drop database if exists library;
create database library;

use library;

drop table if exists library_admin;
create table library_admin(
	admin_id int not null auto_increment,
    admin_name varchar(48),
    admin_role varchar(48),
    
    primary key(admin_id)
);

drop table if exists library;
create table library (
	library_name varchar(48) not null,
    address varchar(48),
    contact_no varchar(48),
    admin_id int,
    
    primary key(library_name),
    constraint FK_admin_library foreign key(admin_id) references library_admin(admin_id)
);

drop table if exists author;
create table author(
	author_code int not null,
    author_name varchar(48) not null,
    author_qualification varchar(48),
    author_subject varchar(48),
    
    primary key(author_code)
);

drop table if exists library_member;
create table library_member (
	member_id int not null auto_increment,
    member_name varchar(48) not null,
    member_address varchar(48),
    member_contact varchar(48),
    member_type varchar(48),
    
    primary key(member_id)
);


drop table if exists employee;
create table employee (
	employee_id int not null auto_increment,
    employee_name varchar(48) not null,
    employee_designation varchar(48),
    admin_id int,
    
    primary key(employee_id),
    constraint FK_admin_employee foreign key(admin_id) references library_admin(admin_id)
);


drop table if exists vendor;
create table vendor (
	vendor_code int not null auto_increment,
    vendor_name varchar(48) not null,
    
    primary key(vendor_code)
);


drop table if exists publisher;
create table publisher (
	publisher_code int not null auto_increment,
    publisher_name varchar(48) not null,
    publisher_country varchar(48),
    
    primary key(publisher_code)
);


drop table if exists send_request;
create table send_request(
	member_id int,
    employee_id int,
    
    constraint employee_member unique(member_id, employee_id),
    constraint FK_send_request_member foreign key(member_id) references library_member(member_id),
    constraint FK_send_request_employee foreign key(employee_id) references employee(employee_id)
    
);

drop table if exists book;
create table book(
	book_id int not null auto_increment,
    book_title varchar(48) not null,
    book_price int,
    book_status varchar(48),
    
    vendor_code int,
    library_name varchar(48),
    publisher_code int,
    author_code int, 
    employee_id int,
    
    primary key(book_id),
    
	constraint FK_vendor_book foreign key(vendor_code) references vendor(vendor_code),
    constraint FK_library_book foreign key(library_name) references library(library_name),
    constraint FK_publisher_book foreign key(publisher_code) references publisher(publisher_code),
    constraint FK_author_book foreign key(author_code) references author(author_code),
    constraint FK_employee_book foreign key(employee_id) references employee(employee_id)
    
);