package vttp2022.workshop4.app;

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
        DataInputStream dis = new DataInputStream(is);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        String input = "";
        boolean loop = true;

        while(loop)
        {
            input = cons.readLine("Input cookie command:  ");
            if(input.equals("exit")) {
                loop = false;
            } else {
                dos.writeUTF(input);
                dos.flush();
                String serverResponse = dis.readUTF();
                if(serverResponse.contains("cookie-text"))
                    System.out.println(serverResponse.substring(11));
            }
        }       
        is.close();
        os.close();
        socket.close();
    }
}
