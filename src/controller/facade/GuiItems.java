package controller.facade;

import controller.security.PropertiesKeys;
import gui.components.LangButton;
import gui.components.SubtitleListPanel;

import javax.swing.*;

public class GuiItems {

    private static JTextField   resourceJTF,
                                uploadNameJTF,
                                uploadWorkJTF,
                                uploadLangJTF,
                                logInNameJTF,
                                logInPassJTF,
                                registerEmailJTF,
                                registerPassJTF;
    private static JCheckBox keepLogged;
    private static JTextArea resourceJTA;
    private static JFrame mainWindow;
    private static JLabel resourceLabel;
    private static SubtitleListPanel rightSubtitlePanel, leftSubtitlePanel;
    private static String uploadPath;
    private static JFileChooser fileChooser = new JFileChooser();
    private static JPanel centerMainPanel, centerSubtitlePanel, centerPanel, botPanel;

    private static LangButton[] botBtns = { new LangButton(PropertiesKeys.MERGE_SUBTITLE_FILES_BTN), new LangButton(PropertiesKeys.BACK_TO_MAIN_BTN)};

   public static LangButton getBotBtn (int pos)
   {
       return botBtns[pos];
   }

    public static JTextField getLogInNameJTF() {
        return logInNameJTF;
    }

    public static void setMainBotPanel (JPanel botPanel)
    {
        GuiItems.botPanel = botPanel;
    }

    public static void setCenterPanel(JPanel centerPanel) {
        GuiItems.centerPanel = centerPanel;
    }

    public static void setLogInNameJTF(JTextField logInNameJTF) {
        GuiItems.logInNameJTF = logInNameJTF;
    }

    public static JTextField getLogInPassJTF() {
        return logInPassJTF;
    }

    public static void setLogInPassJTF(JTextField logInPassJTF) {
        GuiItems.logInPassJTF = logInPassJTF;
    }

    public static JTextField getRegisterEmailJTF() {
        return registerEmailJTF;
    }

    public static void setRegisterEmailJTF(JTextField registerEmailJTF) {
        GuiItems.registerEmailJTF = registerEmailJTF;
    }

    public static JTextField getRegisterPassJTF() {
        return registerPassJTF;
    }

    public static void setRegisterPassJTF(JTextField registerPassJTF) {
        GuiItems.registerPassJTF = registerPassJTF;
    }

    public static boolean isKeepLogged() {
        if (keepLogged!=null) return keepLogged.isSelected();
        else return false;
    }

    public static void setKeepLogged(JCheckBox keepLogged) {
        GuiItems.keepLogged = keepLogged;
    }

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

    public static void setCenterMainPanel(JPanel centerPanel) {
        GuiItems.centerMainPanel = centerPanel;
    }

    public static void setCenterSubtitlePanel(JPanel subtitlePanel) {
        GuiItems.centerSubtitlePanel = subtitlePanel;
    }

    public static JPanel getCenterSubtitlePanel () {
        return GuiItems.centerSubtitlePanel;
    }

    public static JPanel getCenterMainPanel() {
        return GuiItems.centerMainPanel;
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

    public static JPanel getCenterPanel ()
    {
        return centerPanel;
    }

    public static JPanel getMainBotPanel() {
        return botPanel;
    }
}
