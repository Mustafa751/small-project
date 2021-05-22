package demo.demo.repositories;

import demo.demo.entities.contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface contactsrepository extends JpaRepository<contacts,Long > {

    Optional<contacts> findByIme(final String ime);

  Optional<contacts> findByRegistraciq(final String registracionen_nomer);

    Optional<contacts> findBypolica(final String polica);


}
