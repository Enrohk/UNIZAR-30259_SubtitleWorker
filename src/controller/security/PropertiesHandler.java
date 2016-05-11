package controller.security;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesHandler {

    private static Properties langProperties = new Properties();
    private final static Properties configProperties = new Properties();

    public static String getLanguageValue(String key) {
        return langProperties.getProperty(key);
    }

    public static String getConfigValue(String key) {
        return configProperties.getProperty(key);
    }

    public static void setConfigValue (String[] key, String[] value)
    {
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream(PropertiesKeys.CONFIG_PROPERTIES_PATH);

            // set the properties value
            for (int i=0;i<key.length;i++)
            {
                prop.setProperty(key[i],value[i]);
            }
            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static void loadConfigProperties() {
        try (FileInputStream input = new FileInputStream(PropertiesKeys.CONFIG_PROPERTIES_PATH)) {

            configProperties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
            //HANDLE
        }
    }

    /**
     * Load the new language propertie and cchange all the listener language
     *
     * @param lang
     */
    public static void loadLanguageProperties(String lang) {
        try (FileInputStream input = new FileInputStream(lang)) {
            langProperties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
