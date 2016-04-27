package gui.components;


import controller.ddbb.dto.SubtitleDTO;
import model.ddbb.entity.Subtitle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class SubtitleListPanel extends JPanel {

    //private List<SubtitleCheckBox> subtitleCheckBoxList;
    private CheckboxGroup group;


    public SubtitleListPanel() {
        group = new CheckboxGroup();

        //    subtitleCheckBoxList = new ArrayList<>();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
     //   this.setLayout(new FlowLayout());

    }

    public void addSubtitle(SubtitleCheckBox scb) {
        scb.setCheckboxGroup(group);
        JPanel p = new JPanel();
        p.add(scb);
        p.setAlignmentX(Component.CENTER_ALIGNMENT);
        // subtitleCheckBoxList.add(scb);
        this.add(p);
    }

    public SubtitleDTO getSelected() {
        return ((SubtitleCheckBox) group.getSelectedCheckbox()).getSubtitle();
    }

}
