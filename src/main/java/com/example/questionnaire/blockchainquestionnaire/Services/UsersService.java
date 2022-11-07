package com.example.questionnaire.blockchainquestionnaire.Services;

import com.example.questionnaire.blockchainquestionnaire.Entities.Users;
import com.example.questionnaire.blockchainquestionnaire.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers(){
        return usersRepository.findAll();

    }

    public Users createNewAccount(Users newUser) {
        return usersRepository.save(newUser);
    }
}
