import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DuplicateCounter {

    //Instance Variables
    private HashMap <String , Integer> wordCounter = new HashMap<>();

    // Method to accept a file input and take out duplicate words
    public void count (String dataFile)  {
        File file = new File(dataFile);
        try {
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String next = input.next();
                next = next.toLowerCase();      //makes string lower case
                next = next.replaceAll("\\p{Punct}", "");  //removes punctuation from the String
               if (!( next.isEmpty())) {
                    if (wordCounter.containsKey(next)) {
                        wordCounter.put(next, wordCounter.get(next) + 1);
                        //System.out.println(wordCounter.get(next));
                    } else {
                        wordCounter.put(next, 1);
                        //System.out.println(wordCounter.get(next));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(("File not found. Please double check your path. "));
            System.exit(0);
        } catch(Exception e) {
            System.out.println("Ran into an error. Please see error trace below:");
            e.printStackTrace();
            System.exit(0);
        }
    }

    // Method to write the DuplicateCounter to the txt file
    public void write(String outputFile)  {
        File file = null;
        FileWriter fileWriter = null;

        try {
            file = new File(outputFile);

            if (!file.exists()) {
                file.createNewFile();
            }

            fileWriter = new FileWriter(file);

            for (String key : wordCounter.keySet()) {
                fileWriter.write(key + ": " + wordCounter.get(key) + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.print("File Writing is Complete! Check out the text file!\n");
        } catch (FileNotFoundException e) {
            System.out.println(("Failed to create file."));
            System.exit(0);
        } catch(IOException e) {
            System.out.println("Ran into an error. Please see error trace below:");
            e.printStackTrace();
            System.exit(0);
        }
    }
}
