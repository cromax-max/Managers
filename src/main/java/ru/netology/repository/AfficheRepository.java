package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfficheRepository {
    private Movie[] movies = new Movie[0];

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public Movie findById(int id) {
        Movie result = null;
        for (Movie movieId : movies) {
            if (movieId.getId() == id) {
                result = movieId;
            }
        }
        return result;
    }

    public void removeById(int id) {
        Movie[] tmp = new Movie[movies.length];
        int index = 0;
        for (Movie movieID : movies) {
            if (movieID.getId() != id) {
                tmp[index] = movieID;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        movies = new Movie[0];
    }
}
