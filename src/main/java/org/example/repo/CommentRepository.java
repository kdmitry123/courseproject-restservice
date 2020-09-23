package org.example.repo;

import org.example.pojo.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    Optional<List<Comment>> findCommentsByCollection_Name(String name);
}
