package org.example.controller;

import org.example.dto.CollectionCmd;
import org.example.dto.CollectionDto;
import org.example.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("collections")
public class CollectionController {

    @Autowired
    CollectionService collectionService;

    @PostMapping("/add")
    public void addCollection(@RequestBody CollectionDto collectionDto){
        collectionService.addCollection(collectionDto);
    }

    @GetMapping("/getall")
    public List<CollectionCmd> getCollectionsByUserEmail(@RequestParam String email){
        return collectionService.getCollectionsByUserEmail(email);
    }

    @DeleteMapping("/delete")
    public void deleteCollection(@RequestParam String userEmail, @RequestParam String collectionName){
        collectionService.deleteByEmailAndCollection(userEmail, collectionName);
    }

    @PutMapping("/update/{name}")
    public void updateCollection(@RequestParam String name, @RequestBody CollectionDto collectionDto){
        collectionService.updateCollectionByName(name, collectionDto);

    }
}
