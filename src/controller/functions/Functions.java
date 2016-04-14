package controller.functions;

import model.ddbb.entity.Language;
import model.ddbb.entity.Work;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Functions {

    public static int getObjectIDByType (String type, Object o)
    {
        switch (type)
        {
            case Literals.LANGUAGE_TYPE :
                return ((Language) o).getIdLanguage();
            case Literals.WORK_TYPE :
                return ((Work) o ).getIdWork();

            default:
                return -1;
        }
    }

    public static boolean isTimeStampLine (String line)
    {
        return line.contains ("-->");
    }

    public static boolean isNumberLine (String line)
    {
        try{
            Integer.parseInt(line);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static void printSubtitleEntry (List<String> subtitleEntry, PrintWriter pw) throws IOException {

        for (String line : subtitleEntry)
        {
            pw.println(line);
        }
    }

    public static Scanner getScanner (String str, String type) throws FileNotFoundException
    {
        Scanner sc;

        switch (type)
        {
            case Literals.FROM_FILE :
                sc = new Scanner (new File(str));
                return sc;

            case Literals.FROM_STRING :
                sc = new Scanner (str);
                return sc;

        }

        return null;
    }


}
