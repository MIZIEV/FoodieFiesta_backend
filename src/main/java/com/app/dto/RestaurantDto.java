package com.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class RestaurantDto {

    private Long id;

    private String name;

    @Column(length = 1000)
    private List<String> images;

    private String description;
}
