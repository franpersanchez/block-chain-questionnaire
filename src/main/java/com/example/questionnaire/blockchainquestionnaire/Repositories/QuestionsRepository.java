package com.example.questionnaire.blockchainquestionnaire.Repositories;

import com.example.questionnaire.blockchainquestionnaire.Entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {
}
