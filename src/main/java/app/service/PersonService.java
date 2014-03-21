package app.service;

import app.model.Person;
import app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Bryan
 * Date: 3/13/14
 * Time: 12:47 AM
 */
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person getById(Long id){
        return personRepository.getById(id);
    }

    public List<Person> getAll() {
        return personRepository.getAll();
    }
}
