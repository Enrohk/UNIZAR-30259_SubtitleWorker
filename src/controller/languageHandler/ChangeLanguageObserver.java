package controller.languageHandler;

import java.util.ArrayList;
import java.util.List;

public class ChangeLanguageObserver {

    private static List<CanChangeLanguage> listeners = new ArrayList<CanChangeLanguage>();

    public static void addNewListener (CanChangeLanguage listener)
    {
        listeners.add(listener);
    }

    public static void changeLanguage ()
    {
        for(CanChangeLanguage listener: listeners)
            listener.changeLanguage();
    }

}