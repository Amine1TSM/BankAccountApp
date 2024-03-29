package net.amine.accountservice.web;

import lombok.AllArgsConstructor;
import net.amine.accountservice.clients.CustomerRestClient;
import net.amine.accountservice.entities.BankAccount;
import net.amine.accountservice.model.Customer;
import net.amine.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountRepository bankAccountRepository,CustomerRestClient customerRestClient){
        this.bankAccountRepository=bankAccountRepository;
        this.customerRestClient=customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){

        List<BankAccount> bankAccounts= bankAccountRepository.findAll();
        bankAccounts.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
       return bankAccounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount= bankAccountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        System.out.println(customer.toString());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
