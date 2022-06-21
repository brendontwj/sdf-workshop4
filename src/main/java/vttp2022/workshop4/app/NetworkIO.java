package vttp2022.workshop4.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkIO {
    private InputStream is;
    private OutputStream os;
    private DataInputStream dis;
    private DataOutputStream dos;

    public NetworkIO(Socket sock) throws IOException {
        is = sock.getInputStream();
        dis = new DataInputStream(is);
        os = sock.getOutputStream();
        dos = new DataOutputStream(os);
    }

    public String read() throws IOException {
        return dis.readUTF();
    }

    public void write(String message) throws IOException {
        dos.writeUTF(message);
        dos.flush();
    }

    public void close() {
        try{
            dis.close();
            dos.close();
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
