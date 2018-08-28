package com.mazsi.jpademo.repository;

import com.mazsi.jpademo.JpaDemoApplication;
import com.mazsi.jpademo.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
@Slf4j
public class CourseRepositoryTests {

    @Autowired
    CourseRepository repository;

    @Test
    public void testFindById() {
//        Course course = repository.findById(100L);
//        log.info("\n\nTeszt futtatása...\n\n");
//        assertEquals("JPA in 50 Steps", course.getName());
    }

    @Test
    @DirtiesContext
    public void testDeleteById() {
//        repository.deleteById(100L);
//        assertNull(repository.findById(100L));
    }

    @Test
    @DirtiesContext
    public void testInsert() {
//        Course course = repository.findById(100L);
//        assertEquals("JPA in 50 Steps", course.getName());
//
//        course.setName("JPA in 50 Steps - Updated");
//        repository.save(course);
//
//        course = repository.findById(100L);
//        assertEquals("JPA in 50 Steps - Updated", course.getName());
    }

    @Test
    @DirtiesContext
    public void playWithEntittyManager() {
//        repository.playWithEntityManager();
//        log.info("\n\nElindult...\n\n");
    }

}
