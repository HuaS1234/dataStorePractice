package com.example.demo.Service;

import com.example.demo.Data.Plant;
import com.example.demo.Data.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {
    @Autowired
    PlantRepository plantRepository;

    public Long save(Plant plant) {
        return plantRepository.save(plant).getId();

    }

    public Boolean delivered(Long id) {
        return plantRepository.existsPlantByIdAndDeliveryCompleted(id, true);
    }

    public List<Plant> findPlantBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }

    public Plant getPlantByName(String name) {
        return new Plant();
    }
}
