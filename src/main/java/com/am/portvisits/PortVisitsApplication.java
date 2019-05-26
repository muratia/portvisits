package com.am.portvisits;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan("com.am.portvisits")
@SpringBootApplication
@EnableJpaRepositories

public class PortVisitsApplication {

    public static Logger Log = Logger.getLogger(PortVisitsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run (PortVisitsApplication.class, args);
    }

}
