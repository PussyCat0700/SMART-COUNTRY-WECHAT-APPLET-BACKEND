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

 Date: 05/06/2022 15:47:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `reply_uid` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `comment_uid`(`uid`) USING BTREE,
  INDEX `comment_reply_uid`(`reply_uid`) USING BTREE,
  INDEX `comment_mid`(`mid`) USING BTREE,
  CONSTRAINT `comment_mid` FOREIGN KEY (`mid`) REFERENCES `mailbox` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_reply_uid` FOREIGN KEY (`reply_uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (2, 1, 'nj', 'dxq', NULL);
INSERT INTO `country` VALUES (3, NULL, NULL, NULL, NULL);
INSERT INTO `country` VALUES (4, NULL, NULL, NULL, NULL);
INSERT INTO `country` VALUES (5, NULL, NULL, NULL, NULL);
INSERT INTO `country` VALUES (6, NULL, NULL, NULL, NULL);
INSERT INTO `country` VALUES (7, NULL, NULL, NULL, NULL);
INSERT INTO `country` VALUES (8, 1, NULL, NULL, NULL);
INSERT INTO `country` VALUES (9, 1, NULL, NULL, NULL);
INSERT INTO `country` VALUES (10, 1, 'nj', 'dxq', NULL);
INSERT INTO `country` VALUES (11, NULL, NULL, NULL, NULL);
INSERT INTO `country` VALUES (12, 1, 'nj', 'dxq', NULL);
INSERT INTO `country` VALUES (13, 1, 'nj', 'dxq', NULL);
INSERT INTO `country` VALUES (14, 1, 'nj', 'dxq', NULL);
INSERT INTO `country` VALUES (15, 1, 'nj', 'dxq', NULL);
INSERT INTO `country` VALUES (16, NULL, NULL, NULL, NULL);
INSERT INTO `country` VALUES (17, 10, NULL, NULL, NULL);

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of countrydepartment
-- ----------------------------
INSERT INTO `countrydepartment` VALUES (1, 2);
INSERT INTO `countrydepartment` VALUES (2, 2);

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
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of create
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NULL DEFAULT NULL,
  `dname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `ddescription` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `daddress` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `dphone` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE,
  INDEX `department_cid`(`cid`) USING BTREE,
  CONSTRAINT `department_cid` FOREIGN KEY (`cid`) REFERENCES `country` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, 2, 'bingo', NULL, NULL, NULL);
INSERT INTO `department` VALUES (2, 2, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for deptgovaffairs
-- ----------------------------
DROP TABLE IF EXISTS `deptgovaffairs`;
CREATE TABLE `deptgovaffairs`  (
  `GAid` int(11) NOT NULL,
  `did` int(11) NOT NULL,
  `deptGovid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`deptGovid`) USING BTREE,
  INDEX `deptGAid`(`GAid`) USING BTREE,
  INDEX `deptGAdept`(`did`) USING BTREE,
  CONSTRAINT `deptGAGA` FOREIGN KEY (`GAid`) REFERENCES `govaffairs` (`GAid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `deptGAdept` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of deptgovaffairs
-- ----------------------------

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `fTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fReturn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`fid`) USING BTREE,
  INDEX `feedback_uid`(`uid`) USING BTREE,
  INDEX `feedback_pid`(`pid`) USING BTREE,
  CONSTRAINT `feedback_pid` FOREIGN KEY (`pid`) REFERENCES `department` (`did`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `feedback_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (1, 1, 1, '2020-02-02 15:15:15', 'hahaha', '6y6');
INSERT INTO `feedback` VALUES (2, 2, 1, '2020-02-02 15:15:16', 'hahaha?', '6y6');
INSERT INTO `feedback` VALUES (3, 3, 1, '2020-02-03 15:15:17', 'niuwa', '6y6');
INSERT INTO `feedback` VALUES (4, 4, 1, '2020-02-04 15:15:18', 'en?', '6y6');
INSERT INTO `feedback` VALUES (5, 5, 1, '2020-02-05 15:15:19', 'sb', '6y6');
INSERT INTO `feedback` VALUES (6, 6, 1, '2020-02-06 15:15:21', 'gun', '6y6');
INSERT INTO `feedback` VALUES (7, 7, 1, '2020-02-07 15:15:22', 'pa', '6y6');
INSERT INTO `feedback` VALUES (8, 8, 1, '2020-02-08 15:15:23', '???', '6y6');

-- ----------------------------
-- Table structure for govaffairneed
-- ----------------------------
DROP TABLE IF EXISTS `govaffairneed`;
CREATE TABLE `govaffairneed`  (
  `needGovAffairID` int(11) NOT NULL COMMENT '涓庝箣鍏宠仈鐨凣ovAffairID',
  `need` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`needGovAffairID`) USING BTREE,
  CONSTRAINT `needGovAffair` FOREIGN KEY (`needGovAffairID`) REFERENCES `govaffairs` (`GAid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of govaffairneed
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of govaffairs
-- ----------------------------
INSERT INTO `govaffairs` VALUES (1, '2005-03-18 09:58:31', 'ads', 'zhdt', 1);

-- ----------------------------
-- Table structure for mailbox
-- ----------------------------
DROP TABLE IF EXISTS `mailbox`;
CREATE TABLE `mailbox`  (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `mailContent` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`mid`) USING BTREE,
  INDEX `mailbox_uid`(`uid`) USING BTREE,
  CONSTRAINT `mailbox_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mailbox
-- ----------------------------

-- ----------------------------
-- Table structure for mailboximg
-- ----------------------------
DROP TABLE IF EXISTS `mailboximg`;
CREATE TABLE `mailboximg`  (
  `mailboxId` int(11) NOT NULL COMMENT '澶栭敭锛歁ailBoxID',
  `imageBase64` mediumblob NULL COMMENT 'base64褰㈠紡鐩存帴瀛樺偍鍦⊿QL鐨勫浘鐗囨枃浠讹紝涓婇檺16M',
  PRIMARY KEY (`mailboxId`) USING BTREE,
  CONSTRAINT `ImgMailboxID` FOREIGN KEY (`mailboxId`) REFERENCES `mailbox` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mailboximg
-- ----------------------------

-- ----------------------------
-- Table structure for publication
-- ----------------------------
DROP TABLE IF EXISTS `publication`;
CREATE TABLE `publication`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) NULL DEFAULT NULL,
  `pType` int(11) NULL DEFAULT NULL,
  `pContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pAttach` blob NULL,
  `pTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `pPic` blob NULL,
  PRIMARY KEY (`pid`) USING BTREE,
  INDEX `publication_did`(`did`) USING BTREE,
  CONSTRAINT `publication_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of publication
-- ----------------------------
INSERT INTO `publication` VALUES (1, 1, 1, 'wrong!', NULL, '2022-06-05 10:55:47', NULL);

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of publish
-- ----------------------------

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
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of resident
-- ----------------------------

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
  `uphoto` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, 'asd', 0, 10, 'guess', '6', NULL);
INSERT INTO `user` VALUES (2, 2, 'abc', 0, 10, 'you guess', '1', NULL);
INSERT INTO `user` VALUES (3, 2, '123', 0, 10, 'you guess', '1', NULL);
INSERT INTO `user` VALUES (4, 2, '456', 0, 10, 'you guess', '1', NULL);
INSERT INTO `user` VALUES (5, 2, 'qwe', 0, 10, 'you guess', '1', NULL);
INSERT INTO `user` VALUES (6, 2, 'rty', 0, 10, 'you guess', '1', NULL);
INSERT INTO `user` VALUES (7, 2, 'gbn', 0, 10, 'you guess', '1', NULL);
INSERT INTO `user` VALUES (8, 2, '333', 0, 10, 'you guess', '1', NULL);

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
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userGAid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userGAid`) USING BTREE,
  INDEX `GAuid`(`uid`) USING BTREE,
  INDEX `userGAGA`(`GAid`) USING BTREE,
  CONSTRAINT `userGAGA` FOREIGN KEY (`GAid`) REFERENCES `govaffairs` (`GAid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userGAuser` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of usergovaffairs
-- ----------------------------
INSERT INTO `usergovaffairs` VALUES (1, 1, 'hahahaha', '2022-02-02 15:15:15', 'aaaaaa', 0, 0, '', '2022-06-04 17:23:16', 'nothing', 1);

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
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of work
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
