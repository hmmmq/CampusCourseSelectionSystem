create schema `xuanke`;
/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : xuanke

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2018-11-11 16:30:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPw` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'a');
INSERT INTO `admin` VALUES ('2', 'leo', '123456');
INSERT INTO `admin` VALUES ('3', 'admin1', '123456');
INSERT INTO `admin` VALUES ('20', 'admin2', '1');

-- ----------------------------
-- Table structure for `kebiao`
-- ----------------------------
DROP TABLE IF EXISTS `kebiao`;
CREATE TABLE `kebiao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kecheng_id` int(11) DEFAULT NULL,
  `shijian` varchar(255) DEFAULT NULL,
  `jieci` varchar(255) DEFAULT NULL,
  `jiaoshi` varchar(255) DEFAULT NULL,
  `laoshi_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kebiao
-- ----------------------------
INSERT INTO `kebiao` VALUES ('1', '1', '星期一', '1-2节', '多媒体教室1', '1');
INSERT INTO `kebiao` VALUES ('2', '3', '星期一', '5-6节', '多媒体教室3', '1');

-- ----------------------------
-- Table structure for `kecheng`
-- ----------------------------
DROP TABLE IF EXISTS `kecheng`;
CREATE TABLE `kecheng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(255) DEFAULT NULL,
  `mingcheng` varchar(255) DEFAULT NULL,
  `keshi` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kecheng
-- ----------------------------
INSERT INTO `kecheng` VALUES ('1', 'J001', '零基础学Java', '48', null);
INSERT INTO `kecheng` VALUES ('2', 'J002', 'Java Web项目开发入门', '50', null);
INSERT INTO `kecheng` VALUES ('3', 'L001', 'Linux入门学习', '40', null);

-- ----------------------------
-- Table structure for `laoshi`
-- ----------------------------
DROP TABLE IF EXISTS `laoshi`;
CREATE TABLE `laoshi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(255) DEFAULT NULL,
  `xingming` varchar(255) DEFAULT NULL,
  `xingbie` varchar(255) DEFAULT NULL,
  `nianling` varchar(255) DEFAULT NULL,
  `zhicheng` varchar(255) DEFAULT NULL,
  `loginname` varchar(255) DEFAULT NULL,
  `loginpw` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of laoshi
-- ----------------------------
INSERT INTO `laoshi` VALUES ('1', 'T00001', '张一', '男', '45', '教授', 'T00001', 'a', null);
INSERT INTO `laoshi` VALUES ('2', 'T00002', '张二', '女', '36', '硕士', 'T00002', 'a', null);

-- ----------------------------
-- Table structure for `xuekebiao`
-- ----------------------------
DROP TABLE IF EXISTS `xuekebiao`;
CREATE TABLE `xuekebiao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `xuesheng_id` int(11) DEFAULT NULL,
  `kebiao_id` int(11) DEFAULT NULL,
  `kebiao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKxfned866lrtn451smsefuta1` (`kebiao`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xuekebiao
-- ----------------------------
INSERT INTO `xuekebiao` VALUES ('1', '1', '1', null);
INSERT INTO `xuekebiao` VALUES ('2', '1', '2', null);
INSERT INTO `xuekebiao` VALUES ('3', '2', '2', null);

-- ----------------------------
-- Table structure for `xuesheng`
-- ----------------------------
DROP TABLE IF EXISTS `xuesheng`;
CREATE TABLE `xuesheng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `xuehao` varchar(255) DEFAULT NULL,
  `xingming` varchar(255) DEFAULT NULL,
  `xingbie` varchar(255) DEFAULT NULL,
  `nianling` varchar(255) DEFAULT NULL,
  `banji` varchar(255) DEFAULT NULL,
  `loginname` varchar(255) DEFAULT NULL,
  `loginpw` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xuesheng
-- ----------------------------
INSERT INTO `xuesheng` VALUES ('1', 'S00001', '李一', '男', '19', '130804', 'S00001', 'a', null);
INSERT INTO `xuesheng` VALUES ('2', 'S00002', '李二', '女', '18', '130804', 'S00002', 'a', null);
