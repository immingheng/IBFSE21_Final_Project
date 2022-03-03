-- Delete database if it already exists
drop database if exists inventory;

-- Create database called inventory
create database inventory;

-- use inventory
use inventory;

-- create table with all fields of a listing
-- TODO : THIS IS INCOMPLETE!
create table shopee(
    item_id int auto_increment not null,
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
    condition enum('new','used'),
    primary key(item_id);
);


create table lazada(
    item_id int auto_increment not null,
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
    condition enum('new','used'),
    primary key(item_id);
);
-- Record should then be added to the database using SHOPEE API
