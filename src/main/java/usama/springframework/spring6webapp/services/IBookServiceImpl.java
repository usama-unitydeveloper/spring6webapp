package usama.springframework.spring6webapp.services;

import org.springframework.stereotype.Service;
import usama.springframework.spring6webapp.domain.Book;
import usama.springframework.spring6webapp.repository.IBookRepository;



@Service
public class IBookServiceImpl implements IBookService {
    private final IBookRepository bookRepository;

    public IBookServiceImpl(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
