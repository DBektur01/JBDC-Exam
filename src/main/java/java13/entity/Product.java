package java13.entity;

import lombok.*;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private Long id;
    private String name;
    private int rating;
    private int price;


    public Product(String name, int rating, int price) {
        this.name = name;
        this.rating = rating;
        this.price = price;
    }
}
