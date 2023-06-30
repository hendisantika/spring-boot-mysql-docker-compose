package com.hendisantika.controller;

import com.hendisantika.entity.Book;
import com.hendisantika.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-docker-compose
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/30/23
 * Time: 10:05
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequiredArgsConstructor
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookRepository bookRepository;

    @GetMapping("/")
    public String displayForm(Model model) {
        logger.info("*** displayForm () method execution start ***");
        Book bookObj = new Book();
        model.addAttribute("book", bookObj);

        List<Book> booksList = bookRepository.findAll();
        model.addAttribute("books", booksList);

        logger.info("*** displayForm () method execution end ***");
        return "index";
    }

    @PostMapping("/")
    public String saveBook(Book book, Model model) {
        logger.info("*** saveBook () method execution start ***");
        bookRepository.save(book);
        List<Book> booksList = bookRepository.findAll();
        model.addAttribute("books", booksList);

        Book bookObj = new Book();
        model.addAttribute("book", bookObj);


        model.addAttribute("msg", "Book Saved Successfully");
        logger.info("*** saveBook () method execution end ***");
        return "index";
    }

}
