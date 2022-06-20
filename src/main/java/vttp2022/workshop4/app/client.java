package vttp2022.workshop4.app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
    static Console cons = System.console();
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected");

        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        String input = "";
        boolean loop = true;

        while(loop)
        {
            input = cons.readLine("Input cookie command:  ");
            if(input.equals("exit")) {
                loop = false;
            } else {
                dos.writeUTF(input+"\n");
                dos.flush();
                String serverResponse = dis.readUTF();
                System.out.println(serverResponse);
                if(serverResponse.contains("cookie-text"))
                    System.out.println(serverResponse.substring(11));
            }
        }

        System.out.println("Thanks for using the cookie generator.");
        
        is.close();
        os.close();
        socket.close();
    }
}
