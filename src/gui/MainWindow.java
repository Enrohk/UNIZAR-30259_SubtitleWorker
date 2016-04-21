package gui;

import controller.facade.MainFacade;
import controller.languageHandler.CanChangeLanguage;
import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import exceptions.DBException;
import exceptions.SomethingWrongHappenException;
import gui.factory.FactoryPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame implements CanChangeLanguage {
    public MainWindow() throws DBException {
        initFrame();
        MainFacade.addLanguageListener(this);
    }


    private void initFrame() throws DBException {
        String xString = PropertiesHandler.getConfigValue(PropertiesKeys.WINDOW_DIMENSION_X),
                yString = PropertiesHandler.getConfigValue(PropertiesKeys.WINDOW_DIMENSION_Y);

        this.setSize(Integer.parseInt(xString), Integer.parseInt(yString));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle(PropertiesHandler.getLanguageValue(PropertiesKeys.TITLE));
        this.setIconImage(new ImageIcon(PropertiesKeys.ICON_PATH).getImage());
        this.setLayout(new BorderLayout());
        addComponents();
        //close operation
        addCloseOperation();
    }

    private void addComponents() throws DBException {
        this.add(FactoryPanels.getMainTopPanel(), BorderLayout.NORTH);
        this.add(FactoryPanels.getMainCenterPanel(), BorderLayout.CENTER);
        this.add(FactoryPanels.getMainBotPanel(), BorderLayout.SOUTH);
    }

    private void addCloseOperation() {
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                int closeOption = gui.factory.FactoryDialog.closeGUIDialog();
                try {
                    controller.facade.MainFacade.closeProgram(closeOption);
                } catch (SomethingWrongHappenException e) {
                    e.printStackTrace();
                    //LOG ERROR ETC
                    System.exit(-1);
                }
            }
        });
    }

    public void changeLanguage() {
        this.setTitle(PropertiesHandler.getLanguageValue(PropertiesKeys.TITLE));
    }

}
