package gui.components;


import model.ddbb.entity.Subtitle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class SubtitleListPanel extends JPanel {

    //private List<SubtitleCheckBox> subtitleCheckBoxList;
    private CheckboxGroup group;

    public SubtitleListPanel ()
    {
        group = new CheckboxGroup();
    //    subtitleCheckBoxList = new ArrayList<>();
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

    }

    public void addSubtitle (SubtitleCheckBox scb)
    {
        scb.setCheckboxGroup(group);
       // subtitleCheckBoxList.add(scb);
        this.add(scb);
    }

    public Subtitle getSelected ()
    {
        return ((SubtitleCheckBox)group.getSelectedCheckbox()).getSubtitle();
    }

}
