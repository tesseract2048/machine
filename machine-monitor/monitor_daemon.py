#coding:utf-8
from conf import get_conf
import monitor
import sched
import time

def run_monitor(conf):
        monitor.MachineMonitor(conf).scan()

if __name__ == '__main__':
	conf = get_conf('monitor.conf')
	scheduler = sched.scheduler(time.time, time.sleep)
	scan_interval = int(conf.get('monitor', 'scan_interval'))
	def monitor_action():
		scheduler.enterabs(time.time() + scan_interval, 0, monitor_action, ())
		run_monitor(conf)
	monitor_action()
	scheduler.run()
