import kmip.Kmip;
import przesylki.Kp;

import java.io.*;
import java.util.Scanner;

/**
 * gko - główny kontener operacyjny
 */
public class Gko {
    private Kmip kmip;
    private Kp kp;
    private int idBazy;

    public int getPojemnosc() {
        return pojemnosc;
    }

    private int pojemnosc;

    public Gko(String plikMapy, String plikZlecen, int pojemnoscSamochodu) {
        idBazy = 0;
        this.pojemnosc = pojemnoscSamochodu;
        File fplikZlecen = new File(plikZlecen);
        File fplikMapy = new File(plikMapy);
        kmip = new Kmip(fplikMapy, idBazy);
        kp = new Kp(kmip, pojemnoscSamochodu, fplikZlecen);
    }

    public Kmip getKmip() {
        return kmip;
    }

    public Kp getKp() {
        return kp;
    }

    @Override
    public String toString() {
        return kmip.toString() + "\n" + kp.toString();
    }

    public int getIdBazy() {
        return idBazy;
    }
}
