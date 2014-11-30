package graph;

import java.util.ArrayList;
import java.util.List;

public class Wierzcholek implements Comparable<Wierzcholek> {
    private Miasto miasto;
    public List<Polaczenie> polaczenia = new ArrayList<Polaczenie>();
    public double najmniejszaOdleglosc = Double.POSITIVE_INFINITY;
    public Wierzcholek poprzedni;

    public Wierzcholek(Miasto miasto) {
        this.miasto = miasto;
    }

    public String toString() {
        return miasto.toString();
    }

    public int compareTo(Wierzcholek inny) {
        return Double.compare(najmniejszaOdleglosc, inny.najmniejszaOdleglosc);
    }
}
