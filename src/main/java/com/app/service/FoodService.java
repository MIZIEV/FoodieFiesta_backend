package com.app.service;

import com.app.model.Category;
import com.app.model.Food;
import com.app.model.Restaurant;
import com.app.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    Food createFood(CreateFoodRequest request, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantsFood(Long restaurantId, boolean isVegetarian,
                                         boolean isSessional, String foodCategory);

    List<Food> searchFood(String keyword);

    Food getFoodById(Long foodId) throws Exception;

    Food updateAvailabilityStatus(Long foodId) throws Exception;
}