/**
 * ToDo:
 * - add Question
 * - 
 */
package wwae;

import java.io.*;
import java.io.FileReader;
import java.io.FileNotFoundException;    
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static java.nio.file.StandardOpenOption.*;

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
        this.addQuestionToBundle("test");
        // this.editBundleFile("test");
    }

    /**
     * Function to create a new Questionbundle-File
     * @param bundleName Name for the File
     * 
     * @throws FileNFileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public void addQuestionToBundle(String bundleName/* , Question questionObj */) {
        JSONParser jParser = new JSONParser();
        JSONArray jFileArray = new JSONArray();
        JSONObject jQuestionObj = new JSONObject();
        ArrayList<String> jQuestionArray = new ArrayList<String>();
        Path jFileObjPath = Paths.get("data/"+bundleName+".json");
        
        if(Files.exists(jFileObjPath)) {
            try(FileReader reader = new FileReader("data/"+bundleName+".json"))
            {        
                Object obj = jParser.parse(reader);

                jFileArray = (JSONArray) obj;

                System.out.println(jFileArray);
            } 
            catch (FileNotFoundException e) {
                System.out.println("File not Found.");
                e.printStackTrace();
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } 
            catch (ParseException e) {
                System.out.println("An error occurred parsing the File.");
                e.printStackTrace();
            }
        }
        
        jQuestionArray.add("Frage 1");
        jQuestionArray.add("Frage 2");
        jQuestionArray.add("Frage 3");
        jQuestionArray.add("Frage 4");
    
        jQuestionObj.put("Antworten", jQuestionArray);
        jQuestionObj.put("Index", 1);
        jQuestionObj.put("Fragentext", "Fragentext");
        jQuestionObj.put("Time", (double) 30.00);
    
        jFileArray.add(jQuestionObj);

        byte jObjData[] = jFileArray.toJSONString().getBytes();

        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(jFileObjPath, CREATE, TRUNCATE_EXISTING))) {
            out.write(jObjData, 0, jObjData.length);
            out.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred creating the File.");
            e.printStackTrace();
        }
    }

    // public void editBundleFile(String bundleName/* , Question questionObj */) {
    //     JSONArray jFileArray = new JSONArray();

    //     JSONObject jQuestionObj = new JSONObject();
    //     ArrayList<String> jQuestionArray = new ArrayList<String>();
        
    //     jQuestionArray.add("Frage 1");
    //     jQuestionArray.add("Frage 2");
    //     jQuestionArray.add("Frage 3");
    //     jQuestionArray.add("Frage 4");

    //     jQuestionObj.put("Antworten", jQuestionArray);
    //     jQuestionObj.put("Fragentext", "Fragentext");
    //     jQuestionObj.put("Time", (double) 30.00);
        
    //     jFileArray.add(jQuestionObj);
        
        
    //     Path jFileObjPath = Paths.get("data/output.json");
    //     byte jObjData[] = jFileArray.toJSONString().getBytes();
        
    //     try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(jFileObjPath, APPEND))) {
    //         out.write(jObjData, 0, jObjData.length);
    //         out.close();
    //     }
    //     catch (IOException e) {
    //         System.out.println("An error occurred.");
    //         e.printStackTrace();
    //     }
    //     System.out.println("JSON file created: "+jFileArray.toJSONString());
    // }
}
//Gruß an Markus :D