package com.mazsi.jpademo.utils;

import com.mazsi.jpademo.config.Application;
import com.mazsi.jpademo.entity.Course;
import com.mazsi.jpademo.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class TestCommandLineRunner implements CommandLineRunner {

    @Autowired
    Application application;


    @Override
    public void run(String... args) throws Exception {

    }
}
