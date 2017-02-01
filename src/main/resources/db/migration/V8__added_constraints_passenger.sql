ALTER TABLE passengers ADD city_id INT NULL;
ALTER TABLE passengers ADD CONSTRAINT fk_city_id_passenger FOREIGN KEY (city_id) REFERENCES cities(id);