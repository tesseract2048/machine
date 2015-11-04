/*
 Navicat MySQL Data Transfer

 Source Server         : 9localhost
 Source Server Type    : MySQL
 Source Server Version : 50619
 Source Host           : localhost
 Source Database       : qunar

 Target Server Type    : MySQL
 Target Server Version : 50619
 File Encoding         : utf-8

 Date: 11/02/2015 00:50:42 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Machine`
-- ----------------------------
DROP TABLE IF EXISTS `Machine`;
CREATE TABLE `Machine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `machine_print_mode` varchar(16) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `province` varchar(16) DEFAULT NULL,
  `city` varchar(64) DEFAULT NULL,
  `station_info` varchar(64) DEFAULT NULL,
  `login` tinyint(4) DEFAULT '0',
  `group_number` tinyint(4) DEFAULT '0',
  `ticket_mode` varchar(32) DEFAULT NULL,
  `print_times` int(11) DEFAULT '0',
  `suc_times` int(11) DEFAULT '0',
  `failed_times` int(11) DEFAULT '0',
  `paper_number` int(11) DEFAULT '0',
  `paper_used` int(11) DEFAULT '0',
  `user_id` varchar(64) DEFAULT NULL,
  `version` varchar(32) DEFAULT NULL,
  `pass_word` varchar(32) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  `sync_time` datetime DEFAULT NULL,
  `device_id` varchar(128) NOT NULL,
  `sequence_number` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `device_id` (`device_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province` int(11) DEFAULT NULL,
  `city_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `identity_card`
-- ----------------------------
DROP TABLE IF EXISTS `identity_card`;
CREATE TABLE `identity_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` varchar(24) DEFAULT NULL COMMENT '身份证号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `nation` varchar(32) DEFAULT NULL COMMENT '民族',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `address` text COMMENT '地址',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identity_card_idx` (`card_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `machine_info`
-- ----------------------------
DROP TABLE IF EXISTS `machine_info`;
CREATE TABLE `machine_info` (
  `id` int(11) NOT NULL,
  `machine_id` bigint(20) DEFAULT NULL,
  `print_mode` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `province`
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` int(11) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `station`
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `id` int(11) NOT NULL,
  `station_name` varchar(30) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `ticket_print_info`
-- ----------------------------
DROP TABLE IF EXISTS `ticket_print_info`;
CREATE TABLE `ticket_print_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(11) NOT NULL,
  `status` varchar(16) DEFAULT NULL,
  `print_machine_id` varchar(32) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  `print_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ticket_id_idx` (`ticket_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
