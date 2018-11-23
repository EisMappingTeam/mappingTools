package com.dmd.entity.lookup.mappers;

import com.dmd.entity.lookup.LookupName;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;

import java.io.IOException;
import java.util.Map;

public final class LookupNameMapper {

    private final String JSON_NODE_BODY ="body";
    private final String JSON_NODE_RESPONSE ="body";
    private final String JSON_NODE_SUCCESS ="success";

    public static LookupName fromRest(ClientResponse response) throws IOException {
        LookupName ln = new LookupName();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = response.getEntity(String.class);
        Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });


        return ln;
    }

}
