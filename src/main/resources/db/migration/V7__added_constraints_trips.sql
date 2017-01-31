ALTER TABLE trips ADD CONSTRAINT fk_car_id_trip FOREIGN KEY (car_id) REFERENCES cars(id);
ALTER TABLE trips ADD CONSTRAINT fk_driver_id_trip FOREIGN KEY (driver_id) REFERENCES driver(id);
ALTER TABLE trips ADD CONSTRAINT fk_passenger_id_trip FOREIGN KEY (passenger_id) REFERENCES passengers(id);