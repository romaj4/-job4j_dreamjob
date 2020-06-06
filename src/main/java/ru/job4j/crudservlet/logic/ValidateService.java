package ru.job4j.crudservlet.logic;

import ru.job4j.crudservlet.model.User;
import ru.job4j.crudservlet.persistent.MemoryStore;
import ru.job4j.crudservlet.persistent.Store;

import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateService {

    private static final ValidateService INSTANCE = new ValidateService();

    private final Store userStore = MemoryStore.getInstance();

    private ValidateService() {
    }

    public static ValidateService getInstance() {
        return INSTANCE;
    }

    public boolean add(User user) {
        boolean rst = false;
        if (this.isValid(user)) {
            this.userStore.add(user);
            rst = true;
        }
        return rst;
    }

    public boolean update(User user) {
        boolean rst = false;
        if (this.findById(user.getId()) != null && this.isValid(user)) {
            this.userStore.update(user);
            rst = true;
        }
        return rst;
    }

    public boolean delete(User user) {
        return this.userStore.delete(user) != null;
    }

    public User findById(String id) {
        return this.userStore.findById(id);
    }

    public List<User> findAll() {
        return this.userStore.findAll();
    }

    private boolean isValid(User user) {
        return user.getName() != null && user.getLogin() != null && user.getEmail() != null;
    }
}
