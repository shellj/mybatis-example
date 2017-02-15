CREATE TABLE blog (
	`id` bigint(19) NOT NULL AUTO_INCREMENT,
	`author` varchar(64),
	`title` varchar(128),
	`content` varchar(512),
	`create_date` datetime,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT='blog';