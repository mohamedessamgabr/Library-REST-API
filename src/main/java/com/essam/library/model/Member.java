package com.essam.library.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_address")
    private String address;

    @Column(name = "member_contact")
    private String contact;

    @Column(name = "member_type")
    private String type;

    @ManyToMany
    @JoinTable(
            name = "send_request",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employeeList;

    public Member() {
    }

    public Member(String name, String address, String contact, String type) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.type = type;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
