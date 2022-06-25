package server.commands;

import server.data.Movie;
import server.serverCode.MovieManager;

import java.util.HashSet;

public class RemoveGreaterCommand extends AbstractCommand {

    private MovieManager movieManager;

    public String execute(String initialName) {
        HashSet<Movie> collection = movieManager.getCollection();
        int counter = 0;
        for (Movie movie : collection) {
            if (movie.getName().length() > initialName.length()) {
                collection.remove(movie);
                counter += 1;
            }
        }
        return ("Collection was updated successfully. " + counter + " elements were removed.");
    }
}
