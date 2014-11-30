/**
 * Created by shafe_000 on 2014-11-30.
 */
public class GkoTest {
    public static void main(String args[]) {
        Gko gko = new Gko("miasta.txt", "zlecenia.txt", 3);
        System.out.println(gko.toString());
    }
}
