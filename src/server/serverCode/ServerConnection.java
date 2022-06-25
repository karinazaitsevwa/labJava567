package server.serverCode;



import server.commands.*;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

import server.data.*;

/**
 * Class for realizing connection on server side and activating interactive mod with client.
 * Class worked using UDP protocol and allows to run the required command classes
 * depending on the command received from the client
 *
 * @author Karina Zaytseva
 * @verson 1.1
 */
public class ServerConnection implements Runnable {

    /** Field socket which allows to transport datagrams */
    private DatagramSocket socket;
    /** Flag for checking if interactive mod is active */
    private boolean running;
    /** Array of bytes for organizing a packet for receiving data from client */
    private byte[] buf = new byte[65535];
    /** Array of bytes for organizing a packet for sending answer to client */
    private byte[] buf2 = new byte[65535];
    /** Field allows to use methods of CollectionManager class */
    private final MovieManager serverCollection;
    /** Map for printing available commands for user */
    private final HashMap<String, AbstractCommand> availableCommands;

    ExecutorService readPool = Executors.newCachedThreadPool();
    ExecutorService executePool = Executors.newCachedThreadPool();
    ExecutorService responsePool = Executors.newFixedThreadPool(10);
    ReentrantLock locker = new ReentrantLock();

    /**
     * Constructor for this class
     * @param serverCollection - object of class CollectionManager
     */
    ServerConnection(MovieManager serverCollection) {
        try {
            socket = new DatagramSocket(4242);
        } catch (SocketException socketException) {
            System.err.println("Host is busy. Try later.");
            System.exit(1);
        }
        this.serverCollection = serverCollection;
        availableCommands = new HashMap<>();
        availableCommands.put("add", new AddCommand(serverCollection));
        availableCommands.put("clear", new ClearCommand(serverCollection));
        availableCommands.put("execute_script", new ExecuteScriptCommand(serverCollection));
        availableCommands.put("exit", new ExitCommand());
        availableCommands.put("help", new HelpCommand());
        availableCommands.put("history", new HistoryCommand());
        availableCommands.put("info", new InfoCommand(serverCollection));
        availableCommands.put("max_by_oscars_count", new MaxByOscarsCountCommand(serverCollection));
        availableCommands.put("print_descending", new PrintDescendingCommand());
        availableCommands.put("remove_by_id", new RemoveByIdCommand(serverCollection));
        availableCommands.put("remove_greater", new RemoveGreaterCommand());
        availableCommands.put("remove_lower", new RemoveLowerCommand());
        availableCommands.put("save", new SaveCommand(serverCollection));
        availableCommands.put("show", new ShowCommand(serverCollection));
        availableCommands.put("sum_of_oscars_count", new SumOfOscarsCountCommand(serverCollection));
        availableCommands.put("update_by_id", new UpdateByIdCommand(serverCollection));
    }

    /** Active link this client */
    public void run() {
        try {
            running = true;
            ExecutorService service = Executors.newCachedThreadPool();
            Future<?> outPut = service.submit(() -> {
                synchronized (ServerConnection.class) {
                    while (running) {
                        DatagramPacket packet = new DatagramPacket(buf, buf.length);
                        try {
                            socket.receive(packet);
                            System.out.println("received");
                            Future<String> readingResult = readPool.submit(() ->
                                    new String(packet.getData(), 0, packet.getLength()));
                            String received = null;
                            locker.lock();
                            try {
                                received = readingResult.get();
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                                System.out.println("Execution was interrupted.");
                            } finally {
                                locker.unlock();
                            }
                        } catch (IOException ioException) {
                            System.out.println("Data receiving error.");
                            System.exit(1);
                        }
                        AbstractCommand errorCommand = new AbstractCommand(null) {
                            @Override
                            public String execute() {
                                return "Unknown command. Write help for receiving list of available commands.";
                            }
                        };
                        InetAddress address = packet.getAddress();
                        int port = packet.getPort();
                        //packet = new DatagramPacket(buf, buf.length, address, port);
                        String command = new String(packet.getData(), 0, packet.getLength());
                        System.out.println("Message [" + command + "] is received from client.");
                        String[] parsedCommand = command.trim().split(" ", 2);
                        String answer;
                        if (parsedCommand.length == 1) {
                            answer = availableCommands.getOrDefault(parsedCommand[0], errorCommand).execute();
                        } else if (parsedCommand.length == 2) {
                            answer = availableCommands.getOrDefault(parsedCommand[0], errorCommand).execute(parsedCommand[1]);
                        } else
                            answer = "Unknown command. Write [help] for receiving list of available commands";
                        buf2 = answer.getBytes();
                        DatagramPacket sendingPacket = new DatagramPacket(buf2, buf2.length, address, port);
                        String check = new String(sendingPacket.getData(), 0, sendingPacket.getLength());
                        try {
                            socket.send(sendingPacket);
                        } catch (IOException ioException) {
                            System.out.println("Data sending error.");
                            System.exit(1);
                        }
                        System.out.println("Answer has been recent successfully. Content of answer: ");
                        System.out.println(check);
                    }
                    socket.close();
                }
            });
        } catch (NoSuchElementException | ArrayIndexOutOfBoundsException exception) {
            System.out.println("Program will be finished now.");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return "ServerConnection{" +
                "serverCollection=" + serverCollection +
                ", availableCommands=" + availableCommands +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServerConnection)) return false;
        ServerConnection that = (ServerConnection) o;
        return Objects.equals(serverCollection, that.serverCollection) &&
                Objects.equals(availableCommands, that.availableCommands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverCollection, availableCommands);
    }
}