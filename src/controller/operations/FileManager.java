package controller.operations;

import model.ddbb.entity.SubtitleEntity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class FileManager
{

    public static void downloadSubtitle (File destFile, SubtitleEntity subtitleEntity)
    {

        try
        {
            FileOutputStream fos = new FileOutputStream(destFile);


        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

}
