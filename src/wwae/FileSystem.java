/**
 * ToDo:
 * - add Question
 * - 
 */
package wwae;

import java.io.FileWriter;
import org.json.simple.*;
import java.io.IOException;

/**
 *  FileSytem class. To safe questions and settings into files and return the content of the files 
 *  
 *  by CHeinrichs
 */
public class FileSystem {
    /**
     * Class constructor
     */
    public FileSystem() {
        this.createBundleFile("test");
    }

    /**
     * Function to create a new Questionbundle-File
     * @param bundleName Name for the File
     * 
     * @throws IOException if File couldn't be created
     */
    public void createBundleFile(String bundleName/* , Question questionObj */) {
        JSONObject jFileObj = new JSONObject();

        JSONObject jQuestionObj = new JSONObject();
        JSONArray jQuestionArray = new JSONArray();
        
        jQuestionObj.put("Frage 1", "Test 1?");
        jQuestionObj.put("Frage 2", "Test 2?");
        jQuestionObj.put("Frage 3", "Test 3?");
        jQuestionObj.put("Frage 4", "Test 4?");
        
        jQuestionArray.add(jQuestionObj);
        
        jFileObj.put("Fragen", jQuestionArray);
        
        try{
            FileWriter file = new FileWriter("data/output.json");
            file.write(jFileObj.toJSONString());
            file.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+jFileObj.toJSONString());
        System.out.println("JSON file created: "+jFileObj);
    }
}
//Gruß an Markus :D