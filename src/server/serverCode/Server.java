package server.serverCode;

public class Server {
    /** Server entry point */
    public static void main(String[] args) {
        try {
            MovieManager serverCollection = new MovieManager();
            serverCollection.loadCollection(args[0]);
            System.out.println("Starting a server moodle.\nWaiting a client...");
            ServerConnection serverConnection = new ServerConnection(serverCollection);
            serverConnection.run();
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.err.println("You forgot enter path to file. Use [java -jar Server.jar /path/to/file] for correct using.");
            System.exit(1);
        }
    }
}
