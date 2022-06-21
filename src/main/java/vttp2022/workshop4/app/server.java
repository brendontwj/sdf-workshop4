package vttp2022.workshop4.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server {
    public static void main(String[] args) {
        try{
            ExecutorService threadPool = Executors.newFixedThreadPool(2);
            ServerSocket Server = new ServerSocket(12345);

            while (true) {
                System.out.println("Server waiting for connection. . . ");
                Socket socket = Server.accept();
                System.out.println("Connected");
                
                String cookieFilePath;
    
                if(args.length >0)
                    cookieFilePath = args[0];
                else
                    cookieFilePath = "C:\\Users\\Brendon\\JavaProjects\\sdf-workshop4\\src\\main\\java\\vttp2022\\workshop4\\app\\cookie.txt";    
                
                cookieClientHandler thread = new cookieClientHandler(socket, cookieFilePath);
                threadPool.submit(thread);
                System.out.println("Submitted to threadpool. ");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
