package controller.facade;

import controller.languageHandler.CanChangeLanguage;
import controller.languageHandler.ChangeLanguageObserver;
import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import gui.components.LangButton;
import gui.components.LangLabel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class MainFacadeTest {

    @Test
    public void testChangeLanguageToAllTypeOfComponents ()
    {
        List<CanChangeLanguage> oldCCLList = ChangeLanguageObserver.getListenerList();
        PropertiesHandler.loadLanguageProperties(PropertiesKeys.ENGLISH_LANG);
        List<CanChangeLanguage> list = new ArrayList<>();
        LangButton btn = new LangButton(PropertiesKeys.TEST_TEXT);
        LangLabel lbl = new LangLabel(PropertiesKeys.TEST_TEXT);

        list.add(btn);
        list.add(lbl);
        ChangeLanguageObserver.setListenerList(list);
        String helloEn = "hello";
        String helloEs = "hola";

        //assert text is in english
        assertTrue(btn.getText().equals(helloEn));
        assertTrue(lbl.getText().equals(helloEn));

        MainFacade.changeLanguage(PropertiesKeys.SPANISH_LANG);
        //assert text is in spanish
        assertTrue(btn.getText().equals(helloEs));
        assertTrue(lbl.getText().equals(helloEs));

        ChangeLanguageObserver.setListenerList(oldCCLList);
    }





}