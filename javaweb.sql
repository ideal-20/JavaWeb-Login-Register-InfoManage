/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : javaweb

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 30/06/2020 18:28:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES (1, 'admin', 'admin888');

-- ----------------------------
-- Table structure for department_info
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info`  (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `department` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department_info
-- ----------------------------
INSERT INTO `department_info` VALUES (1, '技术部');
INSERT INTO `department_info` VALUES (2, '宣传部');
INSERT INTO `department_info` VALUES (3, '财务部');
INSERT INTO `department_info` VALUES (4, '培训部');
INSERT INTO `department_info` VALUES (5, '安保部');
INSERT INTO `department_info` VALUES (6, '测试部');




-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` date NOT NULL,
  `education` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `family` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `treatment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STATUS` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'zhangsan', '张三', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '8k月资+2w奖金', '技术部', 'Y', 'test');
INSERT INTO `user_info` VALUES (2, 'lisi', '李四', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '5k月资+1w奖金', '宣传部', 'Y', 'test');
INSERT INTO `user_info` VALUES (3, 'wangwu', '王五', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '6k月资+1w奖金', '财务部', 'Y', 'test');
INSERT INTO `user_info` VALUES (4, 'zhaoliu', '赵六', '666666', 'ideal_bwh@163.com', '18888888888', '男', '2020-06-01', '测试大学-研究生', '双亲家庭-独生子女', '8k月资+2w奖金', '技术部', 'Y', 'c4bd43379db244fb8c2d0882a73b5c6f');
INSERT INTO `user_info` VALUES (5, 'test', '测试数据7', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '8k月资+2w奖金', '技术部', 'Y', 'test');
INSERT INTO `user_info` VALUES (6, 'test1', '测试数据1', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '8k月资+2w奖金', '技术部', 'Y', 'test');
INSERT INTO `user_info` VALUES (7, 'test2', '测试数据2', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '8k月资+2w奖金', '技术部', 'Y', 'test');
INSERT INTO `user_info` VALUES (8, 'test3', '测试数据3', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '8k月资+2w奖金', '技术部', 'Y', 'test');
INSERT INTO `user_info` VALUES (9, 'test4', '测试数据4', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '8k月资+2w奖金', '技术部', 'Y', 'test');
INSERT INTO `user_info` VALUES (10, 'test5', '测试数据5', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '8k月资+2w奖金', '技术部', 'Y', 'test');
INSERT INTO `user_info` VALUES (11, 'test6', '测试数据6', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '8k月资+2w奖金', '技术部', 'Y', 'test');
INSERT INTO `user_info` VALUES (12, 'test7', '测试数据7', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '8k月资+2w奖金', '技术部', 'Y', 'test');
INSERT INTO `user_info` VALUES (13, 'test', '测试数据8', '666666', 'ideal_bwh@163.com', '13666668888', '男', '2020-01-01', 'XX大学-本科', '双亲家庭-独生子女', '8k月资+2w奖金', '技术部', 'Y', 'test');
INSERT INTO `user_info` VALUES (14, 'steven', '史蒂文', '666666', 'ideal_bwh@163.com', '13934087888', '男', '2020-06-18', NULL, NULL, NULL, NULL, 'Y', '58b79a880f934936abb924f3ad9cc266');

SET FOREIGN_KEY_CHECKS = 1;
