package com.artiushenko.socnet.controller;

import com.artiushenko.socnet.entity.Town;
import com.artiushenko.socnet.entity.User;
import com.artiushenko.socnet.service.TownService;
import com.artiushenko.socnet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/all")
    public List<User> getAll(){
        List<User> users = service.findAll();
        return users;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    @CrossOrigin
    @GetMapping("/select/{id}")
    public User selectOne(@PathVariable("id") int id){
        User user = service.select(id);
        return user;
    }
}
