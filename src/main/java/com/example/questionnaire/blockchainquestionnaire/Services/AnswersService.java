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

    public void insertNewAnswer(String[] answers,Long user_id){
        Users userFound = usersRepository.findById(user_id).isPresent()?usersRepository.findById(user_id).get():null;

        for(int iq=1; iq<answers.length+1;iq++) {
                Questions questionRelated = questionsRepository.findById((long) iq).isPresent() ? questionsRepository.findById((long) iq).get() : null;
                answersRepository.save(new Answers(answers[iq-1], questionRelated, userFound));

        }
          }





    public List<Answers> getAnswersFromUser(Long user_id) {

        return answersRepository.findAllByUserId(user_id);
    }


}
