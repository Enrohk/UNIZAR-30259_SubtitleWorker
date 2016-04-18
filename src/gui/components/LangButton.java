package gui.components;

import controller.facade.GuiFacade;
import controller.languageHandler.CanChangeLanguage;
import controller.languageHandler.ChangeLanguageObserver;
import controller.security.PropertiesHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LangButton extends JButton implements CanChangeLanguage {

    private String propertyKey;

    public LangButton(String propertyKey) {
        this.propertyKey = propertyKey;
        this.setText(PropertiesHandler.getLanguageValue(propertyKey));
        ChangeLanguageObserver.addNewListener(this);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiFacade.click(propertyKey);
            }
        });
    }


    public void changeLanguage() {
        this.setText(PropertiesHandler.getLanguageValue(propertyKey));
    }

}