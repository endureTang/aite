/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : nj_server

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2020-07-16 16:54:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for nj_coporate
-- ----------------------------
DROP TABLE IF EXISTS `nj_coporate`;
CREATE TABLE `nj_coporate` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) DEFAULT NULL COMMENT '所有父级编号',
  `compan_code` varchar(64) DEFAULT NULL,
  `compan_name` varchar(100) NOT NULL COMMENT '名称',
  `area_id` varchar(64) DEFAULT NULL COMMENT '归属区域',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `busi_license_no` varchar(64) DEFAULT NULL COMMENT '排序',
  `tax_no` varchar(64) DEFAULT NULL COMMENT '机构类型',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `bank_no` varchar(32) DEFAULT NULL,
  `account_type` int(11) DEFAULT NULL,
  `sms_code` varchar(20) DEFAULT NULL,
  `zip_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `master` varchar(100) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `status` varchar(64) DEFAULT NULL COMMENT '是否启用',
  `primary_person` varchar(64) DEFAULT NULL COMMENT '主负责人',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `org_code` varchar(64) DEFAULT NULL,
  `regis_Type` int(1) DEFAULT NULL,
  `regis_per_name` varchar(32) DEFAULT NULL,
  `regis_per_idenno` varchar(64) DEFAULT NULL,
  `channel_code` varchar(10) DEFAULT NULL,
  `merchant_no` varchar(20) DEFAULT NULL,
  `balance_type` int(11) DEFAULT NULL,
  `balance_value` varchar(10) DEFAULT NULL,
  `max_credit_limit` double(19,0) DEFAULT NULL COMMENT '最大授信额度',
  `pay_channel` int(11) DEFAULT NULL COMMENT '支付渠道(1:金鼎支付; 2:兴业存管)',
  `capital_end_channel` int(11) DEFAULT NULL COMMENT '资产推送渠道(1:小贷资金;2:p2p募集资金)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构表';

-- ----------------------------
-- Records of nj_coporate
-- ----------------------------
INSERT INTO `nj_coporate` VALUES ('de48a37349524bfba310582397364d3f', null, null, '1000', '四川金鼎财富信息技术有限公司', null, null, null, null, '丹枫国际', null, null, null, null, null, null, null, null, null, null, '18380398760', '2017-04-06 19:03:44', null, null, null, '0', null, null, null, null, null, null, null, null, '0', '2', '2');

-- ----------------------------
-- Table structure for nj_strategy
-- ----------------------------
DROP TABLE IF EXISTS `nj_strategy`;
CREATE TABLE `nj_strategy` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '策略名',
  `source` varchar(50) NOT NULL COMMENT '订单来源标识符TM、SS、KR等',
  `del_flag` smallint(2) NOT NULL DEFAULT '0' COMMENT '删除标识 0：未删除 1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nj_strategy
-- ----------------------------
INSERT INTO `nj_strategy` VALUES ('1', 'TM拆分逻辑', 'TM', '0');

-- ----------------------------
-- Table structure for nj_strategy_dict
-- ----------------------------
DROP TABLE IF EXISTS `nj_strategy_dict`;
CREATE TABLE `nj_strategy_dict` (
  `id` varchar(32) NOT NULL,
  `dict_id` varchar(32) NOT NULL,
  `strategy_id` varchar(32) NOT NULL,
  `match_word` varchar(100) NOT NULL COMMENT '反馈订单模块（策略）匹配字符',
  `status` smallint(2) NOT NULL DEFAULT '0' COMMENT '状态：0：未启用，1：启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nj_strategy_dict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label_text` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '父级编号',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `type_index` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('065019bb473f4f1a95923ed9d94a8c32', '数量', '数量', 'name', '数量', '6', null, 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 17:02:19', 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 17:02:19', null, '0');
INSERT INTO `sys_dict` VALUES ('0de9f29c5dab4a2c88da70e2a569342b', '运费', '运费', 'name', '运费', '5', null, 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 17:02:06', 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 17:02:06', null, '0');
INSERT INTO `sys_dict` VALUES ('db7dae63fafc465ea9118d8eef9e327a', '原始订单号', '原始订单号', 'name', '原始订单号', '2', null, 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 17:01:13', 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 17:01:13', null, '0');
INSERT INTO `sys_dict` VALUES ('dbf2309d20414b598fb44af3ca6615fd', '物流方式', '物流方式', 'name', '物流方式', '3', null, 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 17:01:21', 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 17:01:21', null, '0');
INSERT INTO `sys_dict` VALUES ('f2a611bb926e46afab12e8d8e81d4259', '物流单号', '物流单号', 'name', '物流单号', '4', null, 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 17:01:36', 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 17:01:36', null, '0');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(32) NOT NULL,
  `remote_addr` varchar(64) DEFAULT NULL,
  `user_agent` char(10) DEFAULT NULL,
  `title` varchar(256) DEFAULT NULL,
  `params` text,
  `request_uri` varchar(64) DEFAULT NULL,
  `method` varchar(5) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `request_id` varchar(32) DEFAULT NULL,
  `request_date` datetime DEFAULT NULL,
  `log_type` int(11) DEFAULT NULL,
  `exception` text,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` int(10) NOT NULL COMMENT '排序',
  `href` varchar(2000) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `is_show` char(1) NOT NULL COMMENT '1:管理后台资源。2、3：业务后台资源',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '0', '0', '用户管理', '1', '#', null, null, '1', null, '', '2017-02-16 13:53:20', '', '2017-02-16 13:53:24', null, '0');
INSERT INTO `sys_resource` VALUES ('2', '0', '0', '业务管理', '2', '#', null, null, '1', null, '', '2018-06-01 10:28:44', 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 14:54:38', '', '0');
INSERT INTO `sys_resource` VALUES ('3', '0', '0', '系统设置', '3', '#', null, null, '1', null, '', '2017-02-16 14:35:52', '', '2017-02-16 14:35:55', null, '0');
INSERT INTO `sys_resource` VALUES ('32c3636de60fa796993b8f5031abea21', '3', '3', '字典列表', '3', '/dict/page', null, null, '1', null, 'system', '2018-06-13 18:21:31', 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 14:52:34', '', '0');
INSERT INTO `sys_resource` VALUES ('39c544fef937eb120e69453fb94171ed', '3', '3', '策略列表', '0', '/strategy/page', null, null, '1', null, 'system', '2020-07-16 15:10:20', 'system', '2020-07-16 15:10:20', null, '0');
INSERT INTO `sys_resource` VALUES ('3f00b3304d566b2d515f9e61f8faf422', '2', '2', '反馈订单', '0', '/file/upload', null, null, '1', null, 'system', '2020-07-15 15:17:21', 'system', '2020-07-15 15:17:21', null, '0');
INSERT INTO `sys_resource` VALUES ('a08865397e3ab55b0da82f7fd4c4143f', '3', '3', '角色管理', '2', '/role/page', null, null, '1', null, 'system', '2018-06-13 18:21:31', 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 14:52:20', '', '0');
INSERT INTO `sys_resource` VALUES ('dbf733f1f7c56c7d4e46e97568983961', '1', '1', '管理用户', '0', '/sysUser/list', null, null, '1', null, 'system', '2018-06-13 18:21:31', 'system', '2018-06-13 18:21:31', null, '0');
INSERT INTO `sys_resource` VALUES ('e1ad3ec16699723c0da9f4b3d2837a95', '3', '3', '菜单管理', '1', '/right/menu', null, null, '1', null, 'system', '2018-06-13 18:21:31', 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 14:51:22', '', '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `type` int(2) DEFAULT '2' COMMENT '类型（1：管理后台，2：业务后台）',
  `office_id` varchar(64) DEFAULT NULL COMMENT '归属机构',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `enname` varchar(255) DEFAULT NULL COMMENT '英文名称',
  `role_type` varchar(255) DEFAULT NULL COMMENT '角色类型',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围',
  `is_sys` varchar(64) DEFAULT NULL COMMENT '是否系统数据',
  `useable` varchar(64) DEFAULT NULL COMMENT '是否可用',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '', '系统管理员', 'dept', 'businessCommissioner', '1', '1', '1', '1', '2013-05-27 08:00:00', '1', '2020-07-15 14:39:04', '系统管理员', '0');
INSERT INTO `sys_role` VALUES ('c0a23f9e4e01496382f4c1ec8ed8cd74', '1', '', '业务', null, 'normal', null, null, null, 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 14:43:51', 'f22a9c5e72814e3cac7ef8fa50db97b5', '2020-07-15 14:43:51', '', '0');
INSERT INTO `sys_role` VALUES ('d278a07415134ea1aff1dd68df9ad35c', '1', null, '管理后台账号', null, null, null, null, null, '1', '2018-06-07 10:55:01', '1', '2018-06-07 10:55:01', '多福多寿', '0');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `menu_id` varchar(64) NOT NULL COMMENT '菜单编号',
  `id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('1', '1', '1');
