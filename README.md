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



### <span style="color: #3b9c61">Commit</span>
/Users/home/git-commit-scripts  
  
###   run: 

./inventory-app-commit.sh

./sales-app-commit.sh


