package controller.functions;

import exceptions.FunctionException;
import model.ddbb.entity.Language;
import model.ddbb.entity.Work;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class FunGetObjectIdByTypeTest {

    @Test
    public void getLanguageIdTest () throws FunctionException {
        Language lang = new Language();
        lang.setIdLanguage(1);
        assertTrue(1 == Functions.getObjectIDByType(Literals.LANGUAGE_TYPE, lang));
    }

    @Test
    public void getWorkIdTest () throws FunctionException {
        Work work = new Work();
        work.setIdWork(1);
        assertTrue(1 == Functions.getObjectIDByType(Literals.WORK_TYPE, work));
    }


    @Test
    public void getIdFromNonTypedObjectReturnNegative () throws FunctionException {
        Object o = new Object();
        assertTrue(0 > Functions.getObjectIDByType("NON TYPED OBJECT", o));
    }

    @Test(expected = FunctionException.class)
    public void getIdFromObjectButWithBadLiteralShouldThrowException () throws FunctionException {
        Object o = new Object();
        Functions.getObjectIDByType(Literals.WORK_TYPE, o);
    }

    @Test
    public void getIdFromObjectButWithBadLiteralAndTryCatchShouldPass () throws FunctionException {
        try
        {
            Object o = new Object();
            Functions.getObjectIDByType(Literals.LANGUAGE_TYPE, o);
        }
        catch (FunctionException e)
        {
            return;
        }
    }
}
