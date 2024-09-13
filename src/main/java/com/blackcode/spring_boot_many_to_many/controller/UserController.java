package com.blackcode.spring_boot_many_to_many.controller;

import com.blackcode.spring_boot_many_to_many.model.User;
import com.blackcode.spring_boot_many_to_many.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getListAll(){
        return ResponseEntity.ok(userService.getListAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> userData = userService.getUserById(id);
        return new ResponseEntity<>(userData.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User userData = userService.addUser(user);
        return new ResponseEntity<>(userData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User userData = userService.updateUser(id, user);
        return new ResponseEntity<>(userData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        boolean userRtn = userService.deleteUser(id);
        if(userRtn){
            return new ResponseEntity<>("Data Success Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Data Failed Delete", HttpStatus.NOT_FOUND);
    }
}
