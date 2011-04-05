/* Copyright (C) 2011 Eduardo Escardo-Raffo. All rights reserved. */
package eescardo.user.dao;

import java.util.List;

/**
 * Data access interface for basic {@link User} functionality.
 * 
 * @author Eddy Escardo
 */
public interface UserDao {

    /**
     * @return all users, sorted by last name then first name
     */
    List<User> getAllUsers();
}
