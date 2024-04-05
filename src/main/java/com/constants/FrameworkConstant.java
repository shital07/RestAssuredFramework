package com.constants;

import lombok.Getter;

public class FrameworkConstant {

    private FrameworkConstant(){

    }
    private static final @Getter String resourcePath = System.getProperty("user.dir")+ "src/main/resources";


}
