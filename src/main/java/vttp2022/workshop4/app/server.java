package vttp2022.workshop4.app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try{
            System.out.println("Server waiting for connection. . . ");
            cookie cookie = new cookie(); 
            ServerSocket Server = new ServerSocket(12345);
            Socket socket = Server.accept();
            System.out.println("Connected");

            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            
            String clientInput;
            boolean loop = true;
            String cookieFilePath = args[0];

            while(loop)
            {
                clientInput = dis.readUTF();
                System.out.println(clientInput);
                if(clientInput.equals("get-cookie")) {
                    System.out.println("Got cookie command");
                    dos.writeUTF(cookie.serverCookie(cookieFilePath));
                } else if (clientInput.equals("exit")) {
                    loop = false;
                } else {
                    dos.writeUTF("Input please");
                }
                System.out.println("One loop completed");
            }
            
            is.close();
            os.close();
            socket.close();
            Server.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
