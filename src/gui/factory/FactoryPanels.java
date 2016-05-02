package gui.factory;


import controller.facade.GuiItems;
import controller.functions.Functions;
import controller.functions.Literals;
import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import exceptions.DBException;
import gui.components.*;

import javax.swing.*;
import java.awt.*;

public class FactoryPanels {

    public static JPanel getLogInDialogPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        JPanel userFieldPanel = new JPanel();
        String user = PropertiesHandler.getLanguageValue(PropertiesKeys.LOG_IN_USERNAME);
        userFieldPanel.add(FactoryLabels.getLabel(user));
        JTextField userName = new JTextField();
        GuiItems.setLogInNameJTF(userName);
        userName.setColumns(10);
        userFieldPanel.add(userName);

        JPanel passFieldPanel = new JPanel();
        String pass = PropertiesHandler.getLanguageValue(PropertiesKeys.LOG_IN_PASSWORD);
        passFieldPanel.add(FactoryLabels.getLabel(pass));
        JPasswordField password = new JPasswordField();
        GuiItems.setLogInPassJTF(password);
        password.setColumns(10);
        passFieldPanel.add(password);

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));
        fieldsPanel.add(userFieldPanel);
        fieldsPanel.add(passFieldPanel);

        String keep = PropertiesHandler.getLanguageValue(PropertiesKeys.LOG_IN_KEEP);
        JCheckBox keepLogged = new JCheckBox(keep);
        GuiItems.setKeepLogged(keepLogged);
        JPanel southPanel = new JPanel();
        southPanel.add(keepLogged);

        centerPanel.add(southPanel, BorderLayout.SOUTH);
        centerPanel.add(fieldsPanel, BorderLayout.CENTER);

        return centerPanel;
    }

    public static JPanel getRegisterDialogPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        JPanel mailFieldPanel = new JPanel();
        String mail = PropertiesHandler.getLanguageValue(PropertiesKeys.REG_MAIL);
        mailFieldPanel.add(FactoryLabels.getLabel(mail));
        JTextField userMail = new JTextField();
        GuiItems.setRegisterEmailJTF(userMail);
        userMail.setColumns(20);
        mailFieldPanel.add(userMail);

        JPanel userFieldPanel = new JPanel();
        String user = PropertiesHandler.getLanguageValue(PropertiesKeys.LOG_IN_USERNAME);
        userFieldPanel.add(FactoryLabels.getLabel(user));
        JTextField userName = new JTextField();
        GuiItems.setLogInNameJTF(userName);
        userName.setColumns(10);
        userFieldPanel.add(userName);

        JPanel passFieldPanel = new JPanel();
        String pass = PropertiesHandler.getLanguageValue(PropertiesKeys.LOG_IN_PASSWORD);
        passFieldPanel.add(FactoryLabels.getLabel(pass));
        JPasswordField password = new JPasswordField();
        GuiItems.setLogInPassJTF(password);
        password.setColumns(10);
        passFieldPanel.add(password);

        JPanel pass2FieldPanel = new JPanel();
        String pass2 = PropertiesHandler.getLanguageValue(PropertiesKeys.REG_PASSWORD2);
        passFieldPanel.add(FactoryLabels.getLabel(pass2));
        JPasswordField password2 = new JPasswordField();
        GuiItems.setRegisterPassJTF(password2);
        password2.setColumns(10);
        passFieldPanel.add(password2);

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));
        fieldsPanel.add(mailFieldPanel);
        fieldsPanel.add(userFieldPanel);
        fieldsPanel.add(passFieldPanel);
        fieldsPanel.add(pass2FieldPanel);

        String keep = PropertiesHandler.getLanguageValue(PropertiesKeys.LOG_IN_KEEP);
        JCheckBox keepLogged = new JCheckBox(keep);
        GuiItems.setKeepLogged(keepLogged);
        JPanel southPanel = new JPanel();
        southPanel.add(keepLogged);

        centerPanel.add(southPanel, BorderLayout.SOUTH);
        centerPanel.add(fieldsPanel, BorderLayout.CENTER);

        return centerPanel;
    }

    public static JPanel getMainTopPanel() throws DBException {
        JPanel genericTop = new JPanel();
        genericTop.setLayout(new BorderLayout());
        genericTop.add(getGenericTopLeft(), BorderLayout.WEST);
        genericTop.add(getGenericTopCenter(), BorderLayout.CENTER);
        genericTop.add(getGenericTopRight(), BorderLayout.EAST);
        return genericTop;
    }

    public static JPanel getMainBotPanel() {
        JPanel botPanel = new JPanel();
        GuiItems.setMainBotPanel(botPanel);
        return botPanel;
    }

    public static JPanel getTopSearchPanel() {
        JPanel topSearchPanel = new JPanel();
        JComboBox<String> langDDL = new JComboBox<>(Functions.getLanguageArray());
        langDDL.setSelectedIndex(0);
        langDDL.setAlignmentX(Component.CENTER_ALIGNMENT);
        topSearchPanel.add(langDDL);
        return topSearchPanel;
    }

    private static JPanel getCenterCenterPanel() {
        JPanel centerCenter = new JPanel();
        centerCenter.setLayout(new GridLayout(0, 2));

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

        centerLeft.add(leftSubtitle, BorderLayout.CENTER);
        centerRight.add(rightSubtitle, BorderLayout.CENTER);

        GuiItems.setLeftSubtitlePanel(leftSubtitle);
        GuiItems.setRightSubtitlePanel(rightSubtitle);

        centerCenter.add(centerLeft);
        centerCenter.add(centerRight);
        //return new JPanel();
        return centerCenter;
    }


    private static JPanel getSubtitleSearcherPanel(String searchButton, String downloadButton) {
        JPanel subtitleSearcher = new JPanel();
        subtitleSearcher.add(new ItemListPanel(searchButton, downloadButton));
        return subtitleSearcher;
    }

    private static JPanel getCenterTopPanel() {
        JPanel centerTop = new JPanel();
        centerTop.setLayout(new BorderLayout());
        JLabel titleLbl = new JLabel();
        GuiItems.setResourceLabel(titleLbl);
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLbl);
        JPanel jtaPanel = new JPanel();
        JTextArea area = new JTextArea(10, 50);
        area.setLineWrap(true);
        jtaPanel.add(area);
        GuiItems.setResourceJTA(area);
        centerTop.add(jtaPanel, BorderLayout.CENTER);
        centerTop.add(titlePanel, BorderLayout.NORTH);
        return centerTop;
    }

    private static JPanel getGenericTopRight() {

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(0, 2));
        rightPanel.add(getLogOutPanel());
        rightPanel.add(getChangeLanguagePanel());
        return rightPanel;

    }

    private static JPanel getLogOutPanel() {
        JPanel logOutPanel = new JPanel();
        logOutPanel.setLayout(new BorderLayout());
        logOutPanel.add(new LangButton(PropertiesKeys.LOG_OUT_BUTTON));
        logOutPanel.add(getLoggedAsPanel(), BorderLayout.SOUTH);
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

    private static JPanel getChangeLanguagePanel() {
        JPanel changeLangPanel = new JPanel();

        JLabel l1 = new JLabel("ES");
        JLabel l2 = new JLabel("EN");
        changeLangPanel.add(l1);
        changeLangPanel.add(l2);

        return changeLangPanel;
    }


    private static JPanel getGenericTopCenter() throws DBException {
        JPanel centerPanel = new JPanel();
        JPanel searchBtnPanel = new JPanel();
        searchBtnPanel.add(new LangButton(PropertiesKeys.FILM_SEARCH_BUTTON));
        JTextField jtf = AutoCompleteJTA.getAutocompleteTextArea(Literals.WORK_TYPE);
        GuiItems.setResourceText(jtf);
        jtf.setColumns(25);
        centerPanel.add(jtf);

        centerPanel.add(searchBtnPanel);
        return centerPanel;
    }

    private static JPanel getTextArea() {
        JPanel textAreaPanel = new JPanel();
        JTextField searchTxtField = new JTextField(25);
        GuiItems.setResourceText(searchTxtField);
        textAreaPanel.add(searchTxtField);
        return textAreaPanel;
    }

    private static JPanel getGenericTopLeft() {
        JPanel leftPanel = new JPanel();
        LangButton langBtn = new LangButton(PropertiesKeys.UPDATE_SUBTITLE_BUTTON);
        leftPanel.add(langBtn);
        return leftPanel;
    }


    public static JPanel getUploadSubtitlePanel() {

        JPanel uploadSubtitle = new JPanel();

        JPanel fileChooserPanel = new JPanel();
        fileChooserPanel.add(new LangButton(PropertiesKeys.UPLOAD_CHOOSE_BTN));

        JPanel namePanel = getPanelWithLayout();
        namePanel.add(new LangLabel(PropertiesKeys.UPLOAD_NAME));
        JTextField jtf = new JTextField(15);
        GuiItems.setUploadNameJTF(jtf);
        namePanel.add(jtf);

        JPanel workPanel = getPanelWithLayout();
        workPanel.add(new LangLabel(PropertiesKeys.UPLOAD_WORK));
        jtf = new JTextField(15);
        GuiItems.setUploadWorkJTF(jtf);
        workPanel.add(jtf);

        JPanel langPanel = getPanelWithLayout();
        langPanel.add(new LangLabel(PropertiesKeys.UPLOAD_LANG_NAME));
        jtf = new JTextField(15);
        GuiItems.setUploadLangJTF(jtf);
        langPanel.add(jtf);

        uploadSubtitle.setLayout(new BoxLayout(uploadSubtitle, BoxLayout.Y_AXIS));

        uploadSubtitle.add(fileChooserPanel);
        uploadSubtitle.add(namePanel);
        uploadSubtitle.add(workPanel);
        uploadSubtitle.add(langPanel);

        return uploadSubtitle;

    }

    private static JPanel getPanelWithLayout() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 0));
        return panel;
    }


    public static void generateSubtitleCenterPanel() {

        JPanel scp = new SubtitleCenterPanel();
        GuiItems.setCenterSubtitlePanel(scp);

    }

    public static  void generateMainCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(getCenterTopPanel(), BorderLayout.NORTH);
        centerPanel.add(getCenterCenterPanel(), BorderLayout.CENTER);
        GuiItems.setCenterMainPanel(centerPanel);
    }
}
