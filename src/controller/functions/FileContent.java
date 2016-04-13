package controller.functions;


import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class FileContent
{

    public static String getFileContent (String path)
    {
        StringBuilder content = new StringBuilder();
        try (Scanner sc = new Scanner(new File(path)))
        {
            while (sc.hasNext())
            {
                content.append(sc.nextLine());
            }
            return content.toString();
        }
        catch (Exception e)
        {
            return "";
        }

    }

}
