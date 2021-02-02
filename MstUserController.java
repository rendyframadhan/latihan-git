package com.infosys.training.controller;


import com.infosys.training.model.CustomMapping;
import com.infosys.training.model.User;
import com.infosys.training.model.repository.UserRepository;
import com.infosys.training.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MstUserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> list = userRepository.findAll();
        if (list==null|| list.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User a = userRepository.save(user);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        User e = userRepository.save(user);

        return new ResponseEntity<>("Updated", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam String id){
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);

    }

    @GetMapping("/testGetOne")
    public ResponseEntity<User> getOneUser(@RequestParam String id){
        User u = userRepository.findById(id).get();

        return ResponseEntity.ok(u);
    }

    @GetMapping("/customMapping")
    public ResponseEntity<List<CustomMapping>> getCustomMapping(){
        List<CustomMapping> list = userDAO.getCustomQueryNative();
        List<CustomMapping> result = new ArrayList<>();
//        System.out.println(list);
        for (CustomMapping user : list){
            if (Integer.parseInt(user.getUmur()) > 17){
                System.out.println("Nama : "+user.getUserName());
                System.out.println("Umur : "+user.getUmur());
                System.out.println("Role : "+user.getRoleName());
                System.out.println("======================");
                result.add(user);
            }
        }

        return ResponseEntity.ok(result);
    }



}