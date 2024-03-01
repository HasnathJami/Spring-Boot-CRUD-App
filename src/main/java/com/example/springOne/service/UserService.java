package com.example.springOne.service;

import com.example.springOne.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1,"Jishan", 27, "j@gmail.com");
        User user2 = new User(2,"Hasnath", 26, "hasnatj@gmail.com");
        User user3 = new User(3,"Jami", 25, "jami@gmail.com");
        User user4 = new User(4,"Chowdhury", 24, "chowdhury@gmail.com");

        userList.addAll(Arrays.asList(user1,user2,user3,user4));
    }

    public Optional<User> getUser(Integer id) {
        Optional<User> optional = Optional.empty();
        for (User user: userList) {
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}