package com.example.questionnaire.blockchainquestionnaire;

//import com.example.questionnaire.blockchainquestionnaire.Entities.Choices;
import com.example.questionnaire.blockchainquestionnaire.Entities.Questions;
import com.example.questionnaire.blockchainquestionnaire.Entities.Users;
import com.example.questionnaire.blockchainquestionnaire.Repositories.AnswersRepository;
import com.example.questionnaire.blockchainquestionnaire.Services.AnswersService;
import com.example.questionnaire.blockchainquestionnaire.Services.QuestionsService;
import com.example.questionnaire.blockchainquestionnaire.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataLoader implements ApplicationRunner {

    private UsersService usersService;
    public QuestionsService questionsService;
    public AnswersService answersService;

    @Autowired
    public DataLoader(UsersService service, QuestionsService service2, AnswersService service3){
        this.usersService=service;
        this.questionsService=service2;
        this.answersService=service3;
    }




    @Override
    public void run(ApplicationArguments args) throws Exception {
        usersService.createNewAccount(new Users("Fran", "Perez Sanchez","fsfsaf@gmail.com"));
        usersService.createNewAccount(new Users("Tomas", "Lageira","tomaswhatever@gmail.com"));

      questionsService.createNewQuestion((new Questions("How big is your House?")));

        answersService.createNewAnswer("100", 2L,1L);
        answersService.createNewAnswer("really big", 2L,2L);



    }
}