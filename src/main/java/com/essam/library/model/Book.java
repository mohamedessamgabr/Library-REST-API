package com.essam.library.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_price")
    private int price;

    @Column(name = "book_status")
    private String status;


    @ManyToOne
    @JoinColumn(name = "vendor_code")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "library_name")
    private Library library;


    @ManyToOne
    @JoinColumn(name = "publisher_code")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "author_code")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public Book() {
    }

    public Book(String title, int price, String status) {
        this.title = title;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
