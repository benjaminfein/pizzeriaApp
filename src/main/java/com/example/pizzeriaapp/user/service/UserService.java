package com.example.pizzeriaapp.user.service;

import com.example.pizzeriaapp.user.model.User;
import com.example.pizzeriaapp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such user by id: " + id));
    }

    public void updateMenuItem(User exitingUser, User userForUpdate) {
        userForUpdate.setId(exitingUser.getId());
        userForUpdate.setRights(exitingUser.userOrAdmin());
        userRepository.save(userForUpdate);
    }

    public void deleteUser(User userForDeletion) {
        userRepository.delete(userForDeletion);
    }
}
