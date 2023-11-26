package org.sid.costumerservice;

import org.sid.costumerservice.entities.Customer;
import org.sid.costumerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CostumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostumerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().nom("AYMAN").email("ayman@gmail.com").build(),
                    Customer.builder().nom("yahya").email("yahya@gmail.com").build(),
                    Customer.builder().nom("najat").email("najat@gmail.com").build()
            ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
