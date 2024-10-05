package com.app.controller;

import com.app.model.Restaurant;
import com.app.model.User;
import com.app.request.CreateRestaurantRequest;
import com.app.response.MessageResponse;
import com.app.service.RestaurantService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminRestaurantController {

    private final RestaurantService restaurantService;
    private final UserService userService;

    @Autowired
    public AdminRestaurantController(RestaurantService restaurantService, UserService userService) {
        this.restaurantService = restaurantService;
        this.userService = userService;
    }

    @PostMapping()
    private ResponseEntity<Restaurant> createRestaurant(@RequestBody CreateRestaurantRequest request,
                                                        @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);
        Restaurant restaurant = restaurantService.createRestaurant(request, user);

        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Restaurant> updateRestaurant(@RequestBody CreateRestaurantRequest request,
                                                        @PathVariable("id") Long id) throws Exception {
        Restaurant restaurant = restaurantService.updateRestaurant(id, request);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<MessageResponse> deleteRestaurant(@PathVariable("id") Long id) throws Exception {

        restaurantService.deleteRestaurant(id);

        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Restaurant deleted successfully");

        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    private ResponseEntity<Restaurant> updateRestaurantStatus(@PathVariable("id") Long id) throws Exception {

        Restaurant restaurant = restaurantService.updateRestaurantStatus(id);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/user")
    private ResponseEntity<Restaurant> getRestaurantByUserId(@RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);
        Restaurant restaurant = restaurantService.getRestaurantByUserId(user.getId());

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
