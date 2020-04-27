import java.io.Serializable;
import java.util.Objects;

public class Produkt implements Serializable {
    private String Wydawca;
    private String Producent;
    private int Datawyd;
    private int cena;

    public Produkt(String Wydawca, String Producent, int Datawyd, int cena) {
        this.Wydawca = Wydawca;
        this.Producent = Producent;
        this.Datawyd = Datawyd;
        this.cena = cena;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produkt produkt = (Produkt) o;
        return Datawyd == produkt.Datawyd &&
                cena == produkt.cena &&
                Wydawca.equals(produkt.Wydawca) &&
                Producent.equals(produkt.Producent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Wydawca, Producent, Datawyd, cena);
    }

    @Override
    public String toString() {
        return "Produkt - " +
                "Wydawca: " + Wydawca +
                ", Producent: " + Producent +
                ", Rok wydania: " + Datawyd +
                ", Cena: " + cena + " zł, " ;

    }
}
