# QuickPoll


CREATE DATABASE pollApp


CREATE TABLE `polls` (
  `POLL_ID` DECIMAL NOT NULL,
  `QUESTION` varchar(500) NOT NULL,
  PRIMARY KEY (`POLL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `opt` (
  `OPTION_ID` DECIMAL NOT NULL,
  `OPTION_VALUE` varchar(500) NOT NULL,
  `POLL_ID` DECIMAL NOT NULL,
  PRIMARY KEY (`OPTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `vot` (
  `VOTE_ID` DECIMAL NOT NULL,
  `OPTION_ID` varchar(500) NOT NULL,
  PRIMARY KEY (`VOTE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SELECT * FROM polls

SELECT * FROM opt

SELECT * FROM vot


INSERT INTO polls VALUES(1, 'Sience is great?')
INSERT INTO polls VALUES(2, 'Spring is great?')

INSERT INTO opt VALUES(1, 'Yes', 1)



--testy dla join

CREATE TABLE `Cart` (
  `cart_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
 
CREATE TABLE `Items` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cart_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cart_id` (`cart_id`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `Cart` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


SELECT * FROM Cart

SELECT * FROM Items
