import java.io.*;
import java.util.Scanner ;
import java.util.HashSet ;


public class DuplicateRemover {
    //Instance Variables
    private HashSet<String> uniqueWords = new HashSet<>() ;//HashSets seemed to be the best approach

    // Method to accept a file input and take out duplicate words
    public void remove(String dataFile) {
        File file = new File(dataFile);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String next = input.next();
                //System.out.println(next);
                next = next.toLowerCase();      //makes string lower case
                next = next.replaceAll("\\p{Punct}", "");  //removes punctuation from the String
                //System.out.println(next);     Test Code
                uniqueWords.add(next);
                //System.out.println(uniqueWords.add(next)); //True if entered successfully.
            }
            //Test Code
            //System.out.println(uniqueWords);
            //System.out.println(uniqueWords.size());

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file. Check the path please.");
        }
    }


    public void write(String outputFile) {
        File file ;
        FileWriter fileWriter ;

        try {
        file = new File(outputFile);

        if (file.createNewFile()) {
            System.out.println("File created");
        }
        else {
            System.out.println("File will be overwritten");
        }

        fileWriter = new FileWriter(file) ;
        fileWriter.write(String.valueOf(uniqueWords));
        fileWriter.close();
        System.out.print("File Writing is Complete! Check out the text file!");
        } catch (FileNotFoundException e) {
            System.out.println("For some reason, your file was not found, nor created. Please try again");
        } catch (IOException e) {
            System.out.println("Please see exception below: ");
            e.printStackTrace();
            }
    }
}

