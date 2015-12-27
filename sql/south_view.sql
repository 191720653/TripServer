/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.16 : Database - south_view
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`south_view` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `south_view`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论Id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `view_id` int(11) DEFAULT NULL COMMENT '景区Id',
  `content` varchar(100) DEFAULT NULL COMMENT '内容',
  `create_date` date DEFAULT NULL COMMENT '时间',
  `score` varchar(5) DEFAULT NULL COMMENT '分数',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`comment_id`),
  KEY `C_R_V_VID` (`view_id`),
  KEY `C_R_U_UID` (`user_id`),
  CONSTRAINT `C_R_V_VID` FOREIGN KEY (`view_id`) REFERENCES `views` (`view_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `C_R_U_UID` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `account` varchar(25) DEFAULT NULL COMMENT '账号',
  `password` varchar(25) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(25) DEFAULT NULL COMMENT '昵称',
  `true_name` varchar(25) DEFAULT NULL COMMENT '姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `icon` varchar(200) DEFAULT NULL COMMENT '头像',
  `phone` varchar(25) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(25) DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(25) DEFAULT NULL COMMENT 'QQ号码',
  `wechat` varchar(25) DEFAULT NULL COMMENT '微信号',
  `info` varchar(200) DEFAULT NULL COMMENT '简介',
  `sign` int(11) DEFAULT NULL COMMENT '管理员标志',
  `create_date` date DEFAULT NULL COMMENT '注册日期',
  `last_update` date DEFAULT NULL COMMENT '更新日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`user_id`,`account`,`password`,`nick_name`,`true_name`,`sex`,`birthday`,`icon`,`phone`,`email`,`qq`,`wechat`,`info`,`sign`,`create_date`,`last_update`,`remark`) values (1,'zehao','zehao','则好','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789','则好，我就是我！',1,'2015-12-27','2015-12-27','管理员！');

/*Table structure for table `view_image` */

DROP TABLE IF EXISTS `view_image`;

CREATE TABLE `view_image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '相片Id',
  `view_id` int(11) DEFAULT NULL COMMENT '景区Id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `image_info` varchar(100) DEFAULT NULL COMMENT '图片信息',
  `image_url` varchar(200) DEFAULT NULL COMMENT '图片URL',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`image_id`),
  KEY `VI_R_V_VID` (`view_id`),
  KEY `VI_R_U_UID` (`user_id`),
  CONSTRAINT `VI_R_V_VID` FOREIGN KEY (`view_id`) REFERENCES `views` (`view_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `VI_R_U_UID` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `view_image` */

insert  into `view_image`(`image_id`,`view_id`,`user_id`,`image_info`,`image_url`,`create_date`,`remark`) values (1,1,1,NULL,'shumuyuan_1.jpg','2015-12-27',NULL),(2,1,1,NULL,'shumuyuan_2.jpg','2015-12-27',NULL),(3,1,1,NULL,'shumuyuan_3.jpg','2015-12-27',NULL),(4,1,1,NULL,'shumuyuan_4.jpg','2015-12-27',NULL),(5,2,1,NULL,'zhanyuan_1.jpg','2015-12-27',NULL),(6,2,1,NULL,'zhanyuan_2.jpg','2015-12-27',NULL),(7,2,1,NULL,'zhanyuan_3.jpg','2015-12-27',NULL),(8,2,1,NULL,'zhanyuan_4.jpg','2015-12-27',NULL);

/*Table structure for table `view_voice` */

DROP TABLE IF EXISTS `view_voice`;

CREATE TABLE `view_voice` (
  `voice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '音频Id',
  `view_id` int(11) DEFAULT NULL COMMENT '景区Id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `voice_info` varchar(100) DEFAULT NULL COMMENT '音频信息',
  `voice_url` varchar(200) DEFAULT NULL COMMENT '音频地址',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`voice_id`),
  KEY `VO_R_V_VID` (`view_id`),
  KEY `VO_R_U_UID` (`user_id`),
  CONSTRAINT `VO_R_V_VID` FOREIGN KEY (`view_id`) REFERENCES `views` (`view_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `VO_R_U_UID` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `view_voice` */

/*Table structure for table `views` */

DROP TABLE IF EXISTS `views`;

CREATE TABLE `views` (
  `view_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '景区Id',
  `village_id` int(11) DEFAULT NULL COMMENT '村子Id',
  `view_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `view_address` varchar(200) DEFAULT NULL COMMENT '地址',
  `view_guide` varchar(500) DEFAULT NULL COMMENT '导语',
  `view_info` varchar(500) DEFAULT NULL COMMENT '简介',
  `view_logo` varchar(200) DEFAULT NULL COMMENT '标志',
  `open_time` varchar(50) DEFAULT NULL COMMENT '开放时间',
  `ticket` varchar(50) DEFAULT NULL COMMENT '票价',
  `phone` varchar(25) DEFAULT NULL COMMENT '联系电话',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`view_id`),
  KEY `V_R_V_VID` (`village_id`),
  CONSTRAINT `V_R_V_VID` FOREIGN KEY (`village_id`) REFERENCES `village` (`village_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `views` */

insert  into `views`(`view_id`,`village_id`,`view_name`,`view_address`,`view_guide`,`view_info`,`view_logo`,`open_time`,`ticket`,`phone`,`create_date`,`remark`) values (1,1,'中山市树木园','广东省中山市南区外环路上','shumuyuan_logo.jpg','位于中山市城区南郊，占地总面积1400多亩，目前投入2900万元的第一期建设工程已完成了树木标本收集92科1200多种，初步建成了木兰园系统分类区竹园等小园区。完成的基础设施包括15公里的登山路，8公里的环山路人工湖及休闲广场等等。二期工程将继续完善配套设施，总体规划建设桃花园山茶花园杜鹃园盆景园等专类园区。树木园共分科普区苗圃示范区生态林建设示范区科研管理区等4个功能区和19个小区。整个树木园主要以乡土树种主打。其中的乡土树种示范区，将广泛种植具有中山特色的树种，如土沉香四药门花黄桐水松等。目前，全国共有各类植物园，包括树木园标本园等100多个。但这些植物园的种类均不是以乡土树种为主，更不是以植物系统进化进行布局的，因此，中山树木园的建成将填补我国这方面的空白。从城轨北站坐038公交车至树木园站下车即可。',NULL,'6:00-22:00','免费',NULL,'2015-12-27',NULL),(2,1,'中山詹园','广东省中山市南区北台村105国道旁','zhanyuan_logo.jpg','中山詹园，又名中山大宅门，坐落于中山市南区北台村，是目前岭南地区最大的私家古典园林。詹园占地百亩，是由詹园主人黄远新亲自设计(黄先生是中山人在澳门做生意)并从苏杭征调数百名园林能工巧匠历时五年共同建成的。詹园主人的初衷，出于为母亲建造一处淡雅精致颐养天年的静心居所。因此最早的詹园，即现在的詹家后院，是詹家上下尤其是詹老太的饮食起居之地詹老太搬离之后，里面的生活器具仍然保持着最初的模样，成为詹家家史的真实见证。',NULL,'08:00~17:30','￥60元',NULL,'2015-12-27','AAAA景区');

/*Table structure for table `village` */

DROP TABLE IF EXISTS `village`;

CREATE TABLE `village` (
  `village_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '村子Id',
  `village_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `village_address` varchar(200) DEFAULT NULL COMMENT '地址',
  `village_info` varchar(500) DEFAULT NULL COMMENT '简介',
  `village_logo` varchar(200) DEFAULT NULL COMMENT '标志',
  `history_record` varchar(500) DEFAULT NULL COMMENT '历史典故',
  `village_story` varchar(500) DEFAULT NULL COMMENT '记录',
  `create_date` date DEFAULT NULL COMMENT '创建记录时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`village_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `village` */

insert  into `village`(`village_id`,`village_name`,`village_address`,`village_info`,`village_logo`,`history_record`,`village_story`,`create_date`,`remark`) values (1,'南区','中山市南区','中山市是广东省著名的侨乡，在市区和各个乡镇留下了大量19—20世纪初古老的侨房和人文景观。这些建筑群是历史上中西方文化强烈碰撞的宝贵文化遗产，积淀着极为丰富的历史、文化、民族、地域、科学、情感的信息价值。',NULL,NULL,NULL,'2015-12-27',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
