package com.example.simpleform.repository;

import com.example.simpleform.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

     Optional<UsersModel> findByLoginAndPassword(String login,String password);

     Optional<UsersModel> findFirstByLogin(String login);
}
