package com.demo.virtual_power_plant;

import com.demo.virtual_power_plant.entity.Battery;
import com.demo.virtual_power_plant.pojo.BatteryPojo;
import com.demo.virtual_power_plant.pojo.BatteryStasticsPojo;
import com.demo.virtual_power_plant.pojo.PostCodeRangePojo;
import com.demo.virtual_power_plant.repository.BatteryRepository;
import com.demo.virtual_power_plant.service.BatteryService;
import com.demo.virtual_power_plant.utill.GenericModelMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class ApplicationTests {

    @Autowired
    private BatteryService batteryService;

    @MockBean
    private BatteryRepository batteryRepository;
    @Autowired
    private GenericModelMapper genericModelMapper;

    /**
     * test method for saving batteries
     */
    @Test
    public void saveBatteriesList() {
        List<BatteryPojo> batteryPojoList = new ArrayList<>();
        BatteryPojo batteryPojo = new BatteryPojo(11111l, "Cannington", "6107", 13500);
        batteryPojoList.add(batteryPojo);
        List<Battery> batteryList = genericModelMapper.mapAll(batteryPojoList, Battery.class);

        when(batteryRepository.saveAll(batteryList)).thenReturn(batteryList);

        assertEquals(batteryPojoList, batteryService.save(batteryPojoList));
    }

    /**
     * test method for getting the battries list under the postCodeRange of batteries
     */
    @Test
    public void getBatteriesUnderpostcodeRange() {

        PostCodeRangePojo postCodeRangePojo = new PostCodeRangePojo(6056, 6057);
        BatteryStasticsPojo batteryStasticsPojo = new BatteryStasticsPojo();
        List<BatteryPojo> batteryPojoList = new ArrayList<>();
        BatteryPojo batteryPojo = new BatteryPojo(2l, "Midland", "6057", 50500);

        batteryPojoList.add(batteryPojo);
        batteryStasticsPojo.setBatteryPojos(batteryPojoList);
        batteryStasticsPojo.setTotalWattCapacity(50500.0);
        batteryStasticsPojo.setAverageWattCapacity(50500.0);
        when(batteryService.getBatteriesList(postCodeRangePojo)).thenReturn(batteryStasticsPojo);
        assertEquals(batteryStasticsPojo, batteryService.getBatteriesList(postCodeRangePojo));


    }

}
