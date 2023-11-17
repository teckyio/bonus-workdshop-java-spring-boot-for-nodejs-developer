package com.abcrestaurant.ordersysem.mapper;

import java.lang.reflect.Field;

public class MapperUtils {
    public static <From, To> void copy(From fromObject, To toObject) {
        Class<?> fromClass = fromObject.getClass();
        for (Field toField : toObject.getClass().getDeclaredFields()) {
            try {
                String fieldName = toField.getName();
                Field fromField = fromClass.getDeclaredField(fieldName);
                fromField.setAccessible(true);
                Object fieldValue = fromField.get(fromObject);
                toField.setAccessible(true);
                toField.set(toObject, fieldValue);
            } catch (NoSuchFieldException e) {
                // skip missing fields
            } catch (IllegalAccessException e) {
                // this should never occur
            }
        }
    }
}
