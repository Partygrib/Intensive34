INSERT INTO db1.orders(name, order_date) VALUES ('disk', '2023-04-17');
INSERT INTO db1.orders(name, order_date) VALUES ('monitor', '2023-08-08');
INSERT INTO db1.orders(name, order_date) VALUES ('laptop', '2022-09-11');
INSERT INTO db1.orders(name, order_date) VALUES ('headphones', '2023-07-09');
INSERT INTO db1.orders(name, order_date) VALUES ('cable', '2023-01-13');

INSERT INTO db1.users(name, surname, middle_name, number, email, order_id)
VALUES ('Ivan', 'Ivanov', 'Ivanovich', '+79993332211', 'ivan@mail.ru', 1);
INSERT INTO db1.users(name, surname, middle_name, number, email, order_id)
VALUES ('Gleb', 'Khmarenko', 'Igorevich', '+79993133266', 'partygrib@gmail.com', 3);
INSERT INTO db1.users(name, surname, number, email, order_id)
VALUES ('Anatoliy', 'Bogsmen', '+76563234442', 'anatol@mail.ru', 2);
INSERT INTO db1.users(name, surname, middle_name, number, email, order_id)
VALUES ('Igor', 'Okonma', 'Gregory', '+79001001234', 'tyler_the_creator@mail.ru', 4);