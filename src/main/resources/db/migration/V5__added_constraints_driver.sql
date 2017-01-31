ALTER TABLE drivers ADD city_id INT NOT NULL;
ALTER TABLE drivers ADD CONSTRAINT fk_city_id FOREIGN KEY (city_id) REFERENCES cities(id);


ALTER TABLE cars ADD driver_id INT NOT NULL;
ALTER TABLE cars ADD CONSTRAINT fk_driver_id FOREIGN KEY (driver_id) REFERENCES drivers(id);