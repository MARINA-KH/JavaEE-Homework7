package com.example.demo.controllers;
import com.example.demo.repositories.IBookRepository;
import com.example.demo.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

    @Autowired
    private IBookRepository bookRepository;


    @RequestMapping(value = "/add-book", method = RequestMethod.GET)
    public String addBookGet() {
        return "form";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addBookPost(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", book);
        bookRepository.save(book);
        return "redirect:/books-list";
    }

    @RequestMapping(value = "/books-list", method = RequestMethod.GET)
    public String bookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/books-list/book/{id}", method = RequestMethod.GET)
    public String getBookPathVariable(
            @PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookRepository.getOne(id));

        return "SampleInfo";
    }


    @RequestMapping(value = "/books-list/find-by-title")
    public String findBookByTitle(
            @RequestParam("title") String title, Model model) {
        model.addAttribute("books", bookRepository.findAllByTitle(title));
        return "search-results";
    }


    @RequestMapping(value = "/books-list/find-by-isbn")
    public String findBookByIsbn(
            @RequestParam("isbn") String isbn, Model model) {
        model.addAttribute("books", bookRepository.findAllByIsbn(isbn));
        return "search-results";
    }



}
