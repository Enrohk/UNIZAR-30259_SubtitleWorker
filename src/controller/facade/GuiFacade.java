package controller.facade;


import controller.ddbb.DataBaseManager;
import controller.ddbb.dto.CommentDTO;
import controller.ddbb.dto.SubtitleDTO;
import controller.functions.GuiFunctions;
import controller.functions.LogFunctions;
import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import exceptions.DBException;
import exceptions.FunctionException;
import gui.components.SubtitleCenterPanel;
import gui.factory.FactoryDialog;
import main.Main;
import model.ddbb.entity.Subtitle;

public class GuiFacade {


    public static void click(String propertyKey) throws DBException, FunctionException {

        switch (propertyKey) {
            case PropertiesKeys.FILM_SEARCH_BUTTON:
                GuiFunctions.fillCenterPanelInfo();
                break;
            case PropertiesKeys.LANG_DOWNLOAD_RIGHT_BUTTON:
                SubtitleDTO sR = GuiItems.getRightSubtitlePanel().getSelected();
                MainFacade.downloadSubtitle(GuiFunctions.showFileChooser(true), sR);
                break;

            case PropertiesKeys.LANG_DOWNLOAD_LEFT_BUTTON:
                SubtitleDTO sL = GuiItems.getLeftSubtitlePanel().getSelected();
                MainFacade.downloadSubtitle(GuiFunctions.showFileChooser(true), sL);
                break;

            case PropertiesKeys.UPDATE_SUBTITLE_BUTTON:
                MainFacade.uploadSubtitle();
                break;

            case PropertiesKeys.UPLOAD_CHOOSE_BTN:
                MainFacade.getUploadPath(GuiFunctions.showFileChooser(false));
                break;

            case PropertiesKeys.MERGE_SUBTITLE_FILES_BTN:
                SubtitleDTO subLeft = GuiItems.getLeftSubtitlePanel().getSelected();
                SubtitleDTO subRight = GuiItems.getRightSubtitlePanel().getSelected();
                MainFacade.downloadMergedSubtitle(GuiFunctions.showFileChooser(true), subLeft, subRight);
                break;

            case PropertiesKeys.BACK_TO_MAIN_BTN:
                showCenterMain();
                break;
            case PropertiesKeys.SPANISH_LANG :
                MainFacade.changeLanguage(PropertiesKeys.SPANISH_LANG);
                break;

            case PropertiesKeys.ENGLISH_LANG:
                MainFacade.changeLanguage(PropertiesKeys.ENGLISH_LANG);
                break;
            case PropertiesKeys.LOG_OUT_BUTTON:
                MainFacade.logOut();
                break;
            case PropertiesKeys.LANG_SEARCH_RIGHT_BUTTON :
                GuiFunctions.setRightSubtitles();
                break;

            case PropertiesKeys.LANG_SEARCH_LEFT_BUTTON :
                GuiFunctions.setLeftSubtitles();
                break;

            case PropertiesKeys.RATE_BTN :
                CommentDTO comment = GuiFunctions.getComment();
                DataBaseManager.saveOrDeleteSingleObject(comment.getUserCommentSubtitle(),true);
                ((SubtitleCenterPanel)GuiItems.getCenterSubtitlePanel()).updateComments();
                break;

            case PropertiesKeys.EDIT_USER_BTN :
                GuiFunctions.showEditPanel();
                break;


        }
    }

    public static void start() throws DBException {
        boolean logged = false;
        while (!logged) {
            int logInClickResult = FactoryDialog.loginGUIDialog();
            if (logInClickResult == 0)
            {
                 logged = LogFunctions.logIn();

            }
            else if (logInClickResult == 1)
                logged = LogFunctions.registerPanel();
            else
                System.exit(0);
        }

    }

    public static void showSubtitlePanel (SubtitleDTO subtitle) throws DBException {
        GuiItems.getCenterPanel().removeAll();
        GuiItems.getCenterPanel().add(GuiItems.getCenterSubtitlePanel());
        ((SubtitleCenterPanel)GuiItems.getCenterSubtitlePanel()).fillInfo(subtitle);
        GuiFunctions.swapMergeBackBtn();
        GuiFunctions.validateAndRepaint();
    }


    public static void showCenterMain() {
        GuiItems.getCenterPanel().removeAll();
        GuiItems.getCenterPanel().add(GuiItems.getCenterMainPanel());
        GuiFunctions.swapMergeBackBtn();
        GuiFunctions.validateAndRepaint();
    }

}
