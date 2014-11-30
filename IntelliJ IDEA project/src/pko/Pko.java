package pko;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import dijkstra.Dijkstra;
import graf.Miasto;
import graf.Polaczenie;

/**
 * PKO - przygotowany kontener operacyjny
 */
public class Pko {
    private List<Miasto> miasta;

    public Pko(File plik, int idBazy) {
        miasta = new ArrayList<Miasto>();
        wczytajPko(plik);
        Dijkstra.obliczDrogi(miasta.get(idBazy).getW());
    }

    public List<Miasto> getMiasta() {
        return miasta;
    }

    public void wczytajPko(File plik) {
        try {
            InputStream fis = new FileInputStream(plik);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
            String l;
            while ((l = br.readLine()) != null) {
                if (l.contains("# miasta")) {
                    while ((l = br.readLine()) != null) {
                        if (l.contains("# połączenia")) {
                            break;
                        }
                        String lm[] = l.split(" ");
                        if (lm.length > 1) {
                            miasta.add(new Miasto(Integer.parseInt(lm[0]), lm[1]));
                        }
                    }
                    if (l.contains("# połączenia")) {
                        while ((l = br.readLine()) != null) {
                            String lm[] = l.split(" ");
                            if (lm.length > 2) {
                                miasta.get(Integer.parseInt(lm[0])).getW().polaczenia.add(new Polaczenie(
                                        miasta.get(Integer.parseInt(lm[1])).getW(), Integer.parseInt(lm[2])
                                ));
                            }
                        }

                    }
                }
            }


        } catch (Exception e) {
            System.err.println(e);
            return;
        }

    }

    @Override
    public String toString() {
        String s = "";
        for (int j = 0; j < miasta.size(); j++) {
            s += miasta.get(j).getW().toString() + "\n";
        }
        return s;
    }
}
