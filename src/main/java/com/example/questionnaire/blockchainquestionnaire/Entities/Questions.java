package com.example.questionnaire.blockchainquestionnaire.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "questions")
    private String question;

    @OneToMany
    @JsonManagedReference
    @JoinColumn(name = "questions_id")
    private List<Answers> answers = new ArrayList<>();


    public Questions() {
    }
    public Questions(String question){
            this.question=question;
    }

    public Questions(String question, List<Answers> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
}
