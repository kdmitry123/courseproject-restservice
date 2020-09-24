package org.example.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MvcUserController {

    @GetMapping("/register")
    public String showRegistrationPage(){
        return "registerUser";
    }

    @GetMapping("/getallusers")
    public String getUsers(){
        return "allUsers";
    }
}
