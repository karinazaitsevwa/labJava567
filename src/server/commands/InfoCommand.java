package server.commands;

import server.serverCode.MovieManager;

public class InfoCommand extends AbstractCommand {

    private MovieManager movieManager;

    public InfoCommand(MovieManager movieManager) {
        this.movieManager = movieManager;
    }

    public String execute() {
        return ("Type of collection is " + movieManager.getCollection().getClass());
        //System.out.println("Initialization date is " + movieManager.getDataInitialisation());
    }

}
