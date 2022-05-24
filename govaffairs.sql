/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : govaffairs

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 24/05/2022 17:58:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `score` decimal(10, 0) NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `cname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for countrydepartment
-- ----------------------------
DROP TABLE IF EXISTS `countrydepartment`;
CREATE TABLE `countrydepartment`  (
  `did` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`did`, `cid`) USING BTREE,
  INDEX `countryd_cid`(`cid`) USING BTREE,
  CONSTRAINT `countryd_cid` FOREIGN KEY (`cid`) REFERENCES `country` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `countryd_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for create
-- ----------------------------
DROP TABLE IF EXISTS `create`;
CREATE TABLE `create`  (
  `uid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`uid`, `cid`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `cid` FOREIGN KEY (`cid`) REFERENCES `country` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `ddescription` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `daddress` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for deptgovaffairsarrival
-- ----------------------------
DROP TABLE IF EXISTS `deptgovaffairsarrival`;
CREATE TABLE `deptgovaffairsarrival`  (
  `GAAid` int(11) NOT NULL,
  `did` int(11) NOT NULL,
  PRIMARY KEY (`did`, `GAAid`) USING BTREE,
  INDEX `govGASid`(`GAAid`) USING BTREE,
  CONSTRAINT `govDid` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `govGASid` FOREIGN KEY (`GAAid`) REFERENCES `govaffairsarrival` (`GAAid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for deptgovaffairsspot
-- ----------------------------
DROP TABLE IF EXISTS `deptgovaffairsspot`;
CREATE TABLE `deptgovaffairsspot`  (
  `GASid` int(11) NOT NULL,
  `did` int(11) NOT NULL,
  PRIMARY KEY (`GASid`, `did`) USING BTREE,
  INDEX `deptspot_did`(`did`) USING BTREE,
  CONSTRAINT `deptspot_GASid` FOREIGN KEY (`GASid`) REFERENCES `govaffairsspot` (`GASid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `deptspot_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `fTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `fContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fReturn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`, `pid`) USING BTREE,
  INDEX `feedback_pid`(`pid`) USING BTREE,
  CONSTRAINT `feedback_pid` FOREIGN KEY (`pid`) REFERENCES `publication` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `feedback_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for govaffairsarrival
-- ----------------------------
DROP TABLE IF EXISTS `govaffairsarrival`;
CREATE TABLE `govaffairsarrival`  (
  `GAAid` int(11) NOT NULL AUTO_INCREMENT,
  `GAATime` datetime NULL DEFAULT NULL,
  `GAADescription` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`GAAid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for govaffairsspot
-- ----------------------------
DROP TABLE IF EXISTS `govaffairsspot`;
CREATE TABLE `govaffairsspot`  (
  `GASid` int(11) NOT NULL AUTO_INCREMENT,
  `GASTime` datetime NULL DEFAULT NULL,
  `GASDescription` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`GASid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mailbox
-- ----------------------------
DROP TABLE IF EXISTS `mailbox`;
CREATE TABLE `mailbox`  (
  `mid` int(11) NOT NULL,
  `did` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `mailContent` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`mid`) USING BTREE,
  INDEX `mailbox_uid`(`uid`) USING BTREE,
  INDEX `mailbox_did`(`did`) USING BTREE,
  CONSTRAINT `mailbox_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `mailbox_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for publication
-- ----------------------------
DROP TABLE IF EXISTS `publication`;
CREATE TABLE `publication`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pType` int(11) NULL DEFAULT NULL,
  `pContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pAttach` blob NULL,
  `pTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `pPic` blob NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for publish
-- ----------------------------
DROP TABLE IF EXISTS `publish`;
CREATE TABLE `publish`  (
  `pid` int(11) NOT NULL,
  `did` int(11) NOT NULL,
  PRIMARY KEY (`pid`, `did`) USING BTREE,
  INDEX `publish_pid`(`pid`) USING BTREE,
  INDEX `publish_did`(`did`) USING BTREE,
  CONSTRAINT `publish_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `publish_pid` FOREIGN KEY (`pid`) REFERENCES `publication` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resident
-- ----------------------------
DROP TABLE IF EXISTS `resident`;
CREATE TABLE `resident`  (
  `uid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `resident_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `country` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `resident_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) NULL DEFAULT NULL,
  `uname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `ugender` int(11) NULL DEFAULT NULL,
  `uage` int(11) NULL DEFAULT NULL,
  `uaddress` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `uwxid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for usergovaffairsarrival
-- ----------------------------
DROP TABLE IF EXISTS `usergovaffairsarrival`;
CREATE TABLE `usergovaffairsarrival`  (
  `GAAid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Appoint_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`GAAid`, `uid`) USING BTREE,
  INDEX `GAAuid`(`uid`) USING BTREE,
  CONSTRAINT `GAAuid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `gaaid` FOREIGN KEY (`GAAid`) REFERENCES `govaffairsarrival` (`GAAid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for usergovaffairsspot
-- ----------------------------
DROP TABLE IF EXISTS `usergovaffairsspot`;
CREATE TABLE `usergovaffairsspot`  (
  `GASid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `Appoint_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`GASid`, `uid`) USING BTREE,
  INDEX `uGASuid`(`uid`) USING BTREE,
  CONSTRAINT `uGASid` FOREIGN KEY (`GASid`) REFERENCES `govaffairsarrival` (`GAAid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uGASuid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work`  (
  `did` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `wname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `wtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`did`, `uid`) USING BTREE,
  INDEX `workuid`(`uid`) USING BTREE,
  CONSTRAINT `workdid` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `workuid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
