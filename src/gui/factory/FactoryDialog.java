package gui.factory;

import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import exceptions.DBException;

import javax.swing.*;

public class FactoryDialog {

    public static int closeGUIDialog() {
        String tittle = PropertiesHandler.getLanguageValue(PropertiesKeys.CONFIRM_CLOSE_TITLE),
                question = PropertiesHandler.getLanguageValue(PropertiesKeys.CONFIRM_CLOSE);

        String yesOption = PropertiesHandler.getLanguageValue(PropertiesKeys.YES_OPTION),
                noOption = PropertiesHandler.getLanguageValue(PropertiesKeys.NO_OPTION);
        String[] options = {yesOption, noOption};

        return JOptionPane.showOptionDialog(null,
                question,
                tittle,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon(PropertiesKeys.ICON_LOGIN_PATH),
                options, options[0]);

    }

    public static int uploadSubtitleDialog() throws DBException {
        String tittle = PropertiesHandler.getLanguageValue(PropertiesKeys.UPLOAD_TITTLE);


        String yesOption = PropertiesHandler.getLanguageValue(PropertiesKeys.YES_OPTION),
                noOption = PropertiesHandler.getLanguageValue(PropertiesKeys.NO_OPTION);
        String[] options = {yesOption, noOption};

        return JOptionPane.showOptionDialog(null,
                FactoryPanels.getUploadSubtitlePanel(),
                tittle,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon(PropertiesKeys.ICON_LOGIN_PATH),
                options, options[0]);

    }

    /**
     * @return 0 if logIn button clicked
     * 1 if register button clicked
     */
    public static int loginGUIDialog() {

        String logInBtn = PropertiesHandler.getLanguageValue(PropertiesKeys.LOGIN_BTN),
                registerBtn = PropertiesHandler.getLanguageValue(PropertiesKeys.REGISTER_BTN);
        String[] options = {logInBtn, registerBtn};


        return JOptionPane.showOptionDialog(null,
                FactoryPanels.getLogInDialogPanel(),
                PropertiesHandler.getLanguageValue(PropertiesKeys.LOGIN_TITLE),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon(PropertiesKeys.ICON_LOGIN_PATH),
                options, options[0]);
    }

    /**
     * @return 0 if register button clicked
     * 1 if cancel button clicked
     */
    public static int registerGUIDialog() {

        String registerBtn = PropertiesHandler.getLanguageValue(PropertiesKeys.REGISTER_BTN),
                cancelBtn = PropertiesHandler.getLanguageValue(PropertiesKeys.CANCEL_BTN);
        String[] options = {registerBtn, cancelBtn};


        return JOptionPane.showOptionDialog(null,
                FactoryPanels.getRegisterDialogPanel(),
                PropertiesHandler.getLanguageValue(PropertiesKeys.REGISTER_TITLE),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon(PropertiesKeys.ICON_LOGIN_PATH),
                options, options[0]);
    }


    public static void invalidLogin ()
    {
        String title = PropertiesHandler.getLanguageValue(PropertiesKeys.LOG_ERROR_TITLE);
        String msg = PropertiesHandler.getLanguageValue(PropertiesKeys.LOG_ERROR_MSG);
        JOptionPane.showMessageDialog(null, msg,title,JOptionPane.WARNING_MESSAGE);
    }

    public static void passErrorRegister ()
    {
        String title = PropertiesHandler.getLanguageValue(PropertiesKeys.REG_PASS_ERROR_TITLE);
        String msg = PropertiesHandler.getLanguageValue(PropertiesKeys.REG_PASS_ERROR_MSG);
        JOptionPane.showMessageDialog(null, msg,title,JOptionPane.WARNING_MESSAGE);
    }

    public static void mailErrorRegister ()
    {
        String title = PropertiesHandler.getLanguageValue(PropertiesKeys.REG_MAIL_ERROR_TITLE);
        String msg = PropertiesHandler.getLanguageValue(PropertiesKeys.REG_MAIL_ERROR_MSG);
        JOptionPane.showMessageDialog(null, msg,title,JOptionPane.WARNING_MESSAGE);
    }

    public static void nameErrorRegister() {
    }

    public static int editUserDialog() throws DBException {

        String editBtn = PropertiesHandler.getLanguageValue(PropertiesKeys.EDIT_BTN),
                cancelBtn = PropertiesHandler.getLanguageValue(PropertiesKeys.CANCEL_BTN),
                deleteBtn = PropertiesHandler.getLanguageValue(PropertiesKeys.DELETE_BTN);
        String[] options = {editBtn, cancelBtn};

        return JOptionPane.showOptionDialog(null,
                FactoryPanels.getUpdateDialogPanel(),
                PropertiesHandler.getLanguageValue(PropertiesKeys.UPDATE_TITLE),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon(PropertiesKeys.ICON_LOGIN_PATH),
                options, options[0]);
    }
}
