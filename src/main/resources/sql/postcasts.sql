DROP TABLE IF EXISTS `podcasts`;
CREATE TABLE `podcasts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(145) NOT NULL,
  `feed` varchar(145) NOT NULL,
  `insertion_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(500) DEFAULT NULL,
  `link_on_podcastpedia` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `feed_UNIQUE` (`feed`)
) ENGINE=InnoDB;


INSERT INTO `podcasts` VALUES
  (1,'Quarks & Co - zum Mitnehmen','http://podcast.wdr.de/quarks.xml','2014-01-09 20:21:10','Quarks & Co: Das Wissenschaftsmagazin','http://www.podcastpedia.org/podcasts/1/Quarks-Co-zum-Mitnehmen'),
  (2,'- The Naked Scientists Podcast - Stripping Down Science','http://www.thenakedscientists.com/naked_scientists_podcast.xml','2014-01-09 20:21:10','The Naked Scientists flagship science show brings you a lighthearted look at the latest scientific breakthroughs, interviews with the world top scientists, answers to your science questions and science experiments to try at home.','http://www.podcastpedia.org/podcasts/792/-The-Naked-Scientists-Podcast-Stripping-Down-Science'),
  (3,'NPR: TED Radio Hour Podcast','http://www.npr.org/rss/podcast.php?id=510298','2014-01-09 20:21:10','The TED Radio Hour is a journey through fascinating ideas: astonishing inventions, fresh approaches to old problems, new ways to think and create. Based on Talks given by riveting speakers on the world-renowned TED stage, each show is centered on a common theme - such as the source of happiness, crowd-sourcing innovation, power shifts, or inexplicable connections. The TED Radio Hour is hosted by Guy Raz, and is a co-production of NPR & TED. Follow the show @TEDRadioHour.','http://www.podcastpedia.org/podcasts/1183/NPR-TED-Radio-Hour-Podcast');

