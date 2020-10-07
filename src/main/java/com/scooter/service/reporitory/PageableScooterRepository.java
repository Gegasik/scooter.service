package com.scooter.service.reporitory;

import com.scooter.service.model.ScooterModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface PageableScooterRepository extends PagingAndSortingRepository <ScooterModel,Long> {
    @Query(value="select sc.id,sc.name, sc.is_electric, sc.description,sc.image, sc.cost_per_hour, sc.producer_id from scooter sc left join users_and_scooters on sc.id=users_and_scooters.id where users_and_scooters.scooter_id is null",nativeQuery = true)
    List<ScooterModel> getFreeScoots(Pageable pageable);
    Integer countAll();

}
