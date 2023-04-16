package usama.springframework.spring6webapp.services;

import usama.springframework.spring6webapp.domain.Book;

public interface IBookService {
    Iterable<Book> getAllBooks();

}
