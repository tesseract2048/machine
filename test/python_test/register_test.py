#!/usr/bin/python
# -*- coding: utf-8 -*-
"""
 @ for test machine service api: register.
 @ author: li.niu@qunar.com
 @ date: 2015-11-4
"""

import requests
import json
from response_util import *
from func_helper import *

fail_req = "http://localhost:8080/api/v1/machine/register?city=shijiazhuang&deviceId=%22%22&stationInfo=%E5%8C%97%E4%BA%AC%E5%8D%97%E7%AB%99&sequenceNumber=1&provice=%22hubei%22"

suc_req = "http://localhost:8080/api/v1/machine/register?city=shijiazhuang&deviceId=NULL&stationInfo=%E5%8C%97%E4%BA%AC%E5%8D%97%E7%AB%99&sequenceNumber=1&provice=%22hubei%22"

def test_register_Failed():
    r = requests.get(fail_req)
    parse_http_result(get_current_function_name(), r, -1)

def test_register_OK():
    r = requests.get(suc_req)
    parse_http_result(get_current_function_name(), r, 0)


if __name__ == '__main__':
    print "start test register."
    test_register_OK()
    test_register_Failed()


