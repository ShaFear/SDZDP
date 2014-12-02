package przesylki;

public class Przesylka implements Comparable<Przesylka> {
    public int getId() {
        return id;
    }

    private int id;
    private String nazwa;

    public Przesylka(int id, String nazwa, int priorytet) {
        this.id = id;
        this.nazwa = nazwa;
        this.priorytet = priorytet;
    }

    public int getPriorytet() {
        return priorytet;
    }

    private int priorytet;

    @Override
    public int compareTo(Przesylka o) {
        return this.priorytet - o.priorytet;
    }

    @Override
    public String toString() {
        return nazwa + ": pr-" + priorytet + " id-" + id;
    }
}
