CREATE TABLE `cars`
(
  `id`              INT NOT NULL auto_increment,
  `version`         INT NULL DEFAULT 0,
  `name`            VARCHAR(45) NOT NULL,
  `make`            VARCHAR(45) NULL,
  `model`           VARCHAR(45) NULL,
  `year`            INT NOT NULL,
  `type`            ENUM('BASIC', 'LUX') NOT NULL,
  `additional_cost` INT NULL DEFAULT 0,
  `created`         TIMESTAMP NULL DEFAULT Now(),
  `modified`        TIMESTAMP NULL DEFAULT Now(),
  PRIMARY KEY (`id`)
);
