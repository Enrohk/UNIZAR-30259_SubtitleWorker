package main;

import controller.ddbb.DBMapNameId;
import controller.functions.GuiFunctions;
import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            PropertiesHandler.loadConfigProperties();
            PropertiesHandler.loadLanguageProperties(PropertiesKeys.SPANISH_LANG);
            Logger log = Logger.getLogger("org.hibernate");
            log.setLevel(Level.OFF);
            DBMapNameId.initWorks();

            SwingUtilities.invokeLater( () -> start() );
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void start ()
    {
        //GuiFacade.start()
        GuiFunctions.showGUI();


    }
}
