package server.commands;

import server.data.Movie;
import server.serverCode.MovieManager;

import java.util.HashSet;

public class RemoveByIdCommand extends AbstractCommand {

    private MovieManager movieManager;

    public RemoveByIdCommand (MovieManager movieManager){
        this.movieManager = movieManager;
    }

    public String execute(Long id) {
        HashSet<Movie> collection = movieManager.getCollection();
        for (Movie movie : collection) {
            if (movie.getId() == id) {
                collection.remove(movie);
            }
        }
        return "Element was removed successfully.";
    }
}