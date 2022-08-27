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



   @Test
    public void saveBatteriesList(){
       List<BatteryPojo> batteryPojoList=new ArrayList<>();
       BatteryPojo batteryPojo=new BatteryPojo(11111l,"Cannington","6107",13500);
       batteryPojoList.add(batteryPojo);
       List<Battery> batteryList=genericModelMapper.mapAll(batteryPojoList,Battery.class);

       when(batteryRepository.saveAll(batteryList)).thenReturn(batteryList);

       assertEquals(batteryPojoList,batteryService.save(batteryPojoList));
   }

/*
   @Test
    public void getBatteriesUnderpostcode(){

       PostCodeRangePojo postCodeRangePojo=new PostCodeRangePojo(6056,6057);
       BatteryStasticsPojo batteryStasticsPojo=new BatteryStasticsPojo();
       BatteryPojo batteryPojo=new BatteryPojo(1l,"Midland","50500",50500);
       batteryStasticsPojo.setBatteryPojos();


   }*/

}
