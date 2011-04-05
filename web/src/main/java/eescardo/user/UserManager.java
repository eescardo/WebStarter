/* Copyright (C) 2011 Eduardo Escardo-Raffo. All rights reserved. */
package eescardo.user;

import java.util.List;

import eescardo.user.dao.User;

/**
 * Business logic service layer for basic {@link User} functionality.
 * 
 * @author Eddy Escardo
 */
public interface UserManager {

    /**
     * @return all users, sorted by last name then first name
     */
    List<User> getAllUsers();
}
