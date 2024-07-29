package com.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    private Category foodCategory;

    @Column(length = 1000)
    @ElementCollection
    private List<String> images;

    @Column(name = "available")
    private boolean available;

    @Column(name = "is_vegeterian")
    private boolean isVegetarian;

    @Column(name = "is_seasonal")
    private boolean isSeasonal;

    @ManyToMany
    private List<IngredientsItem> ingredientsItemList;

    @ManyToOne
    private Restaurant restaurant;

    private Date createdAt;
}
