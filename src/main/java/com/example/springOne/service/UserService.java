package com.example.springOne.service;

import com.example.springOne.api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

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

    public ResponseEntity<?> updateUser(Integer id, User updatedUser) {
        try {
            Optional<User> userOptional = getUser(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                if (updatedUser.getName() != null) {
                    user.setName(updatedUser.getName());
                }
                if (updatedUser.getAge() != null) {
                    user.setAge(updatedUser.getAge());
                }
                if (updatedUser.getEmail() != null) {
                    user.setEmail(updatedUser.getEmail());
                }

                return ResponseEntity.ok(user);
            }
        } catch (Exception e) {

            return ResponseEntity.status(1000).body(e.toString());
        }
        return ResponseEntity.status(1001).body("Exception Caught");
    }

    public void deleteUser(Integer id) {
        userList.removeIf(user -> user.getId() == id);
    }
}
