package gui.factory;

import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import javax.swing.*;

public class FactoryDialog
{

    public static int closeGUIDialog ()
    {
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

    /**
     * @return 0 if logIn button clicked
     *         1 if register button clicked
     */
    public static int loginGUIDialog ()
    {
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



}
