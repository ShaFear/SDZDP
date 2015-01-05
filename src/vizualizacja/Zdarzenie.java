package vizualizacja;

public class Zdarzenie{
    private int czas;

    public String getMiejsce() {
        return miejsce;
    }

    public int getCzas() {
        return czas;
    }

    private String miejsce;

    public Zdarzenie(String miejsce, int czas) {
        this.miejsce = miejsce;
        this.czas = czas;
    }
}
