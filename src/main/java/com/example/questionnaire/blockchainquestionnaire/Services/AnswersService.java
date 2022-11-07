package com.example.questionnaire.blockchainquestionnaire.Services;

import com.example.questionnaire.blockchainquestionnaire.Entities.Answers;
import com.example.questionnaire.blockchainquestionnaire.Entities.Questions;
import com.example.questionnaire.blockchainquestionnaire.Entities.Users;
import com.example.questionnaire.blockchainquestionnaire.Repositories.AnswersRepository;
import com.example.questionnaire.blockchainquestionnaire.Repositories.QuestionsRepository;
import com.example.questionnaire.blockchainquestionnaire.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Users userFound = usersRepository.findById(user_id).isPresent()?usersRepository.findById(user_id).get():null;
        Questions questionRelated = questionsRepository.findById(question_id).isPresent()?questionsRepository.findById(question_id).get():null;
        Answers answer = new Answers(newAnswer,questionRelated, userFound);

        return answersRepository.save(answer);
    }

    public List<Answers> getAnswersFromUser(Long user_id) {

        return answersRepository.findAllByUserId(user_id);
    }
}
