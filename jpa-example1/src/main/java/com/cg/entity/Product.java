package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "product_table")
@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Product {
       @Id
       private int pid;
       private String name;
       private int qty;
       private int price;
       private LocalDate mfd;

}
