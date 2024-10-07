package com.app.controller;

import com.app.dto.RestaurantDto;
import com.app.model.Restaurant;
import com.app.model.User;
import com.app.service.RestaurantService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final UserService userService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService, UserService userService) {
        this.restaurantService = restaurantService;
        this.userService = userService;
    }

    @GetMapping("/search")
    private ResponseEntity<List<Restaurant>> searchRestaurant(@RequestParam String keyword) throws Exception {

        List<Restaurant> restaurantList = restaurantService.searchRestaurant(keyword);

        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
    }

    @GetMapping()
    private ResponseEntity<List<Restaurant>> getAllRestaurants() throws Exception {

        List<Restaurant> restaurantList = restaurantService.getAllRestaurants();

        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") Long id) throws Exception {

        Restaurant restaurant = restaurantService.getRestaurantById(id);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PostMapping("/{id}/add-favorites")
    private ResponseEntity<RestaurantDto> addToFavorites(@RequestHeader("Authorization") String jwt,
                                                         @PathVariable("id") Long id) throws Exception {

        User user = userService.findUserByJwt(jwt);
        RestaurantDto restaurantDto = restaurantService.addToFavorites(id, user);

        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
    }


}
