package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {


    private final EntityManager entityManager;

    @Transactional
    public Book createBook(Book book) {
        return entityManager.merge(book);
    }


    @Transactional
    public Book getBookById(int id) {
        return entityManager.find(Book.class, id);
    }


    @Transactional
    public List<Book> findAllBooks() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
    }





}
