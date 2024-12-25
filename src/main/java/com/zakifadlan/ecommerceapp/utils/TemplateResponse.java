package com.zakifadlan.ecommerceapp.utils;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class TemplateResponse {
    public Map templateSucces(Object object,String Message,String Status){
        Map map = new HashMap();
        map.put("data",object);
        map.put("message",Message);
        map.put("status",Status);
        return map;
    }
    public Map templateError(Object object){
        Map map = new HashMap();
        map.put("message",object);
        map.put("status","404");
        return map;
    }
    public Map templateError(String message){
        Map map = new HashMap();
        map.put("message",message);
        map.put("status","404");
        return map;
    }
    public boolean checkNull(Object object) {
        try {

            Field[] fields = object.getClass().getDeclaredFields();


            for (Field field : fields) {
                field.setAccessible(true);


                if ("id".equals(field.getName())) {
                    continue;
                }


                if (field.get(object) == null) {
                    return true;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
}
