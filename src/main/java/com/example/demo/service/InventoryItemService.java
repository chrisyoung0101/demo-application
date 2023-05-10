package com.example.demo.service;

import com.example.demo.model.InventoryItem;
import com.example.demo.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;

    @Autowired
    public InventoryItemService(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public List<InventoryItem> getAllInventoryItems() {
       List<InventoryItem> items = inventoryItemRepository.findAll();
       System.out.println("Retrieved items: " + items);
       return items;
    }

    public InventoryItem getInventoryItemById(Long id) {
        return inventoryItemRepository.findById(id).orElseThrow();
    }

    public InventoryItem createInventoryItem(InventoryItem inventoryItem) {
        return inventoryItemRepository.save(inventoryItem);
    }

    public void deleteInventoryItem(Long id) {
        inventoryItemRepository.deleteById(id);
    }

    public InventoryItem updateInventoryItem(Long id, InventoryItem inventoryItem) {
        InventoryItem item = inventoryItemRepository.findById(id).orElseThrow();
        item.setName(inventoryItem.getName());
        item.setQuantity(inventoryItem.getQuantity());
        return inventoryItemRepository.save(item);
    }



}
