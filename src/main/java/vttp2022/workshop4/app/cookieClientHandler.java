package vttp2022.workshop4.app;

import java.io.IOException;
import java.net.NetworkInterface;
import java.net.Socket;

public class cookieClientHandler implements Runnable {
    
    private Socket sock;
    private String cookieFilePath;

    public cookieClientHandler(Socket s, String path) {
        this.sock = s;
        this.cookieFilePath = path;  
    }

    @Override
    public void run() {
        System.out.println("Starting a client thread");
        NetworkIO netIO = null;
        try {
            netIO = new NetworkIO(sock);
            String clientInput;
            while(true) {
                    clientInput = netIO.read();
                    if(clientInput.equals("get-cookie")) {
                        netIO.write(cookie.serverCookie(cookieFilePath));
                    } else if (clientInput.equals("exit")) {
                        break;
                    } else {
                        netIO.write("Invalid input, please enter another:");
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
