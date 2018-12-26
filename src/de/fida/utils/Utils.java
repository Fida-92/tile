

package de.fida.utils;

import java.io.BufferedReader;
import java.io.FileReader;

 
public class Utils {

    
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line="";
            while ((line = br.readLine()) != null ) {                
                builder.append(line+"\n");
            }
            br.close();
        } catch (Exception e) {
            System.err.println("not found");
        }
        return builder.toString();
    }
    
    
    public static int parseInt(String number){
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
        return 0;
        }
    }
}
