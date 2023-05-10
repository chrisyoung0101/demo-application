package com.example.demo.controller;

import com.example.demo.model.InventoryItem;
import com.example.demo.repository.InventoryItemRepository;
import com.example.demo.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryItemController {



    private final InventoryItemService inventoryItemService;

    @Autowired
    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
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

}
