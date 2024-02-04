package com.anita.mongodbdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("groceryItems")
@AllArgsConstructor
public class GroceryItem {

    @Id
    private String id;

    private String name;

    private Integer quantity;

    private String category;

}
