package app.mbean;

import app.model.Person;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * User: Bryan
 * Date: 6/12/14
 * Time: 7:56 PM
 */
@Component
@ManagedResource(objectName="app.service:name=PersonMBean", description="find person information")
public class PersonMBean {

    @Autowired
    PersonService personService;

    @ManagedOperation(description = "get a person by their id")
    @ManagedOperationParameters( { @ManagedOperationParameter(name = "id", description = "id of person") })
    public String getById(Long id){
        return personService.getById(id).toString();
    }

    @ManagedOperation(description = "get everyone")
    public List<String> getAll() {

        List<String> persons = personService.getAll().stream().map(Person::toString).collect(toList());

        return persons;
    }

}
