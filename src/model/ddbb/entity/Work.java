package model.ddbb.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;

/**
 * Created by ramon on 12/04/2016.
 */
@Entity
public class Work {
    private int idWork;
    private String title;
    private byte[] description;

    @Id
    @Column(name = "idWork")
    public int getIdWork() {
        return idWork;
    }

    public void setIdWork(int idWork) {
        this.idWork = idWork;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Work work = (Work) o;

        if (idWork != work.idWork) return false;
        if (title != null ? !title.equals(work.title) : work.title != null) return false;
        if (!Arrays.equals(description, work.description)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWork;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(description);
        return result;
    }
}
