package gui.components;

import controller.facade.GuiFacade;
import controller.languageHandler.CanChangeLanguage;
import controller.languageHandler.ChangeLanguageObserver;
import controller.security.PropertiesHandler;
import exceptions.DBException;
import exceptions.FunctionException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

public class LangButton extends JButton implements CanChangeLanguage {

    private String propertyKey;

    public LangButton(String propertyKey) {
        this.propertyKey = propertyKey;
        this.setText(PropertiesHandler.getLanguageValue(propertyKey));
        ChangeLanguageObserver.addNewListener(this);
        this.addActionListener(e -> {
            try {
                GuiFacade.click(propertyKey);
            } catch (DBException e1) {
                e1.printStackTrace();
            } catch (FunctionException e1) {
                e1.printStackTrace();
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        });
    }


    public void changeLanguage() {
        this.setText(PropertiesHandler.getLanguageValue(propertyKey));
    }

}