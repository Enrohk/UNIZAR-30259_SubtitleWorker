package gui.factory;


import controller.facade.GuiFacade;
import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import gui.components.ItemListPanel;
import gui.components.LangButton;
import gui.components.LangLabel;
import gui.components.SubtitleListPanel;

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
        genericTop.setLayout(new BorderLayout());
        genericTop.add(getGenericTopLeft(),BorderLayout.WEST);
        genericTop.add(getGenericTopCenter(), BorderLayout.CENTER);
        genericTop.add(getGenericTopRight(), BorderLayout.EAST);
        return genericTop;
    }

    public static JPanel getMainCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(getCenterTopPanel(),BorderLayout.NORTH);
        centerPanel.add(getCenterCenterPanel(), BorderLayout.CENTER);

        return centerPanel;
    }

    public static JPanel getMainBotPanel() {
        JPanel botPanel = new JPanel();
        botPanel.add(new LangButton(PropertiesKeys.JOIN_SUBTITLE_FILES_BTN));
        return botPanel;
    }

    public static JPanel getTopSearchPanel ()
    {
        JPanel topSearchPanel = new JPanel();
        String[] s = {"Spanish","Eglish"};
        SpinnerModel list = new SpinnerListModel(s);
        JSpinner langSpinner = new JSpinner(list);
        topSearchPanel.add(langSpinner);
        return topSearchPanel;
    }

    private static JPanel getCenterCenterPanel() {
        JPanel centerCenter = new JPanel();
        centerCenter.setLayout(new GridLayout(0,2));

        JPanel centerRight = new JPanel();
        centerRight.setLayout(new BorderLayout());
        JPanel centerLeft = new JPanel();
        centerLeft.setLayout(new BorderLayout());


        centerLeft.add(getSubtitleSearcherPanel(PropertiesKeys.LANG_SEARCH_LEFT_BUTTON,
                                                    PropertiesKeys.LANG_DOWNLOAD_LEFT_BUTTON),
                                                    BorderLayout.NORTH);
        centerRight.add(getSubtitleSearcherPanel(PropertiesKeys.LANG_SEARCH_RIGHT_BUTTON,
                                                    PropertiesKeys.LANG_DOWNLOAD_RIGHT_BUTTON),
                                                    BorderLayout.NORTH);

        SubtitleListPanel rightSubtitle = new SubtitleListPanel();
        SubtitleListPanel leftSubtitle = new SubtitleListPanel();

        centerLeft.add(leftSubtitle,BorderLayout.CENTER);
        centerRight.add(rightSubtitle,BorderLayout.CENTER);

        GuiFacade.setLeftSubtitlePanel(leftSubtitle);
        GuiFacade.setRightSubtitlePanel(rightSubtitle);

        centerCenter.add(centerLeft);
        centerCenter.add(centerRight);

        return centerCenter;
    }


    private static JPanel getSubtitleSearcherPanel(String searchButton, String downloadButton ) {
        JPanel subtitleSearcher = new JPanel();
            subtitleSearcher.add(new ItemListPanel(searchButton, downloadButton));
        return subtitleSearcher;
    }

    private static JPanel getCenterTopPanel() {
        JPanel centerTop = new JPanel();
        centerTop.setLayout(new BorderLayout());
        JLabel titleLbl = new JLabel();
        GuiFacade.setResourceLabel(titleLbl);
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLbl);
        JPanel jtaPanel = new JPanel();
        JTextArea area = new JTextArea(10,50);
        area.setLineWrap(true);
        jtaPanel.add(area);
        GuiFacade.setResourceJTA(area);
        centerTop.add(jtaPanel, BorderLayout.CENTER);
        centerTop.add(titlePanel, BorderLayout.NORTH);
        return centerTop;
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
        GuiFacade.setResourceText(searchTxtField);
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
