import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


public class RLTyper {

        public static void main(String[] args) throws FileNotFoundException {
                ConfigManager cf = new ConfigManager();
            File fileFile = new File("src/sampletext2");
            HashMap<String, ArrayList<String>> first = new HashMap<>();
            HashMap<String, ArrayList<String>> second = new HashMap<>();
            HashMap<String, ArrayList<String>> third = new HashMap<>();
            HashMap<String, ArrayList<String>> fourth = new HashMap<>();
            ArrayList<String> arString = new ArrayList<>();
            arString.add("This is a string");
            arString.add("Also a String");
            arString.add("STRINGS Here");
            arString.add("String here as well");


            first.put("North", arString);
            second.put("East", arString);
            third.put("South", arString);
            fourth.put("West", arString);

            ArrayList<HashMap> mapList = new ArrayList<>();
            mapList.add(first);
            mapList.add(second);
            mapList.add(third);
            mapList.add(fourth);
            System.out.println(mapList);

            for (HashMap hash : mapList) {
                cf.writeConfigToFile(hash, fileFile);
            }

            System.out.println(cf.loadConfigFromFile(fileFile));
        }


}