create table person (
	id bigint not null auto_increment,
	name varchar(60) not null,
	description varchar(255) not null,
	modified datetime not null,
	resourceURI varchar(255) not null,
    thumbnail blob,
	primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

INSERT INTO dextra.person VALUES (1, 'Hulk', 'Herói formado por radiação gama', now(), 'http://', null);

CREATE TABLE `comic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dextra.comic VALUES (1, 'O Incrível Hulk');

CREATE TABLE `person_comic` (
  `person_id` bigint NOT NULL,
  `comic_id` bigint NOT NULL,
  PRIMARY KEY (`person_id`,`comic_id`),
  KEY `comic_id` (`comic_id`),
  CONSTRAINT `person_comic_ibfk_1` 
   FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  CONSTRAINT `person_comic_ibfk_2` 
   FOREIGN KEY (`comic_id`) REFERENCES `comic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dextra.person_comic VALUES (1, 1);

CREATE TABLE `event` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dextra.event VALUES (1, 'Primeira aparição do Hulk');

CREATE TABLE `person_event` (
  `person_id` bigint NOT NULL,
  `event_id` bigint NOT NULL,
  PRIMARY KEY (`person_id`,`event_id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `person_event_ibfk_1` 
   FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  CONSTRAINT `person_event_ibfk_2` 
   FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dextra.person_event VALUES (1, 1);

CREATE TABLE `serie` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dextra.serie VALUES (1, 'As Aventuras do Incrível Hulk');

CREATE TABLE `person_serie` (
  `person_id` bigint NOT NULL,
  `serie_id` bigint NOT NULL,
  PRIMARY KEY (`person_id`,`serie_id`),
  KEY `serie_id` (`serie_id`),
  CONSTRAINT `person_serie_ibfk_1` 
   FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  CONSTRAINT `person_serie_ibfk_2` 
   FOREIGN KEY (`serie_id`) REFERENCES `serie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dextra.person_serie VALUES (1, 1);

CREATE TABLE `storie` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dextra.storie VALUES (1, 'Dr. Banner se transforma');

CREATE TABLE `person_storie` (
  `person_id` bigint NOT NULL,
  `storie_id` bigint NOT NULL,
  PRIMARY KEY (`person_id`,`storie_id`),
  KEY `comic_id` (`storie_id`),
  CONSTRAINT `person_storie_ibfk_1` 
   FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  CONSTRAINT `person_storie_ibfk_2` 
   FOREIGN KEY (`storie_id`) REFERENCES `storie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO dextra.person_storie VALUES (1, 1);