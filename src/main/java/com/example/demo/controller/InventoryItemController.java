package com.example.demo.controller;

import com.example.demo.client.SalesClient;
import com.example.demo.model.CombinedDataEntity;
import com.example.demo.model.InventoryItem;
import com.example.demo.model.Sale;
import com.example.demo.repository.InventoryItemRepository;
import com.example.demo.service.CombinedDataService;
import com.example.demo.service.InventoryItemService;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class InventoryItemController {



    private final InventoryItemService inventoryItemService;
    private final SaleService saleService;

    private final CombinedDataService combinedDataService;

    private final SalesClient salesClient;

    @Autowired
    public InventoryItemController(
            InventoryItemService inventoryItemService,
            SalesClient salesClient,
            SaleService saleService,
            CombinedDataService combinedDataService) {
        this.inventoryItemService = inventoryItemService;
        this.salesClient = salesClient;
        this.saleService = saleService;
        this.combinedDataService = combinedDataService;
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to my application!";
    }

    @GetMapping("/inventory-items")
    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemService.getAllInventoryItems();
    }

    @GetMapping("/inventory-items/{id}")
    public InventoryItem getInventoryItemById(@PathVariable(value = "id") Long id) {
        return inventoryItemService.getInventoryItemById(id);
    }

    @PostMapping("/inventory-items")
    public InventoryItem createInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryItemService.createInventoryItem(inventoryItem);
    }

    @DeleteMapping("/inventory-items/{id}")
    public void deleteInventoryItem(@PathVariable(value = "id") Long id) {
        inventoryItemService.deleteInventoryItem(id);
    }

    @PutMapping("/inventory-items/{id}")
    public InventoryItem updateInventoryItem(@PathVariable(value = "id") Long id, @RequestBody InventoryItem inventoryItem) {
        InventoryItem item = inventoryItemService.getInventoryItemById(id);
        item.setName(inventoryItem.getName());
        item.setQuantity(inventoryItem.getQuantity());
        return inventoryItemService.updateInventoryItem(id, inventoryItem);
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable(value = "id") Long id) {
        Sale sale = salesClient.getSaleById(id);
        return ResponseEntity.ok(sale);
    }

    @GetMapping("/sales")
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = salesClient.getAllSales();
        saleService.saveSales(sales);
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/sales/combined/{id}")
    public ResponseEntity<CombinedDataEntity> getCombinedDataById(@PathVariable(value = "id") Long id) {
        CombinedDataEntity combinedData = combinedDataService.getCombinedDataById(id);
        return ResponseEntity.ok(combinedData);
    }

    @GetMapping("/combined/")
    public ResponseEntity<List<CombinedDataEntity>> getAllCombinedData() {
        List<CombinedDataEntity> combinedData = combinedDataService.getAllCombinedData();
        return ResponseEntity.ok(combinedData);
    }

}
