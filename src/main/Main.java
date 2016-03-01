package main;

import controller.facade.MainFacade;
import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import gui.MainWindow;
import javax.swing.*;

public class Main
{
    public static void main (String[] args)
    {
        PropertiesHandler.loadConfigProperties();
        PropertiesHandler.loadLanguageProperties(PropertiesKeys.ENGLISH_LANG);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                if (MainFacade.logIn())
                {
                    new MainWindow();
                }


            }
        });
    }
}
