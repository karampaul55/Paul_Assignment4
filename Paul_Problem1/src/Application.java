import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {

        DuplicateRemover duplicateRemover = new DuplicateRemover();

        duplicateRemover.remove("problem1.txt");
        duplicateRemover.write("unique_words1.txt");
    }
}

