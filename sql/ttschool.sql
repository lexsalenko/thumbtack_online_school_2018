DROP DATABASE IF EXISTS ttschool;
CREATE DATABASE ttschool; 
USE ttschool;

CREATE TABLE school (
	id INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
    `year` INT(11) NOT NULL,
    UNIQUE KEY name_year (`name`, `year`),
	PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `group` (
	id INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
    room VARCHAR(50) NOT NULL,
    schoolid INT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (schoolid) REFERENCES school (id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;


CREATE TABLE trainee (
	id INT(11) NOT NULL AUTO_INCREMENT,
	firstName VARCHAR(50) NOT NULL,
	lastName VARCHAR(50) NOT NULL,
    rating INT(5) NOT NULL,
    groupid INT(11),
    PRIMARY KEY (id),
    FOREIGN KEY (`groupid`) REFERENCES `group` (id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `subject` (
	id INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE group_subject (
	id INT (11) NOT NULL AUTO_INCREMENT,
    groupid INT (11),
    subjectid INT (11),
    PRIMARY KEY (id),
    FOREIGN KEY (groupid) REFERENCES `group` (id) ON DELETE CASCADE,
    FOREIGN KEY (subjectid) REFERENCES `subject` (id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE city (
	id INT(11) NOT NULL AUTO_INCREMENT,
	capital_city_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
