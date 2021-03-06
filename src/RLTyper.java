import com.ivan.xinput.exceptions.XInputNotLoadedException;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


public class RLTyper {

        public static void main(String[] args) throws FileNotFoundException, AWTException, XInputNotLoadedException, InterruptedException {
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

            ControllerInterface ci = new ControllerInterface();
            FourStringInterface fi = new FourStringInterface();
            fi.setPositions(500, 500);
            fi.setStrings(arString);
            fi.initializeFrame("RLTyper");
            while (ci.getController().poll()) {
                int dpadState = ci.getDpadState(ci.getController());
                 if (dpadState != -1) {
                     HashMap<String, ArrayList<String>> currentMap = mapList.get(ci.calculateStringToSend(dpadState));
                     // Select which direction we are going to send the string from,
                     // display that selection in a FourStringInterface
                     if (ci.getCurentLevel() == 0) {
                        fi.showFrame();
                        ci.setCurrentLevel(1);
                     }
                     else {
                         // Hide the frame, set Rocket League as the active window
                         fi.hideFrame();
                         // Calculate the message to type, and then type it
                         ci.type(
                                 currentMap.get(
                                         cf.getKey(currentMap)).get(
                                         ci.calculateStringToSend(dpadState)
                                 )
                         );
                         // return the CurrentLevel to its default state
                         ci.setCurrentLevel(0);
                     }
                 }

                Thread.sleep(ci.getPollingRate());
            }
//            FourStringInterface fi = new FourStringInterface();
//            fi.setPositions(500, 500);
//            fi.setStrings(arString);
//            fi.initializeFrame("RLTyper");
//            fi.showFrame();
        }



}