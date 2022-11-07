package com.example.questionnaire.blockchainquestionnaire.Controllers;

import com.example.questionnaire.blockchainquestionnaire.Entities.Users;

import com.example.questionnaire.blockchainquestionnaire.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private UsersService usersService;

    @GetMapping(path="/get-questions")
    public List<Users> getQuestions(){

        return usersService.getAllUsers();

    }
}
