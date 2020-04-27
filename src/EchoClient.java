import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter out = null;
        Menu menu = new Menu();
        Main main = new Main();
        boolean exit = false;

        try {
            BufferedReader klawiatura = new BufferedReader(new InputStreamReader(System.in));
            Socket gniazdo = new Socket("localhost", 7);
            in = new BufferedReader(new InputStreamReader(gniazdo.getInputStream()));
            out = new PrintWriter(gniazdo.getOutputStream());
            System.out.println("Nawiazano polaczenie z: " + gniazdo.getInetAddress());
            while (exit==false) {
                menu.wyswietl_menu();
                String number = klawiatura.readLine();
                out.println(number);
                out.flush();
                String odp = in.readLine();
                System.out.println(odp.replace('|','\n'));
                    switch (number) {
                        case "1":
                           // main.czytajIWypiszGryKomputerowe(main.gry_komputerowe);
                           // System.out.println(odp.replace('|','\n'));
                            break;
                        case "2":
                           // main.czytajIWypiszGryPlanszowe(main.gry_planszowe);
                            break;
                        case "3":
                            System.out.println("Podaj nazwe gry komputerowej:");
                            String nazwa = klawiatura.readLine();
                            boolean exist = false;
                            for (Gry p : main.gry_komputerowe) {
                                if (nazwa.equals(p.getNazwa())) {
                                    System.out.println(p);
                                    exist = true;
                                }
                            }
                            if (exist == false)
                                System.out.println("Nie ma takiej gry");
                            break;
                        case "4":
                                System.out.println("Podaj nazwe gry planszowej:");
                                String nazwa1 = klawiatura.readLine();
                                boolean exist1 = false;
                                for (Gry p : main.gry_planszowe) {
                                    if (nazwa1.equals(p.getNazwa())) {
                                        System.out.println(p);
                                        exist1 = true;
                                    }
                                }
                                if (exist1 == false)
                                    System.out.println("Nie ma takiej gry");
                                break;
                        case "5":
                            System.out.println("Koniec programu");
                            exit = true;
                            break;
                        default:
                            System.out.println("Nie ma takiej opcji, podaj ponownie:");
                            break;
                    }
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
            }
        }
    }
}