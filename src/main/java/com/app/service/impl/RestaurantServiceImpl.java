package com.app.service.impl;

import com.app.dto.RestaurantDto;
import com.app.model.Restaurant;
import com.app.model.User;
import com.app.repository.RestaurantRepository;
import com.app.request.CreateRestaurantRequest;
import com.app.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest request, User user) {
        return null;
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updaterRequest) throws Exception {
        return null;
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {

    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return List.of();
    }

    @Override
    public List<Restaurant> searchRestaurant() {
        return List.of();
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) throws Exception {
        return null;
    }

    @Override
    public Restaurant getRestaurantByUserId(Long userId) throws Exception {
        return null;
    }

    @Override
    public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception {
        return null;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long restaurantId) throws Exception {
        return null;
    }
}
