package com.ssafy.B303.service.UserService;

import com.ssafy.B303.domain.User;
import com.ssafy.B303.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public int join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        userRepository.findByLogin_id(user.getLogin_id())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }



}
