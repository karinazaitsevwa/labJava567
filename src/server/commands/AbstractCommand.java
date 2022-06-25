package server.commands;
import server.serverCode.MovieManager;

public abstract class AbstractCommand {

    /**
     * Field for using opportunities of class Collection manager
     */
    private MovieManager manager;

    /**
     * Constructor for this class
     *
     * @param manager - field for using opportunities of Collection Manager
     */
    public AbstractCommand(MovieManager manager) {
        this.manager = manager;
    }

    public AbstractCommand() {}

    /**
     * Method for executing a command without argument
     *
     * @return message about not-existed argument. Should be redefined.
     */
    public synchronized String execute() {
        return "Argument is absent.";
    }

    /**
     * Method for executing a command with argument
     *
     * @return result of executing a command
     */
    public synchronized String execute(String arg) {
        return execute(arg);
    }
}
