package controller.ddbb;

import controller.functions.Functions;
import java.util.List;

import controller.functions.Literals;
import exceptions.DBException;
import model.ddbb.entity.Language;
import model.ddbb.entity.Work;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class DBMapNameIdTest {

    @BeforeClass
    public static void disableLog() {
        Functions.disableHibernateLog();
    }

    @Test
    public void testMapGeneratedMatchWorkBDList () throws DBException {
        List workList = DataBaseManager.getListByQuery(QueryStrings.GET_WORK_LIST);
        int dbListSize = workList.size();
        DBMapNameId.initWorks();
        int workMapSize = DBMapNameId.getMap(Literals.WORK_TYPE).size();
        assertTrue(dbListSize == workMapSize);

        Work work;
        int workMapId;
        for (Object oWork : workList)
        {
            work = (Work) oWork;
            workMapId = DBMapNameId.getMap(Literals.WORK_TYPE).get(work.getTitle());
            assertTrue(workMapId == work.getIdWork());
        }
    }

    @Test
    public void testMapGeneratedMatchLangBDList () throws DBException {
        List langList = DataBaseManager.getListByQuery(QueryStrings.GET_LANGUAGE_LIST);
        int dbListSize = langList.size();
        DBMapNameId.initWorks();
        int langMapSize = DBMapNameId.getMap(Literals.LANGUAGE_TYPE).size();
        assertTrue(dbListSize == langMapSize);

        Language language;
        int langMapId;
        for (Object oLang : langList)
        {
            language = (Language) oLang;
            langMapId = DBMapNameId.getMap(Literals.LANGUAGE_TYPE).get(language.getName());
            assertTrue(langMapId == language.getIdLanguage());
        }
    }

}
