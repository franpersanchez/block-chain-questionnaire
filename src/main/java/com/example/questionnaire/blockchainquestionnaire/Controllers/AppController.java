package com.example.questionnaire.blockchainquestionnaire.Controllers;

import com.example.questionnaire.blockchainquestionnaire.Entities.Answers;
import com.example.questionnaire.blockchainquestionnaire.Entities.Choices;
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
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
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

    //Endpoints for the Front-End use
    //Get-questions. It returns the List of questions available for every user.
    @GetMapping(path="/get-questions")
    public List<Questions> getQuestions(){
        return questionsService.getAllQuestions();
    }

    //Get-questions. It returns the List of choices available for every question. Not used in the frontEnd
    @GetMapping(path="/get-choices")
    public List<Choices> getChoices(){
        return choicesService.getAllChoices();
    }

    //Endpoints for the Front-End use
    //Insert answer. Inserts an answer. The answer should come from a front-end SELECT input, thats why it is not needed to be checked with the given
    //choices-options for each question
    @PostMapping(path="/insert-answer/{user_id}/{question_id}")
    public void insertNewAnswer(@PathVariable Long user_id,

                                @RequestBody String[] actualAnswer){
         answersService.insertNewAnswer(actualAnswer, user_id);
    }

    //Endpoints for the Business
    //get answers. It retrieves the answers for an especific user

    @GetMapping(path="/get-answers/{user_id}")
    public List<Answers> getAnswersFromUser(@PathVariable Long user_id){
        return answersService.getAnswersFromUser(user_id);
    }


    //Endpoints for the Business
    //insert choices. Inserts possible choices for an specific question. Maximum of 5 optional choices.
   @PostMapping(path="/insert-choices-to-question/{question_id}")
    public String addChoices(@PathVariable Long question_id,
                             @RequestParam(required=false) String choices1, @RequestParam(required=false) String choices2, @RequestParam(required=false) String choices3,
                             @RequestParam(required=false) String choices4,
                             @RequestBody(required=false) String choices5){

        return choicesService.addChoicesToQuestion( question_id, choices1, choices2, choices3,choices4,choices5 );
    }

    //Endpoints for the Business
    //gCreate-question. Creates new questions for the questionaire. Text should be passed as a query param without " "
    @PostMapping(path="/create-new-question")
    public Questions createNewQuestion(@RequestParam (required=true) String questionText){
        return questionsService.createNewQuestion(new Questions(questionText));
    }


}
