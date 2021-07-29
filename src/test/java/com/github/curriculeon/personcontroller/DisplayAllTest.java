package com.github.curriculeon.personcontroller;

import com.github.curriculeon.DatabaseConnection;
import com.github.curriculeon.JdbcConfigurator;
import com.github.curriculeon.controllers.ControllerInterface;
import com.github.curriculeon.controllers.PersonController;
import com.github.curriculeon.dao.PersonRepository;
import com.github.curriculeon.service.PersonService;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 8/14/2020.
 */
public class DisplayAllTest {
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
        PersonController personController = new PersonController(new PersonService(new PersonRepository(databaseConnection)));
        ControllerInterface controllerInterface = (ControllerInterface)personController;

        // when
        controllerInterface.displayAll();

        // then

    }
}