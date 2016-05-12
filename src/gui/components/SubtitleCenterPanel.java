package gui.components;

import controller.ddbb.dto.SubtitleDTO;
import exceptions.DBException;

import javax.swing.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;

public class SubtitleCenterPanel extends JPanel {

    private SubtitleCommentListPanel commentListPanel;
    private SubtitleCommentInfoPanel addCommentPanel;
    private SubtitleContentPanel contentPanel;
    private JLabel titleLabel;
    private SubtitleDTO subtitleDto;

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

    public void fillInfo (SubtitleDTO subtitle) throws DBException, UnsupportedEncodingException {
        clear();
        this.subtitleDto = subtitle;
        titleLabel.setText(subtitle.getTitle());
            if(subtitle.getCommentaries()!= null && subtitle.getCommentaries().size() > 0)
        commentListPanel.addComments(subtitle.getCommentaries());
            if(subtitle.getContent()!=null)
        contentPanel.addContent(new String(subtitle.getContent(),"UTF-8"));
        this.validate();
        this.repaint();
    }

    private void clear ()
    {
        commentListPanel.clear();
        contentPanel.clear();
        addCommentPanel.clear();
    }

    public int getRate ()
    {
        return addCommentPanel.getRate();
    }

    public int getSubtitleId() {
        return subtitleDto.getIdSubtitle();
    }

    public String getCommentValue ()
    {
        return addCommentPanel.getText();
    }

    public void updateComments () throws DBException, UnsupportedEncodingException {
        fillInfo(this.subtitleDto);
    }
}
