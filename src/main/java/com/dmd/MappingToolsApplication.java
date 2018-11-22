package com.dmd;

import com.dmd.entity.parameters.StartupParameters;
import com.dmd.tools.parameters.ParametersReader;
import com.dmd.tools.rest.RestHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;

import static java.lang.System.exit;

@SpringBootApplication
public class MappingToolsApplication implements CommandLineRunner {


    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(MappingToolsApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        StartupParameters parameters = new StartupParameters();
        if (args.length > 0) {
          parameters = ParametersReader.read(args[0]);
        }

        //ActionRunner.runActions(parameters);
        RestHandler.requestGetWithBasicAuthentication("http://dev5eis2kub101.sjclab.exigengroup.com:8080/api/lookups/v1/load/AddressType/en_US","qa","qa");
        exit(0);
    }
}