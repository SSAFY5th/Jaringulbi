package com.ssafy.B303.repository;

import com.ssafy.B303.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByLogin_id(String login_id);
    List<User> findAll();
}
