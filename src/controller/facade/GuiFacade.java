package controller.facade;


import controller.ddbb.dto.WorkDTO;
import controller.security.PropertiesKeys;
import gui.components.SubtitleCheckBox;
import gui.components.SubtitleListPanel;
import model.ddbb.entity.Subtitle;

import java.util.List;
import javax.swing.*;

public class GuiFacade {

    private static JTextField resourceJTF;
    private static JTextField uploadNameJTF;

    public static JTextField getUploadNameJTF() {
        return uploadNameJTF;
    }

    public static JTextField getUploadWorkJTF() {
        return uploadWorkJTF;
    }

    public static JTextField getUploadLangJTF() {
        return uploadLangJTF;
    }

    private static JTextField uploadWorkJTF;
    private static JTextField uploadLangJTF;
    private static JTextArea resourceJTA;
    private static JFrame mainWindow;
    private static JLabel resourceLabel;
    private static SubtitleListPanel rightSubtitlePanel, leftSubtitlePanel;

    public static String getUploadPath() {
        return uploadPath;
    }

    public static void setUploadPath(String uploadPath) {
        GuiFacade.uploadPath = uploadPath;
    }

    private static String uploadPath;

    public static void setUploadLangJTF(JTextField jtf) {
        GuiFacade.uploadLangJTF = jtf;
    }

    public static void setUploadWorkJTF(JTextField jtf) {

        GuiFacade.uploadWorkJTF = jtf;

    }

    public static JFileChooser getFileChooser() {
        return GuiFacade.fileChooser;
    }

    public static void setUploadNameJTF(JTextField jtf) {
        GuiFacade.uploadNameJTF = jtf;
    }

    private static JFileChooser fileChooser = new JFileChooser();

    public static void setRightSubtitlePanel(SubtitleListPanel rightSubtitlePanel) {
        GuiFacade.rightSubtitlePanel = rightSubtitlePanel;
    }

    public static void setLeftSubtitlePanel(SubtitleListPanel leftSubtitlePanel) {
        GuiFacade.leftSubtitlePanel = leftSubtitlePanel;
    }

    public static void setResourceLabel(JLabel resourceLabel) {
        GuiFacade.resourceLabel = resourceLabel;
    }

    public static void setMainWindow(JFrame mainWindow) {
        GuiFacade.mainWindow = mainWindow;
    }

    public static void setResourceJTA(JTextArea resourceJTA) {
        GuiFacade.resourceJTA = resourceJTA;
    }

    public static void setResourceText(JTextField text) {
        GuiFacade.resourceJTF = text;
    }

    public static String getResourceText() {
        return GuiFacade.resourceJTF.getText();
    }


    public static void click(String propertyKey) {

        switch (propertyKey) {
            case PropertiesKeys.FILM_SEARCH_BUTTON:
                fillCenterPanelInfo();
                break;
            case PropertiesKeys.LANG_DOWNLOAD_RIGHT_BUTTON:
                Subtitle sR = rightSubtitlePanel.getSelected();
                MainFacade.downloadSubtitle(showFileChooser(true), sR);
                break;

            case PropertiesKeys.LANG_DOWNLOAD_LEFT_BUTTON:
                Subtitle sL = leftSubtitlePanel.getSelected();
                MainFacade.downloadSubtitle(showFileChooser(true), sL);
                break;

            case PropertiesKeys.UPDATE_SUBTITLE_BUTTON:
                MainFacade.uploadSubtitle();
                break;

            case PropertiesKeys.UPLOAD_CHOOSE_BTN:
                MainFacade.getUploadPath(showFileChooser(false));
                break;

            case PropertiesKeys.MERGE_SUBTITLE_FILES_BTN:
                Subtitle subLeft = leftSubtitlePanel.getSelected();
                Subtitle subRight = rightSubtitlePanel.getSelected();
                MainFacade.downloadMergedSubtitle(showFileChooser(true), subLeft, subRight);
                break;
        }
    }

    private static int showFileChooser(boolean download) {
        if (download)
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        else
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        return fileChooser.showOpenDialog(null);

    }

    private static void fillCenterPanelInfo() {
        WorkDTO workDTO = MainFacade.getWorkDTO();
        if (workDTO != null) {
            GuiFacade.resourceJTA.setText(new String(workDTO.getDescription()));
            GuiFacade.resourceLabel.setText(workDTO.getTitle());
            setSubtitles(workDTO.getSubtitleList());
            validateAndRepaint();
        }
    }

    private static void setSubtitles(List<Subtitle> subtitles) {
        for (Subtitle s : subtitles) {
            rightSubtitlePanel.addSubtitle(new SubtitleCheckBox(s));
            leftSubtitlePanel.addSubtitle(new SubtitleCheckBox(s));
        }
        validateAndRepaint();
    }

    private static void validateAndRepaint() {
        if (GuiFacade.mainWindow != null) {
            GuiFacade.mainWindow.validate();
            GuiFacade.mainWindow.repaint();
        }
    }


}
