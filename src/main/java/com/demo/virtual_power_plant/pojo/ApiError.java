package com.demo.virtual_power_plant.pojo;

import com.demo.virtual_power_plant.enums.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private ResponseStatus status;
    private int httpCode;
    private Date dateTime;
    @JsonProperty("message")
    private String message;
    @JsonProperty("errors")
    private List<String> errors;

    public ApiError(ResponseStatus status, final int httpCode, final String message, final String error,Date dateTime) {
        super();
        this.status = status;
        this.httpCode = httpCode;
        this.message = message;
        this.dateTime=dateTime;
        errors = Arrays.asList(error);
    }
}
