package gui.components;

import controller.ddbb.dto.SubtitleDTO;
import model.ddbb.entity.Subtitle;

import javax.swing.*;
import java.awt.*;

public class SubtitleCenterPanel extends JPanel {

    private SubtitleDTO subtitle;
    private JPanel contentPanel, addCommentPanel, commentListPanel;
    private JLabel titleLabel;

    public SubtitleCenterPanel ()
    {

        init();

    }

    private void init ()
    {
        this.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        contentPanel = new JPanel();
        addCommentPanel = new JPanel();
        commentListPanel = new CommentListPanel();
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2,0));
        infoPanel.add(contentPanel);
        infoPanel.add(addCommentPanel);
        centerPanel.setLayout(new GridLayout(0,2));
        centerPanel.add(infoPanel);
        centerPanel.add(commentListPanel);
        this.add(centerPanel,BorderLayout.CENTER);
        titleLabel = new JLabel();
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        this.add(titlePanel,BorderLayout.CENTER);
    }

    public void fillInfo (SubtitleDTO subtitle)
    {
        titleLabel.setText(subtitle.getTitle());

        this.validate();
        this.repaint();
    }

}
