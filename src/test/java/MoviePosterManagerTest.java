import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoviePosterManagerTest {

    @Test
    public void movieManagerShouldHaveZeroMoviesLengthAfterCreation() {
        MoviePosterManager moviePosterManager = new MoviePosterManager();

        assertEquals(0, moviePosterManager.findAll().length);
    }

    @Test
    public void shouldAddMovie() {
        Movie movie = new Movie("Красавица и чудовище");
        MoviePosterManager moviePosterManager = new MoviePosterManager();

        moviePosterManager.addMovie(movie);
        Movie foundedMovie = moviePosterManager.findAll()[0];
        assertEquals(movie.getName(), foundedMovie.getName());
    }

    @Test
    public void shouldAddSeveralMovie() {
        Movie movie = new Movie("Красавица и чудовище");
        Movie secondMovie = new Movie("Аватар");
        Movie thirdMovie = new Movie("Титаник");
        MoviePosterManager moviePosterManager = new MoviePosterManager();

        moviePosterManager.addMovie(movie);
        moviePosterManager.addMovie(secondMovie);
        moviePosterManager.addMovie(thirdMovie);
        Movie[] foundedMovies = moviePosterManager.findAll();
        assertEquals(3, foundedMovies.length);
    }

    @Test
    public void shouldReturnLastMoviesInRightOrder() {
        Movie movie = new Movie("Красавица и чудовище");
        Movie secondMovie = new Movie("Аватар");
        Movie thirdMovie = new Movie("Титаник");
        MoviePosterManager moviePosterManager = new MoviePosterManager();

        moviePosterManager.addMovie(movie);
        moviePosterManager.addMovie(secondMovie);
        moviePosterManager.addMovie(thirdMovie);
        Movie[] foundedMovies = moviePosterManager.findLast();
        assertEquals(thirdMovie.getName(), foundedMovies[0].getName());
        assertEquals(secondMovie.getName(), foundedMovies[1].getName());
        assertEquals(movie.getName(), foundedMovies[2].getName());
    }

    @Test
    public void shouldReturnOnlyTenLastMovies() {
        Movie movie = new Movie("Красавица и чудовище");
        Movie secondMovie = new Movie("Аватар");
        Movie thirdMovie = new Movie("Титаник");
        Movie fourthMovie = new Movie("Хатико");
        Movie fifthMovie = new Movie("Зеленая миля");
        Movie sixthMovie = new Movie("Портрет Дориана Грея");
        Movie seventh = new Movie("Золушка");
        Movie eighth = new Movie("Хроники Нарнии");
        Movie ninth = new Movie("Терминатор");
        Movie tenth = new Movie("Судья Дред");
        Movie eleventh = new Movie("Паразиты");

        MoviePosterManager moviePosterManager = new MoviePosterManager();

        moviePosterManager.addMovie(movie);
        moviePosterManager.addMovie(secondMovie);
        moviePosterManager.addMovie(thirdMovie);
        moviePosterManager.addMovie(fourthMovie);
        moviePosterManager.addMovie(fifthMovie);
        moviePosterManager.addMovie(sixthMovie);
        moviePosterManager.addMovie(seventh);
        moviePosterManager.addMovie(eighth);
        moviePosterManager.addMovie(ninth);
        moviePosterManager.addMovie(tenth);
        moviePosterManager.addMovie(eleventh);

        Movie[] foundedMovies = moviePosterManager.findLast();
        assertEquals(10, foundedMovies.length);
    }

}
