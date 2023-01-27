import org.junit.jupiter.api.Test;

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
        Movie firstMovie = new Movie("Красавица и чудовище");
        Movie secondMovie = new Movie("Аватар");
        Movie thirdMovie = new Movie("Титаник");
        Movie[] expectedMoviesToReturn = {thirdMovie, secondMovie, firstMovie};

        MoviePosterManager moviePosterManager = new MoviePosterManager();
        moviePosterManager.addMovie(firstMovie);
        moviePosterManager.addMovie(secondMovie);
        moviePosterManager.addMovie(thirdMovie);

        Movie[] foundMovies = moviePosterManager.findLast();
        assertArrayEquals(expectedMoviesToReturn, foundMovies);

    }

    @Test
    public void shouldReturnOnlyTenLastMovies() {
        Movie firstMovie = new Movie("Красавица и чудовище");
        Movie secondMovie = new Movie("Аватар");
        Movie thirdMovie = new Movie("Титаник");
        Movie fourthMovie = new Movie("Хатико");
        Movie fifthMovie = new Movie("Зеленая миля");
        Movie sixthMovie = new Movie("Портрет Дориана Грея");
        Movie seventhMovie = new Movie("Золушка");
        Movie eighthMovie = new Movie("Хроники Нарнии");
        Movie ninthMovie = new Movie("Хроники Нарнии 2");
        Movie tenthMovie = new Movie("Терминатор");
        Movie eleventhMovie = new Movie("Судья Дред");
        Movie twelfthMovie = new Movie("Паразиты");

        Movie[] expectedMoviesToReturn = {twelfthMovie, eleventhMovie, tenthMovie, ninthMovie, eighthMovie,
                seventhMovie, sixthMovie, fifthMovie, fourthMovie, thirdMovie};

        MoviePosterManager moviePosterManager = new MoviePosterManager(10);
        moviePosterManager.addMovie(firstMovie);
        moviePosterManager.addMovie(secondMovie);
        moviePosterManager.addMovie(thirdMovie);
        moviePosterManager.addMovie(fourthMovie);
        moviePosterManager.addMovie(fifthMovie);
        moviePosterManager.addMovie(sixthMovie);
        moviePosterManager.addMovie(seventhMovie);
        moviePosterManager.addMovie(eighthMovie);
        moviePosterManager.addMovie(ninthMovie);
        moviePosterManager.addMovie(tenthMovie);
        moviePosterManager.addMovie(eleventhMovie);
        moviePosterManager.addMovie(twelfthMovie);

        Movie[] foundedMovies = moviePosterManager.findLast();
        assertEquals(10, foundedMovies.length);
        assertArrayEquals(expectedMoviesToReturn, foundedMovies);
    }
}
