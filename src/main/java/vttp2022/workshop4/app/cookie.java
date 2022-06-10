package vttp2022.workshop4.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class cookie {

    public static String serverCookie() throws IOException {
        try{
            File test = new File("C:\\Users\\Brendon\\JavaProjects\\sdf-workshop4\\src\\main\\java\\vttp2022\\workshop4\\app\\cookie.txt");
            System.out.println("File opened is " + test.getName()); 

            BufferedReader br = new BufferedReader(new FileReader(test));
            List<String> cookieTypes = new LinkedList<String>();
            String line;
            while((line = br.readLine()) != null)
            {
                cookieTypes.add(line);
            }
    
            int x = (int) (Math.random()*26); 
            return cookieTypes.get(x);

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
