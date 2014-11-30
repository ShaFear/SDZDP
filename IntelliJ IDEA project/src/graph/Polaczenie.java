package graph;

public class Polaczenie {
    public final Wierzcholek cel;
    public final int odleglosc;

    public Polaczenie(Wierzcholek cel, int odleglosc) {
        this.cel = cel;
        this.odleglosc = odleglosc;
    }

    @Override
    public String toString() {
        return cel.getMiasto().toString() + ": " + odleglosc;
    }
}
