package gko;

import dijkstra.Dijkstra;
import dijkstra.EtapDrogi;
import graf.Wierzcholek;
import przesylki.Przesylka;
import vizualizacja.RuchSamochodow;
import vizualizacja.Zdarzenie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shafe_000 on 2014-12-02.
 */
public class Rozwiazanie {


    private ArrayList<ElementRozwiazania> rozwiazanie;

    public Rozwiazanie(Gko g, int liczbaSamochodow) {
        String baza = g.getKp().getMiasta().get(g.getIdBazy()).getMiasto().toString();
        g.getKp().getMiasta().remove(g.getIdBazy());
        int p = g.getPojemnosc();
        int t[] = new int[liczbaSamochodow];
        int tTemp[] = new int[liczbaSamochodow];
        int lm = g.getKp().getMiasta().size() - 1;    //indeks konca tablicy miast
        int lp = g.getKp().getMiasta().get(lm).getPrzesylki().size() - 1; //indeks konca tablicy przesylek dla ostatniego miasta
        RuchSamochodow ruchSamochodow = new RuchSamochodow(liczbaSamochodow);

        //-------------Ostatni w kolejce ma zawsze pierwsza kolejnosc do wyslania---------------------------------------------
        rozwiazanie = new ArrayList<ElementRozwiazania>();

        for (int i = 0; i < t.length; i++) {
            t[i] = 0;
            tTemp[i] = 0;
        }

        while (g.getKp().getMiasta().get(lm).getPrzesylki().size() != 0) {
            ArrayList<Przesylka> lPrzesylek = g.getKp().getMiasta().get(lm).getPrzesylki();
            for (int i = 0; i < liczbaSamochodow; i++) {
                Wierzcholek miastoZPrzesylka = g.getKp().getMiasta().get(lm).getMiasto().getW();
                if (miastoZPrzesylka.najmniejszaOdleglosc != Integer.MAX_VALUE) {
                    tTemp[i] = t[i];
                    t[i] += miastoZPrzesylka.najmniejszaOdleglosc;
                }
                for (int j = 0; j < p; j++) {
                    if (miastoZPrzesylka.najmniejszaOdleglosc == Integer.MAX_VALUE) ;
                    if (lp - j >= 0) {
                        if (lPrzesylek.size() > 0) {
                            String iDprzesylki = changeId(lPrzesylek.get(lp - j).getId());
                            String miastoCel = g.getKp().getMiasta().get(lm).getMiasto().toString();

                            rozwiazanie.add(new ElementRozwiazania(tTemp[i] + " pobrano przesyłkę " + iDprzesylki + " z miasta " + baza + "\n"));
                            rozwiazanie.add(new ElementRozwiazania(t[i] + " dostarczono przesyłkę " + iDprzesylki + " do miasta " + miastoCel + "\n"));

                            ruchSamochodow.getSamochody().get(j).getZdarzenia().add(new Zdarzenie(baza, tTemp[i]));


                            //-----------------------------Wypisuje szczegółowe działąnie przydzielania paczek i transportu---------------------------------
                            System.out.print(tTemp[i] + " Samochód: " + j + ", pobrano " + iDprzesylki + " z " + baza + "\n");
                            ruchSamochodow.getSamochody().get(j).getZdarzenia().add(new Zdarzenie(baza, tTemp[i]));
                            List<EtapDrogi> etapy = Dijkstra.getShortestPathTo(miastoZPrzesylka);
                            for (int jk = 0; jk < etapy.size() - 1; jk++) {
                                System.out.print(tTemp[i] + etapy.get(jk).getOdleglosc() + " Samochód: " + j + ", minął " + etapy.get(jk).getMiasto() + "\n");
                                ruchSamochodow.getSamochody().get(j).getZdarzenia().add(new Zdarzenie(etapy.get(jk).getMiasto(), tTemp[i] + etapy.get(jk).getOdleglosc()));
                            }
                            System.out.print(t[i] + " Samochód: " + j + ", dostarczono " + iDprzesylki + " do " + miastoCel + "\n");
                            ruchSamochodow.getSamochody().get(j).getZdarzenia().add(new Zdarzenie(miastoCel, t[i]));
                            //------------------------------------------------------------------------------------------------------------------------------

                            lPrzesylek.remove(lp - j);
                            g.getKp().getMiasta().get(lm).obliczPriorytet();
                        }
                    } else {
                        break;
                    }
                }
                if (miastoZPrzesylka.najmniejszaOdleglosc != Integer.MAX_VALUE) {
                    tTemp[i] = t[i];
                    t[i] += miastoZPrzesylka.najmniejszaOdleglosc;
                }
                g.getKp().sortKp();
                lp = lPrzesylek.size() - 1;
            }
            g.getKp().sortKp();
        }
    }

    private String changeId(int i) {
        if (i < 10) return "00" + i;
        if (i < 100) return "0" + i;
        return "" + i;
    }

    @Override
    public String toString() {
        Collections.sort(rozwiazanie);
        String s = "";
        for (int j = 0; j < rozwiazanie.size(); j++) {
            s += rozwiazanie.get(j);
        }
        return s;
    }

    private class ElementRozwiazania implements Comparable<ElementRozwiazania> {
        public int czas;
        String elem;

        public ElementRozwiazania(String s) {
            elem = s;
            String x[] = s.split(" ");
            czas = Integer.parseInt(x[0]);
        }

        @Override
        public int compareTo(ElementRozwiazania o) {
            return this.czas - o.czas;
        }

        @Override
        public String toString() {
            return elem;
        }
    }
}

