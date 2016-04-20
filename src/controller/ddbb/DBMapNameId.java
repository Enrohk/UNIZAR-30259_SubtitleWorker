package controller.ddbb;

import controller.functions.Literals;
import exceptions.DBException;
import model.ddbb.entity.Language;
import model.ddbb.entity.Work;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;

public class DBMapNameId {

    private static Map<String, Integer> workMap, langMap;

    public static void initWorks() throws DBException {

        workMap = new TreeMap<>();
        langMap = new TreeMap<>();
        List dbWorks = DataBaseManager.getListByQuery(QueryStrings.GET_WORK_LIST);
        List dbLang = DataBaseManager.getListByQuery(QueryStrings.GET_LANGUAGE_LIST);
        fillMap(dbWorks, Literals.WORK_TYPE);
        fillMap(dbLang, Literals.LANGUAGE_TYPE);

    }

    public static Map<String, Integer> getMap(String mapType) {
        switch (mapType)
        {
            case Literals.WORK_TYPE :
                return workMap;
            case Literals.LANGUAGE_TYPE :
                return langMap;
        }
        return null;
    }

    private static void fillMap(List dbList, String mapType) {

        for (Object o : dbList) {
            putObject(o,mapType);
        }
    }

    private static void putObject (Object o, String mapType)
    {
        String name;
        int id;
        switch (mapType)
        {
            case Literals.WORK_TYPE :
                name = ((Work) o).getTitle();
                id = ((Work) o).getIdWork();
                workMap.put(name, id);
                break;
            case Literals.LANGUAGE_TYPE :
                name = ((Language) o).getName();
                id = ((Language) o).getIdLanguage();
                langMap.put(name, id);
                break;
        }
    }


}
