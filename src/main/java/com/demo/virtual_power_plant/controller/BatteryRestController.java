package com.demo.virtual_power_plant.controller;

import com.demo.virtual_power_plant.constant.MessageConstants;
import com.demo.virtual_power_plant.controller.baserestcontroller.BaseApiConfig;
import com.demo.virtual_power_plant.pojo.BatteryStasticsPojo;
import com.demo.virtual_power_plant.pojo.PostCodeRangePojo;
import com.demo.virtual_power_plant.pojo.api.GlobalApiResponse;
import com.demo.virtual_power_plant.pojo.BatteryPojo;
import com.demo.virtual_power_plant.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BatteryRestController extends BaseApiConfig {
    private final BatteryService batteryService;

    /**
     * @param batteryPojo
     * @param bindingResult
     * @return GlobalApiResponse
     */

    @PostMapping("/save")
    public ResponseEntity<GlobalApiResponse> saveVirtualPowerPlant(@RequestBody @Valid List<BatteryPojo> batteryPojo, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            List<BatteryPojo> powerPlantPojo = batteryService.save(batteryPojo);
            return ResponseEntity.ok(successResponse(customMessageSource.get(MessageConstants.BATTERY_SUCESS), powerPlantPojo));
        } else {
            return ResponseEntity.ok(errorResponse(customMessageSource.get(MessageConstants.ERROR_DEFAULT, customMessageSource.get(MessageConstants.BATTERY_ERROR)), bindingResult));
        }
    }

    /**
     * @param postCodeRangePojo
     * @return BatteryStastics and  list of batteries
     */
    @PostMapping("/get-batteries")
    public ResponseEntity<GlobalApiResponse> getPostCodeRangeBatteries(@RequestBody PostCodeRangePojo postCodeRangePojo) {
        BatteryStasticsPojo batteryStasticsPojo = batteryService.getBatteriesList(postCodeRangePojo);
        return ResponseEntity.ok(successResponse(customMessageSource.get(MessageConstants.BATTERY_FETCH), batteryStasticsPojo));

    }


}
