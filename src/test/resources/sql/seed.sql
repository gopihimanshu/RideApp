use rideapptest;

set FOREIGN_KEY_CHECKS =0;
TRUNCATE TABLE cities;
TRUNCATE TABLE drivers;
TRUNCATE TABLE cars;
TRUNCATE TABLE passengers;
set FOREIGN_KEY_CHECKS =1;

INSERT INTO cities(id,name,state,rate_day,rate_night,driver_id) VALUES (1,'Bangalore','Karnataka',50.2,75.2,1);



INSERT INTO drivers(id,name,gender,age,city_id) VALUES (1,'Rakesh','MALE',25,1);
INSERT INTO drivers(id,name,gender,age,city_id) VALUES (2,'Himanshu','MALE',25,1);

INSERT INTO cars(id,name,year,type,driver_id)VALUES (1,'Polo',2016,'BASIC',1);
INSERT INTO cars(id,name,year,type,driver_id)VALUES (2,'Zest',2015,'BASIC',2);
INSERT INTO cars(id,name,year,type,driver_id)VALUES (3,'Honda',2010,'BASIC',1);

INSERT INTO passengers(id,name,gender,age)VALUES (1,'Ram','MALE',25);