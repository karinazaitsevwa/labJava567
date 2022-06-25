package server.commands;

import server.data.Movie;
import server.serverCode.MovieManager;

import java.util.HashSet;

public class MaxByOscarsCountCommand extends AbstractCommand {

    private MovieManager movieManager;

    public MaxByOscarsCountCommand(MovieManager movieManager) {
        this.movieManager = movieManager;
    }

    public String execute() {
        // load collection
        HashSet<Movie> collection = movieManager.getCollection();
        int max = 0;
        Movie goodMovie = null;
        for (Movie movie : collection) {
            if (movie.getOscarsCount() > max) {
                max = movie.getOscarsCount();
                goodMovie = movie;
            }
        }
        return (goodMovie.toString() + " is a movie with max oscars count.");
    }

}
