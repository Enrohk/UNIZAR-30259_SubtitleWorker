package gui.factory;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryButtons {

    //Get names from properties

    public static JButton getActionButton(String action) {
        JButton logIn = new JButton(action);
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(action);
            }
        });
        return logIn;
    }

}
