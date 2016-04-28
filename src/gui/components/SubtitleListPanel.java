package gui.components;


import controller.ddbb.dto.SubtitleDTO;
import model.ddbb.entity.Subtitle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class SubtitleListPanel extends JPanel {

    private CheckboxGroup group;


    public SubtitleListPanel() {
        group = new CheckboxGroup();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

    public void addSubtitle(SubtitleCheckBox scb) {
        scb.setCheckboxGroup(group);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0,3));
        p.add(scb);
        p.add(new ClickableJLabel (scb.getSubtitle()));
        p.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(p);
    }

    public SubtitleDTO getSelected() {
        return ((SubtitleCheckBox) group.getSelectedCheckbox()).getSubtitle();
    }

    public void clean ()
    {
        this.removeAll();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        group = new CheckboxGroup();
    }

}
