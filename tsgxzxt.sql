/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50736
Source Host           : localhost:3307
Source Database       : tsgxzxt

Target Server Type    : MYSQL
Target Server Version : 50736
File Encoding         : 65001

Date: 2024-03-24 11:09:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `advertiser_info`
-- ----------------------------
DROP TABLE IF EXISTS `advertiser_info`;
CREATE TABLE `advertiser_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公告名称',
  `content` longtext COLLATE utf8mb4_unicode_ci COMMENT '公告内容',
  `time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公告时间',
  `fileIds` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品图片id，用英文逗号隔开',
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='公告信息表';

-- ----------------------------
-- Records of advertiser_info
-- ----------------------------
INSERT INTO `advertiser_info` VALUES ('19', '测试资讯', '<p><strong>办公设备报修系统哪家公司的好</strong></p><p><br></p><p>作者：介靖柔&nbsp;发布：2022-03-25 09:55:49</p><p>438浏览</p><p>	</p><p>	<strong>一、威之德信息-百人团队国家高企</strong></p><p>	1、介绍：河南威之德信息技术有限公司是一家为企业提供集设计、研发（系统应用、APP应用、微信应用等）、营销服务为一体的综合性高新技术企业，公司荣获国家双软（软件企业、软件产品）认证，经过河南省科技厅授予河南科技型企业、郑州市科技型企业称号，拥有26项由国家版权局授予的软件产品著作权证书。入驻猪八戒网平台8年，合作客户1000+，获得猪八戒网皇冠服务商，行业服务之星等荣誉证书。...</p><p>	2、质量评分：4.80;已获得：227位雇主推荐；</p><p>	3、近半年成交：3,723,138元;好评率：100%；</p><p>	4、擅长：APP开发、小程序开发、网站定制开发、行业软件开发</p><p>	5、关联服务：<a href=\"https://shop.zbj.com/11615573/sid-1677246.html\" target=\"_blank\" style=\"color: rgb(51, 51, 51);\">家政小程序开发服务APP软件报修维修订单系统保洁预约管理系统</a></p><p>	6、雇主评价：★这个团队非常棒，专业性强，服务态度好，祝愿团队的每一个人：承乾坤之正气，立天地之威仪，自是成竹于胸，所行风雨无惧，前程似锦，平步青云，步步高升，羽化为龙(鳳)</p><p>★整体开发服务不错、满意，技术团队实力很强，开发效率很高，敬业负责，现在上线运营挺顺利的</p><p>★想做个家政APP，经过对比核对，最终选择了他家做APP，非常有耐心，给我讲解了很多有用的需求，价格不贵，很满意</p><p>	<img src=\"https://homesitetask.zbjimg.com/homesite/task/2021/12/17/1.png/origine/db04a5e2-4f33-47cb-9abd-8539c8dd9886\" alt=\"办公设备报修系统哪家公司的好\" width=\"400px\"></p><p>	<img src=\"https://homesitetask.zbjimg.com/homesite/task/2021/12/17/4.png/origine/06eefae0-c6eb-46c8-89c7-e47c927b50db\" alt=\"办公设备报修系统哪家公司的好\" width=\"400px\"></p><p>	<img src=\"https://homesitetask.zbjimg.com/homesite/task/2021/12/17/2.png/origine/ba0262b9-5d76-43ad-867d-b4ee4fd393b4\" alt=\"办公设备报修系统哪家公司的好\" width=\"400px\"></p><p>	<strong>以上是办公设备报修系统哪家公司的好的相关服务商推荐：</strong></p><p>		1、本数据根据猪八戒网现有服务商数据运算推荐最佳匹配推荐，排名不分先后；</p><p>		2、各项数据在发布时间7天统计完成，我们汇成表格，旨在帮助更多有需求的朋友快速找到心仪的服务商；</p><p>		3、若以上数据无法满足您的需求，您可以直接联系商家或者联系我们的在线客服，我们将提供一对一在线咨询服务；</p>', '2024-03-11 00:03:27', '[49]', '测试');
INSERT INTO `advertiser_info` VALUES ('20', 'xxxxx', '<p>xxxxxxxxxxx</p>', '2024-03-11 00:03:27', '[null]', 'xxxxxxxxxxxxxxxxxxxxxx');
INSERT INTO `advertiser_info` VALUES ('21', '测试', '<p>现在这些数据均为测试数据到时候自行修改即可！</p>', '2024-03-11 00:03:27', '[51]', '测试');
INSERT INTO `advertiser_info` VALUES ('22', 'xxx', '<p>xxxxx</p>', '2024-03-11 00:21:09', '[null]', 'xxxx');

