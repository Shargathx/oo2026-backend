package ee.msaareva.veebipood.service;

import com.github.vladislavgoltjajev.personalcode.locale.estonia.EstonianPersonalCodeValidator;
import ee.msaareva.veebipood.entity.Person;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PersonService {
    private final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    private final Pattern pattern = Pattern.compile(regex);
    private final EstonianPersonalCodeValidator validator = new EstonianPersonalCodeValidator();

    public boolean isValid(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void validate(Person person){
        if (person.getId() != null) {
            throw new RuntimeException("Cannot sign up with ID");
        }
        if (person.getEmail() == null) {
            throw new RuntimeException("Cannot sign up without email");
        }
        if (person.getPersonalCode() == null) {
            throw new RuntimeException("Cannot sign up without personal code");
        }
        if (!isValid(person.getEmail())) {
            throw new RuntimeException("Invalid email");
        }
        if (!validator.isValid(person.getPersonalCode())) {
            throw new RuntimeException("Invalid personal code");
        }
    }
}
