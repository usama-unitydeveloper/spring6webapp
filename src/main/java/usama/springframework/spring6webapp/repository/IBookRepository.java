package usama.springframework.spring6webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import usama.springframework.spring6webapp.domain.Book;
@Repository
public interface IBookRepository extends CrudRepository<Book,Long> {
}
