package usama.springframework.spring6webapp.bootstrapdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import usama.springframework.spring6webapp.domain.Author;
import usama.springframework.spring6webapp.domain.Book;
import usama.springframework.spring6webapp.repository.IAuthorRepository;
import usama.springframework.spring6webapp.repository.IBookRepository;

import java.util.List;

@Component
public class IBootStrapData
        implements CommandLineRunner {
     private final IAuthorRepository authorRepository;
     private final IBookRepository bookRepository;
    @Autowired
    public IBootStrapData(IAuthorRepository authorRepository,IBookRepository bookRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("Usama");
        author.setLastName("Manzoor");

        Author author1 = new Author();
        author1.setFirstName("Zabeeh");
        author1.setLastName("Rehman");

        Book book = new Book();
        book.setTitle("Introduction to Computing");
        book.setIsBin("12345");

        Book book1 = new Book();
        book1.setTitle("Programming Fundamentals");
        book1.setIsBin("67890");

        Author authorSaved = authorRepository.save(author);
        Author author1Saved = authorRepository.save(author1);


        Book bookSaved = bookRepository.save(book);
        Book book1Saved = bookRepository.save(book1);

        authorSaved.getBooks().add(bookSaved);
        author1Saved.getBooks().add(book1Saved);


        authorRepository.saveAll(List.of( authorSaved,author1Saved));


        System.out.println("InBootStrap Run");
        System.out.println("Books count : " + bookRepository.count());

        System.out.println("Authors count : " + authorRepository.count());




    }
}
