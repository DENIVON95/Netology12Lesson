import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoviePosterManagerTest {

    @Test
    public void movieManagerShouldHaveZeroMoviesLengthAfterCreation() {
        MoviePosterManager moviePosterManager = new MoviePosterManager();

        assertEquals(0, moviePosterManager.findAll().length);
    }

    @Test
    public void shouldAddOneMovie() {
        Movie[] movies = {new Movie("Красавица и чудовище")};
        MoviePosterManager moviePosterManager = new MoviePosterManager();

        moviePosterManager.addMovie(movies[0]);
        Movie[] foundedMovies = moviePosterManager.findAll();
        assertArrayEquals(movies, foundedMovies);
    }

    @Test
    public void shouldAddSeveralMovies() {
        Movie[] moviesToAdd = {new Movie("Красавица и чудовище"), new Movie("Аватар"),
                new Movie("Титаник")};

        MoviePosterManager moviePosterManager = new MoviePosterManager();
        moviePosterManager.addMovie(moviesToAdd[0]);
        moviePosterManager.addMovie(moviesToAdd[1]);
        moviePosterManager.addMovie(moviesToAdd[2]);

        Movie[] foundedMovies = moviePosterManager.findAll();
        assertArrayEquals(moviesToAdd, foundedMovies);
    }

    @Test
    public void shouldReturnLastMoviesInRightOrder() {
        Movie[] moviesToAdd = {new Movie("Красавица и чудовище"), new Movie("Аватар"),
                new Movie("Титаник")};

        MoviePosterManager moviePosterManager = new MoviePosterManager();
        moviePosterManager.addMovie(moviesToAdd[0]);
        moviePosterManager.addMovie(moviesToAdd[1]);
        moviePosterManager.addMovie(moviesToAdd[2]);
        Movie[] foundedMovies = moviePosterManager.findLast();

        for (int i = 0; i < foundedMovies.length; i++) {
            assertEquals(moviesToAdd[foundedMovies.length - (i + 1)], foundedMovies[i]);
        }
    }

    @Test
    public void shouldReturnOnlyTenLastMovies() {
        Movie[] moviesToAdd = {new Movie("Красавица и чудовище"), new Movie("Аватар"),
                new Movie("Титаник"), new Movie("Хатико"), new Movie("Зеленая миля"),
                new Movie("Портрет Дориана Грея"), new Movie("Золушка"), new Movie("Хроники Нарнии"),
                new Movie("Хроники Нарнии"), new Movie("Терминатор"), new Movie("Судья Дред"),
                new Movie("Паразиты")
        };
        Movie[] expectedMoviesToReturn = Arrays.copyOfRange(moviesToAdd, 2, moviesToAdd.length);

        MoviePosterManager moviePosterManager = new MoviePosterManager(10);
        for (Movie movie : moviesToAdd) {
            moviePosterManager.addMovie(movie);
        }

        Movie[] foundedMovies = moviePosterManager.findLast();
        assertEquals(10, foundedMovies.length);
        for (int i = 0; i < foundedMovies.length; i++) {
            assertEquals(expectedMoviesToReturn[foundedMovies.length - (i + 1)], foundedMovies[i]);
        }
    }
}
