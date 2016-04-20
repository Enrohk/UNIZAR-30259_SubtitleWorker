package controller.ddbb;

import controller.ddbb.dto.WorkDTO;
import model.ddbb.entity.Language;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class DataBaseManagerTest {

    @BeforeClass
    public static void disableLog() {
        Logger log = Logger.getLogger("org.hibernate");
        log.setLevel(Level.OFF);
    }

    @Test
    public void testGetWorkListByNameCountShouldBe1() {
        try {
            String query = QueryGenerator.GET_WORK_BY_NAME + "'Pulp Fiction'";
            List list = DataBaseManager.getListByQuery(query);
            assertTrue(list.size() == 1);
        } catch (Exception e) {

        }
    }

    @Test
    public void testGetSubtitleListFromWorkByNameShouldBeMoreThan0() {

        try {
            WorkDTO workDTO = new WorkDTO("Pulp Fiction");
            assertTrue(workDTO.getSubtitleList().size() > 0);
        } catch (Exception e) {

        }

    }

    @Test
    public void testAddAndNewObjectWorks() {
        try {
            Language language = new Language();
            language.setName("dummy");
            int oldSize, newSize;
            String query = QueryGenerator.GET_LANGUAGE_LIST;
            List langList = DataBaseManager.getListByQuery(query);
            oldSize = langList.size();
            DataBaseManager.saveOrDeleteSingleObject(language, true);
            langList = DataBaseManager.getListByQuery(query);
            newSize = langList.size();
            assertTrue(newSize > oldSize);
            String newQuery = QueryGenerator.GET_LANGUAGE_BY_NAME + "'dummy'";
            language = (Language) DataBaseManager.getListByQuery(newQuery).get(0);
            DataBaseManager.saveOrDeleteSingleObject(language, false);
            langList = DataBaseManager.getListByQuery(query);
            newSize = langList.size();
            assertTrue(oldSize == newSize);

        } catch (Exception e) {

        }
    }


}
