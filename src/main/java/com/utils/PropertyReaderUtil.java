package com.utils;

import com.constants.FrameworkConstantSingleton;
import com.enums.PropertiesType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReaderUtil {

    private final static Properties properties = new Properties();
    private static final Map<String,String> mp = new HashMap<>();

    static {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                    new FileReader(FrameworkConstantSingleton.getInstance().getResourcePath() + "/config.properties"));
            properties.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        properties.forEach((key, value) -> mp.put(key.toString(), value.toString()));

    }

    public static String getKey(PropertiesType key){
        return mp.get(key.name().toLowerCase());
    }

}