-- ----------------------------
-- Table structure for `nx_system_file_info`
-- ----------------------------
DROP TABLE IF EXISTS `nx_system_file_info`;
CREATE TABLE `nx_system_file_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `originName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '原始文件名',
  `fileName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '存储文件名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='文件信息表';

-- ----------------------------
-- Records of nx_system_file_info
-- ----------------------------
INSERT INTO `nx_system_file_info` VALUES ('17', 'aq.jpg', 'aq1646036412229.jpg');
INSERT INTO `nx_system_file_info` VALUES ('18', 'Huoluan.jpg', 'Huoluan1646036446432.jpg');
INSERT INTO `nx_system_file_info` VALUES ('19', '1.jpg', '11646159810572.jpg');
INSERT INTO `nx_system_file_info` VALUES ('20', '微信图片_20220226151536.jpg', '微信图片_202202261515361646159825910.jpg');
INSERT INTO `nx_system_file_info` VALUES ('21', '微信图片_20220226151549.jpg', '微信图片_202202261515491646159847489.jpg');
INSERT INTO `nx_system_file_info` VALUES ('22', 'ysq.jpg', 'ysq1649801585651.jpg');
INSERT INTO `nx_system_file_info` VALUES ('23', 'ysq.jpg', 'ysq1649801733190.jpg');
INSERT INTO `nx_system_file_info` VALUES ('24', '2.jpg', '21649802231428.jpg');
INSERT INTO `nx_system_file_info` VALUES ('25', 'Erjmch4Pohq06b9b42b8cc32fbc04559b5d530ef1411.jpg', 'Erjmch4Pohq06b9b42b8cc32fbc04559b5d530ef14111650318963556.jpg');
INSERT INTO `nx_system_file_info` VALUES ('26', 'a8x3Yy88lU1H6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'a8x3Yy88lU1H6b9b42b8cc32fbc04559b5d530ef14111650319013222.jpg');
INSERT INTO `nx_system_file_info` VALUES ('27', 'AyzTzaopvlLT6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'AyzTzaopvlLT6b9b42b8cc32fbc04559b5d530ef14111650319082799.jpg');
INSERT INTO `nx_system_file_info` VALUES ('28', 'hhFnJb9FDTmY6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'hhFnJb9FDTmY6b9b42b8cc32fbc04559b5d530ef14111650319207232.jpg');
INSERT INTO `nx_system_file_info` VALUES ('29', 'UpN4lrKLzysh6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'UpN4lrKLzysh6b9b42b8cc32fbc04559b5d530ef14111650319297317.jpg');
INSERT INTO `nx_system_file_info` VALUES ('30', 'pXaa9YjQj4eN6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'pXaa9YjQj4eN6b9b42b8cc32fbc04559b5d530ef14111650319332204.jpg');
INSERT INTO `nx_system_file_info` VALUES ('31', 'cowEy0Q7hCBD6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'cowEy0Q7hCBD6b9b42b8cc32fbc04559b5d530ef14111650319373116.jpg');
INSERT INTO `nx_system_file_info` VALUES ('32', 'ysEyJ6rXUbQ96b9b42b8cc32fbc04559b5d530ef1411.jpg', 'ysEyJ6rXUbQ96b9b42b8cc32fbc04559b5d530ef14111650319395530.jpg');
INSERT INTO `nx_system_file_info` VALUES ('33', 'ysq.jpg', 'ysq1650326345105.jpg');
INSERT INTO `nx_system_file_info` VALUES ('34', 'rx2uiPXx9Mdp6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'rx2uiPXx9Mdp6b9b42b8cc32fbc04559b5d530ef14111650327951477.jpg');
INSERT INTO `nx_system_file_info` VALUES ('35', '9rIBzfJEoZtR6b9b42b8cc32fbc04559b5d530ef1411.jpg', '9rIBzfJEoZtR6b9b42b8cc32fbc04559b5d530ef14111650328055405.jpg');
INSERT INTO `nx_system_file_info` VALUES ('36', 'BEaWpfJk5QwP6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'BEaWpfJk5QwP6b9b42b8cc32fbc04559b5d530ef14111650328100353.jpg');
INSERT INTO `nx_system_file_info` VALUES ('37', 'cZsB9a1zjIPP6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'cZsB9a1zjIPP6b9b42b8cc32fbc04559b5d530ef14111650331118699.jpg');
INSERT INTO `nx_system_file_info` VALUES ('38', 'ysq.jpg', 'ysq1650333598988.jpg');
INSERT INTO `nx_system_file_info` VALUES ('39', 'ysq.jpg', 'ysq1650333620591.jpg');
INSERT INTO `nx_system_file_info` VALUES ('40', 'ysq.jpg', 'ysq1650333651073.jpg');
INSERT INTO `nx_system_file_info` VALUES ('41', 'tfbrryUyiKBG6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'tfbrryUyiKBG6b9b42b8cc32fbc04559b5d530ef14111650333968585.jpg');
INSERT INTO `nx_system_file_info` VALUES ('42', '3.jpg', '31650334238472.jpg');
INSERT INTO `nx_system_file_info` VALUES ('43', '5Sc7hq3O6UkN421af65e6277a58e315ae1a5fc08eae7.jpg', '5Sc7hq3O6UkN421af65e6277a58e315ae1a5fc08eae71650334314206.jpg');
INSERT INTO `nx_system_file_info` VALUES ('44', 'ltoYtFmSgpL26b9b42b8cc32fbc04559b5d530ef1411.jpg', 'ltoYtFmSgpL26b9b42b8cc32fbc04559b5d530ef14111667815150943.jpg');
INSERT INTO `nx_system_file_info` VALUES ('45', 'ysq.jpg', 'ysq1667852707686.jpg');
INSERT INTO `nx_system_file_info` VALUES ('46', 'ysq.jpg', 'ysq1667852783433.jpg');
INSERT INTO `nx_system_file_info` VALUES ('47', 'fRvcg570dxZv6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'fRvcg570dxZv6b9b42b8cc32fbc04559b5d530ef14111667899837031.jpg');
INSERT INTO `nx_system_file_info` VALUES ('48', 'OBMs8ZU3JxsP6b9b42b8cc32fbc04559b5d530ef1411.jpg', 'OBMs8ZU3JxsP6b9b42b8cc32fbc04559b5d530ef14111667899872430.jpg');
INSERT INTO `nx_system_file_info` VALUES ('49', 'ysq.jpg', 'ysq1667902245580.jpg');
INSERT INTO `nx_system_file_info` VALUES ('50', 'weixiurenyuan7.jpg', 'weixiurenyuan71675338754144.jpg');
INSERT INTO `nx_system_file_info` VALUES ('51', 'yhtx5.jpg', 'yhtx51682352445526.jpg');
INSERT INTO `nx_system_file_info` VALUES ('52', 'wxc6850893ddd5c33a.o6zAJs2OrOXKKfnMTO_h7Oz4yIss.0EttbNz77MPf2cff3af40e28596e2a6f0fc2c61488e3.jpg', 'wxc6850893ddd5c33a.o6zAJs2OrOXKKfnMTO_h7Oz4yIss.0EttbNz77MPf2cff3af40e28596e2a6f0fc2c61488e31682352502450.jpg');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `shoujihao` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `jifen` int(20) DEFAULT '100',
  `xuexizongshijian` double(20,2) DEFAULT '0.00',
  `level` int(20) DEFAULT NULL,
  `fileIds` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品图片id，用英文逗号隔开',
  `shenfen` varchar(50) DEFAULT NULL,
  `xueyuan` varchar(50) DEFAULT NULL,
  `nianji` varchar(50) DEFAULT NULL,
  `banji` varchar(50) DEFAULT NULL,
  `zhuanye` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('13', '123', 'e10adc3949ba59abbe56e057f20f883e', '123', '18767386260', '2023-04-25 01:54:03', '90', '6.00', '3', '[50]', '学生', '北京大学', '1', '1', '计算机');
INSERT INTO `user_info` VALUES ('14', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '13111111111', '2023-04-25 01:54:03', '100', '0.00', '1', '[46]', null, '', null, null, null);
INSERT INTO `user_info` VALUES ('15', '1234', 'e10adc3949ba59abbe56e057f20f883e', '123', '13111111111', '2023-04-25 01:54:03', '65', '27.00', '3', '[48]', '学生', '北京大学', '2', '2', '计算机');
INSERT INTO `user_info` VALUES ('16', '777', 'f1c1592588411002af340cbaedd6fc33', '雾岛少帅', '18767386260', '2023-04-25 01:54:03', '85', '0.00', '3', '[52]', '学生', '北京大学', '3', '3', '计算机');

-- ----------------------------
-- Table structure for `yuyuezuowei`
-- ----------------------------
DROP TABLE IF EXISTS `yuyuezuowei`;
CREATE TABLE `yuyuezuowei` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yuyuehao` varchar(50) DEFAULT NULL,
  `leixing` varchar(50) DEFAULT NULL,
  `zuoweihao` varchar(50) DEFAULT NULL,
  `yuyueshijian` datetime DEFAULT NULL,
  `yonghuming` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `shoujihao` varchar(50) DEFAULT NULL,
  `quxiaoyuyueshijian` datetime DEFAULT NULL,
  `issh` varchar(10) DEFAULT '待签到',
  `shhf` varchar(200) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of yuyuezuowei
