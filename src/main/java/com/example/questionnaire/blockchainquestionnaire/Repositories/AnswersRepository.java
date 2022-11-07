package com.example.questionnaire.blockchainquestionnaire.Repositories;

import com.example.questionnaire.blockchainquestionnaire.Entities.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long> {
    List<Answers> findAllByUserId(Long user_id);



    }
