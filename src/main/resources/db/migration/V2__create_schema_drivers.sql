CREATE TABLE `drivers`
(
  `id`                  INT NOT NULL auto_increment,
  `version`             INT NULL DEFAULT 0,
  `name`                VARCHAR(45) NOT NULL,
  `gender`              ENUM('MALE', 'FEMALE') NOT NULL,
  `age`                 INT NOT NULL,
  `number_of_violation` INT NULL DEFAULT 0,
  `is_valid`            TINYINT NULL DEFAULT 1,
  `created`             TIMESTAMP NULL DEFAULT Now(),
  `modified`            TIMESTAMP NULL DEFAULT Now(),
  PRIMARY KEY (`id`)
);