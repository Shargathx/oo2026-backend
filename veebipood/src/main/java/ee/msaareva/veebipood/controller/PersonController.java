package ee.msaareva.veebipood.controller;

import ee.mihkel.veebipood.dto.PersonLoginRecordDto;
import ee.msaareva.veebipood.entity.Person;
import ee.msaareva.veebipood.repository.PersonRepository;
import ee.msaareva.veebipood.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping
public class PersonController {

    private PersonRepository personRepository;

    // Dependency Injection. Kui luuakse see klass (PersonController), seotakse ära samal ajal
    // temaga kõik allolevad muutujad
    // Injectiga võib ka läbi ka constructorite
    private PersonService personService;

    @GetMapping("persons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @DeleteMapping("persons/{id}")
    public List<Person> deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id); // kustutan
        return personRepository.findAll(); // uuenenud seis
    }

    @PostMapping("signup")
    public Person signup(@RequestBody Person person) {
        personService.validate(person);
        return personRepository.save(person);
    }

    @PostMapping("login")
    public Person login(@RequestBody PersonLoginRecordDto personDto) {
        Person dbPerson = personRepository.findByEmail(personDto.email());
        if (dbPerson == null) {
            throw new RuntimeException("Invalid email");
        }
        if (!dbPerson.getPassword().equals(personDto.password())) {
            throw new RuntimeException("Invalid password");
        }
        return dbPerson;
    }
}
