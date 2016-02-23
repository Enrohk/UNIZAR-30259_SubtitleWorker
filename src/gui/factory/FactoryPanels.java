package gui.factory;


import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;

import javax.swing.*;
import java.awt.*;

public class FactoryPanels {

    public static JPanel getLogInDialogPanel ()
    {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        JPanel userFieldPanel = new JPanel();
        String user = PropertiesHandler.getLanguageValue(PropertiesKeys.LOG_IN_USERNAME);
        userFieldPanel.add(FactoryLabels.getLabel(user));
        JTextField userName = new JTextField();
        userName.setColumns(10);
        userFieldPanel.add(userName);

        JPanel passFieldPanel = new JPanel();
        String pass = PropertiesHandler.getLanguageValue(PropertiesKeys.LOG_IN_PASSWORD);
        passFieldPanel.add(FactoryLabels.getLabel(pass));
        JPasswordField password = new JPasswordField();
        password.setColumns(10);
        passFieldPanel.add(password);

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel,BoxLayout.Y_AXIS));
        fieldsPanel.add(userFieldPanel);
        fieldsPanel.add(passFieldPanel);

        String keep = PropertiesHandler.getLanguageValue(PropertiesKeys.LOG_IN_KEEP);
        JCheckBox keepLogged = new JCheckBox(keep);
        JPanel southPanel = new JPanel();
        southPanel.add(keepLogged);

        centerPanel.add(southPanel, BorderLayout.SOUTH);
        centerPanel.add(fieldsPanel,BorderLayout.CENTER);

        return centerPanel;
    }
}
