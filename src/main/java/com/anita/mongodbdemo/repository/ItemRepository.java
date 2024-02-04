package com.anita.mongodbdemo.repository;

import com.anita.mongodbdemo.model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends MongoRepository<GroceryItem, String> {

    @Query("{ name:  '?0'}")
    Optional<GroceryItem> findItemByName(String name);

    @Query(
            value = "{ category:  '?0'}",
            fields = "{ 'name': 1, 'quantity': 1}"
    )
    List<GroceryItem> findAll(String category);

    long count();

}
