package com.example.questionnaire.blockchainquestionnaire.Controllers;

import com.example.questionnaire.blockchainquestionnaire.Entities.Answers;
import com.example.questionnaire.blockchainquestionnaire.Entities.Questions;
import com.example.questionnaire.blockchainquestionnaire.Entities.Users;

import com.example.questionnaire.blockchainquestionnaire.Repositories.AnswersRepository;
//import com.example.questionnaire.blockchainquestionnaire.Repositories.ChoicesRepository;
import com.example.questionnaire.blockchainquestionnaire.Services.AnswersService;
//import com.example.questionnaire.blockchainquestionnaire.Services.ChoicesService;
import com.example.questionnaire.blockchainquestionnaire.Services.ChoicesService;
import com.example.questionnaire.blockchainquestionnaire.Services.QuestionsService;
import com.example.questionnaire.blockchainquestionnaire.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class AppController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private AnswersService answersService;

    @Autowired
    private ChoicesService choicesService;

    @GetMapping(path="/get-questions")
    public List<Questions> getQuestions(){
        return questionsService.getAllQuestions();
    }

    @GetMapping(path="/get-answers/{user_id}")
    public List<Answers> getAnswersFromUser(@PathVariable Long user_id){
        return answersService.getAnswersFromUser(user_id);
    }

    @PostMapping(path="/insert-answers/{user_id}")
    public String insertAnswers(@PathVariable Long user_id,
                                @RequestBody long question_id
                                ){
        return null;
    }

   @PostMapping(path="/insert-to-question/{question_id}")
    public String addChoices(@PathVariable Long question_id,
                             @RequestParam(required=false) String choices1, @RequestParam(required=false) String choices2, @RequestParam(required=false) String choices3,
                             @RequestParam(required=false) String choices4,
                             @RequestBody(required=false) String choices5){

        return choicesService.addChoicesToQuestion( question_id, choices1, choices2, choices3,choices4,choices5 );
    }


}
