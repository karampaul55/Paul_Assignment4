import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        try {
            duplicateRemover.remove("problem1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Please double check your filename\n");
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException has been triggered, but program still continued successfully.\n");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something is wrong\n");
        }

        try {
            duplicateRemover.write("unique_words.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

