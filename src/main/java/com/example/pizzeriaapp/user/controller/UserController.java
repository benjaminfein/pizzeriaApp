package com.example.pizzeriaapp.user.controller;

import com.example.pizzeriaapp.menuItem.exception.MenuItemIdNotFoundException;
import com.example.pizzeriaapp.user.model.User;
import com.example.pizzeriaapp.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/user")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("api/createUser")
    public HttpStatus createUser(@RequestBody User user) {
        userService.createUser(user);
        return HttpStatus.OK;
    }

    @PutMapping("api/updateUser/{id}")
    public HttpStatus updateUser(@RequestBody User user, @PathVariable Integer id) {
        try {
            User userById = userService.findById(id);
            userService.updateMenuItem(userById, user);
            return HttpStatus.NO_CONTENT;
        } catch (Exception wrongIdWasWritten) {
            throw new MenuItemIdNotFoundException("No such user by written id");
        }
    }

    @DeleteMapping("api/deleteUser/{id}")
    public HttpStatus deleteUser(@PathVariable Integer id) {
        try {
            User userById = userService.findById(id);
            userService.deleteUser(userById);
            return HttpStatus.NO_CONTENT;
        } catch (Exception wrongIdWasWritten) {
            throw new MenuItemIdNotFoundException("No such user by written id");
        }
    }
}
