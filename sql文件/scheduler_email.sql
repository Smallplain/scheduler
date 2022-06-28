/*
Navicat MySQL Data Transfer

Source Server         : 139.224.36.30
Source Server Version : 50738
Source Host           : 139.224.36.30:3306
Source Database       : scheduler_email

Target Server Type    : MYSQL
Target Server Version : 50738
File Encoding         : 65001

Date: 2022-06-28 19:04:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for email_info
-- ----------------------------
DROP TABLE IF EXISTS `email_info`;
CREATE TABLE `email_info` (
  `email_id` int(11) NOT NULL AUTO_INCREMENT,
  `email_type` varchar(32) DEFAULT NULL,
  `email_name` varchar(255) DEFAULT NULL,
  `email_content` varchar(255) DEFAULT NULL,
  `emai_title` varchar(255) DEFAULT NULL COMMENT 'EMAIL_QQ，EMAIL_163',
  `sender_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0：发送中 1：发送成功 2：发送失败',
  `is_deleted` tinyint(4) DEFAULT '0',
  `email_send_time` datetime DEFAULT NULL COMMENT '邮件送达时间',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`email_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` int(11) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `salt` varchar(32) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `is_disable` tinyint(4) DEFAULT NULL,
  `is_deleted` tinyint(4) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
