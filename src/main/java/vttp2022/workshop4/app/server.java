package vttp2022.workshop4.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try{ 
            // ServerSocket Server = new ServerSocket(12345);
            // Socket socket = Server.accept();
            
            
            System.out.println(cookie.serverCookie()); 

            // socket.close();
            // Server.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
