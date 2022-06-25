package server.commands;

import server.data.Movie;
import server.serverCode.MovieManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ShowCommand extends AbstractCommand {
    private MovieManager movieManager;

    public ShowCommand (MovieManager movieManager){
        this.movieManager = movieManager;
    }

    public String execute(){
        HashSet<Movie> collection = movieManager.getCollection();
        StringBuilder stringBuilder = new StringBuilder();
        for (Movie movie : collection) {
            stringBuilder.append(movie.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
