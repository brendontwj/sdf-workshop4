package vttp2022.workshop4.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class cookie {

    public String serverCookie(String cookieFilePath) throws IOException {
        try{
            BufferedReader br = new BufferedReader(new FileReader(cookieFilePath));
            List<String> cookieTypes = new LinkedList<String>();
            String line;
            while((line = br.readLine()) != null)
            {
                cookieTypes.add(line);
            }
            
            br.close();
            
            int x = (int) (Math.random()*(cookieTypes.size())); 
            return "cookie-text" + cookieTypes.get(x);

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
