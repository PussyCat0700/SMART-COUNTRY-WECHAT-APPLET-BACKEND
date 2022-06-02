/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : govaffairs

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 02/06/2022 22:19:02
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
  `ccode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
  `dphone` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for deptgovaffairs
-- ----------------------------
DROP TABLE IF EXISTS `deptgovaffairs`;
CREATE TABLE `deptgovaffairs`  (
  `GAid` int(11) NOT NULL,
  `did` int(11) NOT NULL,
  PRIMARY KEY (`did`, `GAid`) USING BTREE,
  INDEX `deptGAid`(`GAid`) USING BTREE,
  CONSTRAINT `deptGAid` FOREIGN KEY (`GAid`) REFERENCES `govaffairs` (`GAid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `govDid` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
-- Table structure for govaffairs
-- ----------------------------
DROP TABLE IF EXISTS `govaffairs`;
CREATE TABLE `govaffairs`  (
  `GAid` int(11) NOT NULL AUTO_INCREMENT,
  `GATime` datetime NULL DEFAULT NULL,
  `GADescription` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `GAName` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `isArrival` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`GAid`) USING BTREE,
  INDEX `GASName`(`GAName`) USING BTREE,
  INDEX `GAid`(`GAid`) USING BTREE,
  INDEX `GAid_2`(`GAid`) USING BTREE
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
  `uwxid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT 'alias = uwxopenId\r',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for usergovaffairs
-- ----------------------------
DROP TABLE IF EXISTS `usergovaffairs`;
CREATE TABLE `usergovaffairs`  (
  `GAid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Appoint_time` datetime NULL DEFAULT NULL,
  `GAName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `rate` int(11) NULL DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`GAid`, `uid`) USING BTREE,
  INDEX `GAuid`(`uid`) USING BTREE,
  CONSTRAINT `GAdid` FOREIGN KEY (`GAid`) REFERENCES `govaffairs` (`GAid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `GAuid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
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
