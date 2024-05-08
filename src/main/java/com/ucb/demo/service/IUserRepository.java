package com.ucb.demo.service;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> findById(String userId);

}
