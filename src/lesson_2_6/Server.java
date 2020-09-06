package lesson_2_6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static int PORT = 8189;
    private static Object DataInputStream;

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket socket = null;
        server = new ServerSocket(PORT);

        System.out.println("-------------------");
        System.out.println(" Server is running ");
        System.out.println("-------------------");

        socket = server.accept();
        System.out.println("Client is connected");
        System.out.println("-------------------");

        try {

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            BufferedReader serverMsg = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String strServer = input.readUTF();
                String str = serverMsg.readLine();
                output.writeUTF(str);

                if(str.equals("/end")) {
                    System.out.println("-------------------");
                    System.out.println("Client disconnected");
                    System.out.println("-------------------");
                    break;
                }

                System.out.println("Server: " + str);
                System.out.println("Client: " + strServer);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
