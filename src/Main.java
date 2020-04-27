import java.io.*;

public class Main implements Serializable {
    

    public Main(){
        gry_komputerowe[0] = new KomputerowePlanszowe("Activison","Ifinity Ward",2005,35,"Call of Duty 2","Akcja","Single/Multi","PC");
        gry_komputerowe[1] = new KomputerowePlanszowe("Warner Bros. IE","Techland",2015,40,"Dying Light","Akcja","Single/Coop","PC");
        gry_komputerowe[2] = new KomputerowePlanszowe("FreeBird Games","FreeBird Games",2011,30,"To the Moon","Przygodowa","Single","PC");
        gry_komputerowe[3] = new KomputerowePlanszowe("Codemasters Software","Codemasters Software",2013,30,"GRID 2","Wyścigi","Single/Multi","PC");
        gry_komputerowe[4] = new KomputerowePlanszowe("SEGA","Relic Entertainment",2013,20,"Company of Heroes 2","Stragegia","Single/Multi","PC");
        gry_komputerowe[5] = new KomputerowePlanszowe("Take 2 Interactive","Irrational Games",2007,45,"BioShock","Akcja","Single","PC");
        gry_komputerowe[6] = new KomputerowePlanszowe("Psyonix","Psyonix",2015,40,"Rocket League","Zręcznościowa","Multi","PC");gry_komputerowe[7] = new KomputerowePlanszowe("Bethesda Softworks","Obsidian Entertainment",2010,25,"Fallout: New Vegas","RPG","Single","PC");
        gry_komputerowe[8] = new KomputerowePlanszowe("CD Project RED","CD Project RED",2015,50,"Wiedźmin 3: Dziki Gon","RPG","Single","PC");
        gry_komputerowe[9] = new KomputerowePlanszowe("Gun Media","Bloober Team",2019,110,"Layers of Fear 2","Przygodowa","Single","PC");

        gry_planszowe[0] = new KomputerowePlanszowe("FryxGames","Jacob Fryxelius",2016,120,"Terraformacja Marsa","Ekonomiczna","1-5 os.","Planszowa");
        gry_planszowe[1] = new KomputerowePlanszowe("Repos Production","Antoine Bauza",2010,110,"7 cudów świata","Karciana","2-7 os.","Planszowa");
        gry_planszowe[2] = new KomputerowePlanszowe("The Oatmeal","Elan Lee and Shane Small",2015,55,"Elsplodujące Kotki","Karciana","2-5 os.","Planszowa");
        gry_planszowe[3] = new KomputerowePlanszowe("Stonemaier Games","Jamey Stegmaier",2016,300,"Scythe","Ekonomiczna","1-5 os.","Planszowa");
        gry_planszowe[4] = new KomputerowePlanszowe("Next Move Games","Michael Kiesling",2017,130,"Azul","Strategiczna","2-4 os.","Planszowa");
        gry_planszowe[5] = new KomputerowePlanszowe("Awaken Realms","Adam Kwapiński",2018,550,"Nemesis","Przygodowa","1-5 os.","Planszowa");
        gry_planszowe[6] = new KomputerowePlanszowe("Fantasy Flight Games","Corey Konieczka",2013,200,"Eldritch Horror","Przygodowa","1-8 os.","Planszowa");
        gry_planszowe[7] = new KomputerowePlanszowe("Czech Games Edition","Vlaada Chvatil",2015,50,"Tajniacy","Karciana","2-8 os.","Planszowa");
        gry_planszowe[8] = new KomputerowePlanszowe("Space Cowboys","Peggy Chassenent",2015,110,"T.I.M.E Stories","Przygodowa","2-4 os.","Planszowa");
        gry_planszowe[9] = new KomputerowePlanszowe("Stonemaier Games","Elizabeth Hargrave",2019,150,"Na skrzydłach","Karciana","1-5 os.","Planszowa");
    }


    KomputerowePlanszowe[] gry_komputerowe = new KomputerowePlanszowe[10];
    KomputerowePlanszowe[] gry_planszowe = new KomputerowePlanszowe[10];

    public static String czytajIWypiszGryKomputerowe(KomputerowePlanszowe[] gry_komputerowe) {
        String fileName = "grykomputerowe.txt";

        try(
                var fs  = new FileOutputStream(fileName);
                var os = new ObjectOutputStream(fs);
        ){
            for(KomputerowePlanszowe gry: gry_komputerowe){
                os.writeObject(gry);
        }
            System.out.println("Zapisano obiekty do pliku");
        }catch(IOException e){
            System.err.println("Błąd zapisu do pliku " + fileName);
            e.printStackTrace();
        }
        String s ="";
        try(
                var fis = new FileInputStream(fileName);
                var ois = new ObjectInputStream(fis);
        ){

            for(KomputerowePlanszowe gry: gry_komputerowe){
                gry = (KomputerowePlanszowe) ois.readObject();
                s = s + gry.toString() +"|";
                //System.out.println(gry);

            }

        }catch(ClassNotFoundException | IOException e){
            System.err.println("Nie udzło się odczytać pliku");
            e.printStackTrace();

        }return s;
    }

    public static String czytajIWypiszGryPlanszowe(KomputerowePlanszowe[] gry_planszowe){
        String fileName = "gryplanszowe.txt";

        try(
                var fs  = new FileOutputStream(fileName);
                var os = new ObjectOutputStream(fs);
                ){
            for(KomputerowePlanszowe gry: gry_planszowe){
                os.writeObject(gry);
            }
            System.out.println("Zapisano obiekty do pliku");
        }catch(IOException e){
            System.err.println("Błąd zapisu do pliku " + fileName);
            e.printStackTrace();
        }
        String z ="";
        try(
                var fis = new FileInputStream(fileName);
                var ois = new ObjectInputStream(fis);
        ){

            for(Gry gry: gry_planszowe){
                gry = (Gry) ois.readObject();
                z = z+gry.toString();
              // System.out.println(gry);

            }

        }catch(ClassNotFoundException | IOException e){
            System.err.println("Nie udzło się odczytać pliku");
            e.printStackTrace();

        }return z;
    }

}

