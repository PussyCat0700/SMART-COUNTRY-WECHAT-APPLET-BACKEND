/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : govaffairs

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2022-06-08 19:59:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `application_id` int NOT NULL AUTO_INCREMENT,
  `userGAid` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`application_id`),
  KEY `application_userGAid` (`userGAid`),
  CONSTRAINT `application_userGAid` FOREIGN KEY (`userGAid`) REFERENCES `usergovaffairs` (`userGAid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('1', '4', 'zhb', '1', '8208208820', 'ggggg');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `mid` int DEFAULT NULL,
  `uid` int DEFAULT NULL,
  `reply_uid` int DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  KEY `comment_uid` (`uid`) USING BTREE,
  KEY `comment_reply_uid` (`reply_uid`) USING BTREE,
  KEY `comment_mid` (`mid`) USING BTREE,
  CONSTRAINT `comment_mid` FOREIGN KEY (`mid`) REFERENCES `mailbox` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_reply_uid` FOREIGN KEY (`reply_uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

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
-- Table structure for countryimg
-- ----------------------------
DROP TABLE IF EXISTS `countryimg`;
CREATE TABLE `countryimg` (
  `img_id` int NOT NULL AUTO_INCREMENT,
  `cid` int DEFAULT NULL,
  `Cpic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`img_id`),
  KEY `countryimg_cid` (`cid`),
  CONSTRAINT `countryimg_cid` FOREIGN KEY (`cid`) REFERENCES `country` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of countryimg
-- ----------------------------
INSERT INTO `countryimg` VALUES ('1', '2', '123');
INSERT INTO `countryimg` VALUES ('2', '2', '222');

-- ----------------------------
-- Table structure for create
-- ----------------------------
DROP TABLE IF EXISTS creates;
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
  KEY `department_cid` (`cid`) USING BTREE,
  CONSTRAINT `department_cid` FOREIGN KEY (`cid`) REFERENCES `country` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '2', 'bingo', 'description_did_1', 'Rd. Chuanda', '0832-123456');
INSERT INTO `department` VALUES ('2', '2', null, null, null, null);

