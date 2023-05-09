package com.example.demo;

import com.example.demo.model.InventoryItem;
import com.example.demo.repository.InventoryItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final InventoryItemRepository inventoryItemRepository;

	public DemoApplication(InventoryItemRepository inventoryItemRepository) {
		this.inventoryItemRepository = inventoryItemRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		InventoryItem item1 = new InventoryItem(1L,"Item 1", 10);
		InventoryItem item2 = new InventoryItem(2L, "Item 2", 20);
		InventoryItem item3 = new InventoryItem(3L, "Item 3", 30);
		InventoryItem item4 = new InventoryItem(4L, "Item 4", 40);
		InventoryItem item5 = new InventoryItem(5L, "Item 5", 50);
		InventoryItem item6 = new InventoryItem(6L, "Item 6", 60);
		InventoryItem item7 = new InventoryItem(7L, "Item 7", 70);

		inventoryItemRepository.saveAll(Arrays.asList(item1, item2, item3, item4, item5, item6, item7));
	}
}

