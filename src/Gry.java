
import java.util.Objects;

public class Gry extends Produkt{

    private String nazwa;
    private String typ;
    private String Tryb;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getTryb() {
        return Tryb;
    }

    public void setTryb(String tryb) {
        Tryb = tryb;
    }

    Gry(String Wydawca, String Producent, int data, int cena, String nazwa, String typ, String Tryb){
        super(Wydawca, Producent, data, cena);
        this.nazwa = nazwa;
        this.Tryb=Tryb;
        this.typ=typ;


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Gry gry = (Gry) o;
        return nazwa.equals(gry.nazwa) &&
                typ.equals(gry.typ) &&
                Tryb.equals(gry.Tryb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nazwa, typ, Tryb);
    }

    public String toString(){
        return super.toString() + "Nazwa: " +  nazwa+"," + " Akcja: "  +typ+", "+"Tryb: "+ Tryb;
    }
}		