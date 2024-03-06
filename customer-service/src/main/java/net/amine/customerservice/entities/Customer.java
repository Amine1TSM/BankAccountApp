package net.amine.customerservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
