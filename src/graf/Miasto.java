package graf;

import dijkstra.EtapDrogi;

import java.util.ArrayList;

public class Miasto {
    private int id;
    private String nazwa;

    public ArrayList<EtapDrogi> getEtapy() {
        return etapy;
    }

    private ArrayList<EtapDrogi> etapy;

    public Wierzcholek getW() {
        return w;
    }

    private Wierzcholek w;

    public Miasto(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
        w = new Wierzcholek(this);
        etapy = new ArrayList<EtapDrogi>();
    }

    @Override
    public String toString() {
        return nazwa.toString();
    }
}
