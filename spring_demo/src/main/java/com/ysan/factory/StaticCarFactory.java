package com.ysan.factory;

import com.ysan.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @description
 * @since 2023/1/30 17:36
 **/
public class StaticCarFactory {
    private static Map<Integer, Car> carMap;


    static {
        carMap = new HashMap<Integer, Car>();
        carMap.put(1,new Car(1,"奥迪"));
        carMap.put(2,new Car(2,"奥拓"));
    }

    public static Car getCar(Integer id){
        return carMap.get(id);
    }
}
