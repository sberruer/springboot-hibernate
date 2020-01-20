package com.example.demo.repository;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookRepositoryIT {

    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorRepository authorRepository;

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

    @Test
    @Commit
    public void beforeAll() {
        Author allanEdgarPoe = new Author();
        allanEdgarPoe.setFirstName("Allan");

        Author arthurConanDoyle = new Author();
        allanEdgarPoe.setFirstName("Arthur");

        authorRepository.save(allanEdgarPoe);
        authorRepository.save(arthurConanDoyle);

        Book book = new Book();
        book.getAuthors().add(allanEdgarPoe);
        book.getAuthors().add(arthurConanDoyle);

        repository.save(book);

        Assertions.assertThat(book.getAuthors()).hasSize(2);
    }
}
