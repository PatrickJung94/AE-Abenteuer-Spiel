/**
 * ToDo:
 * - add Question
 * - 
 */
package wwae;

import java.io.File;
import java.io.FileWriter;
import org.json.simple.*;

import java.io.IOException;

/**
 *  FileSytem class. To safe questions and settings into files and return the content of the files 
 *  
 *  by CHeinrichs
 */
public class FileSystem {
    public void main(String[] args) {
        this.createBundleFile("test");
    }

    public void createBundleFile(String bundleName/* , Question questionObj */) {
        try {
            FileWriter file;

            JSONObject jFileObj = new JSONObject();

            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}