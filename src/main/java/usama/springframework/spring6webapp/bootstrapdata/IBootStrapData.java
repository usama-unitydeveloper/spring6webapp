package usama.springframework.spring6webapp.bootstrapdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import usama.springframework.spring6webapp.domain.Author;
import usama.springframework.spring6webapp.domain.Book;
import usama.springframework.spring6webapp.domain.Publisher;
import usama.springframework.spring6webapp.repository.IAuthorRepository;
import usama.springframework.spring6webapp.repository.IBookRepository;
import usama.springframework.spring6webapp.repository.IPublisherRepository;

import java.util.List;

@Component
public class IBootStrapData
        implements CommandLineRunner {
     private final IAuthorRepository authorRepository;
     private final IBookRepository bookRepository;
     private final IPublisherRepository publisherRepository;
    @Autowired
    public IBootStrapData(IAuthorRepository authorRepository,
                          IBookRepository bookRepository,
                          IPublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author(
                "Usama",
                "Manzoor"
        );


        Author author1 = new Author(
                "Zabeeh",
                "Rehman"
        );


        Book book = new Book(
                "Introduction to Computing",
                "12345"
        );


        Book book1 = new Book(
                "Programming Fundamentals",
                "67890"
                );


        Publisher publisher = new Publisher(
                "Ahmad Raza",
                "Abc123 Street",
                "Lahore",
                "6767");

        Author authorSaved = authorRepository.save(author);
        Author author1Saved = authorRepository.save(author1);


        Book bookSaved = bookRepository.save(book);
        Book book1Saved = bookRepository.save(book1);

        Publisher savedPublisher = publisherRepository.save(publisher);

        bookSaved.setPublisher(savedPublisher);
        book1Saved.setPublisher(savedPublisher);



        authorSaved.getBooks().add(bookSaved);
        author1Saved.getBooks().add(book1Saved);
        bookSaved.getAuthors().add(authorSaved);
        bookSaved.getAuthors().add(author1Saved);


        authorRepository.saveAll(List.of( authorSaved,author1Saved));
        bookRepository.saveAll(List.of(bookSaved,book1Saved));
        publisherRepository.save(publisher);


        System.out.println("InBootStrap Run");
        System.out.println("Books count : " + bookRepository.count());
        System.out.println("Publisher count : "+ publisherRepository.count());

        System.out.println("Authors count : " + authorRepository.count());




    }
}
