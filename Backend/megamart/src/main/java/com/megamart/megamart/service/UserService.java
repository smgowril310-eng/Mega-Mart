package com.megamart.megamart.service;

import com.megamart.megamart.entity.User;
import com.megamart.megamart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {

        return userRepository.save(user);

    }

    public User loginUser(String username, String password) {

    User user = userRepository.findByUsername(username).orElse(null);

    System.out.println(user);

    if (user != null && user.getPassword().equals(password)) {
        return user;
    }

    return null;
}
}