package gui.components;


import controller.ddbb.dto.CommentDTO;

import javax.swing.*;
import java.awt.*;


public class SingleCommentPanel extends JPanel
{

    private CommentDTO comment;

    public SingleCommentPanel (CommentDTO comment)
    {
        this.comment = comment;
        this.setLayout(new BorderLayout());

        JTextArea jta = new JTextArea();
        jta.setColumns(70);
        jta.setRows(2);
        jta.setEditable(false);
        jta.setText(comment.getText());
        this.add(jta,BorderLayout.CENTER);

        JPanel topP = new JPanel();
        topP.setLayout(new BorderLayout());
        JPanel tP = new JPanel();
        tP.add(new JLabel(comment.getAuthor()));
        topP.add(tP,BorderLayout.WEST);

        JPanel rP = new JPanel();
        rP.add(new StarRater(5,comment.getRate(),false));
        topP.add(rP,BorderLayout.EAST);
        this.add(topP, BorderLayout.NORTH);
    }

}
