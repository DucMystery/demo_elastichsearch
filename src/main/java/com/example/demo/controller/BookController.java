package com.example.demo.controller;

import com.example.demo.models.Book;
import com.example.demo.models.Newspaper;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book/{id}",method = RequestMethod.GET)
    public ResponseEntity<Book> getOne(@PathVariable Long id){
        Book book  = bookService.findById(id);
        return new ResponseEntity<>(book , HttpStatus.OK);
    }

    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public ResponseEntity<Iterable<Book>> getOne(){
        Iterable<Book> books = bookService.findAll();
        return new ResponseEntity<>(books , HttpStatus.OK);
    }

    @RequestMapping(value = "/books" , method = RequestMethod.POST)
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book currentBook = bookService.createBook(book);
        Newspaper newspaper = null;
        return new ResponseEntity<>(currentBook,HttpStatus.OK);
    }
}
