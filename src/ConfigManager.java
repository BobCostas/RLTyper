import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


public class ConfigManager {
    /**
     * ConfigManager interacts with configs, from creating, loading,
     */
    Path file = Paths.get("/home/zane/Documents/Programming/Java/Projects/RLTyper/src/sampletext");

    /**
     * Loads a config from a config file
     * TODO Implement of a config in the correct format
     */
    public void loadConfig() {
        // Load the default charset
        Charset charset = Charset.defaultCharset();

        // Create the buffered reader, read the config file from it
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
                System.err.format("IOException %s %n", x);
                }
    }


    /**
     *
     * @param configMap A hahmap containing String as the key, and an ArrayList of Strings
     *                  as the values. The key is the name of our direction
     *                  e.g. North, East, South, or West, and the ArrayList
     *                  contains the Messages associated with that direction
     * @return A String formatted as "Direction: [item1, item2, item3, item4]\n"
     */
   public String formatConfigFileEntry(HashMap<String, ArrayList<String>> configMap) {
     String outputString = "";
     for (String key : configMap.keySet()) {
        outputString += key + ": ";
        outputString += "[";
        for (String string : configMap.get(key)) {
            outputString += string + ", ";

         }
         outputString += "]";
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