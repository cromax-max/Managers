package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfficheManagerTest {
    private Movie movie1 = new Movie(1, "movie1", "Cartoon", "imgUrl");
    private Movie movie2 = new Movie(2, "movie2", "Fantasy", "imgUrl");
    private Movie movie3 = new Movie(3, "movie3", "Cartoon", "imgUrl");
    private Movie movie4 = new Movie(4, "movie4", "Fantasy", "imgUrl");
    private Movie movie5 = new Movie(5, "movie5", "Cartoon", "imgUrl");
    private Movie movie6 = new Movie(6, "movie6", "Fantasy", "imgUrl");
    private Movie movie7 = new Movie(7, "movie7", "Cartoon", "imgUrl");
    private Movie movie8 = new Movie(8, "movie8", "Fantasy", "imgUrl");
    private Movie movie9 = new Movie(9, "movie9", "Cartoon", "imgUrl");
    private Movie movie10 = new Movie(10, "movie10", "Silent movie", "imgUrl");
    private Movie movie11 = new Movie(11, "movie10", "Silent movie", "imgUrl");

    @Test
    void shouldShowDefaultLimit() {
        AfficheManager manager = new AfficheManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);
        manager.add(movie8);
        manager.add(movie9);
        manager.add(movie10);
        manager.add(movie11);
        Movie[] expected = {movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};
        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldShowSetupLimit () {
        AfficheManager manager = new AfficheManager(3);
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        Movie[] expected = {movie3, movie2, movie1};
        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldShowLessLimit() {
        AfficheManager manager = new AfficheManager(5);
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        Movie[] expected = {movie3, movie2, movie1};
        assertArrayEquals(expected, manager.getMovies());
    }
}