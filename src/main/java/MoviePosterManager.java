class MoviePosterManager {
    private Movie[] films = new Movie[0];
    private int limit;

    public MoviePosterManager() {
        this.limit = 10;
    }

    public MoviePosterManager(int limit) {
        this.limit = limit;
    }

    public Movie[] findAll() {
        return films;
    }

    public void addMovie(Movie movie) {
        Movie[] movies = new Movie[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            movies[i] = films[i];
        }
        movies[movies.length - 1] = movie;
        this.films = movies;
    }

    public Movie[] findLast() {
        int resultLenght;
        if (films.length < limit) {
            resultLenght = films.length;
        } else {
            resultLenght = limit;
        }
        Movie[] movies = new Movie[resultLenght];
        for (int i = 0; i < movies.length; i++) {
            movies[i] = films[films.length - 1 - i];
        }
        return movies;
    }
}
