/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : govaffairs

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2022-06-04 22:36:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `score` decimal(10,0) DEFAULT NULL,
  `location` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `cname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `ccode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('2', '1', 'nj', 'dxq', null);
INSERT INTO `country` VALUES ('3', null, null, null, null);
INSERT INTO `country` VALUES ('4', null, null, null, null);
INSERT INTO `country` VALUES ('5', null, null, null, null);
INSERT INTO `country` VALUES ('6', null, null, null, null);
INSERT INTO `country` VALUES ('7', null, null, null, null);
INSERT INTO `country` VALUES ('8', '1', null, null, null);
INSERT INTO `country` VALUES ('9', '1', null, null, null);
INSERT INTO `country` VALUES ('10', '1', 'nj', 'dxq', null);
INSERT INTO `country` VALUES ('11', null, null, null, null);
INSERT INTO `country` VALUES ('12', '1', 'nj', 'dxq', null);
INSERT INTO `country` VALUES ('13', '1', 'nj', 'dxq', null);
INSERT INTO `country` VALUES ('14', '1', 'nj', 'dxq', null);
INSERT INTO `country` VALUES ('15', '1', 'nj', 'dxq', null);
INSERT INTO `country` VALUES ('16', null, null, null, null);
INSERT INTO `country` VALUES ('17', '10', null, null, null);

