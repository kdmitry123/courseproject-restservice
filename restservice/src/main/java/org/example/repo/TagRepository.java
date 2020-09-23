package org.example.repo;

import org.example.pojo.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends CrudRepository<Tag, Long> {
    Optional<List<Tag>> findTagsByCollection_Name(String name);
}
