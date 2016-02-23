package gui.factory;


import javax.swing.*;
import java.awt.*;

public class FactoryDialog
{

    //GET STRINGS FROM CONFIG
    //SET ITEMS TO GET DATTA SOMEWHERE

    public static int closeGUIDialog ()
    {
        String tittle = "Seguro cerrar",
            question = "SEguro cerrar";

        return JOptionPane.showConfirmDialog(null,
                question,
                tittle,
                JOptionPane.YES_NO_OPTION);

    }

    public static int loginGUIDialog ()
    {
        //0 login, 1 register, change icon (null)
        String[] options = {"LogIN", "Register"};
        return JOptionPane.showOptionDialog(null,
                FactoryPanels.getLogInDialogPanel(),
                "Title",JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,null,
                options, options[0]);

    }

}
