package pko;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import graph.Miasto;
import graph.Polaczenie;

/**
 * PKO - przygotowany kontener operacyjny
 */
public class Pko {
    private List<Miasto> miasta;

    public Pko(File plik) {
        miasta = new ArrayList<Miasto>();
        wczytajPko(plik);
    }

    public static void main(String[] args) {
        File f = new File("text.txt");
        Pko p = new Pko(f);
        System.out.print(p.toString());
    }

    private void wczytajPko(File plik) {
        try {
            Integer liczbaMiast = 0;
            Integer liczbaPolaczen = 0;
            int liczbaLinii = 1;

            InputStream fis = new FileInputStream(plik);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String l;
            while ((l = br.readLine()) != null) {
                liczbaLinii++;
                if (l == "# miasta") {
                    while ((l = br.readLine()) != null) {
                        liczbaLinii++;
                        if (l == "# połączenia") break;
                        String lm[] = l.split(" ");
                        if (lm.length > 1) {
                            if (lm[0] != liczbaMiast.toString()) {
                                throw new Exception("Zły format pliku z danymi w linii: " + liczbaLinii);
                            } else {
                                miasta.add(new Miasto(liczbaMiast, lm[1]));
                                liczbaMiast++;
                            }
                        }
                    }
                }

                if (l == "# połączenia") {
                    while ((l = br.readLine()) != null) {
                        liczbaLinii++;
                        String lm[] = l.split(" ");
                        if (lm.length > 2) {
                            miasta.get(Integer.parseInt(lm[0])).getW().polaczenia.add(new Polaczenie(
                                    miasta.get(Integer.parseInt(lm[1])).getW(), Integer.parseInt(lm[2])
                            ));
                            liczbaPolaczen++;
                        }
                    }

                }
            }


        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public String toString() {
        String s="";
        for(int j=0; j<miasta.size(); j++){
            s+=miasta.get(j).getW().toString()+"/n";
        }
        return s;
    }
}
