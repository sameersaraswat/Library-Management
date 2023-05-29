package com.example.library_management.controller;

import com.example.library_management.models.Book;
import com.example.library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping("/")
    public void CreateBook(@RequestBody Book book)  {
        this.bookService.createBook(book);
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(this.bookService.getAllBooks());
    }


}
