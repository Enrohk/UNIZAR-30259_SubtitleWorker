package controller.functions;


import org.junit.Test;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class StrCreatorTest {


    @Test
    public  void testLoadStrAndMerge ()
    {
        String str1 = "1\n0-->1\njustatest\n\n2\n2-->3\nwith more\nlines",
                str2 = "1\n0-->1\nsolo un test\n\n2\n2-->3\ncon mas\nlineas";

        Map<String, List<String>> strMap1, strMap2, strMap2Copy, strMerge;
        strMap1 = StrCreator.parseStr(str1,Literals.FROM_STRING);
        strMap2 = StrCreator.parseStr(str2,Literals.FROM_STRING);
        strMap2Copy = StrCreator.parseStr(str2,Literals.FROM_STRING);
        strMerge = StrCreator.mergeStr(strMap1, strMap2Copy);

        //copy used because items of str2 are removed.
        assertTrue(strMap1.size() == strMap2.size());
        assertTrue(strMap2.size() == strMerge.size());
    }
}


