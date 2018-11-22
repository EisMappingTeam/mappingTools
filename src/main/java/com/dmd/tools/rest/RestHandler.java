package com.dmd.tools.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;

public final class RestHandler {

    public static void requestGet(String urlAddress) {

        try {


            Client client = Client.create();

            WebResource webResource = client.resource("http://dev5eis2kub101.sjclab.exigengroup.com:8080/api/lookups/v1/load/AddressType/en_US");

            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    public static void requestGetWithBasicAuthentication(String urlAddress, String username, String password) {
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

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


}