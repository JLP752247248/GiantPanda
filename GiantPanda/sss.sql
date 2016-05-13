/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : sss

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2016-04-27 19:16:37
*/
 
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptId` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `preDeptId` int(11) DEFAULT NULL,
  PRIMARY KEY (`deptId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('0', '机构', null);
INSERT INTO `dept` VALUES ('1', '办公室', '0');
INSERT INTO `dept` VALUES ('2', '技术部', '0');
INSERT INTO `dept` VALUES ('3', '人事部', '0');
INSERT INTO `dept` VALUES ('4', '外联部', '0');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empId` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `deptId` int(11) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', 'wangmei', '1', '3500', 'm');
INSERT INTO `emp` VALUES ('2', 'lilei', '2', '3600', 'w');
INSERT INTO `emp` VALUES ('3', 'liubei', '1', '4300', 'w');
INSERT INTO `emp` VALUES ('4', 'xiaoli', '2', '3800', 'm');
INSERT INTO `emp` VALUES ('5', 'doushi', '1', '2500', 'm');
INSERT INTO `emp` VALUES ('6', 'wangjin', '3', '5000', 'm');
INSERT INTO `emp` VALUES ('7', 'lianren', '2', '6800', 'w');
INSERT INTO `emp` VALUES ('8', 'fuck', '3', '5000', 'm');
INSERT INTO `emp` VALUES ('9', 'new', '2', '5000', 'm');
INSERT INTO `emp` VALUES ('10', 'hehe', '1', '3000', 'w');
INSERT INTO `emp` VALUES ('11', 'woca', '2', '2000', 'm');
INSERT INTO `emp` VALUES ('12', 'nimei', '3', '4000', 'w');
INSERT INTO `emp` VALUES ('13', 'tiana', '1', '6000', 'm');
INSERT INTO `emp` VALUES ('14', 'youxi', '3', '3800', 'w');
INSERT INTO `emp` VALUES ('15', 'silala', '1', '2900', 'm');

-- ----------------------------
-- Table structure for `sys_fileinfo`
-- ----------------------------
DROP TABLE IF EXISTS `sys_fileinfo`;
CREATE TABLE `sys_fileinfo` (
  `fileId` varchar(20) NOT NULL,
  `fileName` varchar(50) DEFAULT NULL,
  `filePath` varchar(100) DEFAULT NULL,
  `fileSize` double DEFAULT NULL,
  `fileType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_fileinfo
-- ----------------------------

INSERT INTO `sys_userinfo` VALUES ('u1', 'user1', '1234', null);
INSERT INTO `sys_userinfo` VALUES ('u2', 'user2', '123', null);

-- ----------------------------
-- Table structure for `sys_userrole`
-- ----------------------------
DROP TABLE IF EXISTS `sys_userrole`;
CREATE TABLE `sys_userrole` (
  `userroleid` varchar(20) NOT NULL,
  `userid` varchar(20) NOT NULL,
  `roleid` varchar(20) NOT NULL,
  PRIMARY KEY (`userroleid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_userrole
-- ----------------------------
INSERT INTO `sys_userrole` VALUES ('ur1', 'u1', 'r1');
