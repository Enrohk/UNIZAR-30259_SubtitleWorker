package controller.functions;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class FunIsTimeStampLineTest {

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
    public void testIsTimeStampLineEmptyLine ()
    {
        assertFalse(Functions.isTimeStampLine(""));
    }

    @Test
    public void testIsTimeStampLineNull ()
    {
        assertFalse(Functions.isTimeStampLine(null));
    }

}
