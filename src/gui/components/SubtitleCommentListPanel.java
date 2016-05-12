package gui.components;


import controller.ddbb.dto.CommentDTO;

import javax.swing.*;
import java.util.List;

public class SubtitleCommentListPanel extends JPanel {


    public SubtitleCommentListPanel()
    {
       createLayout();
    }

    public void addComments(List<CommentDTO> commentaries) {


        JPanel commentsPanel = new JPanel();
        commentsPanel.setLayout(new BoxLayout(commentsPanel,BoxLayout.Y_AXIS));
        commentaries.forEach(comment -> commentsPanel.add(new SingleCommentPanel(comment)));
        JScrollPane scrollPane = new JScrollPane(commentsPanel);
        this.add(scrollPane);
        this.validate();
        this.repaint();


    }

    public void clear() {
        this.removeAll();
        createLayout();
    }

    private void createLayout ()
    {
         this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }

}
