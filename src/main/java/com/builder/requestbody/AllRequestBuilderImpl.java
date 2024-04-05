package com.builder.requestbody;

public class AllRequestBuilderImpl implements RequestBuilderStrategy{
    @Override
    public Object createRequestBuilder(Object o) {
       return o;
    }
}
