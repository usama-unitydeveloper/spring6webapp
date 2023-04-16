package usama.springframework.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import usama.springframework.spring6webapp.services.IBookService;

@Controller
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping("/books")
    public String getAllBooks(Model model)
    {
        model.addAttribute("books",bookService.getAllBooks());
        return "books";
    }
}
