/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : govaffairs

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2022-06-05 14:13:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `mid` int DEFAULT NULL,
  `uid` int DEFAULT NULL,
  `reply_uid` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comment_uid` (`uid`),
  KEY `comment_reply_uid` (`reply_uid`),
  KEY `comment_mid` (`mid`),
  CONSTRAINT `comment_mid` FOREIGN KEY (`mid`) REFERENCES `mailbox` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_reply_uid` FOREIGN KEY (`reply_uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

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
  `cid` int DEFAULT NULL,
  `dname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `ddescription` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `daddress` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `dphone` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE,
  KEY `department_cid` (`cid`),
  CONSTRAINT `department_cid` FOREIGN KEY (`cid`) REFERENCES `country` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '2', 'bingo', null, null, null);
INSERT INTO `department` VALUES ('2', '2', null, null, null, null);

-- ----------------------------
-- Table structure for deptgovaffairs
-- ----------------------------
DROP TABLE IF EXISTS `deptgovaffairs`;
CREATE TABLE `deptgovaffairs` (
  `GAid` int NOT NULL,
  `did` int NOT NULL,
  PRIMARY KEY (`did`,`GAid`) USING BTREE,
  KEY `deptGAid` (`GAid`) USING BTREE,
  CONSTRAINT `deptGAid` FOREIGN KEY (`GAid`) REFERENCES `govaffairs` (`GAid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `govDid` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of deptgovaffairs
-- ----------------------------

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `fid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `pid` int NOT NULL,
  `fTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fContent` varchar(255) DEFAULT NULL,
  `fReturn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `feedback_uid` (`uid`),
  KEY `feedback_pid` (`pid`),
  CONSTRAINT `feedback_pid` FOREIGN KEY (`pid`) REFERENCES `department` (`did`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `feedback_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', '1', '1', '2020-02-02 15:15:15', 'hahaha', '6y6');
INSERT INTO `feedback` VALUES ('2', '2', '1', '2020-02-02 15:15:16', 'hahaha?', '6y6');
INSERT INTO `feedback` VALUES ('3', '3', '1', '2020-02-03 15:15:17', 'niuwa', '6y6');
INSERT INTO `feedback` VALUES ('4', '4', '1', '2020-02-04 15:15:18', 'en?', '6y6');
INSERT INTO `feedback` VALUES ('5', '5', '1', '2020-02-05 15:15:19', 'sb', '6y6');
INSERT INTO `feedback` VALUES ('6', '6', '1', '2020-02-06 15:15:21', 'gun', '6y6');
INSERT INTO `feedback` VALUES ('7', '7', '1', '2020-02-07 15:15:22', 'pa', '6y6');
INSERT INTO `feedback` VALUES ('8', '8', '1', '2020-02-08 15:15:23', '???', '6y6');

-- ----------------------------
-- Table structure for govaffairneed
-- ----------------------------
DROP TABLE IF EXISTS `govaffairneed`;
CREATE TABLE `govaffairneed` (
  `needGovAffairID` int NOT NULL COMMENT '涓庝箣鍏宠仈鐨凣ovAffairID',
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
-- Table structure for mailbox
-- ----------------------------
DROP TABLE IF EXISTS `mailbox`;
CREATE TABLE `mailbox` (
  `mid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `mailContent` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`mid`) USING BTREE,
  KEY `mailbox_uid` (`uid`) USING BTREE,
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
  `mailboxId` int NOT NULL COMMENT '澶栭敭锛歁ailBoxID',
  `imageBase64` mediumblob COMMENT 'base64褰㈠紡鐩存帴瀛樺偍鍦⊿QL鐨勫浘鐗囨枃浠讹紝涓婇檺16M',
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
  `did` int DEFAULT NULL,
  `pType` int DEFAULT NULL,
  `pContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pAttach` blob,
  `pTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `pPic` blob,
  PRIMARY KEY (`pid`) USING BTREE,
  KEY `publication_did` (`did`),
  CONSTRAINT `publication_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of publication
-- ----------------------------
INSERT INTO `publication` VALUES ('1', '1', '1', 'wrong!', null, '2022-06-05 10:55:47', null);

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
  `uphoto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'asd', '0', '10', 'guess', '6', null);
INSERT INTO `user` VALUES ('2', '2', 'abc', '0', '10', 'you guess', '1', null);
INSERT INTO `user` VALUES ('3', '2', '123', '0', '10', 'you guess', '1', null);
INSERT INTO `user` VALUES ('4', '2', '456', '0', '10', 'you guess', '1', null);
INSERT INTO `user` VALUES ('5', '2', 'qwe', '0', '10', 'you guess', '1', null);
INSERT INTO `user` VALUES ('6', '2', 'rty', '0', '10', 'you guess', '1', null);
INSERT INTO `user` VALUES ('7', '2', 'gbn', '0', '10', 'you guess', '1', null);
INSERT INTO `user` VALUES ('8', '2', '333', '0', '10', 'you guess', '1', null);

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
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
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
