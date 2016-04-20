package controller.functions;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class FunIsNumberLineTest {

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
    public void testIsNumberNull() {
        assertFalse(Functions.isNumberLine(null));
    }
}
