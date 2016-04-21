package controller.facade;

import gui.components.SubtitleListPanel;

import javax.swing.*;

public class GuiItems {

    private static JTextField resourceJTF;
    private static JTextField uploadNameJTF;
    private static JTextField uploadWorkJTF;
    private static JTextField uploadLangJTF;
    private static JTextArea resourceJTA;
    private static JFrame mainWindow;
    private static JLabel resourceLabel;
    private static SubtitleListPanel rightSubtitlePanel, leftSubtitlePanel;
    private static String uploadPath;
    private static JFileChooser fileChooser = new JFileChooser();


    public static void setUploadPath(String uploadPath) {
        GuiItems.uploadPath = uploadPath;
    }

    public static void setUploadLangJTF(JTextField jtf) {
        GuiItems.uploadLangJTF = jtf;
    }

    public static void setUploadWorkJTF(JTextField jtf) {

        GuiItems.uploadWorkJTF = jtf;

    }

    public static void setUploadNameJTF(JTextField jtf) {
        GuiItems.uploadNameJTF = jtf;
    }

    public static void setRightSubtitlePanel(SubtitleListPanel rightSubtitlePanel) {
        GuiItems.rightSubtitlePanel = rightSubtitlePanel;
    }

    public static void setLeftSubtitlePanel(SubtitleListPanel leftSubtitlePanel) {
        GuiItems.leftSubtitlePanel = leftSubtitlePanel;
    }

    public static void setResourceLabel(JLabel resourceLabel) {
        GuiItems.resourceLabel = resourceLabel;
    }

    public static void setMainWindow(JFrame mainWindow) {
        GuiItems.mainWindow = mainWindow;
    }

    public static void setResourceJTA(JTextArea resourceJTA) {
        GuiItems.resourceJTA = resourceJTA;
    }

    public static void setResourceText(JTextField text) {
        GuiItems.resourceJTF = text;
    }

    public static String getResourceText() {
        return GuiItems.resourceJTF.getText();
    }

    public static JTextField getUploadNameJTF() {
        return uploadNameJTF;
    }

    public static JTextField getUploadWorkJTF() {
        return uploadWorkJTF;
    }

    public static JTextField getUploadLangJTF() {
        return uploadLangJTF;
    }

    public static String getUploadPath() {
        return uploadPath;
    }

    public static JFileChooser getFileChooser() {
        return GuiItems.fileChooser;
    }


    public static JTextField getResourceJTF() {
        return resourceJTF;
    }

    public static JTextArea getResourceJTA() {
        return resourceJTA;
    }

    public static JFrame getMainWindow() {
        return mainWindow;
    }

    public static JLabel getResourceLabel() {
        return resourceLabel;
    }

    public static SubtitleListPanel getRightSubtitlePanel() {
        return rightSubtitlePanel;
    }

    public static SubtitleListPanel getLeftSubtitlePanel() {
        return leftSubtitlePanel;
    }
}
