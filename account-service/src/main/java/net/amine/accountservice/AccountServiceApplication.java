package net.amine.accountservice;

import net.amine.accountservice.clients.CustomerRestClient;
import net.amine.accountservice.entities.BankAccount;
import net.amine.accountservice.enums.AccountType;
import net.amine.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){

        return args -> {
            customerRestClient.allCustomers().forEach(c->{
                BankAccount bankAccount1= BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*65432)
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(Long.valueOf(c.getId()))
                        .build();

                BankAccount bankAccount2= BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*80000)
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(Long.valueOf(c.getId()))
                        .build();
                bankAccountRepository.save(bankAccount1);
                bankAccountRepository.save(bankAccount2);
            });
          BankAccount bankAccount1= BankAccount.builder()
                  .accountId(UUID.randomUUID().toString())
                  .currency("MAD")
                  .balance(98000)
                  .createAt(LocalDate.now())
                  .type(AccountType.SAVING_ACCOUNT)
                  .customerId(Long.valueOf(1))
                  .build();

            BankAccount bankAccount2= BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(12000)
                    .createAt(LocalDate.now())
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(Long.valueOf(2))
                    .build();

            bankAccountRepository.save(bankAccount1);
            bankAccountRepository.save(bankAccount2);


        };
    }
}
