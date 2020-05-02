import server.MultipleServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {

        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server started...");

        try {
            while (true) {
                try {
                    socket = server.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                new MultipleServer(socket);
            }
        }finally {
            server.close();
        }
    }
}
