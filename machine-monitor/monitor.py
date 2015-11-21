#coding:utf-8
import api_client
import time
from math import sqrt

def confidence_upper_bound(ups, downs):
    n = ups + downs
    if n == 0:
        return 0
    z = 1.96
    phat = float(ups) / n
    return ((phat + z*z/(2*n) + z * sqrt((phat*(1-phat)+z*z/(4*n))/n))/(1+z*z/n))

class MachineMonitor:
	def __init__(self, conf):
		self.conf = conf
		self.client = api_client.MachineApiClient(conf)
		self.machine_checklist = map(lambda x: getattr(self, x), self.conf.get('monitor', 'checklist').split(','))

	def print_failure_rate_detector(self, machine):
		total = machine['print_times'] if machine['print_times'] is not None else 0
		if total <= 0:
			return True, None
		success = total - machine['failed_times'] if machine['failed_times'] is not None else 0
		clb = confidence_upper_bound(success, total - success)
		threshold = float(self.conf.get('monitor', 'print_success_rate_threshold'))
		if clb < threshold:
			return False, 'Print success rate lower bound: %s' % clb
		return True, None

        def scan_failure_rate_detector(self, machine):
                total = machine['scan_suc_times'] + machine['scan_failed_times']
		if total <= 0:
			return True, None
                success = machine['scan_suc_times']
                clb = confidence_upper_bound(success, total - success)
                threshold = float(self.conf.get('monitor', 'scan_success_rate_threshold'))
                if clb < threshold:
                        return False, 'Scan sucess rate lower bound: %s' % clb
                return True, None

	def sync_detector(self, machine):
        	now = time.time()
        	heartbeat_elapsed = now - machine['sync_time']/1000
		if heartbeat_elapsed > int(self.conf.get('monitor', 'heartbeat_alarm_threshold')):
			return False, 'Last heartbeat was %s seconds ago' % heartbeat_elapsed
		return True, None

	def emit_alarm(self, machine, results):
		msgs = map(lambda x:x[1], filter(lambda x:not x[0], results))
		msg = ', '.join(msgs)
		# TODO: send alarm
		msg = 'ALARM MSG (DEVICE: %s): %s' % (machine['device_id'], msg)
		self.client.send_alarm(machine['id'], msg)

	def scan(self):
		machines = self.client.list_machines()
		for machine in machines:
			results = map(lambda x:x(machine), self.machine_checklist)
			if not all(map(lambda x:x[0], results)):
				self.emit_alarm(machine, results)
