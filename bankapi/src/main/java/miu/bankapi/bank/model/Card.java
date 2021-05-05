package miu.bankapi.bank.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    private Long cardNumber;
    private int cvv;
    private String cardHolder;
    private int month;
    private int year;
    private String billingAddress;

    public Card(Long cardNumber, int cvv, String cardHolder, int month, int year, String billingAddress) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardHolder = cardHolder;
        this.month = month;
        this.year = year;
        this.billingAddress = billingAddress;
    }
}
