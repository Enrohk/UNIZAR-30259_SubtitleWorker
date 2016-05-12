package main;

import controller.ddbb.DBMapNameId;
import controller.facade.GuiFacade;
import controller.facade.MainFacade;
import controller.functions.GuiFunctions;
import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import exceptions.DBException;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        try {
            System.setProperty("line.separator","\r\n");
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
        try {
            if(MainFacade.isLoggedUser())
                GuiFunctions.showGUI();
            else
                GuiFacade.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //GuiFunctions.showGUI();


    }
}
