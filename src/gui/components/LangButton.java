package gui.components;

import controller.languageHandler.CanChangeLanguage;
import controller.languageHandler.ChangeLanguageObserver;
import controller.security.PropertiesHandler;

import javax.swing.*;

public class LangButton extends JButton implements CanChangeLanguage {

    private String propertyKey;

    public LangButton (String propertyKey)
    {
        this.propertyKey = propertyKey;
        this.setText(PropertiesHandler.getLanguageValue(propertyKey));
        ChangeLanguageObserver.addNewListener(this);
    }

    public void changeLanguage ()
    {
        this.setText(PropertiesHandler.getLanguageValue(propertyKey));
    }

}