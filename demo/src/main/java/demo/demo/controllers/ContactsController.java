package demo.demo.controllers;

import demo.demo.entities.contacts;
import demo.demo.repositories.ContactsRepository;
import demo.demo.services.ContactsService;
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

public class ContactsController {
@Autowired
    ContactsService contactsService;
@RequestMapping("/all")
    List<contacts> getAllContacts()
{return contactsService.findAll();}

    @GetMapping("/{id}")
    public contacts getAdById(@PathVariable Long id) {
        Optional<contacts> result = contactsService.findById(id);
        return result.orElse(null);
    }
     @GetMapping("/ime/{ime}")
     public ResponseEntity<?> getContactByIme(@PathVariable(required = false) String ime) {
         if (ime == null || ime.isBlank()) {
             return ResponseEntity.ok().body("No ime inserted!");
         }
         Optional<contacts> result = contactsService.findByIme(ime);
         return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.ok("nqma takova ime!");
  }
   @GetMapping("/registraciq/{registraciq}")
    public ResponseEntity<?> getAdByRegistraciq(@PathVariable String registraciq)  {

        if (registraciq == null || registraciq.isBlank()) {
            return ResponseEntity.ok().body("No registraciq inserted!");
        }
        Optional<contacts> result = contactsService.findByRegistraciq(registraciq);
        return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.ok("nqma takava registraciq!");
    }

    @GetMapping("/polica/{polica}")
    public ResponseEntity<?> getAdByPolica(@PathVariable String polica)  {

        if (polica == null || polica.isBlank()) {
            return ResponseEntity.ok().body("No nomer_polica inserted!");
        }
        Optional<contacts> result = contactsService.findByPolica(polica);
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
       contact = contactsService.save(contact);

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

        if (!contactsService.existsById(id)) {
            return ResponseEntity.ok("No such contact!");
        }
        contactsService.deleteById(id);
        return ResponseEntity.ok("Deleted successfully!");
    }
}
