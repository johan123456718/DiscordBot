package bootstrap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties properties;

    public Config(String fileName) throws Exception{
        properties = new Properties();
        loadProperties(fileName);
    }

    private void loadProperties(String fileName) throws Exception{
        InputStream in = new FileInputStream(fileName);
        properties.load(in);
    }

    public String getToken(){
        return properties.getProperty("token");
    }

}
