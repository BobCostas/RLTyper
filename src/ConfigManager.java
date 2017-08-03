import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
     * Writes a config to the file specified in the format created by formatConfigAsString
     *
     * @param configToWrite the data we are going to write to the file, a hashmap of an arraylist containing strings,
     *                      see formatAsConfig for more information
     * @param fileToWriteTo The file we are going to write to, if it already exists it is overwritten,
     *                      if not then it is created
     */
    public void writeConfigToFile(HashMap<String, ArrayList<String>> configToWrite, File fileToWriteTo) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileToWriteTo);
        // Formats our input data, and writes it to the file
        out.println(formatConfigAsString(configToWrite));
        // Close the file, clear our buffer
        out.close();
    }
}
