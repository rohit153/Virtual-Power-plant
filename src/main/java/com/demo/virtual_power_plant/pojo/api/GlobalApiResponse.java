package com.demo.virtual_power_plant.pojo.api;

import com.demo.virtual_power_plant.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GlobalApiResponse implements Serializable {
    private ResponseStatus status;
    private String message;
    private Date dateTime;
    private Object data;



    public void setResponse(String message, ResponseStatus status, Object data, Date date) {
        this.message = message;
        this.status = status;
        this.data = data;
        this.dateTime = date;
    }
}
