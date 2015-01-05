package vizualizacja;

import java.util.ArrayList;
import java.util.List;

public class Samochod{
    public List<Zdarzenie> getZdarzenia() {
        return zdarzenia;
    }

    List<Zdarzenie> zdarzenia;
    Samochod(){
        zdarzenia = new ArrayList<Zdarzenie>();
    }

    void addZdarzenie(Zdarzenie z){
        zdarzenia.add(z);
    }


}
