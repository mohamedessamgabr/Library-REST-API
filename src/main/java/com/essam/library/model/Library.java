package com.essam.library.model;

import javax.persistence.*;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @Column(name = "library_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_no")
    private String contactNo;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Library() {
    }

    public Library(String name, String address, String contactNo, Admin admin) {
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }



    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", admin=" + admin +
                '}';
    }
}
