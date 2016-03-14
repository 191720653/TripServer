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
  `store_id` int(11) DEFAULT NULL COMMENT '名店Id',
  `special_id` int(11) DEFAULT NULL COMMENT '特产Id',
  `content` varchar(100) DEFAULT NULL COMMENT '内容',
  `create_date` date DEFAULT NULL COMMENT '时间',
  `score` varchar(5) DEFAULT NULL COMMENT '分数',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`comment_id`),
  KEY `C_R_V_VID` (`view_id`),
  KEY `C_R_U_UID` (`user_id`),
  KEY `C_R_V_STID` (`store_id`),
  KEY `C_R_V_SPID` (`special_id`),
  CONSTRAINT `C_R_U_UID` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `C_R_V_SPID` FOREIGN KEY (`special_id`) REFERENCES `specialty` (`special_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `C_R_V_STID` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `C_R_V_VID` FOREIGN KEY (`view_id`) REFERENCES `views` (`view_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`comment_id`,`user_id`,`view_id`,`store_id`,`special_id`,`content`,`create_date`,`score`,`remark`) values (1,1,NULL,NULL,NULL,'dd','2015-12-08','4','ddd'),(2,NULL,1,NULL,NULL,'ggg','2016-01-13','6','hh'),(3,NULL,NULL,9,NULL,'vvv','2016-01-20','7','nn'),(4,NULL,NULL,NULL,2,'sssss','2016-01-18','3','mm'),(5,1,4,8,1,'bbbbbbbbbbb','2016-01-06','0','aaaaaaaaa');

/*Table structure for table `specialty` */

DROP TABLE IF EXISTS `specialty`;

