package com.example.questionnaire.blockchainquestionnaire.Repositories;

import com.example.questionnaire.blockchainquestionnaire.Entities.Choices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoicesRepository extends JpaRepository<Choices, Long> {
}
