package com.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "restaurant")
@Data
public class Restaurant {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
