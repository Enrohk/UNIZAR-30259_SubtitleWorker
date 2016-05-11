package gui.components;

import controller.facade.GuiFacade;
import controller.functions.GuiFunctions;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LanguageChangerJLabel extends JLabel {

    private String key;
    public LanguageChangerJLabel (String path, String key)
    {
        super(path);
        this.key = key;
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                GuiFacade.click(key);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
