package com.mazsi.jpademo.repository;

import com.mazsi.jpademo.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
