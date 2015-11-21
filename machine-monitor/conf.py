#coding: utf-8
import ConfigParser

def get_conf(filename):
	parser = ConfigParser.ConfigParser()
	parser.read(filename)
	return parser

