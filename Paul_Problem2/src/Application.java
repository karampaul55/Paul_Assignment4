import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {

        DuplicateCounter duplicateCounter = new DuplicateCounter();

            duplicateCounter.count("problem2.txt");
            duplicateCounter.write("unique_word_counts.txt");
    }
}

