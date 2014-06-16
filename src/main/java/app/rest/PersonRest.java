

/**
 * User: Bryan
 * Date: 3/13/14
 * Time: 12:25 AM
 */
package app.rest;

import app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import app.service.PersonService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonRest {

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getAll(){
        return personService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getById(@PathVariable("id") Long id) {

        if (id < 0) {
            throw new IllegalArgumentException("id must not be less than zero: " + id);
        }

        return personService.getById(id);
    }
}
