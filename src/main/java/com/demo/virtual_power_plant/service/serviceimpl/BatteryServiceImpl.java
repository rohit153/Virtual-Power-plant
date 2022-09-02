package com.demo.virtual_power_plant.service.serviceimpl;

import com.demo.virtual_power_plant.entity.Battery;
import com.demo.virtual_power_plant.pojo.BatteryPojo;
import com.demo.virtual_power_plant.pojo.BatteryStasticsPojo;
import com.demo.virtual_power_plant.pojo.PostCodeRangePojo;
import com.demo.virtual_power_plant.repository.BatteryRepository;
import com.demo.virtual_power_plant.service.BatteryService;
import com.demo.virtual_power_plant.utill.GenericModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */


/*
* it has save and get battries methods implemented
* */
@Service
@Slf4j
@RequiredArgsConstructor
public class BatteryServiceImpl implements BatteryService {
    private final GenericModelMapper genericModelMapper;
    private final BatteryRepository batteryRepository;

    /**
     * @param batteryPojo
     * @return virtualPowerPlantPojo
     * @throws DataIntegrityViolationException
     */
    @Override
    public List<BatteryPojo> save(List<BatteryPojo> batteryPojo) throws DataIntegrityViolationException {
        List<Battery> battery = genericModelMapper.mapAll(batteryPojo, Battery.class);
        batteryRepository.saveAll(battery);
        log.info("=============saved list of batteries succesfully ==============");
        return batteryPojo;
    }

    /**
     * @param postCodeRangePojo
     * @return BatteryStasticsPojo with stastics of batteries
     */
    @Override
    public BatteryStasticsPojo getBatteriesList(PostCodeRangePojo postCodeRangePojo) {
        /*get the List of batteries between the range of PostCodeRange*/
        List<Battery> batteryList = batteryRepository.findByPostCodeRange(postCodeRangePojo.getFirstRangeParameter(), postCodeRangePojo.getLastRangeParameter());

        /*sorts the list of batteries in alphabetically according to the battery name*/
        List<Battery> batteryList1 = batteryList.stream().sorted(Comparator.comparing(Battery::getName)).collect(Collectors.toList());
        List<BatteryPojo> batteryPojoList = genericModelMapper.mapAll(batteryList1, BatteryPojo.class);


        /*calculate the averageWattCapacity of sorted list */
        double averageWattCapacity = batteryList1.stream().mapToInt(a -> a.getCapacity()).average().orElse(0);

        /*calculate the totalWattCapacity of sorted list */
        double totalWattCapacity = batteryList1.stream().mapToDouble(Battery::getCapacity).sum();

        log.info("=============sorted the list of batteries alphabetically and calculated total and average batteries watt capacity sucess==============");


        BatteryStasticsPojo batteryStasticsPojo=new BatteryStasticsPojo();
        batteryStasticsPojo.setBatteryPojos(batteryPojoList);
        batteryStasticsPojo.setAverageWattCapacity(averageWattCapacity);
        batteryStasticsPojo.setTotalWattCapacity(totalWattCapacity);

        return batteryStasticsPojo;
    }
}
