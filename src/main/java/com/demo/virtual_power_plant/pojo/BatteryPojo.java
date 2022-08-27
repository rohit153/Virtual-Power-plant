package com.demo.virtual_power_plant.pojo;

import com.demo.virtual_power_plant.constant.MessageConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
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
public class BatteryPojo {
    @JsonInclude(NON_NULL)
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty(notes = "Name of the battery",name="name",required=true,value="test name")
    @NotNull(message = MessageConstants.NAMENOTNULL)
    private String name;

    @ApiModelProperty(notes = "postcode of the battery",name="postcode",required=true,value="test postcode")
    @NotNull(message = MessageConstants.POSTCODENOTNULL)
    private String postcode;

    @ApiModelProperty(notes = "capacity of the battery",name="capacity",required=true,value="test capacity")
    @NotNull(message = MessageConstants.CAPACITYNOTNULL)
    private int capacity;
}
