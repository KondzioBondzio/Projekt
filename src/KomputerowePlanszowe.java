import java.util.Objects;

public class KomputerowePlanszowe extends Gry {
    private String platforma;

    KomputerowePlanszowe(String Wydawca, String Producent, int data, int cenav, String nazwa, String typ, String Tryb, String platforma) {
        super(Wydawca, Producent, data, cenav, nazwa, typ, Tryb);
        this.platforma = platforma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        KomputerowePlanszowe that = (KomputerowePlanszowe) o;
        return Objects.equals(platforma, that.platforma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), platforma);
    }

    public String toString() {
        return super.toString() + "Platforma: " + platforma;


    }
}

