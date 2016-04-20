package model.ddbb.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ramon on 12/04/2016.
 */
@Entity
public class Language {
    private int idLanguage;
    private String name;

    @Id
    @Column(name = "idLanguage")
    public int getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(int idLanguage) {
        this.idLanguage = idLanguage;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Language language = (Language) o;

        if (idLanguage != language.idLanguage) return false;
        if (name != null ? !name.equals(language.name) : language.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLanguage;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
