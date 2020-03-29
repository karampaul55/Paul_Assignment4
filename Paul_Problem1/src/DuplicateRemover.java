import java.io.*;
import java.util.Iterator;
import java.util.Scanner ;
import java.util.HashSet ;

public class DuplicateRemover {
    //Instance Variables
    private HashSet<String> uniqueWords = new HashSet<String>() ;//HashSets seemed to be the best approach

    // Method to accept a file input and take out duplicate words
    public void remove(String dataFile) {
        File file = new File(dataFile);
        try {
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String next = input.next();
                next = next.toLowerCase();      //makes string lower case
                next = next.replaceAll("\\p{Punct}", "");  //removes punctuation from the String

                if (!next.isEmpty()) {       //This statement is here in the case of punctuation being considered a word
                    uniqueWords.add(next);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(("File not found. Please double check your path. "));
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Ran into an error. Please see error trace below:");
            e.printStackTrace();
            System.exit(0);        }
    }

    public void write(String outputFile) {
        File file = null;
        FileWriter fileWriter = null;

        try {
            file = new File(outputFile);

            if (!file.exists()) {
                file.createNewFile();
            }

            fileWriter = new FileWriter(file);

            Iterator<String> iter = uniqueWords.iterator();         // Using a hashset iterator to print to the file
            while(iter.hasNext()) {
                fileWriter.write(iter.next() + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.print("File Writing is Complete! Check out the text file!");
        }
        catch (FileNotFoundException e) {
            System.out.println(("Failed to create file."));
            System.exit(0);
        }
        catch(IOException e) {          //In the case that it is not a FileNotFoundException
            System.out.println("Ran into an error. Please see error trace below:");
            e.printStackTrace();
            System.exit(0);
        }
    }
}

