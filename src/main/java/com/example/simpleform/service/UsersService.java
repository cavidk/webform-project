package com.example.simpleform.service;

import com.example.simpleform.model.UsersModel;
import com.example.simpleform.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // * create UserModel function and create a condition on it

    public UsersModel registerUser(String login, String password, String email){
        if (login == null || password == null) {
            return null;
        } else {
            if (usersRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Duplicated Login");
                return null;
            }
            UsersModel usersModel = new UsersModel();
               usersModel.setLogin(login);
               usersModel.setPassword(password);
               usersModel.setEmail(email);
            return usersRepository.save(usersModel);
        }
    }

    // * this is authentication method we ll use method in our service

    public UsersModel authenticate(String login, String password){
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
