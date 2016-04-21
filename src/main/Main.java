package main;

import controller.ddbb.DBMapNameId;
import controller.facade.GuiFacade;
import controller.facade.GuiItems;
import controller.facade.MainFacade;
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
            PropertiesHandler.loadConfigProperties();
            PropertiesHandler.loadLanguageProperties(PropertiesKeys.SPANISH_LANG);
            Logger log = Logger.getLogger("org.hibernate");
            log.setLevel(Level.OFF);
            DBMapNameId.initWorks();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {

                /* if (MainFacade.logIn())
                {
                        new MainWindow();
                }*/
                    JFrame mainWindows = null;
                    try {
                        mainWindows = new MainWindow();
                    } catch (DBException e) {
                        e.printStackTrace();
                    }
                    GuiItems.setMainWindow(mainWindows);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
