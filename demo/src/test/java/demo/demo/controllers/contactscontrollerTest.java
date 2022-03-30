package demo.demo.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import demo.demo.entities.contacts;
import demo.demo.repositories.ContactsRepository;

import java.util.ArrayList;

import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ContactsController.class})
@ExtendWith(SpringExtension.class)
public class contactscontrollerTest {
    @Autowired
    private ContactsController contactscontroller;

    @MockBean
    private ContactsRepository contactsrepository;

    @Test
    public void testDeleteAd() throws Exception {
        doNothing().when(this.contactsrepository).deleteById((Long) any());
        when(this.contactsrepository.existsById((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/contacts/{id}", 1L);
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Deleted successfully!")));
    }

    @Test
    public void testDeleteAd2() throws Exception {
        doNothing().when(this.contactsrepository).deleteById((Long) any());
        when(this.contactsrepository.existsById((Long) any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/contacts/{id}", 1L);
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("No such contact!")));
    }

    @Test
    public void testGetAdById() throws Exception {
        contacts contacts = new contacts();
        contacts.setFamiliq("Familiq");
        contacts.setSuma("Suma");
        contacts.setNachalna_data("Nachalna data");
        contacts.setId(123L);
        contacts.setRegistraciq("Registraciq");
        contacts.setTelefon("Telefon");
        contacts.setEgn("Egn");
        contacts.setOtkude("Otkude");
        contacts.setPolica("Polica");
        contacts.setKraina_data("Kraina data");
        contacts.setIme("Ime");
        Optional<contacts> ofResult = Optional.<contacts>of(contacts);
        when(this.contactsrepository.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts/{id}", 1L);
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"id\":123,\"ime\":\"Ime\",\"familiq\":\"Familiq\",\"registraciq\":\"Registraciq\",\"otkude\":\"Otkude\",\"polica\":"
                                        + "\"Polica\",\"nachalna_data\":\"Nachalna data\",\"kraina_data\":\"Kraina data\",\"suma\":\"Suma\",\"egn\":\"Egn\",\"telefon"
                                        + "\":\"Telefon\"}")));
    }

    @Test
    public void testGetAdById2() throws Exception {
        when(this.contactsrepository.findById((Long) any())).thenReturn(Optional.<contacts>empty());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts/{id}", 1L);
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAdBypolica() throws Exception {
        contacts contacts = new contacts();
        contacts.setFamiliq("Familiq");
        contacts.setSuma("Suma");
        contacts.setNachalna_data("Nachalna data");
        contacts.setId(123L);
        contacts.setRegistraciq("Registraciq");
        contacts.setTelefon("Telefon");
        contacts.setEgn("Egn");
        contacts.setOtkude("Otkude");
        contacts.setPolica("Polica");
        contacts.setKraina_data("Kraina data");
        contacts.setIme("Ime");
        Optional<contacts> ofResult = Optional.<contacts>of(contacts);
        when(this.contactsrepository.findByPolica(anyString())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts/polica/{polica}", "value");
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"id\":123,\"ime\":\"Ime\",\"familiq\":\"Familiq\",\"registraciq\":\"Registraciq\",\"otkude\":\"Otkude\",\"polica\":"
                                        + "\"Polica\",\"nachalna_data\":\"Nachalna data\",\"kraina_data\":\"Kraina data\",\"suma\":\"Suma\",\"egn\":\"Egn\",\"telefon"
                                        + "\":\"Telefon\"}")));
    }

