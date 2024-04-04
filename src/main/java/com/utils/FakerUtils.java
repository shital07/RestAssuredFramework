package com.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils(){

    }

    static final Faker faker = new Faker();
    static int getNumber(int start,int end){

        return faker.number().numberBetween(start,end);

    }

    static String getString(){

        return faker.name().name();

    }

}
