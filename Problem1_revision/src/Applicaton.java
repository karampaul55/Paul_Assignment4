import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

class Application {
    public static void main(String[] args) {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

            duplicateRemover.remove("problem3.txt");
            duplicateRemover.write("unique_words6.txt");
    }
}

