package controller.facade;


import controller.ddbb.DataBaseManager;
import controller.ddbb.QueryStrings;
import controller.ddbb.dto.SubtitleDTO;
import controller.ddbb.dto.UserDTO;
import controller.ddbb.dto.WorkDTO;
import controller.functions.*;
import controller.languageHandler.CanChangeLanguage;
import controller.languageHandler.ChangeLanguageObserver;
import controller.security.PropertiesHandler;
import exceptions.DBException;
import exceptions.SomethingWrongHappenException;
import gui.factory.FactoryDialog;
import model.ddbb.entity.Subtitle;
import model.ddbb.entity.User;

import java.util.*;

import javax.swing.*;

public class MainFacade {

    private static UserDTO loggedUser = null;

    public static UserDTO getLoggedUser() {
        return loggedUser;
    }


    public static void closeProgram(int closeOption) throws SomethingWrongHappenException {
        switch (closeOption) {
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

    public static void changeLanguage(String lang) {
        PropertiesHandler.loadLanguageProperties(lang);
        ChangeLanguageObserver.changeLanguage();
    }

    public static void addLanguageListener(CanChangeLanguage listener) {
        ChangeLanguageObserver.addNewListener(listener);
    }

    public static void clearLanaguageListener() {
        ChangeLanguageObserver.clearAll();
    }

    public static void removeLanguageListener(CanChangeLanguage listener) {
        ChangeLanguageObserver.removeListener(listener);
    }


    public static WorkDTO getWorkDTO() {
        WorkDTO workDTO = null;

        try {
            String resource = GuiItems.getResourceText();
            if (resource != null && !resource.isEmpty()) {
                workDTO = new WorkDTO(resource);
                return workDTO;
            }
        } catch (Exception e) {
            //Handle Exception
        }

        return workDTO;
    }

    public static void downloadSubtitle(int fileChooserResult, SubtitleDTO subtitle) {

        if (fileChooserResult == JFileChooser.APPROVE_OPTION) {
            String finalPath = GuiItems.getFileChooser().getSelectedFile().getPath();
            FileCreator.downloadFileSubtitle(subtitle, finalPath);
        }

    }

    public static void uploadSubtitle() {


        try {
            int option = FactoryDialog.uploadSubtitleDialog();
            if (option == JOptionPane.YES_OPTION) {
                SubtitleDTO subtitleDTO = new SubtitleDTO();
                byte[] content = FileContent.getFileContent(GuiItems.getUploadPath()).getBytes();
                subtitleDTO.setContent(content);
                subtitleDTO.setTitle(GuiItems.getUploadNameJTF().getText());
                String query = QueryStrings.GET_LANGUAGE_BY_NAME + "'" +
                        GuiItems.getUploadLangJTF().getText() + "'";
                List list = DataBaseManager.getListByQuery(query);
                int id = Functions.getObjectIDByType(Literals.LANGUAGE_TYPE, list.get(0));
                subtitleDTO.setLanguageIdLanguage(id);

                query = QueryStrings.GET_WORK_BY_NAME + "'" +
                        GuiItems.getUploadWorkJTF().getText() + "'";

                list = DataBaseManager.getListByQuery(query);

                id = Functions.getObjectIDByType(Literals.WORK_TYPE, list.get(0));

                subtitleDTO.setWorkIdWork(id);

                DataBaseManager.saveOrDeleteSingleObject(subtitleDTO.getSubtitle(), true);
            }
        } catch (Exception e) {

        }


    }

    public static void getUploadPath(int fileChooserResult) {

        if (fileChooserResult == JFileChooser.APPROVE_OPTION) {
            String finalPath = GuiItems.getFileChooser().getSelectedFile().getPath();
            GuiItems.setUploadPath(finalPath);
        }

    }

    public static void downloadMergedSubtitle(int fileChooserResult, SubtitleDTO sL, SubtitleDTO sR) {

        if (fileChooserResult == JFileChooser.APPROVE_OPTION) {
            SubtitleDTO merged = new SubtitleDTO();
            merged.setLanguageIdLanguage(sR.getLanguageIdLanguage());
            merged.setWorkIdWork(sR.getWorkIdWork());
            merged.setTitle(GuiItems.getFileChooser().getSelectedFile().getName());
            Map<String, List<String>> strParseR, strParseL;
            strParseL = StrCreator.parseStr(new String(sR.getContent()), Literals.FROM_STRING);
            strParseR = StrCreator.parseStr(new String(sL.getContent()), Literals.FROM_STRING);

            merged.setContentFromStr(StrCreator.mergeStr(strParseL, strParseR));
            String finalPath = GuiItems.getFileChooser().getSelectedFile().getPath();

            FileCreator.downloadFileSubtitle(merged, finalPath);

        }

    }

    public static void logged(UserDTO userDto, boolean keepLogged) {
        MainFacade.loggedUser = userDto;
        System.out.print("yes");
    }

}
