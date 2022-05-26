package com.etherealhazel.stakediv.service;

import java.util.List;

import com.etherealhazel.stakediv.model.AppUser;
import com.etherealhazel.stakediv.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void createUser(AppUser user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            userRepository.save(user);
        } else {
            user.setUsername(user.getUsername() + "boop");
            userRepository.save(user);
        }        
    }

    public List<AppUser> getAllUsers() {
        List<AppUser> users = userRepository.findAll();
        return users;
    }

}
