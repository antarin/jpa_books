package com.mazsi.jpademo.repository;

import com.mazsi.jpademo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


}
