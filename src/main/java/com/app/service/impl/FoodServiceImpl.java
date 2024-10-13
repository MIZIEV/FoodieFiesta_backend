package com.app.service.impl;

import com.app.model.Category;
import com.app.model.Food;
import com.app.model.Restaurant;
import com.app.repository.FoodRepository;
import com.app.request.CreateFoodRequest;
import com.app.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    @Override
    public Food createFood(CreateFoodRequest request, Category category, Restaurant restaurant) {

        Food food = new Food();

        food.setFoodCategory(category);
        food.setRestaurant(restaurant);
        food.setDescription(request.getDescription());
        food.setImages(request.getImages());
        food.setName(request.getName());
        food.setPrice(request.getPrice());
        food.setIngredientsItemList(request.getIngredients());
        food.setSeasonal(request.isSessional());
        food.setVegetarian(request.isVegetarian());

        foodRepository.save(food);
        restaurant.getFoodList().add(food);

        return food;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {

        Food food = foodRepository.findById(foodId).get();
        food.setRestaurant(null);
        foodRepository.save(food);

    }

    @Override
    public List<Food> getRestaurantsFood(Long restaurantId, boolean isVegetarian,
                                         boolean isSessional, String foodCategory) {
        return List.of();
    }

    @Override
    public List<Food> searchFood(String keyword) {
        return List.of();
    }

    @Override
    public Food getFoodById(Long foodId) throws Exception {
        return null;
    }

    @Override
    public Food updateAvailabilityStatus(Long foodId) throws Exception {
        return null;
    }
}
