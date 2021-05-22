package demo.demo.controllers;

import demo.demo.entities.contacts;
import demo.demo.repositories.contactsrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("contacts")

public class contactscontroller {
@Autowired
    contactsrepository ContactsRepository;
@RequestMapping("/all")
    List<contacts> getAllcontacts(){return ContactsRepository.findAll();}

    @GetMapping("/{id}")
    public contacts getAdById(@PathVariable Long id) {
        Optional<contacts> result = ContactsRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }
     @GetMapping("/ime/{ime}")
     public ResponseEntity<?> getcontactByime(@PathVariable(required = false) String ime) {
         if (ime == null || ime.isBlank()) {
             return ResponseEntity.ok().body("No ime inserted!");
         }
         Optional<contacts> result = ContactsRepository.findByIme(ime);
         return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.ok("nqma takova ime!");
  }
   @GetMapping("/registraciq/{registraciq}")
    public ResponseEntity<?> getAdByregistraciq(@PathVariable String registraciq)  {

        if (registraciq == null || registraciq.isBlank()) {
            return ResponseEntity.ok().body("No registraciq inserted!");
        }
        Optional<contacts> result = ContactsRepository.findByRegistraciq(registraciq);
        return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.ok("nqma takava registraciq!");
    }

    @GetMapping("/polica/{polica}")
    public ResponseEntity<?> getAdBypolica(@PathVariable String polica)  {

        if (polica == null || polica.isBlank()) {
            return ResponseEntity.ok().body("No nomer_polica inserted!");
        }
        Optional<contacts> result = ContactsRepository.findBypolica(polica);
        return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.ok("No contact found!");
    }



   @PostMapping("/save")
    public ResponseEntity<?> saveAd(@RequestParam(required = false) Long id,
                                    @RequestParam(required = false) String ime,
                                    @RequestParam(required = false) String familiq,
                                    @RequestParam(required = false) String registraciq,
                                    @RequestParam(required = false) String otkude,
                                    @RequestParam(required = false) String polica,
                                    @RequestParam(required = false) String nachalna_data,
                                    @RequestParam(required = false) String kraina_data,
                                    @RequestParam(required = false) String suma,
                                    @RequestParam(required = false) String egn,
                                    @RequestParam(required = false) String telefon){

        boolean isNew = id == null;

        contacts contact = new contacts(id, ime, familiq, registraciq,otkude,polica,nachalna_data,kraina_data,suma,egn,telefon);
       contact = ContactsRepository.save(contact);

        Map<String, Object> response = new HashMap<>();
        response.put("generatedId", contact.getId());
        response.put("generatedIme", contact.getIme());
        response.put("generatedFamiliq", contact.getFamiliq());
        response.put("generatedRegistraciq", contact.getRegistraciq());
        response.put("generatedOtkude", contact.getOtkude());
       response.put("generatednomer_polica", contact.getPolica());
       response.put("generatednachalna_data", contact.getNachalna_data());
       response.put("generatedkraina_data", contact.getKraina_data());
       response.put("generatedsuma", contact.getSuma());
       response.put("generatedegn", contact.getEgn());
       response.put("generatedtelefon", contact.getTelefon());

        if (isNew) {
            response.put("message", "Successfully added!");
        } else {
            response.put("message", "Successfully edited!");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAd(@PathVariable Long id) {

        if (!ContactsRepository.existsById(id)) {
            return ResponseEntity.ok("No such contact!");
        }
        ContactsRepository.deleteById(id);
        return ResponseEntity.ok("Deleted successfully!");
    }
}
