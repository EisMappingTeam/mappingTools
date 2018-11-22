package com.dmd.tools.json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonHandler {
    public static List<Map<String, Object>> parseModelReportJson(String jsonString) {
        try {

            ObjectMapper mapper = new ObjectMapper();

            Map<String, List<Map<String, Object>>> nodes = mapper.readValue(jsonString, new TypeReference<Map<String, List<Map<String, Object>>>>() {
            });

            if (nodes.isEmpty()) {
                return null;
            }

            List<Map<String, Object>> entry = nodes.get(nodes.keySet().stream().findFirst().get());
            return entry;

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}




