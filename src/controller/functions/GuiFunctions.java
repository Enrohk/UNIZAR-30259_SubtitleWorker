package controller.functions;


import controller.ddbb.QueryStrings;
import controller.ddbb.dto.SubtitleDTO;
import controller.ddbb.dto.WorkDTO;
import controller.facade.GuiItems;
import controller.facade.MainFacade;
import exceptions.DBException;
import exceptions.FunctionException;
import gui.MainWindow;
import gui.components.SubtitleCheckBox;
import gui.components.SubtitleListPanel;
import model.ddbb.entity.Subtitle;

import javax.swing.*;
import java.util.List;

public class GuiFunctions {

    private static int currentBotBtn = 1;

    public static void fillCenterPanelInfo() {
        WorkDTO workDTO = MainFacade.getWorkDTO();
        if (workDTO != null) {
            GuiItems.getResourceJTA().setText(new String(workDTO.getDescription()));
            GuiItems.getResourceLabel().setText(workDTO.getTitle());
            setSubtitles(workDTO.getSubtitleList());
            validateAndRepaint();
        }
    }

    public static void validateAndRepaint() {
        if (GuiItems.getMainWindow() != null) {
            GuiItems.getMainWindow().validate();
            GuiItems.getMainWindow().repaint();
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


    private static void setSubtitles(List<SubtitleDTO> subtitles) {
        GuiItems.getRightSubtitlePanel().clean();
        GuiItems.getLeftSubtitlePanel().clean();
        if(subtitles!=null && subtitles.size()>0)
        {
            for (SubtitleDTO s : subtitles) {
                GuiItems.getRightSubtitlePanel().addSubtitle(new SubtitleCheckBox(s));
                GuiItems.getLeftSubtitlePanel().addSubtitle(new SubtitleCheckBox(s));
            }
        }
        validateAndRepaint();
    }

    public static void setRightSubtitles () throws DBException, FunctionException {
        GuiItems.getRightSubtitlePanel().clean();
        int workId = MainFacade.getWorkDTO().getId();
        String lang = GuiItems.getLangRightSelected();

        List<SubtitleDTO> subtitles = SubtitleDTO.getSubtitlesFromQuery(QueryStrings.getSubtitleQuery(workId,lang));
        if(subtitles!=null && subtitles.size()>0)
        {
            for (SubtitleDTO s : subtitles) {
                GuiItems.getRightSubtitlePanel().addSubtitle(new SubtitleCheckBox(s));
            }
        }
        validateAndRepaint();
    }

    public static void setLeftSubtitles () throws DBException {
        GuiItems.getLeftSubtitlePanel().clean();
        int workId = MainFacade.getWorkDTO().getId();
        String lang = GuiItems.getLangLeftSelected();

        List<SubtitleDTO> subtitles = SubtitleDTO.getSubtitlesFromQuery(QueryStrings.getSubtitleQuery(workId,lang));
        if(subtitles!=null && subtitles.size()>0)
        {
            for (SubtitleDTO s : subtitles) {
                GuiItems.getLeftSubtitlePanel().addSubtitle(new SubtitleCheckBox(s));
            }
        }
        validateAndRepaint();
    }


    public static void swapMergeBackBtn() {
        currentBotBtn = (currentBotBtn +1) % 2;
        GuiItems.getMainBotPanel().removeAll();
        GuiItems.getMainBotPanel().add(GuiItems.getBotBtn(currentBotBtn));
        validateAndRepaint();
    }
}
