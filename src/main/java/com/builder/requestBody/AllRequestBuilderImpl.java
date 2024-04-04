package com.builder.requestBody;

public class AllRequestBuilderImpl implements RequestBuilderStrategy{
    @Override
    public Object createRequestBuilder(Object o) {
       return o;
    }
}
