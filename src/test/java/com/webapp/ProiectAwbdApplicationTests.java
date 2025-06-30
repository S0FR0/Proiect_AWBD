package com.webapp;

import com.webapp.model.Person;
import com.webapp.repository.PersonRepository;
import com.webapp.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProiectAwbdApplicationTests {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void contextLoads() {
        assertNotNull(personService);
        assertNotNull(personRepository);
    }

    @Test
    void testPersonServiceSave() {
        Person person = new Person();
        person.setFirstName("Test");
        person.setLastName("User");
        person.setEmail("test@example.com");
        person.setBirthDate(LocalDate.of(1990, 1, 1));

        Person saved = personService.save(person);

        assertNotNull(saved.getId());
        assertEquals("Test", saved.getFirstName());
    }

    @Test
    void testPersonRepositoryCrud() {
        Person person = new Person();
        person.setFirstName("Repository");
        person.setLastName("Test");
        person.setEmail("repo@test.com");
        person.setBirthDate(LocalDate.of(1985, 5, 5));

        Person saved = personRepository.save(person);
        assertNotNull(saved.getId());

        List<Person> all = personRepository.findAll();
        assertTrue(all.size() > 0);

        personRepository.deleteById(saved.getId());
        assertFalse(personRepository.existsById(saved.getId()));
    }
}