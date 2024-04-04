package com.constants;

import lombok.Getter;

import java.util.Objects;

@Getter
public class FrameworkConstantSingleton {


    private static FrameworkConstantSingleton frameworkConstantSingleton;
    private final String resourcePath = System.getProperty("user.dir")+ "/src/main/resources";

    private FrameworkConstantSingleton(){

    }

    public static FrameworkConstantSingleton getInstance(){
        if(Objects.isNull(frameworkConstantSingleton)){

            frameworkConstantSingleton = new FrameworkConstantSingleton();
        }
        return frameworkConstantSingleton;
    }
}
