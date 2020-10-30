package com.scooter.service;

import com.scooter.service.model.ScooterModel;
import com.scooter.service.reporitory.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@RunWith(SpringRunner.class)
@DataJpaTest()
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUser_whenFindByEmailAndPassword_thenUser() {

        CriteriaBuilder criteriaBuilder = entityManager.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ScooterModel> sc = criteriaBuilder.createQuery(ScooterModel.class);
        Root<ScooterModel> x =sc.from(ScooterModel.class);
        sc.select(sc.from(ScooterModel.class));
        ScooterModel scooterModel= entityManager.getEntityManager().createQuery(sc).getSingleResult();
		System.out.println(scooterModel);
    }
}
