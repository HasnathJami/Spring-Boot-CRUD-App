package com.example.springOne.service;

import com.example.springOne.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        // Initialize the list with some dummy users
        userList.add(new User(1, "Jishan", 27, "j@gmail.com"));
        userList.add(new User(2, "Hasnath", 26, "hasnatj@gmail.com"));
        userList.add(new User(3, "Jami", 25, "jami@gmail.com"));
        userList.add(new User(4, "Chowdhury", 24, "chowdhury@gmail.com"));
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public Optional<User> getUser(Integer id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst();
    }

    public User createUser(User newUser) {
        userList.add(newUser);
        return newUser;
    }

    public User updateUser(Integer id, User updatedUser) {
        Optional<User> userOptional = getUser(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(updatedUser.getName());
            user.setAge(updatedUser.getAge());
            user.setEmail(updatedUser.getEmail());
            return user;
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public void deleteUser(Integer id) {
        userList.removeIf(user -> user.getId() == id);
    }
}
