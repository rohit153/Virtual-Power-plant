package com.demo.virtual_power_plant.pojo;

import com.demo.virtual_power_plant.constant.MessageConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirtualPowerPlantPojo {
    @JsonInclude(NON_NULL)
    @JsonProperty("id")
    private Long id;

    @NotNull(message = MessageConstants.NAMENOTNULL)
    private String name;

    @NotNull(message = MessageConstants.POSTCODENOTNULL)
    private String postcode;

    @NotNull(message = MessageConstants.CAPACITYNOTNULL)
    private int capacity;
}
