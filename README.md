# QuickPoll


Great for rest testing 
https://insomnia.rest/

Always set header to = application/json
=============================================================================   

For creating a Poll 
http://localhost:8080/PollApp/polls ==> POST

{
"question": "Who will win SuperBowl this year?",
"options": [
{"value": "New England Patriots"},
{"value": "Seattle Seahawks"},
{"value": "Green Bay Packers"},
{"value": "Denver Broncos"}]
}

=============================================================================  

For update Pull  
http://localhost:8080/PollApp/polls/2 ==> PUT

{
"id" : "2",
"question": "Who will losse SuperBowl 2015?",
"options": [
{"value": "New England Patriots"},
{"value": "Seattle Seahawks"},
{"value": "Green Bay Packers"},
{"value": "Denver Broncos"}]
}


=============================================================================   

For sending a Vote to Poll with id=1 
http://localhost:8080/PollApp/polls/1/votes ==> POST

{
	"option": {
		"id" : "1", "value" : "New England Patriots"
	}
}

=============================================================================   

CREATE DATABASE pollApp

-- main table  
CREATE TABLE `polls` (
  `POLL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION` varchar(500) NOT NULL,
  PRIMARY KEY (`POLL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- options for main table  
CREATE TABLE `opt` (
  `OPTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OPTION_VALUE` varchar(500) NOT NULL,
  `POLL_ID` int(11) NOT NULL,
  PRIMARY KEY (`OPTION_ID`),
  KEY `POLL_ID` (`POLL_ID`),
  CONSTRAINT `polls_ibfk_1` FOREIGN KEY (`POLL_ID`) REFERENCES `polls` (`POLL_ID`) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- vote for tables  
CREATE TABLE `vot` (
  `VOTE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OPTION_ID` int(11) NOT NULL,
  PRIMARY KEY (`VOTE_ID`),
  KEY `OPTION_ID` (`OPTION_ID`),
  CONSTRAINT `option_ibfk_1` FOREIGN KEY (`OPTION_ID`) REFERENCES `opt` (`OPTION_ID`) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SELECT * FROM polls  

SELECT * FROM opt  

SELECT * FROM vot  


INSERT INTO polls VALUES(1, 'Sience is great?')
INSERT INTO polls VALUES(2, 'Spring is great?')

INSERT INTO opt VALUES(1, 'Yes', 1)
INSERT INTO opt VALUES(2, 'No', 1)



-- tests for join  

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


