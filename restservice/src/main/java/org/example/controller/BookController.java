package org.example.controller;

import org.example.dto.BookCmd;
import org.example.dto.BookDto;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public void addBook(@RequestBody BookDto bookDto){
        bookService.addBook(bookDto);
    }

    @GetMapping("/getall")
    public List<BookCmd> getBooksByCollectionName(@RequestParam String collectionName){
        return bookService.getBooksByCollectionName(collectionName);
    }

    @DeleteMapping("/delete")
    public void deleteBook(@RequestParam String collectionName, @RequestParam String bookName){
        bookService.deleteByCollectionNameAndBookName(collectionName, bookName);
    }
}
