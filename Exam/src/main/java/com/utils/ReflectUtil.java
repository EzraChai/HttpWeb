package com.utils;

import java.lang.reflect.Field;

/**
 * Turn a Java Object into a JSON
 * Usage example: Student stu = new Student(1,"Chloe");
 * String JSON = stu.ReflectUtil.JSONObject;
 */
public class ReflectUtil {
    public static String JSONObject(Object obj) {
        Class classFile = null;
        Field fieldArray[] = null;
        StringBuffer str = new StringBuffer("{");

        classFile = obj.getClass();
        fieldArray = classFile.getDeclaredFields();


        try {
            for (int i = 0; i < fieldArray.length; i++) {
                Field field = fieldArray[i];
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = null;
                value = field.get(obj);
                str.append("\"");
                str.append(fieldName);
                str.append("\":");
                str.append("\"");
                str.append(value);
                str.append("\"");
                if (i < fieldArray.length - 1) {
                    str.append(",");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            str.append("}");
        }


        return str.toString();
    }
}
