package com.database;

import java.util.Objects;

public class User {

    private String database;
    private String username;
    private String password;

    public User(String database, String username, String password) {
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public String getdatabase() {
        return this.database;
    }

    public void setdatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User database(String database) {
        setdatabase(database);
        return this;
    }

    public User username(String username) {
        setUsername(username);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(database, user.database) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(database, username, password);
    }

    @Override
    public String toString() {
        return "{" +
            " database='" + getdatabase() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

    
}
