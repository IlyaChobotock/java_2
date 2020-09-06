package lesson_2_6;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Client {
    private static final int PORT = 8189;
    private static final String IP_ADDRESS = "localhost";
    private static Socket socket;

    public static void main(String[] args) throws IOException {

        try {
            socket = new Socket(IP_ADDRESS, PORT);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            BufferedReader clientMsg = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("-------------------");
            System.out.println(" You are connected ");
            System.out.println("-------------------");

            while (true) {
                String str = clientMsg.readLine();
                output.writeUTF(str);
                String strServer = input.readUTF();

                if(str.equals("/end")) {
                    System.out.println("--------------------");
                    System.out.println("You are disconnected");
                    System.out.println("--------------------");
                    break;
                }

                System.out.println("You: " + str);
                System.out.println("Server: " + strServer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

//    public void sendMsg ();

}
