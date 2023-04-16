package usama.springframework.spring6webapp.repository;

import org.springframework.data.repository.CrudRepository;
import usama.springframework.spring6webapp.domain.Publisher;

public interface IPublisherRepository
        extends CrudRepository<Publisher,Long> {
}
