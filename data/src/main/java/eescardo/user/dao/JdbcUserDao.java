/* Copyright (C) 2011 Eduardo Escardo-Raffo. All rights reserved. */
package eescardo.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * JDBC implementation for {@link UserDao}
 * 
 * @author Eddy Escardo
 */
@Repository
public class JdbcUserDao implements UserDao {

    private final SimpleJdbcTemplate template;

    @Autowired
    public JdbcUserDao(DataSource dataSource) {
        template = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAllUsers() {
        List<Map<String, Object>> rows = template.queryForList("SELECT userid,firstname,lastname FROM users ORDER BY lastname,firstname ASC");

        List<User> users = new ArrayList<User>(rows.size());

        for (Map<String, Object> row : rows) {
            users.add(new User((Long)row.get("userid"), (String)row.get("firstname"), (String)row.get("lastname")));
        }

        return users;
    }

}
