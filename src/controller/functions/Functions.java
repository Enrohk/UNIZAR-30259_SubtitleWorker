package controller.functions;

import exceptions.FunctionException;
import model.ddbb.entity.Language;
import model.ddbb.entity.Work;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Functions {

    /**
     * @param type object class type
     * @param o
     * @return id of the object
     * @throws FunctionException
     */
    public static int getObjectIDByType(String type, Object o) throws FunctionException {
        try {
            switch (type) {
                case Literals.LANGUAGE_TYPE:
                    return ((Language) o).getIdLanguage();
                case Literals.WORK_TYPE:
                    return ((Work) o).getIdWork();

                default:
                    return -1;
            }
        }
        catch (Exception e)
        {
            throw new FunctionException();
        }

    }

    /**
     * @param line
     * @return true if the line is a srt time stamp line
     */
    public static boolean isTimeStampLine(String line)
    {
        try
        {
            return line.contains("-->");
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * @param line
     * @return true if this line is a integer
     */
    public static boolean isNumberLine(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void printSubtitleEntry(List<String> subtitleEntry, PrintWriter pw) throws IOException {

        for (String line : subtitleEntry) {
            pw.println(line);
        }
    }

    public static Scanner getScanner(String str, String type) throws FileNotFoundException {
        Scanner sc;

        switch (type) {
            case Literals.FROM_FILE:
                sc = new Scanner(new File(str));
                return sc;

            case Literals.FROM_STRING:
                sc = new Scanner(str);
                return sc;

        }

        return null;
    }

    public static List<String> getNewJoinedListWithTwoSpacesBetween(List<String> l1, List<String> l2) {
        List<String> result = new ArrayList<String>(l1);
        result.add("");
        result.add("");
        result.addAll(l2);
        return result;
    }
}
