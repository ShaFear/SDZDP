package vizualizacja;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shafe_000 on 2015-01-04.
 */
public class RuchSamochodow {
    List<Samochod> samochody;
    public RuchSamochodow(int numer){
        samochody = new ArrayList<Samochod>();
        for(int j=0; j<numer; j++){
            samochody.add(new Samochod());
        }
    }

    public List<Samochod> getSamochody() {
        return samochody;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(int j=0; j<samochody.size(); j++){
            s.append("Samochód o numerze: " + j + "\n");
            s.append(samochody.get(j).getZdarzenia().toString() + "\n");
        }
        return s.toString();
    }
}

