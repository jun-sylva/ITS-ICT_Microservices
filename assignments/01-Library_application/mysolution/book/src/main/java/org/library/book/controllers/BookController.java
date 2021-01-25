package org.library.book.controllers;

import lombok.extern.slf4j.Slf4j;
import org.library.book.models.Book;
import org.library.book.repos.BookRepository;
import org.library.book.services.TraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/lib/books/")
public class BookController {

    @Autowired
    TraceService traceService;

    @Autowired
    private BookRepository bookRepository;

    //CREATE BOOK
    @RequestMapping(method = RequestMethod.PUT)
    public void setBook(@RequestBody Book book){
        bookRepository.save(book);
        System.out.println(book);
    }

    //READ SINGLE BOOK BY ID
    @RequestMapping(value = "/{book_id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable String book_id){
        Optional<Book> bookOpt = bookRepository.findById(book_id);
        if (bookOpt.isPresent()){
            log.info("Successful to get " + book_id);
            System.out.println(bookOpt.get());
            return bookOpt.get();
        }else {
            log.error(book_id + " does not exist");
            return null;
        }
    }

    //READ ALL BOOK
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Book> getAllBook(){
        log.info("Successful to get all book");
        System.out.println(bookRepository.findAll());
        return bookRepository.findAll();
    }

    //UPDATE BOOKBY ID
    @RequestMapping(value = "/{book_id}", method = RequestMethod.POST)
    public Book updateBook (@RequestBody Book book, @RequestBody String book_id){
        log.info("Successful to update " + book_id);
        System.out.println(book);
        return bookRepository.save(book);
    }

    //DELETE SINGLE BOOK BY ID
    @RequestMapping(value = "/{book_id}", method = RequestMethod.DELETE)
    public void deleteBook (@PathVariable String book_id){
        log.info("Successful to delete" + book_id);
        bookRepository.deleteById(book_id);
        System.out.println(book_id + " is deleted");
    }

    //DELETE ALL BOOK PRESENT
    @RequestMapping(method = RequestMethod.DELETE)
    public void  deleteAllBook (){
        log.info("Successful to delete all");
        bookRepository.deleteAll();
        System.out.println("All books are deleted");
    }
}
