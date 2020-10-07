package com.scooter.service.service;

import com.scooter.service.model.UserModel;
import com.scooter.service.reporitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends AbstractService {

    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        super(repository);
    }

    public Optional<UserModel> findByLogin(String name) {
        return Optional.of(repository.findByLogin(name));
    }

    public UserModel findByNameAndPassword(String name, String pass) {
        return repository.findByLoginAndPassword(name, pass);
    }

}
