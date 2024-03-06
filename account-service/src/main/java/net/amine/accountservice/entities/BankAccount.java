package net.amine.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.amine.accountservice.enums.AccountType;
import net.amine.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
