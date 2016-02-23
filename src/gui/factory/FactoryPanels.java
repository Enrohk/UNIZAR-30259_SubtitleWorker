package gui.factory;


import javax.swing.*;
import java.awt.*;

public class FactoryPanels {

    public static JPanel getLogInDialogPanel ()
    {
        //Get string from properties
        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new BorderLayout());

        JPanel userFieldPanel = new JPanel();
        userFieldPanel.add(FactoryLabels.getLabel("Username"));
        JTextField userName = new JTextField();
        userName.setColumns(10);
        userFieldPanel.add(userName);

        JPanel passFieldPanel = new JPanel();
        passFieldPanel.add(FactoryLabels.getLabel("Password"));
        JPasswordField password = new JPasswordField();
        password.setColumns(10);
        passFieldPanel.add(password);

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel,BoxLayout.Y_AXIS));
        fieldsPanel.add(userFieldPanel);
        fieldsPanel.add(passFieldPanel);

        JCheckBox keepLogged = new JCheckBox("keep logged");
        JPanel southPanel = new JPanel();
        southPanel.add(keepLogged);

        centerPanel.add(southPanel, BorderLayout.SOUTH);
        centerPanel.add(fieldsPanel,BorderLayout.CENTER);

        return centerPanel;
    }
}
