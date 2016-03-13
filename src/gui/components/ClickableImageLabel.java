package gui.components;


import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickableImageLabel extends JLabel
{
    private String propertieKey;
    private final int selected = 0, nonSelected = 1;

    private ImageIcon[] images;

    public ClickableImageLabel (String propertieKey)
    {
        this.propertieKey = propertieKey;
        getImages();



        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ACTION
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setImage(selected);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setImage(nonSelected);
            }
        });
    }

    private void setImage (int status)
    {
        this.setIcon(images[status]);
    }

    private void getImages() {
        images = new ImageIcon[2];
        images[selected] = new ImageIcon(PropertiesHandler.
                            getConfigValue(propertieKey+selected));

        images[nonSelected] = new ImageIcon(PropertiesHandler.
                getConfigValue(propertieKey+nonSelected));
    }
}
