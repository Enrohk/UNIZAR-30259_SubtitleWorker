package model.ddbb.entity;

import javax.persistence.*;

/**
 * Created by ramon on 12/04/2016.
 */
@Entity
@Table(name = "user_coment_subtitle", schema = "subtitleworkerdb", catalog = "")
@IdClass(UserComentSubtitlePK.class)
public class UserComentSubtitle {
    private int userIdUser;
    private int subtitleIdSubtitle;
    private String text;
    private String punt;

    @Id
    @Column(name = "User_idUser")
    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Id
    @Column(name = "Subtitle_idSubtitle")
    public int getSubtitleIdSubtitle() {
        return subtitleIdSubtitle;
    }

    public void setSubtitleIdSubtitle(int subtitleIdSubtitle) {
        this.subtitleIdSubtitle = subtitleIdSubtitle;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "punt")
    public String getPunt() {
        return punt;
    }

    public void setPunt(String punt) {
        this.punt = punt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserComentSubtitle that = (UserComentSubtitle) o;

        if (userIdUser != that.userIdUser) return false;
        if (subtitleIdSubtitle != that.subtitleIdSubtitle) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (punt != null ? !punt.equals(that.punt) : that.punt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userIdUser;
        result = 31 * result + subtitleIdSubtitle;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (punt != null ? punt.hashCode() : 0);
        return result;
    }
}