-- ----------------------------
-- Table structure for countrydepartment
-- ----------------------------
DROP TABLE IF EXISTS `countrydepartment`;
CREATE TABLE `countrydepartment` (
  `did` int NOT NULL,
  `cid` int NOT NULL,
  PRIMARY KEY (`did`,`cid`) USING BTREE,
  KEY `countryd_cid` (`cid`) USING BTREE,
  CONSTRAINT `countryd_cid` FOREIGN KEY (`cid`) REFERENCES `country` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `countryd_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of countrydepartment
-- ----------------------------
INSERT INTO `countrydepartment` VALUES ('1', '2');
INSERT INTO `countrydepartment` VALUES ('2', '2');

-- ----------------------------
-- Table structure for create
-- ----------------------------
DROP TABLE IF EXISTS `create`;
CREATE TABLE `create` (
  `uid` int NOT NULL,
  `cid` int NOT NULL,
  PRIMARY KEY (`uid`,`cid`) USING BTREE,
  KEY `cid` (`cid`) USING BTREE,
  CONSTRAINT `cid` FOREIGN KEY (`cid`) REFERENCES `country` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of create
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `did` int NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `ddescription` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `daddress` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `dphone` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'bingo', null, null, null);
INSERT INTO `department` VALUES ('2', null, null, null, null);

-- ----------------------------
-- Table structure for deptgovaffairsarrival
-- ----------------------------
DROP TABLE IF EXISTS `deptgovaffairsarrival`;
CREATE TABLE `deptgovaffairsarrival` (
  `GAAid` int NOT NULL,
  `did` int NOT NULL,
  PRIMARY KEY (`did`,`GAAid`) USING BTREE,
  KEY `govGASid` (`GAAid`) USING BTREE,
  CONSTRAINT `govDid` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `govGASid` FOREIGN KEY (`GAAid`) REFERENCES `govaffairsarrival` (`GAAid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of deptgovaffairsarrival
-- ----------------------------

-- ----------------------------
-- Table structure for deptgovaffairsspot
-- ----------------------------
DROP TABLE IF EXISTS `deptgovaffairsspot`;
CREATE TABLE `deptgovaffairsspot` (
  `GASid` int NOT NULL,
  `did` int NOT NULL,
  PRIMARY KEY (`GASid`,`did`) USING BTREE,
  KEY `deptspot_did` (`did`) USING BTREE,
  CONSTRAINT `deptspot_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `deptspot_GASid` FOREIGN KEY (`GASid`) REFERENCES `govaffairsspot` (`GASid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of deptgovaffairsspot
-- ----------------------------

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `uid` int NOT NULL,
  `pid` int NOT NULL,
  `fTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fReturn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`uid`,`pid`) USING BTREE,
  KEY `feedback_pid` (`pid`) USING BTREE,
  CONSTRAINT `feedback_pid` FOREIGN KEY (`pid`) REFERENCES `publication` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `feedback_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', '1', '2022-06-04 19:00:28', 'very good', '');
INSERT INTO `feedback` VALUES ('2', '1', '2022-02-02 15:15:15', 'abc!!!', '?');
INSERT INTO `feedback` VALUES ('3', '1', '2022-02-02 15:15:15', 'tav!!!', '?');
INSERT INTO `feedback` VALUES ('4', '1', '2022-02-02 15:15:15', 'dvcs!!!', '?');
INSERT INTO `feedback` VALUES ('5', '1', '2022-02-02 15:15:15', 'true!!!', '?');
INSERT INTO `feedback` VALUES ('6', '1', '2022-02-02 15:15:15', 'false!!!', '?');
INSERT INTO `feedback` VALUES ('7', '1', '2022-02-02 15:15:15', 'yes!!!', '?');
INSERT INTO `feedback` VALUES ('8', '1', '2022-02-02 15:15:15', 'nice!!!', '?');

-- ----------------------------
-- Table structure for govaffairneed
-- ----------------------------
DROP TABLE IF EXISTS `govaffairneed`;
CREATE TABLE `govaffairneed` (
  `needGovAffairID` int NOT NULL COMMENT '与之关联的GovAffairID',
  `need` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`needGovAffairID`) USING BTREE,
  CONSTRAINT `needGovAffair` FOREIGN KEY (`needGovAffairID`) REFERENCES `govaffairs` (`GAid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of govaffairneed
-- ----------------------------

-- ----------------------------
-- Table structure for govaffairs
-- ----------------------------
DROP TABLE IF EXISTS `govaffairs`;
CREATE TABLE `govaffairs` (
  `GAid` int NOT NULL AUTO_INCREMENT,
  `GATime` datetime DEFAULT NULL,
  `GADescription` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `GAName` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `isArrival` tinyint DEFAULT NULL,
  PRIMARY KEY (`GAid`) USING BTREE,
  KEY `GASName` (`GAName`) USING BTREE,
  KEY `GAid` (`GAid`) USING BTREE,
  KEY `GAid_2` (`GAid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of govaffairs
-- ----------------------------
INSERT INTO `govaffairs` VALUES ('1', '2022-06-04 17:04:08', 'ads', 'zhdt', '1');

-- ----------------------------
-- Table structure for govaffairsarrival
-- ----------------------------
DROP TABLE IF EXISTS `govaffairsarrival`;
CREATE TABLE `govaffairsarrival` (
  `GAAid` int NOT NULL AUTO_INCREMENT,
  `GAATime` datetime DEFAULT NULL,
  `GAADescription` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`GAAid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of govaffairsarrival
-- ----------------------------

-- ----------------------------
-- Table structure for govaffairsspot
-- ----------------------------
DROP TABLE IF EXISTS `govaffairsspot`;
CREATE TABLE `govaffairsspot` (
  `GASid` int NOT NULL AUTO_INCREMENT,
  `GASTime` datetime DEFAULT NULL,
  `GASDescription` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`GASid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of govaffairsspot
-- ----------------------------

-- ----------------------------
-- Table structure for mailbox
-- ----------------------------
DROP TABLE IF EXISTS `mailbox`;
CREATE TABLE `mailbox` (
  `mid` int NOT NULL,
  `did` int NOT NULL,
  `uid` int NOT NULL,
  `mailContent` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`mid`) USING BTREE,
  KEY `mailbox_uid` (`uid`) USING BTREE,
  KEY `mailbox_did` (`did`) USING BTREE,
  CONSTRAINT `mailbox_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `mailbox_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mailbox
-- ----------------------------

-- ----------------------------
-- Table structure for mailboximg
-- ----------------------------
DROP TABLE IF EXISTS `mailboximg`;
CREATE TABLE `mailboximg` (
  `mailboxId` int NOT NULL COMMENT '外键：MailBoxID',
  `imageBase64` mediumblob COMMENT 'base64形式直接存储在SQL的图片文件，上限16M',
  PRIMARY KEY (`mailboxId`) USING BTREE,
  CONSTRAINT `ImgMailboxID` FOREIGN KEY (`mailboxId`) REFERENCES `mailbox` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mailboximg
-- ----------------------------

-- ----------------------------
-- Table structure for publication
-- ----------------------------
DROP TABLE IF EXISTS `publication`;
CREATE TABLE `publication` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `pType` int DEFAULT NULL,
  `pContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pAttach` blob,
  `pTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `pPic` blob,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of publication
-- ----------------------------
INSERT INTO `publication` VALUES ('1', '1', 'wrong!', null, '2020-02-02 14:14:14', null);

-- ----------------------------
-- Table structure for publish
-- ----------------------------
DROP TABLE IF EXISTS `publish`;
CREATE TABLE `publish` (
  `pid` int NOT NULL,
  `did` int NOT NULL,
  PRIMARY KEY (`pid`,`did`) USING BTREE,
  KEY `publish_pid` (`pid`) USING BTREE,
  KEY `publish_did` (`did`) USING BTREE,
  CONSTRAINT `publish_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `publish_pid` FOREIGN KEY (`pid`) REFERENCES `publication` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of publish
-- ----------------------------

-- ----------------------------
-- Table structure for resident
-- ----------------------------
DROP TABLE IF EXISTS `resident`;
CREATE TABLE `resident` (
  `uid` int NOT NULL,
  `cid` int NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  KEY `cid` (`cid`) USING BTREE,
  CONSTRAINT `resident_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `country` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `resident_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of resident
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `status` int DEFAULT NULL,
  `uname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `ugender` int DEFAULT NULL,
  `uage` int DEFAULT NULL,
  `uaddress` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `uwxid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT 'alias = uwxopenId\r',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'asd', '0', '10', 'guess', '6');
INSERT INTO `user` VALUES ('2', '2', 'abc', '0', '10', 'you guess', '1');
INSERT INTO `user` VALUES ('3', '2', '123', '0', '10', 'you guess', '1');
INSERT INTO `user` VALUES ('4', '2', '456', '0', '10', 'you guess', '1');
INSERT INTO `user` VALUES ('5', '2', 'qwe', '0', '10', 'you guess', '1');
INSERT INTO `user` VALUES ('6', '2', 'rty', '0', '10', 'you guess', '1');
INSERT INTO `user` VALUES ('7', '2', 'gbn', '0', '10', 'you guess', '1');
INSERT INTO `user` VALUES ('8', '2', '333', '0', '10', 'you guess', '1');

-- ----------------------------
-- Table structure for usergovaffairs
-- ----------------------------
DROP TABLE IF EXISTS `usergovaffairs`;
CREATE TABLE `usergovaffairs` (
  `GAid` int NOT NULL,
  `uid` int NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Appoint_time` datetime DEFAULT NULL,
  `GAName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int DEFAULT NULL,
  `rate` int DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`GAid`,`uid`) USING BTREE,
  KEY `GAuid` (`uid`) USING BTREE,
  CONSTRAINT `GAdid` FOREIGN KEY (`GAid`) REFERENCES `govaffairs` (`GAid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `GAuid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of usergovaffairs
-- ----------------------------
INSERT INTO `usergovaffairs` VALUES ('1', '1', 'hahahaha', '2022-02-02 15:15:15', 'aaaaaa', '0', '0', '', '2022-06-04 17:23:16', 'nothing');

-- ----------------------------
-- Table structure for usergovaffairsarrival
-- ----------------------------
DROP TABLE IF EXISTS `usergovaffairsarrival`;
CREATE TABLE `usergovaffairsarrival` (
  `GAAid` int NOT NULL,
  `uid` int NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Appoint_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`GAAid`,`uid`) USING BTREE,
  KEY `GAAuid` (`uid`) USING BTREE,
  CONSTRAINT `gaaid` FOREIGN KEY (`GAAid`) REFERENCES `govaffairsarrival` (`GAAid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `GAAuid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of usergovaffairsarrival
-- ----------------------------

-- ----------------------------
-- Table structure for usergovaffairsspot
-- ----------------------------
DROP TABLE IF EXISTS `usergovaffairsspot`;
CREATE TABLE `usergovaffairsspot` (
  `GASid` int NOT NULL,
  `uid` int NOT NULL,
  `Appoint_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`GASid`,`uid`) USING BTREE,
  KEY `uGASuid` (`uid`) USING BTREE,
  CONSTRAINT `uGASid` FOREIGN KEY (`GASid`) REFERENCES `govaffairsarrival` (`GAAid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uGASuid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of usergovaffairsspot
-- ----------------------------

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work` (
  `did` int NOT NULL,
  `uid` int NOT NULL,
  `wname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `wtime` datetime DEFAULT NULL,
  PRIMARY KEY (`did`,`uid`) USING BTREE,
  KEY `workuid` (`uid`) USING BTREE,
  CONSTRAINT `workdid` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `workuid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of work
-- ----------------------------
