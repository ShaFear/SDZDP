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
}

