package server.commands;

import server.data.Movie;
import java.util.*;
import server.serverCode.MovieManager;

public class PrintDescendingCommand extends AbstractCommand {

    private MovieManager movieManager;

     public String execute() {
         HashSet<Movie> collection = movieManager.getCollection();
         TreeSet sortedCollection = new TreeSet();
         sortedCollection.addAll(collection);
         ArrayList<Movie> list = new ArrayList<Movie>(sortedCollection);
         Stack stack = new Stack();
         StringBuilder stringBuilder = new StringBuilder();
         for (Movie movie : list) {
             stack.push(movie);
         }
         for (Object item : stack) {
             stringBuilder.append(item.toString() + " ");
             stack.remove(item);
         }
         return stringBuilder.toString();

     }

}
