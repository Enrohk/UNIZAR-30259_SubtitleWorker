package controller.ddbb.dto;


import controller.functions.Functions;
import model.ddbb.entity.Subtitle;
import model.ddbb.entity.UserComentSubtitle;

import java.util.List;
import java.util.Map;

public class SubtitleDTO {

    private int idSubtitle;
    private byte[] content;
    private String type;
    private String title;
    private int workIdWork;
    private int languageIdLanguage;

    public int getIdSubtitle() {
        return idSubtitle;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWorkIdWork() {
        return workIdWork;
    }

    public void setWorkIdWork(int workIdWork) {
        this.workIdWork = workIdWork;
    }

    public int getLanguageIdLanguage() {
        return languageIdLanguage;
    }

    public void setLanguageIdLanguage(int languageIdLanguage) {
        this.languageIdLanguage = languageIdLanguage;
    }

    public Subtitle getSubtitle() {
        Subtitle subtitle = new Subtitle();
        subtitle.setWorkIdWork(this.workIdWork);
        subtitle.setLanguageIdLanguage(this.languageIdLanguage);
        subtitle.setContent(this.content);
        subtitle.setTitle(this.title);
        return subtitle;

    }

    public void setContentFromStr(Map<String, List<String>> str) {

        String strToString = "";
        for (Map.Entry entry : str.entrySet()) {
            strToString = entry.getKey() + "\n" + ((List<String>) entry.getValue()).get(0);
        }


        this.setContent(strToString.getBytes());

    }

    public List<CommentDTO> getCommentaries() {

        return null;
    }

    public static SubtitleDTO getSubtitleDTOFromQuery(String s) {

        return new SubtitleDTO();
    }
}
