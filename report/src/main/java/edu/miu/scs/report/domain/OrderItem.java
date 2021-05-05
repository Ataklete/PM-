package edu.miu.scs.report.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderItem {

    private int id;
    private String productId;
    private double price;
    private int quantity;

    public OrderItem(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }
}
