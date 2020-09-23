package org.example.service;

import org.example.dto.TagCmd;
import org.example.dto.TagDto;
import org.example.pojo.Tag;
import org.example.repo.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    CollectionService collectionService;

    public void addTag(TagDto tagDto){
        String collectionName = tagDto.getCollectionName();
        if(collectionService.collectionNameIsPresent(collectionName)){
            Tag tag = new Tag();
            tag.setText(tagDto.getText());
            tag.setCollection(collectionService.getCollectionByName(tagDto.getCollectionName()));
            tagRepository.save(tag);
        }
    }

    public List<TagCmd> getTagsByCollectionName(String name){
        List<TagCmd> tagCmdList = new ArrayList<>();
        tagRepository.findTagsByCollection_Name(name).get().forEach(tag -> tagCmdList.add(new TagCmd(tag.getText())));
        return tagCmdList;
    }

    public Set<TagCmd> getAllTags(){
        Set<TagCmd> tagCmdSet = new HashSet<>();
        tagRepository.findAll().forEach(tag -> tagCmdSet.add(new TagCmd(tag.getText())));
        return tagCmdSet;
    }

}
