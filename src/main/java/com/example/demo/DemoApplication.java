package com.example.demo;

import com.example.demo.client.SalesClient;
import com.example.demo.model.InventoryItem;
import com.example.demo.model.Sale;
import com.example.demo.repository.InventoryItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication implements CommandLineRunner {

	private final InventoryItemRepository inventoryItemRepository;

	private final SalesClient salesClient;

	public DemoApplication(InventoryItemRepository inventoryItemRepository, SalesClient salesClient) {
		this.inventoryItemRepository = inventoryItemRepository;
		this.salesClient = salesClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Long saleId = 1L; // the ID of the sale you want to retrieve
		Sale sale = salesClient.getSaleById(saleId);
		System.out.println("Retrieved from Sales Application: " + sale); // print the retrieved sale


		InventoryItem item1 = new InventoryItem(1L,"Item 1", 10);
		InventoryItem item2 = new InventoryItem(2L, "Item 2", 20);
		InventoryItem item3 = new InventoryItem(3L, "Item 3", 30);
		InventoryItem item4 = new InventoryItem(4L, "Item 4", 40);
		InventoryItem item5 = new InventoryItem(5L, "Item 5", 50);
		InventoryItem item6 = new InventoryItem(6L, "Item 6", 60);
		InventoryItem item7 = new InventoryItem(7L, "Item 7", 70);

		inventoryItemRepository.saveAll(Arrays.asList(item1, item2, item3, item4, item5, item6, item7));
	}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.paths(PathSelectors.any())
				.build();
	}

}

