package org.example.repo;

import org.example.pojo.Collection;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CollectionRepository extends CrudRepository<Collection, Long> {
    Optional<Collection> findCollectionByName(String name);
    Optional<Collection> findCollectionById(Long id);
    Optional<List<Collection>> findCollectionsByUser_Email(String email);
    Optional<Collection> findCollectionByUser_Email(String email);
}
