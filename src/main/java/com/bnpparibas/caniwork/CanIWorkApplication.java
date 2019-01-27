package com.bnpparibas.caniwork;

import com.bnpparibas.caniwork.domain.repository.ServiceRepository;
import com.bnpparibas.caniwork.infra.csv.ServiceCsvRepository;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Log
public class CanIWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CanIWorkApplication.class, args);
    }


    @Bean
    public ServiceRepository repo() {
        return new ServiceCsvRepository();
    }

}

