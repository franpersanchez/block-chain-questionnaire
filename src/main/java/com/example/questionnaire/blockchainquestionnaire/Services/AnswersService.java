package com.example.questionnaire.blockchainquestionnaire.Services;

import com.example.questionnaire.blockchainquestionnaire.Entities.Answers;
import com.example.questionnaire.blockchainquestionnaire.Entities.Questions;
import com.example.questionnaire.blockchainquestionnaire.Entities.Users;
import com.example.questionnaire.blockchainquestionnaire.Repositories.AnswersRepository;
import com.example.questionnaire.blockchainquestionnaire.Repositories.QuestionsRepository;
import com.example.questionnaire.blockchainquestionnaire.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswersService {

    @Autowired
    private AnswersRepository answersRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    public Answers createNewAnswer(String newAnswer,Long user_id, Long question_id){
        Optional<Users> userFound = usersRepository.findById(user_id);
        Optional<Questions> questionRelated = questionsRepository.findById(question_id);
        Answers answer = new Answers(newAnswer,questionRelated.get(), userFound.get());
        return answersRepository.save(answer);
    }
}
