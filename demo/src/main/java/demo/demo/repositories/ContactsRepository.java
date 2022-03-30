package demo.demo.repositories;

import demo.demo.entities.contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ContactsRepository extends JpaRepository<contacts,Long > {

    Optional<contacts> findByIme(final String ime);

  Optional<contacts> findByRegistraciq(final String registracionen_nomer);

    Optional<contacts> findByPolica(final String polica);
}
