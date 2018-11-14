package com.dmd;

import com.dmd.services.sample.HelloMessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;

import static java.lang.System.exit;

@SpringBootApplication
public class MappingToolsApplication implements CommandLineRunner {

    @Autowired
    private HelloMessageService helloService;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(MappingToolsApplication.class);
        app.setBannerMode(Banner.Mode.OFF); //don't want to see the spring logo
        app.run(args);
    }

    // Put your logic here.
    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n\n\nHello world\n");

        if (args.length > 0) {
            System.out.println(helloService.getMessage(args[0].toString()));
        } else {
            System.out.println(helloService.getMessage());
        }


        exit(0);
    }
}