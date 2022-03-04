-- Delete database if it already exists
drop database if exists mycuteshop;

-- Create database called inventory
create database mycuteshop;

-- use inventory
use mycuteshop;


-- create table with all fields of a listing
-- TODO : THIS IS INCOMPLETE!
create table shopee(
    shopee_shop_id int not null,
    product_id int not null,
    product_name varchar(256) not null,
    category_name varchar(256) not null,
    product_cover_image varchar(256) not null,
    product_image1 varchar(256),
    product_image2 varchar(256),
    product_image3 varchar(256),
    product_image4 varchar(256),
    product_image5 varchar(256),
    product_image6 varchar(256),
    product_image7 varchar(256),
    product_image8 varchar(256),
    product_description varchar(256) not null,
    brand varchar(62) not null,
    color varchar(62),
    recommended_age varchar(62),
    warranty_type varchar(62),
    material varchar(62),
    price float not null,
    stock int not null,
    product_weight float not null,
    preorder enum('yes','no'),
    shopee_condition enum('new','used'),
    primary key(shopee_shop_id)
);

-- Create ONE-TO-ONE Inventory table to link user with inventory with foreign key 
create table inventory(
    inventory_id int auto_increment not null,
    user_id int not null,
    username varchar(64) not null,
    email varchar(256) not null,
    shopee_shop_id int not null,
    primary key (inventory_id),
    constraint fk_shopee_shop_id foreign key(shopee_shop_id) references shopee(shopee_shop_id)
);

-- CREATE TABLE FOR USER
create table user(
    user_id int auto_increment not null,
    inventory_id int not null,
    name varchar(64) not null,
    email varchar(256) not null,
    username varchar(64) not null,
    password varchar(128) not null,
    primary key (user_id, email, username),
    constraint fk_username_email_id foreign key(inventory_id) references inventory(inventory_id)
);

-- WHEN INSERTING DETAILS OF A USER - ALWAYS HASH THE PASSWORD ! NEVER SAVE THE RAW PASSWORD! 
-- TO EXTRACT IF USER EXISTS, SELECT COUNT(*) 


-- TO BE IMPLEMENTED WITH LAZADA IN THE FUTURE
-- create table lazada(
--     item_id int auto_increment not null,
--     product_name varchar(256) not null,
--     category_name varchar(256) not null,
--     product_cover_image varchar(256) not null,
--     product_image1 varchar(256),
--     product_image2 varchar(256),
--     product_image3 varchar(256),
--     product_image4 varchar(256),
--     product_image5 varchar(256),
--     product_image6 varchar(256),
--     product_image7 varchar(256),
--     product_image8 varchar(256),
--     product_description varchar(256) not null,
--     brand varchar(62) not null,
--     color varchar(62),
--     recommended_age varchar(62),
--     warranty_type varchar(62),
--     material varchar(62),
--     price float not null,
--     stock int not null,
--     product_weight float not null,
--     preorder enum('yes','no'),
--     lazada_condition enum('new','used'),
--     primary key(item_id)
-- );
-- -- Record should then be added to the database using SHOPEE API
