package org.example.customerservice;

import org.example.customerservice.entities.Customer;
import org.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                               RepositoryRestConfiguration repositoryRestConfiguration){
        return  args -> {
            repositoryRestConfiguration.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("kamal").email("kamal@gmail.com").build(),
                            Customer.builder().name("Mohamed").email("Mohamed@gmail.com").build(),
                            Customer.builder().name("amine").email("amine@gmail.com").build()
                    )
            );
            customerRepository.findAll().forEach(c->{
                System.out.println(c);
            });

        };
    }

}

