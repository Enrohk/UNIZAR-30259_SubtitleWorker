package controller.security;


import controller.facade.MainFacade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

    private static Properties langProperties = new Properties();
    private final static Properties configProperties = new Properties();

    public static String getLanguageValue (String key)
    {
        //HANDLE ERROR
        return langProperties.getProperty(key);
    }

    public static String getConfigValue (String key)
    {
        //HANDLE ERROR
        return configProperties.getProperty(key);
    }


    public static void loadConfigProperties ()
    {
        try (FileInputStream input = new FileInputStream(PropertiesKeys.CONFIG_PROPERTIES_PATH)) {

            configProperties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
            //HANDLE
        }
    }

    /**
     * Load the new language propertie and cchange all the listener language
     * @param lang
     */
    public static void loadLanguageProperties (String lang)
    {
        try (FileInputStream input = new FileInputStream(lang)) {

            langProperties.load(input);
            MainFacade.changeLanguage(lang);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



}
