package com.example.demo.controller;

import com.example.demo.client.SalesClient;
import com.example.demo.model.InventoryItem;
import com.example.demo.model.Sale;
import com.example.demo.repository.InventoryItemRepository;
import com.example.demo.service.InventoryItemService;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryItemController {



    private final InventoryItemService inventoryItemService;
    private final SaleService saleService;

    private final SalesClient salesClient;

    @Autowired
    public InventoryItemController(InventoryItemService inventoryItemService, SalesClient salesClient, SaleService saleService) {
        this.inventoryItemService = inventoryItemService;
        this.salesClient = salesClient;
        this.saleService = saleService;
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
    public ResponseEntity<Sale> getSaleById(Long id) {
        Sale sale = salesClient.getSaleById(id);
        return ResponseEntity.ok(sale);
    }

    @GetMapping("/sales")
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = salesClient.getAllSales();
        saleService.saveSales(sales);
        return ResponseEntity.ok(sales);
    }



}
