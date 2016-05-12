package controller.functions;

import controller.ddbb.DBMapNameId;
import controller.ddbb.dto.CommentDTO;
import controller.ddbb.dto.SubtitleDTO;
import controller.facade.MainFacade;
import controller.security.PropertiesKeys;
import exceptions.FunctionException;
import model.ddbb.entity.Language;
import model.ddbb.entity.Subtitle;
import model.ddbb.entity.UserComentSubtitle;
import model.ddbb.entity.Work;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void disableHibernateLog ()
    {
        Logger log = Logger.getLogger("org.hibernate");
        log.setLevel(Level.OFF);
    }

    public static String[] getLanguageArray ()
    {
        Set<String> langSet = DBMapNameId.getMap(Literals.LANGUAGE_TYPE).keySet();
        String[] langArr = new String[langSet.size()+1];
        langArr = langSet.toArray(langArr);
        String first = langArr[0];
        langArr[0] = Literals.LIST_FIRST_ITEM;
        langArr[langSet.size()] = first;
        return langArr;

    }

    public static boolean isValidMail (String mail)
    {
        return mail.contains("@") && mail.indexOf(" ") < 0 ;
    }

    public static SubtitleDTO createSubtitleDTO(Subtitle dbSubtitle) {

        SubtitleDTO subtitleDTO = new SubtitleDTO();
        subtitleDTO.setTitle(dbSubtitle.getTitle());
        subtitleDTO.setContent(dbSubtitle.getContent());
        subtitleDTO.setWorkIdWork(dbSubtitle.getWorkIdWork());
        subtitleDTO.setLanguageIdLanguage(dbSubtitle.getLanguageIdLanguage());
        subtitleDTO.setIdSubtitle(dbSubtitle.getIdSubtitle());
        return subtitleDTO;
    }

    public static ImageIcon[] getImages(String type) {

        ImageIcon[] images = new ImageIcon[2];

        switch (type)
        {
            case PropertiesKeys.ENGLISH_LANG:
                images[0] = new ImageIcon(PropertiesKeys.ICON_LANG_EN_0);
                images[1] = new ImageIcon(PropertiesKeys.ICON_LANG_EN_1);
                break;

            case PropertiesKeys.SPANISH_LANG:
                images[0] = new ImageIcon(PropertiesKeys.ICON_LANG_ES_0);
                images[1] = new ImageIcon(PropertiesKeys.ICON_LANG_ES_1);
                break;
        }

        return images;

    }

    public static CommentDTO createCommentDTO(UserComentSubtitle dbComment) {

        CommentDTO commentDto = new CommentDTO();
        commentDto.setRate(Integer.parseInt(dbComment.getPunt()));
        commentDto.setText(dbComment.getText());
        commentDto.setAuthorId(dbComment.getUserIdUser());
        commentDto.setAuthor(MainFacade.getLoggedUser().getName());
        return commentDto;
    }
}
