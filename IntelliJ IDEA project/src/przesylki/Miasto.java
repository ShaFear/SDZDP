package przesylki;

import java.util.ArrayList;
import java.util.Collections;

public class Miasto implements Comparable<Miasto> {
    private final int pojemnoscSamochodu;
    private ArrayList<Przesylka> przesylki;
    private int priorytet;
    private graf.Miasto miasto;

    public Miasto(int pojemnoscSamochodu, graf.Miasto miasto) {
        przesylki = new ArrayList<Przesylka>();
        priorytet = 0;
        this.pojemnoscSamochodu = pojemnoscSamochodu;
        this.miasto = miasto;
    }

    public int getPriorytet() {
        return priorytet;
    }

    public void dodajPrzesylke(Przesylka p) {
        przesylki.add(p);
        this.obliczPriorytet();
    }

    public void obliczPriorytet() {
        int j = przesylki.size() - 1;
        priorytet = 0;
        while ((j >= przesylki.size() - pojemnoscSamochodu) && (j >= 0)) {
            priorytet += przesylki.get(j).getPriorytet();
            j--;
        }
    }

    @Override
    public int compareTo(Miasto o) {
        Collections.sort(przesylki);
        return this.getPriorytet() - o.getPriorytet();
    }

    @Override
    public String toString() {
        return miasto.toString() + " " + priorytet + ": \n" + this.przesylki.toString();
    }


}
