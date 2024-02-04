package com.anita.mongodbdemo;

import com.anita.mongodbdemo.model.GroceryItem;
import com.anita.mongodbdemo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class MongodbDemoApplication implements CommandLineRunner {

	private final ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		GroceryItem groceryItem1 = new GroceryItem(
				null,
				"Milk",
				2,
				"Dairy"
		);
		itemRepository.save(groceryItem1);

		Optional<GroceryItem> groceryItem = itemRepository.findItemByName("Milk");
		List<GroceryItem> dairy = itemRepository.findAll("Dairy");
		long count = itemRepository.count();

		System.out.println(groceryItem.isPresent() ? groceryItem.get() : "Item not found");
		System.out.println(dairy);
		System.out.println(count);
	}
}
