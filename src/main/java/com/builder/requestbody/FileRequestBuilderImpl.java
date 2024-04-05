package com.builder.requestbody;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;

public class FileRequestBuilderImpl implements RequestBuilderStrategy{

    @SneakyThrows
    @Override
    public Object createRequestBuilder(Object o) {

        if(o instanceof File){

                return Files.readString(((File) o).toPath());

        }

        return o;
    }
}
