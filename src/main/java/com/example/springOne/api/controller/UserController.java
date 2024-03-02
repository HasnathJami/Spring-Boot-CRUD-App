package com.example.springOne.api.controller;

import com.example.springOne.api.model.User;
import com.example.springOne.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/list")
    public List<User> getAllUser() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
        Optional<User> user = userService.getUser(id);
        return user.orElse(null);
    }

//    @PostMapping("/user/create")
//    public void createUser(@RequestBody User newUser) {
//       // return
//        userService.createUser(newUser);
//    }

    @PostMapping("/user/create")
    public User createUser(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age, @RequestParam String email) {
        User newUser = new User(id, name, age, email);
        return userService.createUser(newUser);
    }

//    @PutMapping("/user/update/{id}")
//    public User updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
//        return userService.updateUser(id, updatedUser);
//    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestParam(required = false) String name, @RequestParam(required = false) Integer age, @RequestParam(required = false) String email) {
        User updatedUser = new User(id, name, age, email);
        return ResponseEntity.ok(userService.updateUser(id, updatedUser));
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
