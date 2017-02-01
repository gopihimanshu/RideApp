use rideapptest;

set FOREIGN_KEY_CHECKS =0;
TRUNCATE TABLE cities;
TRUNCATE TABLE drivers;
TRUNCATE TABLE cars;
TRUNCATE TABLE passengers;
TRUNCATE TABLE trips;
set FOREIGN_KEY_CHECKS =1;

INSERT INTO cities(id,name,state,rate_day,rate_night,driver_id) VALUES (1,'Bangalore','Karnataka',50.2,75.2,1);

INSERT INTO drivers(id,name,gender,age,city_id) VALUES (1,'Rakesh','MALE',25,1);
INSERT INTO drivers(id,name,gender,age,city_id) VALUES (2,'Himanshu','MALE',25,1);

INSERT INTO cars(id,name,year,type,driver_id)VALUES (1,'Polo',2016,'BASIC',1);
INSERT INTO cars(id,name,year,type,driver_id)VALUES (2,'Zest',2015,'BASIC',2);
INSERT INTO cars(id,name,year,type,driver_id)VALUES (3,'Honda',2010,'BASIC',1);

INSERT INTO passengers(id,name,gender,age,city_id)VALUES (1,'Ram','MALE',25,1);
INSERT INTO passengers(id,name,gender,age,amount,city_id)VALUES (2,'Lakshman','MALE',25,15000,1);

INSERT INTO trips(id,car_id,passenger_id,driver_id,distance) values(1,1,2,2,40);
INSERT INTO trips(id,car_id,passenger_id,driver_id,distance) values(2,1,1,1,40);
INSERT INTO trips(id,car_id,passenger_id,driver_id,distance) values(3,1,2,2,40);