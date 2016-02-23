package gui.factory;


import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;

import javax.swing.*;
import java.awt.*;

public class FactoryDialog
{

    //GET STRINGS FROM CONFIG
    //SET ITEMS TO GET DATTA SOMEWHERE

    public static int closeGUIDialog ()
    {
        String tittle = PropertiesHandler.getLanguageValue(PropertiesKeys.CONFIRM_CLOSE_TITLE),
            question = PropertiesHandler.getLanguageValue(PropertiesKeys.CONFIRM_CLOSE);

        return JOptionPane.showConfirmDialog(null,
                question,
                tittle,
                JOptionPane.YES_NO_OPTION);

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
