package com.SE.modal;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Item {

    @Id
    private Long id;

    private String itemName;

    private float price;

    private int quantity;

    private boolean isStockAvailable;

}
