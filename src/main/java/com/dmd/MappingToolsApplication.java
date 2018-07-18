package com.dmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;

import static java.lang.System.exit;

@SpringBootApplication
public class MappingToolsApplication implements CommandLineRunner{

    public static void main(String[] args) throws Exception {
        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(MappingToolsApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    // Put your logic here.
    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n\n\nHello world\n");
        if (args.length > 0) {
            System.out.println("Args count: " + args.length +"\n\n\n\n" );
        } else {
            System.out.println("Args count: none");
        }
        exit(0);
    }
}