import przesylki.Miasto;

/**
 * Created by shafe_000 on 2014-11-30.
 */
public class GkoTest {
    public static void main(String args[]) {
        Gko gko = new Gko("miasta.txt", "zlecenia.txt", 3);

        gko.getKmip();

        for(int j=gko.getKp().getMiasta().size()-1; j>= 0; j=-1) { //zmien [rzy -1
            Miasto np = gko.getKp().getMiasta().get(j);
        }

        System.out.println(gko.toString());
    }
}
