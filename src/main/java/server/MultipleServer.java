package server;

import java.io.*;
import java.net.Socket;

public class MultipleServer extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public MultipleServer(Socket socket) {
        this.socket = socket;

        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            in = new BufferedReader(inputStreamReader);
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        this.start();
    }

    @Override
    public void run() {
        String str = null;

        while(true) {
            try {
                str = in.readLine();

                if (str == null) {
                    socket.close();

                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("socket: " + socket + ", data: " + str);
        }
    }
}
