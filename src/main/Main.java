package main;

import controller.facade.GuiFacade;
import controller.facade.MainFacade;
import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import gui.MainWindow;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        PropertiesHandler.loadConfigProperties();
        PropertiesHandler.loadLanguageProperties(PropertiesKeys.SPANISH_LANG);
        Logger log = Logger.getLogger("org.hibernate");
        log.setLevel(Level.OFF);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

               /* if (MainFacade.logIn())
                {
                    new MainWindow();
                }*/
                JFrame mainWindows = new MainWindow();
                GuiFacade.setMainWindow(mainWindows);


            }
        });
    }
}
