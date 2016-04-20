package controller.ddbb;

import controller.functions.Functions;
import java.util.List;

import exceptions.DBException;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class WorkMapTest {

    @BeforeClass
    public static void disableLog() {
        Functions.disableHibernateLog();
    }

    @Test
    public void testMapGeneratedMatchWorkBDList () throws DBException {
        List workList = DataBaseManager.getListByQuery(QueryStrings.GET_WORK_LIST);
        int dbListSize = workList.size();
        WorkMap.initWorkMap();
        int workMapSize = WorkMap.getWorkMap().size();
        assertTrue(dbListSize == workMapSize);
    }


}
