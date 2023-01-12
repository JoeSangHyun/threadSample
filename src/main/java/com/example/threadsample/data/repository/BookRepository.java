package com.example.threadsample.data.repository;

import com.example.threadsample.config.JasyptConfig;
import com.example.threadsample.data.entity.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByIdx(Long idx);

    @Override
    List<Book> findAll(Sort sort);

    @Override
    List<Book> findAll();

    void deleteByIdx(Long idx);

}
