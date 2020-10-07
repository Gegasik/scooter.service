package com.scooter.service.reporitory;

import com.scooter.service.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Integer> {
    public UserModel findByEmail(String email);
    public UserModel findByLogin(String name);
    public UserModel findByLoginAndPassword(String name, String pass);
}
