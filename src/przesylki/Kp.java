package przesylki;

import kmip.Kmip;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Kp - kontener przesyłek
 */
public class Kp {
    ArrayList<Miasto> miasta;

    public Kp(Kmip kmip, int pojemnoscSamochodu, File zlecenia) {
        miasta = new ArrayList<Miasto>();
        for (int j = 0; j < kmip.getMiasta().size(); j++) {
            miasta.add(new Miasto(pojemnoscSamochodu, kmip.getMiasta().get(j)));
        }
        try {
            InputStream fis = new FileInputStream(zlecenia);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
            String l;
            if ((l = br.readLine()) != null)
                while ((l = br.readLine()) != null) {
                    String ls[] = l.split(" ");
                    if (ls.length == 5) {
                        Przesylka p = new Przesylka(Integer.parseInt(ls[0]), ls[3], Integer.parseInt(ls[4]));
                        miasta.get(Integer.parseInt(ls[2])).dodajPrzesylke(p);
                    }
                }
        } catch (Exception e) {
            System.err.println(e);
            return;
        }
        this.sortKp();
    }

    public void sortKp(){
        Collections.sort(miasta);
    }

    public ArrayList<Miasto> getMiasta() {
        return miasta;
    }

    @Override
    public String toString() {
        String s = "";
        for (int j = 0; j < miasta.size(); j++) {
            s += miasta.get(j).toString() + "\n";
        }
        return s;
    }
}
