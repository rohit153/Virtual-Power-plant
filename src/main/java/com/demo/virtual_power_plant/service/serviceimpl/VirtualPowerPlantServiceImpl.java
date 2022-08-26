package com.demo.virtual_power_plant.service.serviceimpl;

import com.demo.virtual_power_plant.entity.VirtualPowerPlant;
import com.demo.virtual_power_plant.exception.GenericException;
import com.demo.virtual_power_plant.pojo.VirtualPowerPlantPojo;
import com.demo.virtual_power_plant.repository.VirtualPowerPlantRepository;
import com.demo.virtual_power_plant.service.VirtualPowerPlantService;
import com.demo.virtual_power_plant.utill.GenericModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
@Service
@RequiredArgsConstructor
public class VirtualPowerPlantServiceImpl implements VirtualPowerPlantService {
    private final GenericModelMapper genericModelMapper;
    private final VirtualPowerPlantRepository virtualPowerPlantRepository;

    /**
     * @param virtualPowerPlantPojo
     * @return virtualPowerPlantPojo
     * @throws DataIntegrityViolationException
     */
    @Override
    public List<VirtualPowerPlantPojo> save(List<VirtualPowerPlantPojo> virtualPowerPlantPojo) throws DataIntegrityViolationException {
        List<VirtualPowerPlant> virtualPowerPlant = genericModelMapper.mapAll(virtualPowerPlantPojo, VirtualPowerPlant.class);
        virtualPowerPlantRepository.saveAll(virtualPowerPlant);
        return virtualPowerPlantPojo;
    }
}
