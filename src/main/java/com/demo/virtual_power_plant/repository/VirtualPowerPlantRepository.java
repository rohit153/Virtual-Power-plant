package com.demo.virtual_power_plant.repository;

import com.demo.virtual_power_plant.entity.VirtualPowerPlant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
@Repository
public interface VirtualPowerPlantRepository extends JpaRepository<VirtualPowerPlant,Long> {
}
