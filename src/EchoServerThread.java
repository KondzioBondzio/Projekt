import java.io.*;
import java.net.*;

class EchoServerThread extends Thread {
    private Socket gniazdo;
    private BufferedReader in;
    private PrintWriter out;
    Main jj = new Main();

    public EchoServerThread(Socket gniazdo) throws IOException {
        this.gniazdo = gniazdo;
        in = new BufferedReader(
                new InputStreamReader(gniazdo.getInputStream()));
        out = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(gniazdo.getOutputStream())), true);
    }

    public void run() {
        try {
            Main main = new Main();
            boolean end = false;
            String response = "Server: \n ddddd";

            do {
                    String s = in.readLine();
                    System.out.println("Wybrano opcje: " + s);
                    //out.println(response);
                    response =  jj.czytajIWypiszGryKomputerowe(jj.gry_komputerowe);
                    System.out.println(response);
                    out.println(response.replace('\n','|'));

                    if(s.equals("5")) end = true;

            }while(!end);

        } catch (IOException e) {
        } finally {
            try {
                gniazdo.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}