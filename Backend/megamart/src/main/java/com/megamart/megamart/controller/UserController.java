package com.megamart.megamart.controller;

import com.megamart.megamart.entity.User;
import com.megamart.megamart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

   @PostMapping("/login")
public String loginUser(@RequestBody User user) {

    User u = userService.loginUser(
            user.getUsername(),
            user.getPassword());

    if (u != null) {
        return "SUCCESS";
    } else {
        return "FAILED";
    }
}

}