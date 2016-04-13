package controller.functions;


import controller.ddbb.DataBaseManager;
import model.ddbb.entity.Subtitle;
import org.junit.BeforeClass;
import org.junit.Test;
import controller.functions.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
public class SingleFileCreatorTest {

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

            SingleFileCreator.downloadFileSubtitle(subtitle,tempFileDest);
            String fileContent = FileContent.getFileContent(tempFileDest);

            String subtiteContent = new String(subtitle.getContent()).trim();
            assertTrue(fileContent.trim().equals(subtiteContent));

        }
        catch (Exception e)
        {

        }

    }

}
