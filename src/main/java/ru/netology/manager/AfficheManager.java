package ru.netology.manager;

import ru.netology.domain.Movie;

public class AfficheManager {
    int limit;
    private Movie[] movies = new Movie[0];

    public AfficheManager() {
        this(10);
    }

    public AfficheManager(int limit) {
        this.limit = limit;
    }

    public void add(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public Movie[] getMovies() {
        if (limit > movies.length) {
            limit = movies.length;
        }
        Movie[] result = new Movie[limit];
        for (int i = 0; i < limit; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}