CREATE TABLE `specialty` (
  `special_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '特产Id',
  `special_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `special_info` varchar(500) DEFAULT NULL COMMENT '简介',
  `special_address` varchar(200) DEFAULT NULL COMMENT '地址',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`special_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `specialty` */

insert  into `specialty`(`special_id`,`special_name`,`special_info`,`special_address`,`create_date`,`remark`) values (1,'刚刚','哥哥','各个资源','2016-01-10','广告歌'),(2,'版本','并不','滨保','2016-01-10','不必');

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `store_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '名店Id',
  `store_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `store_info` varchar(500) DEFAULT NULL COMMENT '简介',
  `store_address` varchar(200) DEFAULT NULL COMMENT '地址',
  `store_time` varchar(50) DEFAULT NULL COMMENT '时间',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `store` */

insert  into `store`(`store_id`,`store_name`,`store_info`,`store_address`,`store_time`,`create_date`,`remark`) values (8,'发','发','发','2016-01-09','2016-01-10','发'),(9,'烦烦烦','上的','的','2016-01-10','2016-01-10','上的'),(10,'qweqwe','qwe','qwe','2016-01-16','2016-01-10','wqe'),(11,'ddddsdd得到','点点滴滴点点滴滴的的的的的的的的的的','顶顶顶顶顶','2016-01-01','2016-01-10','顶顶顶顶顶'),(13,'反反复复反反复复',' 反反复复反反复复发发发 岁的法国','反反复复烦烦烦','2016-01-03','2016-01-10',' 反反复复凤飞飞方法'),(14,'去','去','去','2016-01-02','2016-01-10','去'),(15,'我','我','我','2016-01-10','2016-01-10','我'),(16,'饿','饿','饿','2016-01-09','2016-01-10','饿'),(17,'日','日','日','2016-01-29','2016-01-10','日'),(18,'他','他','他','2016-01-06','2016-01-10','他'),(19,'一','一','一','2016-01-17','2016-01-10','一'),(20,'发发','发发','发发','2016-01-08','2016-01-10','发发');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

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
  `sina` varchar(50) DEFAULT NULL COMMENT 'sina号',
  `info` varchar(200) DEFAULT NULL COMMENT '简介',
  `sign` int(11) DEFAULT NULL COMMENT '管理员标志',
  `token` varchar(200) DEFAULT NULL COMMENT '用户登录后的token',
  `type` varchar(10) DEFAULT NULL COMMENT '用户来源类型',
  `type_id` varchar(100) DEFAULT NULL COMMENT '来源Id',
  `login_sign` varchar(10) DEFAULT NULL COMMENT '用户是否登录标志',
  `create_date` date DEFAULT NULL COMMENT '注册日期',
  `last_update` date DEFAULT NULL COMMENT '更新日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`user_id`,`account`,`password`,`nick_name`,`true_name`,`sex`,`birthday`,`icon`,`phone`,`email`,`qq`,`wechat`,`sina`,`info`,`sign`,`token`,`type`,`type_id`,`login_sign`,`create_date`,`last_update`,`remark`) values (1,'zehao','zehao','则好','则好',1,'2015-12-27','./photoes/image_nanqu.png','1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',1,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(2,'222','222','则好2','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',1,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(3,'333','333','则好3','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(4,'444','444','则好4','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(5,'555','555','则好5','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(6,'666','666','则好6','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(7,'777','777','则好7','则好',0,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(8,'888','888','则好8','则好',0,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(9,'999','999','则好9','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(10,'www','www','则好w','则好',1,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(11,'qqq','qqq','则好q','则好',0,'2015-12-27',NULL,'1234567890','123456789@qq.com','123456789','123456789',NULL,'则好，我就是我！',2,NULL,NULL,NULL,NULL,'2015-12-27','2015-12-27','管理员！'),(12,'123','摸JJ基金经理爸','没看见考虑考虑联系联系啊',NULL,1,NULL,'./icons/1457623057855.jpg',NULL,NULL,NULL,NULL,NULL,NULL,3,NULL,'common','123','on','2016-03-10',NULL,'考虑考虑联系联系考虑考虑'),(13,'12345678','12345678','查流量',NULL,1,NULL,'./icons/1457623604951.jpg',NULL,NULL,NULL,NULL,NULL,NULL,3,NULL,'common','12345678','on','2016-03-10',NULL,'啊啦啦啦啦'),(14,'123456789','123456789','啊啦拉',NULL,1,NULL,'./icons/1457624079694.jpg',NULL,NULL,NULL,NULL,NULL,NULL,3,NULL,'common','123456789','on','2016-03-10',NULL,'鹅鹅鹅'),(15,'87654321','87654321','啊啊',NULL,1,NULL,'./icons/1457624846116.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'common','87654321','on','2016-03-10',NULL,'得得'),(16,'753159258','fdjfchfdg','qaz',NULL,0,NULL,'./icons/1457671214864.jpg',NULL,NULL,NULL,NULL,NULL,'sfdcgddgf',2,NULL,'common','753159258','off','2016-03-11',NULL,NULL),(17,'qefghfff','ttstyyyyy','rdgffgyy',NULL,0,NULL,'./icons/1457671867331.jpg',NULL,NULL,NULL,NULL,NULL,'fffhhg',2,NULL,'common','qefghfff','off','2016-03-11',NULL,NULL),(18,'524555555','fgxggxhgf','fgdgt',NULL,0,NULL,'./icons/1457672572632.jpg',NULL,NULL,NULL,NULL,NULL,'tffgff',2,NULL,'common','524555555','off','2016-03-11',NULL,NULL),(19,'txjffygf','dgxhffuy','dtrt',NULL,1,NULL,'./icons/1457672676496.jpg',NULL,NULL,NULL,NULL,NULL,'ttdttt',2,NULL,'common','txjffygf','off','2016-03-11',NULL,NULL),(20,'dgfdhfgf','Tddfhfggdd','ffhffhgf',NULL,0,NULL,'./icons/1457673810930.jpg',NULL,NULL,NULL,NULL,NULL,'gxggfhg',2,NULL,'common','dgfdhfgf','off','2016-03-11',NULL,NULL),(21,'tttttttttr','fdgdsfgd','dxgffggf',NULL,0,NULL,'./icons/1457673989994.jpg',NULL,NULL,NULL,NULL,NULL,'rsghdd',2,NULL,'common','tttttttttr','off','2016-03-11',NULL,NULL),(22,'gggggggg','tttttttttr','gfghggf',NULL,0,NULL,'./icons/1457674865443.jpg',NULL,NULL,NULL,NULL,NULL,'hggggg',2,NULL,'common','gggggggg','off','2016-03-11',NULL,NULL),(23,'rrrrrttttt','rrrrrttttt','rrrrrttttt',NULL,0,NULL,'./icons/1457674978760.jpg',NULL,NULL,NULL,NULL,NULL,'rrrrrttttt',2,NULL,'common','rrrrrttttt','off','2016-03-11',NULL,NULL),(24,'eeeewwww','eeeewwww','eeeewwww',NULL,0,NULL,'./icons/1457675299732.jpg',NULL,NULL,NULL,NULL,NULL,'eeeewwww',2,'7B89E4ACBF8C4B39A228181E7756CE38','common','eeeewwww','on','2016-03-11',NULL,NULL),(25,'aaaadddd','aaaadddd','aaaadddd',NULL,0,NULL,'./icons/1457675783650.jpg',NULL,NULL,NULL,NULL,NULL,'aaaadddd',2,'D549F544F10241F3B60A8937FFBDE44F','common','aaaadddd','on','2016-03-11',NULL,NULL),(26,'145767953826','145767953826','魑魅魍魉',NULL,0,NULL,'./icons/1457679484326.jpg',NULL,NULL,NULL,NULL,NULL,'我的QQ',2,'CE94A2AA5A164A6EAEBF87A7D2B7CC9C','QZone','C62E2073CD9428E6C9A53C1A82343889','on','2016-03-11',NULL,NULL),(27,'145779880105','145779880105','手机用户2241070071',NULL,0,NULL,'./icons/1457680092068.jpg',NULL,NULL,NULL,NULL,NULL,'null',2,'7D5BFB34E0AF4EEFA0E72F62C258B7C2','SinaWeibo','2241070071','on','2016-03-11',NULL,NULL);

/*Table structure for table `view_image` */

DROP TABLE IF EXISTS `view_image`;

CREATE TABLE `view_image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '相片Id',
  `view_id` int(11) DEFAULT NULL COMMENT '景区Id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `village_id` int(11) DEFAULT NULL COMMENT '村庄Id',
  `image_info` varchar(100) DEFAULT NULL COMMENT '图片信息',
  `image_url` varchar(200) DEFAULT NULL COMMENT '图片URL',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`image_id`),
  KEY `VI_R_V_VID` (`view_id`),
  KEY `VI_R_U_UID` (`user_id`),
  KEY `VI_R_V_VAID` (`village_id`),
  CONSTRAINT `VI_R_V_VAID` FOREIGN KEY (`village_id`) REFERENCES `village` (`village_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `VI_R_U_UID` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `VI_R_V_VID` FOREIGN KEY (`view_id`) REFERENCES `views` (`view_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `view_image` */

insert  into `view_image`(`image_id`,`view_id`,`user_id`,`village_id`,`image_info`,`image_url`,`create_date`,`remark`) values (1,1,1,NULL,NULL,'./photoes/image_beixi.png','2015-12-27',NULL),(2,1,1,NULL,NULL,'./photoes/image_liangdu.png','2015-12-27',NULL),(3,1,1,NULL,NULL,'./photoes/image_chengnan.png','2015-12-27',NULL),(4,1,1,NULL,NULL,'./photoes/image_nanqu.png','2015-12-27',NULL),(5,2,1,NULL,NULL,'./photoes/image_maling.png','2015-12-27',NULL),(6,2,1,NULL,NULL,'./photoes/image_nanqu.png','2015-12-27',NULL),(7,2,1,NULL,NULL,'./photoes/image_nanqu.png','2015-12-27',NULL),(8,2,1,NULL,NULL,'./photoes/image_nanqu.png','2015-12-27',NULL);

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
  CONSTRAINT `VO_R_U_UID` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `VO_R_V_VID` FOREIGN KEY (`view_id`) REFERENCES `views` (`view_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `like_num` int(11) DEFAULT NULL COMMENT '点赞数',
  `child_sign` varchar(10) DEFAULT NULL COMMENT '是否有子景点',
  `up_view` int(11) DEFAULT NULL COMMENT '所属景区的Id',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`view_id`),
  KEY `V_R_V_VID` (`village_id`),
  CONSTRAINT `V_R_V_VID` FOREIGN KEY (`village_id`) REFERENCES `village` (`village_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `views` */

insert  into `views`(`view_id`,`village_id`,`view_name`,`view_address`,`view_guide`,`view_info`,`view_logo`,`open_time`,`ticket`,`phone`,`like_num`,`child_sign`,`up_view`,`create_date`,`remark`) values (1,1,'中山市树木园','广东省中山市南区外环路上','中山市树木园','位于中山市城区南郊，占地总面积1400多亩，目前投入2900万元的第一期建设工程已完成了树木标本收集92科1200多种，初步建成了木兰园系统分类区竹园等小园区。完成的基础设施包括15公里的登山路，8公里的环山路人工湖及休闲广场等等。二期工程将继续完善配套设施，总体规划建设桃花园山茶花园杜鹃园盆景园等专类园区。树木园共分科普区苗圃示范区生态林建设示范区科研管理区等4个功能区和19个小区。整个树木园主要以乡土树种主打。其中的乡土树种示范区，将广泛种植具有中山特色的树种，如土沉香四药门花黄桐水松等。目前，全国共有各类植物园，包括树木园标本园等100多个。但这些植物园的种类均不是以乡土树种为主，更不是以植物系统进化进行布局的，因此，中山树木园的建成将填补我国这方面的空白。从城轨北站坐038公交车至树木园站下车即可。','./photoes/1457247896023.jpg','6:00-22:00','免费','1',1,'1',1,'2015-12-27','1'),(2,1,'中山詹园','广东省中山市南区北台村105国道旁','广东省中山市南区北台村105国道旁','中山詹园，又名中山大宅门，坐落于中山市南区北台村，是目前岭南地区最大的私家古典园林。詹园占地百亩，是由詹园主人黄远新亲自设计(黄先生是中山人在澳门做生意)并从苏杭征调数百名园林能工巧匠历时五年共同建成的。詹园主人的初衷，出于为母亲建造一处淡雅精致颐养天年的静心居所。因此最早的詹园，即现在的詹家后院，是詹家上下尤其是詹老太的饮食起居之地詹老太搬离之后，里面的生活器具仍然保持着最初的模样，成为詹家家史的真实见证。','./photoes/1457247907671.jpg','08:00~17:30','￥60元','2',2,'2',2,'2015-12-27','AAAA景区'),(4,2,'阿三','啊是','f','古古怪怪古古怪怪个个个个个个个','./photoes/1457247919481.jpg','f','f','3',3,'3',3,'2016-01-10','f'),(5,1,'qwer','qwer','qwer','qwer','./photoes/1457247928503.jpg','qwer','qwer','4',4,'4',4,'2016-03-06','4'),(6,1,'asd','asd','asd','asd','./photoes/1457247941455.jpg','ad','ad','34',34,'34',34,'2016-03-06','34');

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
  `like_num` int(11) DEFAULT NULL COMMENT '点赞数',
  `create_date` date DEFAULT NULL COMMENT '创建记录时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`village_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `village` */

insert  into `village`(`village_id`,`village_name`,`village_address`,`village_info`,`village_logo`,`history_record`,`village_story`,`like_num`,`create_date`,`remark`) values (1,'南区','中山市南区','中山市是广东省著名的侨乡，在市区和各个乡镇留下了大量19—20世纪初古老的侨房和人文景观。这些建筑群是历史上中西方文化强烈碰撞的宝贵文化遗产，积淀着极为丰富的历史、文化、民族、地域、科学、情感的信息价值。','./photoes/1457247698864.jpg','q','q',NULL,'2015-12-27','q'),(2,'阿斯顿','阿斯顿','阿斯顿','./photoes/1457247706871.jpg','阿斯顿','阿斯顿',NULL,'2016-01-10','阿斯顿的'),(4,'顶顶顶','顶顶顶','顶顶顶a','./photoes/1457247715318.jpg','顶顶顶','顶顶顶',NULL,'2016-01-10','顶顶顶'),(5,'123','123','123','./photoes/1457247815341.jpg','123','123',NULL,'2016-03-06','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
