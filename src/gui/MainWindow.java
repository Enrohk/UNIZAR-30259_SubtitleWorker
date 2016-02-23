package gui;


import exceptions.SomethingWrongHappenException;
import gui.factory.FactoryDialog;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainWindow extends JFrame
{

    public MainWindow ()
    {
        //initFrame();
        System.out.println(FactoryDialog.loginGUIDialog());
    }

    private void initFrame ()
    {
        //Properties must be setted with config file
        this.setSize(1000,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("WORKER");
        //this.setIconImage(new ImageIcon("path").getImage());  UNCOMENT WHEN ICON


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
