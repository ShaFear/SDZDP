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
    ArrayList<Miasto> m;

    public Kp(Kmip kmip, int pojemnoscSamochodu, File zlecenia) {
        m = new ArrayList<Miasto>();
        for (int j = 0; j < kmip.getMiasta().size(); j++) {
            m.add(new Miasto(pojemnoscSamochodu, kmip.getMiasta().get(j)));
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
                        m.get(Integer.parseInt(ls[2])).dodajPrzesylke(p);
                    }
                }
        } catch (Exception e) {
            System.err.println(e);
            return;
        }
        Collections.sort(m);
    }

    @Override
    public String toString() {
        String s = "";
        for (int j = 0; j < m.size(); j++) {
            s += m.get(j).toString() + "\n";
        }
        return s;
    }
}
