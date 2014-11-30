package test.Graph;

public class Miasto {
    private int id;
    private String nazwa;

    public Miasto(int id, String nazwa){
        this.id = id;
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa.toString();
    }
}
