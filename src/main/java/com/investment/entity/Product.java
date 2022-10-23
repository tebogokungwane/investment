package com.investment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )

    private Long productId;
    private String productKey;
    private double balance;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "investor_id",
            referencedColumnName = "investorId"
    )
    private Investor investor;

}

