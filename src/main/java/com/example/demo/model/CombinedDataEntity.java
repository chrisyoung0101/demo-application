package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "combined_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombinedDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long saleId;
    private LocalDate saleDate;
    private String item;
    private Double price;
    private String customerName;
    private Long inventoryItemId;
    private String inventoryItemName;
    private int quantity;
}

