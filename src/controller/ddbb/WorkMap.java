package controller.ddbb;

import exceptions.DBException;
import model.ddbb.entity.Work;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;

public class WorkMap {

    private static Map<String, Integer> workMap;

    public static void initWorkMap() throws DBException {

        workMap = new TreeMap<>();
        List dbWorks = DataBaseManager.getListByQuery(QueryStrings.GET_WORK_LIST);
        fillWorkMap(dbWorks);

    }

    public static Map<String, Integer> getWorkMap() {
        return workMap;
    }

    private static void fillWorkMap(List dbWorks) {
        String name;
        int id;
        for (Object work : dbWorks) {
            name = ((Work) work).getTitle();
            id = ((Work) work).getIdWork();
            workMap.put(name, id);
        }
    }


}
