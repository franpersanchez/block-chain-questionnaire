package com.example.questionnaire.blockchainquestionnaire.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Questions question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Users user;


    public Answers() {
    }

    public Answers(String answer, Questions question, Users user) {
        this.answer = answer;
        this.question = question;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
