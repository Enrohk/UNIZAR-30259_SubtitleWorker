package controller.functions;


import model.ddbb.entity.Subtitle;

import java.io.PrintWriter;

public class SingleFileCreator {

    public static void downloadFileSubtitle (Subtitle subtitle, String fileDestPath)
    {
        PrintWriter pw = null;
        try
        {
            String finalPath = fileDestPath + "/" + subtitle.getTitle() + ".srt";
            pw = new PrintWriter(finalPath, "UTF-8");
            String subtitleContent = new String(subtitle.getContent());
            pw.write(subtitleContent);

        }
        catch (Exception e)
        {

        }
        finally {
            if (pw!=null)
                pw.close();
        }
    }

}
