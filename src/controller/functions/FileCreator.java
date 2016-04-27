package controller.functions;

import controller.ddbb.dto.SubtitleDTO;
import model.ddbb.entity.Subtitle;

import java.io.FileWriter;
import java.util.*;
import java.io.PrintWriter;

public class FileCreator {

    public static void downloadFileSubtitle(SubtitleDTO subtitle, String fileDestPath) {
        String finalPath = fileDestPath + "/" + subtitle.getTitle() + ".srt";
        try (PrintWriter pw = new PrintWriter(finalPath, "UTF-8");) {
            String subtitleContent = new String(subtitle.getContent());
            pw.write(subtitleContent);

        } catch (Exception e) {

        }
    }

    public static void generateFileFromStrMap(Map<String, List<String>> strMap, String destPath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(destPath))) {
            int i = 1;

            for (String t : strMap.keySet()) {
                writer.println(String.valueOf(i));
                writer.println(t);
                Functions.printSubtitleEntry(strMap.get(t), writer);
                writer.println();
                i++;
            }
        } catch (Exception e) {

        }

    }

}
