package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public Server(int port)
    {
        try (ServerSocket serverSocket = new ServerSocket(port);
                        Socket socket = serverSocket.accept();
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());)
        {
            out.writeUTF("Hello! I am ready to serve you!");

            System.out.println(in.readUTF());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String args[])
    {
        new Server(5000);
    }
}
