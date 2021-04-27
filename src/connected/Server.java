package connected;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true){
            Socket socket = serverSocket.accept();
            StringBuilder sb = new StringBuilder();
            try(InputStream is = socket.getInputStream()){
                byte[] bytes = new byte[10];
                while(is.read(bytes) != -1){
                    sb.append(new String(bytes));
                    bytes = new byte[10];
                }
                System.out.print(sb.toString());
            }
            socket.close();
        }
    }
}
