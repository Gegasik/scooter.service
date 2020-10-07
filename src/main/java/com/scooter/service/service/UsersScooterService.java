package com.scooter.service.service;

import com.scooter.service.model.BasicEntity;
import com.scooter.service.model.ScooterModel;
import com.scooter.service.model.UsersAndScootersModel;
import com.scooter.service.reporitory.UsersScooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersScooterService extends AbstractService {
    @Autowired
    UsersScooterRepository repository;

    public UsersScooterService(UsersScooterRepository repository) {
        super(repository);
    }

    public List<UsersAndScootersModel> getAllUsersScooters(int id) {

        return repository.getAllUsersScooters(id);
    }
}
