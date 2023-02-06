package com.ysan.factory;

import com.ysan.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @description
 * @since 2023/1/31 9:31
 **/
public class InstanceCarFactory {
    private Map<Integer, Car> carMap;

    public InstanceCarFactory(){
        carMap = new HashMap<>();
        carMap.put(1, new Car(1,"奥迪"));
        carMap.put(2, new Car(2,"奥拓"));
    }

    public Car getCar(Integer num){
        return carMap.get(num);
    }
}
