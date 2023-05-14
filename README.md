# <span style="color: #3b9c61">Inventory Application</span>

The Inventory Application is built with <span style="color: #3b9c61">Spring Boot</span> and uses <span style="color: #3b9c61">REST API</span>. It is integrated with an <span style="color: #3b9c61">H2 database</span> and <span style="color: #3b9c61">Swagger</span> for API documentation.

<span style="color: magenta">**Important**: Ensure that the SalesApplication is running before starting the InventoryApplication.</span>



## Application Dependencies

- Spring Boot
- REST
- H2 Database
- Swagger

## Usage

### <span style="color: #3b9c61">InventoryApplication</span>
The Inventory Application serves as the backend for the M&P Hardware Store front-end application. It interacts with the H2 database and communicates with the SalesApplication to retrieve sales data.  The SalesApplication also utilizes an H2 database and runs on port 8081. Please ensure that the SalesApplication is running before starting the InventoryApplication.

- <span style="color: #3b9c61">InventoryApplication (demo): on port 8080</span>
- Swagger UI: [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
### <span style="color: #3b9c61">SalesApplication</span>





- <span style="color: #3b9c61">SalesApplication : on port 8081</span>
- Swagger UI: [localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
- H2 Console: [http://localhost:8081/h2-console](http://localhost:8081/h2-console)


### <span style="color: #3b9c61">Combined Search Results in InventoryApplication</span>

To retrieve combined search results, the `CombinedDataService` utilizes the following steps:

1. Retrieve all sales data by calling `salesClient.getAllSales()`. This retrieves a list of `Sale` objects.

2. Retrieve all inventory items by calling `inventoryItemService.getAllInventoryItems()`. This retrieves a list of `InventoryItem` objects.

3. The `CombinedDataService` combines the sales data and inventory items to create a `combinedData` object. This object is then stored in the `CombinedDataRepository`.

These steps enable the retrieval of combined search results that contain both sales and inventory item data.


### <span style="color: #3b9c61">Commit</span>
/Users/home/git-commit-scripts  
  
###   run: 

./inventory-app-commit.sh

./sales-app-commit.sh


# Why have a CombinedData POJO and a CombinedDataEntity entity?

The purpose of having both a `CombinedData` POJO and a `CombinedDataEntity` entity is to separate the concerns of your application's business logic and the persistence layer.

Here's the breakdown of each class:

1. <span style="color: #3b9c61">CombinedData POJO:</span>
    - It represents the combined data model in your application's business logic layer.
    - This class is used to store and manipulate the combined data retrieved from the `Sale` and `InventoryItem` entities.
    - It does not have any annotations related to persistence or database mapping.
    - It serves as a convenient way to organize and work with the combined data within your application's code.

2. <span style="color: #3b9c61">CombinedDataEntity entity:</span>
    - It represents the persistence entity that maps to the `combined_data` table in the database.
    - This entity class includes the necessary annotations (`@Entity`, `@Table`, etc.) to define its persistence mapping.
    - It serves as a bridge between the business logic layer and the persistence layer, allowing you to store and retrieve the combined data from the database.
    - In some cases, you might have additional annotations or configurations specific to the persistence layer, such as defining relationships or constraints.

By having separate classes for business logic and persistence, you maintain a clear separation of concerns. The `CombinedData` class is focused on encapsulating the combined data and providing convenient methods for working with it, while the `CombinedDataEntity` class is responsible for representing the persistence structure and mapping to the database.

In your `CombinedDataService`, you use the `CombinedData` class to hold and manipulate the combined data in memory. When it comes to saving the combined data, you convert it to a `CombinedDataEntity` object to align with the persistence layer's requirements. The `CombinedDataRepository` handles the persistence operations, interacting with the database using the `CombinedDataEntity` entities.

This separation allows you to decouple your business logic from the database implementation, making your code more maintainable, testable, and flexible to changes in either layer.
