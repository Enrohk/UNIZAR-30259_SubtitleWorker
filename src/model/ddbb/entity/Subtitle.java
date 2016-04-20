package model.ddbb.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by ramon on 12/04/2016.
 */
@Entity
@IdClass(SubtitlePK.class)
public class Subtitle {
    private int idSubtitle;
    private byte[] content;
    private String type;
    private String title;
    private int workIdWork;
    private int languageIdLanguage;

    @Id
    @Column(name = "idSubtitle")
    public int getIdSubtitle() {
        return idSubtitle;
    }

    public void setIdSubtitle(int idSubtitle) {
        this.idSubtitle = idSubtitle;
    }

    @Basic
    @Column(name = "content")
    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Id
    @Column(name = "Work_idWork")
    public int getWorkIdWork() {
        return workIdWork;
    }

    public void setWorkIdWork(int workIdWork) {
        this.workIdWork = workIdWork;
    }

    @Id
    @Column(name = "Language_idLanguage")
    public int getLanguageIdLanguage() {
        return languageIdLanguage;
    }

    public void setLanguageIdLanguage(int languageIdLanguage) {
        this.languageIdLanguage = languageIdLanguage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subtitle subtitle = (Subtitle) o;

        if (idSubtitle != subtitle.idSubtitle) return false;
        if (workIdWork != subtitle.workIdWork) return false;
        if (languageIdLanguage != subtitle.languageIdLanguage) return false;
        if (!Arrays.equals(content, subtitle.content)) return false;
        if (type != null ? !type.equals(subtitle.type) : subtitle.type != null) return false;
        if (title != null ? !title.equals(subtitle.title) : subtitle.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSubtitle;
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + workIdWork;
        result = 31 * result + languageIdLanguage;
        return result;
    }
}
