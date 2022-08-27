package com.demo.virtual_power_plant.pojo;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "totalWattCapacity watt capacity of battery",name="totalWattCapacity",required=true,value="test totalWattCapacity")
    private double totalWattCapacity;

    @ApiModelProperty(notes = "averageWattCapacity  of battery",name="averageWattCapacity",required=true,value="test averageWattCapacity")
    private double averageWattCapacity;

    @ApiModelProperty(notes = "list of filtered batteryPojos ",name="batteryPojos",required=true,value="test batteryPojos")
    List<BatteryPojo> batteryPojos;


}
