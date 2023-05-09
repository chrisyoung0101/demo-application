package com.example.demo.controller;

import com.example.demo.model.InventoryItem;
import com.example.demo.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/inventory-items")
    public InventoryItem createInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryItemRepository.save(inventoryItem);
    }
}
