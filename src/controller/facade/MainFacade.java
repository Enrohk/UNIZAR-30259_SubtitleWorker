package controller.facade;


import controller.ddbb.DataBaseManager;
import controller.ddbb.QueryGenerator;
import controller.ddbb.dto.SubtitleDTO;
import controller.functions.FileContent;
import controller.functions.Functions;
import controller.functions.Lirerals;
import controller.languageHandler.CanChangeLanguage;
import controller.languageHandler.ChangeLanguageObserver;
import controller.security.PropertiesHandler;
import exceptions.DBException;
import exceptions.SomethingWrongHappenException;
import gui.factory.FactoryDialog;
import java.util.*;

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

    public static void addSubtitle (String title, String contentPath,
                                    String language, String resourceName) throws DBException
    {
        try
        {
            SubtitleDTO subtitleDTO = new SubtitleDTO();
            subtitleDTO.setTitle(title);
            subtitleDTO.setContent(FileContent.getFileContent(contentPath).getBytes());
            String query = QueryGenerator.GET_LANGUAGE_BY_NAME + "'" + language +"'";
            List list = DataBaseManager.getListByQuery(query);
            int id = Functions.getObjectIDByType(Lirerals.LANGUAGE_TYPE, list.get(0));
            subtitleDTO.setLanguageIdLanguage(id);
            query = QueryGenerator.GET_WORK_BY_NAME + "'" + resourceName + "'";
            list = DataBaseManager.getListByQuery(query);
            id = Functions.getObjectIDByType(Lirerals.WORK_TYPE , list.get(0));
            subtitleDTO.setWorkIdWork(id);

            DataBaseManager.saveOrDeleteSingleObject(subtitleDTO.getSubtitle(),true);

        }
        catch (Exception e)
        {

        }
        finally {

        }
    }

}
