package model.ddbb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ramon on 12/04/2016.
 */
public class SubtitlePK implements Serializable {
    private int idSubtitle;
    private int workIdWork;
    private int languageIdLanguage;

    @Column(name = "idSubtitle")
    @Id
    public int getIdSubtitle() {
        return idSubtitle;
    }

    public void setIdSubtitle(int idSubtitle) {
        this.idSubtitle = idSubtitle;
    }

    @Column(name = "Work_idWork")
    @Id
    public int getWorkIdWork() {
        return workIdWork;
    }

    public void setWorkIdWork(int workIdWork) {
        this.workIdWork = workIdWork;
    }

    @Column(name = "Language_idLanguage")
    @Id
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

        SubtitlePK that = (SubtitlePK) o;

        if (idSubtitle != that.idSubtitle) return false;
        if (workIdWork != that.workIdWork) return false;
        if (languageIdLanguage != that.languageIdLanguage) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSubtitle;
        result = 31 * result + workIdWork;
        result = 31 * result + languageIdLanguage;
        return result;
    }
}
