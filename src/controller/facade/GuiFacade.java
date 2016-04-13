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
    private static JTextArea resourceJTA;
    private static JFrame mainWindow;
    private static JLabel resourceLabel;
    private static SubtitleListPanel rightSubtitlePanel, leftSubtitlePanel;

    public static JFileChooser getFileChooser() {
        return GuiFacade.fileChooser;
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

    public static void setResourceText (JTextField text)
    {
        GuiFacade.resourceJTF = text;
    }

    public static String getResourceText ()
    {
        return GuiFacade.resourceJTF.getText();
    }


    public static void click(String propertyKey) {

        switch (propertyKey) {
            case PropertiesKeys.FILM_SEARCH_BUTTON:
                fillCenterPanelInfo();
                break;
            case PropertiesKeys.LANG_DOWNLOAD_RIGHT_BUTTON:
                Subtitle sR = rightSubtitlePanel.getSelected();
                MainFacade.downloadSubtitle(showFileChooser(),sR);
                break;

            case PropertiesKeys.LANG_DOWNLOAD_LEFT_BUTTON:
                Subtitle sL = leftSubtitlePanel.getSelected();
                MainFacade.downloadSubtitle(showFileChooser(),sL);
                break;
        }
    }

    private static  int showFileChooser ()
    {
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        return fileChooser.showOpenDialog(null);

    }

    private static void fillCenterPanelInfo ()
    {
        WorkDTO workDTO = MainFacade.getWorkDTO();
        if(workDTO!=null)
        {
            GuiFacade.resourceJTA.setText(new String(workDTO.getDescription()));
            GuiFacade.resourceLabel.setText(workDTO.getTitle());
            setSubtitles(workDTO.getSubtitleList());
            validateAndRepaint();
        }
    }

    private static void setSubtitles(List<Subtitle> subtitles)
    {
        for (Subtitle s : subtitles){
            rightSubtitlePanel.addSubtitle(new SubtitleCheckBox(s));
            leftSubtitlePanel.addSubtitle(new SubtitleCheckBox(s));
        }
        validateAndRepaint();
    }

    private static void validateAndRepaint()
    {
        if (GuiFacade.mainWindow!=null)
        {
            GuiFacade.mainWindow.validate();
            GuiFacade. mainWindow.repaint();
        }
    }


}
