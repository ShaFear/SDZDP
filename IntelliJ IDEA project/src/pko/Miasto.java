package pko;

import graph.Wierzcholek;

/**
 * Created by shafe_000 on 2014-11-30.
 */
public class Miasto {
    private int id;
    private String nazwa;
    private Wierzcholek w;

    public Miasto(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return id + ": " + nazwa;
    }
}
