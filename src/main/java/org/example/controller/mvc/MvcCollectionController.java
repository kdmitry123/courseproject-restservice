package org.example.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcCollectionController {

    @GetMapping("/addcollection")
    public String addCollection(){
        return "addCollection";
    }

}
