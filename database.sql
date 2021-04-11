/*
Navicat MySQL Data Transfer

Source Server         : Casa
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : java-libreria-mysql

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2021-04-11 16:27:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `author` varchar(45) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `book_id_UNIQUE` (`book_id`),
  UNIQUE KEY `title_UNIQUE` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('0', '1', '1', '1');
INSERT INTO `book` VALUES ('1', '2', '2', '2');
INSERT INTO `book` VALUES ('3', '3', '3', '3');
INSERT INTO `book` VALUES ('12', 'Lol', 'lol', '2');
