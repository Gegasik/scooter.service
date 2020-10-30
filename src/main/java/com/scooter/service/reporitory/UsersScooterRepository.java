package com.scooter.service.reporitory;

import com.scooter.service.model.UsersAndScootersModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersScooterRepository extends CrudRepository<UsersAndScootersModel, Long> {
    @Query(value = "select us.id,us.user_id,us.scooter_id,us.rent_date,us.duration from users_and_scooters us inner join scooter sc on us.scooter_id=sc.id where us.user_id = ?1", nativeQuery = true)
    List<UsersAndScootersModel> getAllUsersScooters(int id);
}
