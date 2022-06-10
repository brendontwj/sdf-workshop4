package vttp2022.workshop4.app;

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
            ServerSocket Server = new ServerSocket(12345);
            Socket socket = Server.accept();
            System.out.println("Connected");

            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            
            String clientInput = dis.readUTF();
            System.out.println(clientInput);

            while(clientInput != "close")
            {
                if(clientInput.equals("get-cookie")) {
                    dos.writeUTF(cookie.serverCookie());
                } else {
                    dos.writeUTF("Input please");
                }
                clientInput = dis.readUTF();
            }
            
            // System.out.println(cookie.serverCookie());

            is.close();
            os.close();
            socket.close();
            Server.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
