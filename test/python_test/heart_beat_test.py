#!/usr/bin/python
# -*- coding: utf-8 -*-
"""
 @ for test machine service api: heartbeat.
 @ author: li.niu@qunar.com
 @ date: 2015-11-4
"""

import requests
import json
from response_util import *
from func_helper import *

suc_req = "http://localhost:8080/api/v1/machine/heartbeat?deviceId=03d87317b572447a75707e829b64ca1f"


def test_heart_beat_OK():
    r = requests.get(suc_req)
    parse_http_result(get_current_function_name(), r, 0)


if __name__ == '__main__':
    print "start test heartbeat."
    test_heart_beat_OK()