-- ----------------------------
INSERT INTO `yuyuezuowei` VALUES ('37', 'b859842a-a110-4a5d-874b-86bfcb39796a', '研讨室', '0-3', '2024-03-11 16:49:25', '1234', '123', '123', '2024-03-11 16:49:25', '退座', null, '2024-03-11 16:49:25');
INSERT INTO `yuyuezuowei` VALUES ('41', '1c379a8a-7a01-4e3f-a7c6-ec5d5d6b3a9f', '报告厅', '4-3', '2024-03-11 16:49:25', '1234', '123', '13111111111', '2024-03-11 16:49:25', '退座', null, '2024-03-11 16:49:25');
INSERT INTO `yuyuezuowei` VALUES ('43', 'ccbcac59-3bda-4a06-b216-5e1643497e92', '研讨室', '3-4', '2024-03-11 00:17:12', '777', '雾岛少帅', '18767386260', '2024-03-11 00:17:39', '退座', null, '2024-03-11 00:17:17');
INSERT INTO `yuyuezuowei` VALUES ('44', 'a1282fe7-9d09-42aa-98a7-499bfc475e3d', '报告厅', '3-1', '2024-03-11 00:21:54', '777', '雾岛少帅', '18767386260', '2024-03-11 00:22:17', '退座', null, '2024-03-11 00:22:04');

