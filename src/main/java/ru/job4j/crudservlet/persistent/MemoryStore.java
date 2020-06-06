package ru.job4j.crudservlet.persistent;

import ru.job4j.crudservlet.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class MemoryStore implements Store {

    private static final MemoryStore INSTANCE = new MemoryStore();

    private MemoryStore() {
    }

    public static MemoryStore getInstance() {
        return INSTANCE;
    }

    private final Map<String, User> usersMap = new ConcurrentHashMap<>();

    @Override
    public User add(User user) {
        return this.usersMap.put(user.getId(), user);
    }

    @Override
    public User update(User user) {
        return this.usersMap.put(user.getId(), user);
    }

    @Override
    public User delete(User user) {
        return this.usersMap.remove(user.getId());
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(this.usersMap.values());
    }

    @Override
    public User findById(String id) {
        return usersMap.get(id);
    }
}
