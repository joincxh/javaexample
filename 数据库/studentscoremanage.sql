/*
 Navicat Premium Data Transfer

 Source Server         : java
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : studentscoremanage

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 09/06/2021 22:53:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stu_grade
-- ----------------------------
DROP TABLE IF EXISTS `stu_grade`;
CREATE TABLE `stu_grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级主键',
  `xueyuan` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `gradename` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业班级',
  `gradedesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '班级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_grade
-- ----------------------------
INSERT INTO `stu_grade` VALUES (1, '计算机信息学院', '计算机科学与技术', '国家扶持专业');
INSERT INTO `stu_grade` VALUES (2, '文化传播学院', '新闻传播', '省级品牌');
INSERT INTO `stu_grade` VALUES (3, '商学院', '会计', '国家级专业');
INSERT INTO `stu_grade` VALUES (5, '材料化学学院', '化学材料鉴定', '省级专业');

-- ----------------------------
-- Table structure for stu_student
-- ----------------------------
DROP TABLE IF EXISTS `stu_student`;
CREATE TABLE `stu_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuXue` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuIdcard` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuSex` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuAge` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuAddress` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuPhone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuPart1` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuPart2` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuPart3` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stuTypeid` int(11) NOT NULL COMMENT '学生外键',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stuIdcard`(`stuIdcard`) USING BTREE,
  INDEX `stuTypeid`(`stuTypeid`) USING BTREE,
  CONSTRAINT `stu_student_ibfk_1` FOREIGN KEY (`stuTypeid`) REFERENCES `stu_grade` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_student
-- ----------------------------
INSERT INTO `stu_student` VALUES (12, '陈兴华', '计算机信息学院', '5122512020080', '男', '23', '福建三明', '13960565525', '99', '99', '99', 1);
INSERT INTO `stu_student` VALUES (14, '李四水', '商学院', '199189', '女', '19', '北京朝阳区', '123456789', '88', '88', '88', 3);
INSERT INTO `stu_student` VALUES (16, '张三丰', '材料化学学院', '123456', '男', '24', '浙江', '1448816758', '99', '89', '86', 5);

-- ----------------------------
-- Table structure for stu_user
-- ----------------------------
DROP TABLE IF EXISTS `stu_user`;
CREATE TABLE `stu_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表主键id',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_admin` int(11) NOT NULL DEFAULT 1 COMMENT '判定是否是管理员，默认不是',
  `usertypeid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `usertypeid`(`usertypeid`) USING BTREE,
  CONSTRAINT `stu_user_ibfk_1` FOREIGN KEY (`usertypeid`) REFERENCES `stu_student` (`stuIdcard`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_user
-- ----------------------------
INSERT INTO `stu_user` VALUES (1, '123', '123', 1, NULL);
INSERT INTO `stu_user` VALUES (2, 'root', 'root', 1, NULL);
INSERT INTO `stu_user` VALUES (3, 'cxh', 'cxh', 0, '5122512020080');
INSERT INTO `stu_user` VALUES (4, 'stu', 'stu', 0, '199189');
INSERT INTO `stu_user` VALUES (5, 'teacher', 'teacher', 1, NULL);
INSERT INTO `stu_user` VALUES (6, '13960565525', '123', 0, '123456');

SET FOREIGN_KEY_CHECKS = 1;
