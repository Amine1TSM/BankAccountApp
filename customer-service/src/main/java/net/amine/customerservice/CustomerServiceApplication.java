package net.amine.customerservice;

import net.amine.customerservice.config.GlobalConfig;
import net.amine.customerservice.entities.Customer;
import net.amine.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> customerList=List.of(Customer.builder()
                    .firstname("amine")
                    .lastname("ibrahimi")
                    .email("amineibrahimi79@Gmail.com")
                    .build(),

                    Customer.builder()
                            .firstname("amine")
                            .lastname("ibrahimi")
                            .email("amineibrahimi79@Gmail.com")
                            .build()
                    );

            customerRepository.saveAll(customerList);

        };
    }
}
