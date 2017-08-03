import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ConfigManager {
    /**
     * ConfigManager interacts with configs, from creating, loading,
     */

    /**
     * Loads a config from a config file
     * TODO Implement of a config in the correct format
     */
    public ArrayList<String> loadConfigFromFile(File inputFile) throws FileNotFoundException {
        ArrayList<String> returnArrayList = new ArrayList<>();
        // Create a scanner to read our inputFile
        Scanner in = new Scanner(inputFile);
        // Loop through each line, and add it to our output ArrayList
        while (in.hasNextLine()) {
            returnArrayList.add(in.nextLine());
        }
        // Remember to close the file
        in.close();
        return returnArrayList;


    }


    /**
     *
     * @param configMap A hashmap containing String as the key, and an ArrayList of Strings
     *                  as the values. The key is the name of our direction
     *                  e.g. North, East, South, or West, and the ArrayList
     *                  contains the Messages associated with that direction
     * @return A String formatted as "Direction: [Thing1][Thing2][Thing3][Thing4]"
     */
   public String formatConfigAsString(HashMap<String, ArrayList<String>> configMap) {
     String outputString = "";
     // Loop through each of the keys in our HashMap
     for (String key : configMap.keySet()) {
        outputString += key + ": ";
        for (String string : configMap.get(key)) {
            outputString += "[" + string + "]";
         }

     }


        return outputString;
   }

    /**
     * Creates an entry for the config file, one direction of our D-pad input
     * @param configMap A hashmap containg String as the key, and an ArrayList of Strings
     */
  //  public void createConfigFileEntry(HashMap<String, ArrayList<String>> configMap) {
       // Load the default CharSet
//       Charset charset = Charset.defaultCharset();

       //create our buffered Writer, which writes our value to the file

 //   }


    /**
     * TODO See if this is the right class to implement this in
     * @return
     */
    public boolean checkMessageLength() {return true;}

}