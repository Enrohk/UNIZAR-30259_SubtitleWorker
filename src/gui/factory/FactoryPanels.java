package gui.factory;


import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import gui.components.LangButton;
import gui.components.LangLabel;

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

    public static JPanel getRegisterPanel ()
    {
        return null;
    }

    public static JPanel getMainTopPanel ()
    {
        JPanel genericTop = new JPanel();
     //   genericTop.setLayout(new GridLayout(0,3));
        genericTop.setLayout(new BorderLayout());
        genericTop.add(getGenericTopLeft(),BorderLayout.WEST);
        genericTop.add(getGenericTopCenter(), BorderLayout.CENTER);
        genericTop.add(getGenericTopRight(), BorderLayout.EAST);
        return genericTop;
    }

    private static JPanel getGenericTopRight() {

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(0,2));
        rightPanel.add(getLogOutPanel());
        rightPanel.add(getChangeLanguagePanel());
        return rightPanel;

    }

    private static JPanel getLogOutPanel() {
        JPanel logOutPanel = new JPanel();
        logOutPanel.setLayout(new BorderLayout());
        logOutPanel.add(new LangButton(PropertiesKeys.LOG_OUT_BUTTON));
        logOutPanel.add(getLoggedAsPanel(),BorderLayout.SOUTH);
        return logOutPanel;
    }

    private static JPanel getLoggedAsPanel() {
        JPanel loggedAsPanel = new JPanel();
        loggedAsPanel.setLayout(new FlowLayout());
        loggedAsPanel.add(new LangLabel(PropertiesKeys.LOGGED_AS_LBL));
        loggedAsPanel.add(new JLabel(PropertiesHandler.
                                    getConfigValue(PropertiesKeys.LOGGED_USERNAME)));
        return loggedAsPanel;
    }

    private static JPanel getChangeLanguagePanel ()
    {
        JPanel changeLangPanel = new JPanel();

        JLabel l1 = new JLabel("ES");
        JLabel l2 = new JLabel("EN");
        changeLangPanel.add(l1);
        changeLangPanel.add(l2);

        return changeLangPanel;
    }


    private static JPanel getGenericTopCenter () {
        JPanel centerPanel = new JPanel();;
        JPanel searchBtnPanel = new JPanel();
        searchBtnPanel.add(new LangButton(PropertiesKeys.FILM_SEARCH_BUTTON));
        centerPanel.add(getTextArea());
        centerPanel.add(searchBtnPanel);
        return centerPanel;
    }

    private static JPanel getTextArea() {
        JPanel textAreaPanel = new JPanel();
        JTextField searchTxtField = new JTextField(25);
        textAreaPanel.add(searchTxtField);
        return textAreaPanel;
    }

    private static JPanel getGenericTopLeft () {
        JPanel leftPanel = new JPanel();
        LangButton langBtn = new LangButton(PropertiesKeys.UPDATE_SUBTITLE_BUTTON);
        leftPanel.add(langBtn);
        return leftPanel;
    }


}
