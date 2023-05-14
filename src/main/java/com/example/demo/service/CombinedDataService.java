package com.example.demo.service;

import com.example.demo.client.SalesClient;
import com.example.demo.model.CombinedDataEntity;
import com.example.demo.model.InventoryItem;
import com.example.demo.model.Sale;
import com.example.demo.pojo.CombinedData;
import com.example.demo.repository.CombinedDataRepository;
import com.example.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CombinedDataService {
    private final SaleRepository saleRepository;
    private final InventoryItemService inventoryItemService;
    private final SaleService saleService;

    private final SalesClient salesClient;
    private final CombinedDataRepository combinedDataRepository;

    @Autowired
    public CombinedDataService(
            SaleRepository saleRepository,
            InventoryItemService inventoryItemService,
            CombinedDataRepository combinedDataRepository,
            SaleService saleService,
            SalesClient salesClient) {
        this.saleRepository = saleRepository;
        this.inventoryItemService = inventoryItemService;
        this.combinedDataRepository = combinedDataRepository;
        this.saleService = saleService;
        this.salesClient = salesClient;
    }

    // Combine the data from sales and inventoryItems into CombinedData objects
    public List<CombinedData> getCombinedData() {
        List<Sale> sales = salesClient.getAllSales();
        List<InventoryItem> items = inventoryItemService.getAllInventoryItems();

        List<CombinedData> combinedData = new ArrayList<>();

        // Combine the data from sales and inventoryItems into CombinedData objects
        for (Sale sale : sales) {
            CombinedData data = new CombinedData();
            data.setSaleId(sale.getId());
            data.setSaleDate(sale.getSaleDate());
            data.setItem(sale.getItem());
            data.setPrice(sale.getPrice());
            data.setCustomerName(sale.getCustomerName());

            // Find the matching inventory item and set its data
            for (InventoryItem item : items) {
                if (item.getId().equals(sale.getId())) {
                    data.setInventoryItemId(item.getId());
                    data.setInventoryItemName(item.getName());
                    data.setQuantity(item.getQuantity());
                    break;
                }
            }

            combinedData.add(data);
        }
        System.out.println("Combined data from service : " + combinedData);
        return combinedData;
    }

    public CombinedDataEntity saveCombinedData(CombinedDataEntity combinedDataEntity) {
        return combinedDataRepository.save(combinedDataEntity);
    }

    // Get all the combined data from the database
    public List<CombinedDataEntity> getAllCombinedData() {
        System.out.println("Getting all combined data :" + combinedDataRepository.findAll());
        return combinedDataRepository.findAll();
    }

    public CombinedDataEntity getCombinedDataById(Long id) {
        return combinedDataRepository.findById(id).orElse(null);
    }
}

