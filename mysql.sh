

DROP TABLE IF EXISTS `machine`;
CREATE TABLE `machine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `machine_id` varchar(128) NOT NULL,
  `machine_id_md5` varchar(32) NOT NULL,
  `machine_print_mode` varchar(16) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `province` varchar(16) DEFAULT NULL,
  `city` varchar(64) DEFAULT NULL,
  `station_info` varchar(64) DEFAULT NULL,
  `login` tinyint DEFAULT 0,
  `group_number` tinyint DEFAULT 0,
  `ticket_mode` varchar(32) DEFAULT NULL,
  `print_times` int(11) DEFAULT 0,
  `suc_times` int(11) DEFAULT 0,
  `failed_times` int(11) DEFAULT 0,
  `paper_number` int(11) DEFAULT 0,
  `paper_used` int(11) DEFAULT 0,
  `user_id` varchar(64) DEFAULT NULL,
  `version` varchar(32) DEFAULT NULL,
  `pass_word` varchar(32) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `machine_idx` (`machine_id_md5`),
  KEY `machineId_idx` (`machine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `machine_version`;
CREATE TABLE `machine_version` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `version` varchar(32) DEFAULT NULL,
 `new_version` varchar(32) DEFAULT NULL
 `machine_id` varchar(128) NOT NULL,
 `machine_id_md5` varchar(32) NOT NULL,
  KEY `machine_version_dx` (`machine_id_md5`),
  KEY `version_idx` (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_id` varchar(128) NOT NULL,
  `ticket_print_mode` varchar(32) DEFAULT NULL,
  `ticket_status` varchar(16) DEFAULT NULL,
  `ticket_type` varchar(32) DEFAULT NULL  COMMENT '客票类型，如全票，儿童票',
  `id_card_number` varchar(24) DEFAULT NULL COMMENT '身份证号',
  `fetch_ticket_id` varchar(16) DEFAULT NULL COMMENT '取票号',
  `fetch_ticket_key` varchar(16) DEFAULT NULL COMMENT '取票密码',
  `dep_city` varchar(64) DEFAULT NULL,
  `arr_city` varchar(64) DEFAULT NULL,
  `dep_station` varchar(64) DEFAULT NULL,
  `arr_station` varchar(64) DEFAULT NULL,

  `route_number` varchar(20) DEFAULT NULL COMMENT '车次',
  `dep_date` datetime DEFAULT NULL COMMENT '出发日期',
  `arr_date` datetime DEFAULT NULL COMMENT '到达日期',
  `dep_time` varchar(5) DEFAULT NULL COMMENT '出发时间',
  `arr_time` varchar(5) DEFAULT NULL COMMENT '到达时间',
  `price`   decimal(8,1) DEFAULT NULL COMMENT '执行票价',
  `max_price` decimal(8,1) DEFAULT NULL COMMENT '票价上限',
  `seat_number` varchar(6) DEFAULT NULL COMMENT '座位号',
  `seat_type` varchar(12) DEFAULT NULL COMMENT '座位类型，如一等座位',
  `coach_type` varchar(16) DEFAULT NULL COMMENT '车类型，如普通中巴',
  `mileage` double DEFAULT NULL COMMENT '里程',
  `ticket_machine_id` varchar(32) DEFAULT NULL,
  `travel_time` smallint(6) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ticket_id_idx` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `identity_card`;
CREATE TABLE `identity_card`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` VARCHAR(24) DEFAULT NULL COMMENT '身份证号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',   
  `nation` varchar(32) DEFAULT NULL COMMENT '民族',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `address` text DEFAULT NULL COMMENT '地址',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `identity_card_idx` (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;








