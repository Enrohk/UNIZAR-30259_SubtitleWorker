package controller.facade;


import controller.ddbb.dto.WorkDTO;
import controller.security.PropertiesKeys;
import gui.components.SubtitleCheckBox;
import gui.components.SubtitleListPanel;
import model.ddbb.entity.Subtitle;

import java.util.List;
import javax.swing.*;

public class GuiFacade {


    public static void click(String propertyKey) {

        switch (propertyKey) {
            case PropertiesKeys.FILM_SEARCH_BUTTON:
                fillCenterPanelInfo();
                break;
            case PropertiesKeys.LANG_DOWNLOAD_RIGHT_BUTTON:
                Subtitle sR = GuiItems.getRightSubtitlePanel().getSelected();
                MainFacade.downloadSubtitle(showFileChooser(true), sR);
                break;

            case PropertiesKeys.LANG_DOWNLOAD_LEFT_BUTTON:
                Subtitle sL = GuiItems.getLeftSubtitlePanel().getSelected();
                MainFacade.downloadSubtitle(showFileChooser(true), sL);
                break;

            case PropertiesKeys.UPDATE_SUBTITLE_BUTTON:
                MainFacade.uploadSubtitle();
                break;

            case PropertiesKeys.UPLOAD_CHOOSE_BTN:
                MainFacade.getUploadPath(showFileChooser(false));
                break;

            case PropertiesKeys.MERGE_SUBTITLE_FILES_BTN:
                Subtitle subLeft = GuiItems.getLeftSubtitlePanel().getSelected();
                Subtitle subRight = GuiItems.getRightSubtitlePanel().getSelected();
                MainFacade.downloadMergedSubtitle(showFileChooser(true), subLeft, subRight);
                break;
        }
    }

    private static int showFileChooser(boolean download) {
        if (download)
            GuiItems.getFileChooser().setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        else
            GuiItems.getFileChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);
        return GuiItems.getFileChooser().showOpenDialog(null);

    }

    private static void fillCenterPanelInfo() {
        WorkDTO workDTO = MainFacade.getWorkDTO();
        if (workDTO != null) {
            GuiItems.getResourceJTA().setText(new String(workDTO.getDescription()));
            GuiItems.getResourceLabel().setText(workDTO.getTitle());
            setSubtitles(workDTO.getSubtitleList());
            validateAndRepaint();
        }
    }


    private static void setSubtitles(List<Subtitle> subtitles) {

        GuiItems.setRightSubtitlePanel(new SubtitleListPanel());
        GuiItems.setLeftSubtitlePanel(new SubtitleListPanel());

        for (Subtitle s : subtitles) {
            GuiItems.getRightSubtitlePanel().addSubtitle(new SubtitleCheckBox(s));
            GuiItems.getLeftSubtitlePanel().addSubtitle(new SubtitleCheckBox(s));
        }
        validateAndRepaint();
    }


    private static void validateAndRepaint() {
        if (GuiItems.getMainWindow() != null) {
            GuiItems.getMainWindow().validate();
            GuiItems.getMainWindow().repaint();
        }
    }


}
