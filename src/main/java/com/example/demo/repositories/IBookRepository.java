package com.example.demo.repositories;

import com.example.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {


    Book save(Book book);

    List<Book> findAllByTitle(String title);
    List<Book> findAllByIsbn(String isbn);


}
