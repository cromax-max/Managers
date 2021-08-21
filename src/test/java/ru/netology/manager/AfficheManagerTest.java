package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Movie;
import ru.netology.repository.AfficheRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

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

    AfficheRepository repository = Mockito.mock(AfficheRepository.class);

    @Test
    void shouldShowDefaultLimit() {
        AfficheManager manager = new AfficheManager(repository);
        Movie[] returned = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11};
        doReturn(returned).when(repository).findAll();
//
        Movie[] expected = {movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2};
        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldShowSetupLimit() {
        AfficheManager manager = new AfficheManager(3, repository);
        Movie[] returned = {movie1, movie2, movie3};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = {movie3, movie2, movie1};
        assertArrayEquals(expected, manager.getMovies());
    }

    @Test
    void shouldShowLessLimit() {
        AfficheManager manager = new AfficheManager(5, repository);
        Movie[] returned = {movie1, movie2, movie3};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = {movie3, movie2, movie1};
        assertArrayEquals(expected, manager.getMovies());
    }
}