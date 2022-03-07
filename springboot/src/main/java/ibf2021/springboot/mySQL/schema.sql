-- Delete database if it already exists
drop database if exists mycuteshop;

-- Create database called inventory
create database mycuteshop;

-- use inventory
use mycuteshop;

-- CREATE TABLE FOR USER
create table user(
    user_id int auto_increment not null,
    -- Allows duplicate name but not email.
    name varchar(64) not null, 
    email varchar(256) not null,
    shopee_shop_id int not null,
    primary key (user_id, email)
);

create unique index email on user(email);

-- create table with all fields of a listing
-- TODO : THIS IS INCOMPLETE!
create table shopee(
	product_id int not null,
    shopee_shop_id int not null,
    image_thumbnail varchar(256),
    product_name varchar(256),
    product_description varchar(256),
    quantity int,
    price float,
    primary key(product_id),
    constraint fk_shopee_id foreign key(shopee_shop_id) references user(user_id)
);



-- WHEN INSERTING DETAILS OF A USER - ALWAYS HASH THE PASSWORD ! NEVER SAVE THE RAW PASSWORD! 
-- TO EXTRACT IF USER EXISTS, SELECT COUNT(*) 
