package com.example.demo.repository;

import com.example.demo.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryIT {

    @Autowired
    private BookRepository repository;

    @Test
    public void testCreate() {
        Book book = new Book();

        repository.save(book);

        Assertions.assertThat(book.getId()).isNotNull();
    }
}
