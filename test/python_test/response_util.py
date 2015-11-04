#!/usr/bin/python
# -*- coding: utf-8 -*-
"""
 @ for test machine service api: utils.
 @ author: li.niu@qunar.com
 @ date: 2015-11-4
"""

import json

# module for extract http response for machine api
def parse_http_result(func_name, response, code):
    res = response.text
    j_res = json.loads(res)
    if j_res["code"] == code :
        print func_name + ":OK"
    else:
        print func_name + ":Failed"


