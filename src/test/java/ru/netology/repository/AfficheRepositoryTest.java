package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfficheRepositoryTest {

    private Movie movie1 = new Movie(1, "movie1", "Cartoon", "imgUrl");
    private Movie movie2 = new Movie(2, "movie2", "Fantasy", "imgUrl");
    private Movie movie3 = new Movie(3, "movie3", "Cartoon", "imgUrl");
    private Movie movie4 = new Movie(4, "movie4", "Fantasy", "imgUrl");
    private Movie movie5 = new Movie(5, "movie5", "Cartoon", "imgUrl");
    AfficheRepository repository = new AfficheRepository();

    @BeforeEach
    void setup() {
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);
        repository.save(movie4);
    }

    @Test
    void shouldFindAll() {
        Movie[] expected = {movie1, movie2, movie3, movie4};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldSave() {
        repository.save(movie5);
        Movie[] expected = {movie1, movie2, movie3, movie4, movie5};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldFindById() {
        assertEquals(movie3, repository.findById(3));
    }

    @Test
    void shouldFindByNoneId() {
        assertNull(repository.findById(10));
    }

    @Test
    void removeById() {
        repository.removeById(2);
        Movie[] expected = {movie1, movie3, movie4, null};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void removeByNoneId() {
        repository.removeById(5);
        Movie[] expected = {movie1, movie2, movie3, movie4};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void removeAll() {
        repository.removeAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, repository.findAll());
    }
}