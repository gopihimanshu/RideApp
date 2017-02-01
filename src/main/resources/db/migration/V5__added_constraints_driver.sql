ALTER TABLE drivers ADD city_id INT NOT NULL;
ALTER TABLE drivers ADD CONSTRAINT fk_city_id FOREIGN KEY (city_id) REFERENCES cities(id);


