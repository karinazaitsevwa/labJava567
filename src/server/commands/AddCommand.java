package server.commands;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import server.data.*;
import server.serverCode.MovieManager;
import java.io.IOException;
import java.util.*;

public class AddCommand extends AbstractCommand {

    private MovieManager movieManager;
    private HashSet<Movie> collection;

    public AddCommand(MovieManager movieManager) {
        this.movieManager = movieManager;
        this.collection = movieManager.getCollection();
    }

    public Long receiveId() {
        //HashSet<Movie> collection = new MovieManager().getCollection();
        Long size = (long) collection.size();
        System.out.println("size is " + size);
        Long id = size + 1;
        return id;
    }

    public String execute(String arg) {
        try {
            Movie movie = new XmlMapper().readValue(arg, Movie.class);
            System.out.println(movie.toString());
            collection.add(movie);
            return "Element was added successfully!";
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return "Invalid argument!";
        }
    }

}
