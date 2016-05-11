package gui.components;

import controller.ddbb.dto.SubtitleDTO;
import controller.facade.GuiFacade;
import exceptions.DBException;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickableJLabel extends JPanel {

    private JLabel text;
    private SubtitleDTO subtitleDTO;
    Color c;

    public ClickableJLabel(SubtitleDTO subtitleDTO)
    {
        this.subtitleDTO = subtitleDTO;
        text = new JLabel(subtitleDTO.getTitle());
        this.add(text);
        c = text.getForeground();
        addMouseListenerToLabel();
    }

    private void addMouseListenerToLabel() {
        text.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    GuiFacade.showSubtitlePanel(subtitleDTO);
                } catch (DBException e1) {
                    e1.printStackTrace();
                }
                text.setForeground(c);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                changeBackGround(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                changeBackGround(false);
            }
        });
    }

    private void changeBackGround (boolean entered)
    {
        if (entered)
        {
            text.setForeground(Color.red);
        }
        else
            text.setForeground(c);
    }


}
