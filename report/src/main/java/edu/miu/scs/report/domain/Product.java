package edu.miu.scs.report.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "productreport")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Product {
	@Id
    private Long productId;
    //@Indexed(unique=true) // make it unique username
    private String productName;
    private double price;
    private String description;
    private  int Quantity;
    private String vendorId;
    private String  categoryName;
    private String  categoryId;
    private ProductStatus status ;
}
