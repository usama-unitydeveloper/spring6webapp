package usama.springframework.spring6webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import usama.springframework.spring6webapp.domain.Author;
@Repository
public interface IAuthorRepository extends CrudRepository<Author,Long> {
}
