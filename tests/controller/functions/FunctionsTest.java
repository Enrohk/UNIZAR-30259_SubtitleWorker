package controller.functions;


import model.ddbb.entity.Language;
import model.ddbb.entity.Work;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class FunctionsTest {

    @Test
    public void testIsTimeStampLineTrue() {
        String timeStamp = "00:02:17,440 --> 00:02:20,375";
        assertTrue(Functions.isTimeStampLine(timeStamp));
    }

    @Test
    public void testIsTimeStampLineFalse() {
        String timeStamp = "no timne stamp";
        assertFalse(Functions.isTimeStampLine(timeStamp));
    }

    @Test
    public void testIsNumberLineTrue() {
        String numberLine = "1";
        assertTrue(Functions.isNumberLine(numberLine));
    }

    @Test
    public void testIsNumberLineFalse() {
        String numberLine = "not number line";
        assertFalse(Functions.isNumberLine(numberLine));
    }


    @Test
    public void testIsNumberEmptyLine() {
        String numberLine = "";
        assertFalse(Functions.isNumberLine(numberLine));
    }

    @Test
    public void testJoinTwoListShouldWork() {
        List<String> l1 = new ArrayList<String>(), l2 = new ArrayList<String>(), l3;
        l1.add("1");
        l1.add("2");
        l1.add("3");
        l2.add("4");
        l2.add("5");
        l2.add("6");
        l2.add("7");

        l3 = Functions.getNewJoinedListWithTwoSpacesBetween(l1, l2);

        assertTrue(l3.size() == (l1.size() + l2.size()) + 2);

        for (int i = 0; i < l1.size(); i++) {
            assertTrue(l3.get(i).equals(String.valueOf(i + 1)));
        }

        for (int i = l1.size() + 2; i < l2.size(); i++) {
            assertTrue(l3.get(i).equals(String.valueOf(i + 1)));
        }

    }

    @Test
    public void testGetObjectIdByType() {
        Language l = new Language();
        l.setIdLanguage(1);
        Work w = new Work();
        w.setIdWork(1);

        assertTrue(1 == Functions.getObjectIDByType(Literals.LANGUAGE_TYPE, l));
        assertTrue(1 == Functions.getObjectIDByType(Literals.WORK_TYPE, w));
        assertTrue(-1 == Functions.getObjectIDByType(Literals.NO_TYPE, ""));

    }
}
