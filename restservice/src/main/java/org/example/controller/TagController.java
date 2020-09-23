package org.example.controller;

import org.example.dto.TagCmd;
import org.example.dto.TagDto;
import org.example.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("tags")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping("/add")
    public void addTag(@RequestBody TagDto tagDto){
        tagService.addTag(tagDto);
    }

    @GetMapping("/getall")
    public Set<TagCmd> getAllTags(){
        return tagService.getAllTags();
    }

    @GetMapping("/gettagsbycollectionname")
    public List<TagCmd> getTagsByCollectionName(@RequestParam String collectionName){
        return tagService.getTagsByCollectionName(collectionName);
    }
}
