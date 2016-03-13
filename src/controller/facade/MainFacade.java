package controller.facade;


import controller.languageHandler.CanChangeLanguage;
import controller.languageHandler.ChangeLanguageObserver;
import controller.security.PropertiesHandler;
import exceptions.SomethingWrongHappenException;
import gui.factory.FactoryDialog;

import javax.swing.*;

public class MainFacade
{

    public static void closeProgram (int closeOption) throws SomethingWrongHappenException
    {
        switch (closeOption)
        {
            case JOptionPane.YES_OPTION:
                //Sure we must do more shit
                System.exit(1);
                break;

            case JOptionPane.NO_OPTION:
                //DO nothing
                break;

            case JOptionPane.CLOSED_OPTION:
                //Do nothing
                break;

            default:
                throw new SomethingWrongHappenException();
        }
    }

    public static void changeLanguage (String lang)
    {
        PropertiesHandler.loadLanguageProperties(lang);
        ChangeLanguageObserver.changeLanguage();
    }

    public static void addLanguageListener (CanChangeLanguage listener)
    {
        ChangeLanguageObserver.addNewListener(listener);
    }

    public static void clearLanaguageListener ()
    {
        ChangeLanguageObserver.clearAll();
    }

    public static void removeLanguageListener (CanChangeLanguage listener)
    {
        ChangeLanguageObserver.removeListener (listener);
    }

    public static boolean logIn()
    {
        return FactoryDialog.loginGUIDialog() == 1;
    }


}
