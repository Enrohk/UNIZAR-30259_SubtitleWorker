package gui.components;

import com.mxrck.autocompleter.TextAutoCompleter;
import controller.ddbb.dto.WorkDTO;
import controller.functions.Functions;
import controller.functions.Literals;
import exceptions.DBException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class AutoCompleteJTA {

    public static JTextField getAutocompleteTextArea (String type) throws DBException
    {
        List<String> items = null;
        switch (type)
        {
            case Literals.WORK_TYPE:
                items = WorkDTO.getWorkTitleList();
                break;

            case Literals.LANGUAGE_TYPE :
                String[] lang = Functions.getLanguageArray();
                items = new ArrayList<>();
                for(int i=0; i<lang.length; i++)
                {
                    items.add(lang[i]);
                }
                break;
        }

        if(items !=null && items.size()>0)
            return generateAutocompleteTextArea(items);
        else
            return null;
    }

    private static JTextField generateAutocompleteTextArea (List<String> items)
    {
        JTextField jta = new JTextField();
        TextAutoCompleter complete=new TextAutoCompleter(jta);
        items.forEach( item -> complete.addItem(item));
        return jta;

    }

}
