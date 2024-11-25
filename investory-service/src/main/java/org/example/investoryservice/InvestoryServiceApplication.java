package org.example.investoryservice;

import org.example.investoryservice.entities.Product;
import org.example.investoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InvestoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvestoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository,
                            RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
                 repositoryRestConfiguration.exposeIdsFor(Product.class);
                productRepository.saveAll(
                        List.of(
                                Product.builder().name("Computer").quantity(12).price(1200).build(),
                                Product.builder().name("Printer").quantity(32).price(150).build(),
                                Product.builder().name("SmartPhone").quantity(45).price(5500).build()

                        )
                );
        };
    }

}
