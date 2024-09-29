package com.app.service.impl;

import com.app.dto.RestaurantDto;
import com.app.model.Address;
import com.app.model.Restaurant;
import com.app.model.User;
import com.app.repository.AddressRepository;
import com.app.repository.RestaurantRepository;
import com.app.request.CreateRestaurantRequest;
import com.app.service.RestaurantService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final AddressRepository addressRepository;
    private final UserService userService;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, AddressRepository addressRepository, UserService userService) {
        this.restaurantRepository = restaurantRepository;
        this.addressRepository = addressRepository;
        this.userService = userService;
    }

    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest request, User user) {

        Address address = addressRepository.save(request.getAddress());
        Restaurant restaurant = new Restaurant();

        restaurant.setAddress(address);
        restaurant.setContactInformation(request.getContactInformation());
        restaurant.setCuisineType(request.getCuisineType());
        restaurant.setDescription(request.getDescription());
        restaurant.setImages(request.getImages());
        restaurant.setName(request.getName());
        restaurant.setOpeningHours(request.getOpeningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);

        restaurantRepository.save(restaurant);
        return restaurant;
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
