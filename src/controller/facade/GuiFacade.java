package controller.facade;


import controller.ddbb.dto.SubtitleDTO;
import controller.functions.GuiFunctions;
import controller.functions.LogFunctions;
import controller.security.PropertiesKeys;
import gui.components.SubtitleCenterPanel;
import gui.factory.FactoryDialog;
import model.ddbb.entity.Subtitle;

public class GuiFacade {


    public static void click(String propertyKey) {

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

        }
    }

    public static void start() {
        int logInClickResult = FactoryDialog.loginGUIDialog();
        if (logInClickResult == 0)
            LogFunctions.logIn();
        else if (logInClickResult == 1)
            LogFunctions.registerPanel();
        else
            System.exit(0);

        GuiFunctions.showGUI();
    }

    public static void showSubtitlePanel (SubtitleDTO subtitle)
    {
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