    @Test
    public void testGetAdBypolica2() throws Exception {
        when(this.contactsrepository.findByPolica(anyString())).thenReturn(Optional.<contacts>empty());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts/polica/{polica}", "value");
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("No contact found!")));
    }

    @Test
    public void testGetAdByregistraciq() throws Exception {
        contacts contacts = new contacts();
        contacts.setFamiliq("Familiq");
        contacts.setSuma("Suma");
        contacts.setNachalna_data("Nachalna data");
        contacts.setId(123L);
        contacts.setRegistraciq("Registraciq");
        contacts.setTelefon("Telefon");
        contacts.setEgn("Egn");
        contacts.setOtkude("Otkude");
        contacts.setPolica("Polica");
        contacts.setKraina_data("Kraina data");
        contacts.setIme("Ime");
        Optional<contacts> ofResult = Optional.<contacts>of(contacts);
        when(this.contactsrepository.findByRegistraciq(anyString())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts/registraciq/{registraciq}",
                "value");
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"id\":123,\"ime\":\"Ime\",\"familiq\":\"Familiq\",\"registraciq\":\"Registraciq\",\"otkude\":\"Otkude\",\"polica\":"
                                        + "\"Polica\",\"nachalna_data\":\"Nachalna data\",\"kraina_data\":\"Kraina data\",\"suma\":\"Suma\",\"egn\":\"Egn\",\"telefon"
                                        + "\":\"Telefon\"}")));
    }

    @Test
    public void testGetAdByregistraciq2() throws Exception {
        when(this.contactsrepository.findByRegistraciq(anyString())).thenReturn(Optional.<contacts>empty());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts/registraciq/{registraciq}",
                "value");
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("nqma takava registraciq!")));
    }

    @Test
    public void testGetAllcontacts() throws Exception {
        when(this.contactsrepository.findAll()).thenReturn(new ArrayList<contacts>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts/all");
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetAllcontacts2() throws Exception {
        when(this.contactsrepository.findAll()).thenReturn(new ArrayList<contacts>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/contacts/all");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void testGetcontactByime() throws Exception {
        contacts contacts = new contacts();
        contacts.setFamiliq("Familiq");
        contacts.setSuma("Suma");
        contacts.setNachalna_data("Nachalna data");
        contacts.setId(123L);
        contacts.setRegistraciq("Registraciq");
        contacts.setTelefon("Telefon");
        contacts.setEgn("Egn");
        contacts.setOtkude("Otkude");
        contacts.setPolica("Polica");
        contacts.setKraina_data("Kraina data");
        contacts.setIme("Ime");
        Optional<contacts> ofResult = Optional.<contacts>of(contacts);
        when(this.contactsrepository.findByIme(anyString())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts/ime/{ime}", "value");
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"id\":123,\"ime\":\"Ime\",\"familiq\":\"Familiq\",\"registraciq\":\"Registraciq\",\"otkude\":\"Otkude\",\"polica\":"
                                        + "\"Polica\",\"nachalna_data\":\"Nachalna data\",\"kraina_data\":\"Kraina data\",\"suma\":\"Suma\",\"egn\":\"Egn\",\"telefon"
                                        + "\":\"Telefon\"}")));
    }

    @Test
    public void testGetcontactByime2() throws Exception {
        when(this.contactsrepository.findByIme(anyString())).thenReturn(Optional.<contacts>empty());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contacts/ime/{ime}", "value");
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("nqma takova ime!")));
    }

    @Test
    public void testSaveAd() throws Exception {
        contacts contacts = new contacts();
        contacts.setFamiliq("Familiq");
        contacts.setSuma("Suma");
        contacts.setNachalna_data("Nachalna data");
        contacts.setId(123L);
        contacts.setRegistraciq("Registraciq");
        contacts.setTelefon("Telefon");
        contacts.setEgn("Egn");
        contacts.setOtkude("Otkude");
        contacts.setPolica("Polica");
        contacts.setKraina_data("Kraina data");
        contacts.setIme("Ime");
        when(this.contactsrepository.save((contacts) any())).thenReturn(contacts);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/contacts/save");
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"generatedId\":123,\"generatedkraina_data\":\"Kraina data\",\"generatedtelefon\":\"Telefon\",\"generatednachalna"
                                        + "_data\":\"Nachalna data\",\"generatedFamiliq\":\"Familiq\",\"generatedIme\":\"Ime\",\"generatedegn\":\"Egn\","
                                        + "\"generatednomer_polica\":\"Polica\",\"message\":\"Successfully added!\",\"generatedOtkude\":\"Otkude\",\"generatedsuma"
                                        + "\":\"Suma\",\"generatedRegistraciq\":\"Registraciq\"}")));
    }

    @Test
    public void testSaveAd2() throws Exception {
        contacts contacts = new contacts();
        contacts.setFamiliq("Familiq");
        contacts.setSuma("Suma");
        contacts.setNachalna_data("Nachalna data");
        contacts.setId(123L);
        contacts.setRegistraciq("Registraciq");
        contacts.setTelefon("Telefon");
        contacts.setEgn("Egn");
        contacts.setOtkude("Otkude");
        contacts.setPolica("Polica");
        contacts.setKraina_data("Kraina data");
        contacts.setIme("Ime");
        when(this.contactsrepository.save((contacts) any())).thenReturn(contacts);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/contacts/save");
        MockHttpServletRequestBuilder requestBuilder = postResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(this.contactscontroller)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"generatedId\":123,\"generatedkraina_data\":\"Kraina data\",\"generatedtelefon\":\"Telefon\",\"generatednachalna"
                                        + "_data\":\"Nachalna data\",\"generatedFamiliq\":\"Familiq\",\"generatedIme\":\"Ime\",\"generatedegn\":\"Egn\","
                                        + "\"generatednomer_polica\":\"Polica\",\"message\":\"Successfully edited!\",\"generatedOtkude\":\"Otkude\",\"generatedsuma"
                                        + "\":\"Suma\",\"generatedRegistraciq\":\"Registraciq\"}")));
    }
}

