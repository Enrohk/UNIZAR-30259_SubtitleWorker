package controller.functions;


import controller.ddbb.dto.WorkDTO;
import controller.facade.GuiItems;
import controller.facade.MainFacade;
import exceptions.DBException;
import gui.MainWindow;
import gui.components.SubtitleCheckBox;
import gui.components.SubtitleListPanel;
import model.ddbb.entity.Subtitle;

import javax.swing.*;
import java.util.List;

public class GuiFunctions {

    public static void fillCenterPanelInfo() {
        WorkDTO workDTO = MainFacade.getWorkDTO();
        if (workDTO != null) {
            GuiItems.getResourceJTA().setText(new String(workDTO.getDescription()));
            GuiItems.getResourceLabel().setText(workDTO.getTitle());
            setSubtitles(workDTO.getSubtitleList());
            validateAndRepaint();
        }
    }

    public static void showGUI ()
    {
        JFrame mainWindows = null;
        try {
            mainWindows = new MainWindow();
        } catch (DBException e) {
            e.printStackTrace();
        }
        GuiItems.setMainWindow(mainWindows);
    }



    public static int showFileChooser(boolean download) {
        if (download)
            GuiItems.getFileChooser().setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        else
            GuiItems.getFileChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);
        return GuiItems.getFileChooser().showOpenDialog(null);

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
