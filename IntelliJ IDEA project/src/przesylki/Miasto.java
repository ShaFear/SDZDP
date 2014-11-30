package przesylki;

import java.util.ArrayList;
import java.util.Collections;

public class Miasto implements Comparable<Miasto> {
    private final int pojemnoscSamochodu;
    private ArrayList<Przesylka> przesylki;
    private int priorytet;

    public Miasto(int pojemnoscSamochodu) {
        przesylki = new ArrayList<Przesylka>();
        priorytet = 0;
        this.pojemnoscSamochodu = pojemnoscSamochodu;
    }

    public int getPriorytet() {
        return priorytet;
    }

    public void dodajPrzesylke(Przesylka p) {
        przesylki.add(p);
    }

    private void obliczPriorytet() {
        int j = 0;
        priorytet = 0;
        while ((j < pojemnoscSamochodu) && (j < przesylki.size())) {
            priorytet += przesylki.get(j).getPriorytet();
            j++;
        }
    }

    @Override
    public int compareTo(Miasto o) {
        Collections.sort(przesylki);
        this.obliczPriorytet();
        return this.getPriorytet() - o.getPriorytet();
    }

    @Override
    public String toString() {
        return priorytet + ": \n" + this.przesylki.toString();
    }


}
