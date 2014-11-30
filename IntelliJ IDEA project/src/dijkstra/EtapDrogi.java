package dijkstra;


public class EtapDrogi {

    private int odleglosc;
    private String miasto;

    public EtapDrogi(int odleglosc, String miasto) {
        this.odleglosc = odleglosc;
        this.miasto = miasto;
    }

    @Override
    public String toString() {
        return odleglosc + " " + miasto;
    }

    public int getOdleglosc() {
        return odleglosc;
    }

    public String getMiasto() {
        return miasto;
    }
}
