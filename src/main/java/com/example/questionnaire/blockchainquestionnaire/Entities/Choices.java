package com.example.questionnaire.blockchainquestionnaire.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Choices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToOne
    @JoinColumn(name = "questions_id")
    private Questions questions;


    @Column(name = "Choice1")
    private String choice1 = null;

    @Column(name = "Choice2")
    private String choice2 = null;

    @Column(name = "Choice3")
    private String choice3 = null;

    @Column(name = "Choice4")
    private String choice4 = null;

    @Column(name = "Choice5")
    private String choice5 = null;

    public Choices() {
    }

    public Choices(Questions questions, String choice1, String choice2, String choice3, String choice4, String choice5) {
        this.questions = questions;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.choice5 = choice5;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}