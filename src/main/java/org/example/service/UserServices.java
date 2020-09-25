package org.example.service;

import org.example.dto.UserCmd;
import org.example.dto.UserDto;
import org.example.pojo.User;
import org.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public void saveUser(UserDto userDto){
        if(!userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            User user = new User();
            user.setFirstname(userDto.getFirstname());
            user.setSecondname(userDto.getSecondname());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setRole(userDto.getRole());
            userRepository.save(user);
        }
    }

    public List<UserCmd> getAllUsers(){
        final List<UserCmd> list = new ArrayList<>();
        userRepository.findAll().forEach(user -> list.add(new UserCmd(user.getFirstname(), user.getSecondname(), user.getEmail(), user.getRole())));
        return list;
    }

    public void deleteUserByEmail(String email){
        if(userRepository.findByEmail(email).isPresent()){
            userRepository.delete(userRepository.findByEmail(email).get());
        }
    }

    public boolean userEmailIsPresent(String email){
        return userRepository.findByEmail(email).isPresent();
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).get();
    }


    public void updateUserByEmail(String email, UserCmd userCmd){
        User userDB = userRepository.findByEmail(email).get();
        userDB.setFirstname(userCmd.getFirstname());
        userDB.setSecondname(userCmd.getSecondname());
        userDB.setRole(userCmd.getRole());
        userDB.setPassword(userDB.getPassword());
        userRepository.save(userDB);
    }

    public void updateUserPassword(String email, String password){
        User userDB = userRepository.findByEmail(email).get();
        userDB.setPassword(password);
        userDB.setFirstname(userDB.getFirstname());
        userDB.setSecondname(userDB.getSecondname());
        userDB.setEmail(userDB.getEmail());
        userDB.setRole(userDB.getRole());
        userRepository.save(userDB);
    }
}
