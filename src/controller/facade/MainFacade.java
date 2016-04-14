package controller.facade;


import controller.ddbb.DataBaseManager;
import controller.ddbb.QueryGenerator;
import controller.ddbb.dto.SubtitleDTO;
import controller.ddbb.dto.WorkDTO;
import controller.functions.FileContent;
import controller.functions.Functions;
import controller.functions.Literals;
import controller.functions.FileCreator;
import controller.languageHandler.CanChangeLanguage;
import controller.languageHandler.ChangeLanguageObserver;
import controller.security.PropertiesHandler;
import exceptions.DBException;
import exceptions.SomethingWrongHappenException;
import gui.factory.FactoryDialog;
import model.ddbb.entity.Subtitle;

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
            int id = Functions.getObjectIDByType(Literals.LANGUAGE_TYPE, list.get(0));
            subtitleDTO.setLanguageIdLanguage(id);
            query = QueryGenerator.GET_WORK_BY_NAME + "'" + resourceName + "'";
            list = DataBaseManager.getListByQuery(query);
            id = Functions.getObjectIDByType(Literals.WORK_TYPE , list.get(0));
            subtitleDTO.setWorkIdWork(id);

            DataBaseManager.saveOrDeleteSingleObject(subtitleDTO.getSubtitle(),true);

        }
        catch (Exception e)
        {

        }
        finally {

        }
    }

    public static WorkDTO getWorkDTO ()
    {
        WorkDTO workDTO =  null;

        try {
            String resource = GuiFacade.getResourceText();
            if (resource != null && !resource.isEmpty()) {
                workDTO = new WorkDTO(resource);
                return workDTO;
            }
        }
        catch (Exception e)
        {
            //Handle Exception
        }

        return workDTO;
    }

    public static void downloadSubtitle(int fileChooserResult, Subtitle subtitle) {

        if (fileChooserResult == JFileChooser.APPROVE_OPTION)
        {
            String finalPath = GuiFacade.getFileChooser().getSelectedFile().getPath();
            FileCreator.downloadFileSubtitle(subtitle,finalPath);
        }

    }

    public static void uploadSubtitle() {

        try {
            int option = FactoryDialog.uploadSubtitleDialog();
            if (option == JOptionPane.YES_OPTION) {
                SubtitleDTO subtitleDTO = new SubtitleDTO();
                byte[] content = FileContent.getFileContent(GuiFacade.getUploadPath()).getBytes();
                subtitleDTO.setContent(content);
                subtitleDTO.setTitle(GuiFacade.getUploadNameJTF().getText());
                String query = QueryGenerator.GET_LANGUAGE_BY_NAME + "'" +
                                GuiFacade.getUploadLangJTF().getText() + "'";
                List list = DataBaseManager.getListByQuery(query);
                int id = Functions.getObjectIDByType(Literals.LANGUAGE_TYPE, list.get(0));
                subtitleDTO.setLanguageIdLanguage(id);

                query = QueryGenerator.GET_WORK_BY_NAME + "'" +
                        GuiFacade.getUploadWorkJTF().getText() + "'";

                list = DataBaseManager.getListByQuery(query);

                id = Functions.getObjectIDByType(Literals.WORK_TYPE,list.get(0));

                subtitleDTO.setWorkIdWork(id);

                DataBaseManager.saveOrDeleteSingleObject(subtitleDTO.getSubtitle(),true);
            }
        }
        catch (Exception e)
        {

        }


    }

    public static void getUploadPath(int fileChooserResult) {

        if (fileChooserResult == JFileChooser.APPROVE_OPTION)
        {
            String finalPath = GuiFacade.getFileChooser().getSelectedFile().getPath();
            GuiFacade.setUploadPath(finalPath);
        }

    }
}
