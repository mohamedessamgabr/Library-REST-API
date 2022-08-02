package com.essam.library.model;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_code")
    private int code;

    @Column(name = "author_name")
    private String name;

    @Column(name = "author_qualification")
    private String qualification;

    @Column(name = "author_subject")
    private String subject;

    public Author() {
    }

    public Author(String name, String qualification, String subject) {
        this.name = name;
        this.qualification = qualification;
        this.subject = subject;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Author{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
