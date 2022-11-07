package com.example.questionnaire.blockchainquestionnaire.Services;

import com.example.questionnaire.blockchainquestionnaire.Entities.Questions;
import com.example.questionnaire.blockchainquestionnaire.Entities.Users;
import com.example.questionnaire.blockchainquestionnaire.Repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    public Questions createNewQuestion(Questions newQuestion) {
        return questionsRepository.save(newQuestion);
    }
}

