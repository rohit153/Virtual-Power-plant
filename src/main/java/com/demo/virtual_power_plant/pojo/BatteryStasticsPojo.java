package com.demo.virtual_power_plant.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatteryStasticsPojo {
    private double totalWattCapacity;
    private double averageWattCapacity;
    List<BatteryPojo> batteryPojos;


}
