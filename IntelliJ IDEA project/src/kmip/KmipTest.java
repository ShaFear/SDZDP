package kmip;

import dijkstra.Dijkstra;
import dijkstra.EtapDrogi;
import graf.Wierzcholek;

import java.io.File;
import java.util.List;

public class KmipTest {
    public static void main(String[] args) {
        File f = new File("test.txt");
        Kmip p = new Kmip(f, 0);
        System.out.print("Kontener: \n");
        for (int j = 0; j < p.getMiasta().size(); j++) {
            System.out.println(p.getMiasta().get(j).getW().toString());
        }

        System.out.print("\nOdległości od bazy: \n");
        for (int j = 0; j < p.getMiasta().size(); j++) {
            Wierzcholek v = p.getMiasta().get(j).getW();
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
