package com.example.questionnaire.blockchainquestionnaire.Services;

import com.example.questionnaire.blockchainquestionnaire.Entities.Choices;
import com.example.questionnaire.blockchainquestionnaire.Entities.Questions;
import com.example.questionnaire.blockchainquestionnaire.Repositories.ChoicesRepository;
import com.example.questionnaire.blockchainquestionnaire.Repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ChoicesService {

    @Autowired
    private ChoicesRepository choicesRepository;

    @Autowired
    private QuestionsRepository questionsRepository;


    public String addChoicesToQuestion(long question_id, String choice1, String choice2, String choice3, String choice4,
                                       String choice5) {
        Questions questionSelected = questionsRepository.findById(question_id).isPresent() ? questionsRepository.findById(question_id).get() : null;
        if (questionSelected!=null){
            Choices choicesSent = new Choices(questionSelected, choice1, choice2, choice3, choice4, choice5);
            choicesRepository.save(choicesSent);
            return "Choices Saved successfully";
        }
        else{
            return "No question found for that ID";
        }

    }


}
