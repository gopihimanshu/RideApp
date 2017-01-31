use rideapptest;

TRUNCATE TABLE cities;
TRUNCATE TABLE drivers;
TRUNCATE TABLE cars;
TRUNCATE TABLE passengers;

insert into cities(id,name,state,rate_day,rate_night,driver_id) values(1,'Bangalore','Karnataka',50.2,75.2,1);
INSERT INTO drivers(id,name,gender,age) VALUES (1,'Rakesh','MALE',25);
INSERT INTO cars(id,name,year,type)values(1,'Polo',2016,'BASIC');
INSERT INTO passengers(id,name,gender,age)values(1,'Ram','MALE',25);