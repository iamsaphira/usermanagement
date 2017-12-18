package com.example.demo.com.example.demo.maypack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import java.util.ArrayList;

@Service
public class  UserService {
    @Autowired
    private UserRepository userrepository;


    public void addUser(User user) {
        userrepository.save(user);
    }

    public List<User> listUsers() {
        java.util.List<User> users=new ArrayList<>();
        userrepository.findAll().forEach(users::add );

       return users;
        
    }

    public void deleteUser(String id) {
        userrepository.delete(Integer.parseInt(id));
    }

    public void updateUser(User user) {
        userrepository.save(user);
    }

    public User findById(String id){
        return userrepository.findById(Integer.parseInt(id));
    }
}
