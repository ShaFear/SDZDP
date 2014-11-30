package dijkstra;

import graph.Polaczenie;
import graph.Miasto;
import graph.Wierzcholek;

import java.util.List;

public class DijkstraTest {

    public static void main(String[] args) {
        Wierzcholek w0 = new Wierzcholek(new Miasto(0, "Radom"));
        Wierzcholek w1 = new Wierzcholek(new Miasto(1, "Warszawa"));
        Wierzcholek w2 = new Wierzcholek(new Miasto(2, "Olsztyn"));
        Wierzcholek w3 = new Wierzcholek(new Miasto(3, "Suwałki"));
        Wierzcholek w4 = new Wierzcholek(new Miasto(4, "Poznań"));

        w0.polaczenia.add(new Polaczenie(w1, 100));
        w0.polaczenia.add(new Polaczenie(w2, 200));
        w2.polaczenia.add(new Polaczenie(w3, 15));
        w1.polaczenia.add(new Polaczenie(w3, 10));

        Wierzcholek[] wierzcholki = {w0, w1, w2, w3, w4};
        Dijkstra.obliczDrogi(w0);
        for (int j = 0; j < wierzcholki.length; j++) {
            Wierzcholek v = wierzcholki[j];
            if (v.najmniejszaOdleglosc == Integer.MAX_VALUE)
                System.out.println("Brak połączenia do " + v.getMiasto().toString());
            else {
                System.out.println("Odległość do " + v.getMiasto().toString() + ": " + v.najmniejszaOdleglosc);
                List<EtapDrogi> s = Dijkstra.getShortestPathTo(v);
                System.out.println("Droga: " + s.toString());
            }
        }
    }
}
