package main;

import controller.ddbb.DBMapNameId;
import controller.facade.GuiFacade;
import controller.facade.GuiItems;
import controller.facade.MainFacade;
import controller.functions.GuiFunctions;
import controller.functions.Mocker;
import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import exceptions.DBException;
import gui.MainWindow;

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
        Mocker.generateMocks();

    }
}
