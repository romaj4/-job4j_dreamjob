package ru.job4j.crudservlet.persistent;

import ru.job4j.crudservlet.model.User;

import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public interface Store {
    User add(User user);

    User update(User user);

    User delete(User user);

    List<User> findAll();

    User findById(String id);
}
