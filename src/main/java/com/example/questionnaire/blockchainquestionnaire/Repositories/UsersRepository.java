package com.example.questionnaire.blockchainquestionnaire.Repositories;

import com.example.questionnaire.blockchainquestionnaire.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {



}
