package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StoreStub implements Store {

    private final Map<Integer, User> userStore = new HashMap<>();

    private final Map<Integer, Post> postStore = new HashMap<>();

    private final Map<Integer, Candidate> candidateStore = new HashMap<>();

    private int userId = 0;

    private int postId = 0;

    private int candidateId = 0;

    private StoreStub() {
    }

    private static final class Lazy {
        private static final Store INST = new StoreStub();
    }

    public static Store instOf() {
        return StoreStub.Lazy.INST;
    }

    @Override
    public Collection<Post> findAllPosts() {
        return this.postStore.values();
    }

    @Override
    public Collection<Candidate> findAllCandidates() {
        return this.candidateStore.values();
    }

    @Override
    public Collection<User> findAllUsers() {
        return this.userStore.values();
    }

    @Override
    public void savePost(Post post) {
        post.setId(this.postId++);
        this.postStore.put(post.getId(), post);
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        candidate.setId(this.candidateId++);
        this.candidateStore.put(candidate.getId(), candidate);
    }

    @Override
    public void saveUser(User user) {
        user.setId(this.userId++);
        this.userStore.put(user.getId(), user);
    }

    @Override
    public Post findPostById(int id) {
        return null;
    }

    @Override
    public Candidate findCandidateById(int id) {
        return null;
    }

    @Override
    public User findUserByName(String name) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public City findCityById(int id) {
        return null;
    }

    @Override
    public Collection<City> findAllCities() {
        return null;
    }
}
