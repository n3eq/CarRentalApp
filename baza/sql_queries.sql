use carrental;

CREATE TABLE user(user_id int NOT NULL UNIQUE, user_name varchar(30), password varchar(30), active tinyint(1), roles varchar(30), PRIMARY KEY (user_id));

CREATE TABLE office(office_id int UNIQUE NOT NULL, city varchar(30), zip_code varchar(10), street varchar(30), PRIMARY KEY (office_id));

CREATE TABLE car (car_id int UNIQUE NOT NULL, office_id int NOT NULL,car_type varchar(50), brand varchar(50), model varchar(50), 
production_year int, horsepower int, seats int, price int, avaliable int, PRIMARY KEY (car_id), FOREIGN KEY (office_id) REFERENCES office(office_id));

CREATE TABLE rental (rental_id int UNIQUE NOT NULL, user_id int NOT NULL, car_id int NOT NULL, rental_start_date date, rental_finish_date date,
pickup_city varchar(30), return_city varchar(30), PRIMARY KEY (rental_id), FOREIGN KEY (user_id) REFERENCES user(user_id), FOREIGN KEY (car_id) 
REFERENCES car(car_id));

INSERT INTO user VALUES (1,'user','user',1,'ROLE_USER');
INSERT INTO user VALUES (2,'admin','admin',1,'ROLE_ADMIN');

INSERT INTO office VALUES (1,'krakow','30-300','kosciuszki 32');
INSERT INTO office VALUES (2,'warszawa','10-250','maniuszki 27');
INSERT INTO office VALUES (3,'gdansk','22-310','sienkiewicza 12');

INSERT INTO car VALUES (101,2,'sport','audi','rs7',2019,560,4,4000,1);
INSERT INTO car VALUES (102,3,'sport','audi','s5',2018,410,4,3050,1);
INSERT INTO car VALUES (103,2,'sport','bmw','m2',2016,360,2,2250,1);
INSERT INTO car VALUES (104,1,'sport','bmw','m7',2017,380,4,3300,1);
INSERT INTO car VALUES (105,1,'sport','ford','mustang',2017,350,3,1600,1);
INSERT INTO car VALUES (106,3,'sport','lamborghini','huracan',2020,720,2,9600,1);
INSERT INTO car VALUES (107,2,'family','toyota','rav4',2018,200,5,1900,1);
INSERT INTO car VALUES (108,1,'family','opel','zafira',2017,150,7,1250,1);
INSERT INTO car VALUES (109,1,'family','volvo','xc60',2015,220,7,1600,1);
INSERT INTO car VALUES (110,3,'family','mercedes','cla',2020,450,5,3500,1);
INSERT INTO car VALUES (111,2,'delivery','citroen','jumper',2017,140,3,950,1);
INSERT INTO car VALUES (112,3,'delivery','renault','master',2019,140,3,1200,1);

DELETE FROM rental;
DELETE FROM car;
DELETE FROM office;
DELETE FROM user;

DROP TABLE rental;
DROP TABLE car;
DROP TABLE office;
DROP TABLE user;

SELECT * FROM user;
SELECT * FROM car;
SELECT * FROM office;
SELECT * FROM rental;