-- ----------------------------
-- Table structure for `zuoweileixing`
-- ----------------------------
DROP TABLE IF EXISTS `zuoweileixing`;
CREATE TABLE `zuoweileixing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leixing` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pai` int(20) DEFAULT NULL,
  `lie` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of zuoweileixing
-- ----------------------------
INSERT INTO `zuoweileixing` VALUES ('9', '研讨室', '2024-03-11 16:49:25', '10', '8');
INSERT INTO `zuoweileixing` VALUES ('11', '普通自习室', '2024-03-11 16:49:25', '8', '8');
INSERT INTO `zuoweileixing` VALUES ('62', '报告厅', '2024-03-11 16:49:25', '5', '4');

-- ----------------------------
-- Table structure for `zuoweixinxi`
-- ----------------------------
DROP TABLE IF EXISTS `zuoweixinxi`;
CREATE TABLE `zuoweixinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leixing` varchar(50) DEFAULT NULL,
  `zuoweihao` varchar(50) DEFAULT NULL,
  `zhuangtai` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `louhao` varchar(50) DEFAULT NULL,
  `fangjianhao` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=gb2312 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of zuoweixinxi
-- ----------------------------
INSERT INTO `zuoweixinxi` VALUES ('12', '普通自习室', '1-2', '占用', '2024-03-11 16:49:25', '001', '001');
INSERT INTO `zuoweixinxi` VALUES ('13', '普通自习室', '0-0', '占用', '2024-03-11 16:49:25', '002', '002');
INSERT INTO `zuoweixinxi` VALUES ('14', '研讨室', '2-1', '占用', '2024-03-11 16:49:25', '003', '003');
