CREATE TABLE `cities` (
  `id`                INT             NOT NULL  AUTO_INCREMENT,
  `version`           INT             NULL      DEFAULT 0,
  `name`              VARCHAR(45)     NOT NULL,
  `state`             VARCHAR(45)     NOT NULL,
  `rate_day`          DECIMAL(12,2)   NOT NULL,
  `rate_night`        DECIMAL(12,2)   NOT NULL,
  `driver_id`         INT,
  `created`           TIMESTAMP       NULL      DEFAULT NOW(),
  `modified`          TIMESTAMP       NULL      DEFAULT NOW(),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)
 );
