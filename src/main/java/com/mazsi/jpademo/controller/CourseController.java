package com.mazsi.jpademo.controller;

import com.mazsi.jpademo.entity.Books;
import com.mazsi.jpademo.entity.Course;
import com.mazsi.jpademo.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Slf4j
@RestController
@RequestMapping(value = "/course", produces = APPLICATION_JSON_VALUE)
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public List<Course> getBooks() {
        return courseRepository.findAll();
    }
}
