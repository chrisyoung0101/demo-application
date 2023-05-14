package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Component
public class CombinedData {
    private Long saleId;
    private LocalDate saleDate;
    private String item;
    private Double price;
    private String customerName;
    private Long inventoryItemId;
    private String inventoryItemName;
    private int quantity;
}

