package com.scooter.service.reporitory;

import com.scooter.service.model.UserModel;
import org.apache.catalina.User;
import org.hibernate.SessionFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Iterator;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Integer> {
    public UserModel findByEmail(String email);
    public UserModel findByEmailAndPassword(String email, String pass);
}
