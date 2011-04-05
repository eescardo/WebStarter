/* Copyright (C) 2011 Eduardo Escardo-Raffo. All rights reserved. */
package eescardo.user.dao;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for {@link JdbcUserDao}
 * 
 * @author Eddy Escardo
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/dataAccessContext.xml", "/dataAccessContext-test.xml" })
@TransactionConfiguration(defaultRollback = true)
public class JdbcUserDaoIT {

    /**
     * Verify that we get an empty user list when database table is empty
     */
    @Test
    public void getAllUsers_empty() {
        List<User> actual = instance.getAllUsers();
        assertEquals(Collections.emptyList(), actual);
    }

    /**
     * Verify that we get a properly populated user list when database table has
     * two users.
     */
    @Test
    public void getAllUsers_2Users() {
        insertUser("Adam", "Smith");
        insertUser("Eve", "Johnson");

        List<User> actual = instance.getAllUsers();
        assertEquals(2, actual.size());
        assertEquals("Eve", actual.get(0).getFirstname());
        assertEquals("Johnson", actual.get(0).getLastname());
        assertEquals("Adam", actual.get(1).getFirstname());
        assertEquals("Smith", actual.get(1).getLastname());
    }

    private SimpleJdbcTemplate template;
    private JdbcUserDao instance;

    /**
     * Performs actions common to all tests
     */
    @Before
    public void setUp() {
        // Remove all users from DB to have the table in a known state
        template.update("DELETE FROM users");
    }

    /**
     * Configure the data source for the tests
     */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        template = new SimpleJdbcTemplate(dataSource);
        instance = new JdbcUserDao(dataSource);
    }

    private void insertUser(String firstname, String lastname) {
        template.update("INSERT INTO users(firstname,lastname) VALUES (?,?)", firstname, lastname);
    }
}
