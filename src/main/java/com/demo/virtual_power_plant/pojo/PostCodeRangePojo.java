package com.demo.virtual_power_plant.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCodeRangePojo {
    private int firstRangeParameter;
    private int lastRangeParameter;

}
