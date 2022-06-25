package server.commands;

import server.data.Movie;
import server.serverCode.MovieManager;

import java.util.HashSet;

public class ClearCommand extends AbstractCommand {
    private MovieManager movieManager;

    public ClearCommand (MovieManager movieManager){
        this.movieManager = movieManager;
    }

    public String execute(){
        HashSet<Movie> collection = movieManager.getCollection();
        collection.clear();
        return "Collection is removed successfully! :)";
    }

}
