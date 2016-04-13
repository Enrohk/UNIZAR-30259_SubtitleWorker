package gui.components;

import model.ddbb.entity.Subtitle;

import java.awt.*;


public class SubtitleCheckBox extends Checkbox {

    private Subtitle subtitle;

    public Subtitle getSubtitle() {
        return subtitle;
    }

    public SubtitleCheckBox (Subtitle subtitle)
    {
        super(subtitle.getTitle());
        this.subtitle = subtitle;

    }

}
