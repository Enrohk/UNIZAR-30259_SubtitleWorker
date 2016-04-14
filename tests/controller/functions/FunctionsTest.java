package controller.functions;


import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class FunctionsTest {

    @Test
    public  void testIsTimeStampLineTrue ()
    {
        String timeStamp = "00:02:17,440 --> 00:02:20,375";
        assertTrue(Functions.isTimeStampLine(timeStamp));
    }

    @Test
    public  void testIsTimeStampLineFalse()
    {
        String timeStamp = "no timne stamp";
        assertFalse(Functions.isTimeStampLine(timeStamp));
    }

    @Test
    public void testIsNumberLineTrue ()
    {
        String numberLine = "1";
        assertTrue(Functions.isNumberLine(numberLine));
    }

    @Test
    public void testIsNumberLineFalse ()
    {
        String numberLine = "not number line";
        assertFalse(Functions.isNumberLine(numberLine));
    }


    @Test
    public void testIsNumberEmptyLine ()
    {
        String numberLine = "";
        assertFalse(Functions.isNumberLine(numberLine));
    }

}
