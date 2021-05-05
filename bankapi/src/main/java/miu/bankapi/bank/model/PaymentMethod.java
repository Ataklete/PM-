package miu.bankapi.bank.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaymentMethod {

    @Id
    private Long id;
    private String url;
    private String name;
    private String description;
    private int rangeFrom;
    private int rangeTo;
}
