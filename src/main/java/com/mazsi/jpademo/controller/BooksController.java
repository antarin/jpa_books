package com.mazsi.jpademo.controller;

import com.mazsi.jpademo.entity.Books;
import com.mazsi.jpademo.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/book", consumes = APPLICATION_JSON_VALUE)
public class BooksController {

    @Autowired
    BooksRepository booksRepository;

    @GetMapping
    public List<Books> getBooks() {
        return booksRepository.findAll();
    }

    @PostMapping
    public Books addBook(@RequestBody Books book) {
        return booksRepository.save(book);
    }
}
