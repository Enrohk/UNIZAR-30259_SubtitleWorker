package gui.components;

import controller.facade.GuiFacade;
import controller.functions.Functions;
import controller.functions.GuiFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LanguageChangerJLabel extends JLabel {


    private ImageIcon[] images;
    public LanguageChangerJLabel (String key)
    {
        images = Functions.getImages(key);
        this.setIcon(images[0]);

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
                mouseEnter();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseExit();
            }
        });
    }

    private void mouseEnter ()
    {
        this.setIcon(images[1]);
    }

    private void mouseExit ()
    {
        this.setIcon(images[0]);
    }
}
