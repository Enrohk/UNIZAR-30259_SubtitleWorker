package controller.functions;


import controller.ddbb.DataBaseManager;
import model.ddbb.entity.Subtitle;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import java.util.List;
public class FileCreatorTest {

    @BeforeClass
    public static void disableLog ()
    {
        Logger log = Logger.getLogger("org.hibernate");
        log.setLevel(Level.OFF);
    }

    @Test
    public void downloadASingleSubtitleShouldWork ()
    {
        try {
            Subtitle subtitle = (Subtitle) DataBaseManager.getListByQuery("from Subtitle").get(0);
            assertTrue(subtitle.getIdSubtitle() > -1);
            String tempFileDest = "tmp/tmp.srt";

            FileCreator.downloadFileSubtitle(subtitle,tempFileDest);
            String fileContent = FileContent.getFileContent(tempFileDest);

            String subtitleContent = new String(subtitle.getContent()).trim();
            assertTrue(fileContent.trim().equals(subtitleContent));

        }
        catch (Exception e)
        {

        }

    }

    @Test
    public  void testgenerateFileFromStrMap ()
    {
        String path = "tmp/tmp1.srt";
        Scanner sc = null;
        try
        {
            String str = "1\n0-->1\njustatest\n\n2\n2-->3\nwith more\nlines";
            Map<String, List<String>> strMap = StrCreator.parseStr(str,Literals.FROM_STRING);
            String result ="";
            FileCreator.generateFileFromStrMap(strMap, path);
            sc = new Scanner (new File(path));

            while(sc.hasNextLine())
            {
                result+=sc.nextLine()+"\n";
            }
            result = result.substring(0,result.length()-2);
            assertTrue(str.equals(result));
        }
        catch (Exception e){
            fail();
        }
        finally {
            if (sc!=null)
                    sc.close();
        }

    }



}
