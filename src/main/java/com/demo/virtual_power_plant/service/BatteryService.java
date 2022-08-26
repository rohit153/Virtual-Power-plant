package com.demo.virtual_power_plant.service;

import com.demo.virtual_power_plant.pojo.BatteryPojo;
import com.demo.virtual_power_plant.pojo.BatteryStasticsPojo;
import com.demo.virtual_power_plant.pojo.PostCodeRangePojo;

import java.util.List;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
public interface BatteryService {
    List<BatteryPojo> save(List<BatteryPojo> batteryPojo);
  BatteryStasticsPojo getBatteriesList(PostCodeRangePojo postCodeRangePojo);
}
