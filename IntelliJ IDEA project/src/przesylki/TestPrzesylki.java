package przesylki;

import java.util.ArrayList;
import java.util.Collections;

public class TestPrzesylki {
    public static void main(String args[]) {
        ArrayList <Miasto> m = new ArrayList<Miasto>();
        int pj = 2; //pojemnosc samochodu

        for(int j=0; j < 5; j++) {
            m.add(new Miasto(pj));
        }

        Przesylka p0 = new Przesylka(0, "kapeć", 5);
        Przesylka p1 = new Przesylka(1, "mikrofon", 20);
        Przesylka p2 = new Przesylka(2, "uran", 100);
        Przesylka p3 = new Przesylka(3, "kamyk", 1);
        Przesylka p4 = new Przesylka(4, "złoto", 50);
        Przesylka p5 = new Przesylka(5, "batonik", 30);

        m.get(0).dodajPrzesylke(p0);
        m.get(0).dodajPrzesylke(p0);
        m.get(0).dodajPrzesylke(p0);
        m.get(0).dodajPrzesylke(p4);

        m.get(1).dodajPrzesylke(p0);
        m.get(1).dodajPrzesylke(p3);
        m.get(1).dodajPrzesylke(p1);
        m.get(1).dodajPrzesylke(p0);
        m.get(1).dodajPrzesylke(p2);
        m.get(1).dodajPrzesylke(p4);

        m.get(2).dodajPrzesylke(p5);
        m.get(2).dodajPrzesylke(p3);
        m.get(2).dodajPrzesylke(p2);

        m.get(3).dodajPrzesylke(p1);
        m.get(3).dodajPrzesylke(p2);
        m.get(3).dodajPrzesylke(p4);

        m.get(4).dodajPrzesylke(p0);
        m.get(4).dodajPrzesylke(p0);
        m.get(4).dodajPrzesylke(p3);
        m.get(4).dodajPrzesylke(p0);
        m.get(4).dodajPrzesylke(p5);
        m.get(4).dodajPrzesylke(p0);
        m.get(4).dodajPrzesylke(p5);
        m.get(4).dodajPrzesylke(p2);

        Collections.sort(m);

        for(int j=0; j < m.size(); j++) {
            System.out.println(m.get(j).toString());
        }
    }
}
