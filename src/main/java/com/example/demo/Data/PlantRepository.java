package com.example.demo.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository

public interface PlantRepository extends JpaRepository<Plant, Long> {

    //check if a plant by this id exists where delivery has been completed
    Boolean existsPlantByIdAndDeliveryCompleted(Long id, Boolean delivered);

    //return a primitive directly
    @Query("select p.delivery.completed from Plant p where p.id = :plantId")
    Boolean deliveryCompleted(Long plantId);

    //to return a wrapper class, may need to construct it as a projection
    @Query("select new java.lang.Boolean(p.deliver.completed) from Plant p where p.id = :plantId")
    Boolean deliveryCompletedBoolean(Long plantId);

    //we can do this entirely with the method name
    List<Plant> findByPriceLessThan(BigDecimal price);



}
