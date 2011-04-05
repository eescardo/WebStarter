/* Copyright (C) 2011 Eduardo Escardo-Raffo. All rights reserved. */
package eescardo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eescardo.user.dao.User;
import eescardo.user.dao.UserDao;

/**
 * Default implementation for {@link UserManager}
 * 
 * @author Eddy Escardo
 */
@Component
@Transactional
public class DefaultUserManager implements UserManager {

    private final UserDao dao;

    @Autowired
    public DefaultUserManager(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

}
