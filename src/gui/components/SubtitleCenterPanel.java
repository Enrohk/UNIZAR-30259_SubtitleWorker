package gui.components;

import controller.ddbb.dto.SubtitleDTO;
import javax.swing.*;
import java.awt.*;

public class SubtitleCenterPanel extends JPanel {

    private SubtitleCommentListPanel commentListPanel;
    private SubtitleCommentInfoPanel addCommentPanel;
    private SubtitleContentPanel contentPanel;
    private JLabel titleLabel;

    public SubtitleCenterPanel ()
    {
        init();
        this.validate();
        this.repaint();

    }

    private void init ()
    {
        this.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        commentListPanel = new SubtitleCommentListPanel();
        contentPanel = new SubtitleContentPanel();
        addCommentPanel = new SubtitleCommentInfoPanel();
        centerPanel.add(contentPanel,BorderLayout.WEST);
        centerPanel.add(addCommentPanel,BorderLayout.EAST);
        centerPanel.add(commentListPanel,BorderLayout.SOUTH);
        this.add(centerPanel,BorderLayout.CENTER);
        titleLabel = new JLabel();
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        this.add(titlePanel,BorderLayout.NORTH);

    }

    public void fillInfo (SubtitleDTO subtitle)
    {
        clear();
        titleLabel.setText(subtitle.getTitle());
            if(subtitle.getCommentaries()!= null && subtitle.getCommentaries().size() > 0)
        commentListPanel.addComments(subtitle.getCommentaries());
            if(subtitle.getContent()!=null)
        contentPanel.addContent(subtitle.getContent().toString());
        this.validate();
        this.repaint();
    }

    private void clear ()
    {
        commentListPanel.clear();
        contentPanel.clear();
        addCommentPanel.clear();
    }

}
