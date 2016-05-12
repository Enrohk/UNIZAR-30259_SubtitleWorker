package gui.components;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class SubtitleContentPanel extends JPanel {

    private JTextArea content;

    public SubtitleContentPanel ()
    {
        JPanel cP = new JPanel();
        content = new JTextArea();
        content.setColumns(40);
        content.setRows(25);
        content.setBorder(BorderFactory.createLineBorder(Color.black));
        content.setEditable(false);
        content.setWrapStyleWord(true);
        content.setLineWrap(true);
        cP.add(content);
        JScrollPane jp = new JScrollPane(content);
        this.add(jp);

    }

    public void addContent (String contentText)
    {
        content.setText(contentText);
    }

    public void clear() {
        content.setText("");
    }
}
