/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - db_nfc_payment
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `db_nfc_payment`;

USE `db_nfc_payment`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `d_admin` */

DROP TABLE IF EXISTS `d_admin`;

CREATE TABLE `d_admin` (
  `admin_id` varchar(15) NOT NULL,
  `admin_password` varchar(10) NOT NULL,
  `admin_name` varchar(20) default NULL,
  PRIMARY KEY  (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `d_admin` */

insert into `d_admin` (`admin_id`,`admin_password`,`admin_name`) values ('admin','admin','Shanu Gowda');

/*Table structure for table `d_cat` */

DROP TABLE IF EXISTS `d_cat`;

CREATE TABLE `d_cat` (
  `cat_code` int(8) NOT NULL,
  `cat_name` varchar(30) NOT NULL,
  PRIMARY KEY  (`cat_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `d_cat` */

insert into `d_cat` (`cat_code`,`cat_name`) values (1000,'mobile');
insert into `d_cat` (`cat_code`,`cat_name`) values (2000,'gadgets');
insert into `d_cat` (`cat_code`,`cat_name`) values (3000,'furnituree');

/*Table structure for table `d_product` */

DROP TABLE IF EXISTS `d_product`;

CREATE TABLE `d_product` (
  `pro_code` int(8) NOT NULL,
  `pro_name` varchar(50) NOT NULL,
  `pro_description` varchar(50) default NULL,
  `cat_code` int(8) default NULL,
  `sub_cat_code` int(8) default NULL,
  `pro_photo_path` varchar(100) default NULL,
  `pro_pur_price` float default NULL,
  `pro_mrp` float default NULL,
  `pro_price` float default NULL,
  `pro_tax` float default NULL,
  PRIMARY KEY  (`pro_code`),
  KEY `FK_d_product` (`cat_code`),
  KEY `FK_d_product1` (`sub_cat_code`),
  CONSTRAINT `d_product_ibfk_1` FOREIGN KEY (`cat_code`) REFERENCES `d_cat` (`cat_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `d_product_ibfk_2` FOREIGN KEY (`sub_cat_code`) REFERENCES `d_sub_cat` (`sub_cat_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `d_product` */

insert into `d_product` (`pro_code`,`pro_name`,`pro_description`,`cat_code`,`sub_cat_code`,`pro_photo_path`,`pro_pur_price`,`pro_mrp`,`pro_price`,`pro_tax`) values (101,'Lenovo Laptop','Good',1000,1000,'Lap.jpg',40000,45000,43000,10);
insert into `d_product` (`pro_code`,`pro_name`,`pro_description`,`cat_code`,`sub_cat_code`,`pro_photo_path`,`pro_pur_price`,`pro_mrp`,`pro_price`,`pro_tax`) values (102,'sony phone','bad',1000,1000,'cvv2.jpg',30000,35000,32000,10);

/*Table structure for table `d_quotation` */

DROP TABLE IF EXISTS `d_quotation`;

CREATE TABLE `d_quotation` (
  `q_no` int(8) NOT NULL,
  `tot_amount` varchar(500) default NULL,
  PRIMARY KEY  (`q_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `d_quotation` */

/*Table structure for table `d_salesperson` */

DROP TABLE IF EXISTS `d_salesperson`;

CREATE TABLE `d_salesperson` (
  `sp_id` varchar(15) NOT NULL,
  `sp_password` varchar(15) NOT NULL,
  `sp_name` varchar(50) default NULL,
  `sp_address` varchar(150) default NULL,
  `sp_mobile` varchar(10) default NULL,
  `sp_publickey` varchar(20) default NULL,
  `sp_secretkey` varchar(20) default NULL,
  `sp_otp` varchar(50) default NULL,
  `sp_email` varchar(50) default NULL,
  PRIMARY KEY  (`sp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `d_salesperson` */

insert into `d_salesperson` (`sp_id`,`sp_password`,`sp_name`,`sp_address`,`sp_mobile`,`sp_publickey`,`sp_secretkey`,`sp_otp`,`sp_email`) values ('17','1234','Sharath','Bengaluru','8296397717','487','509','268145','sharathsharu@gmail.com');
insert into `d_salesperson` (`sp_id`,`sp_password`,`sp_name`,`sp_address`,`sp_mobile`,`sp_publickey`,`sp_secretkey`,`sp_otp`,`sp_email`) values ('18','1234','Ruchitha','Bengaluru','7349288433','521','541','767129','xyz@gmail.com');
insert into `d_salesperson` (`sp_id`,`sp_password`,`sp_name`,`sp_address`,`sp_mobile`,`sp_publickey`,`sp_secretkey`,`sp_otp`,`sp_email`) values ('19','3456','kalyan','Bengaluru','9916715304','523','499','719269','abc@gmail.com');
insert into `d_salesperson` (`sp_id`,`sp_password`,`sp_name`,`sp_address`,`sp_mobile`,`sp_publickey`,`sp_secretkey`,`sp_otp`,`sp_email`) values ('ashwini','ashwini','ashwini','btm','976854321','487','487','431581','namanabl13@gmail.com');
insert into `d_salesperson` (`sp_id`,`sp_password`,`sp_name`,`sp_address`,`sp_mobile`,`sp_publickey`,`sp_secretkey`,`sp_otp`,`sp_email`) values ('jack','1234','jack','btm','98765432','503','499',NULL,'ashwinigodase25@gmail.com');
insert into `d_salesperson` (`sp_id`,`sp_password`,`sp_name`,`sp_address`,`sp_mobile`,`sp_publickey`,`sp_secretkey`,`sp_otp`,`sp_email`) values ('neha','3456','neha','Jayanagar','7760433598','491','523','142821','namanabl13@gmail.com');

/*Table structure for table `d_sub_cat` */

DROP TABLE IF EXISTS `d_sub_cat`;

CREATE TABLE `d_sub_cat` (
  `sub_cat_code` int(8) NOT NULL,
  `cat_code` int(11) default NULL,
  `sub_cat_name` varchar(21) default NULL,
  PRIMARY KEY  (`sub_cat_code`),
  KEY `FK_d_sub_cat` (`cat_code`),
  CONSTRAINT `d_sub_cat_ibfk_1` FOREIGN KEY (`cat_code`) REFERENCES `d_cat` (`cat_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `d_sub_cat` */

insert into `d_sub_cat` (`sub_cat_code`,`cat_code`,`sub_cat_name`) values (1000,1000,'Sony');
insert into `d_sub_cat` (`sub_cat_code`,`cat_code`,`sub_cat_name`) values (2000,1000,'Sony Ericson');
insert into `d_sub_cat` (`sub_cat_code`,`cat_code`,`sub_cat_name`) values (3000,1000,'Lenova');
insert into `d_sub_cat` (`sub_cat_code`,`cat_code`,`sub_cat_name`) values (3001,3000,'Beanbag');

/*Table structure for table `m_as` */

DROP TABLE IF EXISTS `m_as`;

CREATE TABLE `m_as` (
  `as_certificate_content` varchar(100) default NULL,
  `as_publickey` varchar(50) default NULL,
  `as_secretkey` varchar(50) default NULL,
  `as_certificate` varchar(1000) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_as` */

insert into `m_as` (`as_certificate_content`,`as_publickey`,`as_secretkey`,`as_certificate`) values ('vnusecret123','521','523','49_49#48_48#55_55#50_50#49_49#54_54#53_53#54_54#50_50#51_51#100_100#54_54#48_48#52_52#52_52#53_53#56_56#53_53#57_57#57_57#55_55#98_98#102_102#52_52#49_49#52_52#48_48#55_55#56_56#99_99#50_50#51_51#');

/*Table structure for table `m_bank` */

DROP TABLE IF EXISTS `m_bank`;

CREATE TABLE `m_bank` (
  `d_name` varchar(10) default NULL,
  `d_password` varchar(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_bank` */

insert into `m_bank` (`d_name`,`d_password`) values ('bank','bank');

/*Table structure for table `m_card` */

DROP TABLE IF EXISTS `m_card`;

CREATE TABLE `m_card` (
  `card_code` int(10) NOT NULL auto_increment,
  `card_bank` varchar(100) NOT NULL,
  `card_custid` varchar(100) NOT NULL,
  `card_pan` varchar(100) NOT NULL,
  `card_name` varchar(100) NOT NULL,
  `card_exp` varchar(100) NOT NULL,
  `card_balance` varchar(100) NOT NULL,
  `card_atmpin` varchar(100) NOT NULL,
  `card_status` varchar(20) NOT NULL default 'Active',
  PRIMARY KEY  (`card_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_card` */

insert into `m_card` (`card_code`,`card_bank`,`card_custid`,`card_pan`,`card_name`,`card_exp`,`card_balance`,`card_atmpin`,`card_status`) values (1,'sbi','123456','cs1234','shiva','02-2025','9800','8907','Active');
insert into `m_card` (`card_code`,`card_bank`,`card_custid`,`card_pan`,`card_name`,`card_exp`,`card_balance`,`card_atmpin`,`card_status`) values (2,'icici','123','bg3000','isha','04-2024','756300','7608','Active');
insert into `m_card` (`card_code`,`card_bank`,`card_custid`,`card_pan`,`card_name`,`card_exp`,`card_balance`,`card_atmpin`,`card_status`) values (3,'pnb','3','ab1234','ruchitha','05-2023','666500','1234','Active');

/*Table structure for table `t_quotation` */

DROP TABLE IF EXISTS `t_quotation`;

CREATE TABLE `t_quotation` (
  `q_no` int(8) default NULL,
  `s_no` int(8) NOT NULL auto_increment,
  `pro_code` int(8) default NULL,
  `cat_code` int(8) default NULL,
  `qty` int(100) default NULL,
  `price` float default NULL,
  `tax` float default NULL,
  `amount` float default NULL,
  `status` varchar(20) default 'no',
  `net_amount` varchar(500) default NULL,
  `tot_amount` varchar(500) default NULL,
  PRIMARY KEY  (`s_no`),
  KEY `FK_t_quotation` (`pro_code`),
  KEY `FK_t_quotation2` (`q_no`),
  KEY `FK_t_quotation4` (`cat_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_quotation` */

insert into `t_quotation` (`q_no`,`s_no`,`pro_code`,`cat_code`,`qty`,`price`,`tax`,`amount`,`status`,`net_amount`,`tot_amount`) values (1,2,102,1000,1,32000,10,35200,'no','35200',NULL);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
