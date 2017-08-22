import com.ivan.xinput.exceptions.XInputNotLoadedException;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


public class RLTyper {

        public static void main(String[] args) throws FileNotFoundException, AWTException, XInputNotLoadedException, InterruptedException {
            ConfigManager cf = new ConfigManager();
            HashMap currentHashMap;
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
            ControllerInterface ci = new ControllerInterface();

            while (ci.getController().poll()) {
                int dpadState = ci.getDpadState(ci.getController());
                 if (dpadState != -1) {
                     if (ci.getCurentLevel() == 0) {
                        currentHashMap = mapList.get(ci.calculateStringToSend(dpadState));
                        ci.setCurrentLevel(1);
                     }
                     else {
                         ci.type(currentHashMap.get(
                                 cf.getKey(currentHashMap)).get(
                                    ci.calculateStringToSend(
                                         dpadState)));
                         // return the currenLevel to original state
                         ci.setCurrentLevel(0);
                     }
                 }
            }
        }



}