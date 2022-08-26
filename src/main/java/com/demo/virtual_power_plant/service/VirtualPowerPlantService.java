package com.demo.virtual_power_plant.service;

import com.demo.virtual_power_plant.entity.VirtualPowerPlant;
import com.demo.virtual_power_plant.pojo.VirtualPowerPlantPojo;

import java.util.List;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
public interface VirtualPowerPlantService {
    List<VirtualPowerPlantPojo> save(List<VirtualPowerPlantPojo> virtualPowerPlantPojo);
}
