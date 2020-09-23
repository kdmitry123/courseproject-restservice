package org.example.repo;

import org.example.pojo.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<List<Book>> findBooksByCollection_Name(String name);
}
