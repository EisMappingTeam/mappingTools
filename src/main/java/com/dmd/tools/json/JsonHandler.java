package com.dmd.tools.json;

import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonHandler {
    public static List<Map<String, Object>> parseModelReportJson(String jsonString, String rootNode) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> map = objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
        });

        if (map.containsKey(rootNode)) {
            return (List<Map<String, Object>>) map.get(rootNode);
        }

        return new ArrayList<Map<String, Object>>();
    }

}




