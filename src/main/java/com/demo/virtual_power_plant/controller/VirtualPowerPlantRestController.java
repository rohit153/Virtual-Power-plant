package com.demo.virtual_power_plant.controller;

import com.demo.virtual_power_plant.constant.MessageConstants;
import com.demo.virtual_power_plant.controller.baserestcontroller.BaseApiConfig;
import com.demo.virtual_power_plant.pojo.GlobalApiResponse;
import com.demo.virtual_power_plant.pojo.VirtualPowerPlantPojo;
import com.demo.virtual_power_plant.service.VirtualPowerPlantService;
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
public class VirtualPowerPlantRestController extends BaseApiConfig {
    private final VirtualPowerPlantService virtualPowerPlantService;

    /**
     *
     * @param virtualPowerPlantPojo
     * @param bindingResult
     * @return GlobalApiResponse
     */

    @PostMapping("/save")
    public ResponseEntity<GlobalApiResponse> saveVirtualPowerPlant(@RequestBody @Valid List<VirtualPowerPlantPojo> virtualPowerPlantPojo, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            List<VirtualPowerPlantPojo> powerPlantPojo = virtualPowerPlantService.save(virtualPowerPlantPojo);
            return ResponseEntity.ok(successResponse(customMessageSource.get(MessageConstants.VIRTUAL_PLANT_SUCESS), powerPlantPojo));
        } else {
            return ResponseEntity.ok(errorResponse(customMessageSource.get(MessageConstants.ERROR_DEFAULT, customMessageSource.get(MessageConstants.VIRTUAL_PLANT_ERROR)), bindingResult));
        }
    }
}
