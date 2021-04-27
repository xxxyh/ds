package connected;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.2", 8888);
        try(OutputStream out = socket.getOutputStream()){
            out.write("hello world!!!".getBytes());
        }
    }
}
