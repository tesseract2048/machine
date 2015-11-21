#coding: utf-8
import requests
import json

class MachineApiClient:
	def __init__(self, conf):
		self.conf = conf
		self.api_url = conf.get('api', 'url')

	def _request(self, method, uri, params=None):
		m = getattr(requests, method)
		resp = m('%s%s' % (self.api_url, uri), params=params)
		print '%s%s' % (self.api_url, uri)
		resp = json.loads(resp.text)
		if resp['code'] != 0:
			raise Exception('API request failed: %s' % resp['code'])
		return resp['t']

	def list_machines(self):
		return self._request('get', '/admin/Machine')
	
	def send_alarm(self, machine_id, msg):
		return self._request('post', '/machine/alarm', {'machineId': machine_id, 'message': msg})
