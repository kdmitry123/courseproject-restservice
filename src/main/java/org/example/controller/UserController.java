package org.example.controller;

import org.example.dto.UserCmd;
import org.example.dto.UserDto;
import org.example.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("/add")
    public void addUser(@RequestBody UserDto userDto){
        userServices.saveUser(userDto);
    }

    @GetMapping("/getall")
    public List<UserCmd> getAllUsers(){
        return userServices.getAllUsers();
    }

    @DeleteMapping("/delete/{email}")
    public void delete(@PathVariable String email){
        userServices.deleteUserByEmail(email);
    }

    @PutMapping("/{email}")
    public void update(@PathVariable String email, UserCmd userCmd){
        userServices.updateUserByEmail(email, userCmd);
    }
    @PutMapping("/update/{email}")
    public void updatePassword(@PathVariable String email, @RequestParam String password){
        userServices.updateUserPassword(email, password);
    }

}
