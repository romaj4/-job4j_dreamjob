package ru.job4j.crudservlet.model;

import java.util.Date;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class User {
    private final String id;

    private String name;

    private String login;

    private String email;

    private Date createDate;

    public User(String id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = new Date();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("User: id= %s; name= %s; login= %s; email= %s; createDate= %s%n",
                this.id, this.name, this.login, this.email, this.createDate);
    }
}