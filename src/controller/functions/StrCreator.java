package controller.functions;

import java.util.*;

public class StrCreator {

    public static Map<String, List<String>> parseStr(String str, String type) {
        Map<String, List<String>> parsedStr = new TreeMap<String, List<String>>();
        List<String> subtitleEntry = new ArrayList<String>();
        String timeStamp = null;
        String line;

        try (Scanner sc = Functions.getScanner(str, type)) {
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (line.isEmpty()) {
                    if (timeStamp != null) {
                        parsedStr.put(timeStamp, subtitleEntry);
                        subtitleEntry = new ArrayList<String>();
                        timeStamp = "";
                    }
                } else {
                    if (!Functions.isNumberLine(line)) {
                        if (Functions.isTimeStampLine(line)) {
                            timeStamp = line;
                        } else {
                            subtitleEntry.add(line);
                        }
                    }
                }
            }
            parsedStr.put(timeStamp, subtitleEntry);

        } catch (Exception e) {

        }

        return parsedStr;

    }

    public static Map<String, List<String>> mergeStr(Map<String, List<String>> strTop, Map<String, List<String>> strBot) {

        Map<String, List<String>> mergedStr = new TreeMap<String, List<String>>();

        for (String t : strTop.keySet()) {
            if (strBot.containsKey(t)) {
                mergedStr.put(t, Functions.getNewJoinedListWithTwoSpacesBetween(strTop.get(t), strBot.get(t)));
                strBot.remove(t);
            } else {
                mergedStr.put(t, strTop.get(t));
            }

        }
        for (String t : strBot.keySet()) {
            mergedStr.put(t, strBot.get(t));
        }


        return mergedStr;

    }


}
