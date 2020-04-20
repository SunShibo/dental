/*
Navicat MySQL Data Transfer

Source Server         : wy
Source Server Version : 50727
Source Host           : 47.94.143.11:3306
Source Database       : brace

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-04-06 15:28:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章',
  `type` varchar(255) DEFAULT NULL COMMENT '分类 文章/案例',
  `img` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'article', 'https://timgsa.baidu.com/timg?image', '荒木画展', '荒木画展，看最正宗的JOJO画风，摆最帅气的JO立。', 'yes');

-- ----------------------------
-- Table structure for article_comment
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment` (
  `id` bigint(20) NOT NULL COMMENT '评论表',
  `p_id` bigint(20) DEFAULT '0' COMMENT '评论置顶 1 置顶0 普通',
  `c_id` bigint(20) DEFAULT NULL COMMENT '文章id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_comment
-- ----------------------------
INSERT INTO `article_comment` VALUES ('1', '1', '1', '1', 'no', '写的好', '2020-03-27 19:10:04');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'banner',
  `sort` int(255) DEFAULT NULL,
  `t_id` bigint(20) DEFAULT NULL COMMENT '跳转的文章id',
  `img` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------

-- ----------------------------
-- Table structure for brace
-- ----------------------------
DROP TABLE IF EXISTS `brace`;
CREATE TABLE `brace` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '牙套',
  `user_id` bigint(20) DEFAULT NULL,
  `stage` varchar(255) DEFAULT NULL COMMENT '阶段名称',
  `status` varchar(255) DEFAULT 'not' COMMENT '状态',
  `make` varchar(255) DEFAULT 'no' COMMENT '制作状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brace
-- ----------------------------
INSERT INTO `brace` VALUES ('1', '11', '阶段2', 'yes', 'yes');
INSERT INTO `brace` VALUES ('2', '11', '阶段2', 'no', 'yes');
INSERT INTO `brace` VALUES ('3', '11', '方案一', 'yes', 'no');

-- ----------------------------
-- Table structure for brace_msg
-- ----------------------------
DROP TABLE IF EXISTS `brace_msg`;
CREATE TABLE `brace_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '方案详情',
  `b_id` bigint(20) DEFAULT NULL COMMENT '方案id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `num` int(11) DEFAULT NULL COMMENT '佩戴天数',
  `start_time` date DEFAULT NULL COMMENT '开始时间',
  `end_time` date DEFAULT NULL COMMENT '结束时间',
  `status` varchar(255) DEFAULT 'yes' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brace_msg
-- ----------------------------
INSERT INTO `brace_msg` VALUES ('1', '1', '第一副', '10', '2020-02-01', '2020-02-11', 'yes');
INSERT INTO `brace_msg` VALUES ('2', '1', '第二副', '10', '2020-02-15', '2020-02-25', 'yes');
INSERT INTO `brace_msg` VALUES ('3', '1', '第三副', '10', '2020-02-26', '2020-03-07', 'yes');
INSERT INTO `brace_msg` VALUES ('4', '1', '第四副', '24', '2020-03-07', '2020-03-31', 'yes');
INSERT INTO `brace_msg` VALUES ('5', '2', '啊啊啊', '5', '2020-04-04', '2020-04-09', 'yes');
INSERT INTO `brace_msg` VALUES ('6', '1', '第六副', '15', '2020-04-15', '2020-04-30', 'yes');
INSERT INTO `brace_msg` VALUES ('7', '2', '啊啊啊', '2', '2020-01-04', '2020-01-06', 'yes');
INSERT INTO `brace_msg` VALUES ('10', '2', '第一套', '10', '2020-04-03', '2020-04-13', 'no');
INSERT INTO `brace_msg` VALUES ('11', '2', '第一套', '10', '2020-04-03', '2020-04-13', 'yes');
INSERT INTO `brace_msg` VALUES ('12', '2', '第一套', '10', '2020-04-04', '2020-04-14', 'yes');

-- ----------------------------
-- Table structure for consult
-- ----------------------------
DROP TABLE IF EXISTS `consult`;
CREATE TABLE `consult` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `read` varchar(255) DEFAULT NULL,
  `cation` varchar(255) DEFAULT NULL COMMENT '标识',
  `doctor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consult
-- ----------------------------
INSERT INTO `consult` VALUES ('1', '11', 'no', '2020-03-31 15:39:52', 'sdfas', 'yes', 'user', '11');
INSERT INTO `consult` VALUES ('2', '11', 'yes', '2020-03-31 15:40:33', '内容', 'no', 'user', '11');
INSERT INTO `consult` VALUES ('3', '11', 'yes', '2020-03-31 07:40:59', '咋回事啊，睡了一觉牙套松了', 'no', 'user', '1');
INSERT INTO `consult` VALUES ('4', '11', 'yes', '2020-03-31 07:42:23', '咋回事啊，睡了一觉牙套松了', 'no', 'user', '1');

-- ----------------------------
-- Table structure for consult_img
-- ----------------------------
DROP TABLE IF EXISTS `consult_img`;
CREATE TABLE `consult_img` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '咨询图片',
  `c_id` bigint(20) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consult_img
-- ----------------------------

-- ----------------------------
-- Table structure for dynamic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '动态方案',
  `user_id` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '类型 front正面 ，left左面 ，right右面 above上面，below下面',
  `img` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `create_time` datetime DEFAULT NULL,
  `sort` bigint(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
INSERT INTO `dynamic` VALUES ('1', '1', 'front', 'http://localhost/123.jpg', '2020-03-29 08:42:34', '1');

-- ----------------------------
-- Table structure for inform
-- ----------------------------
DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) DEFAULT NULL COMMENT '已读/未读',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inform
-- ----------------------------
INSERT INTO `inform` VALUES ('1', '11', '2020-03-30 08:49:42', 'no', '腾讯游戏用钱创造快乐');

-- ----------------------------
-- Table structure for scheme
-- ----------------------------
DROP TABLE IF EXISTS `scheme`;
CREATE TABLE `scheme` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '方案',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `img` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scheme
-- ----------------------------

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES ('1', '666666', '系统', 'f379eaf3c831b04de153469d1bec345e', '1', 'yes');

-- ----------------------------
-- Table structure for sys_key_value
-- ----------------------------
DROP TABLE IF EXISTS `sys_key_value`;
CREATE TABLE `sys_key_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '医生',
  `key` varchar(255) DEFAULT NULL,
  `values` varchar(255) DEFAULT NULL COMMENT '姓名',
  `comment` varchar(255) DEFAULT NULL COMMENT '医疗机构',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_key_value
-- ----------------------------
INSERT INTO `sys_key_value` VALUES ('1', 'head', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2263384027,3593909578', '默认头像');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单',
  `menu_name` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `url` varchar(5000) DEFAULT NULL,
  `index` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', 'Banner管理', '0', '/', '1', null);
INSERT INTO `sys_menu` VALUES ('2', 'Banner管理', '1', '/', '2', null);
INSERT INTO `sys_menu` VALUES ('3', '系统设置', '0', '/', '3', null);
INSERT INTO `sys_menu` VALUES ('4', '管理人员列表', '3', '/admin/adminRegister,/admin/changePassword,/admin/updateAdminUser,/admin/delAdmins,/admin/getAdminById,', '4', null);
INSERT INTO `sys_menu` VALUES ('5', '角色列表', '3', '/admin/delRoleByIds,/admin/grantAuthority,/admin/getAllRoleMenu,/admin/addRoleGrantAuthority,', '5', null);
INSERT INTO `sys_menu` VALUES ('6', '参数配置', '0', '/', '6', null);
INSERT INTO `sys_menu` VALUES ('7', '参数配置', '6', '/', '7', null);
INSERT INTO `sys_menu` VALUES ('8', '用户管理', '0', '/', '8', null);
INSERT INTO `sys_menu` VALUES ('9', '用户列表', '8', '/', '9', null);
INSERT INTO `sys_menu` VALUES ('10', '说说管理', '9', '/', '10', null);
INSERT INTO `sys_menu` VALUES ('11', '文章管理', '0', '/', '11', null);
INSERT INTO `sys_menu` VALUES ('12', '科普案例', '11', '/', '12', null);
INSERT INTO `sys_menu` VALUES ('13', '医生管理', '0', '/', '13', null);
INSERT INTO `sys_menu` VALUES ('14', '医生列表', '13', '/', '14', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '2020-03-27 15:03:51', null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(255) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1', null, null);
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2', null, null);
INSERT INTO `sys_role_menu` VALUES ('3', '1', '3', null, null);
INSERT INTO `sys_role_menu` VALUES ('4', '1', '4', null, null);
INSERT INTO `sys_role_menu` VALUES ('5', '1', '5', null, null);
INSERT INTO `sys_role_menu` VALUES ('6', '1', '6', null, null);
INSERT INTO `sys_role_menu` VALUES ('7', '1', '7', null, null);
INSERT INTO `sys_role_menu` VALUES ('8', '1', '8', null, null);
INSERT INTO `sys_role_menu` VALUES ('9', '1', '9', null, null);
INSERT INTO `sys_role_menu` VALUES ('10', '1', '10', null, null);
INSERT INTO `sys_role_menu` VALUES ('11', '1', '11', null, null);
INSERT INTO `sys_role_menu` VALUES ('12', '1', '12', null, null);
INSERT INTO `sys_role_menu` VALUES ('13', '1', '13', null, null);
INSERT INTO `sys_role_menu` VALUES ('14', '1', '14', null, null);
INSERT INTO `sys_role_menu` VALUES ('15', '1', '15', null, null);

-- ----------------------------
-- Table structure for talk
-- ----------------------------
DROP TABLE IF EXISTS `talk`;
CREATE TABLE `talk` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '说说',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) DEFAULT 'yes' COMMENT '状态',
  `user_id` bigint(20) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_head` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of talk
-- ----------------------------
INSERT INTO `talk` VALUES ('1', '今天走路牙卡丢了一个，不用花钱拔牙了，好开心！', '2020-03-30 06:33:42', 'yes', '11', '用户_15214440324', null);

-- ----------------------------
-- Table structure for talk_comment
-- ----------------------------
DROP TABLE IF EXISTS `talk_comment`;
CREATE TABLE `talk_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论表',
  `t_id` bigint(11) DEFAULT NULL COMMENT '说说id',
  `content` varchar(2000) DEFAULT NULL COMMENT '评论内容',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '评论用户名',
  `user_head` varchar(255) DEFAULT NULL COMMENT '评论的用户头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) DEFAULT 'yes',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of talk_comment
-- ----------------------------
INSERT INTO `talk_comment` VALUES ('1', '1', '哈哈哈，楼主真是个小天才!', '11', '用户_15214440324', null, '2020-03-30 07:03:42', 'yes');

-- ----------------------------
-- Table structure for talk_img
-- ----------------------------
DROP TABLE IF EXISTS `talk_img`;
CREATE TABLE `talk_img` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `t_id` bigint(20) DEFAULT NULL COMMENT '说说Id',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of talk_img
-- ----------------------------
INSERT INTO `talk_img` VALUES ('1', '1', '图片1');
INSERT INTO `talk_img` VALUES ('2', '1', '图片2');
INSERT INTO `talk_img` VALUES ('3', '1', '图片3');

-- ----------------------------
-- Table structure for talk_like
-- ----------------------------
DROP TABLE IF EXISTS `talk_like`;
CREATE TABLE `talk_like` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户点赞',
  `c_id` bigint(20) DEFAULT NULL COMMENT '说说id',
  `user_id` bigint(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of talk_like
-- ----------------------------
INSERT INTO `talk_like` VALUES ('1', '1', '11');

-- ----------------------------
-- Table structure for talk_reply
-- ----------------------------
DROP TABLE IF EXISTS `talk_reply`;
CREATE TABLE `talk_reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '说说评论回复',
  `c_id` bigint(11) DEFAULT NULL COMMENT '评论id',
  `replay_id` bigint(20) DEFAULT NULL COMMENT '回复用户id',
  `replay_name` varchar(255) DEFAULT NULL COMMENT '回复目标用户名',
  `replay_head` varchar(255) DEFAULT NULL COMMENT '回复目标用户头像',
  `content` varchar(2000) DEFAULT NULL COMMENT '回复内容',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_head` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of talk_reply
-- ----------------------------
INSERT INTO `talk_reply` VALUES ('1', '1', '11', '小汶', '1.png', '哈哈哈', '11', '用户_15214440324', null, '2020-03-30 07:25:03');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `region` varchar(255) DEFAULT NULL COMMENT '地区',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `organ` varchar(255) DEFAULT NULL COMMENT '机构',
  `diagnose` varchar(255) DEFAULT NULL COMMENT '诊断 多个用 ，分割 ',
  `create_time` datetime DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL COMMENT '密码',
  `wxid` varchar(255) DEFAULT NULL COMMENT '微信id',
  `doctor_id` bigint(20) DEFAULT NULL COMMENT '医生id',
  `state` varchar(255) DEFAULT 'underway' COMMENT '诊断状态 ''underway'' 进行中 accomplish完成',
  `head` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT 'yes' COMMENT '账号状态',
  `doctor` varchar(255) DEFAULT 'no' COMMENT '是否是医生',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小汶', '15214440324', '男', null, '北京', '1997-12-01', '北京医疗小组', '需去釉，需拔牙', '2020-03-28 17:15:21', null, null, '11', 'underway', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2263384027,3593909578&fm=26&gp=0.jpg', 'yes', 'no');
INSERT INTO `user` VALUES ('12', '张三', '12345678901', '男', null, '北京', '1997-12-01', '北京医疗小组', '', '2020-03-28 17:15:21', null, null, null, '', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2263384027,3593909578&fm=26&gp=0.jpg', 'yes', 'yes');
