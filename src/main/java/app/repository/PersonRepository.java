package app.repository;

import app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Bryan
 * Date: 3/20/14
 * Time: 8:27 PM
 */
@Repository
public class PersonRepository {

    @Autowired
    JdbcTemplate template;

    public Person getById(Long id) {

        return template.queryForObject("select * from person where id = ?", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                person.setId(rs.getLong("id"));
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                return person;
            }
        }, id);
    }

    public List<Person> getAll() {
        List<Map<String, Object>> maps = template.queryForList("select * from person");

        List<Person> persons = new ArrayList<>();
        for(Map<String, Object> row : maps){
            Person person = new Person();
            person.setId((Long) row.get("id"));
            person.setFirstName((String)row.get("first_name"));
            person.setLastName((String)row.get("last_name"));
            persons.add(person);
        }

        return persons;
    }
}
