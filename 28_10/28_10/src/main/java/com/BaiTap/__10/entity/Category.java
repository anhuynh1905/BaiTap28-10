package com.BaiTap.__10.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category_2810")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="CategoryId")
    private int categoryId;
    @Column(name="Categoryname", columnDefinition = "nvarchar(50) NOT NULL")
    private String categoryname;
    @Column(name="Images", columnDefinition = "nvarchar(500) NULL")
    private String images;
    @Column(name="Status")
    private int status;
}
