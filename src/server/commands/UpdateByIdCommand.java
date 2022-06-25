package server.commands;

import server.data.Movie;
import server.serverCode.MovieManager;

import java.util.HashSet;

public class UpdateByIdCommand extends AbstractCommand {

    private MovieManager movieManager;

    public UpdateByIdCommand (MovieManager movieManager){
        this.movieManager = movieManager;
    }

    public String execute(Long id) {
        HashSet<Movie> collection = movieManager.getCollection();
        for (Movie movie : collection) {
            if (movie.getId() == id) {
                collection.remove(movie);
                new AddCommand(movieManager).execute();
            }
        }
        return "Element was added successfully.";
    }
}
