/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.16 : Database - ourblog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ourblog` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ourblog`;

/*Table structure for table `role_action` */

DROP TABLE IF EXISTS `role_action`;

CREATE TABLE `role_action` (
  `role_id` int(2) NOT NULL,
  `action_id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `role_action` */

insert  into `role_action`(`role_id`,`action_id`) values (2,1),(2,2),(2,3),(1,1),(1,2);

/*Table structure for table `t_action` */

DROP TABLE IF EXISTS `t_action`;

CREATE TABLE `t_action` (
  `action_id` int(2) NOT NULL AUTO_INCREMENT,
  `action_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_action` */

insert  into `t_action`(`action_id`,`action_name`) values (1,'read'),(2,'update'),(3,'administrate');

/*Table structure for table `t_article` */

DROP TABLE IF EXISTS `t_article`;

CREATE TABLE `t_article` (
  `article_id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 NOT NULL,
  `synopsis` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `star_num` int(10) DEFAULT '0',
  `praise_num` int(10) DEFAULT '0',
  `tread_num` int(10) DEFAULT '0',
  `hot_index` int(10) DEFAULT '0',
  `is_stick` tinyint(1) DEFAULT '0',
  `is_ban` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_article` */

insert  into `t_article`(`article_id`,`username`,`title`,`synopsis`,`content`,`update_time`,`star_num`,`praise_num`,`tread_num`,`hot_index`,`is_stick`,`is_ban`) values (12,'aaa','第一章 罗峰',' 天空湛蓝，就仿佛一块巨大的蓝色翡翠，盛夏的太阳仿佛一个大火球，高高悬挂在这块巨大翡翠之中，看太阳位置，估计也就下午三点左右。 宜安区第三高中。 “叮叮叮……”随着响亮的铃声响彻整个校园，顿时整个校园','&nbsp;天空湛蓝，就仿佛一块巨大的蓝色翡翠，盛夏的太阳仿佛一个大火球，高高悬挂在这块巨大翡翠之中，看太阳位置，估计也就下午三点左右。\n\n    宜安区第三高中。\n\n    “叮叮叮……”随着响亮的铃声响彻整个校园，顿时整个校园中响起一片喧哗声，各栋教学楼中便鱼贯涌出了大量的学生，三五成群说笑着朝校门口走去。\n\n    “罗峰师兄！罗峰师兄！”一道粗厚的声音响起。\n\n    “阿峰，有人喊你。”\n\n    在学生人群当中，和同学一道走着的拿着书籍的青年，穿着普通蓝色运动服，身高大概一米七五，显得比较精瘦。此时他疑惑转头看去，喊他的是一名男生，身高大概有一米九，长的虎背熊腰，手臂更是粗壮的惊人。\n\n    “你是？”罗峰疑惑看着来人，自己似乎不认识眼前人。\n\n    这二人，一个壮硕的好似一头黑熊。而‘罗峰师兄’和普通人一般。\n\n    论身高……\n\n    这二人相差极大。可是这名虎背熊腰的男生，却显得有些拘谨，他仔细看了看他崇拜的‘罗峰师兄’，暗道：“看样子，传言没错，罗峰师兄，是挺好说话的。”\n\n    “罗峰师兄，我，我有事想请罗峰师兄帮忙。”壮硕男忐忑道。\n\n    “什么事？”罗峰一笑，说道。\n\n    “我练拳的时候，出拳发劲，总是感觉不对，不知道师兄你有没有时间指点一下。”这壮硕男生，连说道，“按照武馆老师说的，以我的力气，按道理一拳可以打出强上50％的力道。可是，我出拳发劲，总是达不到那么高。”\n\n    壮硕男生期盼看着罗峰。\n\n    “哦，是这样……”罗峰略微停顿一下，点点头，“这样吧，这个星期的星期天下午，在武馆的时候你找我。”\n\n    “谢师兄，谢师兄了。”这壮硕的男生连感谢道。\n\n    罗峰笑了笑，就和自己的同学一道离开。\n\n    目送着罗峰离去，壮硕男生露出兴奋之色，猛地一握拳，手臂上青筋暴突，兴奋低吼一声：“成功！”\n\n    “罗峰师兄，竟然就这么容易答应了？”一名穿着校服的男生惊讶道。\n\n    “传言果然没错，罗峰师兄是很好说话的，人也很好。”壮硕男生咧嘴笑道。\n\n    “可是……不对啊，我们第三高中，五千名学生中，获得‘武馆高级学员’称号的，一共才三个。三名高级学员当中，另外两个‘张昊白’和‘柳婷’可都是很傲的，根本是不肯浪费时间指点我们的。”校服男生疑惑道，“罗峰师兄脾气竟然这么好？”\n\n    现如今，整个世界上，各个国家地区，几乎每一个高中生，在接受文化教育之外，也会加入武馆，开发人体潜力。\n\n    宜安区第三高中，三个年级，一共近五千名高中生。\n\n    绝大多数，都是武馆的初级学员！只有极少数，是‘中级学员’。能获得‘高级学员’资格的，一共才三个人！\n\n    “耳听为虚，眼见为实。哼哼，看到了吧？罗峰师兄和另外两个可不一样。”壮硕男生撇嘴道，“那个张昊白和柳婷，家里都是富豪。从小家里花了大量金钱去培养，才能有这么强。至于罗峰师兄，和他们可不同！”\n\n    校服男生也点头：“我也听说了，罗峰师兄和我们一样，家里经济条件一般，住的还是廉租房呢。”\n\n    “对，罗峰师兄，能走到今天这一步，可完全是刻苦修炼。靠自己一拳一脚练出来的。哪像张昊白他们两个。”壮硕男生握紧拳头，深吸一口气，“我的目标就是罗峰师兄，我一定要在四年内，也就是大学毕业前，通过武馆考核，得到武馆的‘高级学员’称号！”\n\n    ……\n\n    此刻，他们谈论的那位罗峰师兄，正和一名运动服男生顺着学生人流，朝第三高中大门走去。\n\n    “阿峰，啧啧，刚才那个请你指点‘出拳发劲’的大块头男生走的时候，还和他同学夸你呢。”运动服男生，不由笑了起来，“夸你人好，夸你好说话。”\n\n    罗峰笑了笑：“怎么，魏文，你嫉妒了？”&nbsp;&nbsp;<p></p>','2019-10-19 15:05:53',0,0,0,0,0,0),(13,'aaa','测试1',' 天空湛蓝，就仿佛一块巨大的蓝色翡翠，盛夏的太阳仿佛一个大火球，高高悬挂在这块巨大翡翠之中，看太阳位置，估计也就下午三点左右。 宜安区第三高中。 “叮叮叮……”随着响亮的铃声响彻整个校园，顿时整个校园中响起一片喧哗声，各栋教学楼中便鱼贯涌出了大量的学生，三五成群说笑着朝校门口走去。 “罗峰师兄！罗峰师兄！”','<p>&nbsp;天空湛蓝，就仿佛一块巨大的蓝色翡翠，盛夏的太阳仿佛一个大火球，高高悬挂在这块巨大翡翠之中，看太阳位置，估计也就下午三点左右。 宜安区第三高中。 “叮叮叮……”随着响亮的铃声响彻整个校园，顿时整个校园中响起一片喧哗声，各栋教学楼中便鱼贯涌出了大量的学生，三五成群说笑着朝校门口走去。 “罗峰师兄！罗峰师兄！”<img src=\"http://localhost/getImage?imageName=907ed2e5-9319-41c3-9ea2-a0fd1145f167.jpg\" style=\"max-width:30%;\"></p><p></p>','2019-10-19 15:08:34',0,0,0,0,0,0),(14,'测试用户1','哈哈哈','这是几楼哦了外头拒绝了5可口可乐了看看可口可乐了了','哈咯您呢6:6:龙门来来来<p></p>','2019-10-19 17:16:53',0,0,0,0,0,1),(19,'aaa','a5555','qqswewqds','ewqeqwewqe<p></p>','2019-10-19 22:05:15',0,0,0,0,0,1),(20,'aaa','15565645','44444','65654498<p></p>','2019-10-19 22:05:57',0,0,0,0,0,1),(21,'aaa','wsdd','sadda','dada<img src=\"/getImage?imageName=e20541ab0ce44433b2b3056d5f1ee43f.jpg\" style=\"max-width:100%;\"><p></p>','2019-11-14 17:32:14',0,0,0,0,0,1),(23,'aaa','第一章 小二上酒','北凉王府龙盘虎踞于清凉山，千门万户，极土木之盛。\n\n    作为王朝硕果仅存的异姓王，在庙堂和江湖都是毁誉参半的北凉王徐骁作为一名功勋武臣，可谓得到了皇帝宝座以外所有的东西，在西北三州，他就是当之无愧的主宰，只手遮天，翻云覆雨','（每一个钟头上传一章，直到传完二十章！红票和收藏别忘了～）<br><br>&nbsp;&nbsp;&nbsp;&nbsp;北凉王府龙盘虎踞于清凉山，千门万户，极土木之盛。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;作为王朝硕果仅存的异姓王，在庙堂和江湖都是毁誉参半的北凉王徐骁作为一名功勋武臣，可谓得到了皇帝宝座以外所有的东西，在西北三州，他就是当之无愧的主宰，只手遮天，翻云覆雨。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;难怪朝廷中与这位异姓王政见不合的大人们私下都会文绉绉骂一声徐蛮子，而一些居心叵测的，更诛心地丢了顶“二皇帝”的帽子。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;今天王府很热闹，位高权重的北凉王亲自开了中门，摆开辉煌仪仗，迎接一位仙风道骨的老者，府中下人们只听说是来自道教圣地龙虎山的神仙，相中了痴痴傻傻的小王爷，要收作闭关弟子，这可是天大的福缘，北凉王府都解释成傻人有傻福。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;可不是，小王爷自打出生起便没哭过，读书识字一窍不通，六岁才会说话，名字倒是威武气派，徐龙象，传闻还是龙虎山的老神仙当年给取的，说好十二年后再来收徒，这不就如约而至了。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;王府内一处院落，龙虎山师祖一级的道门老祖宗捻着一缕雪白胡须，眉头紧皱，背负一柄不常见的小钟馗式桃木剑，配合他的相貌，确实当得出尘二字，谁看都要由衷赞一声世外高人呐。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;但此番收徒显然遇到了不小的阻碍，倒不是王府方面有异议，而是他的未来徒弟犟脾气上来了，蹲在一株梨树下，用屁股对付他这个天下道统中论地位能排前三甲的便宜师傅，至于武功嘛，咳咳，前三十总该有的吧。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;连堂堂大柱国北凉王都得蹲在那里好言相劝，循循善诱里透着股诱拐，“儿子，去龙虎山学成一身本事，以后谁再敢说你傻，你就揍他，三品以下的文官武将，打死都不怕，爹给你撑腰。”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;“儿啊，你力气大，不学武捞个天下十大高手当当就太可惜了。学成归来，爹就给你一个上骑都尉当当，骑五花马，披重甲，多气派。”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;小王爷完全不搭理，死死盯着地面，瞧得津津有味。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;“黄蛮儿，你不是喜欢吃糖葫芦吗，那龙虎山遍地的野山楂，你随便摘随便啃。赵天师，是不是？”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;老神仙硬挤出一抹笑容，连连点头称是。收徒弟收到这份上，也忒寒碜了，说出去还不被全天下笑话。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;可哪怕位于堂堂超一品官职、在十二郡一言九鼎的大柱国口干舌燥了，少年还是没什么反应，估计是不耐烦了嫌老爹说得呱噪，翘起屁股，噗一下来了个响屁，还不忘扭头对老爹咧嘴一笑。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;把北凉王给气得抬手作势要打，可抬着手僵持一会儿，就作罢。一来是不舍得打，二来是打了没意义。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;这儿子可真对得起名字，徐龙象，取自“水行中龙力最大，陆行中象力第一，威猛如金刚，是谓龙象”，别看绰号黄蛮儿的傻儿子憨憨笨笨，至今斗大字不识，皮肤病态的暗黄，身形比较同龄人都要瘦弱，但这气力，却是一等一骇人。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;徐骁十岁从军杀人，从东北锦州杀匈奴到南部灭大小六国屠七十余城再到西南镇压蛮夷十六族，什么样膂力惊人的猛将没有见过，但如小儿子这般可天生铜筋铁骨力拔山河的，真没有。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;徐骁心中轻轻叹息，黄蛮儿若能稍稍聪慧一些，心窍多开一二，将来必定可以成为陷阵第一的无双猛将啊。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;他缓缓起身转头朝龙虎山辈分极高的道士尴尬一笑，后者眼神示意不打紧，只是心中难免悲凉，收个徒弟收到这份上，也忒不是个事儿了，一旦传出去还不得被天下人笑话，这张老脸就甭想在龙虎山那一大帮徒子徒孙面前摆放喽。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;束手无策的北凉王心生一计，嘿嘿道：“黄蛮儿，你哥游行归来，看时辰也约莫进城了，你不出去看看？”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;小王爷猛地抬头，表情千年不变的呆板僵硬，但寻常木讷无神的眼眸却爆绽出罕见光彩，很刺人，拉住老爹的手就往外冲。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;可惜这北凉王府出了名百廊回转曲径千折，否则也容不下一座饱受朝廷清官士大夫们诟病的“听潮亭”，手被儿子握得生疼的徐骁不得不数次提醒走错路了，足足走了一炷香时间，这才来到府外。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;父子和老神仙身后，跟着一帮扛着大小箱子的奴仆，都是准备带往龙虎山的东西，北凉王富可敌国，对儿女也是素来宠溺，见不得他们吃一点苦受一点委屈。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;到了府外，小王爷一看到街道空荡，哪里有哥哥的身影，先是失望，继而愤怒，沉沉嘶吼一声，沙哑而暴躁，起先想对徐骁发火，但笨归笨，起码还知道这位是父亲，否则徐骁的下场恐怕就得像前不久秋狩里倒霉遇到徐龙象的黑罴了，被单枪匹马的十二岁少年生生撕成两半。他怒瞪了一眼心虚的老爹，掉头就走。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;不希望功亏一篑的徐骁无奈丢给老神仙一个眼神。龙虎山真人微微一笑，伸出枯竹一般的手臂，但仅是两指搭住了小王爷的手腕，轻声慈祥道：“徐龙象，莫要浪费了你百年难遇的天赋异禀，随我去龙虎山，最多十年，你便可下山立功立德。”<br><br>&nbsp;&nbsp;&nbsp;&nbsp;少年也不废话，哼了一声，继续前往，但玄妙古怪的是他发现自己没能挣脱老道士看似云淡风轻的束缚，那踏出去悬空的一步如何都没能落地。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，以至于他都不敢多安排仆人女婢给儿子，生怕一个不小心就捏断了胳膊腿脚，这些年院中被坐坏拍烂的桌椅不计其数，也亏得北凉王府家底厚实，寻常殷实人家早就破产了。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;小王爷愣了一下，随即发火，轻喝一声，硬是带着老神仙往前走了一步，两步，三步。头顶黄冠、身披道袍的真人只是微微咦了一声，不怒反喜，悄悄加重了几分力道，阻止了少年的继续前行。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;如此一来，徐龙象是真怒了，面容狰狞如同一只野兽，伸出空闲的一只手，双手握住老道士的手臂，双脚一沉，咔嚓，在白玉地板上踩出两个坑，一甩，就将老道士整个人给丢掷了出去。<p></p>','2019-10-20 00:50:53',0,0,0,0,0,0),(27,'测试用户1','里咯摸摸','哈哈哈','尤克里里哦哦哦里咯摸摸爸爸啊<p></p>','2019-10-24 01:10:05',0,0,0,0,0,1),(29,'测试用户1','手机写文章','哈喽咯嗯额','老嬷嬷<p></p>','2019-11-01 21:58:49',0,0,0,0,0,1),(30,'administrator','测试图片','啪啪啪啪啪1','图片：<p></p><p><img src=\"/getImage?imageName=e183d02213ec49718c52cbd3677848e5.jpg\" style=\"max-width:100%;\"><br></p>','2019-11-08 22:05:33',0,0,0,0,0,0),(31,'administrator','测试草稿','测试草稿','<p><strong></strong>测试草稿</p>','2019-11-09 17:24:51',0,0,0,0,0,2),(34,'aaa','顶顶顶顶','顶顶顶顶','<p>啵啵啵啵啵啵宝宝</p><p></p>','2019-11-14 17:39:47',0,0,0,0,0,2),(35,'admin','管理员账号','提供一个测试用管理员账号，请不要捣乱！','<p>账号：admin</p><p>密码：123456</p><p>提供一个测试用管理员账号，请不要捣乱！</p>','2019-11-14 19:50:34',2,2,0,0,1,0);

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `comment_id` int(10) NOT NULL AUTO_INCREMENT,
  `speaker` varchar(20) CHARACTER SET utf8 NOT NULL,
  `listener` varchar(20) CHARACTER SET utf8 NOT NULL,
  `content` varchar(500) CHARACTER SET utf8 NOT NULL,
  `create_time` timestamp NOT NULL,
  `article_id` int(10) NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_comment` */

insert  into `t_comment`(`comment_id`,`speaker`,`listener`,`content`,`create_time`,`article_id`) values (5,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，以至于他都不敢多安排仆人女婢给儿子，生怕一个不小心就捏断了胳膊腿脚，这些年院中被坐坏拍烂的桌椅不计其数，也亏得北凉王府家底厚实，寻常殷实人家早就破产了。','2019-10-26 00:10:07',23),(6,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，以至于他都不敢多安排仆人女婢给儿子，生怕一个不小心就捏断了胳膊腿脚，这些年院中被坐坏拍烂的桌椅不计其数，也亏得北凉王府家底厚实，寻常殷实人家早就破产了。','2019-10-26 00:10:12',23),(7,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，以至于他都不敢多安排仆人女婢给儿子，生怕一个不小心就捏断了胳膊腿脚，这些年院中被坐坏拍烂的桌椅不计其数，也亏得北凉王府家底厚实，寻常殷实人家早就破产了。','2019-10-26 00:10:15',23),(8,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，以至于他都不敢多安排仆人女婢给儿子，生怕一个不小心就捏断了胳膊腿脚，这些年院中被坐坏拍烂的桌椅不计其数，也亏得北凉王府家底厚实，寻常殷实人家早就破产了。','2019-10-26 00:10:18',23),(9,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，以至于他都不敢多安排仆人女婢给儿子，生怕一个不小心就捏断了胳膊腿脚，这些年院中被坐坏拍烂的桌椅不计其数，也亏得北凉王府家底厚实，寻常殷实人家早就破产了。','2019-10-26 00:10:20',23),(10,'administrator','administrator  ','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，以至于他都不敢多安排仆人女婢给儿子，生怕一个不小心就捏断了胳膊腿脚，这些年院中被坐坏拍烂的桌椅不计其数，也亏得北凉王府家底厚实，寻常殷实人家早就破产了。','2019-10-26 00:10:29',23),(11,'administrator','administrator  ','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，以至于他都不敢多安排仆人女婢给儿子，生怕一个不小心就捏断了胳膊腿脚，这些年院中被坐坏拍烂的桌椅不计其数，也亏得北凉王府家底厚实，寻常殷实人家早就破产了。','2019-10-26 00:10:56',23),(12,'administrator',' ','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，以至于他都不敢多安排仆人女婢给儿子，生怕一个不小心就捏断了胳膊腿脚，这些年院中被坐坏拍烂的桌椅不计其数，也亏得北凉王府家底厚实，寻常殷实人家早就破产了。','2019-10-26 00:11:01',23),(13,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:36',23),(14,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:37',23),(15,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:38',23),(16,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:38',23),(17,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:38',23),(18,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:38',23),(19,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:39',23),(20,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:40',23),(21,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:40',23),(22,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:40',23),(23,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:41',23),(24,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:41',23),(25,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:41',23),(26,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:42',23),(27,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:42',23),(28,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:42',23),(29,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:43',23),(30,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:43',23),(31,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:43',23),(32,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:43',23),(33,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:44',23),(34,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:44',23),(35,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:44',23),(36,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:44',23),(37,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很，','2019-10-26 00:46:45',23),(38,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:07',23),(39,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:08',23),(40,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:08',23),(41,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:08',23),(42,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:08',23),(43,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:08',23),(44,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:09',23),(45,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:09',23),(46,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:09',23),(47,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:09',23),(48,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:09',23),(49,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:10',23),(50,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:10',23),(51,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:10',23),(52,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:11',23),(53,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:11',23),(54,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:11',23),(55,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:11',23),(56,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:12',23),(57,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:12',23),(58,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:12',23),(59,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:13',23),(60,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:13',23),(61,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:13',23),(62,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:14',23),(63,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:14',23),(64,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:14',23),(65,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:15',23),(66,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:15',23),(67,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:15',23),(68,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:15',23),(69,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:16',23),(70,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:16',23),(71,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:16',23),(72,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:16',23),(73,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:17',23),(74,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:17',23),(75,'administrator','aaa','北凉王如释重负，这位道统辈分高到离谱的上人果真还是有些本事的，知子莫若父，徐骁哪里不知道小儿子的力道，霸气得很','2019-10-26 00:47:17',23),(76,'一位没有注册的游客','aaa','的撒按时 阿松大','2019-10-26 01:07:52',23),(77,'一位没有注册的游客','aaa','的撒按时 阿松大','2019-10-26 01:07:53',23),(78,'administrator','administrator  ','mkkmkjjjjjj','2019-10-27 15:03:43',23),(79,'administrator','administrator  ','4564','2019-10-27 15:04:12',23),(80,'administrator','aaa','454654','2019-10-27 15:06:15',23),(81,'administrator',' ','56654','2019-10-27 15:06:31',23),(82,'administrator','administrator  ','554\n','2019-10-27 15:08:39',23),(83,'administrator','你自己 ','54654','2019-10-27 15:08:46',23),(84,'administrator','administrator  ','545646','2019-10-27 15:10:36',23),(85,'administrator','您自己 ','84854','2019-10-27 15:10:42',23),(86,'administrator','aaa','的撒大取得阿斯顿去','2019-10-28 15:21:48',1),(87,'administrator','aaa','大撒大撒的','2019-10-28 15:22:11',1),(88,'administrator','aaa','大撒大撒的','2019-10-28 15:22:12',1),(89,'administrator','administrator  ','5465\n','2019-10-28 16:29:04',23),(90,'administrator','administrator  ','我去饿我去','2019-10-28 16:54:33',23),(91,'aaa','administrator','测试成功','2019-10-31 23:44:45',28),(92,'一位没有注册的游客','administrator','测试成功','2019-10-31 23:45:12',28),(93,'测试用户1','aaa','哈哈哈','2019-11-01 21:49:32',12),(94,'测试用户1','测试用户1  ','歌碟呵呵额呵呵','2019-11-01 21:49:54',12),(95,'测试用户1','aaa','爸爸啊','2019-11-01 21:50:10',12),(96,'测试用户1','aaa','爸爸啊','2019-11-01 21:50:12',12),(97,'测试用户1','aaa','爸爸啊','2019-11-01 21:50:13',12),(98,'测试用户1','aaa','爸爸啊','2019-11-01 21:50:15',12),(99,'测试用户1','aaa','eryh','2019-11-01 21:52:25',12),(100,'admin','admin','测试消息回复','2019-11-14 21:07:50',35),(101,'aaa','admin','测试回复','2019-11-14 21:08:59',35),(102,'aaa','admin','可以可以','2019-11-14 22:20:07',35);

/*Table structure for table `t_icon` */

DROP TABLE IF EXISTS `t_icon`;

CREATE TABLE `t_icon` (
  `icon_id` int(10) NOT NULL AUTO_INCREMENT,
  `article_id` int(10) NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  `type` int(1) NOT NULL COMMENT '1:star;2:praise;3:tread',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`icon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_icon` */

insert  into `t_icon`(`icon_id`,`article_id`,`username`,`type`,`create_time`) values (1,1,'aa',1,'2019-11-09 21:11:09'),(2,2,'administrator',1,'2019-11-09 22:10:53'),(3,2,'administrator',2,'2019-11-09 22:10:56'),(4,2,'administrator',3,'2019-11-09 22:10:58'),(5,35,'admin',1,'2019-11-14 17:57:15'),(6,35,'admin',2,'2019-11-14 17:57:17'),(7,35,'aaa',1,'2019-11-14 21:08:59'),(8,35,'aaa',2,'2019-11-14 21:09:02');

/*Table structure for table `t_login` */

DROP TABLE IF EXISTS `t_login`;

CREATE TABLE `t_login` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) CHARACTER SET utf8 NOT NULL,
  `ip` varchar(20) CHARACTER SET utf8 NOT NULL,
  `location` varchar(20) CHARACTER SET utf8 NOT NULL,
  `login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_login` */

insert  into `t_login`(`id`,`user_name`,`ip`,`location`,`login_time`) values (1,'administrator','0:0:0:0:0:0:0:1','[]-[]','2019-11-01 21:46:29'),(2,'测试用户1','192.168.1.240','局域网-[]','2019-11-01 21:48:24'),(3,'测试用户1','192.168.1.240','局域网-[]','2019-11-01 21:58:15'),(4,'aaa','127.0.0.1','[]-[]','2019-11-02 00:20:44'),(5,'administrator','0:0:0:0:0:0:0:1','[]-[]','2019-11-04 16:20:22'),(6,'administrator','192.168.1.240','局域网-[]','2019-11-05 22:32:06'),(7,'aaa','0:0:0:0:0:0:0:1','[]-[]','2019-11-09 15:28:35'),(8,'administrator','0:0:0:0:0:0:0:1','[]-[]','2019-11-12 18:10:31'),(9,'administrator','0:0:0:0:0:0:0:1','[]-[]','2019-11-12 18:13:11'),(10,'administrator','0:0:0:0:0:0:0:1','[]-[]','2019-11-12 18:16:29'),(11,'administrator','0:0:0:0:0:0:0:1','[]-[]','2019-11-12 18:18:29'),(12,'administrator','0:0:0:0:0:0:0:1','[]-[]','2019-11-12 18:26:47'),(13,'aaa','0:0:0:0:0:0:0:1','[]-[]','2019-11-12 22:27:59'),(14,'administrator','0:0:0:0:0:0:0:1','[]-[]','2019-11-12 22:28:56'),(15,'administrator','0:0:0:0:0:0:0:1','[]-[]','2019-11-12 22:29:04'),(16,'aaa','0:0:0:0:0:0:0:1','[]-[]','2019-11-12 22:33:30'),(17,'administrator','0:0:0:0:0:0:0:1','[]-[]','2019-11-12 22:34:34'),(18,'admin','0:0:0:0:0:0:0:1','[]-[]','2019-11-14 14:12:01'),(19,'admin','0:0:0:0:0:0:0:1','[]-[]','2019-11-14 14:14:01'),(20,'administrator','0:0:0:0:0:0:0:1','[]-[]','2019-11-14 14:17:41'),(21,'aaa','0:0:0:0:0:0:0:1','[]-[]','2019-11-14 16:37:23'),(22,'admin','0:0:0:0:0:0:0:1','[]-[]','2019-11-14 17:54:16'),(23,'asas','0:0:0:0:0:0:0:1','[]-[]','2019-11-14 22:54:39');

/*Table structure for table `t_msg` */

DROP TABLE IF EXISTS `t_msg`;

CREATE TABLE `t_msg` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `listener` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` varchar(400) CHARACTER SET utf8 NOT NULL,
  `isread` tinyint(1) NOT NULL DEFAULT '0',
  `type` tinyint(2) NOT NULL COMMENT '1.系统2.回复3.私信',
  `sendby` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_msg` */

insert  into `t_msg`(`id`,`listener`,`create_time`,`content`,`isread`,`type`,`sendby`) values (11,'administrator','2019-11-12 22:46:52','nihhh',0,3,'aaa'),(12,'administrator','2019-11-14 17:53:01','你是煞笔',0,3,'aaa'),(13,'admin','2019-11-14 20:03:53','管理员封禁了你的文章:管理员账号!',1,1,'admin'),(14,'admin','2019-11-14 20:36:47','管理员解封你的文章:管理员账号!',1,1,'admin'),(15,'admin','2019-11-14 20:36:52','管理员置顶了你的文章:管理员账号!',1,1,'admin'),(16,'admin','2019-11-14 20:54:13','管理员封禁了你的文章:管理员账号!',1,1,'admin'),(17,'admin','2019-11-14 20:54:17','管理员解封你的文章:管理员账号!',1,1,'admin'),(18,'admin','2019-11-14 20:54:24','管理员置顶了你的文章:管理员账号!',1,1,'admin'),(19,'admin','2019-11-14 21:08:59','测试回复',1,2,'aaa'),(20,'admin','2019-11-14 22:12:17','你好啊',1,3,'aaa'),(21,'admin','2019-11-14 22:20:07','可以可以',0,2,'aaa'),(22,'麻花疼','2019-11-14 22:48:30','你已注册成功，欢迎你的加入！',0,1,'系统'),(23,'asas','2019-11-14 22:54:08','你已注册成功，欢迎你的加入！',1,1,'系统');

/*Table structure for table `t_pic` */

DROP TABLE IF EXISTS `t_pic`;

CREATE TABLE `t_pic` (
  `src` varchar(300) NOT NULL,
  `md5` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`md5`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_pic` */

insert  into `t_pic`(`src`,`md5`) values ('/getImage?imageName=99df1197a99a45f7ae82262957471a4b.jpg','3d4fb062eddd4ca0fa961aba519eaf8d'),('/getImage?imageName=5dfc5fe6f4c1430b96604462111a73f4.jpg','5c88facd9684c83e976f4bcd9d013488'),('/getImage?imageName=e183d02213ec49718c52cbd3677848e5.jpg','6372a64e0de43f877d2cd4d37946db21'),('/getImage?imageName=bce1c091b8f444d19333474804415515.jpg','80d15acd36abed63c045eb71082858da'),('/getImage?imageName=b82a0b91657140f38dbca6606c2e75d6.jpg','9042e79fd5c98363c22dd81bbd1100d7'),('/getImage?imageName=7ab13a83dd8c43e68ce19c5d763b6358.jpg','a5eae083dd687ab8f498704ab4f8fbd1'),('/getImage?imageName=e20541ab0ce44433b2b3056d5f1ee43f.jpg','b931f5510672157165a747a99e2dfe59'),('/getImage?imageName=959508296b0240b98dab574698270c7d.jpg','c638c6931371181481750fa4a126d73c'),('/getImage?imageName=a92ca0df7104422c814ea1b837cd1cbd.jpg','dc2473270711bdeddd092491ea32eff5'),('/getImage?imageName=9a0a0a61f2444638a1779b1de3cd3dbc.jpg','e181ba5e55dddda18b9ac5ee01f59449');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `role_id` int(2) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_role` */

insert  into `t_role`(`role_id`,`role_name`) values (1,'user'),(2,'admin');

/*Table structure for table `t_rotation` */

DROP TABLE IF EXISTS `t_rotation`;

CREATE TABLE `t_rotation` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `image_src` varchar(200) CHARACTER SET utf8 NOT NULL,
  `hyperlink` varchar(200) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_rotation` */

insert  into `t_rotation`(`id`,`image_src`,`hyperlink`) values (4,'http://localhost:8080/getImage?imageName=bce1c091b8f444d19333474804415515.jpg','https://github.com/chenyang195/ourBlog'),(14,'http://localhost:8080/getImage?imageName=a92ca0df7104422c814ea1b837cd1cbd.jpg','http://localhost:8080/showArticle?articleId=35');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `username` varchar(30) CHARACTER SET utf8 NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 NOT NULL,
  `image_url` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `recent_location` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `recent_login_time` datetime DEFAULT NULL,
  `synopsis` varchar(500) CHARACTER SET utf8 DEFAULT '该用户很懒，没有设置简介...',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`create_time`,`username`,`password`,`image_url`,`update_time`,`recent_location`,`recent_login_time`,`synopsis`) values (29,'2019-10-07 17:22:10','aaa','e97ae203e788e10b215184a0ea10ebf7','picDB/image/default.jpeg',NULL,'[]-[]','2019-11-14 16:37:23','该用户很懒，没有设置简介...'),(30,'2019-10-07 19:33:59','administrator','8f6c038de11afe46edb69ab90472a2e2','picDB/image/default.jpeg',NULL,'[]-[]','2019-11-14 14:17:41','该用户很懒，没有设置简介...'),(31,'2019-10-10 20:18:22','chenyang','ac5d79d8498e54668f6e6b02a6dc389b','picDB/image/default.jpeg',NULL,'[]-[]','2019-10-10 20:32:15','该用户很懒，没有设置简介...'),(32,'2019-10-19 17:12:08','测试用户1','3dc3a7e4872afdfb47dde5c48a1f1eff','picDB/image/default.jpeg',NULL,'局域网-[]','2019-11-01 21:58:15','该用户很懒，没有设置简介...'),(33,NULL,'一位没有注册的游客','qewqe','picDB/image/default.jpeg',NULL,NULL,NULL,'该用户很懒，没有设置简介...'),(34,'2019-11-14 14:11:46','admin','038bdaf98f2037b31f1e75b5b4c9b26e','C:/Users/13663/Desktop/git/ourBlog/ourBlog/picDB/image/default.jpeg',NULL,'[]-[]','2019-11-14 17:54:16','该用户很懒，没有设置简介...'),(35,'2019-11-14 22:25:20','zzz','2a78d2e7c70a3154c74502c999d98768','C:/Users/13663/Desktop/git/ourBlog/ourBlog/picDB/image/default.jpeg',NULL,NULL,NULL,'该用户很懒，没有设置简介...'),(36,'2019-11-14 22:28:12','ssss','727f016511d1ca111dfabf392f348880','C:/Users/13663/Desktop/git/ourBlog/ourBlog/picDB/image/default.jpeg',NULL,NULL,NULL,'该用户很懒，没有设置简介...'),(37,'2019-11-14 22:48:29','麻花疼','15dd69c15f05f8aa91a43f65e55386ec','C:/Users/13663/Desktop/git/ourBlog/ourBlog/picDB/image/default.jpeg',NULL,NULL,NULL,'该用户很懒，没有设置简介...'),(38,'2019-11-14 22:54:07','asas','ea172cc24142cd5b2a7daa462a109a8e','C:/Users/13663/Desktop/git/ourBlog/ourBlog/picDB/image/default.jpeg',NULL,'[]-[]','2019-11-14 22:54:39','该用户很懒，没有设置简介...');

/*Table structure for table `user_location` */

DROP TABLE IF EXISTS `user_location`;

CREATE TABLE `user_location` (
  `locid` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `location` varchar(20) CHARACTER SET utf8 NOT NULL,
  `login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`locid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_location` */

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(10) NOT NULL,
  `role_id` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values (29,1),(30,1),(30,2),(31,1),(32,1),(34,1),(34,2),(35,1),(36,1),(37,1),(38,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
