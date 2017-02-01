CREATE TABLE `trips`
(
  `id`           INT NOT NULL auto_increment,
  `version`         INT NULL DEFAULT 0,
  `start`        TIMESTAMP NULL DEFAULT Now(),
  `end`          TIMESTAMP NULL,
  `total_time`   INT NULL DEFAULT 0,
  `car_id`       INT NOT NULL,
  `driver_id`    INT NOT NULL,
  `passenger_id` INT NOT NULL,
  `distance`     DECIMAL(10, 2) NULL DEFAULT 0,
  `cost`         DECIMAL(10, 2) NULL DEFAULT 0,
  `tips_per`     DECIMAL(10, 2) NULL DEFAULT 0,
  `total_cost`   DECIMAL(10, 2) NULL DEFAULT 0,
  `created`         TIMESTAMP NULL DEFAULT Now(),
  `modified`        TIMESTAMP NULL DEFAULT Now(),
  PRIMARY KEY (`id`)
);