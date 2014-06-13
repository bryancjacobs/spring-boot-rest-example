package app.service;

import app.model.Person;
import app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
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

    @ManagedOperation(description = "get a person by their id")
    @ManagedOperationParameters( { @ManagedOperationParameter(name = "id", description = "id of person") })
    public Person getById(Long id){
        return personRepository.getById(id);
    }

    public List<Person> getAll() {
        return personRepository.getAll();
    }
}
