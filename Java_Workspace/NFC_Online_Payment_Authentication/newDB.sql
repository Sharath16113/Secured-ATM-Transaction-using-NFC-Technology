/*
SQLyog - Free MySQL GUI v5.19
Host - 5.5.17 : Database - db_nfc_payment
*********************************************************************
Server version : 5.5.17
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
  `admin_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `d_admin` */

insert into `d_admin` (`admin_id`,`admin_password`,`admin_name`) values ('admin','admin123','Shanu Gowda');

/*Table structure for table `d_cat` */

DROP TABLE IF EXISTS `d_cat`;

CREATE TABLE `d_cat` (
  `cat_code` int(8) NOT NULL,
  `cat_name` varchar(30) NOT NULL,
  PRIMARY KEY (`cat_code`)
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
  `pro_description` varchar(50) DEFAULT NULL,
  `cat_code` int(8) DEFAULT NULL,
  `sub_cat_code` int(8) DEFAULT NULL,
  `pro_photo_path` varchar(100) DEFAULT NULL,
  `pro_pur_price` float DEFAULT NULL,
  `pro_mrp` float DEFAULT NULL,
  `pro_price` float DEFAULT NULL,
  `pro_tax` float DEFAULT NULL,
  PRIMARY KEY (`pro_code`),
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
  PRIMARY KEY (`q_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `d_quotation` */

insert into `d_quotation` (`q_no`) values (1);

/*Table structure for table `d_salesperson` */

DROP TABLE IF EXISTS `d_salesperson`;

CREATE TABLE `d_salesperson` (
  `sp_id` varchar(15) NOT NULL,
  `sp_password` varchar(15) NOT NULL,
  `sp_name` varchar(50) DEFAULT NULL,
  `sp_address` varchar(150) DEFAULT NULL,
  `sp_mobile` varchar(10) DEFAULT NULL,
  `sp_publickey` varchar(20) DEFAULT NULL,
  `sp_secretkey` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `d_salesperson` */

insert into `d_salesperson` (`sp_id`,`sp_password`,`sp_name`,`sp_address`,`sp_mobile`,`sp_publickey`,`sp_secretkey`) values ('shanu','shanu123','shanu','hassan','9999999999','521','523');

/*Table structure for table `d_sub_cat` */

DROP TABLE IF EXISTS `d_sub_cat`;

CREATE TABLE `d_sub_cat` (
  `sub_cat_code` int(8) NOT NULL,
  `cat_code` int(11) DEFAULT NULL,
  `sub_cat_name` varchar(21) DEFAULT NULL,
  PRIMARY KEY (`sub_cat_code`),
  KEY `FK_d_sub_cat` (`cat_code`),
  CONSTRAINT `d_sub_cat_ibfk_1` FOREIGN KEY (`cat_code`) REFERENCES `d_cat` (`cat_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `d_sub_cat` */

insert into `d_sub_cat` (`sub_cat_code`,`cat_code`,`sub_cat_name`) values (1000,1000,'Sony');
insert into `d_sub_cat` (`sub_cat_code`,`cat_code`,`sub_cat_name`) values (2000,1000,'Sony Ericson');
insert into `d_sub_cat` (`sub_cat_code`,`cat_code`,`sub_cat_name`) values (3000,1000,'Lenova');

/*Table structure for table `m_as` */

DROP TABLE IF EXISTS `m_as`;

CREATE TABLE `m_as` (
  `as_certificate_content` varchar(100) DEFAULT NULL,
  `as_publickey` varchar(50) DEFAULT NULL,
  `as_secretkey` varchar(50) DEFAULT NULL,
  `as_certificate` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_as` */

/*Table structure for table `m_card` */

DROP TABLE IF EXISTS `m_card`;

CREATE TABLE `m_card` (
  `card_code` int(10) NOT NULL AUTO_INCREMENT,
  `card_bank` varchar(100) NOT NULL,
  `card_custid` varchar(100) NOT NULL,
  `card_pan` varchar(100) NOT NULL,
  `card_name` varchar(100) NOT NULL,
  `card_exp` varchar(100) NOT NULL,
  `card_balance` varchar(100) NOT NULL,
  `card_atmpin` varchar(100) NOT NULL,
  `card_status` varchar(20) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`card_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_card` */

/*Table structure for table `t_quotation` */

DROP TABLE IF EXISTS `t_quotation`;

CREATE TABLE `t_quotation` (
  `q_no` int(8) DEFAULT NULL,
  `s_no` int(8) NOT NULL AUTO_INCREMENT,
  `pro_code` int(8) DEFAULT NULL,
  `cat_code` int(8) DEFAULT NULL,
  `qty` int(100) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `tax` float DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `status` varchar(20) DEFAULT 'no',
  PRIMARY KEY (`s_no`),
  KEY `FK_t_quotation` (`pro_code`),
  KEY `FK_t_quotation2` (`q_no`),
  KEY `FK_t_quotation4` (`cat_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `t_quotation` */

insert into `t_quotation` (`q_no`,`s_no`,`pro_code`,`cat_code`,`qty`,`price`,`tax`,`amount`,`status`) values (1,1,101,1000,1,43000,10,47300,'no');
insert into `t_quotation` (`q_no`,`s_no`,`pro_code`,`cat_code`,`qty`,`price`,`tax`,`amount`,`status`) values (1,2,102,1000,2,32000,10,67200,'yes');
insert into `t_quotation` (`q_no`,`s_no`,`pro_code`,`cat_code`,`qty`,`price`,`tax`,`amount`,`status`) values (2,3,102,1000,2,32000,10,67200,'yes');
insert into `t_quotation` (`q_no`,`s_no`,`pro_code`,`cat_code`,`qty`,`price`,`tax`,`amount`,`status`) values (3,4,102,1000,3,32000,10,99200,'no');
insert into `t_quotation` (`q_no`,`s_no`,`pro_code`,`cat_code`,`qty`,`price`,`tax`,`amount`,`status`) values (3,5,101,1000,5,43000,10,219300,'yes');
insert into `t_quotation` (`q_no`,`s_no`,`pro_code`,`cat_code`,`qty`,`price`,`tax`,`amount`,`status`) values (4,6,102,1000,3,32000,10,99200,'no');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
