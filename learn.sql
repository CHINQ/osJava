/*
Navicat MySQL Data Transfer

Source Server         : localhost_3300
Source Server Version : 50621
Source Host           : localhost:3300
Source Database       : learn

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-04-30 17:28:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bid` int(11) NOT NULL AUTO_INCREMENT COMMENT '资料编号',
  `bname` varchar(100) DEFAULT NULL COMMENT '资料名称',
  `btext` varchar(200) DEFAULT NULL COMMENT '资料简介',
  `btime` datetime DEFAULT NULL COMMENT '上传时间',
  `bimage` varchar(50) DEFAULT NULL COMMENT '图片',
  `baddress` varchar(50) DEFAULT NULL COMMENT '链接地址',
  `uid` varchar(50) DEFAULT NULL COMMENT '资料上传人',
  PRIMARY KEY (`bid`),
  KEY `fk_books_users` (`uid`),
  CONSTRAINT `books_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of books
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `lid` int(11) DEFAULT NULL COMMENT '讲师编号--外键--讲师表lectors',
  `ctime` datetime DEFAULT NULL COMMENT '开课时间',
  `cplace` varchar(100) DEFAULT NULL COMMENT '上课地点',
  `cstate` int(11) DEFAULT NULL COMMENT '状态--是否被选中',
  PRIMARY KEY (`cid`),
  KEY `fk_course_lector` (`lid`),
  CONSTRAINT `fk_course_lector` FOREIGN KEY (`lid`) REFERENCES `lector` (`lid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '1', '2014-11-06 09:00:00', '101教室', '0');

-- ----------------------------
-- Table structure for exammanage
-- ----------------------------
DROP TABLE IF EXISTS `exammanage`;
CREATE TABLE `exammanage` (
  `emid` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) DEFAULT NULL,
  `emtime` datetime DEFAULT NULL,
  `emduration` int(11) DEFAULT NULL,
  `emfull` float DEFAULT NULL,
  `emstate` int(11) DEFAULT NULL,
  `emoverdue` int(11) DEFAULT NULL,
  PRIMARY KEY (`emid`),
  KEY `fk_lector_exam` (`lid`),
  CONSTRAINT `fk_lector_exam` FOREIGN KEY (`lid`) REFERENCES `lector` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of exammanage
-- ----------------------------
INSERT INTO `exammanage` VALUES ('1', '1', '2014-12-08 00:00:00', '90', '100', '0', '0');
INSERT INTO `exammanage` VALUES ('2', '2', '2020-12-12 00:00:00', '120', '100', '0', '1');
INSERT INTO `exammanage` VALUES ('3', '1', '2014-12-12 12:12:12', '120', '100', '1', '0');

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '学友编号',
  `ubid` varchar(50) DEFAULT NULL COMMENT '本人编号==外键==用户表--用户编号',
  `uid` varchar(50) DEFAULT NULL COMMENT '用户编号--外键--用户表users',
  PRIMARY KEY (`fid`),
  KEY `fk_friend_users` (`uid`),
  KEY `fk2_friend_users` (`ubid`),
  CONSTRAINT `fk2_friend_users` FOREIGN KEY (`ubid`) REFERENCES `users` (`uid`) ON DELETE CASCADE,
  CONSTRAINT `fk_friend_users` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('3', 'user1', 'user2');
INSERT INTO `friend` VALUES ('4', null, null);
INSERT INTO `friend` VALUES ('5', null, null);

-- ----------------------------
-- Table structure for lector
-- ----------------------------
DROP TABLE IF EXISTS `lector`;
CREATE TABLE `lector` (
  `lid` int(11) NOT NULL AUTO_INCREMENT COMMENT '讲师编号',
  `uid` varchar(50) DEFAULT NULL COMMENT '用户编号--外键--用户表users',
  `lcourse` varchar(100) DEFAULT NULL COMMENT '所讲课程',
  PRIMARY KEY (`lid`),
  KEY `fk_lector_users` (`uid`),
  CONSTRAINT `fk_lector_users` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of lector
-- ----------------------------
INSERT INTO `lector` VALUES ('1', 'lec1', 'Java核心基础');
INSERT INTO `lector` VALUES ('2', 'lec2', 'JavaWEB网络编程');
INSERT INTO `lector` VALUES ('3', 'lec3', 'Javak框架');
INSERT INTO `lector` VALUES ('4', 'lec4', 'Oracle数据库');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(50) DEFAULT NULL,
  `mpath` varchar(50) DEFAULT NULL COMMENT '链接路径',
  `isdirect` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '我的首页', 'My_IndexServlet', null);
INSERT INTO `menu` VALUES ('2', '学习中心', 'studentct\r\n', '1');
INSERT INTO `menu` VALUES ('3', '课程总览', 'Course_Servlet', '1');
INSERT INTO `menu` VALUES ('4', '在线考试', 'TestServlet', '0');
INSERT INTO `menu` VALUES ('5', '留言板', 'LeaveWordsServlet', '1');
INSERT INTO `menu` VALUES ('6', '论坛', 'PostingServlet', '1');
INSERT INTO `menu` VALUES ('7', '个人中心', 'UsersServlet', '1');
INSERT INTO `menu` VALUES ('8', '试题管理', 'TestManageServlet', '0');
INSERT INTO `menu` VALUES ('9', '资料管理', 'datamanager', '1');
INSERT INTO `menu` VALUES ('10', '消息管理', 'HouMessageServlet', '1');
INSERT INTO `menu` VALUES ('11', '用户管理', 'userscontrol', '1');
INSERT INTO `menu` VALUES ('12', '留言管理', 'HouWordsServlet', '1');
INSERT INTO `menu` VALUES ('13', '成绩单', 'ScoreServlet', '0');
INSERT INTO `menu` VALUES ('14', '考试管理', 'ExamManageServlet', '0');
INSERT INTO `menu` VALUES ('15', '资料查看', 'studentdata', '1');
INSERT INTO `menu` VALUES ('16', '选课查看', 'classsee', '1');
INSERT INTO `menu` VALUES ('17', '课程管理', 'houtaiCourseServlet', '1');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mid` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息编号',
  `uid` varchar(50) DEFAULT NULL COMMENT '谁发的消息==外键==用户表--管理员',
  `mtitle` varchar(100) DEFAULT NULL COMMENT '消息标题',
  `mcontent` varchar(1000) DEFAULT NULL COMMENT '消息内容',
  `mtime` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`mid`),
  KEY `fk_message_users` (`uid`),
  CONSTRAINT `fk_message_users` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('17', 'admin', '机器人MicroTugs可拖拽超过自身重量2000倍的物品', '斯坦福大学工程师发明了一种微型机器人，叫做MicroTugs，它可拖拽超过自身重量100倍的物品。\r\n\r\n最强的一款机器人是：仅重12克，可拖拽比自己重2000倍的物品。开发出这类机器人的一名工程师David Christensen表示，这一比例就相当于一个人可以拖动一只蓝鲸。\r\n\r\n作者之一David Christensen，斯坦福大学的博士生，这个作品产自于他的博士论文，他的研究还有：gecko adhesives manufacturing, MEMS sensors, actuators, robotics and manufacturing generally。另外一个作者Elliot Hawkes，研究壁虎的攀爬，成果参见：http://bdml.stanford.edu/Main/Climb。其它的参与者还有：Arul Suresh, Karen Ladenheim。\r\n\r\n工作原理参见MicroTugs在斯坦福大学网站的主页\r\n\r\n这些机器人之所以有如此之大的力量，其秘密还是来自于研究人员从动物身上得到的启发。\r\n\r\n机器人脚部安装了小型橡胶钉，当受到拖拽的压力时能够弯曲，增加吸附的表面积，从而增加粘性。当机器人的脚抬起时，这些橡胶钉能够伸直拉顺，从而容易地与平面分离。\r\n\r\n另外一种攀爬墙壁的机器人则是受到了毛毛虫（尺蠖）的启发，当一半的身体向前移动时，另一半在原地保持不动，这就使得机器人在攀爬墙壁时不会失去它的吸附力。', '2015-04-29 02:13:57');
INSERT INTO `message` VALUES ('18', 'admin', '开源模拟器 QEMU 2.3.0 发布，有 1900+ commits', 'QEMU 2.3本周二正式对外开放下载，该版本包含了1900+ commits和184个作者，也带来了诸多功能改进和新功能：\r\n\r\n针对ARM新增semihosting环境配置选项\r\n支持MIPS5KEc和5KEf MIPS64r2处理器\r\n支持M14K和M14Kc内核MIPS32r2的microMIPS处理器\r\n大量MIPS修复\r\nPseudo支持事务内存扩展\r\nS390 PCI bus支持连接KVM\r\n更好的TriCore模拟\r\n新增x86 IvyBridge CPU模式\r\nKVM支持运行于Valgrind\r\n支持XSAVES，可与KVM一起\r\n通过新sdhci-PCI驱动，可在PCI系统上支持SD卡\r\n其他\r\n\r\n发行说明：QEMU 2.3.0 is now available\r\n\r\n下载地址：http://wiki.qemu.org/download/qemu-2.3.0.tar.bz2\r\n\r\n完整特性：http://wiki.qemu.org/ChangeLog/2.3\r\n\r\n关于开源模拟器 QEMU\r\n\r\nhttp://img.my.csdn.net/uploads/201504/29/1430265621_2232.png\r\n\r\nQEMU是一套由Fabrice Bellard所编写的模拟处理器的自由软件。它与Bochs，PearPC近似，但其具有某些后两者所不具备的特性，如高速度及跨平台的特性。经由kqemu这个开源的加速器，QEMU能模拟至接近真实电脑的速度。QEMU有两种主要运作模倾：\r\n\r\nUser mode模拟模式，亦即是使用者模式。QEMU 能启动那些为不同中央处理器编译的Linux程序。而Wine及 Dosemu是其主要目标。\r\n\r\nSystem mode模拟模式，亦即是系统模式。QEMU能模拟整个电脑系统，包括中央处理器及其他周边设备。它使得为系统源代码进行测试及除错工作变得容易。其亦能用来在一部主机上虚拟数部不同虚拟电脑。\r\n\r\nQEMU的主体部份是在LGPL下发布的，而其系统模式模拟与kqemu加速器则是在GPL下发布。使用kqemu可使QEMU能模拟至接近实机速度，但其在虚拟的操作系统是Microsoft Windows 98或以下的情况下是无用的。', '2015-04-29 02:14:34');
INSERT INTO `message` VALUES ('19', 'admin', 'AvePoint蒋天毅：跨平台协作和集中数据管理将成为主流', '业内对微软“移动为先，云为先”的战略耳熟能详。但究竟微软在产品层面会出现哪些变革？知之者甚少。日前在世纪互联蓝云发会上（详见《蓝云另辟蹊径：柯文达将国际优质SaaS和工具引进生态》），有机会见到AvePoint Co-CEO兼战略和全球业务发展总监蒋天毅博士。作为微软生态中极为专业且知名的ISV（微软深度金牌合作伙伴，微软2014年度国家安全和公共安全金牌合作伙伴及美国政府GSA的战略合作伙伴，有独立知识产权），AvePoint对企业云迁移的认识和本身战略转型的调整更能反应真实发展情况。\r\n\r\nAvePoint是2001年在美国新泽西成立的企业，起源于为微软SharePoint提供诸如集成、管理、迁移、优化、保护和报告等服务。14年积累下来，AvePoint在美国、澳大利亚、英国、法国、德国、日本、新加坡、南非等16个国家有20多个分公司，服务过14000多家企业。IBM Tivoli for SharePoint和NetApp SnapManager for SharePoint都是OEM AvePoint相关方案。其在中国有1200多员工，主要是研发团队。但随着市场变革，移动端和云端的爆发，使得机器产生的数据、工程师开发的数据、流程的数据等一拥而入，企业对于信息管理和分配需要更有计划性和运营能力。也正是敏感意识到客户的变化，4-5年前，AvePoint开始主动选择转型，从基于SharePoint的服务转到为跨平台协作，实现企业内部部署系统及云端服务系统的集中数据管理。\r\n\r\n蒋天毅对CSDN云计算说：“我们是有中国特色的美国公司。多年观察下来，现在国内企业在信息管理方面需求较高，虽然基础相比美国、日本、澳大利亚等企业要弱一些。但如今的云端迁移，对包袱没有这么重的国内企业反而是跳跃发展的机会。可以直接从不同的数据管理系统进入云端管理，实现更快、更有效的数据查询和协同等数据管理服务。”\r\n\r\n看准趋势的AvePoint，主动牵手世纪互联蓝云，以SaaS为切入点，迅速进入中国市场。', '2015-04-29 02:15:26');

-- ----------------------------
-- Table structure for options
-- ----------------------------
DROP TABLE IF EXISTS `options`;
CREATE TABLE `options` (
  `oid` varchar(11) NOT NULL COMMENT '选项编号',
  `tid` int(11) NOT NULL COMMENT '外键---试题表',
  `ocontent` varchar(2000) DEFAULT NULL COMMENT '选项内容',
  PRIMARY KEY (`oid`,`tid`),
  KEY `fk_option_test` (`tid`),
  CONSTRAINT `fk_option_test` FOREIGN KEY (`tid`) REFERENCES `test` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of options
-- ----------------------------
INSERT INTO `options` VALUES ('A', '1', 'try-catch必须配对使用');
INSERT INTO `options` VALUES ('A', '2', 'ArithmeticException');
INSERT INTO `options` VALUES ('A', '3', 'Calendar calen=new Date()');
INSERT INTO `options` VALUES ('A', '4', 'DataInput');
INSERT INTO `options` VALUES ('A', '5', 'FileInputStream');
INSERT INTO `options` VALUES ('A', '6', 'DataInput');
INSERT INTO `options` VALUES ('A', '7', '友元函数');
INSERT INTO `options` VALUES ('A', '8', '构造方法不能指定返回值类型');
INSERT INTO `options` VALUES ('A', '9', '协议');
INSERT INTO `options` VALUES ('A', '10', 'DatagramSocket a=new DatagramSocket()');
INSERT INTO `options` VALUES ('A', '11', '类体中只能有变量定义和成员方法的定义，不能有其它语句');
INSERT INTO `options` VALUES ('A', '12', 'public class method(){}');
INSERT INTO `options` VALUES ('A', '13', '属性和方法');
INSERT INTO `options` VALUES ('A', '14', 'try 后面是可能产生异常的代码，catch 后面是捕获到某种异常对象时进行处理的代码，finally 后面是没有捕获到异常时要执行的代码');
INSERT INTO `options` VALUES ('A', '15', '不可靠、面向无连接和尽最大努力投递');
INSERT INTO `options` VALUES ('A', '16', 'getPath()');
INSERT INTO `options` VALUES ('A', '17', 'FileOutputStream');
INSERT INTO `options` VALUES ('A', '18', '类体中只能有变量定义和成员方法的定义，不能有其它语句');
INSERT INTO `options` VALUES ('A', '19', 'final');
INSERT INTO `options` VALUES ('A', '20', '安全性');
INSERT INTO `options` VALUES ('A', '21', '公有成员');
INSERT INTO `options` VALUES ('B', '1', 'try可以单独使用');
INSERT INTO `options` VALUES ('B', '2', 'NullpointerException');
INSERT INTO `options` VALUES ('B', '3', 'Calender calen=new Calendar()');
INSERT INTO `options` VALUES ('B', '4', 'DataOutput');
INSERT INTO `options` VALUES ('B', '5', 'FileOutputStream');
INSERT INTO `options` VALUES ('B', '6', 'DataOutputStream');
INSERT INTO `options` VALUES ('B', '7', '虚函数');
INSERT INTO `options` VALUES ('B', '8', '构造方法不能指定任何参数');
INSERT INTO `options` VALUES ('B', '9', 'TCP/IP');
INSERT INTO `options` VALUES ('B', '10', 'DatagramSocket b=new DatagramSocket(80)');
INSERT INTO `options` VALUES ('B', '11', '构造方法是类中的特殊方法');
INSERT INTO `options` VALUES ('B', '12', 'public void int method(){}');
INSERT INTO `options` VALUES ('B', '13', '变量和方法');
INSERT INTO `options` VALUES ('B', '14', 'try 后面是可能产生异常的代码，catch 后面是捕获到某种异常对象时进行处理的代码，finally 后面是无论是否捕获到异常都必须执行的代码');
INSERT INTO `options` VALUES ('B', '15', '可靠、面向连接和尽最大努力投递');
INSERT INTO `options` VALUES ('B', '16', 'getName()');
INSERT INTO `options` VALUES ('B', '17', 'FileWriter');
INSERT INTO `options` VALUES ('B', '18', '构造方法是类中的特殊方法');
INSERT INTO `options` VALUES ('B', '19', 'static');
INSERT INTO `options` VALUES ('B', '20', '多线程');
INSERT INTO `options` VALUES ('B', '21', '保护成员');
INSERT INTO `options` VALUES ('C', '1', 'try-finally可以配对使用');
INSERT INTO `options` VALUES ('C', '2', 'ArrayIndexOutOfBoundsException');
INSERT INTO `options` VALUES ('C', '3', 'Calendar calen=Calendar.getTime()');
INSERT INTO `options` VALUES ('C', '4', 'dataInputStream');
INSERT INTO `options` VALUES ('C', '5', 'RandomAccessFile');
INSERT INTO `options` VALUES ('C', '6', 'RandomAccessFile');
INSERT INTO `options` VALUES ('C', '7', '构造函数	 ');
INSERT INTO `options` VALUES ('C', '8', '同一类中，构造方法位于其它方法之前');
INSERT INTO `options` VALUES ('C', '9', 'Internet');
INSERT INTO `options` VALUES ('C', '10', 'DatagramSocket c=new DatagramSocket(\"127.0.0.1\",70)');
INSERT INTO `options` VALUES ('C', '11', '类一定要声明为public，才可以执行');
INSERT INTO `options` VALUES ('C', '12', 'public void method{}');
INSERT INTO `options` VALUES ('C', '13', '变量的数据');
INSERT INTO `options` VALUES ('C', '14', 'catch 语句用来处理程序运行时的非致命性错误，而 finally 语句用来处理程序运行时的致命性错误');
INSERT INTO `options` VALUES ('C', '15', '不可靠、面向连接和全双工');
INSERT INTO `options` VALUES ('C', '16', 'isFile()');
INSERT INTO `options` VALUES ('C', '17', 'BufferedWriter');
INSERT INTO `options` VALUES ('C', '18', '类一定要声明为public，才可以执行');
INSERT INTO `options` VALUES ('C', '19', 'abstract');
INSERT INTO `options` VALUES ('C', '20', '跨平台');
INSERT INTO `options` VALUES ('C', '21', '私有派生');
INSERT INTO `options` VALUES ('D', '1', 'try后必须有catch和finally');
INSERT INTO `options` VALUES ('D', '2', 'SecourityManager');
INSERT INTO `options` VALUES ('D', '3', 'Calendar calen=Calendar.getInstance()');
INSERT INTO `options` VALUES ('D', '4', 'ObjectInput');
INSERT INTO `options` VALUES ('D', '5', 'File');
INSERT INTO `options` VALUES ('D', '6', 'FileNameFilter');
INSERT INTO `options` VALUES ('D', '7', '析构函数');
INSERT INTO `options` VALUES ('D', '8', '构造方法能够向实例变量赋值');
INSERT INTO `options` VALUES ('D', '9', '以太');
INSERT INTO `options` VALUES ('D', '10', 'DatagramSocket d=new DatagramSocket(\"127.0.0.1\")');
INSERT INTO `options` VALUES ('D', '11', '一个java文件中可以有多个class定义');
INSERT INTO `options` VALUES ('D', '12', 'public void method(){}');
INSERT INTO `options` VALUES ('D', '13', '对象和属性');
INSERT INTO `options` VALUES ('D', '14', 'catch 语句和 finally 语句都可以缺省');
INSERT INTO `options` VALUES ('D', '15', '可靠、面向无连接和全双工');
INSERT INTO `options` VALUES ('D', '16', 'isAbsolute()');
INSERT INTO `options` VALUES ('D', '17', 'OutputStream');
INSERT INTO `options` VALUES ('D', '18', '一个java文件中可以有多个class定义');
INSERT INTO `options` VALUES ('D', '19', 'void');
INSERT INTO `options` VALUES ('D', '20', '可移植');
INSERT INTO `options` VALUES ('D', '21', '公有和保护成员');

-- ----------------------------
-- Table structure for posting
-- ----------------------------
DROP TABLE IF EXISTS `posting`;
CREATE TABLE `posting` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子编号',
  `uid` varchar(50) DEFAULT NULL COMMENT '用户编号---外键--用户表users',
  `ptitle` varchar(200) DEFAULT NULL COMMENT '帖子标题',
  `pcontent` varchar(1000) DEFAULT NULL COMMENT '帖子内容',
  `ptime` datetime DEFAULT NULL COMMENT '发帖时间',
  `pimage` varchar(100) DEFAULT NULL COMMENT '图片',
  `pcount` int(255) DEFAULT '0',
  `prcount` int(255) DEFAULT '0',
  PRIMARY KEY (`pid`),
  KEY `fk_posting_users` (`uid`),
  CONSTRAINT `fk_posting_users` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of posting
-- ----------------------------

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '回帖编号',
  `uid` varchar(50) DEFAULT NULL COMMENT '回帖人编号--外键--用户表users',
  `pid` int(11) DEFAULT NULL COMMENT '帖子编号--外键--论坛发帖posting',
  `rcontent` varchar(1000) DEFAULT NULL COMMENT '回帖内容',
  `rtime` datetime DEFAULT NULL COMMENT '回帖时间',
  PRIMARY KEY (`rid`),
  KEY `fk_reply_users` (`uid`),
  KEY `fk_reply_posting` (`pid`),
  CONSTRAINT `fk_reply_posting` FOREIGN KEY (`pid`) REFERENCES `posting` (`pid`) ON DELETE CASCADE,
  CONSTRAINT `fk_reply_users` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for selectcourse
-- ----------------------------
DROP TABLE IF EXISTS `selectcourse`;
CREATE TABLE `selectcourse` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '已选课程编号',
  `uid` varchar(50) DEFAULT NULL COMMENT '外键==用户表==用户编号',
  `cid` int(11) DEFAULT NULL COMMENT '课程编号--外键--课程表course',
  PRIMARY KEY (`sid`),
  KEY `fk_selectcourse_users` (`uid`),
  KEY `fk_selectcourse_course` (`cid`),
  CONSTRAINT `selectcourse_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`) ON DELETE CASCADE,
  CONSTRAINT `selectcourse_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of selectcourse
-- ----------------------------
INSERT INTO `selectcourse` VALUES ('1', 'user1', '1');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `tid` int(11) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `title` varchar(500) DEFAULT NULL COMMENT '题目内容',
  `truekey` varchar(20) DEFAULT NULL COMMENT '正确答案',
  `tanalyze` varchar(500) DEFAULT NULL COMMENT '解析',
  `ttime` datetime DEFAULT NULL COMMENT '出题时间',
  `lid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL COMMENT '题目类型编号==外键==课程表',
  PRIMARY KEY (`tid`),
  KEY `fk_test_course` (`cid`),
  KEY `fk_test_lector` (`lid`),
  CONSTRAINT `fk_test_course` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`),
  CONSTRAINT `fk_test_lector` FOREIGN KEY (`lid`) REFERENCES `lector` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '在Java中， 关于捕获异常的语法try-catch-finally的下列描述正确的是哪个项目？（选择1项）', 'C', null, '2014-10-13 12:39:41', null, '1');
INSERT INTO `test` VALUES ('2', '在Java语言中，在程序运行时会自动检查数组的下标是否越界，如果越界，会抛掷下面的（）异常。（选择1项）', 'C', null, '2014-10-27 12:47:03', null, '1');
INSERT INTO `test` VALUES ('3', '以下创建Calendar的对象正确的代码是：（）', 'D', null, '2014-10-27 12:47:19', null, '1');
INSERT INTO `test` VALUES ('4', '不属于java.io包中的接口的一项是（）', 'C', null, '2014-10-27 12:47:56', null, '1');
INSERT INTO `test` VALUES ('5', '要创建一个新目录，可以用下面(  )类实现。', 'C', null, '2014-10-27 12:48:09', null, '1');
INSERT INTO `test` VALUES ('6', 'java.io包中提供的用于筛选文件名的接口是（） ', 'D', null, '2014-10-27 12:48:38', null, '1');
INSERT INTO `test` VALUES ('7', '在类的定义中，用于为对象分配内存空间，对类的数据成员进行初始化并执行其他内部管理操作的函数是', 'C', null, null, null, '1');
INSERT INTO `test` VALUES ('8', '构造方法和普通方法之间的一个重要区别是( )', 'A', null, null, null, '1');
INSERT INTO `test` VALUES ('9', '在网络的各个节点上，为了顺利实现OSI模型中同一层次的功能，必须共同遵守的规则，叫做（ ）。', 'A', null, null, null, '1');
INSERT INTO `test` VALUES ('10', '下面的语句创建一DatagramSocket对象，错误的是（ ）', 'D', null, null, null, '1');
INSERT INTO `test` VALUES ('11', '下面关于java中类的说法不正确的是(  )', 'C', null, null, null, '1');
INSERT INTO `test` VALUES ('12', '下面几个方法声明中正确的是（ ）', 'D', null, null, null, '1');
INSERT INTO `test` VALUES ('13', '类是具有相同的(  )的集合', 'A', null, null, null, '1');
INSERT INTO `test` VALUES ('14', '在 Java 的异常处理语句 try-catch-finally 中，以下描述正确的是：', 'B', null, null, null, '1');
INSERT INTO `test` VALUES ('15', 'IP服务的3个主要特点是（ ）', 'A', null, null, null, '1');
INSERT INTO `test` VALUES ('16', '从键盘上输入一个字符串创建文件对象，若要判断该文件对象为目录文件或数据文件，可使用下列哪个方法？（  ）', 'C', null, null, null, '1');
INSERT INTO `test` VALUES ('17', '能够以字符串为单位写入文件数据的流类是（  ）', 'C', null, null, null, '1');
INSERT INTO `test` VALUES ('18', '下面关于java中类的说法不正确的是(   )', 'C', null, null, null, '1');
INSERT INTO `test` VALUES ('19', '在Java中，如果父类中的某些方法不包含任务逻辑，并且需要有子类重写，应该使用(    )关键字来声明父类的这些方法', 'C', null, null, null, '1');
INSERT INTO `test` VALUES ('20', 'Java语言具有许多优点和特点，哪个反映了Java程序并行机制的特点？', 'B', null, null, null, '1');
INSERT INTO `test` VALUES ('21', '派生类可以访问其基类的', 'D', null, '2014-11-05 06:21:39', null, null);

-- ----------------------------
-- Table structure for testdetail
-- ----------------------------
DROP TABLE IF EXISTS `testdetail`;
CREATE TABLE `testdetail` (
  `tdid` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `tpid` int(50) DEFAULT NULL COMMENT '试卷编号==外键==试卷表testpaper',
  `tid` varchar(50) DEFAULT NULL,
  `tppitch` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tdid`),
  KEY `fk_testdetail_testpaper` (`tpid`),
  KEY `fk_testdetail_test` (`tid`),
  CONSTRAINT `fk_testdetail_testpaper` FOREIGN KEY (`tpid`) REFERENCES `testpaper` (`tpid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of testdetail
-- ----------------------------
INSERT INTO `testdetail` VALUES ('7', '10', '17,16,2,21,5', 'A,A,A,A,A');

-- ----------------------------
-- Table structure for testpaper
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper` (
  `tpid` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷编号',
  `uid` varchar(50) DEFAULT NULL COMMENT '用户编号--外键--用户表users',
  `tpfull` float DEFAULT NULL COMMENT '满分',
  `tpscore` float DEFAULT NULL COMMENT '得分',
  `emid` int(11) DEFAULT NULL,
  `tpdate` datetime DEFAULT NULL,
  PRIMARY KEY (`tpid`),
  KEY `fk_testpaper_users` (`uid`),
  KEY `fk_exammanage` (`emid`),
  CONSTRAINT `fk_exammanage` FOREIGN KEY (`emid`) REFERENCES `exammanage` (`emid`),
  CONSTRAINT `fk_testpaper_users` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of testpaper
-- ----------------------------
INSERT INTO `testpaper` VALUES ('10', 'user2', '100', '0', '3', '2014-11-05 07:08:32');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uid` varchar(50) NOT NULL COMMENT '用户账号==唯一非空',
  `upass` varchar(50) DEFAULT NULL COMMENT '密码',
  `upower` varchar(50) DEFAULT '1' COMMENT '权限',
  `uname` varchar(50) DEFAULT NULL COMMENT '用户真实姓名',
  `uage` int(11) DEFAULT NULL COMMENT '用户年龄',
  `usex` varchar(20) DEFAULT NULL COMMENT '用户性别  男  女',
  `uimage` varchar(100) DEFAULT NULL COMMENT '头像',
  `utext` varchar(500) DEFAULT NULL COMMENT '用户简介',
  `ustate` int(11) DEFAULT '1' COMMENT '用户账号状态  1-未封  0-封',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('admin', 'admin', '0', '管理员', '32', '男', null, '总管理员', '1');
INSERT INTO `users` VALUES ('lec1', '000', '10', '张老师', '25', '女', null, '硕士级导师', '1');
INSERT INTO `users` VALUES ('lec2', '000', '10', '高老师', '26', '女', null, '硕士级导师', '1');
INSERT INTO `users` VALUES ('lec3', '000', '10', '王老师', '33', '男', null, '硕士级导师', '1');
INSERT INTO `users` VALUES ('lec4', '000', '10', '李老师', '27', '男', null, '硕士级导师', '1');
INSERT INTO `users` VALUES ('user1', 'aaa', '1', '小李', '20', '女', '', '学霸', '1');
INSERT INTO `users` VALUES ('user2', 'aaa', '1', '小王', '21', '男', 'images/1415186137687.jpg', '学渣', '1');
INSERT INTO `users` VALUES ('user3', 'aaa', '1', '小明', '22', '男', null, '学神', '1');

-- ----------------------------
-- Table structure for words
-- ----------------------------
DROP TABLE IF EXISTS `words`;
CREATE TABLE `words` (
  `wid` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言编号',
  `uid` varchar(50) DEFAULT NULL COMMENT '用户编号--外键--用户表users',
  `wcontent` varchar(2000) DEFAULT NULL COMMENT '留言内容',
  `wtouid` varchar(50) DEFAULT NULL COMMENT '用户编号==给谁留言==外键',
  `wtime` datetime DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`wid`),
  KEY `fk_words_users` (`uid`),
  KEY `fk2_words_users` (`wtouid`),
  CONSTRAINT `fk2_words_users` FOREIGN KEY (`wtouid`) REFERENCES `users` (`uid`) ON DELETE CASCADE,
  CONSTRAINT `fk_words_users` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of words
-- ----------------------------
