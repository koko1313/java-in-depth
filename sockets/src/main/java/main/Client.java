package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client
{
    public Client(String address, int port)
    {
        try (Socket socket = new Socket(address, port);
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());)
        {
            System.out.println(in.readUTF());

            out.writeUTF("Hey!!! I am your client!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new Client("localhost", 5000);
    }
}
