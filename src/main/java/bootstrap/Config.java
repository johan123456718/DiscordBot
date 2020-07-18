package bootstrap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private Properties properties;

    public Config(String fileName){

    }

    private InputStream getPropertyFile(String fileName){
        try(InputStream in = new FileInputStream(fileName)){
            return in;
        } catch (Exception e){

        }
    }
}
