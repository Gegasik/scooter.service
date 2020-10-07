package com.scooter.service.reporitory;

import com.scooter.service.model.ScooterModel;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.hibernate.Session;

@Repository
public interface ScooterRepository extends CrudRepository<ScooterModel, Long> {
    @Query(value="select sc.id,sc.name, sc.is_electric, sc.description,sc.image, sc.cost_per_hour, sc.producer_id from scooter sc left join users_and_scooters on sc.id=users_and_scooters.id where users_and_scooters.scooter_id is null",nativeQuery = true)
    List<ScooterModel> getFreeScoots();

}
    //select scooter.id,scooter.is_electric,scooter.cost_per_hour,scooter.producer_id from scooter inner join users_and_scooters on scooter.id= users_and_scooters.user_id where user_id =id
