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

   /* public Questions getQuestions() {
        return questions;
    }*/

  /*  public void setQuestions(Questions questions) {
        this.questions = questions;
    }*/

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getChoice5() {
        return choice5;
    }

    public void setChoice5(String choice5) {
        this.choice5 = choice5;
    }
}