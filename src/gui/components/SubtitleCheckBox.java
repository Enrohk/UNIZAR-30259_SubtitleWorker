package gui.components;

import controller.ddbb.dto.SubtitleDTO;
import model.ddbb.entity.Subtitle;

import javax.swing.*;
import java.awt.*;


public class SubtitleCheckBox extends Checkbox {


    private SubtitleDTO subtitle;
    public SubtitleDTO getSubtitle() {
        return subtitle;
    }

    public SubtitleCheckBox(SubtitleDTO subtitle) {
        super();
        this.subtitle = subtitle;
    }

}
