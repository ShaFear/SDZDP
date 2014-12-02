package przesylki;

import java.util.ArrayList;
import java.util.Collections;

public class Miasto implements Comparable<Miasto> {
    private final int pojemnoscSamochodu;

    public ArrayList<Przesylka> getPrzesylki() {
        return przesylki;
    }

    private ArrayList<Przesylka> przesylki;
    private int priorytet;

    public graf.Miasto getMiasto() {
        return miasto;
    }

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
        if(przesylki.size() <= 0){
            priorytet = 0;
            return;
        }
        int j = przesylki.size() - 1;
        priorytet = 1;
        while ((j >= przesylki.size() - pojemnoscSamochodu) && (j >= 0)) {
            priorytet += przesylki.get(j).getPriorytet();
            j--;
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
        return miasto.toString() + " " + priorytet + ": \n" + this.przesylki.toString();
    }


}
