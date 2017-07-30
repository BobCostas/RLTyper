import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


public class RLTyper {
        public static void main(String[] args) throws FileNotFoundException {
                ConfigManager cf = new ConfigManager();

                cf.loadConfig();
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            ArrayList<String> stringArrayList = new ArrayList<>();
            stringArrayList.add("Meme1");
            stringArrayList.add("Meme2");
            stringArrayList.add("Meme3");
            stringArrayList.add("Meme4");
            map.put("North", stringArrayList);
            //Scanner scan=new Scanner(file);
            System.out.println(cf.formatConfigFileEntry(map));
        }


}