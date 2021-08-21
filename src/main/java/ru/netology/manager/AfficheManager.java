package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfficheRepository;

public class AfficheManager {
    private int limit;
    private AfficheRepository repository;

    public AfficheManager(AfficheRepository repository) {
        this(10, repository);
    }

    public AfficheManager(int limit, AfficheRepository repository) {
        this.limit = limit;
        this.repository = repository;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getMovies() {
        if (limit > repository.findAll().length) {
            limit = repository.findAll().length;
        }
        Movie[] result = new Movie[limit];
        for (int i = 0; i < limit; i++) {
            result[i] = repository.findAll()[repository.findAll().length - 1 - i];
        }
        return result;
    }
}

