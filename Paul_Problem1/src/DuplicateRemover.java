import java.io.*;
import java.util.Scanner ;
import java.util.HashSet ;


public class DuplicateRemover {
    //Instance Variables
    private HashSet<String> uniqueWords = new HashSet<String>() ;//HashSets seemed to be the best approach


    // Method to accept a file input and take out duplicate words
    public void remove(String dataFile) throws Exception {
        File file = new File(dataFile);
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String next = input.next();
            System.out.println(next);
            next = next.toLowerCase();      //makes string lower case
            next = next.replaceAll("\\p{Punct}", "");  //removes punctuation from the String
            //System.out.println(next);     Test Code
            uniqueWords.add(next);
        }
        //Test Code
        //System.out.println(uniqueWords);
        //System.out.println(uniqueWords.size());
    }

    public void write(String outputFile) throws IOException {
        File file = null;
        FileWriter fileWriter = null;

        file = new File(outputFile);

        if (!file.exists()) {
            file.createNewFile();
        }

        fileWriter = new FileWriter(file);
        fileWriter.write(String.valueOf(uniqueWords));
        fileWriter.close();
        System.out.print("File Writing is Complete! Check out the text file!");

    }

//        Writer out = new FileWriter(outputFile);
//        out.write(String.valueOf(uniqueWords));
//        out.flush();
//        out.close();

        //Test code
}

