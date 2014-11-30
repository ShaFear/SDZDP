package dijkstra;

import graf.Polaczenie;
import graf.Wierzcholek;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {
    public static void obliczDrogi(Wierzcholek baza) {
        baza.najmniejszaOdleglosc = 0;
        PriorityQueue<Wierzcholek> kolejkaWierzcholkow = new PriorityQueue<Wierzcholek>();
        kolejkaWierzcholkow.add(baza);

        while (!kolejkaWierzcholkow.isEmpty()) {
            Wierzcholek u = kolejkaWierzcholkow.poll();

            for (Polaczenie e : u.polaczenia) {
                Wierzcholek v = e.cel;
                int odleglosc = e.odleglosc;
                int odlegloscPrzezU = u.najmniejszaOdleglosc + odleglosc;
                if (odlegloscPrzezU < v.najmniejszaOdleglosc) {
                    kolejkaWierzcholkow.remove(v);
                    v.najmniejszaOdleglosc = odlegloscPrzezU;
                    v.poprzedni = u;
                    kolejkaWierzcholkow.add(v);
                }
            }
        }
    }

    public static List<EtapDrogi> getShortestPathTo(Wierzcholek target) {
        List<Wierzcholek> wList = new ArrayList<Wierzcholek>();
        for (Wierzcholek wierzcholek = target; wierzcholek != null; wierzcholek = wierzcholek.poprzedni)
            wList.add(wierzcholek);
        Collections.reverse(wList);

        List<EtapDrogi> etapy = new ArrayList<EtapDrogi>();
        for (int i = 1; i < wList.size(); i++) {
            etapy.add(new EtapDrogi(wList.get(i).najmniejszaOdleglosc - wList.get(i - 1).najmniejszaOdleglosc, wList.get(i).getMiasto().toString()));
        }
        return etapy;
    }
}