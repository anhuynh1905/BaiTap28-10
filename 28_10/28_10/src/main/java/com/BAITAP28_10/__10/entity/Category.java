package com.BAITAP28_10.__10.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category_2810")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId")
    private int id;

    @Column(name = "CategoryName", columnDefinition = "nvarchar(50) NOT NULL")
    private String name;

    @Column(name = "Images", columnDefinition = "nvarchar(500) NOT NULL")
    private String image;

    @Column(name = "Status")
    private int status;
}
