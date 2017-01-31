CREATE TABLE `passengers`
(
  `id`       INT NOT NULL auto_increment,
  `version`  INT NOT NULL DEFAULT 0,
  `name`     VARCHAR(45) NOT NULL,
  `age`      INT NOT NULL,
  `gender`   ENUM('MALE', 'FEMALE') NOT NULL,
  `amount`   DECIMAL(12, 2) NULL DEFAULT 0.0,
  `created`  TIMESTAMP NULL DEFAULT Now(),
  `modified` TIMESTAMP NULL DEFAULT Now(),
  PRIMARY KEY (`id`)
);