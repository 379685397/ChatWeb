/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Source Server Version : 50568
 Target Server Type    : MySQL
 Target Server Version : 50568
 File Encoding         : 65001

 Date: 02/04/2023 10:15:02
*/

SET NAMES utf8mb4;
SET
    FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_content
-- ----------------------------
DROP TABLE IF EXISTS `user_content`;
CREATE TABLE `user_content`
(
    `id`          bigint(20)                                                   NOT NULL AUTO_INCREMENT,
    `user`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
    `role`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色',
    `content`     longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci    NULL COMMENT '信息',
    `create_time` datetime                                                     NULL DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '用户会话表'
  ROW_FORMAT = Compact;
SET FOREIGN_KEY_CHECKS = 1;
