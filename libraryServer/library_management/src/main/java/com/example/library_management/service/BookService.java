package com.example.library_management.service;

import com.example.library_management.models.Book;
import java.util.List;

public interface BookService {

    public void createBook(Book book);

    public List<Book> getAllBooks();


}
