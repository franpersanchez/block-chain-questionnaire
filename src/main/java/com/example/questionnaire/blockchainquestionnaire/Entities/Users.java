package com.example.questionnaire.blockchainquestionnaire.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="Name")
    private String Name;

    @Column(name="surName")
    private String surName;

    @Column(name="email")
    private String email;

    @OneToMany
    @JsonManagedReference
    @JoinColumn(name = "users_id")
    private List<Answers> answer;




    public Users() {
    }

    public Users(String name, String surName, String email) {
        Name = name;
        this.surName = surName;
        this.email = email;
    }

    @Column(name="Name")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
