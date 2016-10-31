/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-10-13 15:51:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_name` (`account_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'paul', '6f573d39c480ffb5f071d48a4dfab16cb3dbb44b858b9bc3f402aefd51c459101cf5a21888ee90cb', '刘松林');
INSERT INTO `account` VALUES ('7', 'selena', 'f460d0597aec1ff0029301e3956cbdab4ddfba4b007075f0bc19b411ef88de888a00fd7b134f55ca', '谷艳');

-- ----------------------------
-- Table structure for movie_ticket
-- ----------------------------
DROP TABLE IF EXISTS `movie_ticket`;
CREATE TABLE `movie_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movieName` varchar(255) DEFAULT NULL,
  `tickets_count` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie_ticket
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LoginName` varchar(50) NOT NULL COMMENT '用户名',
  `PassWord` varchar(100) NOT NULL COMMENT '密码',
  `UserName` varchar(50) NOT NULL COMMENT '姓名',
  `Phone` varchar(20) DEFAULT NULL,
  `Telephone` varchar(50) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `HeadPath` varchar(50) DEFAULT NULL,
  `TitleName` varchar(50) DEFAULT NULL,
  `Status` int(11) NOT NULL COMMENT '1.启用\r\n2.禁用',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `CreateUser` int(11) NOT NULL COMMENT '创建人',
  `UpdateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `UpdateUser` int(11) DEFAULT NULL,
  `Department` varchar(50) DEFAULT NULL,
  `departmentId` varchar(255) DEFAULT NULL,
  `newpassword` varchar(255) DEFAULT NULL,
  `roleIds` varchar(255) DEFAULT NULL,
  `roleNames` varchar(255) DEFAULT NULL,
  `tenantId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=300 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '698d51a19d8a121ce581499d7b701668', '2sdfa', '15201929988', '021-39277888', '12312313', '123321@qq.com', '/storage\\IA\\hA\\1K-ori.jpg', null, '1', '2014-11-10 00:00:00', '0', '2014-11-10 00:00:00', null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('299', 'kermit', '698d51a19d8a121ce581499d7b701668', 'asddf', '11111111111', null, '6518546', 'test@mail.com', null, null, '1', '2015-10-14 14:31:24', '1', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ticketId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'paul', null);
