package vizualizacja;

import java.awt.geom.Ellipse2D;

/**
 * Created by shafe_000 on 2015-01-05.
 */
public class PozycjeSamochodow {

    public static Ellipse2D.Double[] setPozycjeSamochodow(Integer czas, Ellipse2D.Double[] circles, RuchSamochodow ruchSamochodow) {
        for(int j=0; j<ruchSamochodow.samochody.size(); j++){
            for( int i=0; i<ruchSamochodow.samochody.get(j).getZdarzenia().size(); i++){
                if(ruchSamochodow.samochody.get(j).getZdarzenia().get(i).getCzas() == czas){

                    switch (ruchSamochodow.samochody.get(j).getZdarzenia().get(i).getMiejsce()){
                        case "Warszawa": {
                            circles[j].x = 414 + j*5;
                            circles[j].y = 400;
                        }
                    }
                    break;
                }
            }
        }
        return circles;
    }
}
