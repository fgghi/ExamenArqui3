package com.ucb.demo.service;

import java.util.Optional;

public class Greeting {
    private String greeting;
    private IUserRepository userRepository;

    public Greeting(IUserRepository userRepository) {
        this.greeting = "Hello, %s, from UCB!";
        this.userRepository = userRepository;
    }

    public String greet(String userId) {
        Optional<User> user = userRepository.findById(userId);
        String name = user.map(User::getName).orElse("friend");
        String nameFormat = name.trim();
        nameFormat = nameFormat.toLowerCase();
        nameFormat = nameFormat.substring(0,1).toUpperCase() + nameFormat.substring(1);
        return String.format(greeting, nameFormat);
    }
}
