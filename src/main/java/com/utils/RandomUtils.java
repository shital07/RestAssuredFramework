package com.utils;

public final class RandomUtils {

    private RandomUtils(){

    }

    public static int getId(){
        return FakerUtils.getNumber(100,1000);
    }


    public static String getName(){
        return FakerUtils.getString();
    }


}
