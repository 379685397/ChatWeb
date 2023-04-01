/*
 Navicat Premium Data Transfer

 Source Server         : 本机mysql
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : webtap

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 07/06/2020 22:56:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wt_app_category
-- ----------------------------
DROP TABLE IF EXISTS `wt_app_category`;
CREATE TABLE `wt_app_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `org_id` bigint(20) NULL DEFAULT NULL,
  `app_amount` bigint(255) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wt_app_category
-- ----------------------------
INSERT INTO `wt_app_category` VALUES (1, '产品', 1, 4, NULL);
INSERT INTO `wt_app_category` VALUES (2, '开发', 1, 0, NULL);
INSERT INTO `wt_app_category` VALUES (4, '运营', 1, 3, NULL);
INSERT INTO `wt_app_category` VALUES (6, '项目', 1, 0, 1);

-- ----------------------------
-- Table structure for wt_apps
-- ----------------------------
DROP TABLE IF EXISTS `wt_apps`;
CREATE TABLE `wt_apps`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` bigint(255) NULL DEFAULT NULL COMMENT '分类Id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `org_id` bigint(20) NOT NULL COMMENT '组织id',
  `logo_url` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'app logo',
  `url` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'app url',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'app 名称',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `last_modify_time` bigint(20) NOT NULL COMMENT '修改时间',
  `is_delete` int(255) NOT NULL COMMENT '删除状态',
  `sec_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '敏感信息',
  `sort_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `view_permission` int(255) NULL DEFAULT NULL COMMENT '查看权限0全部,1登录,2自己,3指定角色',
  `view_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查看密码',
  `password_required` bigint(20) NULL DEFAULT NULL,
  `short_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wt_apps
-- ----------------------------
INSERT INTO `wt_apps` VALUES (1, 5, 1, 5, '/upload/logo/kod.png', '来来来', '000', 'jjo', 0, 1585129828285, 0, '用户名：admin\n密码：123456', 8, NULL, NULL, NULL, NULL);
INSERT INTO `wt_apps` VALUES (14, 5, 1, 5, '/upload/logo/gitlab.png', 'lll', 'gitlab', 'll', 0, 1585129318949, 0, '', 0, NULL, NULL, NULL, NULL);
INSERT INTO `wt_apps` VALUES (15, 1, 1, 5, '/upload/logo/chandao.png', 'kk', 'lllll', 'kkk', 0, 0, 0, '', 9, NULL, NULL, NULL, NULL);
INSERT INTO `wt_apps` VALUES (16, 4, 1, 5, '/upload/logo/chandao.png', 'kk', 'lllll', 'kkk', 0, 0, 0, '', 9, NULL, NULL, NULL, NULL);
INSERT INTO `wt_apps` VALUES (18, 3, 1, 5, '/', 'hhh', 'hhh', 'hhh', 0, 0, 0, '', 4, NULL, NULL, NULL, NULL);
INSERT INTO `wt_apps` VALUES (19, 3, 1, 5, '/', 'dsdsd', 'eee', 'sdsds', 0, 0, 0, '', 121, NULL, NULL, NULL, NULL);
INSERT INTO `wt_apps` VALUES (22, 5, 1, 5, '/upload/logo/zabbix.png', 'http://zabbix.utrycc.com/zabbix', 'zabbix-U客', NULL, 1585110929159, 1585129211124, 0, 'Admin/zabbix', 9999, 1, NULL, NULL, NULL);
INSERT INTO `wt_apps` VALUES (25, 0, 1, 1, 'http://localhost:8080/upload/logo/shimo.png', 'https://shimo.im/', '在线office', NULL, 1591518012445, 1591518012445, 0, NULL, 100000, NULL, NULL, 0, NULL);
INSERT INTO `wt_apps` VALUES (26, 0, 1, 1, 'http://localhost:8080/upload/logo/on.png', 'https://www.processon.com/', '流程图', NULL, 1591518081208, 1591518081208, 0, NULL, 100000, NULL, NULL, 0, NULL);
INSERT INTO `wt_apps` VALUES (27, 0, 1, 1, 'http://localhost:8080/upload/logo/photoshop.png', 'https://ps.gaoding.com/#/', '在线PS', NULL, 1591518125857, 1591518125857, 0, NULL, 100000, NULL, NULL, 0, NULL);
INSERT INTO `wt_apps` VALUES (28, 0, 1, 1, 'http://localhost:8080/upload/logo/italent.png', 'https://www.italent.cn/', 'OA', NULL, 1591518337105, 1591518337105, 0, NULL, 100000, NULL, NULL, 0, NULL);
INSERT INTO `wt_apps` VALUES (29, 0, 1, 1, 'http://localhost:8080/upload/logo/kod.png', 'http://demo.kodcloud.com/#user/login', '网盘', NULL, 1591518428084, 1591518428084, 0, '账号demo，密码demo', 100000, NULL, NULL, 1, NULL);
INSERT INTO `wt_apps` VALUES (30, 0, 1, 1, 'http://localhost:8080/upload/logo/gitlab.png', 'https://gitlab.com/', '代码管理', NULL, 1591518543071, 1591518543071, 0, NULL, 100000, NULL, NULL, 0, NULL);
INSERT INTO `wt_apps` VALUES (31, 0, 1, 1, 'http://localhost:8080/upload/logo/chandao.png', 'https://demo.zentao.net/my/', '禅道', NULL, 1591518765411, 1591518765411, 0, NULL, 100000, NULL, NULL, 0, NULL);
INSERT INTO `wt_apps` VALUES (32, 1, 1, 1, 'http://localhost:8080/upload/logo/excel.png', 'https://shimo.im/sheets/qJw9YXQkdtxPWC9c/MODOC/', 'webtap技术选型', NULL, 1591519006648, 1591519006648, 0, NULL, 100000, NULL, NULL, 0, NULL);
INSERT INTO `wt_apps` VALUES (33, 2, 1, 1, 'http://localhost:8080/upload/logo/github.png', 'https://github.com/robotbird/webtap', 'webtap代码', NULL, 1591519290046, 1591519290046, 0, NULL, 100000, NULL, NULL, 0, NULL);
INSERT INTO `wt_apps` VALUES (34, 0, 1, 1, 'http://localhost:8080/upload/logo/teambition.png', 'https://www.teambition.com/', '项目管理', NULL, 1591519426805, 1591519426805, 0, NULL, 100000, NULL, NULL, 0, NULL);
INSERT INTO `wt_apps` VALUES (35, 0, 1, 1, 'http://localhost:8080/upload/logo/slack.png', 'https://slack.com/', 'slack', NULL, 1591519486086, 1591519486086, 0, NULL, 100000, NULL, NULL, 0, NULL);
INSERT INTO `wt_apps` VALUES (37, 4, 1, 1, 'http://localhost:8080/upload/logo/cnblogs.png', 'https://www.cnblogs.com/jqbird/', '博客', NULL, 1591519978655, 1591519978655, 0, NULL, 100000, NULL, NULL, 0, NULL);
INSERT INTO `wt_apps` VALUES (38, 6, 1, 1, 'http://localhost:8080/upload/logo/excel.png', 'https://shimo.im/sheets/qK3yKg6gtCrktHPY/ruGeP/', 'webtap计划', NULL, 1591520036286, 1591520036286, 0, NULL, 100000, NULL, NULL, 0, NULL);

-- ----------------------------
-- Table structure for wt_organizations
-- ----------------------------
DROP TABLE IF EXISTS `wt_organizations`;
CREATE TABLE `wt_organizations`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `org_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织名称',
  `org_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织logo',
  `short_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短地址',
  `create_time` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wt_organizations
-- ----------------------------
INSERT INTO `wt_organizations` VALUES (1, '机器鸟', 'upload/logo/webtap.png', 'robotbird', 1591517598646);
INSERT INTO `wt_organizations` VALUES (6, '智能产品', 'upload/logo/webtap.png', 'ai', 1591517576963);

-- ----------------------------
-- Table structure for wt_resources
-- ----------------------------
DROP TABLE IF EXISTS `wt_resources`;
CREATE TABLE `wt_resources`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) UNSIGNED NULL DEFAULT 0,
  `sort` int(10) UNSIGNED NULL DEFAULT NULL,
  `external` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否外部链接',
  `available` tinyint(1) UNSIGNED NULL DEFAULT 0,
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `org_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wt_resources
-- ----------------------------
INSERT INTO `wt_resources` VALUES (1, '用户管理', 'menu', '', '', 0, 4, 0, 1, 'fa fa-users', '2020-03-09 22:05:09', '2020-03-09 22:05:09', 1);

-- ----------------------------
-- Table structure for wt_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `wt_role_resource`;
CREATE TABLE `wt_role_resource`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) UNSIGNED NOT NULL,
  `resources_id` bigint(20) UNSIGNED NOT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wt_roles
-- ----------------------------
DROP TABLE IF EXISTS `wt_roles`;
CREATE TABLE `wt_roles`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` tinyint(1) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `org_id` bigint(20) NULL DEFAULT NULL,
  `sys_role` tinyblob NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wt_user_role
-- ----------------------------
DROP TABLE IF EXISTS `wt_user_role`;
CREATE TABLE `wt_user_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `role_id` bigint(20) UNSIGNED NOT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wt_users
-- ----------------------------
DROP TABLE IF EXISTS `wt_users`;
CREATE TABLE `wt_users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `background_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` bigint(20) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `introduction` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `last_modify_time` bigint(20) NOT NULL,
  `out_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pass_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `profile_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `validata_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `org_id` bigint(20) NULL DEFAULT NULL,
  `user_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_ob8kqyqqgmefl0aco34akdtpe`(`email`) USING BTREE,
  UNIQUE INDEX `UK_lqjrcobrh9jc8wpcar64q1bfh`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wt_users
-- ----------------------------
INSERT INTO `wt_users` VALUES (1, NULL, 1577200840955, 'robotbird@qq.com', NULL, 1577200840955, '2020-01-29 19:51:15.993', '6db3aabc3ca5f673ac4e2b8221c539d3', 'img/favicon.png', 'webtap', '440417f0-c621-4e55-b5e3-c56610fe655b', 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
