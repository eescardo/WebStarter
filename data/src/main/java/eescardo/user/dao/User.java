/* Copyright (C) 2011 Eduardo Escardo-Raffo. All rights reserved. */
package eescardo.user.dao;

/**
 * Represents a user of the site.
 * 
 * @author Eddy Escardo
 */
public final class User {

    private final long userID;
    private final String firstName;
    private final String lastName;

    /**
     * Constructs a new {@link User}.
     */
    public User(long userID, String firstName, String lastName) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return DB ID of user
     */
    public long getId() {
        return userID;
    }

    /**
     * @return user's first name
     */
    public String getFirstname() {
        return firstName;
    }

    /**
     * @return user's last name
     */
    public String getLastname() {
        return lastName;
    }
}
