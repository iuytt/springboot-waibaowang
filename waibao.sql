/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : waibao

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 05/09/2020 13:43:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `projectID` bigint(8) NOT NULL AUTO_INCREMENT COMMENT '项目ID，唯一',
  `projectName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `issue` bigint(11) NOT NULL COMMENT '发布者',
  `projectType` int(2) NOT NULL COMMENT '项目类型;\r\n0=\"Web网站\" \r\n1=\"APP开发\"\r\n2=\"微信小程序\"\r\n3=\"微信公众号\"\r\n4=\"其他\"',
  `projectDetails` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目描述',
  `pay` int(8) NOT NULL COMMENT '项目资金',
  `date` int(4) NOT NULL COMMENT '项目周期',
  `projectState` int(1) NOT NULL COMMENT '项目状态;\r\n0=“招募中”\r\n1=“进行中”\r\n2=“结束”\r\n',
  `employee` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '雇员',
  `recruit` int(2) NOT NULL COMMENT '招募类型;\r\n0=\"项目顾问\"\r\n1=\"项目经理\" \r\n2=\"产品经理\" \r\n3=\"Android开发\"\r\n4=\"iOS开发\"\r\n5=\"前端开发\"\r\n6=\"后端开发\"\r\n7=\"全栈开发\"\r\n8=\"测试工程师\"',
  `time` datetime(0) NOT NULL COMMENT '项目创建时间',
  PRIMARY KEY (`projectID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '发布项目01', 18645451111, 0, '这是项目描述', 1000, 3, 0, '', 0, '2020-09-05 04:30:27');
INSERT INTO `project` VALUES (2, '发布项目02', 18645451111, 0, '这是项目描述', 3000, 7, 0, '', 4, '2020-09-05 04:36:46');
INSERT INTO `project` VALUES (3, '发布项目03', 18645451111, 1, '这是项目描述', 4000, 5, 0, '', 6, '2020-09-05 04:37:29');
INSERT INTO `project` VALUES (4, '发布项目04', 18645451111, 2, '这是项目描述', 5000, 20, 0, '18645451178;18645451179;', 7, '2020-09-05 04:42:06');
INSERT INTO `project` VALUES (5, 'P1', 18645451112, 3, '这是项目描述', 4000, 20, 0, '', 5, '2020-09-05 05:38:16');
INSERT INTO `project` VALUES (6, 'P2', 18645451112, 4, '这是项目描述', 3000, 20, 0, '', 5, '2020-09-05 05:38:43');
INSERT INTO `project` VALUES (7, 'P3', 18645451112, 2, '这是项目描述', 6000, 30, 0, '', 3, '2020-09-05 05:39:13');
INSERT INTO `project` VALUES (8, 'P4', 18645451112, 0, '这是项目描述', 10000, 30, 0, '', 7, '2020-09-05 05:39:50');
INSERT INTO `project` VALUES (9, 'T1', 18645451112, 3, '这是项目描述', 3000, 15, 0, '', 4, '2020-09-05 05:40:18');
INSERT INTO `project` VALUES (10, 'T2', 18645451112, 0, '这是项目描述', 2000, 7, 0, '', 8, '2020-09-05 05:40:41');
INSERT INTO `project` VALUES (11, 'A1', 18645451112, 2, '这是项目描述', 2000, 10, 0, '', 1, '2020-09-05 05:41:11');
INSERT INTO `project` VALUES (12, 'A2', 18645451112, 4, '这是项目描述', 3000, 10, 0, '', 5, '2020-09-05 05:41:27');
INSERT INTO `project` VALUES (13, 'B1', 18645451112, 3, '这是项目描述', 4000, 15, 0, '', 2, '2020-09-05 05:41:48');
INSERT INTO `project` VALUES (14, 'B2', 18645451112, 0, '这是项目描述', 15000, 30, 0, '', 7, '2020-09-05 05:42:20');
INSERT INTO `project` VALUES (15, 'B3', 18645451112, 1, '这是项目描述', 2000, 15, 0, '', 1, '2020-09-05 05:42:36');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一',
  `PN` bigint(11) NOT NULL COMMENT '唯一',
  `pwd` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一',
  `userStatus` int(1) NOT NULL COMMENT '0=“开发者”\r\n1=“需求方‘',
  `projectID` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '参与的所有项目的ID',
  PRIMARY KEY (`PN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('iuytt', 18645451111, '123456', '22@22.com', 1, '');
INSERT INTO `user` VALUES ('test2', 18645451112, '123456', '23@22.com', 1, '');
INSERT INTO `user` VALUES ('iclzr', 18645451178, '123456', '11@11.com', 0, '4;');
INSERT INTO `user` VALUES ('test1', 18645451179, '123456', '12@11.com', 0, '4;');
INSERT INTO `user` VALUES ('test3', 18645451180, '123456', '13@11.com', 0, '');

SET FOREIGN_KEY_CHECKS = 1;
