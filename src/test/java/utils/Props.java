package utils;

import java.io.*;
import java.util.Properties;

public class Props {
    private Properties properties;
    private final String propertyFilePath = System.getProperty("user.dir") + "/Documents/env.properties";

    public Props() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getNavegador() {
        String driverPath = properties.getProperty("BROWSER");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }

    public String getRuta() {
       String env = properties.getProperty("ENV_URL");
       // String url = properties.getProperty(URL);

       //if (url != null) return env+url;
        if (env != null) return env;
        else
            throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }

}
