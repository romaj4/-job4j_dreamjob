package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {
    private static AtomicInteger POST_ID = new AtomicInteger(4);

    private static AtomicInteger CANDIDATE_ID = new AtomicInteger(4);

    private static final MemStore INST = new MemStore();

    private Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private MemStore() {
        posts.put(1, new Post(1, "Junior Java Job"));
        posts.put(2, new Post(2, "Middle Java Job"));
        posts.put(3, new Post(3, "Senior Java Job"));
        candidates.put(1, new Candidate(1, "Roman junior", 1));
        candidates.put(2, new Candidate(2, "Ivan middle", 2));
        candidates.put(3, new Candidate(3, "Petr senior", 3));
    }

    public void savePost(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        this.posts.put(post.getId(), post);
    }

    public Post findPostById(int id) {
        return this.posts.get(id);
    }

    public void saveCandidate(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        this.candidates.put(candidate.getId(), candidate);
    }

    @Override
    public void saveUser(User user) {

    }

    public Candidate findCandidateById(int id) {
        return this.candidates.get(id);
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

    public static MemStore instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    @Override
    public Collection<User> findAllUsers() {
        return null;
    }
}