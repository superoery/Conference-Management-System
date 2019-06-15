/*
Navicat MySQL Data Transfer

Source Server         : confersys
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : softwaredb

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-06-14 13:46:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting_id` int(11) NOT NULL,
  `user_id` varchar(10) NOT NULL,
  `apply_status_id` char(10) NOT NULL,
  `apply_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_applies` (`user_id`),
  KEY `FK_apply_to` (`meeting_id`),
  CONSTRAINT `FK_applies` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_apply_to` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES ('2', '14', '10000001', '通过审核', '2019-06-03 16:04:47');
INSERT INTO `apply` VALUES ('4', '18', '10000007', '审核中', '2019-06-02 01:53:04');
INSERT INTO `apply` VALUES ('6', '21', '00000009', '未通过审核', '2019-06-02 02:06:44');
INSERT INTO `apply` VALUES ('7', '22', '00000009', '未通过审核', '2019-06-02 02:51:58');
INSERT INTO `apply` VALUES ('8', '23', '00000009', '未通过审核', '2019-06-02 03:03:42');
INSERT INTO `apply` VALUES ('9', '24', '00000009', '未通过审核', '2019-06-03 16:04:47');
INSERT INTO `apply` VALUES ('10', '25', '10000009', '通过审核', '2019-06-13 17:55:31');
INSERT INTO `apply` VALUES ('11', '26', '10000001', '未通过审核', '2019-06-13 17:59:33');
INSERT INTO `apply` VALUES ('12', '27', '10000001', '通过审核', '2019-06-13 18:15:15');
INSERT INTO `apply` VALUES ('13', '28', '10000001', '通过审核', '2019-06-13 18:45:55');

-- ----------------------------
-- Table structure for belongs_to
-- ----------------------------
DROP TABLE IF EXISTS `belongs_to`;
CREATE TABLE `belongs_to` (
  `id` int(11) NOT NULL,
  `user_id` varchar(10) NOT NULL,
  PRIMARY KEY (`id`,`user_id`),
  KEY `FK_belongs_to2` (`user_id`),
  CONSTRAINT `FK_belongs_to` FOREIGN KEY (`id`) REFERENCES `user_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_belongs_to2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of belongs_to
-- ----------------------------
INSERT INTO `belongs_to` VALUES ('7', '00000009');
INSERT INTO `belongs_to` VALUES ('7', '00000010');
INSERT INTO `belongs_to` VALUES ('7', '00000011');
INSERT INTO `belongs_to` VALUES ('2', '10000001');
INSERT INTO `belongs_to` VALUES ('14', '10000001');
INSERT INTO `belongs_to` VALUES ('3', '10000002');
INSERT INTO `belongs_to` VALUES ('3', '10000004');
INSERT INTO `belongs_to` VALUES ('3', '10000005');
INSERT INTO `belongs_to` VALUES ('3', '10000006');
INSERT INTO `belongs_to` VALUES ('2', '10000007');
INSERT INTO `belongs_to` VALUES ('3', '10000008');
INSERT INTO `belongs_to` VALUES ('12', '10000008');
INSERT INTO `belongs_to` VALUES ('3', '10000009');
INSERT INTO `belongs_to` VALUES ('12', '10000009');
INSERT INTO `belongs_to` VALUES ('2', '10000010');
INSERT INTO `belongs_to` VALUES ('14', '10000010');
INSERT INTO `belongs_to` VALUES ('18', '10000010');
INSERT INTO `belongs_to` VALUES ('2', '10000011');
INSERT INTO `belongs_to` VALUES ('14', '10000011');
INSERT INTO `belongs_to` VALUES ('18', '10000011');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `equipment_id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_type_id` int(11) NOT NULL,
  `meeting_room_id` int(11) NOT NULL,
  `equipment_name` varchar(50) NOT NULL,
  `store_time` datetime NOT NULL,
  `equipment_status` char(10) NOT NULL,
  PRIMARY KEY (`equipment_id`),
  KEY `FK_Relationship_14` (`equipment_type_id`),
  KEY `FK_owns` (`meeting_room_id`),
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`equipment_type_id`) REFERENCES `equipment_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_owns` FOREIGN KEY (`meeting_room_id`) REFERENCES `meeting_room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('13', '2', '7', '投影仪1', '2019-05-31 10:18:56', '可用');
INSERT INTO `equipment` VALUES ('14', '3', '7', '电脑1', '2019-05-31 10:18:56', '可用');
INSERT INTO `equipment` VALUES ('15', '4', '7', '黑板1', '2019-05-31 10:18:56', '可用');
INSERT INTO `equipment` VALUES ('16', '2', '8', '投影仪2', '2019-05-31 10:18:56', '可用');
INSERT INTO `equipment` VALUES ('17', '1', '8', '打印机1', '2019-05-31 10:18:56', '可用');
INSERT INTO `equipment` VALUES ('19', '3', '8', '电脑2', '2019-05-31 10:51:47', '可用');
INSERT INTO `equipment` VALUES ('20', '1', '7', '打印机1', '2019-05-31 10:18:56', '可用');

-- ----------------------------
-- Table structure for equipment_type
-- ----------------------------
DROP TABLE IF EXISTS `equipment_type`;
CREATE TABLE `equipment_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of equipment_type
-- ----------------------------
INSERT INTO `equipment_type` VALUES ('1', '打印机');
INSERT INTO `equipment_type` VALUES ('2', '投影仪');
INSERT INTO `equipment_type` VALUES ('3', '电脑');
INSERT INTO `equipment_type` VALUES ('4', '黑板');

-- ----------------------------
-- Table structure for identity
-- ----------------------------
DROP TABLE IF EXISTS `identity`;
CREATE TABLE `identity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `identity` char(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_power` (`role_id`),
  CONSTRAINT `FK_power` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of identity
-- ----------------------------
INSERT INTO `identity` VALUES ('1', '3', '普通学生');
INSERT INTO `identity` VALUES ('2', '1', '班委');
INSERT INTO `identity` VALUES ('3', '1', '教师');
INSERT INTO `identity` VALUES ('4', '1', '助教');
INSERT INTO `identity` VALUES ('5', '2', '管理员');

-- ----------------------------
-- Table structure for leave_application
-- ----------------------------
DROP TABLE IF EXISTS `leave_application`;
CREATE TABLE `leave_application` (
  `user_id` varchar(10) NOT NULL,
  `meeting_id` int(11) NOT NULL,
  `apply_time` datetime DEFAULT NULL,
  `apply_status_id` char(10) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`meeting_id`),
  KEY `FK_leave_application2` (`meeting_id`),
  CONSTRAINT `FK_leave_application` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_leave_application2` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of leave_application
-- ----------------------------
INSERT INTO `leave_application` VALUES ('10000001', '14', '2019-06-12 08:21:09', '审核中', '临时出差');
INSERT INTO `leave_application` VALUES ('10000002', '14', '2019-06-13 16:49:27', '通过审核', '不想去');
INSERT INTO `leave_application` VALUES ('10000002', '25', '2019-06-13 18:50:45', '审核中', '啊的施工');
INSERT INTO `leave_application` VALUES ('10000004', '18', '2019-06-11 23:34:35', '未通过审核', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊');
INSERT INTO `leave_application` VALUES ('10000005', '14', '2019-06-01 20:33:18', '未通过审核', '病假');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(10) NOT NULL,
  `login_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_login` (`user_id`),
  CONSTRAINT `FK_login` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', '10000005', '2019-06-07 03:19:06');
INSERT INTO `login` VALUES ('2', '10000005', '2019-06-07 04:04:58');
INSERT INTO `login` VALUES ('3', '10000006', '2019-06-07 04:24:58');
INSERT INTO `login` VALUES ('4', '10000006', '2019-06-07 04:26:36');
INSERT INTO `login` VALUES ('5', '10000006', '2019-06-07 04:27:21');
INSERT INTO `login` VALUES ('6', '00000009', '2019-06-07 04:28:56');
INSERT INTO `login` VALUES ('7', '00000009', '2019-06-07 04:29:46');
INSERT INTO `login` VALUES ('8', '00000009', '2019-06-07 04:32:28');
INSERT INTO `login` VALUES ('9', '00000009', '2019-06-07 04:38:21');
INSERT INTO `login` VALUES ('10', '10000001', '2019-06-10 22:12:16');
INSERT INTO `login` VALUES ('11', '10000009', '2019-06-12 00:57:57');
INSERT INTO `login` VALUES ('12', '10000009', '2019-06-12 00:58:45');
INSERT INTO `login` VALUES ('13', '10000003', '2019-06-12 00:58:58');
INSERT INTO `login` VALUES ('14', '10000003', '2019-06-12 00:59:03');
INSERT INTO `login` VALUES ('15', '10000003', '2019-06-12 07:59:23');
INSERT INTO `login` VALUES ('16', '10000003', '2019-06-12 08:01:49');
INSERT INTO `login` VALUES ('17', '10000003', '2019-06-12 08:03:40');
INSERT INTO `login` VALUES ('18', '10000001', '2019-06-12 08:19:58');
INSERT INTO `login` VALUES ('19', '10000003', '2019-06-12 08:24:45');
INSERT INTO `login` VALUES ('20', '10000003', '2019-06-12 08:35:54');
INSERT INTO `login` VALUES ('21', '10000003', '2019-06-12 08:38:48');
INSERT INTO `login` VALUES ('22', '10000003', '2019-06-12 08:40:48');
INSERT INTO `login` VALUES ('23', '10000003', '2019-06-12 08:43:30');
INSERT INTO `login` VALUES ('24', '10000003', '2019-06-12 09:22:36');
INSERT INTO `login` VALUES ('25', '10000003', '2019-06-12 09:24:00');
INSERT INTO `login` VALUES ('26', '10000003', '2019-06-12 09:29:34');
INSERT INTO `login` VALUES ('27', '10000003', '2019-06-12 09:37:12');
INSERT INTO `login` VALUES ('28', '10000003', '2019-06-12 09:38:36');
INSERT INTO `login` VALUES ('29', '10000003', '2019-06-12 10:23:22');
INSERT INTO `login` VALUES ('30', '10000003', '2019-06-12 10:54:04');
INSERT INTO `login` VALUES ('31', '10000003', '2019-06-12 10:58:07');
INSERT INTO `login` VALUES ('32', '10000003', '2019-06-12 11:04:00');
INSERT INTO `login` VALUES ('33', '10000003', '2019-06-12 11:05:24');
INSERT INTO `login` VALUES ('34', '10000003', '2019-06-12 11:06:24');
INSERT INTO `login` VALUES ('35', '10000003', '2019-06-12 11:08:14');
INSERT INTO `login` VALUES ('36', '10000003', '2019-06-12 16:08:10');
INSERT INTO `login` VALUES ('37', '10000003', '2019-06-12 16:10:48');
INSERT INTO `login` VALUES ('38', '10000003', '2019-06-12 16:12:24');
INSERT INTO `login` VALUES ('39', '10000003', '2019-06-12 17:10:25');
INSERT INTO `login` VALUES ('40', '10000003', '2019-06-12 17:11:28');
INSERT INTO `login` VALUES ('41', '10000009', '2019-06-12 22:35:31');
INSERT INTO `login` VALUES ('42', '10000003', '2019-06-12 22:41:55');
INSERT INTO `login` VALUES ('43', '10000003', '2019-06-12 22:43:20');
INSERT INTO `login` VALUES ('44', '10000003', '2019-06-12 22:45:44');
INSERT INTO `login` VALUES ('45', '10000003', '2019-06-12 22:55:11');
INSERT INTO `login` VALUES ('46', '10000003', '2019-06-12 22:55:17');
INSERT INTO `login` VALUES ('47', '10000003', '2019-06-12 22:58:33');
INSERT INTO `login` VALUES ('48', '10000003', '2019-06-12 22:58:42');
INSERT INTO `login` VALUES ('49', '10000003', '2019-06-12 23:01:12');
INSERT INTO `login` VALUES ('50', '10000003', '2019-06-12 23:03:39');
INSERT INTO `login` VALUES ('51', '10000003', '2019-06-12 23:05:56');
INSERT INTO `login` VALUES ('52', '10000003', '2019-06-12 23:32:40');
INSERT INTO `login` VALUES ('53', '10000003', '2019-06-12 23:44:24');
INSERT INTO `login` VALUES ('54', '10000001', '2019-06-12 23:46:49');
INSERT INTO `login` VALUES ('55', '10000003', '2019-06-12 23:47:24');
INSERT INTO `login` VALUES ('56', '10000001', '2019-06-13 00:06:54');
INSERT INTO `login` VALUES ('57', '10000002', '2019-06-13 00:12:01');
INSERT INTO `login` VALUES ('58', '10000001', '2019-06-13 00:14:43');
INSERT INTO `login` VALUES ('59', '10000003', '2019-06-13 00:19:43');
INSERT INTO `login` VALUES ('60', '10000001', '2019-06-13 00:24:14');
INSERT INTO `login` VALUES ('61', '10000002', '2019-06-13 01:50:37');
INSERT INTO `login` VALUES ('62', '10000003', '2019-06-13 01:54:43');
INSERT INTO `login` VALUES ('63', '10000001', '2019-06-13 01:55:26');
INSERT INTO `login` VALUES ('64', '10000002', '2019-06-13 01:59:54');
INSERT INTO `login` VALUES ('65', '10000003', '2019-06-13 02:08:11');
INSERT INTO `login` VALUES ('66', '10000001', '2019-06-13 02:14:46');
INSERT INTO `login` VALUES ('67', '10000002', '2019-06-13 08:20:59');
INSERT INTO `login` VALUES ('68', '10000003', '2019-06-13 08:26:51');
INSERT INTO `login` VALUES ('69', '10000002', '2019-06-13 08:29:36');
INSERT INTO `login` VALUES ('70', '10000002', '2019-06-13 09:24:08');
INSERT INTO `login` VALUES ('71', '10000002', '2019-06-13 09:28:56');
INSERT INTO `login` VALUES ('72', '10000002', '2019-06-13 09:31:07');
INSERT INTO `login` VALUES ('73', '10000002', '2019-06-13 09:37:21');
INSERT INTO `login` VALUES ('74', '10000002', '2019-06-13 09:38:49');
INSERT INTO `login` VALUES ('75', '10000002', '2019-06-13 09:41:32');
INSERT INTO `login` VALUES ('76', '10000002', '2019-06-13 09:42:41');
INSERT INTO `login` VALUES ('77', '10000002', '2019-06-13 09:46:32');
INSERT INTO `login` VALUES ('78', '10000002', '2019-06-13 09:49:27');
INSERT INTO `login` VALUES ('79', '10000002', '2019-06-13 10:49:58');
INSERT INTO `login` VALUES ('80', '10000001', '2019-06-13 10:51:07');
INSERT INTO `login` VALUES ('81', '10000002', '2019-06-13 11:07:21');
INSERT INTO `login` VALUES ('82', '10000002', '2019-06-13 11:09:39');
INSERT INTO `login` VALUES ('83', '10000002', '2019-06-13 11:11:08');
INSERT INTO `login` VALUES ('84', '10000003', '2019-06-13 11:11:45');
INSERT INTO `login` VALUES ('85', '10000002', '2019-06-13 11:16:00');
INSERT INTO `login` VALUES ('86', '10000002', '2019-06-13 11:18:51');
INSERT INTO `login` VALUES ('87', '10000002', '2019-06-13 11:21:37');
INSERT INTO `login` VALUES ('88', '10000002', '2019-06-13 11:26:06');
INSERT INTO `login` VALUES ('89', '10000003', '2019-06-13 12:23:06');
INSERT INTO `login` VALUES ('90', '10000002', '2019-06-13 12:24:46');
INSERT INTO `login` VALUES ('91', '10000001', '2019-06-13 12:36:32');
INSERT INTO `login` VALUES ('92', '10000001', '2019-06-13 12:36:32');
INSERT INTO `login` VALUES ('93', '10000001', '2019-06-13 12:59:14');
INSERT INTO `login` VALUES ('94', '10000002', '2019-06-13 12:59:55');
INSERT INTO `login` VALUES ('95', '10000001', '2019-06-13 13:22:25');
INSERT INTO `login` VALUES ('96', '10000001', '2019-06-13 13:28:28');
INSERT INTO `login` VALUES ('97', '10000002', '2019-06-13 13:37:29');
INSERT INTO `login` VALUES ('98', '10000001', '2019-06-13 14:01:21');
INSERT INTO `login` VALUES ('99', '10000002', '2019-06-13 14:03:25');
INSERT INTO `login` VALUES ('100', '10000002', '2019-06-13 14:06:36');
INSERT INTO `login` VALUES ('101', '10000002', '2019-06-13 14:09:53');
INSERT INTO `login` VALUES ('102', '10000002', '2019-06-13 14:12:29');
INSERT INTO `login` VALUES ('103', '10000002', '2019-06-13 14:15:07');
INSERT INTO `login` VALUES ('104', '10000002', '2019-06-13 14:16:51');
INSERT INTO `login` VALUES ('105', '10000002', '2019-06-13 14:24:15');
INSERT INTO `login` VALUES ('106', '10000002', '2019-06-13 14:25:45');
INSERT INTO `login` VALUES ('107', '10000002', '2019-06-13 14:44:07');
INSERT INTO `login` VALUES ('108', '10000002', '2019-06-13 14:47:46');
INSERT INTO `login` VALUES ('109', '10000002', '2019-06-13 14:50:47');
INSERT INTO `login` VALUES ('110', '10000002', '2019-06-13 14:52:06');
INSERT INTO `login` VALUES ('111', '10000002', '2019-06-13 14:52:58');
INSERT INTO `login` VALUES ('112', '10000002', '2019-06-13 14:55:32');
INSERT INTO `login` VALUES ('113', '10000002', '2019-06-13 14:56:19');
INSERT INTO `login` VALUES ('114', '10000003', '2019-06-13 14:58:25');
INSERT INTO `login` VALUES ('115', '10000002', '2019-06-13 14:59:48');
INSERT INTO `login` VALUES ('116', '10000002', '2019-06-13 15:05:16');
INSERT INTO `login` VALUES ('117', '10000002', '2019-06-13 15:06:32');
INSERT INTO `login` VALUES ('118', '10000002', '2019-06-13 15:07:26');
INSERT INTO `login` VALUES ('119', '10000002', '2019-06-13 15:59:59');
INSERT INTO `login` VALUES ('120', '10000001', '2019-06-13 16:00:43');
INSERT INTO `login` VALUES ('121', '10000002', '2019-06-13 16:01:26');
INSERT INTO `login` VALUES ('122', '10000002', '2019-06-13 16:30:29');
INSERT INTO `login` VALUES ('123', '10000002', '2019-06-13 16:33:27');
INSERT INTO `login` VALUES ('124', '10000002', '2019-06-13 16:33:27');
INSERT INTO `login` VALUES ('125', '10000002', '2019-06-13 16:36:24');
INSERT INTO `login` VALUES ('126', '10000002', '2019-06-13 16:38:20');
INSERT INTO `login` VALUES ('127', '10000002', '2019-06-13 16:39:07');
INSERT INTO `login` VALUES ('128', '10000002', '2019-06-13 16:40:37');
INSERT INTO `login` VALUES ('129', '10000002', '2019-06-13 16:42:46');
INSERT INTO `login` VALUES ('130', '10000002', '2019-06-13 16:44:40');
INSERT INTO `login` VALUES ('131', '10000002', '2019-06-13 16:50:23');
INSERT INTO `login` VALUES ('132', '10000002', '2019-06-13 16:51:13');
INSERT INTO `login` VALUES ('133', '10000002', '2019-06-13 16:53:58');
INSERT INTO `login` VALUES ('134', '10000002', '2019-06-13 16:58:04');
INSERT INTO `login` VALUES ('135', '10000001', '2019-06-13 16:58:26');
INSERT INTO `login` VALUES ('136', '10000003', '2019-06-13 16:58:46');
INSERT INTO `login` VALUES ('137', '10000002', '2019-06-13 16:59:07');
INSERT INTO `login` VALUES ('138', '10000002', '2019-06-13 17:01:41');
INSERT INTO `login` VALUES ('139', '10000002', '2019-06-13 17:08:32');
INSERT INTO `login` VALUES ('140', '10000002', '2019-06-13 17:09:36');
INSERT INTO `login` VALUES ('141', '10000002', '2019-06-13 17:15:35');
INSERT INTO `login` VALUES ('142', '10000002', '2019-06-13 17:17:55');
INSERT INTO `login` VALUES ('143', '10000002', '2019-06-13 17:19:06');
INSERT INTO `login` VALUES ('144', '10000002', '2019-06-13 17:22:56');
INSERT INTO `login` VALUES ('145', '10000002', '2019-06-13 17:23:57');
INSERT INTO `login` VALUES ('146', '10000001', '2019-06-13 17:36:39');
INSERT INTO `login` VALUES ('147', '10000009', '2019-06-13 17:54:21');
INSERT INTO `login` VALUES ('148', '10000003', '2019-06-13 17:56:06');
INSERT INTO `login` VALUES ('149', '10000009', '2019-06-13 17:57:09');
INSERT INTO `login` VALUES ('150', '10000002', '2019-06-13 17:57:42');
INSERT INTO `login` VALUES ('151', '10000001', '2019-06-13 17:58:56');
INSERT INTO `login` VALUES ('152', '10000003', '2019-06-13 17:59:42');
INSERT INTO `login` VALUES ('153', '10000002', '2019-06-13 18:00:09');
INSERT INTO `login` VALUES ('154', '10000001', '2019-06-13 18:00:27');
INSERT INTO `login` VALUES ('155', '10000001', '2019-06-13 18:08:57');
INSERT INTO `login` VALUES ('156', '10000003', '2019-06-13 18:09:35');
INSERT INTO `login` VALUES ('157', '10000001', '2019-06-13 18:14:24');
INSERT INTO `login` VALUES ('158', '10000003', '2019-06-13 18:15:48');
INSERT INTO `login` VALUES ('159', '10000003', '2019-06-13 18:19:12');
INSERT INTO `login` VALUES ('160', '10000003', '2019-06-13 18:19:12');
INSERT INTO `login` VALUES ('161', '10000002', '2019-06-13 18:20:12');
INSERT INTO `login` VALUES ('162', '10000001', '2019-06-13 18:22:07');
INSERT INTO `login` VALUES ('163', '10000002', '2019-06-13 18:24:02');
INSERT INTO `login` VALUES ('164', '10000001', '2019-06-13 18:44:41');
INSERT INTO `login` VALUES ('165', '10000003', '2019-06-13 18:46:15');
INSERT INTO `login` VALUES ('166', '10000002', '2019-06-13 18:47:34');
INSERT INTO `login` VALUES ('167', '10000001', '2019-06-14 12:21:16');

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(100) NOT NULL,
  `number` int(11) NOT NULL,
  `meeting_status_id` char(10) NOT NULL,
  `meeting_content` varchar(200) DEFAULT NULL,
  `meeting_conclusion` varchar(100) DEFAULT NULL,
  `apply_status_id` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of meeting
-- ----------------------------
INSERT INTO `meeting` VALUES ('5', 'how to graduate', '20', '审核通过未开始', 'this meeting is about graduation.', 'study harder!', '通过审核');
INSERT INTO `meeting` VALUES ('6', 'how to work', '30', '审核通过未开始', 'this meeting2 is about work.', 'work harder!', '通过审核');
INSERT INTO `meeting` VALUES ('7', 'how to graduate', '20', '审核通过未开始', 'this meeting is about graduation.', 'study harder!', '通过审核');
INSERT INTO `meeting` VALUES ('8', 'how to work', '30', '审核通过未开始', 'this meeting2 is about work.', 'work harder!', '通过审核');
INSERT INTO `meeting` VALUES ('14', 'srtp开会', '3', '审核通过未开始', '讨论怎么实现人工智能的实际应用', '很难实现', '审核中');
INSERT INTO `meeting` VALUES ('18', '软件工程实现', '3', '正在审核', '讨论怎么实现软件工程课程的项目', null, '审核中');
INSERT INTO `meeting` VALUES ('21', '党团开会', '0', '正在审核', '讨论怎么实现美好未来', null, '审核中');
INSERT INTO `meeting` VALUES ('22', '党团开会', '0', '正在审核', '讨论怎么实现美好未来', null, '正在审核');
INSERT INTO `meeting` VALUES ('23', '党团开会', '0', '正在审核', '讨论怎么实现美好未来', null, '正在审核');
INSERT INTO `meeting` VALUES ('24', '党团开会', '0', '正在审核', '讨论怎么实现美好未来', null, '审核中');
INSERT INTO `meeting` VALUES ('25', 'abc', '0', '审核通过未开始', 'aaaaaaaaaaaaa', null, '审核中');
INSERT INTO `meeting` VALUES ('26', '开心', '0', '审核未通过', '', null, '审核中');
INSERT INTO `meeting` VALUES ('27', '教学经验分享会', '0', '审核通过未开始', '教学经验分享会，希望大家能好好交流', null, '审核中');
INSERT INTO `meeting` VALUES ('28', '1111', '0', '审核通过未开始', '111111', null, '审核中');

-- ----------------------------
-- Table structure for meeting_room
-- ----------------------------
DROP TABLE IF EXISTS `meeting_room`;
CREATE TABLE `meeting_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `capacity` int(11) NOT NULL,
  `room_introduce` varchar(100) DEFAULT NULL,
  `room_number` varchar(10) NOT NULL,
  `building` varchar(10) NOT NULL,
  `floor` int(11) NOT NULL,
  `status_id` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of meeting_room
-- ----------------------------
INSERT INTO `meeting_room` VALUES ('7', '40', 'I\'m 604', '04', '逸夫楼', '6', '空闲');
INSERT INTO `meeting_room` VALUES ('8', '70', 'I\'m 104', '04', '机电楼', '1', '空闲');

-- ----------------------------
-- Table structure for notices
-- ----------------------------
DROP TABLE IF EXISTS `notices`;
CREATE TABLE `notices` (
  `user_id` varchar(10) NOT NULL,
  `notification_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`notification_id`),
  KEY `FK_notices2` (`notification_id`),
  CONSTRAINT `FK_notices` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_notices2` FOREIGN KEY (`notification_id`) REFERENCES `notification` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of notices
-- ----------------------------
INSERT INTO `notices` VALUES ('10000002', '1');
INSERT INTO `notices` VALUES ('10000004', '2');
INSERT INTO `notices` VALUES ('10000011', '3');
INSERT INTO `notices` VALUES ('10000008', '4');
INSERT INTO `notices` VALUES ('10000004', '5');
INSERT INTO `notices` VALUES ('10000001', '17');
INSERT INTO `notices` VALUES ('10000004', '18');
INSERT INTO `notices` VALUES ('10000008', '19');
INSERT INTO `notices` VALUES ('10000009', '20');
INSERT INTO `notices` VALUES ('10000011', '21');
INSERT INTO `notices` VALUES ('10000001', '22');
INSERT INTO `notices` VALUES ('10000001', '23');
INSERT INTO `notices` VALUES ('10000002', '24');
INSERT INTO `notices` VALUES ('10000004', '25');
INSERT INTO `notices` VALUES ('10000008', '26');
INSERT INTO `notices` VALUES ('10000001', '27');
INSERT INTO `notices` VALUES ('10000001', '28');
INSERT INTO `notices` VALUES ('10000001', '29');
INSERT INTO `notices` VALUES ('10000002', '30');
INSERT INTO `notices` VALUES ('10000004', '31');
INSERT INTO `notices` VALUES ('10000008', '32');
INSERT INTO `notices` VALUES ('10000001', '33');
INSERT INTO `notices` VALUES ('10000001', '34');
INSERT INTO `notices` VALUES ('10000001', '36');
INSERT INTO `notices` VALUES ('10000001', '37');
INSERT INTO `notices` VALUES ('10000002', '38');
INSERT INTO `notices` VALUES ('10000004', '39');
INSERT INTO `notices` VALUES ('10000008', '40');
INSERT INTO `notices` VALUES ('10000001', '41');
INSERT INTO `notices` VALUES ('10000004', '42');
INSERT INTO `notices` VALUES ('10000004', '43');
INSERT INTO `notices` VALUES ('10000005', '44');
INSERT INTO `notices` VALUES ('10000001', '45');
INSERT INTO `notices` VALUES ('10000002', '46');
INSERT INTO `notices` VALUES ('10000004', '47');
INSERT INTO `notices` VALUES ('10000008', '48');
INSERT INTO `notices` VALUES ('10000001', '49');
INSERT INTO `notices` VALUES ('10000001', '50');
INSERT INTO `notices` VALUES ('10000002', '51');
INSERT INTO `notices` VALUES ('10000004', '52');
INSERT INTO `notices` VALUES ('10000008', '53');
INSERT INTO `notices` VALUES ('10000001', '54');
INSERT INTO `notices` VALUES ('10000005', '55');
INSERT INTO `notices` VALUES ('10000004', '56');
INSERT INTO `notices` VALUES ('10000001', '57');
INSERT INTO `notices` VALUES ('10000002', '58');
INSERT INTO `notices` VALUES ('10000004', '59');
INSERT INTO `notices` VALUES ('10000008', '60');
INSERT INTO `notices` VALUES ('10000001', '61');
INSERT INTO `notices` VALUES ('10000004', '62');
INSERT INTO `notices` VALUES ('10000001', '63');
INSERT INTO `notices` VALUES ('10000001', '64');
INSERT INTO `notices` VALUES ('10000002', '65');
INSERT INTO `notices` VALUES ('10000002', '66');
INSERT INTO `notices` VALUES ('10000001', '67');
INSERT INTO `notices` VALUES ('10000002', '68');
INSERT INTO `notices` VALUES ('10000002', '69');
INSERT INTO `notices` VALUES ('10000002', '72');
INSERT INTO `notices` VALUES ('10000002', '73');
INSERT INTO `notices` VALUES ('10000002', '74');
INSERT INTO `notices` VALUES ('10000002', '75');
INSERT INTO `notices` VALUES ('10000002', '76');
INSERT INTO `notices` VALUES ('10000002', '77');
INSERT INTO `notices` VALUES ('10000002', '78');
INSERT INTO `notices` VALUES ('10000002', '79');
INSERT INTO `notices` VALUES ('10000002', '80');
INSERT INTO `notices` VALUES ('10000001', '81');
INSERT INTO `notices` VALUES ('10000002', '82');
INSERT INTO `notices` VALUES ('10000004', '83');
INSERT INTO `notices` VALUES ('10000005', '84');
INSERT INTO `notices` VALUES ('10000006', '85');
INSERT INTO `notices` VALUES ('10000007', '86');
INSERT INTO `notices` VALUES ('10000008', '87');
INSERT INTO `notices` VALUES ('10000009', '88');
INSERT INTO `notices` VALUES ('10000010', '89');
INSERT INTO `notices` VALUES ('10000011', '90');
INSERT INTO `notices` VALUES ('10000009', '91');
INSERT INTO `notices` VALUES ('10000001', '92');
INSERT INTO `notices` VALUES ('10000001', '93');
INSERT INTO `notices` VALUES ('10000007', '94');
INSERT INTO `notices` VALUES ('10000010', '95');
INSERT INTO `notices` VALUES ('10000011', '96');
INSERT INTO `notices` VALUES ('10000001', '97');
INSERT INTO `notices` VALUES ('10000001', '98');
INSERT INTO `notices` VALUES ('10000002', '99');
INSERT INTO `notices` VALUES ('10000004', '100');
INSERT INTO `notices` VALUES ('10000005', '101');
INSERT INTO `notices` VALUES ('10000006', '102');
INSERT INTO `notices` VALUES ('10000008', '103');
INSERT INTO `notices` VALUES ('10000009', '104');
INSERT INTO `notices` VALUES ('10000001', '105');
INSERT INTO `notices` VALUES ('10000002', '106');
INSERT INTO `notices` VALUES ('10000002', '107');

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notification_type` char(10) NOT NULL,
  `notification_detail` varchar(100) DEFAULT NULL,
  `notification_status` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `refer_id` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of notification
-- ----------------------------
INSERT INTO `notification` VALUES ('1', '新会议', '您有新的会议信息，该会议的主题是“srtp开会”', '已读', '14');
INSERT INTO `notification` VALUES ('2', '新会议', '您有新的会议信息，该会议的主题是“srtp开会”', '未读', '14');
INSERT INTO `notification` VALUES ('3', '新会议', '您有新的会议信息，该会议的主题是“srtp开会”', '已读', '14');
INSERT INTO `notification` VALUES ('4', '新会议', '您有新的会议信息，该会议的主题是“srtp开会”', '未读', '14');
INSERT INTO `notification` VALUES ('5', '请假结果', '会议“srtp开会”的请假已获批', '已读', '14');
INSERT INTO `notification` VALUES ('7', '报修', '逸夫楼804的设备 电脑1 已修复完毕', '未读', '2');
INSERT INTO `notification` VALUES ('8', '审核结果', '会议“how to work”已获批', '已读', '8');
INSERT INTO `notification` VALUES ('17', '新会议', '05月30日,从14时00分到16时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '已读', '14');
INSERT INTO `notification` VALUES ('18', '新会议', '05月30日,从14时00分到16时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('19', '新会议', '05月30日,从14时00分到16时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('20', '新会议', '05月30日,从14时00分到16时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('21', '新会议', '05月30日,从14时00分到16时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('22', '审核结果', '主题为\"srtp开会\"的会议预约已通过', '已读', '14');
INSERT INTO `notification` VALUES ('23', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('24', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '已读', '14');
INSERT INTO `notification` VALUES ('25', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('26', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('27', '审核结果', '主题为\"srtp开会\"的会议预约已通过', '已读', '14');
INSERT INTO `notification` VALUES ('28', '审核结果', '主题为\"srtp开会\"的会议预约未通过', '已读', '14');
INSERT INTO `notification` VALUES ('29', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('30', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '已读', '14');
INSERT INTO `notification` VALUES ('31', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('32', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('33', '审核结果', '主题为\"srtp开会\"的会议预约已通过', '已读', '14');
INSERT INTO `notification` VALUES ('34', '审核结果', '主题为\"srtp开会\"的会议预约未通过', '已读', '14');
INSERT INTO `notification` VALUES ('36', '审核结果', '主题为\"srtp开会\"的会议预约未通过', '未读', '14');
INSERT INTO `notification` VALUES ('37', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('38', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '已读', '14');
INSERT INTO `notification` VALUES ('39', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('40', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('41', '审核结果', '主题为\"srtp开会\"的会议预约已通过', '未读', '14');
INSERT INTO `notification` VALUES ('42', '报修', 'succeed!', '未读', '1');
INSERT INTO `notification` VALUES ('43', '报修', 'succeed!', '未读', '1');
INSERT INTO `notification` VALUES ('44', '请假结果', '恭喜，您的请假申请已通过', '未读', '14');
INSERT INTO `notification` VALUES ('45', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('46', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '已读', '14');
INSERT INTO `notification` VALUES ('47', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('48', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('49', '审核结果', '主题为\"srtp开会\"的会议预约已通过', '未读', '14');
INSERT INTO `notification` VALUES ('50', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('51', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '已读', '14');
INSERT INTO `notification` VALUES ('52', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('53', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('54', '审核结果', '主题为\"srtp开会\"的会议预约已通过', '未读', '14');
INSERT INTO `notification` VALUES ('55', '请假结果', '对不起，您的请假申请未通过。', '未读', '14');
INSERT INTO `notification` VALUES ('56', '报修', 'succeed!', '未读', '1');
INSERT INTO `notification` VALUES ('57', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '已读', '14');
INSERT INTO `notification` VALUES ('58', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '已读', '14');
INSERT INTO `notification` VALUES ('59', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('60', '新会议', '05月30日,从14时00分到18时00分您需要参加 \"srtp开会\"会议，请您做好与会准备', '未读', '14');
INSERT INTO `notification` VALUES ('61', '审核结果', '主题为\"srtp开会\"的会议预约已通过', '未读', '14');
INSERT INTO `notification` VALUES ('62', '请假结果', '对不起，您的请假申请未通过。', '未读', '18');
INSERT INTO `notification` VALUES ('63', '请假结果', '恭喜，您的请假申请已通过', '已读', '14');
INSERT INTO `notification` VALUES ('64', '报修', '机电楼104的设备 投影仪2 已修复完毕', '已读', '2');
INSERT INTO `notification` VALUES ('65', '请假结果', '对不起，您的请假申请未通过', '已读', '14');
INSERT INTO `notification` VALUES ('66', '报修', '逸夫楼604的设备 黑板1 已补充完毕', '已读', '3');
INSERT INTO `notification` VALUES ('67', '报修', '您关于8号房间的投影仪2报修已成功处理，感谢您的反馈', '已读', '2');
INSERT INTO `notification` VALUES ('68', '报修', '您关于7号房间的投影仪1报修已成功处理，感谢您的反馈', '已读', '4');
INSERT INTO `notification` VALUES ('69', '报修', '您关于7号房间的打印机1报修已成功处理，感谢您的反馈', '已读', '5');
INSERT INTO `notification` VALUES ('72', '报修', '对不起，由于您于06月13日报修的设备编号不存在，报修无效', '已读', '0');
INSERT INTO `notification` VALUES ('73', '报修', '您关于逸夫楼604的黑板，设备编号为15的报修已成功处理，感谢您的反馈', '已读', '3');
INSERT INTO `notification` VALUES ('74', '请假结果', '恭喜，您的会议主题为srtp开会的会议请假申请已通过', '已读', '14');
INSERT INTO `notification` VALUES ('75', '报修', '您关于机电楼104的打印机，设备编号为17的报修已成功处理，感谢您的反馈', '已读', '8');
INSERT INTO `notification` VALUES ('76', '请假结果', '恭喜，您的会议主题为srtp开会的会议请假申请已通过', '已读', '14');
INSERT INTO `notification` VALUES ('77', '报修', '对不起，由于您于06月13日报修的设备编号不存在，报修无效', '已读', '0');
INSERT INTO `notification` VALUES ('78', '请假结果', '恭喜，您的会议主题为srtp开会的会议请假申请已通过', '已读', '14');
INSERT INTO `notification` VALUES ('79', '报修', '您关于逸夫楼604的打印机，设备编号为20的报修已成功处理，感谢您的反馈', '已读', '9');
INSERT INTO `notification` VALUES ('80', '请假结果', '对不起，您的会议主题为srtp开会的会议请假申请未通过', '已读', '14');
INSERT INTO `notification` VALUES ('81', '新会议', '06月13日,从11时50分到13时55分您需要参加 \"abc\"会议，请您做好与会准备', '已读', '25');
INSERT INTO `notification` VALUES ('82', '新会议', '06月13日,从11时50分到13时55分您需要参加 \"abc\"会议，请您做好与会准备', '已读', '25');
INSERT INTO `notification` VALUES ('83', '新会议', '06月13日,从11时50分到13时55分您需要参加 \"abc\"会议，请您做好与会准备', '未读', '25');
INSERT INTO `notification` VALUES ('84', '新会议', '06月13日,从11时50分到13时55分您需要参加 \"abc\"会议，请您做好与会准备', '未读', '25');
INSERT INTO `notification` VALUES ('85', '新会议', '06月13日,从11时50分到13时55分您需要参加 \"abc\"会议，请您做好与会准备', '未读', '25');
INSERT INTO `notification` VALUES ('86', '新会议', '06月13日,从11时50分到13时55分您需要参加 \"abc\"会议，请您做好与会准备', '未读', '25');
INSERT INTO `notification` VALUES ('87', '新会议', '06月13日,从11时50分到13时55分您需要参加 \"abc\"会议，请您做好与会准备', '未读', '25');
INSERT INTO `notification` VALUES ('88', '新会议', '06月13日,从11时50分到13时55分您需要参加 \"abc\"会议，请您做好与会准备', '未读', '25');
INSERT INTO `notification` VALUES ('89', '新会议', '06月13日,从11时50分到13时55分您需要参加 \"abc\"会议，请您做好与会准备', '未读', '25');
INSERT INTO `notification` VALUES ('90', '新会议', '06月13日,从11时50分到13时55分您需要参加 \"abc\"会议，请您做好与会准备', '未读', '25');
INSERT INTO `notification` VALUES ('91', '审核结果', '主题为\"abc\"的会议预约已通过', '已读', '25');
INSERT INTO `notification` VALUES ('92', '审核结果', '主题为\"开心\"的会议预约未通过', '已读', '26');
INSERT INTO `notification` VALUES ('93', '新会议', '08月13日,从10时12分到15时14分在逸夫楼604,您需要参加 \"教学经验分享会\"会议，请您做好与会准备', '已读', '27');
INSERT INTO `notification` VALUES ('94', '新会议', '08月13日,从10时12分到15时14分在逸夫楼604,您需要参加 \"教学经验分享会\"会议，请您做好与会准备', '未读', '27');
INSERT INTO `notification` VALUES ('95', '新会议', '08月13日,从10时12分到15时14分在逸夫楼604,您需要参加 \"教学经验分享会\"会议，请您做好与会准备', '未读', '27');
INSERT INTO `notification` VALUES ('96', '新会议', '08月13日,从10时12分到15时14分在逸夫楼604,您需要参加 \"教学经验分享会\"会议，请您做好与会准备', '未读', '27');
INSERT INTO `notification` VALUES ('97', '审核结果', '主题为\"教学经验分享会\"的会议预约已通过', '已读', '27');
INSERT INTO `notification` VALUES ('98', '新会议', '10月16日,从10时48分到16时45分在逸夫楼604,您需要参加 \"1111\"会议，请您做好与会准备', '已读', '28');
INSERT INTO `notification` VALUES ('99', '新会议', '10月16日,从10时48分到16时45分在逸夫楼604,您需要参加 \"1111\"会议，请您做好与会准备', '已读', '28');
INSERT INTO `notification` VALUES ('100', '新会议', '10月16日,从10时48分到16时45分在逸夫楼604,您需要参加 \"1111\"会议，请您做好与会准备', '未读', '28');
INSERT INTO `notification` VALUES ('101', '新会议', '10月16日,从10时48分到16时45分在逸夫楼604,您需要参加 \"1111\"会议，请您做好与会准备', '未读', '28');
INSERT INTO `notification` VALUES ('102', '新会议', '10月16日,从10时48分到16时45分在逸夫楼604,您需要参加 \"1111\"会议，请您做好与会准备', '未读', '28');
INSERT INTO `notification` VALUES ('103', '新会议', '10月16日,从10时48分到16时45分在逸夫楼604,您需要参加 \"1111\"会议，请您做好与会准备', '未读', '28');
INSERT INTO `notification` VALUES ('104', '新会议', '10月16日,从10时48分到16时45分在逸夫楼604,您需要参加 \"1111\"会议，请您做好与会准备', '未读', '28');
INSERT INTO `notification` VALUES ('105', '审核结果', '主题为\"1111\"的会议预约已通过', '已读', '28');
INSERT INTO `notification` VALUES ('106', '报修', '您关于机电楼104的打印机，设备编号为17的报修已成功处理，感谢您的反馈', '已读', '10');
INSERT INTO `notification` VALUES ('107', '请假结果', '恭喜，您的会议主题为srtp开会的会议请假申请已通过', '未读', '14');

-- ----------------------------
-- Table structure for participates
-- ----------------------------
DROP TABLE IF EXISTS `participates`;
CREATE TABLE `participates` (
  `user_id` varchar(10) NOT NULL,
  `meeting_id` int(11) NOT NULL,
  `participants_status` char(10) NOT NULL,
  PRIMARY KEY (`user_id`,`meeting_id`),
  KEY `FK_participates2` (`meeting_id`),
  CONSTRAINT `FK_participates` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_participates2` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of participates
-- ----------------------------
INSERT INTO `participates` VALUES ('00000009', '21', '出席');
INSERT INTO `participates` VALUES ('00000009', '22', '出席');
INSERT INTO `participates` VALUES ('00000009', '23', '出席');
INSERT INTO `participates` VALUES ('00000009', '24', '出席');
INSERT INTO `participates` VALUES ('00000010', '21', '出席');
INSERT INTO `participates` VALUES ('00000010', '22', '出席');
INSERT INTO `participates` VALUES ('00000010', '23', '出席');
INSERT INTO `participates` VALUES ('00000010', '24', '出席');
INSERT INTO `participates` VALUES ('00000011', '21', '出席');
INSERT INTO `participates` VALUES ('00000011', '22', '出席');
INSERT INTO `participates` VALUES ('00000011', '23', '出席');
INSERT INTO `participates` VALUES ('00000011', '24', '出席');
INSERT INTO `participates` VALUES ('10000001', '14', '出席');
INSERT INTO `participates` VALUES ('10000001', '18', '出席');
INSERT INTO `participates` VALUES ('10000001', '25', '出席');
INSERT INTO `participates` VALUES ('10000001', '26', '出席');
INSERT INTO `participates` VALUES ('10000001', '27', '出席');
INSERT INTO `participates` VALUES ('10000001', '28', '出席');
INSERT INTO `participates` VALUES ('10000002', '14', '请假');
INSERT INTO `participates` VALUES ('10000002', '18', '出席');
INSERT INTO `participates` VALUES ('10000002', '25', '申请请假中');
INSERT INTO `participates` VALUES ('10000002', '26', '出席');
INSERT INTO `participates` VALUES ('10000002', '28', '出席');
INSERT INTO `participates` VALUES ('10000004', '14', '出席');
INSERT INTO `participates` VALUES ('10000004', '18', '出席');
INSERT INTO `participates` VALUES ('10000004', '25', '出席');
INSERT INTO `participates` VALUES ('10000004', '26', '出席');
INSERT INTO `participates` VALUES ('10000004', '28', '出席');
INSERT INTO `participates` VALUES ('10000005', '25', '出席');
INSERT INTO `participates` VALUES ('10000005', '26', '出席');
INSERT INTO `participates` VALUES ('10000005', '28', '出席');
INSERT INTO `participates` VALUES ('10000006', '25', '出席');
INSERT INTO `participates` VALUES ('10000006', '26', '出席');
INSERT INTO `participates` VALUES ('10000006', '28', '出席');
INSERT INTO `participates` VALUES ('10000007', '18', '出席');
INSERT INTO `participates` VALUES ('10000007', '25', '出席');
INSERT INTO `participates` VALUES ('10000007', '27', '出席');
INSERT INTO `participates` VALUES ('10000008', '14', '出席');
INSERT INTO `participates` VALUES ('10000008', '18', '出席');
INSERT INTO `participates` VALUES ('10000008', '25', '出席');
INSERT INTO `participates` VALUES ('10000008', '26', '出席');
INSERT INTO `participates` VALUES ('10000008', '28', '出席');
INSERT INTO `participates` VALUES ('10000009', '18', '出席');
INSERT INTO `participates` VALUES ('10000009', '25', '出席');
INSERT INTO `participates` VALUES ('10000009', '26', '出席');
INSERT INTO `participates` VALUES ('10000009', '28', '出席');
INSERT INTO `participates` VALUES ('10000010', '18', '出席');
INSERT INTO `participates` VALUES ('10000010', '25', '出席');
INSERT INTO `participates` VALUES ('10000010', '27', '出席');
INSERT INTO `participates` VALUES ('10000011', '18', '出席');
INSERT INTO `participates` VALUES ('10000011', '25', '出席');
INSERT INTO `participates` VALUES ('10000011', '27', '出席');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `role_id` int(11) NOT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) NOT NULL,
  KEY `role_id` (`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '/user/login', '显示用户界面');
INSERT INTO `permission` VALUES ('2', '/user/main', '显示主界面');
INSERT INTO `permission` VALUES ('3', '/user/login', '显示用户界面');
INSERT INTO `permission` VALUES ('1', '/user/main', '显示主界面');

-- ----------------------------
-- Table structure for repairs
-- ----------------------------
DROP TABLE IF EXISTS `repairs`;
CREATE TABLE `repairs` (
  `equipment_id` int(11) NOT NULL,
  `repair_equipment_id` int(11) NOT NULL,
  PRIMARY KEY (`equipment_id`,`repair_equipment_id`),
  KEY `FK_repairs2` (`repair_equipment_id`),
  CONSTRAINT `FK_repairs` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`equipment_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_repairs2` FOREIGN KEY (`repair_equipment_id`) REFERENCES `repair_equipment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of repairs
-- ----------------------------
INSERT INTO `repairs` VALUES ('13', '1');
INSERT INTO `repairs` VALUES ('16', '2');
INSERT INTO `repairs` VALUES ('15', '3');
INSERT INTO `repairs` VALUES ('13', '4');
INSERT INTO `repairs` VALUES ('20', '5');
INSERT INTO `repairs` VALUES ('17', '8');
INSERT INTO `repairs` VALUES ('20', '9');
INSERT INTO `repairs` VALUES ('17', '10');

-- ----------------------------
-- Table structure for repair_equipment
-- ----------------------------
DROP TABLE IF EXISTS `repair_equipment`;
CREATE TABLE `repair_equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(10) NOT NULL,
  `repair_time` datetime NOT NULL,
  `repair_detail` varchar(100) DEFAULT NULL,
  `repair_type` char(10) NOT NULL,
  `repair_status` char(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_asks_for_repairment` (`user_id`),
  CONSTRAINT `FK_asks_for_repairment` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of repair_equipment
-- ----------------------------
INSERT INTO `repair_equipment` VALUES ('1', '10000004', '2019-06-11 10:07:06', '坏了', '维修', '未处理');
INSERT INTO `repair_equipment` VALUES ('2', '10000001', '2019-06-13 01:22:17', '有问题', '维修', '已处理');
INSERT INTO `repair_equipment` VALUES ('3', '10000002', '2019-06-13 01:22:17', '没了', '补充', '已处理');
INSERT INTO `repair_equipment` VALUES ('4', '10000002', '2019-06-13 08:25:09', '投影仪损坏', '维修', '已处理');
INSERT INTO `repair_equipment` VALUES ('5', '10000002', '2019-06-13 08:25:26', '打印机没墨水了', '补充', '已处理');
INSERT INTO `repair_equipment` VALUES ('8', '10000002', '2019-06-13 14:58:09', '没有墨水', '补充', '已处理');
INSERT INTO `repair_equipment` VALUES ('9', '10000002', '2019-06-13 16:46:38', '好像出了问题', '维修', '已处理');
INSERT INTO `repair_equipment` VALUES ('10', '10000002', '2019-06-13 18:48:15', '报修', '维修', '已处理');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` char(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '会议组织者');
INSERT INTO `role` VALUES ('2', '管理员');
INSERT INTO `role` VALUES ('3', '普通用户');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `meeting_id` int(11) NOT NULL,
  `meeting_room_id` int(11) NOT NULL,
  `begin_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  PRIMARY KEY (`meeting_id`,`meeting_room_id`),
  KEY `FK_schedule2` (`meeting_room_id`),
  CONSTRAINT `FK_schedule` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_schedule2` FOREIGN KEY (`meeting_room_id`) REFERENCES `meeting_room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('5', '7', '2019-05-30 07:00:00', '2019-05-30 08:30:00');
INSERT INTO `schedule` VALUES ('6', '7', '2019-05-30 10:00:00', '2019-05-30 11:10:00');
INSERT INTO `schedule` VALUES ('7', '8', '2019-05-30 07:00:00', '2019-05-30 08:30:00');
INSERT INTO `schedule` VALUES ('8', '8', '2019-05-30 10:00:00', '2019-05-30 11:10:00');
INSERT INTO `schedule` VALUES ('14', '7', '2019-05-30 14:00:00', '2019-05-30 18:00:00');
INSERT INTO `schedule` VALUES ('18', '8', '2019-05-30 14:00:00', '2019-05-30 15:10:00');
INSERT INTO `schedule` VALUES ('21', '7', '2019-05-30 20:00:00', '2019-05-30 21:10:00');
INSERT INTO `schedule` VALUES ('22', '7', '2019-05-30 20:00:00', '2019-05-30 21:10:00');
INSERT INTO `schedule` VALUES ('23', '7', '2019-05-30 20:00:00', '2019-05-30 21:10:00');
INSERT INTO `schedule` VALUES ('24', '7', '2019-05-30 20:00:00', '2019-05-30 21:10:00');
INSERT INTO `schedule` VALUES ('25', '7', '2019-06-13 11:50:00', '2019-06-13 13:55:00');
INSERT INTO `schedule` VALUES ('26', '8', '2019-08-13 14:59:00', '2019-08-13 16:59:00');
INSERT INTO `schedule` VALUES ('27', '7', '2019-08-13 10:12:00', '2019-08-13 15:14:00');
INSERT INTO `schedule` VALUES ('28', '7', '2018-10-16 10:48:00', '2018-10-16 16:45:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(10) NOT NULL,
  `identity_id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  `sex` char(10) NOT NULL,
  `telephone` char(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_identify` (`identity_id`),
  CONSTRAINT `FK_identify` FOREIGN KEY (`identity_id`) REFERENCES `identity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('00000009', '4', '测试0', '男', '13839991397', '9998542@qq.com', '123');
INSERT INTO `user` VALUES ('00000010', '3', '测试2', '男', '13873392397', '192315@qq.com', '123');
INSERT INTO `user` VALUES ('00000011', '3', '测试1', '女', '13873392397', '192315@qq.com', '123');
INSERT INTO `user` VALUES ('10000001', '3', '王教师', '男', '', '123', '123');
INSERT INTO `user` VALUES ('10000002', '1', '小明', '男', '1235324536', '123523454654623', '123');
INSERT INTO `user` VALUES ('10000003', '5', '超人', '男', '10286638724', '8082315@qq.com', '123');
INSERT INTO `user` VALUES ('10000004', '2', '大脸妹', '女', '13045528399', '843315@qq.com', '123');
INSERT INTO `user` VALUES ('10000005', '2', '云雀', '男', '13087495866', '843123315@qq.com', '123');
INSERT INTO `user` VALUES ('10000006', '1', '小红', '女', '13873392744', '843315@qq.com', '123');
INSERT INTO `user` VALUES ('10000007', '3', '杀老师', '男', '13873392397', '192315@qq.com', '123');
INSERT INTO `user` VALUES ('10000008', '4', '青行灯', '女', '13878792397', '874542@qq.com', '123');
INSERT INTO `user` VALUES ('10000009', '4', '夜叉', '男', '13839991397', '9998542@qq.com', '123');
INSERT INTO `user` VALUES ('10000010', '3', '李老师', '男', '13873392397', '192315@qq.com', '123');
INSERT INTO `user` VALUES ('10000011', '3', '美美老师', '女', '13873392397', '192315@qq.com', '123');

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_establish` (`user_id`),
  CONSTRAINT `FK_establish` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES ('2', '10000003', '老师组');
INSERT INTO `user_group` VALUES ('3', '10000003', '学生组');
INSERT INTO `user_group` VALUES ('4', '10000003', '信安1602');
INSERT INTO `user_group` VALUES ('5', '10000003', '物理教师组');
INSERT INTO `user_group` VALUES ('7', '10000003', '测试0');
INSERT INTO `user_group` VALUES ('12', '10000007', '阴阳师组');
INSERT INTO `user_group` VALUES ('14', '10000001', '老师组');
INSERT INTO `user_group` VALUES ('18', '10000001', '测试组');
