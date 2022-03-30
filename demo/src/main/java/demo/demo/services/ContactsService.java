package demo.demo.services;

import demo.demo.entities.contacts;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactsService {
    List<contacts> findAll();

    Optional<contacts> findById(Long id);

    Optional<contacts> findByIme(String ime);

    Optional<contacts> findByRegistraciq(String registraciq);

    Optional<contacts> findByPolica(String polica);

    contacts save(contacts contact);

    boolean existsById(Long id);

    void deleteById(Long id);
}
