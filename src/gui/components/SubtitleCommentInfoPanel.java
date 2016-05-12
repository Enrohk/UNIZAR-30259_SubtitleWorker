package gui.components;


import controller.facade.GuiItems;
import controller.security.PropertiesKeys;

import javax.swing.*;
import java.awt.*;


public class SubtitleCommentInfoPanel extends JPanel {

    private JTextArea commentBox;
    private StarRater startRater;
    private SpinnerNumberModel spinnerModel;

    public SubtitleCommentInfoPanel()
    {
        this.setLayout(new BorderLayout());
        this.addSpinners();
        this.addCommentBox();
        this.validate();
        this.repaint();
    }

    private void addSpinners ()
    {
        JPanel topP = new JPanel();
        topP.setLayout(new BoxLayout(topP,BoxLayout.X_AXIS));
        LangLabel timeLbl = new LangLabel(PropertiesKeys.CHANGE_TIME_SUB);
        JPanel pLbl = new JPanel();
        pLbl.add(timeLbl);
        topP.add(pLbl);

        spinnerModel = new SpinnerNumberModel(0,-15,15,1);
        JSpinner sp = new JSpinner(spinnerModel);
        JPanel spP = new JPanel();
        spP.add(sp);
        topP.add(spP);
        GuiItems.setModifySpinner(sp);

        LangButton btn = new LangButton(PropertiesKeys.MODIFY_TIME_BTN);
        JPanel btnP = new JPanel();
        btnP.add(btn);
        topP.add(btnP);
        //this.add(topP, BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.add(new LangLabel(PropertiesKeys.ADD_COMMENT));
        this.add(p,BorderLayout.NORTH);

    }

    private void addCommentBox ()
    {
        JPanel p = new JPanel();
       // p.setLayout(new BorderLayout());
        JPanel cP = new JPanel();
        commentBox = new JTextArea();
        commentBox.setRows(10);
        commentBox.setColumns(30);
        commentBox.setBorder(BorderFactory.createLineBorder(Color.black));
        cP.add(commentBox);
        p.add(cP);
        JPanel pR = new JPanel();
        pR.add(getRatingPanel());
        pR.setAlignmentX(TOP_ALIGNMENT);
        p.add(pR);
        this.add(p,BorderLayout.CENTER);
    }

    private JPanel getRatingPanel ()
    {
        JPanel rP = new JPanel();
        rP.setLayout(new BorderLayout());
        JPanel sP = new JPanel();
        startRater = new StarRater(true);
        sP.add(startRater);
        rP.add(sP, BorderLayout.NORTH);
        JPanel btnP = new JPanel();
        LangButton rate = new LangButton(PropertiesKeys.RATE_BTN);
        btnP.add(rate);
        rP.add(btnP,BorderLayout.CENTER);
        return rP;
    }

    public void clear() {
        startRater.setSelection(0);
        commentBox.setText("");
        spinnerModel.setValue(0);
    }

    public int getRate() {
        return startRater.getSelection();
    }

    public String getText()
    {
        return commentBox.getText();
    }
}
