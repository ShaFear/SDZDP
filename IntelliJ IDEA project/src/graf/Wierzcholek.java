package graf;

import java.util.ArrayList;
import java.util.List;

public class Wierzcholek implements Comparable<Wierzcholek> {
    public List<Polaczenie> polaczenia = new ArrayList<Polaczenie>();
    public int najmniejszaOdleglosc = Integer.MAX_VALUE;
    public Wierzcholek poprzedni;
    private Miasto miasto;

    public Wierzcholek(Miasto miasto) {
        this.miasto = miasto;
    }

    public String toString() {
        return miasto.toString() + ": " + polaczenia.toString();
    }

    public int compareTo(Wierzcholek inny) {
        return Double.compare(najmniejszaOdleglosc, inny.najmniejszaOdleglosc);
    }

    public Miasto getMiasto() {
        return this.miasto;
    }
}
