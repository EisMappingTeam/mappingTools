package com.dmd.services.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HelloMessageService {

    @Value("${name:unknown}")
    private String name;

    public String getMessage() throws IOException {
        return getMessage("..." + name);
    }

    public String getMessage(String name) throws IOException {
        return "Hello __ " + name;
    }

}