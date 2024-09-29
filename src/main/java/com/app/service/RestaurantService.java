package com.app.service;

import com.app.dto.RestaurantDto;
import com.app.model.Restaurant;
import com.app.model.User;
import com.app.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {

    Restaurant createRestaurant(CreateRestaurantRequest request, User user);

    Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updaterRequest) throws Exception;

    void deleteRestaurant(Long restaurantId) throws Exception;

    List<Restaurant> getAllRestaurants();

    List<Restaurant> searchRestaurant();

    Restaurant getRestaurantById(Long restaurantId) throws Exception;

    Restaurant getRestaurantByUserId(Long userId) throws Exception;

    RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception;

    Restaurant updateRestaurantStatus(Long restaurantId) throws Exception;
}