-- ----------------------------
-- Table structure for departmentimg
-- ----------------------------
DROP TABLE IF EXISTS `departmentimg`;
CREATE TABLE `departmentimg` (
  `img_id` int NOT NULL AUTO_INCREMENT,
  `did` int DEFAULT NULL,
  `Dpic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`img_id`),
  KEY `departmentimg_did` (`did`),
  CONSTRAINT `departmentimg_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of departmentimg
-- ----------------------------
INSERT INTO `departmentimg` VALUES ('1', '1', '123');
INSERT INTO `departmentimg` VALUES ('2', '1', '22222');

-- ----------------------------
-- Table structure for deptgovaffairs
-- ----------------------------
DROP TABLE IF EXISTS `deptgovaffairs`;
CREATE TABLE `deptgovaffairs` (
  `GAid` int NOT NULL,
  `did` int NOT NULL,
  `deptGovid` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`deptGovid`) USING BTREE,
  KEY `deptGAid` (`GAid`) USING BTREE,
  KEY `deptGAdept` (`did`) USING BTREE,
  CONSTRAINT `deptGAdept` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `deptGAGA` FOREIGN KEY (`GAid`) REFERENCES `govaffairs` (`GAid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of deptgovaffairs
-- ----------------------------
INSERT INTO `deptgovaffairs` VALUES ('1', '1', '1');
INSERT INTO `deptgovaffairs` VALUES ('2', '1', '2');
INSERT INTO `deptgovaffairs` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `fid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `pid` int NOT NULL,
  `fTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `fContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fReturn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`fid`) USING BTREE,
  KEY `feedback_uid` (`uid`) USING BTREE,
  KEY `feedback_pid` (`pid`) USING BTREE,
  CONSTRAINT `feedback_pid` FOREIGN KEY (`pid`) REFERENCES `department` (`did`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `feedback_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

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
  `need_id` int NOT NULL AUTO_INCREMENT,
  `needGovAffairID` int NOT NULL COMMENT '????????????????????????ovAffairID',
  `need` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`need_id`),
  KEY `needGovAffair` (`needGovAffairID`),
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of govaffairs
-- ----------------------------
INSERT INTO `govaffairs` VALUES ('1', '2005-03-18 09:58:31', 'renew your ID card[@material&]ID Card;Social Insurance Card;Driving Licence', 'renew ID Card', '1');
INSERT INTO `govaffairs` VALUES ('2', '2022-06-07 16:48:02', 'renew your ID card[@material&]ID Card;Social Insurance Card;Driving Licence', 'renew ID Card', '0');
INSERT INTO `govaffairs` VALUES ('3', '2022-05-12 16:48:09', '666', '999', '1');

-- ----------------------------
-- Table structure for mailbox
-- ----------------------------
DROP TABLE IF EXISTS `mailbox`;
CREATE TABLE `mailbox` (
  `mid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `mailContent` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `cid` int NOT NULL,
  PRIMARY KEY (`mid`) USING BTREE,
  KEY `mailbox_uid` (`uid`) USING BTREE,
  KEY `mailbox_cid` (`cid`),
  CONSTRAINT `mailbox_cid` FOREIGN KEY (`cid`) REFERENCES `country` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `mailbox_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mailbox
-- ----------------------------
INSERT INTO `mailbox` VALUES ('1', '1', '??', '2');

-- ----------------------------
-- Table structure for mailboximg
-- ----------------------------
DROP TABLE IF EXISTS `mailboximg`;
CREATE TABLE `mailboximg` (
  `img_id` int NOT NULL AUTO_INCREMENT,
  `mailboxId` int NOT NULL COMMENT '???????????????ailBoxID',
  `imageBase64` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'base64?????????????????????????????????QL????????????????????????????????????16M',
  PRIMARY KEY (`img_id`),
  KEY `ImgMailboxID` (`mailboxId`),
  CONSTRAINT `ImgMailboxID` FOREIGN KEY (`mailboxId`) REFERENCES `mailbox` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

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
  `pTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `pTitle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE,
  KEY `publication_did` (`did`) USING BTREE,
  CONSTRAINT `publication_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of publication
-- ----------------------------
INSERT INTO `publication` VALUES ('1', '1', '1', 'wrong!', '2022-06-07 12:14:32', 'amazing!');
INSERT INTO `publication` VALUES ('2', '1', '2', 'true!!!', '2022-06-07 15:59:00', 'unbelievable!');
INSERT INTO `publication` VALUES ('3', '1', '1', '??', '2022-06-08 16:08:41', '!!!');

-- ----------------------------
-- Table structure for publicationattach
-- ----------------------------
DROP TABLE IF EXISTS `publicationattach`;
CREATE TABLE `publicationattach` (
  `attach_id` int NOT NULL AUTO_INCREMENT,
  `pid` int DEFAULT NULL,
  `pAttach` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`attach_id`),
  KEY `attach_pid` (`pid`),
  CONSTRAINT `attach_pid` FOREIGN KEY (`pid`) REFERENCES `publication` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publicationattach
-- ----------------------------
INSERT INTO `publicationattach` VALUES ('1', '1', null);
INSERT INTO `publicationattach` VALUES ('2', '1', null);
INSERT INTO `publicationattach` VALUES ('3', '2', null);
INSERT INTO `publicationattach` VALUES ('4', '3', null);

-- ----------------------------
-- Table structure for publicationpic
-- ----------------------------
DROP TABLE IF EXISTS `publicationpic`;
CREATE TABLE `publicationpic` (
  `img_id` int NOT NULL AUTO_INCREMENT,
  `pid` int DEFAULT NULL,
  `Ppic` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`img_id`),
  KEY `pic_pid` (`pid`),
  CONSTRAINT `pic_pid` FOREIGN KEY (`pid`) REFERENCES `publication` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publicationpic
-- ----------------------------
INSERT INTO `publicationpic` VALUES ('1', '1', null);
INSERT INTO `publicationpic` VALUES ('2', '2', null);
INSERT INTO `publicationpic` VALUES ('3', '3', null);

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
  `uphoto` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `uphone` varchar(255) DEFAULT NULL,
  `ucreate_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'asd', '0', '10', 'guess', '6', null, null, '2022-06-08 18:44:47');
INSERT INTO `user` VALUES ('2', '2', 'abc', '0', '10', 'you guess', '1', null, null, '2022-06-08 18:44:47');
INSERT INTO `user` VALUES ('3', '2', '123', '0', '10', 'you guess', '1', null, null, '2022-06-08 18:44:47');
INSERT INTO `user` VALUES ('4', '2', '456', '0', '10', 'you guess', '1', null, null, '2022-06-08 18:44:47');
INSERT INTO `user` VALUES ('5', '2', 'qwe', '0', '10', 'you guess', '1', null, null, '2022-06-08 18:44:47');
INSERT INTO `user` VALUES ('6', '2', 'rty', '0', '10', 'you guess', '1', null, null, '2022-06-08 18:44:47');
INSERT INTO `user` VALUES ('7', '2', 'gbn', '0', '10', 'you guess', '1', null, null, '2022-06-08 18:44:47');
INSERT INTO `user` VALUES ('8', '2', '333', '0', '10', 'you guess', '1', null, null, '2022-06-08 18:44:47');

-- ----------------------------
-- Table structure for usergovaffairs
-- ----------------------------
DROP TABLE IF EXISTS `usergovaffairs`;
CREATE TABLE `usergovaffairs` (
  `userGAid` int NOT NULL AUTO_INCREMENT,
  `GAid` int NOT NULL,
  `uid` int NOT NULL,
  `did` int DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Appoint_time` datetime DEFAULT NULL,
  `GAName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int DEFAULT NULL,
  `rate` int DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`userGAid`) USING BTREE,
  KEY `GAuid` (`uid`) USING BTREE,
  KEY `userGAGA` (`GAid`) USING BTREE,
  KEY `userGAdid` (`did`),
  CONSTRAINT `userGAdid` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userGAGA` FOREIGN KEY (`GAid`) REFERENCES `govaffairs` (`GAid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userGAuser` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of usergovaffairs
-- ----------------------------
INSERT INTO `usergovaffairs` VALUES ('1', '1', '1', '1', 'hahahaha', '2022-02-02 15:15:15', 'aaaaaa', '0', '0', '', '2022-06-04 17:23:16', 'nothing');
INSERT INTO `usergovaffairs` VALUES ('4', '1', '2', '1', 'asdbgg', '2022-06-04 09:00:00', 'wo budong', '0', '0', '', '2022-06-06 11:55:17', '???');

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