INSERT INTO `sys_role_resource` VALUES ('1', '2', '2');
INSERT INTO `sys_role_resource` VALUES ('1', '3', '3');
INSERT INTO `sys_role_resource` VALUES ('b485c55da8b04342bd13315924b60a90', '1', null);
INSERT INTO `sys_role_resource` VALUES ('b485c55da8b04342bd13315924b60a90', 'a36a114ef5a85de8885a84e49a599058', null);
INSERT INTO `sys_role_resource` VALUES ('c0a23f9e4e01496382f4c1ec8ed8cd74', '2', null);
INSERT INTO `sys_role_resource` VALUES ('c0a23f9e4e01496382f4c1ec8ed8cd74', '3', null);
INSERT INTO `sys_role_resource` VALUES ('c0a23f9e4e01496382f4c1ec8ed8cd74', '32c3636de60fa796993b8f5031abea21', null);
INSERT INTO `sys_role_resource` VALUES ('c0a23f9e4e01496382f4c1ec8ed8cd74', '39c544fef937eb120e69453fb94171ed', null);
INSERT INTO `sys_role_resource` VALUES ('c0a23f9e4e01496382f4c1ec8ed8cd74', '3f00b3304d566b2d515f9e61f8faf422', null);
INSERT INTO `sys_role_resource` VALUES ('d278a07415134ea1aff1dd68df9ad35c', '1', null);
INSERT INTO `sys_role_resource` VALUES ('d278a07415134ea1aff1dd68df9ad35c', '2', null);
INSERT INTO `sys_role_resource` VALUES ('d278a07415134ea1aff1dd68df9ad35c', '3', null);
INSERT INTO `sys_role_resource` VALUES ('d278a07415134ea1aff1dd68df9ad35c', '32c3636de60fa796993b8f5031abea21', null);
INSERT INTO `sys_role_resource` VALUES ('d278a07415134ea1aff1dd68df9ad35c', '7f852582588b701a6bcbff69e5515168', null);
INSERT INTO `sys_role_resource` VALUES ('d278a07415134ea1aff1dd68df9ad35c', 'a08865397e3ab55b0da82f7fd4c4143f', null);
INSERT INTO `sys_role_resource` VALUES ('d278a07415134ea1aff1dd68df9ad35c', 'a36a114ef5a85de8885a84e49a599058', null);
INSERT INTO `sys_role_resource` VALUES ('d278a07415134ea1aff1dd68df9ad35c', 'dbf733f1f7c56c7d4e46e97568983961', null);
INSERT INTO `sys_role_resource` VALUES ('d278a07415134ea1aff1dd68df9ad35c', 'e1ad3ec16699723c0da9f4b3d2837a95', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `company_id` varchar(64) NOT NULL COMMENT '归属公司',
  `office_id` varchar(64) NOT NULL COMMENT '归属部门',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `no` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  `photo` varchar(1000) DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_flag` varchar(64) DEFAULT NULL COMMENT '是否可登录',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', '2', 'admin', '0e3afcb838100d8c3dc928af74954110123f5cbc', '0001', '系统管理员', 'thinkgem@163.com', '8675', '8675', '', '', '0:0:0:0:0:0:0:1', '2020-07-16 15:34:01', '1', '1', '2013-05-27 08:00:00', '1', '2018-02-24 10:54:18', '最高管理员', '0');
INSERT INTO `sys_user` VALUES ('17838e0731a945fbbb9dd768e5db95b9', '231f0babdad4454b96e607f2f62c6ff4', '', 'datastat', '0e3afcb838100d8c3dc928af74954110123f5cbc', null, '数据统计', null, '15812345670', null, null, null, null, '2020-07-13 16:40:50', null, 'admin', '2018-11-21 09:44:50', 'admin', '2018-11-21 09:44:50', '数据统计', '0');
INSERT INTO `sys_user` VALUES ('ef6d091542f64dfeb7e18b53a107bac5', '231f0babdad4454b96e607f2f62c6ff4', '', 'zhangsan', 'e4ebb42aaa236ed561134b22a64314b7e8a9c9b1', null, '张三', null, '15111111111', null, null, null, null, '2020-07-16 16:27:20', null, 'administrator', '2020-07-15 14:44:27', 'administrator', '2020-07-15 14:44:27', '', '0');
INSERT INTO `sys_user` VALUES ('f22a9c5e72814e3cac7ef8fa50db97b5', '1', '2', 'administrator', '0e3afcb838100d8c3dc928af74954110123f5cbc', '999', '管理员', '123@qq.com', '15888888888', '', '1', '', '0:0:0:0:0:0:0:1', '2020-07-16 15:35:02', '1', '1', '2017-01-05 16:57:05', '1', '2017-01-05 16:57:05', '系统管理员', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(64) NOT NULL COMMENT '用户编号',
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `coporate_id` varchar(32) NOT NULL,
  `id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`role_id`,`coporate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('', '', '1a7204310a9344d4935a92a24bd30719', '2a9c3dc57ddb499b894e111b77c55148');
INSERT INTO `sys_user_role` VALUES ('', '', '1feefe45896948678d1c7288f93e3c24', 'b937a3aced6a44d29cfdc5596944c934');
INSERT INTO `sys_user_role` VALUES ('', '', '4fbc8346aa144a75a827255b862409f0', 'd5cda78edd3945d7a609d76636dccba4');
INSERT INTO `sys_user_role` VALUES ('', '', '5e776ab4e4fd46e499e25f57579dd9b1', '55aee82ae0184278a2d373c55a54d2e6');
INSERT INTO `sys_user_role` VALUES ('', '', '684100f998444e75b327afdb8fb9499f', '553a76e156084d3fac62a131dd96c851');
INSERT INTO `sys_user_role` VALUES ('', '', '92dd6f9239bb4304b824f80105181785', '3c7b60e2a38044a1a4703f8eaa4c13b0');
INSERT INTO `sys_user_role` VALUES ('', '', '9c64aa23a9f541d483489e1f67152d5d', '15d741bcc80f40fa808c0d22eb1b827c');
INSERT INTO `sys_user_role` VALUES ('', '', 'b4d3752f0d61459ba73fe2835bff11f1', '090e29f8513b4ac4aa215ae427b385e0');
INSERT INTO `sys_user_role` VALUES ('', '', 'bfe8c6d1f4b8436db11539701e3c7295', '4ad07fc78b6e4686ab6d8a87b62e5026');
INSERT INTO `sys_user_role` VALUES ('', '', 'c2ff93a643e546ff837f5cda1071b892', 'f690eac6b00a4818851193cffe2edeb0');
INSERT INTO `sys_user_role` VALUES ('', '', 'd3968ab8d63e4560bf7a64bd1d0f3898', '862937b61333428d831269f6646c4c81');
INSERT INTO `sys_user_role` VALUES ('', '', 'ebdfe346fd4c4d57a736bb35731ac080', 'cc012dd78c7144229df95559fa0c7b08');
INSERT INTO `sys_user_role` VALUES ('', '', 'eeeb6036b19840d8891b41c398a01cf3', 'cdcd1961dff04fc1ac41fde2afe8af68');
INSERT INTO `sys_user_role` VALUES ('', '', 'f2af49df438e4e51ab1e89d0fa2be240', '503f5d7cbea74693a17a4aad91b8c463');
INSERT INTO `sys_user_role` VALUES ('', '4', '0191bd738ec74acbb84f1c4ec6519e76', '58bad08a3ecb4c628186e6a5e79e63c2');
INSERT INTO `sys_user_role` VALUES ('', '4', '0411360c0bca4348841f8695b33fa966', 'f9f49969a1eb4284acfe85fc99b8f0f9');
INSERT INTO `sys_user_role` VALUES ('', '4', '1b41bb1347e541619ec2bf88c1d8f369', '1d1f2ea4ab094a4bac8fbb5068ffdcff');
INSERT INTO `sys_user_role` VALUES ('', '4', '24e7f053439f4b4db6170fac037000a7', '37efe5174b8c42d9bb0428ef63431980');
INSERT INTO `sys_user_role` VALUES ('', '4', '33bcfcbb240048ab81dc3521290461a5', 'f187ba92061b40928436ac4ca4195ce0');
INSERT INTO `sys_user_role` VALUES ('', '4', '3a0fd14ccedf46f48aaa7423a815b211', '404e1adde99147728c53e355b8766957');
INSERT INTO `sys_user_role` VALUES ('', '4', '3e51ad9281f74cdfb7d0087687370093', '26662172b1a145f595147bd34bbc2326');
INSERT INTO `sys_user_role` VALUES ('', '4', '406bb3fe07e94208b61ee403d7fa9b54', '00c2ffad1c624cf7896d8480b69834d3');
INSERT INTO `sys_user_role` VALUES ('', '4', '48b1d2f90862423dbe885e3e3fa91d55', '6ebafa862ee14c07a3baa56c08976844');
INSERT INTO `sys_user_role` VALUES ('', '4', '4b2ee924084a410fbb8dee369469a693', '292fa17016c94ae2b3b97759a2e5dbae');
INSERT INTO `sys_user_role` VALUES ('', '4', '5813548b18fb4d70a78c87e1a3faa1d6', 'e2c6dbe6760b48f9b3cae7a8e222a4fa');
INSERT INTO `sys_user_role` VALUES ('', '4', '63de9c9b11a84abd95a661ea6882040a', '2ac651aaabe5405c8a68b7c374ecb8d1');
INSERT INTO `sys_user_role` VALUES ('', '4', 'bb7d321b618b4230b2194841fe7a1323', '8746def8a77344dd9c78fe3edc7b0004');
INSERT INTO `sys_user_role` VALUES ('', '4', 'c394cab900a244d7a126bf9e2360c71c', '2f3b17d1fe72416aad523e08dd3cf562');
INSERT INTO `sys_user_role` VALUES ('', '4', 'f0e00761200149c99f16e1614ff8ba47', 'c1ea478be5dd4adf97f685ef1c273f44');
INSERT INTO `sys_user_role` VALUES ('', '4', 'fe4a3f20f4744aa09c4bc5b10d0d4190', '23e1fcd886564b92b30edacd68d7e6ac');
INSERT INTO `sys_user_role` VALUES ('', 'b2c12cfffbaa4de8a988f2e555b0c0e6', 'fcf3d335f3ad4df78d42074cb7559075', '403a8413f52648368f2e488bd89d7cc6');
INSERT INTO `sys_user_role` VALUES ('-1', '2', '', '2');
INSERT INTO `sys_user_role` VALUES ('0283b9cd3fea433cad9e72ff70f29bd4', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', 'a9b85212b01c4c499c89c1adef528fa4');
INSERT INTO `sys_user_role` VALUES ('0337b991d27b45749e7e303d16d62631', 'dd05adfbb76d48879af046847afabe23', 'de48a37349524bfba310582397364d3f', '2c8707dc192b4a8bb1b5837972b0a855');
INSERT INTO `sys_user_role` VALUES ('036ee1013b944e1aa62c6f12ea27a715', '4916cb14c13a423f97d666a175595645', 'd99a1ee29a874d46845c6e9f3ad80f61', 'a3752d1d7f8841c4bf56d7697b1422f1');
INSERT INTO `sys_user_role` VALUES ('044c42cd181b4aa9a999038061633c63', '4', '', 'ceec072f87f8464fbf3fbf29f8dec374');
INSERT INTO `sys_user_role` VALUES ('05694bc472764f0eaa622e994a4c0d7e', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '304186268b1f4564b05fb496b7bca00b');
INSERT INTO `sys_user_role` VALUES ('06a8744c786a4617ba9dad005accc2e8', '4', '', '742e8aadb35d4a6685b8cc921bf82397');
INSERT INTO `sys_user_role` VALUES ('07180cccb49c4d818938ba175146dc08', '4', 'e62ace3781e34aa49533ad82a25f09eb', '9185bb154d5b477aa7cb9ae1155610a2');
INSERT INTO `sys_user_role` VALUES ('0814bcb397804c50987aa0fb80b15aa9', '815808c9438a4277b02891c82232c825', '231f0babdad4454b96e607f2f62c6ff4', 'e4faa1fe01a14790ab99ef7754710eac');
INSERT INTO `sys_user_role` VALUES ('0849f22222eb4e0da85cd6913278c05a', '3af5e9ba22fa43d2b1a8c778263da0b8', '1a1e2a243d304ff6bce0bc17f0512b67', '50212605609e490aab75e13feb764a69');
INSERT INTO `sys_user_role` VALUES ('09a531b2606d486c854fd62f907dbaef', '67533a14acf041d9b6a8c971ed62c362', 'ceb02eb6cb234e6098ce75c36dca5563', '1dc736110c7d4b01ac94c439cbf75e06');
INSERT INTO `sys_user_role` VALUES ('0a5bb4823a384f4687a56a5d106aa8b2', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', '438b5aec3e4943af8f693108dac87fcc');
INSERT INTO `sys_user_role` VALUES ('0b071d1e8fc7472bad562aac5038cafc', '428ca3c433554b329ea35807f1ee010e', '42073f221b984a53877c0b0840cacc05', 'dfb7beb0184643779f7424f7bddb3f03');
INSERT INTO `sys_user_role` VALUES ('0b7476b4429245e2941688f9d4b1ba80', '044595d92c0049ce9c82d66e453715a4', 'a06c8be19be14ab79f232012132384ab', '4f9da6513d1747d194226e1802e918b3');
INSERT INTO `sys_user_role` VALUES ('0ba6785345c645149ae88cb43940497f', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '2333fcab250541ae8e8a37ade6c60f24');
INSERT INTO `sys_user_role` VALUES ('0c2563bdd7f54f8aa46ac40825377785', 'ef309dba67744ad39af835efbeeb31e0', '1a1e2a243d304ff6bce0bc17f0512b67', '482f50d1ba8942a4b635bbf503346fe6');
INSERT INTO `sys_user_role` VALUES ('0cf64450616348988aa21b84a764beb9', '710b3aac9bfd4ab0aaed5aa50e51f8ab', 'de48a37349524bfba310582397364d3f', 'd1df3f11b6914656bd33f213d77277b7');
INSERT INTO `sys_user_role` VALUES ('0d431f0d03d342b8b8635374ca511f83', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', '3127fe5ebc6943739a90b82ae5e2f1ed');
INSERT INTO `sys_user_role` VALUES ('0d5f3aa85a2949be942a98808414a3f1', '1120d9317a4e4bc2909947caac837d0d', '42073f221b984a53877c0b0840cacc05', '7c3b6df4885f434e84703a19355c571c');
INSERT INTO `sys_user_role` VALUES ('0d98de2a993349d69f3acd8c508aa1a2', '4ef553d147ea4348a72c47dd7a544645', 'd954a734d92d4dc1a21a974533fa4b31', '977b0c4864c440d6bfe4a24f42523615');
INSERT INTO `sys_user_role` VALUES ('0e330174a80a48bfa0739b720e088f41', '4', '', '7565927cc3cd4f2e983b4e7f16d776c9');
INSERT INTO `sys_user_role` VALUES ('1', '1', '', '1');
INSERT INTO `sys_user_role` VALUES ('10', '2', '', '3');
INSERT INTO `sys_user_role` VALUES ('11', '3', '', '4');
INSERT INTO `sys_user_role` VALUES ('12', '4', '', '5');
INSERT INTO `sys_user_role` VALUES ('12faefa6a4244dfdaeeccb9abf7fef60', '2', 'fe73748e52914fefb9da4dbd66f91c6d', '28eeb54a3adb4e5987683c331cabdcfc');
INSERT INTO `sys_user_role` VALUES ('12faefa6a4244dfdaeeccb9abf7fef60', '3', 'fe73748e52914fefb9da4dbd66f91c6d', '09541f25febe40708f2a3ed076324088');
INSERT INTO `sys_user_role` VALUES ('12ff72470c824014b7c245a77a931331', '3023e961538744349d43f0c780bc783a', '1a1e2a243d304ff6bce0bc17f0512b67', '5772c7f8a10a40dd9568fa80f1583f89');
INSERT INTO `sys_user_role` VALUES ('13', '5', '', '6');
INSERT INTO `sys_user_role` VALUES ('132f5ae9a1434ecca397e470ca7a2dd7', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '9163fa92fd4840ba92ee4902736ce36b');
INSERT INTO `sys_user_role` VALUES ('13a6d11261554ece815dd5bfabda7ac3', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', 'ffcc5dced043466ea109fc3acb60af15');
INSERT INTO `sys_user_role` VALUES ('14', '6', '', '7');
INSERT INTO `sys_user_role` VALUES ('14c24131122149e498081e60c45e18d1', '64cf56b4353a48359553b84e71dff600', 'd99a1ee29a874d46845c6e9f3ad80f61', 'd5585da1441d4f5184d26f61412b2ad1');
INSERT INTO `sys_user_role` VALUES ('151c900f66a24bc59712f79c9aef70df', '4', '', '5ef8b9bd27ba422d9eb71b37f35bc07b');
INSERT INTO `sys_user_role` VALUES ('1677d7c24ddd4b51bfddbaf98f952dfa', '5', 'de48a37349524bfba310582397364d3f', '390e703ee07b4abab9d6b4d552d473ec');
INSERT INTO `sys_user_role` VALUES ('16e6501d74ac4556b8a90f6999b6556b', '044595d92c0049ce9c82d66e453715a4', 'a06c8be19be14ab79f232012132384ab', 'fcc140f66dae43c0a16f436e540d06d8');
INSERT INTO `sys_user_role` VALUES ('16fb7031dace4fc0b331858bb9bfa3cb', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '1a87468f3c1b4606b337b5d626a5a152');
INSERT INTO `sys_user_role` VALUES ('1780e4a8b6ae438a813555506999b7b6', '4', '125538eda16a46ce894a2eb653093f8e', '18006a221cc24d838d1a30c1a2869ad1');
INSERT INTO `sys_user_role` VALUES ('17838e0731a945fbbb9dd768e5db95b9', 'b485c55da8b04342bd13315924b60a90', '', '4bc789cd39554f38822cadc338ec6137');
INSERT INTO `sys_user_role` VALUES ('1848bc5e76614afb88a31001e48cac72', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', 'eac622cd0a044b838b82287f2006656a');
INSERT INTO `sys_user_role` VALUES ('19e4fae2b1cd439aa8b15bb3db30fd23', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', '0ef1cfcbbf154c0eaa96e66904453e01');
INSERT INTO `sys_user_role` VALUES ('1a475c8c8b2f4733b13144464a1158ef', 'c5670f238a52405f8bba8ea6d3cd1ce0', 'ceb02eb6cb234e6098ce75c36dca5563', 'fe2d586faf9d4cdda738db6a3d8081e5');
INSERT INTO `sys_user_role` VALUES ('1ad95e8651d4445eb2d3919ce5adb75f', '4', 'd3e516d6170a48d694f836eb0269af94', 'd1c7681137f344f0aa2c48ccfdf57c5b');
INSERT INTO `sys_user_role` VALUES ('1ad95e8651d4445eb2d3919ce5adb75f', 'b2c12cfffbaa4de8a988f2e555b0c0e6', '4da825a73bcc459e89540a4714ad412a', '7d99fcb8c0564f9f8533e2055050b9b9');
INSERT INTO `sys_user_role` VALUES ('1adbb3e8a2874073947fb68fb70d8aa2', '4', '', 'd4f8466b1e404b478ae3906d470ccdbf');
INSERT INTO `sys_user_role` VALUES ('1ade201766494606ad9ffe0875c55259', 'a8c3e530e5f44bb7b9759ac75d0859b0', 'f6d8e91420794e34bc1b705bdbf0d00c', 'bcaeab62ab054a95bf6c66a7532f6a6d');
INSERT INTO `sys_user_role` VALUES ('1bfb5b3a4d584784872f36595b81a319', '4', '', 'ba9e83f001b542e7aead86fe7e437ba6');
INSERT INTO `sys_user_role` VALUES ('1deb244824434c6f9238706611b56510', '4', '0f195208fdae483caa731380ee37cde7', '1e5863ee2328438cbb5baad988ff8b04');
INSERT INTO `sys_user_role` VALUES ('1e262b1d5b3246b9876a35e7039cfb0e', '4', '', '04356d30d2c54e6b832c19cb0f634895');
INSERT INTO `sys_user_role` VALUES ('1e76a9ae562741758b433ee1c6b682d4', '2', 'de48a37349524bfba310582397364d3f', '3fd7c54754f945b7a84213a57d9bd5ef');
INSERT INTO `sys_user_role` VALUES ('1f195ba6f695440f977d2eea2e3abcaa', '', '4343976124db44499bdc27d13290976e', 'd1c6e777a61b4040ab6dffdc44fdc820');
INSERT INTO `sys_user_role` VALUES ('2000846a7ba0456c8a1f74438ec7dea8', '4', '', 'e60cc61d2d304b15b484edd2d729be7e');
INSERT INTO `sys_user_role` VALUES ('204644bbd74b4c65998bac4a80e59f4c', 'dd05adfbb76d48879af046847afabe23', 'de48a37349524bfba310582397364d3f', '74c0ff82921042249dbfdaac3f5e6c2e');
INSERT INTO `sys_user_role` VALUES ('2049ba59fdbf4ec2802f629b0eed79da', '4', '2ca559303af2444baf075e2ddbac4d57', 'fb4ab8f2e9bd4ea3952f7e85dd18a1c5');
INSERT INTO `sys_user_role` VALUES ('2053b2e36cdc4b9983b4a788c2c85fc9', '82132d72c50d48e49f21a6515c658d0b', 'd99a1ee29a874d46845c6e9f3ad80f61', '8408b9c29e35444db2c3b38eea7625c1');
INSERT INTO `sys_user_role` VALUES ('2067b7c054654e409fd9c0641c5e3db7', '4', '', '76a70bed46364d92b99166aff7906b71');
INSERT INTO `sys_user_role` VALUES ('2131977d7c064fb082761b1afffec6eb', '06aeda9d29bb48769ba14b3b4745efcd', 'ceb02eb6cb234e6098ce75c36dca5563', '001f677aa2684b3287b5233fa7faa783');
INSERT INTO `sys_user_role` VALUES ('21a90344f83c45839a87d21fddcc1f3f', '66a7412ce1d94e81ba6e3698f0adb711', 'd99a1ee29a874d46845c6e9f3ad80f61', 'e679595db5bc4a67ab212d6600541e24');
INSERT INTO `sys_user_role` VALUES ('220c257b60484a3491d667049f87fbb1', '5081393be1bb4fff8f9f773e2b837c12', 'ceb02eb6cb234e6098ce75c36dca5563', 'b0b98a8a07ed46fe825a9990467286d8');
INSERT INTO `sys_user_role` VALUES ('24059db619724d5488a95bbe450f3744', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', 'cfad4508a10f4ff285a3656a309036fe');
INSERT INTO `sys_user_role` VALUES ('2442d1c3b9534bf2bacf206db21a9658', '5c7245e305644e3a901ac05742e3990a', 'de48a37349524bfba310582397364d3f', '175fe06d1864479ab6e0163f1c140697');
INSERT INTO `sys_user_role` VALUES ('2551411a7ba64ed2ab4fd94be061182b', '17770167c6614c59af54054a2b2569f1', '231f0babdad4454b96e607f2f62c6ff4', '25ebef163e084efa9751968f3cccca48');
INSERT INTO `sys_user_role` VALUES ('25738565c82345269314ed25abe5eccd', '97dc666df13948ffbcfc018dd1d094fc', '231f0babdad4454b96e607f2f62c6ff4', '63736aa234394fc891cb513987b48ae8');
INSERT INTO `sys_user_role` VALUES ('25738565c82345269314ed25abe5eccd', 'd83744c197ea49fcb8d6dba6195040a4', '231f0babdad4454b96e607f2f62c6ff4', '4a1777ee19c7479cbf29a9952ee3f67e');
INSERT INTO `sys_user_role` VALUES ('25e0e3498fe84b5d8c34894218320ff7', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', 'ca714e66442b4316ae253e3efb216c22');
INSERT INTO `sys_user_role` VALUES ('26f2f1e5dedb4c579145b23bb734117e', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '8ed8ed032fb4477aaff5c5085e664fcd');
INSERT INTO `sys_user_role` VALUES ('275024283e1546e6818e03a5572257d3', '710b3aac9bfd4ab0aaed5aa50e51f8ab', 'de48a37349524bfba310582397364d3f', '510c3b50f679475ba6321b35d306a703');
INSERT INTO `sys_user_role` VALUES ('276b9b1e772c4a5cb85c64f463537d04', '2', '86c3a37b827c40e8b93047912e4ab069', 'b8ce913492494e28a6d4f0ce883ef21f');
INSERT INTO `sys_user_role` VALUES ('276b9b1e772c4a5cb85c64f463537d04', '3', '86c3a37b827c40e8b93047912e4ab069', 'd21b023450c54e64af9b64f75eb9bd79');
INSERT INTO `sys_user_role` VALUES ('27c4ac3404e04be19291edff5dcc5afe', '3', 'de48a37349524bfba310582397364d3f', '916e64623a444f9ab8203790e98706e1');
INSERT INTO `sys_user_role` VALUES ('286a5674f439469e903cd8a98b296c80', '710b3aac9bfd4ab0aaed5aa50e51f8ab', 'de48a37349524bfba310582397364d3f', '67b37ad1fdab4ffa85247bcb464674c6');
INSERT INTO `sys_user_role` VALUES ('29e50dbd08474c2488c6c5d39e165bd0', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', '3e10a1ee86854f68ae087e794d0c9de9');
INSERT INTO `sys_user_role` VALUES ('2a27af3520cf44619f8073b11810401c', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', 'db8f5568064a405398171d30d588cb31');
INSERT INTO `sys_user_role` VALUES ('2a46e93f7f4d4b2c8162d00956b1020b', '7165f6eeac5a4ea8ad1f161dac91ce32', 'a06c8be19be14ab79f232012132384ab', 'eabc527a89cb4e7da1a96d455ab7ea3f');
INSERT INTO `sys_user_role` VALUES ('2adc3f12a6c64aa9ab20d60545625fd9', '710b3aac9bfd4ab0aaed5aa50e51f8ab', 'de48a37349524bfba310582397364d3f', '422e05e3f92d49529427d0da6c68e460');
INSERT INTO `sys_user_role` VALUES ('2b808facf4b14654a9c87036f4bc61e3', '4', 'fe73748e52914fefb9da4dbd66f91c6d', '9801f35412e84719ae89b3ba8f8a4479');
INSERT INTO `sys_user_role` VALUES ('2c025da5cf5349d39cfa0fb86afd09ec', '4', '', '0082c47cc8234f1a97bf1c89a9594fc0');
INSERT INTO `sys_user_role` VALUES ('2d531ed54a834f4ab5bfef42baf2ad9b', 'a816d265374b454e86a347303d7a46cd', 'de48a37349524bfba310582397364d3f', '944dcf037a514d59899d27d86a0c88e7');
INSERT INTO `sys_user_role` VALUES ('2de01ae95fc0474f8f62f04f3c2a29b0', '4', '13304347940c4e48b0124561de06a204', '7d4a114ee66e4480a44a6fd7aef77e20');
INSERT INTO `sys_user_role` VALUES ('2de01ae95fc0474f8f62f04f3c2a29b0', '4', '3f5ffd14e1d64b1fb045dc566bb965c2', '2fee86ca249d446793e4e286fc4f8fed');
INSERT INTO `sys_user_role` VALUES ('2de01ae95fc0474f8f62f04f3c2a29b0', '4', '4b4bb8b4b9f74555bcf863a429fcfa26', '9bb717535fa34de89159a1a7ceef699f');
INSERT INTO `sys_user_role` VALUES ('2e9f73e159c441a3af9f17f6660a7661', '22a2f359d94b4bd696ca72cc3960eafc', 'de48a37349524bfba310582397364d3f', 'a6d46cfe13e74c36a9b13a81bab7102b');
INSERT INTO `sys_user_role` VALUES ('2e9f73e159c441a3af9f17f6660a7661', '496c0dce7f744c5083ca52f6b7b49bef', 'de48a37349524bfba310582397364d3f', '8fc77482c74940529f881b8c5c46ddd6');
INSERT INTO `sys_user_role` VALUES ('2e9f73e159c441a3af9f17f6660a7661', '5edb192aac45446d8a62dbe6c3c0cc23', 'de48a37349524bfba310582397364d3f', '221e9586d27d43e4b28cc67ff93e1d5f');
INSERT INTO `sys_user_role` VALUES ('30af71ad22974a87bbd2087d01e360cf', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', '4eea07f560de47ac8c368513a2119af8');
INSERT INTO `sys_user_role` VALUES ('313d248589654c068c7c8621bcddd2d3', '710b3aac9bfd4ab0aaed5aa50e51f8ab', 'de48a37349524bfba310582397364d3f', '7a0d896b44c0448a87d67ab7e0e1986e');
INSERT INTO `sys_user_role` VALUES ('31a39b107e314b518d55c015e1b8f35a', '4', '', '8');
INSERT INTO `sys_user_role` VALUES ('34cc49a9f2e1462d9f6c1a12165d8822', '044595d92c0049ce9c82d66e453715a4', 'a06c8be19be14ab79f232012132384ab', '3166c3e1ef6b421692c7b224fa42d16d');
INSERT INTO `sys_user_role` VALUES ('34cc49a9f2e1462d9f6c1a12165d8822', '39841b25f5fa472da8e8cdc4bca04442', 'a06c8be19be14ab79f232012132384ab', '2e52a6304b7c4bf997b7c3f8976d36fc');
INSERT INTO `sys_user_role` VALUES ('367722d2ead043bc83b4b1ebd664b167', '044595d92c0049ce9c82d66e453715a4', 'a06c8be19be14ab79f232012132384ab', 'aec8a0c513ba44b48e0174e2e31d5251');
INSERT INTO `sys_user_role` VALUES ('36b4e4d240194e8d85390596c52142f1', '66a7412ce1d94e81ba6e3698f0adb711', 'd99a1ee29a874d46845c6e9f3ad80f61', 'd52252f4db134c8dac5bfe6bb1563f0c');
INSERT INTO `sys_user_role` VALUES ('371a44ba10c448b2a06cfefe35b38a64', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', '42f8be1f2b204e49a7720d9a6e9e83bc');
INSERT INTO `sys_user_role` VALUES ('37fd6b33f65841609ce9b0e35f0afe7b', 'c722d31661d84348b365a326b7af38f5', 'd954a734d92d4dc1a21a974533fa4b31', '61571ec50ab74c778d72d13bf2bd28e3');
INSERT INTO `sys_user_role` VALUES ('397523e5fd5748b8b1998491b4f7f739', '4', '', '305504867a4448c183c9b76c69098cd7');
INSERT INTO `sys_user_role` VALUES ('39d657ad367f44e6b9e4b4423ed1fdf1', '4ef553d147ea4348a72c47dd7a544645', 'd954a734d92d4dc1a21a974533fa4b31', 'a34ce7f8c8674faa8091fdba413cecb4');
INSERT INTO `sys_user_role` VALUES ('3a4f90525039452491fbbac9ac52773b', '09b642e794644997924750a33e627e91', '42073f221b984a53877c0b0840cacc05', 'ac9d09aef763478f9dc0429901fdb051');
INSERT INTO `sys_user_role` VALUES ('3b288b3540b644729284ab5f8b589aea', '7af0ac2f4c874b15b915e210dbbd22a6', 'f6d8e91420794e34bc1b705bdbf0d00c', '79db1b5e13c844c1998c918dd63a8c95');
INSERT INTO `sys_user_role` VALUES ('3b4dad425cae44dc9b72d9f6e6308da9', 'a9e3769592d94fa187649df39e70d2ed', 'a06c8be19be14ab79f232012132384ab', '88a47fb3422f4d62a3990c055bdde7ad');
INSERT INTO `sys_user_role` VALUES ('3d443a57dc014c418738c8184e707bd1', '5', 'de48a37349524bfba310582397364d3f', '9d17db13f8fb466ab4f8b09790509d9d');
INSERT INTO `sys_user_role` VALUES ('3ea4faf3cfae4addb9d7d4fa6d4bbe64', 'c45e9816601748e1a8e07718e8c28163', 'f6d8e91420794e34bc1b705bdbf0d00c', 'cde907a04da04a6c8eea42d2bd0ed164');
INSERT INTO `sys_user_role` VALUES ('3ff6852c98d344f9b692fb9cada7742c', '3', 'de48a37349524bfba310582397364d3f', 'e7c03f7d23764adfa1bb4d30ff862437');
INSERT INTO `sys_user_role` VALUES ('405840b616974efebd7ee125e1cdfebb', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', 'e05587af9e424240a362810812c1687a');
INSERT INTO `sys_user_role` VALUES ('40619cb6f9c74ebe8cc01e0ec310cccb', '75c4b8d9bde141f7a0e6b876d0c741c2', 'b69303a1e8a14bc8893fd90b6f6ace0a', '784c4ee4452e4aa4b21ad0ec47e3fcb0');
INSERT INTO `sys_user_role` VALUES ('41339bb3237e44c19192ff5f55137672', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', 'ec60334240f04d2db64d0ed8e5a45994');
INSERT INTO `sys_user_role` VALUES ('428691a32f674d1f81aca56bb87bf82d', '4', 'de48a37349524bfba310582397364d3f', '7d37956985ef4f7a8393c4524679c474');
INSERT INTO `sys_user_role` VALUES ('429abc43e2db45428bfe0cff78a8386e', 'b2c12cfffbaa4de8a988f2e555b0c0e6', '59a35e5a07284c54a8d80edb3a8604c2', '734ea76c735343459142695da2808074');
INSERT INTO `sys_user_role` VALUES ('44bea592f2394eecae9c2dc166bc24af', '3', 'fe73748e52914fefb9da4dbd66f91c6d', 'acba04f07dcf4fae83633bed442a7fa9');
INSERT INTO `sys_user_role` VALUES ('44eac6b22eb748f88185474a2f97c2cc', '7bc7cd264f2e4067a434db667fc6e847', 'de48a37349524bfba310582397364d3f', '71dc522e4c0c4a0197bcf86db0697c3a');
INSERT INTO `sys_user_role` VALUES ('469a4e6ec59b4a0b9a3976393bc650e4', '4916cb14c13a423f97d666a175595645', 'd99a1ee29a874d46845c6e9f3ad80f61', 'db18d1054d464f0a85e27f06e0f6dcea');
INSERT INTO `sys_user_role` VALUES ('47af6a5554d14eb59722fbde96f2d197', '781d3d453e4b45618dd8471a2567a878', '42073f221b984a53877c0b0840cacc05', '58aa683959b947e2afc4361a9ceaa608');
INSERT INTO `sys_user_role` VALUES ('498bd1d5b3b543ad93983c43b05fab16', 'e6123bcf53994068b37f9f7bc9fa442a', 'd99a1ee29a874d46845c6e9f3ad80f61', 'd0fd15f503204c079f75815ba42f847c');
INSERT INTO `sys_user_role` VALUES ('49e67fc010c549f997aaf01e0f94a84a', '22a2f359d94b4bd696ca72cc3960eafc', 'de48a37349524bfba310582397364d3f', 'bcfabe7d8486455b83e6e55b9762213f');
INSERT INTO `sys_user_role` VALUES ('49e67fc010c549f997aaf01e0f94a84a', '496c0dce7f744c5083ca52f6b7b49bef', 'de48a37349524bfba310582397364d3f', '35ca3bcd3ba74b6993ee9f6f419624d7');
INSERT INTO `sys_user_role` VALUES ('49e67fc010c549f997aaf01e0f94a84a', '5edb192aac45446d8a62dbe6c3c0cc23', 'de48a37349524bfba310582397364d3f', 'e4d2326e5c5145b497f0db6169142f5a');
INSERT INTO `sys_user_role` VALUES ('4a4dd7078fca49ef981c5545a9bc4d79', '80c1813d6b674dc9bf0c378ab7f623b3', 'a06c8be19be14ab79f232012132384ab', '11c82dd232c44ec7bd9b78934a65967f');
INSERT INTO `sys_user_role` VALUES ('4b6e1eab9f1c4299ae27c54064afc2a2', '131d948f67684847a8b7101c691de6a2', 'b69303a1e8a14bc8893fd90b6f6ace0a', 'b128627688f84e2986d3d25966786494');
INSERT INTO `sys_user_role` VALUES ('4bae301ef5d44d068f5dee6cdea62109', '83542fbb53994f1bb0ffe4efdfe4b935', 'ceb02eb6cb234e6098ce75c36dca5563', '433124aa79b64b579963f2ab2118fbe8');
INSERT INTO `sys_user_role` VALUES ('4bcc72fef3c44759b6280e702c77e518', '4', '', '37fd88cf09604666ba322db8d78da102');
INSERT INTO `sys_user_role` VALUES ('4bd0c0578bb14f75be7ba28d8c7a63e1', '4', '', 'b46980716ea642058ad6401804ee1b95');
INSERT INTO `sys_user_role` VALUES ('4c36d9d3de1744e5812798376727c888', '4', '', '4ef724162b1144db962c90bbfbeebd79');
INSERT INTO `sys_user_role` VALUES ('4c9f4b269f6146a997c2e676221ef558', '4', '', 'a80cb3abb698469a83034f169277132c');
INSERT INTO `sys_user_role` VALUES ('4d71c07afb6344bc890fbacd2d436146', 'f632b4770de4499daf73ea50664699d6', '42073f221b984a53877c0b0840cacc05', 'c44d63e7449843a0b6f0e33ae2451660');
INSERT INTO `sys_user_role` VALUES ('4d9318f6d3cb4de69ab6697482ba5d50', '4', 'dbd58f5b72b945999b0882853b5f3c21', 'd32ade8fa4d84331a979cfe596d2f9da');
INSERT INTO `sys_user_role` VALUES ('4d9318f6d3cb4de69ab6697482ba5d50', '4', 'f2402e7715e0433fba264dc9510a7c23', '4852a78a0c374414982b68fe027e6c5b');
INSERT INTO `sys_user_role` VALUES ('4e2a8741f7df48e4bff7db5a6a203f85', 'de959fc6c24942a2a1a7f6227c45653e', '10815a1166e44fc18dd90e6df702f553', '830f67ecfe38473aafc542c0dad73bfc');
INSERT INTO `sys_user_role` VALUES ('4e657710569044a39ef3c0062105a4f2', '4', '', '4b15c17162184f448ab7012edeac72ba');
INSERT INTO `sys_user_role` VALUES ('4f4d7f591a524e06a13c6c17dfeb3daa', '4ef553d147ea4348a72c47dd7a544645', 'd954a734d92d4dc1a21a974533fa4b31', 'a7dd77499cd14b028cf93e0bc19982d6');
INSERT INTO `sys_user_role` VALUES ('5156cdd055bb42caa0e3131228c9f976', '4', '', '94756c4e4b234818a5242d5b678ef1db');
INSERT INTO `sys_user_role` VALUES ('5274cb1ca9034b508777fcb6da8d2778', '4', '53ff70f19752471b846133563d7e9b39', '040c78c931104c1f8930bcaed7e25804');
INSERT INTO `sys_user_role` VALUES ('529be880f67d491dad12449421c08c06', 'b6aa1fea47cb464b9eb7e52c5986c18a', 'd954a734d92d4dc1a21a974533fa4b31', '5153dd4e86504dd59f11006dd034c961');
INSERT INTO `sys_user_role` VALUES ('52fc31e088a546a4ad04ff6b2fdfd98b', 'c23f1ca8f97e4140b2bf2a9ce9092f85', 'b69303a1e8a14bc8893fd90b6f6ace0a', '88eae1c4d981485dacf4699843df67c2');
INSERT INTO `sys_user_role` VALUES ('5394d2a9b14a4d27a2d5bdf089f33204', 'e629b0f278a0417c99d8c06614424252', 'de48a37349524bfba310582397364d3f', '1057ed42dfa445949be77414602aac0e');
INSERT INTO `sys_user_role` VALUES ('5578d355137541debcbee2e789fd0f20', 'dd2bf777809a4201ae3ae903c878453a', 'ceb02eb6cb234e6098ce75c36dca5563', 'd04a47d1a43549d2893010a98e7f36c1');
INSERT INTO `sys_user_role` VALUES ('5675030f18924a4d80555b4435d13c18', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', 'a26c4c95207644cfb2ec36912f032b41');
INSERT INTO `sys_user_role` VALUES ('5738d723179741cc9bf10b8d73837c55', '4', '', 'f9982a6da98344798302a113df0bf370');
INSERT INTO `sys_user_role` VALUES ('5738d723179741cc9bf10b8d73837c55', '4', '68a34a548b164464b354c2f62e8f6dae', 'b1d6d34c231a41dc99ea552ddb25e155');
INSERT INTO `sys_user_role` VALUES ('57b66f6ce4ae4622b1b932c00f313396', 'c3a34ac4a1fc4c4d95ba853966f54e24', 'b69303a1e8a14bc8893fd90b6f6ace0a', '4fb5b1aba8ea4cf59e99fe5a7b0c725f');
INSERT INTO `sys_user_role` VALUES ('593712767ff14e5090ceab44d95d5fc6', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', '55e36ae88bc54df2a6b2f4dbe6f611ce');
INSERT INTO `sys_user_role` VALUES ('5a1899771b1c42e08cf0049aaa694d8a', '4', '4601e20a77e944a7a77e1bcc225f675a', '2d1e520207084f37a114c6022436ad80');
INSERT INTO `sys_user_role` VALUES ('5a54bc4c3a894a1f89d950234bf988db', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '59692047fac546d9a648e0dd0054bab4');
INSERT INTO `sys_user_role` VALUES ('5a81778dbd174cdf91314fb8b682be89', 'c45e9816601748e1a8e07718e8c28163', 'f6d8e91420794e34bc1b705bdbf0d00c', '52c94e412cb74622990b2a3e897d4025');
INSERT INTO `sys_user_role` VALUES ('5aa95043a6c64e43b6d78e121d255cae', '29a6522b3497437fbfe5405f65af6deb', 'ceb02eb6cb234e6098ce75c36dca5563', '5bbf6e94e0aa486a88a8f4538b3eac41');
INSERT INTO `sys_user_role` VALUES ('5ac78e75a399489b97b0fe2f70f73a42', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', 'ade179ff7aee4215a0fd6e8843f93ab1');
INSERT INTO `sys_user_role` VALUES ('5b0252f6a777496c9a6179f0471aa9ca', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', '52fdabc483644419a9af29bb3cc67a9b');
INSERT INTO `sys_user_role` VALUES ('5b8a077de5a14253aedbfa14615467c2', '4', '', 'f88ca9cb02544d469cf24d714e72f50c');
INSERT INTO `sys_user_role` VALUES ('5be5f11dd00046b7bada7fec89cc1ba4', 'f0a49a9e1db04ccd8869933a547ba625', 'd954a734d92d4dc1a21a974533fa4b31', '8df7c68465d94d0cb8ac8b6b528c83ef');
INSERT INTO `sys_user_role` VALUES ('5d06f8e70f6c4d15939c21ccf7f632bc', 'c292f2cb6f784f5693d20b42db20b6e5', 'b69303a1e8a14bc8893fd90b6f6ace0a', '979d91bc8f04473ca3e5d16dcfde37d2');
INSERT INTO `sys_user_role` VALUES ('5d71c3e3036f493c80e8d4f69348e23b', '2', 'd3e516d6170a48d694f836eb0269af94', 'e5e854c72a8e4054aa1d2299ccdc2230');
INSERT INTO `sys_user_role` VALUES ('5f42c4de6fa341f2b2aa5b294b1dc58d', 'd4724186dcb04b8b9e4edc37479f165f', '42073f221b984a53877c0b0840cacc05', '3d5ef6d08d6f438ca68d1a9e0d65f860');
INSERT INTO `sys_user_role` VALUES ('5f73c52064fc45b78f28928605878af1', '4', '', '18648d7157334a66ad5c865619f1f74b');
INSERT INTO `sys_user_role` VALUES ('5fc6130cc5ce4c19840c32a9cdd95aae', '511c2db4b28b436f939dbc38c8a14ef0', '231f0babdad4454b96e607f2f62c6ff4', '848237732d764cf5beb1c72fcc437f1a');
INSERT INTO `sys_user_role` VALUES ('623b015be93343a4bcd2deb167e53cad', '04ea62537086478eb24e9b35ca9b7243', '231f0babdad4454b96e607f2f62c6ff4', 'ffa0e3aedb1443aaaba84b3a93c12d19');
INSERT INTO `sys_user_role` VALUES ('627eac67f4ab4a97991cad4b97ad74a0', '3e07e8f9f7c84d97beb3810573cc9410', 'b69303a1e8a14bc8893fd90b6f6ace0a', 'd7ec54a8325e40e4a7e68c2c1d0dda0c');
INSERT INTO `sys_user_role` VALUES ('62fb677c397e4190bd9fe7866e4c776c', '4', '', null);
INSERT INTO `sys_user_role` VALUES ('6301b216a92f4754ac95ee1f4e275f4f', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', 'fb0c594e714c494499ca6e0d07ad68ae');
INSERT INTO `sys_user_role` VALUES ('63695cc3a0fd48dea5f17605e4ff075e', '815808c9438a4277b02891c82232c825', '231f0babdad4454b96e607f2f62c6ff4', 'd11692ebbaf54b28bd22ea8ec3f7bd68');
INSERT INTO `sys_user_role` VALUES ('6431c1152c254eb28c8a7e7f7f72db0d', '66fb4bf787a64832bc80135511f583e9', 'd954a734d92d4dc1a21a974533fa4b31', 'ae47d75cc5fa44348994b9fa656d0a9c');
INSERT INTO `sys_user_role` VALUES ('64f6186453f34cbdb68b1c51e72fd80f', '3e07e8f9f7c84d97beb3810573cc9410', 'b69303a1e8a14bc8893fd90b6f6ace0a', 'd9abe6f9f7264c15959c7ff633bc4b41');
INSERT INTO `sys_user_role` VALUES ('656146e75165408792c8ac758a2bae51', '2', 'de48a37349524bfba310582397364d3f', '1a455ffa35f040038fbec00bf75bb309');
INSERT INTO `sys_user_role` VALUES ('656146e75165408792c8ac758a2bae51', '3', 'de48a37349524bfba310582397364d3f', 'f15a88d810584ef5aac6561c673233be');
INSERT INTO `sys_user_role` VALUES ('656146e75165408792c8ac758a2bae51', '4', 'de48a37349524bfba310582397364d3f', 'c143bbff86de4200be868619ccf95083');
INSERT INTO `sys_user_role` VALUES ('656146e75165408792c8ac758a2bae51', '496c0dce7f744c5083ca52f6b7b49bef', 'de48a37349524bfba310582397364d3f', '99113502cb484383a6c9c3abaab551bf');
INSERT INTO `sys_user_role` VALUES ('656146e75165408792c8ac758a2bae51', '5c7245e305644e3a901ac05742e3990a', 'de48a37349524bfba310582397364d3f', '50d0c6360e9743358e36800161fb8121');
INSERT INTO `sys_user_role` VALUES ('656146e75165408792c8ac758a2bae51', '5edb192aac45446d8a62dbe6c3c0cc23', 'de48a37349524bfba310582397364d3f', '9d52ec0127174c41977c440cc3006a75');
INSERT INTO `sys_user_role` VALUES ('65744b0fa95f4eebadbdca73e1af3640', '4', '', '00e9a581c9a64b2ea4847a059b3e7238');
INSERT INTO `sys_user_role` VALUES ('65e956d1046241ec99718e5fbf2d9d6a', '4', '', '8a64a3e3e8544487bcda62970a98923b');
INSERT INTO `sys_user_role` VALUES ('66ae934cb15d420db707c75812626357', 'a816d265374b454e86a347303d7a46cd', 'de48a37349524bfba310582397364d3f', '31f1185e0b4744a68b5aa07fa6f5bc39');
INSERT INTO `sys_user_role` VALUES ('67709b80814f476d9669c5adbcacf7f7', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', 'c2bc68cd03d948589969998222390d5c');
INSERT INTO `sys_user_role` VALUES ('67f0c3cc78ce458bb43b0411df14860f', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '86657e139adf44b1918592010eade172');
INSERT INTO `sys_user_role` VALUES ('6868352c6f3a42f7babcdb3865d82043', '8aad683b6f414b37944da688f6be0c6a', '231f0babdad4454b96e607f2f62c6ff4', '8d16f744b8da4badb94ee3e440594bf6');
INSERT INTO `sys_user_role` VALUES ('6895a9d1c4dd4cf4aec08ed6475fca80', '4', '6aa2299b5f66468285dd2dce44718369', '474a1070b7a740c486463e49b060b19c');
INSERT INTO `sys_user_role` VALUES ('69f1bcb0860d48c28f0202f03eff392e', '4', '', '683e4c05c59f49e283a143543a37a49b');
INSERT INTO `sys_user_role` VALUES ('6b0f3930ff53409aa293c672ab748264', '4', '', '');
INSERT INTO `sys_user_role` VALUES ('6b56489cd8864d1981f67634bd9abc42', '4ef553d147ea4348a72c47dd7a544645', 'd954a734d92d4dc1a21a974533fa4b31', '39747ae60a694d34812cd486949322d3');
INSERT INTO `sys_user_role` VALUES ('6b70b1180fce461588b4da465ea9c00d', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', 'a715508d3b60497da321eff37af7d4a1');
INSERT INTO `sys_user_role` VALUES ('6b780dc294b64fc09ea7b7360645f957', '524945b5fc4d4ba4aa9d0c0346468c5e', '10815a1166e44fc18dd90e6df702f553', '69c24c3583044c88be53fc20dc391a36');
INSERT INTO `sys_user_role` VALUES ('6d220a9ec4934bdfa88517adba99562e', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '3cdc304f39d242fd9075fb331f3753f0');
INSERT INTO `sys_user_role` VALUES ('6d26e5aa0b834d13bb6533fbb76a6de1', '4', 'de48a37349524bfba310582397364d3f', 'fb1dc10212aa4f0787fc15588cfb9b84');
INSERT INTO `sys_user_role` VALUES ('6d26e5aa0b834d13bb6533fbb76a6de1', '496c0dce7f744c5083ca52f6b7b49bef', 'de48a37349524bfba310582397364d3f', '9fea6b28b29c478faac588da1f0e1010');
INSERT INTO `sys_user_role` VALUES ('6d26e5aa0b834d13bb6533fbb76a6de1', '5edb192aac45446d8a62dbe6c3c0cc23', 'de48a37349524bfba310582397364d3f', 'd78f4d197898424987e0c339c8d35a5d');
INSERT INTO `sys_user_role` VALUES ('6d26e5aa0b834d13bb6533fbb76a6de1', 'a816d265374b454e86a347303d7a46cd', 'de48a37349524bfba310582397364d3f', '493d0bbdd48c4603af120f74a9c4198b');
INSERT INTO `sys_user_role` VALUES ('6da0e8708ef647f68f8b827f5314d825', '8616a8d609394ba2acc537f726e9b1d4', '10815a1166e44fc18dd90e6df702f553', '6afcb4864de74f21b1a02ce04d2d509d');
INSERT INTO `sys_user_role` VALUES ('6e3ccde2a93d4c4891ae045721971167', '4', '0bc8287b8b3b4ac2bef410349338df64', 'be6b1ae02f4a4a1f838b0f049b4aabf2');
INSERT INTO `sys_user_role` VALUES ('6ea29372c37c4bb9a9e3f0e088510584', '4', '', 'be54cfd96bc84fdca8645c734ae9be65');
INSERT INTO `sys_user_role` VALUES ('6ebba068dc7841a8912d8bfac91f3321', '4', '95037601eb444f3f96d65ae1403e0930', 'aa4e4f9ade084291a33cdd4fe9bbf674');
INSERT INTO `sys_user_role` VALUES ('6ed029c406924f46a2ea78dc31d7a33e', '511c2db4b28b436f939dbc38c8a14ef0', '231f0babdad4454b96e607f2f62c6ff4', 'dd5bb4d88fab44e787e70424fbb01f89');
INSERT INTO `sys_user_role` VALUES ('6f1d0c07f7d44d9c8ed3b8f57e650627', '044595d92c0049ce9c82d66e453715a4', 'a06c8be19be14ab79f232012132384ab', '8cb749f90e314b7886dffa29a451b717');
INSERT INTO `sys_user_role` VALUES ('6fe54fd8e876488997e3db8c3f24e01e', '4', '', '9da190f4bd2f46f3abf8500cc1766396');
INSERT INTO `sys_user_role` VALUES ('7082960d2e9e42538515c9649412bb94', '4ef553d147ea4348a72c47dd7a544645', 'd954a734d92d4dc1a21a974533fa4b31', '2b28ec3fa54347db8c7fe523d4f4a0e5');
INSERT INTO `sys_user_role` VALUES ('71680f54e8f040d6adc03d7fb3569421', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', 'a30246594c484183a604cc0f1e8f3caa');
INSERT INTO `sys_user_role` VALUES ('71807855f671429381350097e4b24d97', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', 'b25ff9d78a93494bbe6c1874fd544829');
INSERT INTO `sys_user_role` VALUES ('723c29f7c01e4eb197d86332b5fd6143', '4', 'de48a37349524bfba310582397364d3f', 'g517555b76ksadfl95036b933b8f5fk0');
INSERT INTO `sys_user_role` VALUES ('7269a410b2114bc184643e23e140181b', 'a816d265374b454e86a347303d7a46cd', 'de48a37349524bfba310582397364d3f', '14a6d3358f284071be49a3324c095f1b');
INSERT INTO `sys_user_role` VALUES ('726d742cba2b4359848a63d8368527e7', 'c991914468684eccab3af4efa90a3186', 'f6d8e91420794e34bc1b705bdbf0d00c', 'f1a0127647a44faba6a2960bb0352945');
INSERT INTO `sys_user_role` VALUES ('73551850a408476e893ce552fcc078d8', '511c2db4b28b436f939dbc38c8a14ef0', '231f0babdad4454b96e607f2f62c6ff4', '8cb65393948042c4b4e4740fa0b38c49');
INSERT INTO `sys_user_role` VALUES ('735e691541e94ec99efde7b192e994aa', '3', 'de48a37349524bfba310582397364d3f', '21a943ace4774a73b1dd1f1a1b7d1a27');
INSERT INTO `sys_user_role` VALUES ('735e691541e94ec99efde7b192e994aa', 'a816d265374b454e86a347303d7a46cd', 'de48a37349524bfba310582397364d3f', '3e35f86550364e05a016cd848351d326');
INSERT INTO `sys_user_role` VALUES ('73b348df2364409680c96c2255b24591', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', '39e9ddf2808042d6bf525376b4a02f19');
INSERT INTO `sys_user_role` VALUES ('744b7f50bc1d408e9ab4f1d4c767530e', 'dd91ebc1392d41ec9beed20f744fed0f', '', '4744f5d8661e48fb8f61d68e7644d2b4');
INSERT INTO `sys_user_role` VALUES ('75362e29b3f04da39380a537628d0746', '4', '', '29e00cbde4f643cb8cf4cb0f2c9dda7c');
INSERT INTO `sys_user_role` VALUES ('75c358496a504ba8ad39c41c79e99d80', 'de959fc6c24942a2a1a7f6227c45653e', '10815a1166e44fc18dd90e6df702f553', '1446b0f0d27b43a5838cdc876fe2d91c');
INSERT INTO `sys_user_role` VALUES ('76399dc3a31642edbebbd0a52f7124a3', '1936c7d6569c46868fc44e5e9425b2db', 'd954a734d92d4dc1a21a974533fa4b31', 'b4d971f8d927493da9c8a74e20fdc2fe');
INSERT INTO `sys_user_role` VALUES ('7892083b7e5842f1bf789c99b8a5b93f', '66a7412ce1d94e81ba6e3698f0adb711', 'd99a1ee29a874d46845c6e9f3ad80f61', '3bc835fd49d3469ab059439172641955');
INSERT INTO `sys_user_role` VALUES ('7a163b99c613467aac2d91e82e8a3034', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', '1a69058349674b7f83a672ed2b352006');
INSERT INTO `sys_user_role` VALUES ('7acf79348b6646ccae1fbc9d3d2068a4', '', '8ccf142efe3f45ffa92c32c9d36345f5', '43981e0484c84526880be370b5223622');
INSERT INTO `sys_user_role` VALUES ('7adef2e29ed148969f8da2a68a0d7bb7', 'b524ec63bc8a40b7a84161047b6c586e', '10815a1166e44fc18dd90e6df702f553', 'dcd2b9e8ad82470abccccc65d44dc1ce');
INSERT INTO `sys_user_role` VALUES ('7d22b16b55894dbcaf8afda4ead1de24', 'dd91ebc1392d41ec9beed20f744fed0f', '1a1e2a243d304ff6bce0bc17f0512b67', '68602e5b860f48ff9975a02cba2fbe35');
INSERT INTO `sys_user_role` VALUES ('7db6c05883274d1eb8e2126f1552e96a', '51b91fc4790144708db609c9d7a32279', '42073f221b984a53877c0b0840cacc05', 'cb36ea2cc0554be49f1e7e656f8e0094');
INSERT INTO `sys_user_role` VALUES ('7debfecf16dd4f1e9f5cccf913cf1995', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '219d91cc71214f9ab1c0b6366178471c');
INSERT INTO `sys_user_role` VALUES ('7e2fd9b9a6e84fd281b330c678e24200', '4', '', '9c0cfa7db4f44d45a82cf8a8e1295203');
INSERT INTO `sys_user_role` VALUES ('7e88594b36a84a529123d42ced29f8d2', '3b095ea411604abb8656c85461a775b2', '10815a1166e44fc18dd90e6df702f553', 'df2c7c9fba054f129ace878589c64d62');
INSERT INTO `sys_user_role` VALUES ('7e88a0ac922e436b8e65cb506bfe88a2', 'a816d265374b454e86a347303d7a46cd', 'de48a37349524bfba310582397364d3f', '6c1037a886ca4618a0f0f7bbcee710be');
INSERT INTO `sys_user_role` VALUES ('7e88a0ac922e436b8e65cb506bfe88a2', 'dd05adfbb76d48879af046847afabe23', 'de48a37349524bfba310582397364d3f', '550f978f8cfb48628546065485daebe4');
INSERT INTO `sys_user_role` VALUES ('7e8bc209f0034a92a0a186dd0739d56b', '4ef553d147ea4348a72c47dd7a544645', 'd954a734d92d4dc1a21a974533fa4b31', '9dd9f228f7d24385bb68f61deee908a6');
INSERT INTO `sys_user_role` VALUES ('7ec36e187bac4233b627c7e0dc2640e4', '4ef553d147ea4348a72c47dd7a544645', 'd954a734d92d4dc1a21a974533fa4b31', '3be04c694a444998868b1da2cd3551a1');
INSERT INTO `sys_user_role` VALUES ('7f124741facc42bc98220166f4d1aec2', 'f80328a19f5940849fef7707d187d5da', 'a06c8be19be14ab79f232012132384ab', '5277fe9b4f5645ca9b9b5ea9e503abe3');
INSERT INTO `sys_user_role` VALUES ('7f301acd602b4e74b647a174bb7580c6', '4', '', '172558b6711b4956a07d90e306297dc5');
INSERT INTO `sys_user_role` VALUES ('7f85bc5d0e2e46aca99817a5a7c13d39', '4ef553d147ea4348a72c47dd7a544645', 'd954a734d92d4dc1a21a974533fa4b31', 'd363c6194f744b9a81f09631433e0903');
INSERT INTO `sys_user_role` VALUES ('80105147e12d46719ba7b88e306aa553', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', 'fe60eb82ffcd420ebf15cdc8abae37ac');
INSERT INTO `sys_user_role` VALUES ('810d1090d6934699ad1df2adc75fc0e7', '2', 'de48a37349524bfba310582397364d3f', 'efb5b4c3050d4e6cae3fca90137f4c11');
INSERT INTO `sys_user_role` VALUES ('813c5388c18e488dbcf9fc6193b47af5', '4', '', '9a9e31bdca04455f93e616fe01cc7218');
INSERT INTO `sys_user_role` VALUES ('81ec95a2cfdf4a7590033c60232e652d', '3023e961538744349d43f0c780bc783a', '1a1e2a243d304ff6bce0bc17f0512b67', '74058c6b3f2b440087633f0eaed512e2');
INSERT INTO `sys_user_role` VALUES ('81fb13a07966494998500915e085647c', '7165f6eeac5a4ea8ad1f161dac91ce32', 'a06c8be19be14ab79f232012132384ab', '0c802f96ee904db39f9452d35c7d403d');
INSERT INTO `sys_user_role` VALUES ('82c5905e2a9f49e9baac0037412f7bca', 'f2787272d7d94ac5a103a13f0d2859be', '10815a1166e44fc18dd90e6df702f553', 'c9229a41e86c4be19e5bc3dfc7aa6325');
INSERT INTO `sys_user_role` VALUES ('844d122c02ef41e4bc05d7c100754fbc', '524945b5fc4d4ba4aa9d0c0346468c5e', '10815a1166e44fc18dd90e6df702f553', 'c9eda404772949c6ae9aae8aceb2d4df');
INSERT INTO `sys_user_role` VALUES ('845cdac2919740deb0e36ad95e677dfd', '9c82f5e5f4ea4bcaad70a58ebd665aab', '10815a1166e44fc18dd90e6df702f553', '039b91ab300347de8ab98d5ec336b64c');
INSERT INTO `sys_user_role` VALUES ('848d329574374bf48386306d5fab0435', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '5a1130926a754873a24d344f51c4158e');
INSERT INTO `sys_user_role` VALUES ('84f4f89249294cc0a15c61d421805004', '815808c9438a4277b02891c82232c825', '231f0babdad4454b96e607f2f62c6ff4', '8ee02256e63d41a390e54ec390485f68');
INSERT INTO `sys_user_role` VALUES ('85d45fb561664e39a2a796a52b84b9f9', '4ef553d147ea4348a72c47dd7a544645', 'd954a734d92d4dc1a21a974533fa4b31', 'fe47def0194a4c7594280a22d9adda04');
INSERT INTO `sys_user_role` VALUES ('860548fe4b8745e3ab59bd8652b395be', '91c5fe4764e9451ab94e47869a686190', 'b69303a1e8a14bc8893fd90b6f6ace0a', '4bba13b04a4145c790057867d4fc3231');
INSERT INTO `sys_user_role` VALUES ('86d57d2121484449b8d0408db500d10e', '2a07aba3f25941538478f4a0032a9bbd', 'd954a734d92d4dc1a21a974533fa4b31', 'fbad665c7c4f42f8896b5c4c9ab319a6');
INSERT INTO `sys_user_role` VALUES ('8701424fcbf2485183603cc5835ab47a', '51b91fc4790144708db609c9d7a32279', '42073f221b984a53877c0b0840cacc05', '50b4cb599047466b8699ff0179e2ec5d');
INSERT INTO `sys_user_role` VALUES ('8757a4b1561e4b84b3eacf00e7146680', '97dc666df13948ffbcfc018dd1d094fc', '231f0babdad4454b96e607f2f62c6ff4', 'c30f11ba246c4369921242c32f0df676');
INSERT INTO `sys_user_role` VALUES ('88fca9a0b65b400ab65d2ace27b69419', '044595d92c0049ce9c82d66e453715a4', 'a06c8be19be14ab79f232012132384ab', 'd2879dc205344449aae74025b80d6b67');
INSERT INTO `sys_user_role` VALUES ('89a8aa30d08d42d3b48ec86872618567', '815808c9438a4277b02891c82232c825', '231f0babdad4454b96e607f2f62c6ff4', '49621abefc064e2487826f7342a4d4c2');
INSERT INTO `sys_user_role` VALUES ('89d434ac7aa04f6d87104dc210dfb178', '66a7412ce1d94e81ba6e3698f0adb711', 'd99a1ee29a874d46845c6e9f3ad80f61', '1260dd8a4641474bb380a795d43c6305');
INSERT INTO `sys_user_role` VALUES ('89de679a6c8e4384be64466af04cbb0f', '', '398339d44b9f42d1a4fa56e343797dac', '6ad319ee08824004ba60c4a785ea8e3c');
INSERT INTO `sys_user_role` VALUES ('8b4e14c053e946b184116548693a435b', '4', '', '316d11ffc16341c08ed2c9a182fecbd5');
INSERT INTO `sys_user_role` VALUES ('8bec83cda1bd4014b0dd76f9a9f380ac', '2', 'de48a37349524bfba310582397364d3f', '0cc000272829492b877bcdbfb670bfd5');
INSERT INTO `sys_user_role` VALUES ('8bec83cda1bd4014b0dd76f9a9f380ac', '496c0dce7f744c5083ca52f6b7b49bef', 'de48a37349524bfba310582397364d3f', 'bdc04b1c24bc4bfe95017e8e073e846d');
INSERT INTO `sys_user_role` VALUES ('8bec83cda1bd4014b0dd76f9a9f380ac', '5444c73eecb648d5bb02a73cdb7d382f', 'de48a37349524bfba310582397364d3f', '89336f40407240f4bbb8507948319789');
INSERT INTO `sys_user_role` VALUES ('8bec83cda1bd4014b0dd76f9a9f380ac', '7bc7cd264f2e4067a434db667fc6e847', 'de48a37349524bfba310582397364d3f', 'a4a23cc134df49229287ed92fce03aca');
INSERT INTO `sys_user_role` VALUES ('8bec83cda1bd4014b0dd76f9a9f380ac', 'a816d265374b454e86a347303d7a46cd', 'de48a37349524bfba310582397364d3f', '33229b9b0a1241d28b5668012723d4d3');
INSERT INTO `sys_user_role` VALUES ('8bec83cda1bd4014b0dd76f9a9f380ac', 'dd05adfbb76d48879af046847afabe23', 'de48a37349524bfba310582397364d3f', '894208a7b2ea495ea656916e09725d67');
INSERT INTO `sys_user_role` VALUES ('8f09e3c9d50d4f11ade20ef34576a368', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', 'e9e97e346add4141bb8538c6b81db10d');
INSERT INTO `sys_user_role` VALUES ('8f60dba6b9d341d9ad465e9f0deb55c9', '4ef553d147ea4348a72c47dd7a544645', 'd954a734d92d4dc1a21a974533fa4b31', '87476c193bfc4ed4afd5594f590c1033');
INSERT INTO `sys_user_role` VALUES ('900025ec6eb14c7097af2d9f838d6765', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', 'ce042e82ca0448ddb8d6e026dabf1321');
INSERT INTO `sys_user_role` VALUES ('9224b43edf2d4c5c8ea03c5d5f99ff13', '5b7af7af700448108856051a28172e0d', 'b69303a1e8a14bc8893fd90b6f6ace0a', 'c7ea60c199e34194bca007ab652a9300');
INSERT INTO `sys_user_role` VALUES ('93183590664442a6883b436df6a58cd1', '9a85fdf07ea142758df98c72ba067730', 'd99a1ee29a874d46845c6e9f3ad80f61', '41e059a2d74d4e61845857f10a2d817c');
INSERT INTO `sys_user_role` VALUES ('9330918575dc4fa8a6c1485d0d8594e6', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', '27d51dfb567241e49501cf26366f51d0');
INSERT INTO `sys_user_role` VALUES ('94e70692a52542e9ae2100d18eea453d', '2c6eba0d6a284631931673bd614075e9', '42073f221b984a53877c0b0840cacc05', 'afc536e90cc849ffab24066a3b0b1100');
INSERT INTO `sys_user_role` VALUES ('950de3b43eed407096b7f2789c997dcf', '4', '', 'ace77dec19e048d6b8b6dbf4afc253cb');
INSERT INTO `sys_user_role` VALUES ('95f9e9dabdee4bb183c7442adf91d60c', '3b095ea411604abb8656c85461a775b2', '10815a1166e44fc18dd90e6df702f553', 'ac1301e12ee540f784ed25d5df5ddea1');
INSERT INTO `sys_user_role` VALUES ('96dfb16187f54f7ba1606065bc8ddc1e', 'c7fa7ffe8ad34d0695d5617282149c14', 'f6d8e91420794e34bc1b705bdbf0d00c', '62eff18009c54c0ea72331c717e9e38c');
INSERT INTO `sys_user_role` VALUES ('96dfb16187f54f7ba1606065bc8ddc1e', 'f309c6752a06481f93cbe35a4c79a840', 'f6d8e91420794e34bc1b705bdbf0d00c', '206e28ef882f41b89fcbf0fa84d704a2');
INSERT INTO `sys_user_role` VALUES ('973818b1d1ff4decba7b758d302bba64', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', 'a461befb59c74bf29d7d320908e4c38c');
INSERT INTO `sys_user_role` VALUES ('98940f848dc74097b42c9f14e1f80062', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', '0aecd3477d484877b69a40f78bf4e3e5');
INSERT INTO `sys_user_role` VALUES ('993eb74dc029412883e01bd233998a33', '66a7412ce1d94e81ba6e3698f0adb711', 'd99a1ee29a874d46845c6e9f3ad80f61', 'b3e0116d92ae40fb96fa790047e0b4b4');
INSERT INTO `sys_user_role` VALUES ('9a853434ddef4fb3a3a727704809c69f', '384928029986434cb367e301db816439', 'b69303a1e8a14bc8893fd90b6f6ace0a', '536249b57ece4185afdd817c28871c63');
INSERT INTO `sys_user_role` VALUES ('9a8ebac4becd41ed85a9fc2a9cd53cb0', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', '0e3f3fcb49314ea99cc870f33a8622c7');
INSERT INTO `sys_user_role` VALUES ('9b737e4fc6e64157a2b9f33aeaf64df7', '4', '', '1bd5df7f267844349918ed65cf211d77');
INSERT INTO `sys_user_role` VALUES ('9b737e4fc6e64157a2b9f33aeaf64df7', '4', '00e885329d3946b2bc841ba2cac43ee7', 'd041086bb2f24a65bb82a659fd23dbe3');
INSERT INTO `sys_user_role` VALUES ('9b737e4fc6e64157a2b9f33aeaf64df7', '4', '0910af1a41bc4d79b90db64cb0093e85', 'cd7604c00ef643c8a0b8a8f9a17b73f1');
INSERT INTO `sys_user_role` VALUES ('9b737e4fc6e64157a2b9f33aeaf64df7', '4', '294e4cbbd4784d77a805dbf3ee448a0e', 'f73c4b9a1cbe4c5598e0539623f3374b');
INSERT INTO `sys_user_role` VALUES ('9b737e4fc6e64157a2b9f33aeaf64df7', '4', '4a5795ab39e741778be2c67893557701', '4e681a2ebdc848f19861b87eb1291fc3');
INSERT INTO `sys_user_role` VALUES ('9b737e4fc6e64157a2b9f33aeaf64df7', '4', '4b9c1d648e0947958c37a4f813affeb5', '7f7233309bb44731a5a2032d40a0d5bf');
INSERT INTO `sys_user_role` VALUES ('9b737e4fc6e64157a2b9f33aeaf64df7', '4', '5774b042140a4c53ad2232ce6911e7ee', '654c601e8b3e41e399d644862c687536');
INSERT INTO `sys_user_role` VALUES ('9b737e4fc6e64157a2b9f33aeaf64df7', '4', '6e419a772ae74eacbe4c67bd44684d34', '06d4f0f4b06d4ad282d30adab6e4fad9');
INSERT INTO `sys_user_role` VALUES ('9b737e4fc6e64157a2b9f33aeaf64df7', '4', 'ff2305179e124680a68b52ca52018521', '999729c27b224bbb88d7e61862951ed1');
INSERT INTO `sys_user_role` VALUES ('9bf36d0d4aab42c4b16ee39cc62a29a0', '3b095ea411604abb8656c85461a775b2', '10815a1166e44fc18dd90e6df702f553', '26ee0e2d07fd44c2be5d36043ae14998');
INSERT INTO `sys_user_role` VALUES ('9c1e75fb89db4c14bdb0911be1a3bda3', '49ac0955aff74ffab08771a3566bf9ff', 'a06c8be19be14ab79f232012132384ab', '48a1b6d366294b07a2438c98d1421dd0');
INSERT INTO `sys_user_role` VALUES ('9c672adb9ea74df295f6700d9b1b9c2a', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '636e7781142c4bc99df9ae1426f41a74');
INSERT INTO `sys_user_role` VALUES ('9d192814730e48349a1b012bae5e9a39', 'a816d265374b454e86a347303d7a46cd', 'de48a37349524bfba310582397364d3f', '95c3c408b88a4654b6e6e8e616abe36c');
INSERT INTO `sys_user_role` VALUES ('9d2bcb6b8787406da645fe25410be133', '94f9818d70b94c2a8ece380430b368b6', 'ceb02eb6cb234e6098ce75c36dca5563', 'cdf6cee7d12e4095a0a3b6ccd2070433');
INSERT INTO `sys_user_role` VALUES ('9d48a887900e4bbab5403c61cffa4621', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', '883128b3d0a14d5fa529c921c37e906c');
INSERT INTO `sys_user_role` VALUES ('9d74230aa765478bb94b76e9166fd7af', '5b7af7af700448108856051a28172e0d', 'b69303a1e8a14bc8893fd90b6f6ace0a', '030a2e7798c04c09bc475715e541200d');
INSERT INTO `sys_user_role` VALUES ('9dc5f5e6c78a4406a490f601ca368ce3', '', 'd30ae34c68e2437ea2d8dc8f3a2e6945', '5cc71e2d2adc43a4aa43b5739a787402');
INSERT INTO `sys_user_role` VALUES ('9e02ee14f4934c0985517f707147cd78', '4', 'ae9a04c4842e46338853947c9ee3f4b0', 'fdfe3b4a26cf47a6ababbaff37aadb79');
INSERT INTO `sys_user_role` VALUES ('9e02ee14f4934c0985517f707147cd78', '4', 'f1b022847b3440fd8c33524b7ecd06f5', '0e2c24eae50241d38e47075bfbc740f0');
INSERT INTO `sys_user_role` VALUES ('9f6a88b506a1492e9af730c50b863018', '31448f50f3094e11a2537418d41c826f', 'b69303a1e8a14bc8893fd90b6f6ace0a', 'cabc7a6ebf5b4587a941a7496360b709');
INSERT INTO `sys_user_role` VALUES ('9fa59ef194364f0faac3a17cb57f3a19', '4', 'de48a37349524bfba310582397364d3f', 'c40c0638f31a4e8aac76497721130564');
INSERT INTO `sys_user_role` VALUES ('a0b28c1072d6439e8bb3570e2c981125', '5444c73eecb648d5bb02a73cdb7d382f', 'de48a37349524bfba310582397364d3f', 'cb8e57ab3d5944d5810690a14bd5f391');
INSERT INTO `sys_user_role` VALUES ('a0b99f2378564c45803fb94524f064d4', 'dd05adfbb76d48879af046847afabe23', 'de48a37349524bfba310582397364d3f', '27029b7486d040d090d84bf1ca6175cb');
INSERT INTO `sys_user_role` VALUES ('a182fb135d0543c68699166339e96000', '4', '', '4a1f1ec070c0457d9c91e8cb8d5eed79');
INSERT INTO `sys_user_role` VALUES ('a1d4f0c3a91a4d279434a293cac582e7', '044595d92c0049ce9c82d66e453715a4', 'a06c8be19be14ab79f232012132384ab', '25fb26508ebf4fe4a95fde3ef16de55a');
INSERT INTO `sys_user_role` VALUES ('a2888482cace4967ba9dddad2ab1bf50', '3b095ea411604abb8656c85461a775b2', '10815a1166e44fc18dd90e6df702f553', 'e31bb146829f462b8703b9818da8f857');
INSERT INTO `sys_user_role` VALUES ('a350c60e44584b0fb242d065839caba7', 'd83744c197ea49fcb8d6dba6195040a4', '231f0babdad4454b96e607f2f62c6ff4', '2de6fdc098934d8288c4326f853b8b46');
INSERT INTO `sys_user_role` VALUES ('a3ce4493e5ed41a1af4e07fc7b4e89d9', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', 'ae836b945fa844f09633b7832fe5c984');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '01352ab5916d467290cde01dce810268', 'bbeb290640664becaa560d7335fba38a');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '04daab5fd8da4b62906b6b797de39708', '5eb75a99abc546c9bc583ec837c56ddc');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '138628c8bf814913b020fc06730d8862', 'd34e0373315c42378cdbf09a0fe81652');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '1fe0fba575d5429c874d5df8d4172c1e', '1fba53ac83e748c1b597845f6eba4f8f');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '41da1592a2264bf79ae1d8284851e1fa', 'cfe320452c10416ab5068fec9d1cbb95');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '5308ddcfbac94878b4a095d3ae70263f', 'd3e0e8e2c6be414a84f1776676ab8093');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '65a62da1ce2b4e109c0e095ec486ac73', 'f440bc6dd4e244fb98c012f77dc0e85f');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '65d6bae02e2f420584a42c6df0a7e550', 'd7000e168d8941fbb9fb95e42d48420a');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '86c3a37b827c40e8b93047912e4ab069', '9a33038e284246758c2baad5680142af');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '8b99d685ac904a65a3adeae3dce2e2f1', '0916f1ae0ae542788f0e04faca240887');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '90ba522127fb49c68febd26150a5a679', 'ed6eff1b6a6742219cdf2ea05b65800a');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', '9638d39803904ef197fd41a58d27c2bc', 'de68e3e8edad4312ab8e9a20de401b08');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', 'a86cb5a4b1754fbf8bbd06b7df5889a8', 'cfd365da87f94399be9c08d3bc698038');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', 'cfaaecc0b7c047769a8f9d0fc04c91ef', '81b3089fd4d348a4bb438821f4763fa4');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', 'd18e76a4f0e847a5982ec589ec173cb1', '24002bd2abdb49ba9b124769fbdcc421');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', 'f50934455da748acb2fb98fcc4ef210b', '8159e73135ea4929954e638d5d10b1e0');
INSERT INTO `sys_user_role` VALUES ('a4c509a1473a40d9ab03177812c6d280', '4', 'fa5ad41ce4d4481f871cc71e40b5c735', 'f24160005f004487a8e3fc46c18b5a26');
INSERT INTO `sys_user_role` VALUES ('a4c8cdd20ae745b7b903df37b18317ef', 'c7abdd5252044dfe8486dd6ba3f46d56', '1a1e2a243d304ff6bce0bc17f0512b67', 'd78d605017e044f383592185f2cf0bd4');
INSERT INTO `sys_user_role` VALUES ('a526642a8ba6408d8d69cb755dc642dc', '2e235583cb284cd7b63fb21c7fff172c', '231f0babdad4454b96e607f2f62c6ff4', '4492ed7798584f9187ac0f4637212d0e');
INSERT INTO `sys_user_role` VALUES ('a565a3c3bdb94064942c2013cbece255', 'a03b6790be3e48ec84cb195bf51b6312', 'b69303a1e8a14bc8893fd90b6f6ace0a', 'fc8feb4681d2489683bc6ab3f3e256f1');
INSERT INTO `sys_user_role` VALUES ('a5740bf65ddc498e8c757a8a24c69134', '3b095ea411604abb8656c85461a775b2', '10815a1166e44fc18dd90e6df702f553', '7ee984dc92eb4eee993eef1f38457f1e');
INSERT INTO `sys_user_role` VALUES ('a595f65bfb734025af7b0582d88b704c', 'b5a6534664894905a7b980cda52ca01c', 'b69303a1e8a14bc8893fd90b6f6ace0a', 'd0a6e0cffbeb45208ba6e82172bd3cbf');
INSERT INTO `sys_user_role` VALUES ('a6aabc21c96c4120918317397bde5f1d', '', 'e9b75e6e8a5b467786695e13a77f88cb', 'dc327753b8c74400b67258748a665535');
INSERT INTO `sys_user_role` VALUES ('a7298c64ee3b4ac29b608202f34ecf8f', 'fad72387131a4dbb9946c9a66a5ccc8b', 'f6d8e91420794e34bc1b705bdbf0d00c', '12487fac68894f15a790abdbf23f8619');
INSERT INTO `sys_user_role` VALUES ('a936bf74d7334ae085795cfafd2efaeb', '666739d09eb84b59b46dd801519b6258', '1a1e2a243d304ff6bce0bc17f0512b67', 'd4b14360daeb458eac22792a28be8d2a');
INSERT INTO `sys_user_role` VALUES ('a9668609e38b495db96e91cb1bb108cf', '9fc228bf1d0c4469a9ee5e8d8acdac11', '42073f221b984a53877c0b0840cacc05', '769bf694a01641c19ac1d4b4675b8f8f');
INSERT INTO `sys_user_role` VALUES ('aa9e13ff68324ebd8a057ebc9665b06b', '22a2f359d94b4bd696ca72cc3960eafc', 'de48a37349524bfba310582397364d3f', '8ace7320d15a46e8b328e0916548253a');
INSERT INTO `sys_user_role` VALUES ('ab5100071a2e4e6d8db29cbf4e3df99f', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', 'bb209f35852a4719a0d109bbbf6a5844');
INSERT INTO `sys_user_role` VALUES ('abb6a30f0caf410a8a41d0400cd7166d', 'fad72387131a4dbb9946c9a66a5ccc8b', 'f6d8e91420794e34bc1b705bdbf0d00c', '129778deda5e41f8a752be9c5c327b88');
INSERT INTO `sys_user_role` VALUES ('ace352c2c9f14e02906555c69799b41f', 'c7fa7ffe8ad34d0695d5617282149c14', 'f6d8e91420794e34bc1b705bdbf0d00c', '63e9f5cc800142628a99a0b88217eeeb');
INSERT INTO `sys_user_role` VALUES ('ace352c2c9f14e02906555c69799b41f', 'cfbcc586f2a94a7887ad58bd1914426c', 'f6d8e91420794e34bc1b705bdbf0d00c', 'fe457b4148ae4f11ac8b31a1a4a5828f');
INSERT INTO `sys_user_role` VALUES ('ad2e39f7680c4e5a8560eda3b517207f', 'd6f378c854c4458c8b03eeb2c75b1e43', '1a1e2a243d304ff6bce0bc17f0512b67', 'd494a221b854424c9de4fa76c5b00d5d');
INSERT INTO `sys_user_role` VALUES ('ad2e39f7680c4e5a8560eda3b517207f', 'ef309dba67744ad39af835efbeeb31e0', '1a1e2a243d304ff6bce0bc17f0512b67', '17f0721a9be642348eb3b9a4fe88dbbc');
INSERT INTO `sys_user_role` VALUES ('ad2e39f7680c4e5a8560eda3b517207f', 'ef497f582b0a41b7a82344a0ce1b5e05', '1a1e2a243d304ff6bce0bc17f0512b67', '977a6f1a82e1463a9dc1c2e8491cccbd');
INSERT INTO `sys_user_role` VALUES ('ae9e5c7b4ad24d68a131cb9a9d00aec8', 'd587b2e9fd5c45adba5e91de4953511d', 'f6d8e91420794e34bc1b705bdbf0d00c', '098c0b85e1cd49cc9fd7323db36bc66b');
INSERT INTO `sys_user_role` VALUES ('af05afbb144b4a8181a59fbc6098dd3d', '5e1d469c8eee440e95844f02c3e769d9', '10815a1166e44fc18dd90e6df702f553', '234f5554aee24796865e76c81c3d7cea');
INSERT INTO `sys_user_role` VALUES ('b068b8a79bd74cbb9949c178c8eb7cf4', '6ef68c304d6947c889ef0aecdd448968', '231f0babdad4454b96e607f2f62c6ff4', '3970bc90af0044d29e9ffb5c1ca0d8cb');
INSERT INTO `sys_user_role` VALUES ('b17a5b1ffb0343c58d955cb42ebba3fc', '59682135fdb54904808b755ac436df50', '1a1e2a243d304ff6bce0bc17f0512b67', 'a3722c1a56e24850b50a99dbba13e6e2');
INSERT INTO `sys_user_role` VALUES ('b17a5b1ffb0343c58d955cb42ebba3fc', 'ef309dba67744ad39af835efbeeb31e0', '1a1e2a243d304ff6bce0bc17f0512b67', 'defd208c03ed46029d785582c6b09dbb');
INSERT INTO `sys_user_role` VALUES ('b1bd8812d17b437585561e71b30a2a23', '3', 'd3e516d6170a48d694f836eb0269af94', '4836e7f01d834424a710a6711ee927f9');
INSERT INTO `sys_user_role` VALUES ('b20cc26bd5d24509b69f5f0e51479615', '4', 'de48a37349524bfba310582397364d3f', '3611dd17d1804b5097174931c3a28666');
INSERT INTO `sys_user_role` VALUES ('b2870f806fa74751b6961566b5308ffb', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', '033c93e837d84693b5bd3e2a147bfab2');
INSERT INTO `sys_user_role` VALUES ('b2a4b3932a4c4719bf28505e77008a4e', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', 'c6b60663d55244e4b7b3c389f5b4a9f8');
INSERT INTO `sys_user_role` VALUES ('b42f962339024d11966b44e67db0075a', 'f6a6589a8860454cb9c4d64d29619e94', 'ceb02eb6cb234e6098ce75c36dca5563', '78811a3e28564378ac51e10a57308595');
INSERT INTO `sys_user_role` VALUES ('b515b31a143a4a098785fc9bfaf86a29', '3', 'de48a37349524bfba310582397364d3f', 'dc483e091c514d40b7b0ea146e136a6f');
INSERT INTO `sys_user_role` VALUES ('b5328d5a2321412c9266bb50958258cc', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', 'af4beddc31674f60abd979deb38f36ca');
INSERT INTO `sys_user_role` VALUES ('b73ccb2b2af7404d8371fc69fd08ab8a', '4', '', '0646c6fb86e04131b31061b60b6bf991');
INSERT INTO `sys_user_role` VALUES ('b78d8c1af6e94259b45eba9710aa37a5', '4', '', '0e5131a8f26842b5b8b46b448b417351');
INSERT INTO `sys_user_role` VALUES ('b8e83625cbf240aa8305052570b23172', '7c44fdc96dfd4bef87f69caef5abb27f', '42073f221b984a53877c0b0840cacc05', 'ed07c0f872fc4ca1acc9a95e630b52db');
INSERT INTO `sys_user_role` VALUES ('b942bb7698ce40dab82b4433a1fe5281', '678028dc14534a3aa2ee9caf55d6b548', 'd954a734d92d4dc1a21a974533fa4b31', '20fd6272447841e2beb6e3b072264c73');
INSERT INTO `sys_user_role` VALUES ('b9e42abc5c8c4145885f1fb28c036d9f', '2', 'ac5f921eb1c5492780dbc3bb7548718b', '13dc4926cff94cc9bcf69c5cd3d410fc');
INSERT INTO `sys_user_role` VALUES ('b9e42abc5c8c4145885f1fb28c036d9f', '4', '071fef8a79b1425485d1d029321597ab', '66526d50b14f486cbd462db5b6b3e3d2');
INSERT INTO `sys_user_role` VALUES ('b9e42abc5c8c4145885f1fb28c036d9f', '4', '743bf500df8740d399765ed460cf56d6', 'e15915d0443b437f84549e8db639a49d');
INSERT INTO `sys_user_role` VALUES ('ba89b301deba4ce6b93e9273b59acdc5', '6e6b05d894b04a86937c8bd1ee7335fb', 'f6d8e91420794e34bc1b705bdbf0d00c', '291e2120cca5400081a2736566811203');
INSERT INTO `sys_user_role` VALUES ('bbcb927f7718486496764a1579bd211b', '078f7148f3f34e6a99f0f30f6a509468', 'd99a1ee29a874d46845c6e9f3ad80f61', 'b64aa136286d4bdabff578263434c3ca');
INSERT INTO `sys_user_role` VALUES ('bc5e2c0127b244cf98374f4d41883dc8', '3e07e8f9f7c84d97beb3810573cc9410', 'b69303a1e8a14bc8893fd90b6f6ace0a', '99666b28763c4c7282ef7976f586f5a9');
INSERT INTO `sys_user_role` VALUES ('bc8739bcd6ee419681d5ff84bd2bb62c', '4', '', '9e040706dbc04368b0bf117905304e53');
INSERT INTO `sys_user_role` VALUES ('bc960ca471ff46159f2e6a43176f08ed', '4', '', '8ab49d75ea464c4882932daeb1487052');
INSERT INTO `sys_user_role` VALUES ('be2965bb07e2431eb676133cadbf0c04', '5081393be1bb4fff8f9f773e2b837c12', 'ceb02eb6cb234e6098ce75c36dca5563', '130ded031383403f93aa6d3ead6c389e');
INSERT INTO `sys_user_role` VALUES ('bf124bc2f6c544bca7a2f32ba75c2c66', 'cfd52ee9cef94987ad2ae602cc401184', 'd954a734d92d4dc1a21a974533fa4b31', '362d8b2a7516425c8bc9cbc9c996a9e7');
INSERT INTO `sys_user_role` VALUES ('bf386687999040b6a135529de19ce32f', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '81f588512f9d4e33bcb0e9e436157a6d');
INSERT INTO `sys_user_role` VALUES ('bff07b86b10543368c66aa66986a92dd', '5081393be1bb4fff8f9f773e2b837c12', 'ceb02eb6cb234e6098ce75c36dca5563', 'f7f4377b863e4693947cd73a2b04960f');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '0ec78fdfeebe4717a5d0c95f3478d4f3', '5d06fa78a07c444187bffe95a54585c5');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '1169950944dd46b2a525913cfa91b424', '57ece73c7234405ca7999d20936da307');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '1fa805d0281e4c13ba9dfd352790fd67', '9e0669d1818449c9b04046a60d2548e4');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '224c89139b4648a0902c934f79405ec0', 'ad8a40c16afd4ea8bffb1d86ccf46aa8');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '22f4ca9589b44a4d92cf27ad71870186', 'bd10148080794da09f15c3b8bdbb70e0');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '2a851454fe034323aa175253239a1bb1', '7bc225fe1379479ab7781adf424eb962');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '3f971d062c6d4404a13989484f563fa9', 'c727445260284513b4ab176bafe6ce4d');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '42e06962ce8e4452aef007066a21c810', '34ead3fd265e4c7db99975e71c2f847d');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '4ac57f7f4594428dabc17f0ac78ff5e1', '24ba2e922ca64cd284b332420795b29d');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '4de3519526f0423caf9760b18c493efd', 'e3715fcf959842c9b0fc9f46b8ecef9d');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '4e6dfc8520a644dfa2f9690153b6769c', '9a35e62a3b874d768db640eddfcdfdb0');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '5128286a83d54dd7837bb4adb208bfd2', '1647694ff08d443bb34de58fb70c46f6');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '5a9bc0f677a74fe8b9d8cd3a2ea8da37', '78815a602e574f8ebff1e3793698b90a');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '5b8db11a29e54dad9902b2b85ad59815', 'b2fd5a519f3b4bfcb0af77df8fe9d595');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '6251f3fa3d9e4eea93f84d0a103f463d', '145d92d31ec945c2a6d0bbb5fc69b690');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '6c7451da7d78415bade4ddcd8b5ddc33', '2a85cdccb11d4856a7817bc1253ce4ff');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '6ecbd5e0cb224695b55caefe5850ea57', '52e5feb77f1b466fb26fc270c6e8977d');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '70c276ec21734c82b4595831dfd136a2', 'c226384c600c4467938ba44c601ba12b');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '70e518987c6f4755850dc655e75ff125', 'a958747fc27941f788fd86828acc4e60');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '7445c50e77dc4717af4951aef840acce', 'e0c43275d4a1438abe001b3b44b0e4be');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '806ed318d8a74a9fa15a741ecb5aedb6', '3d905e34a5114617b9e07381a9c78eef');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '9c69cb551d29404b90ab838be68ef8e8', 'ba4a3984aaf34b6ca57d531f8a826f8c');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', '9e1fabb6372a4b049a02d690f18582fe', '969e535be87e43e58c5c8e29fb17b967');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'a709c01f2ab342aea949518285d84fb4', 'e6a5cd783e804a7d91fffecf409546fb');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'a97809bc6319432b818e662445a9f085', '52d21376385c4e239ce9f83e6271f838');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'ae07f9b21587426b895d2c19295935c4', '582550bd1c6743a59d34d963200017e1');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'b37e0836aeda41a48b4860d75e5844c7', '9ef18b909b004fadb4a3940a565e6929');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'b68f60e24d4b45c3b30458a6c098b933', 'a622ea7eb8b54e6fa968ef7e6a80b847');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'b6b18ba63f6842b7851efebea0d71af2', 'cbd1434852d34ac7b771ae968d17acb1');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'ba02b769408043d7944c4d0a9efaf27c', 'ede6dbc3ed774f4a96a293fad7c932ee');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'c275515bbb884578a8189b11442c5b7d', '319f8e024e324ef6b44f8e8aa7bc2694');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'c68df603cfe14d7bb2c1c5a5d2d21db3', 'a8cdb0f8bdd640bd8a58e3fd2c7b579e');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'c97ee75e41414a7b9b27ced2f3d15038', '3647aa69648d4701a78c5354f8a5c70c');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'd005686d010c4c6fb0586c335833b6ca', '06ce7322d871425f838bd521f2612083');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'd43156fc5cf943be811a01ce4462f276', '098128bc16fd4072aa7d597029084a8d');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'd478cc5f35e74edfb09f01fbadd8288d', 'fe0e0a86a71a4ecea3935367e17bd3d5');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'db3a9eb9c4fd40f494dfa0533423e1a9', 'ec9ac47950154f2388fce7a8614b33f9');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'e15d5ccb31014894bcfc4927703f5202', '31708c171daa4637a9a76cc68aff1952');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'e60c8ad21cee446997fce97353ee14da', 'ff2ef0dd16a3494a8323a24bfe7567fb');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'eee1e3f032a74487bc50ac205242a617', 'b251ae3cde9c4d39bfd7d4a2b021c287');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'f304852c3ee742ecbf0f670adfea1341', '3aed44bbbc4a49079efe08c3256dd134');
INSERT INTO `sys_user_role` VALUES ('c226bde8fe7a4fbd82500e061265d24f', '4', 'f4ae639295854abc80c0d9a445dcd5e0', 'f057f0771c934a6cbdfb2c8ede7389aa');
INSERT INTO `sys_user_role` VALUES ('c2f16b225aa54eab8fddccef4c325dce', '8a64e83e1eef48d088a0191e2bea17fd', 'a06c8be19be14ab79f232012132384ab', 'c5551fd8b9d248949acdd4bf7d483707');
INSERT INTO `sys_user_role` VALUES ('c5bbf9f284294f22b31f79977768391a', '4', '1a8807d03afd44ddb136291e84ec5eb8', '4d967c96cb6f4fd28a9a78d055f0f384');
INSERT INTO `sys_user_role` VALUES ('c5bbf9f284294f22b31f79977768391a', '4', 'b0a32fe11ec74107a410b75681155bf3', '9095683aaa2746538bb421c8491980fb');
INSERT INTO `sys_user_role` VALUES ('c99d2990181845c6898b612b7a201096', '4', '', '96ed76012ed64dad86296ad17fc3fb20');
INSERT INTO `sys_user_role` VALUES ('ca76ad3eace142d7b9ac2f79b749ffb6', '524945b5fc4d4ba4aa9d0c0346468c5e', '10815a1166e44fc18dd90e6df702f553', '8077200db55049fbb3d1720434540aac');
INSERT INTO `sys_user_role` VALUES ('cb7ff224bf914590a60b163867b5cbfe', '4', '', 'd03c007102ed442ca84fe8641a9d8998');
INSERT INTO `sys_user_role` VALUES ('ccd43e3a714e431ca9f8c5389afc9a44', 'faf90a2cb28843b7898306cf2e5d391c', '10815a1166e44fc18dd90e6df702f553', 'b927c1bec58c4fc19de39a6a87fe27ac');
INSERT INTO `sys_user_role` VALUES ('cd5d671af85346dba6ffb57e4775a71c', '4', '', '6bc1d8da85134599a4f40ff172f62013');
INSERT INTO `sys_user_role` VALUES ('cd5d671af85346dba6ffb57e4775a71c', '4', '9f7dc9e3de484f5cafce1f66c3ca40ce', '9ec7c873c8ac45539d173f47000256c9');
INSERT INTO `sys_user_role` VALUES ('cdb36a07faca449da88539e27e0b4b74', 'e063c5975afd49d187b239510b4eff77', '10815a1166e44fc18dd90e6df702f553', '5edf19aa76d241f69de04c60e13ec2c4');
INSERT INTO `sys_user_role` VALUES ('ce6507fa11224868b8a93d7e6dcc7fdd', '4', '', '7c0e03790b624715bb48b0f49ae36c31');
INSERT INTO `sys_user_role` VALUES ('cea462cb0b1c4a5986eb051b944352cf', '3', 'de48a37349524bfba310582397364d3f', '04e56cadaeb444bea098e3ed17d05c9f');
INSERT INTO `sys_user_role` VALUES ('cea462cb0b1c4a5986eb051b944352cf', 'a816d265374b454e86a347303d7a46cd', 'de48a37349524bfba310582397364d3f', 'a85a7a995930433193d4b9068801bca5');
INSERT INTO `sys_user_role` VALUES ('cfb007b3f48445c48e270fb36d5aea41', '5a2689745d5b4c3c9eb6ae47b61d442e', 'd99a1ee29a874d46845c6e9f3ad80f61', '2aaad8ff620048288b6ac7c02ac1ee85');
INSERT INTO `sys_user_role` VALUES ('d25b93f43c74485e99d6f50f8a60a1a5', '22a2f359d94b4bd696ca72cc3960eafc', 'de48a37349524bfba310582397364d3f', '81a7f57e28174d38914176a2c87ad3c8');
INSERT INTO `sys_user_role` VALUES ('d25b93f43c74485e99d6f50f8a60a1a5', '4', 'de48a37349524bfba310582397364d3f', '0387c35b9e234373b8ad45feb2e94b5a');
INSERT INTO `sys_user_role` VALUES ('d25b93f43c74485e99d6f50f8a60a1a5', '496c0dce7f744c5083ca52f6b7b49bef', 'de48a37349524bfba310582397364d3f', '86539dbdfa4e4d2b9576a1967f141631');
INSERT INTO `sys_user_role` VALUES ('d25b93f43c74485e99d6f50f8a60a1a5', 'e629b0f278a0417c99d8c06614424252', 'de48a37349524bfba310582397364d3f', '281e986fdefe4971b254735b78a0f000');
INSERT INTO `sys_user_role` VALUES ('d2a8fb630c4b498db069310448398c5d', '76e6135175c44678a70c4f11af3d80af', 'a06c8be19be14ab79f232012132384ab', 'cd020d31440644f3b40ead271b02888d');
INSERT INTO `sys_user_role` VALUES ('d2d5c9f1d7e24e83a17ebad5853aacbd', '4', '38cec2bda01544fc81ef0a35b8811474', '0115ee1fb143485d92f095e8f23af2b3');
INSERT INTO `sys_user_role` VALUES ('d2d5c9f1d7e24e83a17ebad5853aacbd', '4', '4ea2af57209c4fe1a8d683b11e91df62', '5308cc14aa5b47438b64cfefeb76db7b');
INSERT INTO `sys_user_role` VALUES ('d2d5c9f1d7e24e83a17ebad5853aacbd', '4', '689d6e3aa6454dad80e6f5194466bf9c', 'b24ae6204d2545b7ba8117379b944446');
INSERT INTO `sys_user_role` VALUES ('d2d5c9f1d7e24e83a17ebad5853aacbd', '4', '8aa894008ed241f89dc41dd86a32fc51', '4b720aca15454dc998aa7a2b4bc9d458');
INSERT INTO `sys_user_role` VALUES ('d2d5c9f1d7e24e83a17ebad5853aacbd', '4', '8bc4d052de8a4a48ae0b928a322eb922', '0e6a3e7d26944222bb58c5e34941d65a');
INSERT INTO `sys_user_role` VALUES ('d2d5c9f1d7e24e83a17ebad5853aacbd', '4', '92480e5176f24be2b5872f8455932466', 'd6006e4bc709457ebc8f6be33ac6df5f');
INSERT INTO `sys_user_role` VALUES ('d2d5c9f1d7e24e83a17ebad5853aacbd', '4', 'bc607e183683424f9073b6466ba6a80a', 'b58766c8a54a4cdf97dbab17ea561e89');
INSERT INTO `sys_user_role` VALUES ('d2d5c9f1d7e24e83a17ebad5853aacbd', '4', 'f1b579906a2a468ba548d022d758083a', '2ebfb27d5a774c81b70cfab0ba9e06d8');
INSERT INTO `sys_user_role` VALUES ('d2d5c9f1d7e24e83a17ebad5853aacbd', '4', 'f4bfd46662504ce2b037be0195ce6870', '9b3d7bb09542426f85caefd3adcb1417');
INSERT INTO `sys_user_role` VALUES ('d6e8b3ad0cae40579dc7d3320e8dfdff', '3', 'ac5f921eb1c5492780dbc3bb7548718b', '94a603b89df742be94d66f8c11808ab8');
INSERT INTO `sys_user_role` VALUES ('d6e8b3ad0cae40579dc7d3320e8dfdff', '4', '9af918016ad84c4a9a2d3a678c5a0863', '5affc5f25446490fb72d5b0b6c007bb5');
INSERT INTO `sys_user_role` VALUES ('d6e8b3ad0cae40579dc7d3320e8dfdff', '4', 'bf282a36d2254ef3a2f8d74d092f1da7', '37d622ffe1b44d4ab4af0a11a74d8c62');
INSERT INTO `sys_user_role` VALUES ('d8951f7dd02447cdbba3c84841bd8656', 'b1670255bb3e4337a18a890354061cc1', 'f6d8e91420794e34bc1b705bdbf0d00c', 'def79984167947fea84e3813217fb1e0');
INSERT INTO `sys_user_role` VALUES ('d8db36000a4f4162877eced8c38c3fe3', '09b642e794644997924750a33e627e91', '42073f221b984a53877c0b0840cacc05', 'ae36e9d7b40a4333bbe60bcef88c981c');
INSERT INTO `sys_user_role` VALUES ('d98e7567f15f4a7cae3518e65d174cfd', '613e3c847efe428ba8e4d50db09fd76a', '42073f221b984a53877c0b0840cacc05', '1af8bc8d7dc047138e3163493476d551');
INSERT INTO `sys_user_role` VALUES ('daaf55662b134374a5b96a3d2066c635', '4', '', '3e027edfcf0d4c3abb89e81bc40b9818');
INSERT INTO `sys_user_role` VALUES ('dab5d0f6db894d63825dc1416a4c6b39', '4', '', null);
INSERT INTO `sys_user_role` VALUES ('dc065c8495e54dd8afb60059caaa80ed', '90b19d82c6b24321a936436a3f15cb75', 'b69303a1e8a14bc8893fd90b6f6ace0a', 'df44589ab6dc4b7cb5c14e6031e3a472');
INSERT INTO `sys_user_role` VALUES ('dc37acd749ae4055b8d767d30d71f16d', 'e9f0f5f5ddeb42038804176d53ca74e8', 'd954a734d92d4dc1a21a974533fa4b31', 'ce83bdc1a412427bbc96dac87b8728ef');
INSERT INTO `sys_user_role` VALUES ('dd54dff717c8413b8c88277c1f11259c', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', '9847b67450414c388b3ff9e01fb0f6db');
INSERT INTO `sys_user_role` VALUES ('de25085cc33c4b5db63a8eb16a72284c', 'b2c12cfffbaa4de8a988f2e555b0c0e6', '03bce32ada6e427bb82a36da50a75d3c', '49bcbaaa3443431ab5cb34c370b8603e');
INSERT INTO `sys_user_role` VALUES ('df328657347b4351a73a617321042be5', '0a47fed8abe1418b8181a3cc8acda6b3', 'a06c8be19be14ab79f232012132384ab', '493a424327e54306824035e2088c13e7');
INSERT INTO `sys_user_role` VALUES ('e10f686dcc8d43b982feb2bba547b26e', '4', 'e4306b927df34abbb6366f1c0d23352a', 'f75da739efea49788091a499c80bd613');
INSERT INTO `sys_user_role` VALUES ('e2a3a4f9f1da402f90e48710103bbb2b', '2', 'de48a37349524bfba310582397364d3f', 'c3a95eb1047d4ef5a9ffb1c90624af56');
INSERT INTO `sys_user_role` VALUES ('e353873a5b62425db95380c29a68d579', '59682135fdb54904808b755ac436df50', '1a1e2a243d304ff6bce0bc17f0512b67', 'ad5c1113b587486bbcf4aa66e1516abb');
INSERT INTO `sys_user_role` VALUES ('e353873a5b62425db95380c29a68d579', 'ef309dba67744ad39af835efbeeb31e0', '1a1e2a243d304ff6bce0bc17f0512b67', 'b5a477ffd21e4c288d28cc70da8f0b1b');
INSERT INTO `sys_user_role` VALUES ('e399b83775d34a1dae000963778101a5', '8616a8d609394ba2acc537f726e9b1d4', '10815a1166e44fc18dd90e6df702f553', '93f33fb3dfd643f282c3159f95b4f01d');
INSERT INTO `sys_user_role` VALUES ('e3e1d31f4acf4712aa125907d09b8f2f', '3b095ea411604abb8656c85461a775b2', '10815a1166e44fc18dd90e6df702f553', 'f1ee801c77044fc88d35cabdb46090b4');
INSERT INTO `sys_user_role` VALUES ('e47b2387883442c0b989d2d80a6e8021', '710b3aac9bfd4ab0aaed5aa50e51f8ab', 'de48a37349524bfba310582397364d3f', 'f414bc15d0974cabb8e8124ef5055370');
INSERT INTO `sys_user_role` VALUES ('e48c1b39f9d84b7b96b0eb6b47fc0ede', '4', '', '1545c3fad1374f9ea0aa83c42031b6e0');
INSERT INTO `sys_user_role` VALUES ('e4f3e8a5b4184344b7db6faedc304be8', '5c7245e305644e3a901ac05742e3990a', 'de48a37349524bfba310582397364d3f', '979ea566fb08464386444ecb5649aa3e');
INSERT INTO `sys_user_role` VALUES ('e4f3e8a5b4184344b7db6faedc304be8', 'a816d265374b454e86a347303d7a46cd', 'de48a37349524bfba310582397364d3f', '1af7557396c6418f9aa97bb90f30782f');
INSERT INTO `sys_user_role` VALUES ('e5341bb5535347c38ab553dbb984336d', '4', '', '5e140b17e16d4798b77784266fea0771');
INSERT INTO `sys_user_role` VALUES ('e574bfaeebcf4af68ab3cbe7fcf9f33a', '815808c9438a4277b02891c82232c825', '231f0babdad4454b96e607f2f62c6ff4', 'bfbcf3fff9474afa94e815feb5b59365');
INSERT INTO `sys_user_role` VALUES ('e5e139fc573341598f777316563fcd01', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', 'cc3d75c9989b4f169b626dc7f76c5586');
INSERT INTO `sys_user_role` VALUES ('e5fce3825c074fcdbbc71227c805584e', '044595d92c0049ce9c82d66e453715a4', 'a06c8be19be14ab79f232012132384ab', 'a0dbf1bc995540d083280f94802e7d91');
INSERT INTO `sys_user_role` VALUES ('e6198825bd0e4081a2d4c15b35b93980', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '7fc6f754a92a486fb789feb22f3e95e0');
INSERT INTO `sys_user_role` VALUES ('e66e6bbdb6ba4292abeb4b5826c2983a', 'aa8ea1db57b94075a61200e7fbe7f949', 'd954a734d92d4dc1a21a974533fa4b31', '94be8dc938a740eda1bf3a9c25112665');
INSERT INTO `sys_user_role` VALUES ('e7ac64582de24ccebcb9b98280166a9a', '51c3954f0bfa46179cc7b3e9ca7bd345', '1a1e2a243d304ff6bce0bc17f0512b67', 'a7f6150f57f648779c2269ef0cec0afc');
INSERT INTO `sys_user_role` VALUES ('e8767ba55f8243cf85dc8eb437798376', '70e9f6148ea545b8845fdb3e3e3a37e6', '10815a1166e44fc18dd90e6df702f553', 'f81376b8b99648b6a675cf1a6fa4e528');
INSERT INTO `sys_user_role` VALUES ('e9d66ccf6add4b2aa011f98fe038b405', '710b3aac9bfd4ab0aaed5aa50e51f8ab', 'de48a37349524bfba310582397364d3f', '37e5bedda34641c0a363c2d27d446fb9');
INSERT INTO `sys_user_role` VALUES ('eac7fb82f62841dcba2321cf8f2034b5', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', 'ee3638b52ca24504bcc4358e154e25c5');
INSERT INTO `sys_user_role` VALUES ('ec0220f5cbf749c79cd9796f38c39de6', '81a9c0555fee474db8c4ef9ebbe5ca76', 'd99a1ee29a874d46845c6e9f3ad80f61', '8f0a4462c139482a83f0528579c72c04');
INSERT INTO `sys_user_role` VALUES ('ec2393a6b53549e9bdd41203ea3a60f6', '8dd3a0a719ce422dab1b281be5369254', '231f0babdad4454b96e607f2f62c6ff4', '150a218dba0244c485e2f37a18d74667');
INSERT INTO `sys_user_role` VALUES ('eca5f5fa5f5e4ba0b359e030dbee92e3', '2', 'de48a37349524bfba310582397364d3f', 'cc4abc9c169e4ea99113abdf1c4e566b');
INSERT INTO `sys_user_role` VALUES ('ed33f07941f54adc84d0982b9376c435', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', '31420d3ce2de4b1bb504177f76db0317');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', '0d0a7b00819c4289ba64109796b75336', 'adfa36c8f7994cb6ab7b6a96b9fbc910');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', '4d2514e44559402ca9fb642acde43e20', '0c7d7c18b9b047a999a8b65637cdc9f2');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', '4ea4b0cf305d480ca01a19579ebe6fbe', '251e3b7fc733465583076755b66e0064');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', '50bc1e34540140d988445b9fef3ddd22', '758e7c45dddf4134bb6c4cbfd9c932fd');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', '51dbcc06be2848eaac5ddf449d402a6e', 'b054f92db2a243c6b234a53b5778e679');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', '5b27587ff73e499e8496eec3db72b13b', 'edd9347c31d947bcb4c657d3babaf066');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', '630e91a8395b48f9b39e0907b5006be7', '17ed0ee36aed476e9fd2e73f47941dc7');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', '884ac41aaa6e42cc8bd987a1e1dfaf6c', '4d7a458249254da4ae8fab04b7979220');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', '93561dc1188a4d4ab5b18bf9bf885430', 'c31334585f904a0e97eb93b66dd3b3d2');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', '94dc602cc63d44b0a1e5de915236fe29', 'b9ef4e8ef7bd4788942ba21533b5ec00');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', 'a763148fedab4afa81ae39cd258c8725', 'd222b03b1f52425ca4d14ad75c1aed6a');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', 'aa7bdfb0660b40268617247e17e5f946', '9d51a8e5e54848ef975ecbfe8080527d');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', 'ac5f921eb1c5492780dbc3bb7548718b', '14887c2501d44ab5b9b546554d5625d0');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', 'be4a4038c2e74970846bf1f9fa197151', 'abe4ea8ab6b04c97ad38ea6e044f6f79');
INSERT INTO `sys_user_role` VALUES ('ed37d9f1b3584361a998f7686434b6b6', '4', 'ea60c8c85b7c4194a1b5fc12df3cb5eb', '7199e11de07b4e82bec4532273f4ca90');
INSERT INTO `sys_user_role` VALUES ('edb4a9b1e0c94739a80e68768320597d', '3383627a82154bdaa215dec3cb13fe57', 'ceb02eb6cb234e6098ce75c36dca5563', '230284eb32814f91946244b182984c0a');
INSERT INTO `sys_user_role` VALUES ('eeb1224f92dc45aeb3b041867de4d8f2', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', '2eb0e7b24cc5435cb6effe76609b4894');
INSERT INTO `sys_user_role` VALUES ('eed66f2705d84eef9bc5dfb15c859b9a', '4', '', '42f75584867c4fd9a8977e06f2c19f21');
INSERT INTO `sys_user_role` VALUES ('ef16953876f04065b0d3df6230f67b8d', 'fad72387131a4dbb9946c9a66a5ccc8b', 'f6d8e91420794e34bc1b705bdbf0d00c', '2425410525154b709c7e559651a2b0ed');
INSERT INTO `sys_user_role` VALUES ('ef2122f5df30480db805e300861b6ac7', '835612121e9842069f09a5d71573221c', '231f0babdad4454b96e607f2f62c6ff4', 'b135e7d10ab74c2aaa04071eaec9b766');
INSERT INTO `sys_user_role` VALUES ('ef6d091542f64dfeb7e18b53a107bac5', 'c0a23f9e4e01496382f4c1ec8ed8cd74', '231f0babdad4454b96e607f2f62c6ff4', '5e723e7bcdcb40f08f028959dd225902');
INSERT INTO `sys_user_role` VALUES ('ef9ff3c8411a4460a3594d4b16499064', '4', '', '26682a694c4c4ee89dbe823aedf39b9a');
INSERT INTO `sys_user_role` VALUES ('f098d3570c814a7ebba97b9f018f2511', 'b1ffc3e95f2249ee8db48670af967c2b', 'a06c8be19be14ab79f232012132384ab', '4e9762bcaf9443d993bee5cc78856b89');
INSERT INTO `sys_user_role` VALUES ('f09dda5a858d42c691d331c34b4a679c', '80c1813d6b674dc9bf0c378ab7f623b3', 'a06c8be19be14ab79f232012132384ab', '0cb358d690d14ab792dc1120ac78a2c1');
INSERT INTO `sys_user_role` VALUES ('f0ed3a83cc17437fbd6042a0be9b412d', '5081393be1bb4fff8f9f773e2b837c12', 'ceb02eb6cb234e6098ce75c36dca5563', 'f1e608bd18d74b698228bef1afd4567a');
INSERT INTO `sys_user_role` VALUES ('f1aa536d2f5b4cab85dd231c328877a7', '2a07aba3f25941538478f4a0032a9bbd', 'd954a734d92d4dc1a21a974533fa4b31', '19a6833680f24106b6a570be1a791d6d');
INSERT INTO `sys_user_role` VALUES ('f22a9c5e72814e3cac7ef8fa50db97b5', 'd278a07415134ea1aff1dd68df9ad35c', '', '03db3464934d4ea1a902ae01d08ef8b6');
INSERT INTO `sys_user_role` VALUES ('f2ca21044812498eb4e6e80fbfd18e09', 'ead65787c8f940258384896c909cda01', 'd99a1ee29a874d46845c6e9f3ad80f61', '41d4d645137c4351a3eaf0e61910605b');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', '0c4114f8465d4e9cb3da0ebd15a65ec7', 'a5a1eb9f53ee4526a53d7b3d61095749');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', '17877dfa3f3e43c194a9131656f0999c', '8de71460580d452fa96161bf17155da1');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', '2cb878cb7d1f426b9fdd4f9d5e712b9c', '09cbeec0539349bfa54fa7208d2cb048');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', '3ebb5695783e4f828380a2a73ac6813e', 'de6f1f5b0a10441eb2621a5ac5a4fa8f');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', '447c683cf20a40aabf79c3a3bf3fe8c8', '13e6d8c369914812a8b10b77b141aecd');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', '511a081a5d3046949613fa3a01971a78', 'd091748a721a46658f2a788aea91143d');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', '592802b16c334f99a366c29d841c8f80', '368c73d5b40441d3b5dd722ec4791c79');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', '693b512e33e143a59e1da18a978cc4dc', 'dbc5011a1ee842e78cd5299d11cab3df');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', '87333262404647e29d8199ff9156ea0b', '0eb6bced68104aab9638e4731f486b23');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', '91b5ace09cee4f05a4e38c55072c11c1', 'afe6f7624ee541c9bd2bd17384e7f4bc');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', 'a5a54df906db4f4fb770c73adebe5007', 'f50cab27009544e3b926897e7b584231');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', 'a837dadc91f14ed6aaf429becca4bc47', '00ac023a75ee48f89935b0a8d42b1bc2');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', 'ab3412661f8341b186849f753b4e3e2f', 'c2b332fe923644168a5c4ee287e9e862');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', 'c2c1b66639064dff9f5e99f1379ecffc', '9ad6e4ff6f1642a982a9f4a0c0fec6ff');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', 'c472a3f131824f43a8984daf831b6704', '0b63e705af154eedaddaccbb7f6a7b10');
INSERT INTO `sys_user_role` VALUES ('f5105b0c00764b58ac7fc3c65f1b27d4', '4', 'e1d52d311f7a4f838698f89632c8314c', '60cb48130d8942c5a58feb57bcd58275');
INSERT INTO `sys_user_role` VALUES ('f74b4b5809d74d90b1a3f18ecf14fc03', 'fad72387131a4dbb9946c9a66a5ccc8b', 'f6d8e91420794e34bc1b705bdbf0d00c', '2723f8eb32b2471a914c83059b99142b');
INSERT INTO `sys_user_role` VALUES ('f8afedd8ea014b1089cddcf1a714fd3b', '7fa0a08a85954df2a58f2deaca05578f', '1a1e2a243d304ff6bce0bc17f0512b67', 'c8b740d3601f4594a49c3854ca321b72');
INSERT INTO `sys_user_role` VALUES ('f9e3a9dc4c324e91a5f7a9431519f273', 'c5670f238a52405f8bba8ea6d3cd1ce0', 'ceb02eb6cb234e6098ce75c36dca5563', '3f36b599463a41e8ad255c0e7fe9e0a1');
INSERT INTO `sys_user_role` VALUES ('f9e3a9dc4c324e91a5f7a9431519f273', 'f7e518ff739743d78386b1a1ef121bd6', 'ceb02eb6cb234e6098ce75c36dca5563', '708e266d9769418397bea9649f5b7ba0');
INSERT INTO `sys_user_role` VALUES ('fa8380a70e5746789ddf9a2d3956b179', '3254a918f24e44f88454ae382a0ecbea', '1a1e2a243d304ff6bce0bc17f0512b67', '51fb50f66e6d42e89ca6aaa04db49639');
INSERT INTO `sys_user_role` VALUES ('fae34b105f6041edabe15795a0bfbb23', '66a7412ce1d94e81ba6e3698f0adb711', 'd99a1ee29a874d46845c6e9f3ad80f61', '5060501a9c9a4fcabc1fed875e7a2360');
INSERT INTO `sys_user_role` VALUES ('fc2a74a782804450a722e81662b4a2d6', 'ef309dba67744ad39af835efbeeb31e0', '1a1e2a243d304ff6bce0bc17f0512b67', '035ac5a774d44b58a2ee4852bcde7602');
INSERT INTO `sys_user_role` VALUES ('fdf46b69492544398d6676a44c7adff3', 'baafb9b4b3d945fea261c3fe96c542ab', 'd99a1ee29a874d46845c6e9f3ad80f61', 'd1ca856602114b65b4eb1a075dac8661');
INSERT INTO `sys_user_role` VALUES ('fef01c3e89d64d369f8349a32a1051ba', '4', '', '5d7a466bca1848438056a90b6178d20a');
INSERT INTO `sys_user_role` VALUES ('ff5a9f0d5f494edda96ad3cb141ebe2f', '8719beb8888a448daf0fdc951e358e0e', 'ceb02eb6cb234e6098ce75c36dca5563', '0b1d950ae251450593bcb92d55ee5803');
INSERT INTO `sys_user_role` VALUES ('ffe0c46e4ae64348919428e7b2156e57', '496c0dce7f744c5083ca52f6b7b49bef', 'de48a37349524bfba310582397364d3f', 'd01a9a7349d44fdb8c39b92e256a94fa');
INSERT INTO `sys_user_role` VALUES ('ffe0c46e4ae64348919428e7b2156e57', '5edb192aac45446d8a62dbe6c3c0cc23', 'de48a37349524bfba310582397364d3f', '119c3d6c46044e2099f1f131374ac42c');
INSERT INTO `sys_user_role` VALUES ('ffe0c46e4ae64348919428e7b2156e57', 'e629b0f278a0417c99d8c06614424252', 'de48a37349524bfba310582397364d3f', 'a9b598902b54448fb49d17a9529ef82e');

-- ----------------------------
-- Function structure for currval
-- ----------------------------
DROP FUNCTION IF EXISTS `currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`223.85.203.140` FUNCTION `currval`(v_seq_name VARCHAR(50) CHARACTER SET utf8) RETURNS int(11)
BEGIN
   DECLARE VALUE   INTEGER;
   SET VALUE = 0;
   SELECT current_val
     INTO VALUE
     FROM nj_id_sequence
    WHERE seq_name = v_seq_name;
   RETURN VALUE;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`223.85.203.140` FUNCTION `nextval`(v_seq_name VARCHAR(50) CHARACTER SET utf8) RETURNS int(11)
BEGIN
   UPDATE nj_id_sequence
      SET current_val = current_val + increment_val
    WHERE seq_name = v_seq_name;
   RETURN currval(v_seq_name);
END
;;
DELIMITER ;
