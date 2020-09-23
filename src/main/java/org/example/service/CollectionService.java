package org.example.service;

import org.example.dto.CollectionCmd;
import org.example.dto.CollectionDto;
import org.example.pojo.Collection;
import org.example.repo.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    UserServices userServices;

    public boolean collectionNameIsPresent(String name){
        return collectionRepository.findCollectionByName(name).isPresent();
    }

    public Collection getCollectionByName(String name){
        return collectionRepository.findCollectionByName(name).get();
    }

    public Collection getCollectionById(Long id){
        return collectionRepository.findCollectionById(id).get();
    }

    public void addCollection(CollectionDto collectionDto){
        if(userServices.userEmailIsPresent(collectionDto.getUserEmail())){
            Collection collection = new Collection();
            collection.setName(collectionDto.getName());
            collection.setDescription(collectionDto.getDescription());
            collection.setImage(collectionDto.getImage());
            collection.setUser(userServices.getUserByEmail(collectionDto.getUserEmail()));
            collectionRepository.save(collection);
        }
    }

    public List<CollectionCmd> getCollectionsByUserEmail(String email){
        List<CollectionCmd> collectionCmdList = new ArrayList<>();
        collectionRepository.findCollectionsByUser_Email(email).get().forEach(collection -> {
            CollectionCmd collectionCmd = new CollectionCmd();
            collectionCmd.setDescription(collection.getDescription());
            collectionCmd.setName(collection.getName());
            collectionCmd.setImage(collection.getImage());
            collectionCmdList.add(collectionCmd);
        });
        return collectionCmdList;
    }

    public void deleteByEmailAndCollection(String userEmail, String collectionName){
        List<Collection> listCollection = collectionRepository.findCollectionsByUser_Email(userEmail).get();
        listCollection.forEach(elem -> {
            if(collectionName.equals(elem.getName())){
                collectionRepository.delete(elem);
            }
        });
    }

    public void updateCollectionByName(String name, CollectionDto collectionDto){
        Collection collection = collectionRepository.findCollectionByName(name).get();
        collection.setName(collectionDto.getName());
        collection.setDescription(collectionDto.getDescription());
        collection.setImage(collectionDto.getImage());
        collection.setId(collection.getId());
        collectionRepository.save(collection);
    }

}
