package com.essam.library.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_designation")
    private String designation;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToMany
    @JoinTable(name = "send_request",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    private List<Member> memberList;

    public Employee() {
    }

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public void addMember(Member member) {
        if(memberList == null) {
            memberList = new ArrayList<>();
        }
        memberList.add(member);
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
