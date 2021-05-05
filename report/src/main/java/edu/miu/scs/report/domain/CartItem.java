package edu.miu.scs.report.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@NoArgsConstructor
@ToString
@Setter
@Getter
@AllArgsConstructor
public class CartItem {

	private int productId;
    private int quantity;
    private double unitCost;
    private String vendorId;
    private String userName;

}
