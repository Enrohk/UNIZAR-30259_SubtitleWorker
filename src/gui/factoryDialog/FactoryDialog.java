package gui.factoryDialog;


import javax.swing.*;

public class FactoryDialog
{

    public static int closeGUIDialog ()
    {
        String tittle = "Seguro cerrar",
            question = "SEguro cerrar";
        //String must be getter from config file
        return JOptionPane.showConfirmDialog(null,
                question,
                tittle,
                JOptionPane.YES_NO_OPTION);

    }
}
