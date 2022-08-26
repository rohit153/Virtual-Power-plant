package com.demo.virtual_power_plant.repository;

import com.demo.virtual_power_plant.entity.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {
    @Query(value = "select * from battery where post_code BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Battery> findByPostCodeRange(int firstRangeParameter, int lastRangeParameter);
}
