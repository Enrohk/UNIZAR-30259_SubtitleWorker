package gui.components;

import javax.swing.*;
import java.awt.*;

public class SubtitleContentPanel extends JPanel {

    private JTextArea content;

    public SubtitleContentPanel ()
    {
        JPanel cP = new JPanel();
        content = new JTextArea();
        content.setColumns(30);
        content.setRows(25);
        content.setBorder(BorderFactory.createLineBorder(Color.black));
        content.setEditable(false);
        cP.add(content);
        this.add(cP);

    }

    public void addContent (String contentText)
    {
        content.setText(contentText);
    }

    public void clear() {
        content.setText("");
    }
}
