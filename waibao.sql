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

 Date: 05/09/2020 10:39:03
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
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, 'p1', 18645451111, 1, 'details', 4000, 40, 2, '18645451178;', 1, '2020-07-09 07:40:12');
INSERT INTO `project` VALUES (2, 'p2', 18645451111, 1, 'details', 4000, 40, 1, '18645451178;', 1, '2020-07-09 07:41:12');
INSERT INTO `project` VALUES (3, 'tp1', 18645451111, 0, 'fabuceshi1', 1000, 7, 0, '', 1, '2020-07-09 03:42:15');
INSERT INTO `project` VALUES (4, 'tp2', 18645451111, 0, 'fabuceshi2', 1000, 7, 0, '', 1, '2020-07-09 03:43:36');
INSERT INTO `project` VALUES (5, 'tp3', 18645451111, 1, 'fabuces3', 3000, 30, 0, '', 4, '2020-07-09 03:44:03');
INSERT INTO `project` VALUES (6, 'tp4', 18645451111, 2, 'fabuces4', 5000, 30, 0, '', 6, '2020-07-09 03:45:02');
INSERT INTO `project` VALUES (7, 'tp5', 18645451111, 4, 'tp5', 2000, 7, 0, '', 8, '2020-07-09 03:46:24');
INSERT INTO `project` VALUES (8, 'tp6', 18645451111, 3, 'tp6', 2000, 5, 0, '', 1, '2020-07-09 03:47:06');
INSERT INTO `project` VALUES (9, '项目发布测试1', 18645451111, 4, '这是一条项目发布测试1', 2222, 22, 0, '', 2, '2020-07-13 08:24:04');
INSERT INTO `project` VALUES (10, '项目发布测试2', 18645451111, 1, '项目发布测试2', 3000, 20, 0, '18645451178;', 1, '2020-07-13 08:24:35');
INSERT INTO `project` VALUES (11, '项目发布测试3', 18645451111, 4, '项目发布测试3', 3000, 10, 2, '18645451178;', 4, '2020-07-13 08:24:59');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '罗祥', '1991-04-04', '男', '北京海淀');

SET FOREIGN_KEY_CHECKS = 1;
