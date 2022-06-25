package server.commands;

import server.data.Movie;
import server.serverCode.MovieManager;

import java.util.HashSet;

public class SumOfOscarsCountCommand extends AbstractCommand {

    private MovieManager movieManager;

    public SumOfOscarsCountCommand(MovieManager movieManager) {
        this.movieManager = movieManager;
    }

    public String execute() {
        HashSet<Movie> collection = movieManager.getCollection();
        int counter = 0;
        for (Movie movie : collection) {
            counter += movie.getOscarsCount();
        }
        return ("The command is finished successfully! " + counter + " is sum of oscars count in this " +
                "collection");

    }
}
