package org.example.service;

import org.example.dto.BookCmd;
import org.example.dto.BookDto;
import org.example.pojo.Book;
import org.example.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CollectionService collectionService;

    public void addBook(BookDto bookDto){
        String collectionName = bookDto.getCollectionName();
        if(collectionService.collectionNameIsPresent(collectionName)){
            Book book = new Book();
            book.setName(bookDto.getName());
            book.setAuthor(bookDto.getAuthor());
            book.setCollection(collectionService.getCollectionByName(bookDto.getCollectionName()));
            bookRepository.save(book);

        }
    }

    public List<BookCmd> getBooksByCollectionName(String name){
        List<BookCmd> bookCmdList = new ArrayList<>();
        List<Book> bookList = bookRepository.findBooksByCollection_Name(name).get();
        bookList.forEach(book -> {
            BookCmd bookCmd = new BookCmd();
            bookCmd.setName(book.getName());
            bookCmd.setAuthor(book.getAuthor());
            bookCmdList.add(bookCmd);
        });
        return bookCmdList;
    }

    public void deleteByCollectionNameAndBookName(String collectionName, String bookName){
        Long id = collectionService.getCollectionByName(collectionName).getId();
        List<Book> bookList = bookRepository.findBooksByCollection_Name(collectionName).get();
        bookList.forEach(elem -> {
            if(id.equals(elem.getId())){
                bookRepository.delete(elem);
            }
        });
    }
}
