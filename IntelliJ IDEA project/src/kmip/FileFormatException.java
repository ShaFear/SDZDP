package kmip;

/**
 * Created by shafe_000 on 2014-11-30.
 */
public class FileFormatException extends Exception {
    public FileFormatException(int linia) {
        super("Zły format w pliku z danymi miast i połączeń w linii: " + linia);
    }
}
