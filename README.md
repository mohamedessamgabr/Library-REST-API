# Library-REST-API
REST API for library Management System

# Tools and Technologies
MySQL and Intellij.
Java, Spring Boot, MySQL Database, Maven, Spring Data JPA.



# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/library <br/>
spring.datasource.username=the username<br/>
spring.datasource.password= the password<br/>

## Sql query
drop database if exists library; <br/>
create database library; <br/>

use library; <br/>

drop table if exists library_admin; <br/>
create table library_admin(
	admin_id int not null auto_increment,
    admin_name varchar(48),
    admin_role varchar(48),
    primary key(admin_id)
); <br/>

drop table if exists library; <br/>
create table library (
	library_name varchar(48) not null,
    address varchar(48),
    contact_no varchar(48),
    admin_id int,
    primary key(library_name),
    constraint FK_admin_library foreign key(admin_id) references library_admin(admin_id)
); <br/>

drop table if exists author; <br/>
create table author(
	author_code int not null auto_increment,
    author_name varchar(48) not null,
    author_qualification varchar(48),
    author_subject varchar(48),
    primary key(author_code)
); <br/>

drop table if exists library_member; <br/>
create table library_member (
	member_id int not null auto_increment,
    member_name varchar(48) not null,
    member_address varchar(48),
    member_contact varchar(48),
    member_type varchar(48),
    primary key(member_id)
); <br/>


drop table if exists employee; <br/>
create table employee (
	employee_id int not null auto_increment,
    employee_name varchar(48) not null,
    employee_designation varchar(48),
    admin_id int,
    primary key(employee_id),
    constraint FK_admin_employee foreign key(admin_id) references library_admin(admin_id)
); <br/>


drop table if exists vendor; <br/>
create table vendor (
	vendor_code int not null auto_increment,
    vendor_name varchar(48) not null,
    primary key(vendor_code)
); <br/>


drop table if exists publisher; <br/>
create table publisher (
	publisher_code int not null auto_increment,
    publisher_name varchar(48) not null,
    publisher_country varchar(48),
    primary key(publisher_code)
); <br/>


drop table if exists send_request; <br/>
create table send_request(
	member_id int,
    employee_id int,
    constraint employee_member unique(member_id, employee_id),
    constraint FK_send_request_member foreign key(member_id) references library_member(member_id),
    constraint FK_send_request_employee foreign key(employee_id) references employee(employee_id)
); <br/>

drop table if exists book; <br/>
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
 <br/>

# API Features
## Admin
Add Admin (POST): http://localhost:8080/admin/admins/
Get Admins (GET): http://localhost:8080/admin/admins/

## Book
Add Book (POST): http://localhost:8080/add-book
Get Books (GET): http://localhost:8080/books
Add book to library (PUT): http://localhost:8080/add-book-to-library
Vendor sells Book (PUT): http://localhost:8080/vendor-sells-book
Publish Book (PUT): http://localhost:8080/publish-book
Assign author to book(PUT): http://localhost:8080/assign-author-to-book
Employee issue book (PUT): http://localhost:8080/employee-issue-receive-book

## Vendor
Add Vendor (POST): http://localhost:8080/add-vendor
Get All Vendors (GET):http://localhost:8080/vendors

## Publisher
Add Publisher (POST): http://localhost:8080/add-publisher
Get All Publisher (GET):http://localhost:8080/publishers

## Publisher
Add Author (POST): http://localhost:8080/add-author
Get All Authors (GET):http://localhost:8080/authors



## Library
Add Author (POST): http://localhost:8080/library/libraries
Get All Authors (GET): http://localhost:8080/library/libraries
Admin Manage library(POST): http://localhost:8080/library/assign-admin











