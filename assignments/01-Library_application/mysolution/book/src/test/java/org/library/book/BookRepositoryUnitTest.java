package org.library.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.book.models.Book;
import org.library.book.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryUnitTest {

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void testEmptyDB(){
        assertEquals(0,bookRepository.findAll().size()  );
    }

    @Test
    public void testAddOneCustomer(){
        Book book = new Book();
        book.setBook_id(1234567890);
        book.setTitle("Life");
        book.setAuthor("Junior");
        book.setEditing("Sylva ed");
        book.setYear(2021);
        book.setCategory("Drama");
        bookRepository.save(book);
        assertEquals(1,bookRepository.findAll().size()  );
    }
}
