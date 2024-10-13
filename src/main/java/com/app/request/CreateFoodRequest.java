package com.app.request;

import com.app.model.Category;
import com.app.model.IngredientsItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {

    private String name;
    private String description;
    private Long price;

    private Category category;
    private List<String> images;

    private Long restaurantId;
    private boolean vegetarian;
    private boolean sessional;
    private List<IngredientsItem> ingredients;
}