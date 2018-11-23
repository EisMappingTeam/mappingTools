package com.dmd.tools.rest;

import com.dmd.entity.lookup.LookupName;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;

import java.util.HashMap;
import java.util.Map;

public final class RestHandler {

    public static ClientResponse requestGet(String urlAddress) {

        try {
            Client client = Client.create();
            WebResource webResource = client.resource(urlAddress);
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            //String output = response.getEntity(String.class);
            //System.out.println("Output from Server .... \n");
            //System.out.println(output);
            return response;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    public static ClientResponse requestGetWithBasicAuthentication(String urlAddress, String username, String password) {
        //https://stackoverflow.com/questions/6774506/jersey-client-api-authentication
        try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(clientConfig);

            final HTTPBasicAuthFilter authFilter = new HTTPBasicAuthFilter(username, password);
            client.addFilter(authFilter);
            client.addFilter(new LoggingFilter());

            WebResource webResource = client.resource(urlAddress);

            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
            //.type("application/json").put( ClientResponse.class, lookupClassDMD);


            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

//            String output = response.getEntity(String.class);
//            System.out.println("Output from Server .... \n");
//            System.out.println(output);
//
            //ClientResponse response2 = webResource.accept("application/json").type("application/json").put( ClientResponse.class, ln);

            ObjectMapper objectMapper = new ObjectMapper();
            String json = response.getEntity(String.class);
            Map<String, Object> map
                    = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});





            return response;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
