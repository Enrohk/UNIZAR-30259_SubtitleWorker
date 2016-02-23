package gui.factory;


import javax.swing.*;

public class FactoryLabels {

    //Add config shit to label,
    public static JLabel getLabel (String lbl)
    {
        return new JLabel(lbl);
    }
}
