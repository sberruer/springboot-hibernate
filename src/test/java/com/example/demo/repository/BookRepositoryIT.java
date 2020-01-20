package com.example.demo.repository;

import com.example.demo.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookRepositoryIT {

    @Autowired
    private BookRepository repository;

    @Test
    @Order(1)
    public void testSave() {
        Book book = new Book();

        repository.save(book);

        Assertions.assertThat(book.getId()).isNotNull();
    }

    @Test
    @Order(2)
    public void testFindAll() {
        Iterable<Book> books = repository.findAll();

        Assertions.assertThat(books).hasSizeGreaterThanOrEqualTo(1);
    }
}
