package com.example.demo.controller;

import com.example.demo.model.InventoryItem;
import com.example.demo.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryItemController {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @GetMapping("/")
    public String index() {
        return "Welcome to my application!";
    }

    @GetMapping("/inventory-items")
    public List<InventoryItem> getAllInventoryItems() {
        List<InventoryItem> items = inventoryItemRepository.findAll();
        System.out.println("Retrieved items: " + items);
        return items;
    }

    @GetMapping("/inventory-items/{id}")
    public InventoryItem getInventoryItemById(@PathVariable(value = "id") Long id) {
        return inventoryItemRepository.findById(id).orElseThrow();
    }

    @PostMapping("/inventory-items")
    public InventoryItem createInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryItemRepository.save(inventoryItem);
    }

    @DeleteMapping("/inventory-items/{id}")
    public void deleteInventoryItem(@PathVariable(value = "id") Long id) {
        inventoryItemRepository.deleteById(id);
    }

    @PutMapping("/inventory-items/{id}")
    public InventoryItem updateInventoryItem(@PathVariable(value = "id") Long id, @RequestBody InventoryItem inventoryItem) {
        InventoryItem item = inventoryItemRepository.findById(id).orElseThrow();
        item.setName(inventoryItem.getName());
        item.setQuantity(inventoryItem.getQuantity());
        return inventoryItemRepository.save(item);
    }

}
