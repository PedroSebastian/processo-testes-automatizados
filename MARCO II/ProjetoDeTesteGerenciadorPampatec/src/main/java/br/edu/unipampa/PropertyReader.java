package br.edu.unipampa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static String read(String propertyName) {
        String propertyValue = null;

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/test/resources/config.properties"));

            propertyValue = properties.getProperty(propertyName);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return propertyValue;
    }

}
