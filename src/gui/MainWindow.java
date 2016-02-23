package gui;

import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import exceptions.SomethingWrongHappenException;
import gui.factory.FactoryDialog;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame
{
    public MainWindow ()
    {
        initFrame();
        System.out.println(FactoryDialog.loginGUIDialog());
    }

    private void initFrame ()
    {
        String xString = PropertiesHandler.getConfigValue(PropertiesKeys.WINDOW_DIMENSION_X),
               yString = PropertiesHandler.getConfigValue(PropertiesKeys.WINDOW_DIMENSION_Y);

        this.setSize(Integer.parseInt(xString),Integer.parseInt(yString));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle(PropertiesHandler.getLanguageValue(PropertiesKeys.TITLE));
        this.setIconImage(new ImageIcon(PropertiesKeys.ICON_PATH).getImage());


        //close operation
        addCloseOperation();
    }

    private void addCloseOperation ()
    {
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

}
