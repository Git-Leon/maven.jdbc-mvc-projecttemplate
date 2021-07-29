package com.github.curriculeon.personservice;

import com.github.curriculeon.DatabaseConnection;
import com.github.curriculeon.JdbcConfigurator;
import com.github.curriculeon.dao.PersonRepository;
import com.github.curriculeon.model.Person;
import com.github.curriculeon.service.PersonService;
import com.github.curriculeon.service.ServiceInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by leon on 8/14/2020.
 */
public class FindAllTest {
    private DatabaseConnection databaseConnection;

    @Before
    public void setup() {
        // given
        this.databaseConnection = DatabaseConnection.TESTING_DATABASE;
        JdbcConfigurator configurator = new JdbcConfigurator(databaseConnection);
        configurator.appendSqlScript("testing.person_create-table.sql");
        configurator.appendSqlScript("testing.person_populate-table.sql");
        configurator.initialize();
    }

    @Test
    public void test() {
        // given
        PersonService personService = new PersonService(new PersonRepository(databaseConnection));
        ServiceInterface serviceInterface =  (ServiceInterface)personService;

        // when
        List<Person> personList = serviceInterface.findAll();

        // then
        Assert.assertFalse(personList.isEmpty());
    }
}
