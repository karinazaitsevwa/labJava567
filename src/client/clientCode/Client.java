package client.clientCode;

public class Client {
    public static void main(String[] args) {
        System.out.println("Starting a client module.\nConnecting to server...");
        ClientConnection connection = new ClientConnection();
        connection.work();
    }
}
