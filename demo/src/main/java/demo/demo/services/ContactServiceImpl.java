package demo.demo.services;

import demo.demo.entities.contacts;
import demo.demo.repositories.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class ContactsServiceImpl implements ContactsService{

    @Autowired
    ContactsRepository contactsrepository;

    @Override
    public List<contacts> findAll() {
        return contactsrepository.findAll();
    }

    @Override
    public Optional<contacts> findById(Long id) {
        return contactsrepository.findById(id);
    }

    @Override
    public Optional<contacts> findByIme(String ime) {
        return contactsrepository.findByIme(ime);
    }

    @Override
    public Optional<contacts> findByRegistraciq(String registraciq) {
        return contactsrepository.findByRegistraciq(registraciq);
    }

    @Override
    public Optional<contacts> findByPolica(String polica) {
        return contactsrepository.findByPolica(polica);
    }

    @Override
    public contacts save(contacts contact) {
        return contactsrepository.save(contact);
    }

    @Override
    public boolean existsById(Long id) {
        return contactsrepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        contactsrepository.deleteById(id);
    }


}
