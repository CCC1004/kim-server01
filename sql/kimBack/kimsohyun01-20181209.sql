/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : kimsohyun01

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-12-10 00:47:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for code_dbinfo
-- ----------------------------
DROP TABLE IF EXISTS `code_dbinfo`;
CREATE TABLE `code_dbinfo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '别名',
  `db_driver` varchar(100) NOT NULL COMMENT '数据库驱动',
  `db_url` varchar(200) NOT NULL COMMENT '数据库地址',
  `db_user_name` varchar(100) NOT NULL COMMENT '数据库账户',
  `db_password` varchar(100) NOT NULL COMMENT '连接密码',
  `db_type` varchar(10) DEFAULT NULL COMMENT '数据库类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据库链接信息';

-- ----------------------------
-- Records of code_dbinfo
-- ----------------------------

-- ----------------------------
-- Table structure for coin_index_jpfl
-- ----------------------------
DROP TABLE IF EXISTS `coin_index_jpfl`;
CREATE TABLE `coin_index_jpfl` (
  `guid` varchar(32) NOT NULL COMMENT '主键自增',
  `fl_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `fl_image` varchar(32) DEFAULT NULL COMMENT '分类图片id(与资源信息主键匹配)',
  `fl_desc` varchar(255) DEFAULT NULL COMMENT '分类描述',
  `fl_sort` varchar(2) DEFAULT NULL COMMENT '排序',
  `fl_status` varchar(1) DEFAULT NULL COMMENT '是否显示（1显示；2不显示）',
  `nt` varchar(255) DEFAULT NULL COMMENT '备注',
  `ts` datetime DEFAULT NULL COMMENT '时间戳',
  PRIMARY KEY (`guid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品分类表';

-- ----------------------------
-- Records of coin_index_jpfl
-- ----------------------------
INSERT INTO `coin_index_jpfl` VALUES ('12442214bd7e4ee4b0b12b4e8a192fde', '外国纪念币', '1eaa895e4a904e66aec46ffe8304b23e', '', '29', '1', '', '2018-12-06 17:12:12');
INSERT INTO `coin_index_jpfl` VALUES ('317339cb46ca42178d797d6bdb8c8cbd', '和字币', '8e45ba251edb427b8677d9a1ea0b30cb', '', '14', '1', '', '2018-12-06 17:10:43');
INSERT INTO `coin_index_jpfl` VALUES ('359a6f4f80774f14aa72b2d53423a9a4', '普通纪念币', 'c4901917a04c4bfc84cf89591a055adc', '', '11', '1', '', '2018-12-06 17:09:22');
INSERT INTO `coin_index_jpfl` VALUES ('5925c18f230140898e55fcb00e5fd1e2', '其他金银币', '3b13891621514ce58dfb092c98b98d0b', '', '23', '1', '', '2018-12-06 17:12:43');
INSERT INTO `coin_index_jpfl` VALUES ('5e1545b6085343ab8f22cdce9602d78a', '银元', 'bb99743e6b18464daeea95f5b0f8da2d', '', '15', '1', '', '2018-12-06 17:11:50');
INSERT INTO `coin_index_jpfl` VALUES ('819b258decb84926aeb9f3e5c007f9e6', '古钱币', '2a5c2b4346ef4e31b006c88d6bef34e5', '', '24', '1', '', '2018-12-06 17:17:56');
INSERT INTO `coin_index_jpfl` VALUES ('8d02383627b44d45840bcd512f684a23', '纪念钞', 'b599a9db53994a6281430094f924fcae', '', '13', '1', '', '2018-12-06 17:26:02');
INSERT INTO `coin_index_jpfl` VALUES ('a6a42db3693c4343ada13cc3d9661b9e', '福字币', 'fde15618c3c14034ba7dd2559ee081d1', '', '16', '1', '', '2018-12-06 17:11:37');
INSERT INTO `coin_index_jpfl` VALUES ('c291510ced5344ce980147824c314907', '熊猫金银币', 'a86e031ca8214f70beec0df2a2f33a81', '', '12', '1', '', '2018-12-06 17:10:16');
INSERT INTO `coin_index_jpfl` VALUES ('cf9cd4a9026f4565b3ae3d1b343c5ca9', '澳门生肖钞', 'e78df57c690843aa9290987edef11d9e', '', '13', '1', '', '2018-12-06 17:27:09');

-- ----------------------------
-- Table structure for coin_index_lb
-- ----------------------------
DROP TABLE IF EXISTS `coin_index_lb`;
CREATE TABLE `coin_index_lb` (
  `guid` varchar(32) NOT NULL COMMENT '主键自增',
  `lb_name` varchar(255) DEFAULT NULL COMMENT '轮播页名称',
  `lb_image` varchar(32) DEFAULT NULL COMMENT '轮播图片id(与资源信息主键匹配)',
  `lb_sort` varchar(2) DEFAULT NULL COMMENT '排序',
  `lb_status` varchar(1) DEFAULT NULL COMMENT '是否显示(1显示；2不显示)',
  `nt` varchar(255) DEFAULT NULL COMMENT '备注',
  `ts` datetime DEFAULT NULL COMMENT '时间戳',
  PRIMARY KEY (`guid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='轮播图信息';

-- ----------------------------
-- Records of coin_index_lb
-- ----------------------------
INSERT INTO `coin_index_lb` VALUES ('2231645c6684447bb97a8623c2e43d37', '第三页', '94123f5e42d846839a4a00d2cf663d89', '3', '1', '改革开发40周年纪念钞', '2018-12-06 16:33:02');
INSERT INTO `coin_index_lb` VALUES ('2960cbf92d4e4206ad1c66105d6c6bd1', '第一页', '9ab491917e7e4fe09c1194e7d2f32192', '1', '1', '狗年生肖币', '2018-12-06 16:15:28');
INSERT INTO `coin_index_lb` VALUES ('7523d4fdec2f4f6aae5be950d0fcdea7', '第二页', 'c0720fc1df744ad0937eb58a7e27c467', '2', '1', '第五套2015 100', '2018-12-06 16:32:36');

-- ----------------------------
-- Table structure for coin_kind
-- ----------------------------
DROP TABLE IF EXISTS `coin_kind`;
CREATE TABLE `coin_kind` (
  `guid` varchar(32) NOT NULL COMMENT '主键uuid',
  `kind_name` varchar(30) DEFAULT NULL COMMENT '品种名称',
  `kind_value` varchar(30) DEFAULT NULL COMMENT '面值',
  `kind_desc` varchar(255) DEFAULT NULL COMMENT '品种描述',
  `kind_org` varchar(30) DEFAULT NULL COMMENT '发行机构',
  `kind_head` varchar(255) DEFAULT NULL COMMENT '正面',
  `kind_tail` varchar(255) DEFAULT NULL COMMENT '背面',
  `fl_id` varchar(32) DEFAULT NULL COMMENT '精品分类id',
  `issue_time` datetime DEFAULT NULL COMMENT '发行日期',
  `issue_size` varchar(30) DEFAULT NULL COMMENT '发行量',
  `kind_size` varchar(30) DEFAULT NULL COMMENT '规格',
  `kind_material` varchar(30) DEFAULT NULL COMMENT '材质',
  `kind_packing` varchar(255) DEFAULT NULL COMMENT '品种包装',
  `now_prise_down` decimal(10,2) DEFAULT NULL COMMENT '目前价格下限',
  `now_prise_up` decimal(10,2) DEFAULT NULL COMMENT '目前价格上限',
  `kind_image` varchar(32) DEFAULT NULL COMMENT '品种图片1（与资源表id关联）',
  `kind_image2` varchar(32) DEFAULT NULL COMMENT '品种图片2',
  `kind_image3` varchar(32) DEFAULT NULL COMMENT '品种图片3',
  `kind_image4` varchar(32) DEFAULT NULL COMMENT '品种图片4',
  `kind_sort` varchar(3) DEFAULT NULL COMMENT '排序',
  `ts` datetime DEFAULT NULL COMMENT '时间戳',
  `nt` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`guid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品种信息表';

-- ----------------------------
-- Records of coin_kind
-- ----------------------------
INSERT INTO `coin_kind` VALUES ('07ba5bbbd4bc4185a33522518e82a954', '中国银行在香港服务100周年纪念钞', '100港币', '中国银行（香港）百年华诞纪念钞票', '中国银行', '中银香港大厦，中银总部大厦，长城，中国古代建筑的柱子与榫卯结构。', '维港俯视图，中国银行行徽，码头塔吊。', '8d02383627b44d45840bcd512f684a23', '2017-09-26 00:00:00', '500万', '', '', '', null, null, 'df4aa10721cf452dab717ba5a288fa1f', null, null, null, '135', '2018-12-10 00:30:58', '');
INSERT INTO `coin_kind` VALUES ('1aa2e7e0c11e4fc5a165c78785606c05', '人民币钞', '50元', '人民币发行70周年纪念钞', '中国人民银行', '纪念钞正面主景图案为树木年轮与第一套至第五套人民币代表性局部图案。', '纪念钞背面主景图案为中国人民银行大楼，辅以牡丹花、中国人民银行旧址、第一套人民币发行布告及城市建筑剪影图案。', '8d02383627b44d45840bcd512f684a23', '2018-12-28 00:00:00', '1.2亿', '150×70mm', '纸钞', '整刀100张', '80.00', null, '187b30354c054ec08d82e51dc85f07fa', null, null, null, '105', '2018-12-10 00:15:15', '');
INSERT INTO `coin_kind` VALUES ('1e0406cabc4c4856a2255c262f635397', '香港渣打银行成立150周年', '150港币', '', '香港渣打银行', '香港渣打银行大楼，背景为香港的卫星地图', '不同年代、不同阶层的香港市民俯瞰维多利亚港', '8d02383627b44d45840bcd512f684a23', '2009-10-01 00:00:00', '100万', '', '', '', null, null, 'aab3d6c0b01347fc9241fdc82544c2c5', null, null, null, '132', '2018-12-10 00:26:27', '');
INSERT INTO `coin_kind` VALUES ('219232b742ad40aea176e12e644d0dcd', '台湾50周年纪念钞', '50台币', '新台币发行50周年纪念钞', '台湾银行', '1949和1999版本的台币钞票，背景为铁路桥和子弹头火车等。', '台湾中央银行大楼，背景为列车、收获稻谷', '8d02383627b44d45840bcd512f684a23', '1999-06-15 00:00:00', '3000万', '166x72mm', '塑料钞', '', null, null, '487bbb58d28e45eeb9448564a4478ada', null, null, null, '121', '2018-12-10 00:19:02', '两张纸币编号的寓意：1圆的编号DT380615代表民国38年6月15日首次发行新台币，DT可能是代表Dollar Taiwan*；100圆的编号DT880615CB代表民国88年6月15日，DT同，CB代表中央银行Central Bank');
INSERT INTO `coin_kind` VALUES ('4caea212139147ef81f6c6d1d9f67899', '航天钞', '100元', '中国航天纪念钞', '中国人民银行', '（左）东方红一号卫星，（中）神舟九号飞船与天宫一号交会对接，（右）嫦娥一号卫星', '（由上至下）嫦娥一号卫星、2020年中国空间站“天宫”、喷气式客机、冯如2号双翼螺旋桨飞机、飞禽海东青。', '8d02383627b44d45840bcd512f684a23', '2015-11-26 00:00:00', '3亿', '155×77mm', '', '整刀100张', '102.00', null, 'e0573a02b1014dd6b268e8f075445a59', null, null, null, '104', '2018-12-10 00:14:26', '纪念钞主色调为蓝色，图案包括东方红一号卫星、神舟九号、天宫一号、嫦娥卫星等。这是新中国成立以来发行的第四张纪念钞，也是首张以航天为题材的纪念钞。');
INSERT INTO `coin_kind` VALUES ('54af970b5ba9435c85e46bb61b1fe26a', '香港奥运钞', '20港币', '2008年香港20元奥运纪念钞', '中国银行香港分行', '中国银行香港分行大楼，奥运会发源地遗址的石柱', '国家体育馆', '8d02383627b44d45840bcd512f684a23', '2008-07-16 00:00:00', '400万', '', '', '', '300.00', null, '9fd4d4e331ab44f29be4a21a7701ed22', null, null, null, '131', '2018-12-10 00:24:31', '');
INSERT INTO `coin_kind` VALUES ('711f51c99cfc403995148f07ea06548c', '香港汇丰银行成立150周年', '150港币', '庆祝香港上海汇丰银行成立150周年', '香港汇丰银行', '汇丰四座不同时期的总行大厦', '一双铜狮子“史提芬”（左面的水印）和“施迪”（右面神态较闲适的狮子）', '8d02383627b44d45840bcd512f684a23', '2015-03-03 00:00:00', '200万', '158X79mm', '', '', null, null, '9b536178019a4a3796a1c291c9594105', null, null, null, '134', '2018-12-10 00:29:37', '汇丰银行150周年念钞是香港上海汇丰银行为庆祝香港上海汇丰银行成立150周');
INSERT INTO `coin_kind` VALUES ('783dbaa516e7431b8c4d30232924d810', '中华民国建国一百周年纪念钞', '100台币', '中华民国建国一百周年纪念钞', '台湾中央银行', '中国近代民主革命的伟大先行者、革命家、政治家、理论家孙中山先生；右为孙中山手迹“博爱”和《礼记·礼运·大同篇》；背景是为南京中山陵孙中山大理石坐像底座浮雕《如抱赤子》。', '台北中山楼，梅花，左下角有“庆祝中华民国建国一百年”的字，右下角有壹佰元的字。', '8d02383627b44d45840bcd512f684a23', '2011-01-06 00:00:00', '4亿', '145×70mm', '', '', null, null, '771cc4bfa2434df8b83fb78eb1bb0030', null, null, null, '122', '2018-12-10 00:22:22', '30万套3联体');
INSERT INTO `coin_kind` VALUES ('7ffa219260d640c7bd930be1b2014fa8', '澳门奥运钞', '20澳币', '2008年澳门20元奥运纪念钞', '中国银行澳门分行', '中国银行澳门分行大楼，奥运会发源地遗址的石柱', '国家体育馆', '8d02383627b44d45840bcd512f684a23', '2008-07-16 00:00:00', '400万', '', '', '', '350.00', null, 'ca3794894fae4329984ee48b4d7a969e', null, null, null, '141', '2018-12-10 00:34:17', '');
INSERT INTO `coin_kind` VALUES ('a01aa9d2c1cd4f04869fbd63bb1a84ae', '中国银行100元纪念钞', '100澳币', '中国银行成立100周年澳门纪念钞', '中国银行澳门分行', '中国银行澳门分行大楼', '荷花', '8d02383627b44d45840bcd512f684a23', '2012-02-05 00:00:00', '300万', '', '', '', '750.00', null, 'a8a4a91707064802a3b356732c171498', null, null, null, '142', '2018-12-10 00:35:52', '');
INSERT INTO `coin_kind` VALUES ('dab7eebe3cf8476bb07d388e4d921aa7', '建国钞', '50元', '中华人民共和国成立50周年纪念钞', '中国人民银行', '开国大典', '（左）太和殿前的铜狮，（中）和平鸽，（右）华表', '8d02383627b44d45840bcd512f684a23', '1999-09-20 00:00:00', '6000万', '165×80mm', '', '整刀100张', '230.00', '290.00', 'd6ffb7b4101949f5b20813a4dac70bc2', null, null, null, '101', '2018-12-09 23:53:23', '中国人民银行决定于1999年9月20日发行的“庆祝中华人民共和国成立50周年”流通纪念钞。这是我国自1984年建国35周年开始发行金属流通纪念币以来，首次发行流通纪念钞。');
INSERT INTO `coin_kind` VALUES ('e5a86f33ba8840ceb8feddc941b26716', '奥运钞', '10元', '第29届奥林匹克运动会10元纪念钞', '中国人民银行', '国家体育馆，背景为天坛', '（左）掷铁饼者，（中）奥运会运动员', '8d02383627b44d45840bcd512f684a23', '2008-07-08 00:00:00', '600万', '148.5×72.0mm', '短棉绒', '', '3500.00', '3900.00', 'cd4d2bbdfe5a40a1a9a2e80dc5a0f38c', null, null, null, '103', '2018-12-10 00:07:39', '奥运钞是我国为了纪念2008年北京奥运会成功举办而发行的纪念钞，该纪念钞正面主景图案为北京2008年奥林匹克运动会国家体育场，其上方为第二十九届奥林匹克运动会会徽图案，背景为天坛图案。');
INSERT INTO `coin_kind` VALUES ('fab73d6edaad4cffb296fa6c01c52962', '中国银行成立100周年纪念钞', '100港币', '中国银行成立100周年香港纪念钞', '中国银行香港分行', '北京中国银行总部大厦，长城和《申报》1912年2月6日的《中国银行成立大会记》', '香港中环和香港中国银行大厦', '8d02383627b44d45840bcd512f684a23', '2012-02-06 00:00:00', '110万', '153x76.5mm', '', '', '450.00', null, '7dd147cbfa12498cab09d5df9615e118', null, null, null, '133', '2018-12-10 00:28:13', '香港纪念钞正面主景为中国银行大厦，衬景为长城和1912年《申报》关于中国银行成立报道的组合图案。纪念文字为“纪念中国银行成立一百周年”。正面中部极具中国书法韵味的数字“100”既是面额，又与百年纪念主题呼应。');
INSERT INTO `coin_kind` VALUES ('fec0d2025b6747e49218c374e77a9c8f', '世纪龙钞', '100元', '迎接新世纪纪念钞', '中国人民银行', '北海九龙壁上的升龙', '中华世纪坛，敦煌壁画“飞天”', '8d02383627b44d45840bcd512f684a23', '2000-11-28 00:00:00', '1000万', '165×80mm', '塑料基片', '整刀100张', '1800.00', '1950.00', '9633a5f1237b4b1982ad6e90a7231e77', null, null, null, '102', '2018-12-10 00:05:26', '其主色调为金黄色，正面主景以北京九龙壁为设计依据，“龙”的左侧为“火珠”吉祥图案，票面左侧透明视窗为“天坛”图案，右侧为动态全息标志。背面主景为迎接新世纪的代表性建筑──中华世纪坛，上方为中国传统“飞天”图案和“中国人民银行”汉语拼音，右上方为中华人民共和国国徽图案，右下方为蒙、藏、维、壮四种民族文字的“中国人民银行”字样和面额。1000万张，其中有二连体钞（发行量10万张）');

-- ----------------------------
-- Table structure for coin_resources
-- ----------------------------
DROP TABLE IF EXISTS `coin_resources`;
CREATE TABLE `coin_resources` (
  `FILE_CD` char(32) NOT NULL COMMENT '文件代码',
  `FILE_TITL` varchar(256) DEFAULT NULL COMMENT '文件标题',
  `KEY_WORD` varchar(60) DEFAULT NULL COMMENT '关键词',
  `EST_ORG` varchar(60) DEFAULT NULL COMMENT '编制单位名称',
  `ORGCD` char(18) DEFAULT NULL COMMENT '编制单位代码',
  `EST_PERS` varchar(100) DEFAULT NULL COMMENT '编制人员',
  `EST_DT` date DEFAULT NULL COMMENT '编制完成日期',
  `PUB_ORG` varchar(60) DEFAULT NULL COMMENT '发布单位名称',
  `PUB_ORGCD` char(18) DEFAULT NULL COMMENT '发布单位代码',
  `PUB_DT` date DEFAULT NULL COMMENT '发布日期',
  `ABS` varchar(400) DEFAULT NULL COMMENT '摘要信息',
  `MUL_TP` char(1) NOT NULL COMMENT '多媒体文件类型（1文档资料；2图片资料；3视音资料；4其他文件）',
  `FILE_PATH` varchar(256) NOT NULL DEFAULT '' COMMENT '文件路径',
  `FILE_NM` varchar(256) NOT NULL COMMENT '文件名',
  `FILE_SIZE` decimal(10,2) DEFAULT NULL COMMENT '文件大小',
  `FILE_EXT` varchar(10) DEFAULT NULL COMMENT '文件扩展名',
  `IS_SEC` tinyint(1) DEFAULT NULL COMMENT '是否密件',
  `SEC_G` char(1) DEFAULT NULL COMMENT '密件等级（1：公开级 2：限制级 3：秘密级 4：机密级 5：绝密级）',
  `DOC_TP` char(4) DEFAULT NULL COMMENT '资料类别',
  `TS` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
  `NT` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`FILE_CD`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='资源文件信息表';

-- ----------------------------
-- Records of coin_resources
-- ----------------------------
INSERT INTO `coin_resources` VALUES ('187b30354c054ec08d82e51dc85f07fa', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181208/88.jpg', '88.jpg', null, 'image/jpeg', null, null, null, '2018-12-08 17:18:02.280', null);
INSERT INTO `coin_resources` VALUES ('1eaa895e4a904e66aec46ffe8304b23e', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/8.jpg', '8.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 17:12:12.033', null);
INSERT INTO `coin_resources` VALUES ('2a5c2b4346ef4e31b006c88d6bef34e5', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/88.jpg', '88.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 17:17:56.014', null);
INSERT INTO `coin_resources` VALUES ('3b13891621514ce58dfb092c98b98d0b', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/2.jpg', '2.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 17:12:42.507', null);
INSERT INTO `coin_resources` VALUES ('487bbb58d28e45eeb9448564a4478ada', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181209/45.jpg', '45.jpg', null, 'image/jpeg', null, null, null, '2018-12-09 18:08:22.089', null);
INSERT INTO `coin_resources` VALUES ('771cc4bfa2434df8b83fb78eb1bb0030', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181209/35.jpg', '35.jpg', null, 'image/jpeg', null, null, null, '2018-12-09 18:19:17.491', null);
INSERT INTO `coin_resources` VALUES ('7dd147cbfa12498cab09d5df9615e118', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181209/47.jpg', '47.jpg', null, 'image/jpeg', null, null, null, '2018-12-09 22:33:20.329', null);
INSERT INTO `coin_resources` VALUES ('8e45ba251edb427b8677d9a1ea0b30cb', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/1.jpg', '1.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 17:10:43.099', null);
INSERT INTO `coin_resources` VALUES ('94123f5e42d846839a4a00d2cf663d89', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/mmexport1543573681720.jpg', 'mmexport1543573681720.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 16:48:26.786', null);
INSERT INTO `coin_resources` VALUES ('9633a5f1237b4b1982ad6e90a7231e77', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181208/22.jpg', '22.jpg', null, 'image/jpeg', null, null, null, '2018-12-08 17:03:02.609', null);
INSERT INTO `coin_resources` VALUES ('9ab491917e7e4fe09c1194e7d2f32192', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/mmexport1542357811198.jpg', 'mmexport1542357811198.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 16:48:28.594', null);
INSERT INTO `coin_resources` VALUES ('9b536178019a4a3796a1c291c9594105', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181209/49.jpg', '49.jpg', null, 'image/jpeg', null, null, null, '2018-12-09 22:41:19.460', null);
INSERT INTO `coin_resources` VALUES ('9fd4d4e331ab44f29be4a21a7701ed22', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181209/81.jpg', '81.jpg', null, 'image/jpeg', null, null, null, '2018-12-09 17:43:02.794', null);
INSERT INTO `coin_resources` VALUES ('a86e031ca8214f70beec0df2a2f33a81', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/4.jpg', '4.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 17:10:15.989', null);
INSERT INTO `coin_resources` VALUES ('a8a4a91707064802a3b356732c171498', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181209/44.jpg', '44.jpg', null, 'image/jpeg', null, null, null, '2018-12-09 18:01:39.443', null);
INSERT INTO `coin_resources` VALUES ('aab3d6c0b01347fc9241fdc82544c2c5', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181209/48.jpg', '48.jpg', null, 'image/jpeg', null, null, null, '2018-12-09 22:38:30.774', null);
INSERT INTO `coin_resources` VALUES ('b599a9db53994a6281430094f924fcae', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/55.jpg', '55.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 17:26:02.344', null);
INSERT INTO `coin_resources` VALUES ('bb99743e6b18464daeea95f5b0f8da2d', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/6.jpg', '6.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 17:11:49.758', null);
INSERT INTO `coin_resources` VALUES ('c0720fc1df744ad0937eb58a7e27c467', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/img-55289940f5c4d882e2542c63d29e5058.jpg', 'img-55289940f5c4d882e2542c63d29e5058.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 16:48:31.657', null);
INSERT INTO `coin_resources` VALUES ('c4901917a04c4bfc84cf89591a055adc', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/211.jpg', '211.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 17:09:22.157', null);
INSERT INTO `coin_resources` VALUES ('ca3794894fae4329984ee48b4d7a969e', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181209/82.jpg', '82.jpg', null, 'image/jpeg', null, null, null, '2018-12-09 17:45:56.522', null);
INSERT INTO `coin_resources` VALUES ('cd4d2bbdfe5a40a1a9a2e80dc5a0f38c', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181208/55.jpg', '55.jpg', null, 'image/jpeg', null, null, null, '2018-12-08 17:07:28.616', null);
INSERT INTO `coin_resources` VALUES ('d6ffb7b4101949f5b20813a4dac70bc2', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181208/66.jpg', '66.jpg', null, 'image/jpeg', null, null, null, '2018-12-08 16:57:40.404', null);
INSERT INTO `coin_resources` VALUES ('df4aa10721cf452dab717ba5a288fa1f', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181209/46.jpg', '46.jpg', null, 'image/jpeg', null, null, null, '2018-12-09 22:33:40.160', null);
INSERT INTO `coin_resources` VALUES ('e0573a02b1014dd6b268e8f075445a59', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181208/77.jpg', '77.jpg', null, 'image/jpeg', null, null, null, '2018-12-08 17:11:21.890', null);
INSERT INTO `coin_resources` VALUES ('e78df57c690843aa9290987edef11d9e', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/34.jpg', '34.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 17:27:08.777', null);
INSERT INTO `coin_resources` VALUES ('fde15618c3c14034ba7dd2559ee081d1', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/coin/20181206/3.jpg', '3.jpg', null, 'image/jpeg', null, null, null, '2018-12-06 17:11:37.248', null);

-- ----------------------------
-- Table structure for kim_index_jptj
-- ----------------------------
DROP TABLE IF EXISTS `kim_index_jptj`;
CREATE TABLE `kim_index_jptj` (
  `guid` varchar(32) NOT NULL COMMENT '主键自增',
  `jp_name` varchar(255) DEFAULT NULL COMMENT '精品名称',
  `jp_image` varchar(32) DEFAULT NULL COMMENT '精品图片id(与资源信息主键匹配)',
  `jp_desc` varchar(255) DEFAULT NULL COMMENT '精品描述',
  `jp_sort` varchar(2) DEFAULT NULL COMMENT '排序',
  `jp_status` varchar(1) DEFAULT NULL COMMENT '是否显示（1显示；2不显示）',
  `nt` varchar(255) DEFAULT NULL COMMENT '备注',
  `ts` datetime DEFAULT NULL COMMENT '时间戳',
  PRIMARY KEY (`guid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品推荐表';

-- ----------------------------
-- Records of kim_index_jptj
-- ----------------------------
INSERT INTO `kim_index_jptj` VALUES ('147658c698184faf83e6f52faaa29b61', '金1', '75f2b34ae05c4b0885972478b025b5d7', 'KimSohyun', '1', '1', '', '2018-12-02 21:36:51');
INSERT INTO `kim_index_jptj` VALUES ('183836c5d9e14c6d8d75cdc314a18231', '金3', 'ccc3c7be338d4928908ca81adf520325', 'Kim', '3', '1', '', '2018-12-02 21:37:17');
INSERT INTO `kim_index_jptj` VALUES ('1ed2ffce255c423c87a6628c7563daae', '金4', '013de96be4ca4fea82c4e2056d3f033e', 'Page Turner', '4', '1', '', '2018-12-02 21:37:43');
INSERT INTO `kim_index_jptj` VALUES ('6b68b6c00d6d4bb5b49edcf055d7fa88', '金2', 'caaa5b025e6043639553ec2ff44626b3', '金所炫64', '2', '1', '', '2018-12-02 21:37:07');

-- ----------------------------
-- Table structure for kim_index_lb
-- ----------------------------
DROP TABLE IF EXISTS `kim_index_lb`;
CREATE TABLE `kim_index_lb` (
  `guid` varchar(32) NOT NULL COMMENT '主键自增',
  `lb_name` varchar(255) DEFAULT NULL COMMENT '轮播页名称',
  `lb_image` varchar(32) DEFAULT NULL COMMENT '轮播图片id(与资源信息主键匹配)',
  `lb_sort` varchar(2) DEFAULT NULL COMMENT '排序',
  `lb_status` varchar(1) DEFAULT NULL COMMENT '是否显示(1显示；2不显示)',
  `nt` varchar(255) DEFAULT NULL COMMENT '备注',
  `ts` datetime DEFAULT NULL COMMENT '时间戳',
  PRIMARY KEY (`guid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='轮播图信息';

-- ----------------------------
-- Records of kim_index_lb
-- ----------------------------
INSERT INTO `kim_index_lb` VALUES ('0d19ea1d2c05414b906dceae2bc94e8e', '金2', '31d66151ff71419d99818590f776f361', '2', '1', '', '2018-12-02 21:35:53');
INSERT INTO `kim_index_lb` VALUES ('46da955609f94324981d581aa6180afb', '第一页', 'bda3092ab7bb4a8ebcf970c6a7ddb865', '1', '1', '', '2018-12-02 21:34:26');
INSERT INTO `kim_index_lb` VALUES ('6f02f867ee0c4b8e8fcad8fbd4bb0100', '金3', '2247d45c00b94a418693038080697cc5', '3', '1', '', '2018-12-02 21:36:14');

-- ----------------------------
-- Table structure for kim_index_rmtp
-- ----------------------------
DROP TABLE IF EXISTS `kim_index_rmtp`;
CREATE TABLE `kim_index_rmtp` (
  `guid` varchar(32) NOT NULL COMMENT '主键自增',
  `rm_name` varchar(255) DEFAULT NULL COMMENT '热门名称',
  `rm_image` varchar(32) DEFAULT NULL COMMENT '热门图片id(与资源信息主键匹配)',
  `rm_head_img` varchar(32) DEFAULT NULL COMMENT '头像图片id(与资源信息主键匹配)',
  `rm_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `rm_context` varchar(255) DEFAULT NULL COMMENT '内容',
  `rm_sort` varchar(2) DEFAULT NULL COMMENT '排序',
  `rm_status` varchar(1) DEFAULT NULL COMMENT '是否显示(1显示；2不显示)',
  `nt` varchar(255) DEFAULT NULL COMMENT '备注',
  `ts` datetime DEFAULT NULL COMMENT '时间戳',
  PRIMARY KEY (`guid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='热门图片信息';

-- ----------------------------
-- Records of kim_index_rmtp
-- ----------------------------
INSERT INTO `kim_index_rmtp` VALUES ('05ba50309aa54950899e37329b8fbf5e', '金2', '67ab9b16ecb442fd869312675c99aba6', '8f7f92abb8cf44ad9a134ad7901a99a5', 'KimSoHyun', '金所泫（김소현），1999年6月4日出生于澳大利亚，韩国女演员。             代表作品:想你，拥抱太阳的月亮，My boy，可疑的保姆，学校2015，打架吧鬼神', '2', '1', '', '2018-12-02 22:45:25');
INSERT INTO `kim_index_rmtp` VALUES ('611ff86089274c8bb33b64858b574426', '金4', '9f7b6654c2b04278a74e20943fe7f597', '5140bdbe1f3340cfbc73dacfc5fefe9d', 'Kim所炫', '金所泫（김소현），1999年6月4日出生于澳大利亚，韩国女演员。             代表作品:想你，拥抱太阳的月亮，My boy，可疑的保姆，学校2015，打架吧鬼神', '4', '1', '', '2018-12-02 22:46:06');
INSERT INTO `kim_index_rmtp` VALUES ('f3958c6ee1064cb29b3393b9e117ce21', '金1', 'f47e9a5c89524af5926ca8d4199fcd62', 'a2d7f9e93daa4d1ca02d9aae4865b52a', 'KimSoHyun', '金所泫（김소현），1999年6月4日出生于澳大利亚，韩国女演员。             代表作品:想你，拥抱太阳的月亮，My boy，可疑的保姆，学校2015，打架吧鬼神', '1', '1', '', '2018-12-02 22:41:33');
INSERT INTO `kim_index_rmtp` VALUES ('f5f831ec88494b4692db5c6658097915', '金5', 'a8e0130703ab4556aa241b9b4fd79c86', '8de5450160d74c30aab0f6786129e4bf', '金hyun', '金所泫（김소현），1999年6月4日出生于澳大利亚，韩国女演员。             代表作品:想你，拥抱太阳的月亮，My boy，可疑的保姆，学校2015，打架吧鬼神', '5', '1', '', '2018-12-02 22:46:23');
INSERT INTO `kim_index_rmtp` VALUES ('f69ce630369449acb7b0ead3c84ebf12', '金3', 'e7952720f5224d448ff6846cb845b75a', 'ccbb40ed78284b63a33f11abb720c8ef', 'Kim', '金所泫（김소현），1999年6月4日出生于澳大利亚，韩国女演员。             代表作品:想你，拥抱太阳的月亮，My boy，可疑的保姆，学校2015，打架吧鬼神', '3', '1', '', '2018-12-02 22:45:44');

-- ----------------------------
-- Table structure for kim_resources
-- ----------------------------
DROP TABLE IF EXISTS `kim_resources`;
CREATE TABLE `kim_resources` (
  `FILE_CD` char(32) NOT NULL COMMENT '文件代码',
  `FILE_TITL` varchar(256) DEFAULT NULL COMMENT '文件标题',
  `KEY_WORD` varchar(60) DEFAULT NULL COMMENT '关键词',
  `EST_ORG` varchar(60) DEFAULT NULL COMMENT '编制单位名称',
  `ORGCD` char(18) DEFAULT NULL COMMENT '编制单位代码',
  `EST_PERS` varchar(100) DEFAULT NULL COMMENT '编制人员',
  `EST_DT` date DEFAULT NULL COMMENT '编制完成日期',
  `PUB_ORG` varchar(60) DEFAULT NULL COMMENT '发布单位名称',
  `PUB_ORGCD` char(18) DEFAULT NULL COMMENT '发布单位代码',
  `PUB_DT` date DEFAULT NULL COMMENT '发布日期',
  `ABS` varchar(400) DEFAULT NULL COMMENT '摘要信息',
  `MUL_TP` char(1) NOT NULL COMMENT '多媒体文件类型（1文档资料；2图片资料；3视音资料；4其他文件）',
  `FILE_PATH` varchar(256) NOT NULL DEFAULT '' COMMENT '文件路径',
  `FILE_NM` varchar(256) NOT NULL COMMENT '文件名',
  `FILE_SIZE` decimal(10,2) DEFAULT NULL COMMENT '文件大小',
  `FILE_EXT` varchar(10) DEFAULT NULL COMMENT '文件扩展名',
  `IS_SEC` tinyint(1) DEFAULT NULL COMMENT '是否密件',
  `SEC_G` char(1) DEFAULT NULL COMMENT '密件等级（1：公开级 2：限制级 3：秘密级 4：机密级 5：绝密级）',
  `DOC_TP` char(4) DEFAULT NULL COMMENT '资料类别',
  `TS` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '时间戳',
  `NT` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`FILE_CD`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='资源文件信息表';

-- ----------------------------
-- Records of kim_resources
-- ----------------------------
INSERT INTO `kim_resources` VALUES ('013de96be4ca4fea82c4e2056d3f033e', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/9.jpg', '9.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 21:37:43.032', null);
INSERT INTO `kim_resources` VALUES ('2247d45c00b94a418693038080697cc5', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/17.jpg', '17.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 21:36:14.219', null);
INSERT INTO `kim_resources` VALUES ('31d66151ff71419d99818590f776f361', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/3.jpg', '3.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 21:35:52.728', null);
INSERT INTO `kim_resources` VALUES ('5140bdbe1f3340cfbc73dacfc5fefe9d', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/img-3c3e0c48b4eb7cdefff03a13b2e4e319.jpg', 'img-3c3e0c48b4eb7cdefff03a13b2e4e319.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 22:46:05.820', null);
INSERT INTO `kim_resources` VALUES ('67ab9b16ecb442fd869312675c99aba6', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/10.jpg', '10.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 22:45:25.096', null);
INSERT INTO `kim_resources` VALUES ('75f2b34ae05c4b0885972478b025b5d7', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/5.jpg', '5.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 21:36:50.754', null);
INSERT INTO `kim_resources` VALUES ('8de5450160d74c30aab0f6786129e4bf', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/img-3c5397862a1973a20d73310e56316f91.jpg', 'img-3c5397862a1973a20d73310e56316f91.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 22:46:23.351', null);
INSERT INTO `kim_resources` VALUES ('8f7f92abb8cf44ad9a134ad7901a99a5', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/901.jpeg', '901.jpeg', null, 'image/jpeg', null, null, null, '2018-12-02 22:45:25.105', null);
INSERT INTO `kim_resources` VALUES ('9f7b6654c2b04278a74e20943fe7f597', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/14.jpg', '14.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 22:46:05.810', null);
INSERT INTO `kim_resources` VALUES ('a2d7f9e93daa4d1ca02d9aae4865b52a', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/timg.jpg', 'timg.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 22:41:33.033', null);
INSERT INTO `kim_resources` VALUES ('a8e0130703ab4556aa241b9b4fd79c86', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/23.jpg', '23.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 22:46:23.341', null);
INSERT INTO `kim_resources` VALUES ('bda3092ab7bb4a8ebcf970c6a7ddb865', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/2.jpg', '2.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 21:34:26.251', null);
INSERT INTO `kim_resources` VALUES ('caaa5b025e6043639553ec2ff44626b3', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/6.JPG', '6.JPG', null, 'image/jpeg', null, null, null, '2018-12-02 21:37:06.508', null);
INSERT INTO `kim_resources` VALUES ('ccbb40ed78284b63a33f11abb720c8ef', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/image.jpg.JPG', 'image.jpg.JPG', null, 'image/jpeg', null, null, null, '2018-12-02 22:45:44.311', null);
INSERT INTO `kim_resources` VALUES ('ccc3c7be338d4928908ca81adf520325', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/8.jpg', '8.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 21:37:17.487', null);
INSERT INTO `kim_resources` VALUES ('e7952720f5224d448ff6846cb845b75a', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/13.jpg', '13.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 22:45:44.305', null);
INSERT INTO `kim_resources` VALUES ('f47e9a5c89524af5926ca8d4199fcd62', null, null, null, null, null, null, null, null, null, null, '2', '/static/upload/kim/20181202/1.jpg', '1.jpg', null, 'image/jpeg', null, null, null, '2018-12-02 22:41:33.007', null);

-- ----------------------------
-- Table structure for kim_user
-- ----------------------------
DROP TABLE IF EXISTS `kim_user`;
CREATE TABLE `kim_user` (
  `uuid` varchar(32) NOT NULL COMMENT '主键id',
  `username` varchar(30) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` char(1) DEFAULT NULL COMMENT '性别（0女1男2保密）',
  `job` char(1) DEFAULT NULL COMMENT '职业类型(1：Java开发 2：前端开发 3：大数据开发 4：ios开发 5：Android开发 10：学生 11：其它)',
  `realname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `faceImage` varchar(32) DEFAULT NULL COMMENT '头像地址（资源表主键）',
  `province` varchar(30) DEFAULT NULL COMMENT '省',
  `city` varchar(30) DEFAULT NULL COMMENT '市',
  `district` varchar(30) DEFAULT NULL COMMENT '区',
  `address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `openid` varchar(100) DEFAULT NULL COMMENT '微信登录id',
  `nt` varchar(255) DEFAULT NULL COMMENT '备注',
  `ts` datetime DEFAULT NULL COMMENT '时间戳',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='kim小程序用户表';

-- ----------------------------
-- Records of kim_user
-- ----------------------------
INSERT INTO `kim_user` VALUES ('0da71453427f47c4bcec45d74458e5dc', 'ccc', '123456', '25', '1', '1', '曹先生', null, '陕西', '榆林', '榆阳区', '榆林大道3号线超越小区6栋', null, null, '2018-11-11 22:14:59');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('24', '1', '0', '[0],', '总公司', '总公司', '', null);
INSERT INTO `sys_dept` VALUES ('25', '2', '24', '[0],[24],', '开发部', '开发部', '', null);
INSERT INTO `sys_dept` VALUES ('26', '3', '24', '[0],[24],', '运营部', '运营部', '', null);
INSERT INTO `sys_dept` VALUES ('27', '4', '24', '[0],[24],', '战略部', '战略部', '', null);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `code` varchar(255) DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('50', '0', '0', '性别', null, 'sys_sex');
INSERT INTO `sys_dict` VALUES ('51', '1', '50', '男', null, '1');
INSERT INTO `sys_dict` VALUES ('52', '2', '50', '女', null, '2');
INSERT INTO `sys_dict` VALUES ('53', '0', '0', '状态', null, 'sys_state');
INSERT INTO `sys_dict` VALUES ('54', '1', '53', '启用', null, '1');
INSERT INTO `sys_dict` VALUES ('55', '2', '53', '禁用', null, '2');
INSERT INTO `sys_dict` VALUES ('56', '0', '0', '账号状态', null, 'account_state');
INSERT INTO `sys_dict` VALUES ('57', '1', '56', '启用', null, '1');
INSERT INTO `sys_dict` VALUES ('58', '2', '56', '冻结', null, '2');
INSERT INTO `sys_dict` VALUES ('59', '3', '56', '已删除', null, '3');

-- ----------------------------
-- Table structure for sys_expense
-- ----------------------------
DROP TABLE IF EXISTS `sys_expense`;
CREATE TABLE `sys_expense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` decimal(20,2) DEFAULT NULL COMMENT '报销金额',
  `desc` varchar(255) DEFAULT '' COMMENT '描述',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(11) DEFAULT NULL COMMENT '状态: 1.待提交  2:待审核   3.审核通过 4:驳回',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `processId` varchar(255) DEFAULT NULL COMMENT '流程定义id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报销表';

-- ----------------------------
-- Records of sys_expense
-- ----------------------------

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '管理员id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否执行成功',
  `message` text COMMENT '具体消息',
  `ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=305 DEFAULT CHARSET=utf8 COMMENT='登录记录';

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------
INSERT INTO `sys_login_log` VALUES ('291', '登录日志', '1', '2018-12-08 12:33:35', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('292', '登录日志', '1', '2018-12-08 12:49:52', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('293', '登录日志', '1', '2018-12-08 16:18:13', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('294', '登录日志', '1', '2018-12-08 16:24:25', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('295', '登录日志', '1', '2018-12-08 16:33:29', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('296', '登录日志', '1', '2018-12-08 16:34:29', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('297', '登录日志', '1', '2018-12-08 16:36:39', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('298', '登录日志', '1', '2018-12-09 22:53:15', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('299', '登录日志', '1', '2018-12-09 22:58:17', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('300', '登录日志', '1', '2018-12-09 23:09:35', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('301', '登录日志', '1', '2018-12-09 23:11:26', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('302', '登录日志', '1', '2018-12-09 23:15:47', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('303', '登录日志', '1', '2018-12-09 23:52:51', '成功', null, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_login_log` VALUES ('304', '登录日志', '1', '2018-12-10 00:13:28', '成功', null, '0:0:0:0:0:0:0:1');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1070984102437756936 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('105', 'system', '0', '[0],', '系统管理', 'fa-user', '#', '6', '1', '1', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('106', 'mgr', 'system', '[0],[system],', '用户管理', '', '/mgr', '1', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('107', 'mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', null, '/mgr/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('108', 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', null, '/mgr/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('109', 'mgr_delete', 'mgr', '[0],[system],[mgr],', '删除用户', null, '/mgr/delete', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('110', 'mgr_reset', 'mgr', '[0],[system],[mgr],', '重置密码', null, '/mgr/reset', '4', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('111', 'mgr_freeze', 'mgr', '[0],[system],[mgr],', '冻结用户', null, '/mgr/freeze', '5', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('112', 'mgr_unfreeze', 'mgr', '[0],[system],[mgr],', '解除冻结用户', null, '/mgr/unfreeze', '6', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('113', 'mgr_setRole', 'mgr', '[0],[system],[mgr],', '分配角色', null, '/mgr/setRole', '7', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('114', 'role', 'system', '[0],[system],', '角色管理', null, '/role', '2', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('115', 'role_add', 'role', '[0],[system],[role],', '添加角色', null, '/role/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('116', 'role_edit', 'role', '[0],[system],[role],', '修改角色', null, '/role/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('117', 'role_remove', 'role', '[0],[system],[role],', '删除角色', null, '/role/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('118', 'role_setAuthority', 'role', '[0],[system],[role],', '配置权限', null, '/role/setAuthority', '4', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('119', 'menu', 'system', '[0],[system],', '菜单管理', null, '/menu', '4', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('120', 'menu_add', 'menu', '[0],[system],[menu],', '添加菜单', null, '/menu/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('121', 'menu_edit', 'menu', '[0],[system],[menu],', '修改菜单', null, '/menu/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('122', 'menu_remove', 'menu', '[0],[system],[menu],', '删除菜单', null, '/menu/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('128', 'log', 'system', '[0],[system],', '业务日志', null, '/log', '6', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('130', 'druid', 'system', '[0],[system],', '监控管理', null, '/druid', '7', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('131', 'dept', 'system', '[0],[system],', '部门管理', null, '/dept', '3', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('132', 'dict', 'system', '[0],[system],', '字典管理', null, '/dict', '4', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('133', 'loginLog', 'system', '[0],[system],', '登录日志', null, '/loginLog', '6', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('134', 'log_clean', 'log', '[0],[system],[log],', '清空日志', null, '/log/delLog', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('135', 'dept_add', 'dept', '[0],[system],[dept],', '添加部门', null, '/dept/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('136', 'dept_update', 'dept', '[0],[system],[dept],', '修改部门', null, '/dept/update', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('137', 'dept_delete', 'dept', '[0],[system],[dept],', '删除部门', null, '/dept/delete', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('138', 'dict_add', 'dict', '[0],[system],[dict],', '添加字典', null, '/dict/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('139', 'dict_update', 'dict', '[0],[system],[dict],', '修改字典', null, '/dict/update', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('140', 'dict_delete', 'dict', '[0],[system],[dict],', '删除字典', null, '/dict/delete', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('141', 'notice', 'system', '[0],[system],', '通知管理', null, '/notice', '9', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('142', 'notice_add', 'notice', '[0],[system],[notice],', '添加通知', null, '/notice/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('143', 'notice_update', 'notice', '[0],[system],[notice],', '修改通知', null, '/notice/update', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('144', 'notice_delete', 'notice', '[0],[system],[notice],', '删除通知', null, '/notice/delete', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('145', 'hello', '0', '[0],', '通知', 'fa-rocket', '/notice/hello', '1', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('148', 'code', '0', '[0],', '代码生成', 'fa-code', '/code', '8', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('149', 'api_mgr', '0', '[0],', '接口文档', 'fa-leaf', '/swagger-ui.html', '9', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('150', 'to_menu_edit', 'menu', '[0],[system],[menu],', '菜单编辑跳转', '', '/menu/menu_edit', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('151', 'menu_list', 'menu', '[0],[system],[menu],', '菜单列表', '', '/menu/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('152', 'to_dept_update', 'dept', '[0],[system],[dept],', '修改部门跳转', '', '/dept/dept_update', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('153', 'dept_list', 'dept', '[0],[system],[dept],', '部门列表', '', '/dept/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('154', 'dept_detail', 'dept', '[0],[system],[dept],', '部门详情', '', '/dept/detail', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('155', 'to_dict_edit', 'dict', '[0],[system],[dict],', '修改菜单跳转', '', '/dict/dict_edit', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('156', 'dict_list', 'dict', '[0],[system],[dict],', '字典列表', '', '/dict/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('157', 'dict_detail', 'dict', '[0],[system],[dict],', '字典详情', '', '/dict/detail', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('158', 'log_list', 'log', '[0],[system],[log],', '日志列表', '', '/log/list', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('159', 'log_detail', 'log', '[0],[system],[log],', '日志详情', '', '/log/detail', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('160', 'del_login_log', 'loginLog', '[0],[system],[loginLog],', '清空登录日志', '', '/loginLog/delLoginLog', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('161', 'login_log_list', 'loginLog', '[0],[system],[loginLog],', '登录日志列表', '', '/loginLog/list', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('162', 'to_role_edit', 'role', '[0],[system],[role],', '修改角色跳转', '', '/role/role_edit', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('163', 'to_role_assign', 'role', '[0],[system],[role],', '角色分配跳转', '', '/role/role_assign', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('164', 'role_list', 'role', '[0],[system],[role],', '角色列表', '', '/role/list', '7', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('165', 'to_assign_role', 'mgr', '[0],[system],[mgr],', '分配角色跳转', '', '/mgr/role_assign', '8', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('166', 'to_user_edit', 'mgr', '[0],[system],[mgr],', '编辑用户跳转', '', '/mgr/user_edit', '9', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('167', 'mgr_list', 'mgr', '[0],[system],[mgr],', '用户列表', '', '/mgr/list', '10', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('168', 'jcxx', '0', '[0],', 'kimsohyun', 'fa-qrcode', '#', '3', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1066217093503913986', 'kimIndexJptj', 'jcxx', '[0],[jcxx],', '精品推荐', '', '/kimIndexJptj', '99', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066217093503913987', 'kimIndexJptj_list', 'kimIndexJptj', '[0],[jcxx],[kimIndexJptj],', '精品推荐列表', '', '/kimIndexJptj/list', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066217093503913988', 'kimIndexJptj_add', 'kimIndexJptj', '[0],[jcxx],[kimIndexJptj],', '精品推荐添加', '', '/kimIndexJptj/add', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066217093503913989', 'kimIndexJptj_update', 'kimIndexJptj', '[0],[jcxx],[kimIndexJptj],', '精品推荐更新', '', '/kimIndexJptj/update', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066217093503913990', 'kimIndexJptj_delete', 'kimIndexJptj', '[0],[jcxx],[kimIndexJptj],', '精品推荐删除', '', '/kimIndexJptj/delete', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066217093503913991', 'kimIndexJptj_detail', 'kimIndexJptj', '[0],[jcxx],[kimIndexJptj],', '精品推荐详情', '', '/kimIndexJptj/detail', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066219156250038273', 'kimIndexLb', 'jcxx', '[0],[jcxx],', '轮播图', '', '/kimIndexLb', '99', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066219156250038274', 'kimIndexLb_list', 'kimIndexLb', '[0],[jcxx],[kimIndexLb],', '轮播图列表', '', '/kimIndexLb/list', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066219156250038275', 'kimIndexLb_add', 'kimIndexLb', '[0],[jcxx],[kimIndexLb],', '轮播图添加', '', '/kimIndexLb/add', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066219156250038276', 'kimIndexLb_update', 'kimIndexLb', '[0],[jcxx],[kimIndexLb],', '轮播图更新', '', '/kimIndexLb/update', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066219156250038277', 'kimIndexLb_delete', 'kimIndexLb', '[0],[jcxx],[kimIndexLb],', '轮播图删除', '', '/kimIndexLb/delete', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066219156250038278', 'kimIndexLb_detail', 'kimIndexLb', '[0],[jcxx],[kimIndexLb],', '轮播图详情', '', '/kimIndexLb/detail', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066343706723962882', 'kimIndexRmtp', 'jcxx', '[0],[jcxx],', '热门图片', '', '/kimIndexRmtp', '99', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066343706723962883', 'kimIndexRmtp_list', 'kimIndexRmtp', '[0],[jcxx],[kimIndexRmtp],', '热门图片列表', '', '/kimIndexRmtp/list', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066343706723962884', 'kimIndexRmtp_add', 'kimIndexRmtp', '[0],[jcxx],[kimIndexRmtp],', '热门图片添加', '', '/kimIndexRmtp/add', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066343706723962885', 'kimIndexRmtp_update', 'kimIndexRmtp', '[0],[jcxx],[kimIndexRmtp],', '热门图片更新', '', '/kimIndexRmtp/update', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066343706723962886', 'kimIndexRmtp_delete', 'kimIndexRmtp', '[0],[jcxx],[kimIndexRmtp],', '热门图片删除', '', '/kimIndexRmtp/delete', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1066343706723962887', 'kimIndexRmtp_detail', 'kimIndexRmtp', '[0],[jcxx],[kimIndexRmtp],', '热门图片详情', '', '/kimIndexRmtp/detail', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1069197256567037954', 'kimUser', 'jcxx', '[0],[jcxx],', '微信用户', '', '/kimUser', '99', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1069197256567037955', 'kimUser_list', 'kimUser', '[0],[jcxx],[kimUser],', '微信用户列表', '', '/kimUser/list', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1069197256567037956', 'kimUser_add', 'kimUser', '[0],[jcxx],[kimUser],', '微信用户添加', '', '/kimUser/add', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1069197256567037957', 'kimUser_update', 'kimUser', '[0],[jcxx],[kimUser],', '微信用户更新', '', '/kimUser/update', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1069197256567037958', 'kimUser_delete', 'kimUser', '[0],[jcxx],[kimUser],', '微信用户删除', '', '/kimUser/delete', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1069197256567037959', 'kimUser_detail', 'kimUser', '[0],[jcxx],[kimUser],', '微信用户详情', '', '/kimUser/detail', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1069197256567037960', 'coin', '0', '[0],', '纪念币/钞', 'fa-qrcode', '#', '4', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1070585870847111169', 'coinIndexJpfl', 'coin', '[0],[coin],', '精品分类', '', '/coinIndexJpfl', '2', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070585870847111170', 'coinIndexJpfl_list', 'coinIndexJpfl', '[0],[coin],[coinIndexJpfl],', '精品分类列表', '', '/coinIndexJpfl/list', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070585870847111171', 'coinIndexJpfl_add', 'coinIndexJpfl', '[0],[coin],[coinIndexJpfl],', '精品分类添加', '', '/coinIndexJpfl/add', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070585870847111172', 'coinIndexJpfl_update', 'coinIndexJpfl', '[0],[coin],[coinIndexJpfl],', '精品分类更新', '', '/coinIndexJpfl/update', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070585870847111173', 'coinIndexJpfl_delete', 'coinIndexJpfl', '[0],[coin],[coinIndexJpfl],', '精品分类删除', '', '/coinIndexJpfl/delete', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070585870847111174', 'coinIndexJpfl_detail', 'coinIndexJpfl', '[0],[coin],[coinIndexJpfl],', '精品分类详情', '', '/coinIndexJpfl/detail', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070586442123898881', 'coinIndexLb', 'coin', '[0],[coin],', '轮播图', '', '/coinIndexLb', '1', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070586442123898882', 'coinIndexLb_list', 'coinIndexLb', '[0],[coin],[coinIndexLb],', '轮播图列表', '', '/coinIndexLb/list', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070586442123898883', 'coinIndexLb_add', 'coinIndexLb', '[0],[coin],[coinIndexLb],', '轮播图添加', '', '/coinIndexLb/add', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070586442123898884', 'coinIndexLb_update', 'coinIndexLb', '[0],[coin],[coinIndexLb],', '轮播图更新', '', '/coinIndexLb/update', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070586442123898885', 'coinIndexLb_delete', 'coinIndexLb', '[0],[coin],[coinIndexLb],', '轮播图删除', '', '/coinIndexLb/delete', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070586442123898886', 'coinIndexLb_detail', 'coinIndexLb', '[0],[coin],[coinIndexLb],', '轮播图详情', '', '/coinIndexLb/detail', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070984102437756930', 'coinKind', 'coin', '[0],[coin],', '品种信息', '', '/coinKind', '4', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070984102437756931', 'coinKind_list', 'coinKind', '[0],[coin],[coinKind],', '品种信息列表', '', '/coinKind/list', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070984102437756932', 'coinKind_add', 'coinKind', '[0],[coin],[coinKind],', '品种信息添加', '', '/coinKind/add', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070984102437756933', 'coinKind_update', 'coinKind', '[0],[coin],[coinKind],', '品种信息更新', '', '/coinKind/update', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070984102437756934', 'coinKind_delete', 'coinKind', '[0],[coin],[coinKind],', '品种信息删除', '', '/coinKind/delete', '99', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('1070984102437756935', 'coinKind_detail', 'coinKind', '[0],[coin],[coinKind],', '品种信息详情', '', '/coinKind/detail', '99', '3', '0', null, '1', '0');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='通知表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('6', '世界', '10', '欢迎使用Kim后台管理系统', '2017-01-11 08:53:20', '1');
INSERT INTO `sys_notice` VALUES ('8', '你好', null, '你好，kim', '2017-05-10 19:28:57', '1');

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logtype` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '用户id',
  `classname` varchar(255) DEFAULT NULL COMMENT '类名称',
  `method` text COMMENT '方法名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `message` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------
INSERT INTO `sys_operation_log` VALUES ('50', '业务日志', '清空业务日志', '1', 'cn.stylefeng.guns.modular.system.controller.LogController', 'delLog', '2018-12-08 12:29:05', '成功', '主键id=null');
INSERT INTO `sys_operation_log` VALUES ('51', '业务日志', '清空登录日志', '1', 'cn.stylefeng.guns.modular.system.controller.LoginLogController', 'delLog', '2018-12-08 12:29:11', '成功', '主键id=null');
INSERT INTO `sys_operation_log` VALUES ('52', '异常日志', '', '1', null, null, '2018-12-09 17:34:54', '失败', 'org.springframework.web.multipart.MultipartException: Failed to parse multipart servlet request; nested exception is java.io.IOException: The temporary upload location [C:\\Users\\superC\\AppData\\Local\\Temp\\tomcat.1116354106878535164.8064\\work\\Tomcat\\localhost\\ROOT] is not valid\r\n	at org.springframework.web.multipart.support.StandardMultipartHttpServletRequest.handleParseFailure(StandardMultipartHttpServletRequest.java:122)\r\n	at org.springframework.web.multipart.support.StandardMultipartHttpServletRequest.parseRequest(StandardMultipartHttpServletRequest.java:113)\r\n	at org.springframework.web.multipart.support.StandardMultipartHttpServletRequest.<init>(StandardMultipartHttpServletRequest.java:86)\r\n	at org.springframework.web.multipart.support.StandardServletMultipartResolver.resolveMultipart(StandardServletMultipartResolver.java:93)\r\n	at org.springframework.web.servlet.DispatcherServlet.checkMultipart(DispatcherServlet.java:1128)\r\n	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:960)\r\n	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:925)\r\n	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:974)\r\n	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:877)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:661)\r\n	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:851)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:742)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)\r\n	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)\r\n	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)\r\n	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\r\n	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)\r\n	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)\r\n	at org.apache.shiro.web.servlet.AbstractShiroFilterT1.call(AbstractShiroFilter.java:365)\r\n	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)\r\n	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)\r\n	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387)\r\n	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)\r\n	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at cn.stylefeng.roses.core.xss.XssFilter.doFilter(XssFilter.java:31)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:109)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:81)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:200)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:198)\r\n	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\r\n	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:496)\r\n	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:140)\r\n	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:81)\r\n	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:87)\r\n	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:342)\r\n	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:803)\r\n	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)\r\n	at org.apache.coyote.AbstractProtocolTConnectionHandler.process(AbstractProtocol.java:790)\r\n	at org.apache.tomcat.util.net.NioEndpointTSocketProcessor.doRun(NioEndpoint.java:1459)\r\n	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\r\n	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\r\n	at java.util.concurrent.ThreadPoolExecutorTWorker.run(ThreadPoolExecutor.java:617)\r\n	at org.apache.tomcat.util.threads.TaskThreadTWrappingRunnable.run(TaskThread.java:61)\r\n	at java.lang.Thread.run(Thread.java:745)\r\nCaused by: java.io.IOException: The temporary upload location [C:\\Users\\superC\\AppData\\Local\\Temp\\tomcat.1116354106878535164.8064\\work\\Tomcat\\localhost\\ROOT] is not valid\r\n	at org.apache.catalina.connector.Request.parseParts(Request.java:2843)\r\n	at org.apache.catalina.connector.Request.parseParameters(Request.java:3216)\r\n	at org.apache.catalina.connector.Request.getParameter(Request.java:1137)\r\n	at org.apache.catalina.connector.RequestFacade.getParameter(RequestFacade.java:381)\r\n	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:75)\r\n	... 23 more\r\n');
INSERT INTO `sys_operation_log` VALUES ('53', '异常日志', '', '1', null, null, '2018-12-09 17:36:41', '失败', 'org.springframework.web.multipart.MultipartException: Failed to parse multipart servlet request; nested exception is java.io.IOException: The temporary upload location [C:\\Users\\superC\\AppData\\Local\\Temp\\tomcat.1116354106878535164.8064\\work\\Tomcat\\localhost\\ROOT] is not valid\r\n	at org.springframework.web.multipart.support.StandardMultipartHttpServletRequest.handleParseFailure(StandardMultipartHttpServletRequest.java:122)\r\n	at org.springframework.web.multipart.support.StandardMultipartHttpServletRequest.parseRequest(StandardMultipartHttpServletRequest.java:113)\r\n	at org.springframework.web.multipart.support.StandardMultipartHttpServletRequest.<init>(StandardMultipartHttpServletRequest.java:86)\r\n	at org.springframework.web.multipart.support.StandardServletMultipartResolver.resolveMultipart(StandardServletMultipartResolver.java:93)\r\n	at org.springframework.web.servlet.DispatcherServlet.checkMultipart(DispatcherServlet.java:1128)\r\n	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:960)\r\n	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:925)\r\n	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:974)\r\n	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:877)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:661)\r\n	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:851)\r\n	at javax.servlet.http.HttpServlet.service(HttpServlet.java:742)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)\r\n	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)\r\n	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)\r\n	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\r\n	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)\r\n	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)\r\n	at org.apache.shiro.web.servlet.AbstractShiroFilterT1.call(AbstractShiroFilter.java:365)\r\n	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)\r\n	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)\r\n	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387)\r\n	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)\r\n	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at cn.stylefeng.roses.core.xss.XssFilter.doFilter(XssFilter.java:31)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:109)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:81)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:200)\r\n	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)\r\n	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:198)\r\n	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\r\n	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:496)\r\n	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:140)\r\n	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:81)\r\n	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:87)\r\n	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:342)\r\n	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:803)\r\n	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)\r\n	at org.apache.coyote.AbstractProtocolTConnectionHandler.process(AbstractProtocol.java:790)\r\n	at org.apache.tomcat.util.net.NioEndpointTSocketProcessor.doRun(NioEndpoint.java:1459)\r\n	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\r\n	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\r\n	at java.util.concurrent.ThreadPoolExecutorTWorker.run(ThreadPoolExecutor.java:617)\r\n	at org.apache.tomcat.util.threads.TaskThreadTWrappingRunnable.run(TaskThread.java:61)\r\n	at java.lang.Thread.run(Thread.java:745)\r\nCaused by: java.io.IOException: The temporary upload location [C:\\Users\\superC\\AppData\\Local\\Temp\\tomcat.1116354106878535164.8064\\work\\Tomcat\\localhost\\ROOT] is not valid\r\n	at org.apache.catalina.connector.Request.parseParts(Request.java:2843)\r\n	at org.apache.catalina.connector.Request.parseParameters(Request.java:3216)\r\n	at org.apache.catalina.connector.Request.getParameter(Request.java:1137)\r\n	at org.apache.catalina.connector.RequestFacade.getParameter(RequestFacade.java:381)\r\n	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:75)\r\n	... 23 more\r\n');
INSERT INTO `sys_operation_log` VALUES ('54', '业务日志', '修改管理员', '1', 'cn.stylefeng.guns.modular.system.controller.UserMgrController', 'edit', '2018-12-09 23:38:51', '成功', '账号=manager;;;字段名称:null,旧值:b53cac62e7175637d4beb3b16b2f7915,新值:;;;字段名称:生日,旧值:2017-12-04,新值:2017-12-19');

-- ----------------------------
-- Table structure for sys_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_relation`;
CREATE TABLE `sys_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` bigint(11) DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4353 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_relation
-- ----------------------------
INSERT INTO `sys_relation` VALUES ('4079', '168', '5');
INSERT INTO `sys_relation` VALUES ('4080', '1066217093503913986', '5');
INSERT INTO `sys_relation` VALUES ('4081', '1066217093503913987', '5');
INSERT INTO `sys_relation` VALUES ('4082', '1066217093503913988', '5');
INSERT INTO `sys_relation` VALUES ('4083', '1066217093503913989', '5');
INSERT INTO `sys_relation` VALUES ('4084', '1066217093503913990', '5');
INSERT INTO `sys_relation` VALUES ('4085', '1066217093503913991', '5');
INSERT INTO `sys_relation` VALUES ('4086', '1066219156250038273', '5');
INSERT INTO `sys_relation` VALUES ('4087', '1066219156250038274', '5');
INSERT INTO `sys_relation` VALUES ('4088', '1066219156250038275', '5');
INSERT INTO `sys_relation` VALUES ('4089', '1066219156250038276', '5');
INSERT INTO `sys_relation` VALUES ('4090', '1066219156250038277', '5');
INSERT INTO `sys_relation` VALUES ('4091', '1066219156250038278', '5');
INSERT INTO `sys_relation` VALUES ('4092', '1066343706723962882', '5');
INSERT INTO `sys_relation` VALUES ('4093', '1066343706723962883', '5');
INSERT INTO `sys_relation` VALUES ('4094', '1066343706723962884', '5');
INSERT INTO `sys_relation` VALUES ('4095', '1066343706723962885', '5');
INSERT INTO `sys_relation` VALUES ('4096', '1066343706723962886', '5');
INSERT INTO `sys_relation` VALUES ('4097', '1066343706723962887', '5');
INSERT INTO `sys_relation` VALUES ('4260', '105', '1');
INSERT INTO `sys_relation` VALUES ('4261', '106', '1');
INSERT INTO `sys_relation` VALUES ('4262', '107', '1');
INSERT INTO `sys_relation` VALUES ('4263', '108', '1');
INSERT INTO `sys_relation` VALUES ('4264', '109', '1');
INSERT INTO `sys_relation` VALUES ('4265', '110', '1');
INSERT INTO `sys_relation` VALUES ('4266', '111', '1');
INSERT INTO `sys_relation` VALUES ('4267', '112', '1');
INSERT INTO `sys_relation` VALUES ('4268', '113', '1');
INSERT INTO `sys_relation` VALUES ('4269', '165', '1');
INSERT INTO `sys_relation` VALUES ('4270', '166', '1');
INSERT INTO `sys_relation` VALUES ('4271', '167', '1');
INSERT INTO `sys_relation` VALUES ('4272', '114', '1');
INSERT INTO `sys_relation` VALUES ('4273', '115', '1');
INSERT INTO `sys_relation` VALUES ('4274', '116', '1');
INSERT INTO `sys_relation` VALUES ('4275', '117', '1');
INSERT INTO `sys_relation` VALUES ('4276', '118', '1');
INSERT INTO `sys_relation` VALUES ('4277', '162', '1');
INSERT INTO `sys_relation` VALUES ('4278', '163', '1');
INSERT INTO `sys_relation` VALUES ('4279', '164', '1');
INSERT INTO `sys_relation` VALUES ('4280', '119', '1');
INSERT INTO `sys_relation` VALUES ('4281', '120', '1');
INSERT INTO `sys_relation` VALUES ('4282', '121', '1');
INSERT INTO `sys_relation` VALUES ('4283', '122', '1');
INSERT INTO `sys_relation` VALUES ('4284', '150', '1');
INSERT INTO `sys_relation` VALUES ('4285', '151', '1');
INSERT INTO `sys_relation` VALUES ('4286', '128', '1');
INSERT INTO `sys_relation` VALUES ('4287', '134', '1');
INSERT INTO `sys_relation` VALUES ('4288', '158', '1');
INSERT INTO `sys_relation` VALUES ('4289', '159', '1');
INSERT INTO `sys_relation` VALUES ('4290', '130', '1');
INSERT INTO `sys_relation` VALUES ('4291', '131', '1');
INSERT INTO `sys_relation` VALUES ('4292', '135', '1');
INSERT INTO `sys_relation` VALUES ('4293', '136', '1');
INSERT INTO `sys_relation` VALUES ('4294', '137', '1');
INSERT INTO `sys_relation` VALUES ('4295', '152', '1');
INSERT INTO `sys_relation` VALUES ('4296', '153', '1');
INSERT INTO `sys_relation` VALUES ('4297', '154', '1');
INSERT INTO `sys_relation` VALUES ('4298', '132', '1');
INSERT INTO `sys_relation` VALUES ('4299', '138', '1');
INSERT INTO `sys_relation` VALUES ('4300', '139', '1');
INSERT INTO `sys_relation` VALUES ('4301', '140', '1');
INSERT INTO `sys_relation` VALUES ('4302', '155', '1');
INSERT INTO `sys_relation` VALUES ('4303', '156', '1');
INSERT INTO `sys_relation` VALUES ('4304', '157', '1');
INSERT INTO `sys_relation` VALUES ('4305', '133', '1');
INSERT INTO `sys_relation` VALUES ('4306', '160', '1');
INSERT INTO `sys_relation` VALUES ('4307', '161', '1');
INSERT INTO `sys_relation` VALUES ('4308', '141', '1');
INSERT INTO `sys_relation` VALUES ('4309', '142', '1');
INSERT INTO `sys_relation` VALUES ('4310', '143', '1');
INSERT INTO `sys_relation` VALUES ('4311', '144', '1');
INSERT INTO `sys_relation` VALUES ('4312', '145', '1');
INSERT INTO `sys_relation` VALUES ('4313', '148', '1');
INSERT INTO `sys_relation` VALUES ('4314', '149', '1');
INSERT INTO `sys_relation` VALUES ('4315', '168', '1');
INSERT INTO `sys_relation` VALUES ('4316', '1066217093503913986', '1');
INSERT INTO `sys_relation` VALUES ('4317', '1066217093503913987', '1');
INSERT INTO `sys_relation` VALUES ('4318', '1066217093503913988', '1');
INSERT INTO `sys_relation` VALUES ('4319', '1066217093503913989', '1');
INSERT INTO `sys_relation` VALUES ('4320', '1066217093503913990', '1');
INSERT INTO `sys_relation` VALUES ('4321', '1066217093503913991', '1');
INSERT INTO `sys_relation` VALUES ('4322', '1066219156250038273', '1');
INSERT INTO `sys_relation` VALUES ('4323', '1066219156250038274', '1');
INSERT INTO `sys_relation` VALUES ('4324', '1066219156250038275', '1');
INSERT INTO `sys_relation` VALUES ('4325', '1066219156250038276', '1');
INSERT INTO `sys_relation` VALUES ('4326', '1066219156250038277', '1');
INSERT INTO `sys_relation` VALUES ('4327', '1066219156250038278', '1');
INSERT INTO `sys_relation` VALUES ('4328', '1066343706723962882', '1');
INSERT INTO `sys_relation` VALUES ('4329', '1066343706723962883', '1');
INSERT INTO `sys_relation` VALUES ('4330', '1066343706723962884', '1');
INSERT INTO `sys_relation` VALUES ('4331', '1066343706723962885', '1');
INSERT INTO `sys_relation` VALUES ('4332', '1066343706723962886', '1');
INSERT INTO `sys_relation` VALUES ('4333', '1066343706723962887', '1');
INSERT INTO `sys_relation` VALUES ('4334', '1069197256567037960', '1');
INSERT INTO `sys_relation` VALUES ('4335', '1070585870847111169', '1');
INSERT INTO `sys_relation` VALUES ('4336', '1070585870847111170', '1');
INSERT INTO `sys_relation` VALUES ('4337', '1070585870847111171', '1');
INSERT INTO `sys_relation` VALUES ('4338', '1070585870847111172', '1');
INSERT INTO `sys_relation` VALUES ('4339', '1070585870847111173', '1');
INSERT INTO `sys_relation` VALUES ('4340', '1070585870847111174', '1');
INSERT INTO `sys_relation` VALUES ('4341', '1070586442123898881', '1');
INSERT INTO `sys_relation` VALUES ('4342', '1070586442123898882', '1');
INSERT INTO `sys_relation` VALUES ('4343', '1070586442123898883', '1');
INSERT INTO `sys_relation` VALUES ('4344', '1070586442123898884', '1');
INSERT INTO `sys_relation` VALUES ('4345', '1070586442123898885', '1');
INSERT INTO `sys_relation` VALUES ('4346', '1070586442123898886', '1');
INSERT INTO `sys_relation` VALUES ('4347', '1070984102437756930', '1');
INSERT INTO `sys_relation` VALUES ('4348', '1070984102437756931', '1');
INSERT INTO `sys_relation` VALUES ('4349', '1070984102437756932', '1');
INSERT INTO `sys_relation` VALUES ('4350', '1070984102437756933', '1');
INSERT INTO `sys_relation` VALUES ('4351', '1070984102437756934', '1');
INSERT INTO `sys_relation` VALUES ('4352', '1070984102437756935', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '0', '超级管理员', '24', 'administrator', '1');
INSERT INTO `sys_role` VALUES ('5', '2', '1', '临时', '26', 'temp', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `roleid` varchar(255) DEFAULT NULL COMMENT '角色id',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'dc0bbfc2-6772-48d7-b168-42742b5ae47f.jpeg', 'admin', 'ecfadcde9305f8891bcfe5a1e28c253e', '8pgby', 'superC', '2017-05-05 00:00:00', '2', 'sn93@qq.com', '18200000000', '1', '27', '1', '2016-01-29 08:49:53', '25');
INSERT INTO `sys_user` VALUES ('44', null, 'test', '45abb7879f6a8268f1ef600e6038ac73', 'ssts3', 'test', '2017-05-01 00:00:00', '1', 'abc@123.com', '', '5', '26', '3', '2017-05-16 20:33:37', null);
INSERT INTO `sys_user` VALUES ('45', null, 'boss', '71887a5ad666a18f709e1d4e693d5a35', '1f7bf', '老板', '2017-12-04 00:00:00', '1', '', '', '1', '24', '1', '2017-12-04 22:24:02', null);
INSERT INTO `sys_user` VALUES ('46', null, 'manager', 'b53cac62e7175637d4beb3b16b2f7915', 'j3cs9', '经理', '2017-12-19 00:00:00', '1', '', '', '1', '24', '1', '2017-12-04 22:24:24', null);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `aaa` int(11) NOT NULL AUTO_INCREMENT,
  `bbb` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aaa`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of test
-- ----------------------------
