package org.example.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcHomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "homePage.html";
    }



}
