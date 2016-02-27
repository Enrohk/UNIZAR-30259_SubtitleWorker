package controller.facade;

import controller.languageHandler.CanChangeLanguage;
import controller.languageHandler.ChangeLanguageObserver;
import controller.security.PropertiesHandler;
import controller.security.PropertiesKeys;
import gui.MainWindow;
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

        
        ChangeLanguageObserver.setListenerList(oldCCLList);


    }

    private List<CanChangeLanguage> getListListeners ()
    {
        List<CanChangeLanguage> list = new ArrayList<>();
        LangButton btn = new LangButton(PropertiesHandler.getLanguageValue
                (PropertiesKeys.TEST_TEXT));
        LangLabel lbl = new LangLabel(PropertiesHandler.getLanguageValue
                (PropertiesKeys.TEST_TEXT));

        list.add(btn);
        list.add(lbl);

        return list;

    }



}