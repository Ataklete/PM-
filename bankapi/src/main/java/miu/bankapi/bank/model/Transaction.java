package miu.bankapi.bank.model;

import lombok.*;
import javax.persistence.*;


@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cardNumber")
    private Card card;
    private double amount;
  }
