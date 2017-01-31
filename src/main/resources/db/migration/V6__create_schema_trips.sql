CREATE TABLE `trips`
(
  `id`           INT NOT NULL auto_increment,
  `start`        TIMESTAMP NULL DEFAULT Now(),
  `end`          TIMESTAMP NULL,
  `total_time`   INT NULL,
  `car_id`       INT NOT NULL,
  `driver_id`    INT NOT NULL,
  `passenger_id` INT NOT NULL,
  `distance`     DECIMAL(10, 2) NULL DEFAULT 0,
  `cost`         DECIMAL(10, 2) NULL DEFAULT 0,
  `tips_per`     DECIMAL(10, 2) NULL DEFAULT 0,
  `total_cost`   DECIMAL(10, 2) NULL DEFAULT 0,
  PRIMARY KEY (`id`)
);