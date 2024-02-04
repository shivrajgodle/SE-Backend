package com.SE.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ItemDto {
    private Long id;

    private String itemName;

    private float price;

    private int quantity;

    private boolean isStockAvailable;
}
