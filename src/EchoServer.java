import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException{
        Main main = new Main();

        ServerSocket serverSocket = new ServerSocket(7);
        System.out.println("Uruchomiono server" + serverSocket);
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    new EchoServerThread(socket).start();
                    System.out.println("Otwarto połączenie: " + socket);

                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            serverSocket.close();
        }
    }
}
