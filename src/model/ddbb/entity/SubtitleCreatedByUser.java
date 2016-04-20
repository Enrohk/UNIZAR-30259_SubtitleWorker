package model.ddbb.entity;

import javax.persistence.*;

/**
 * Created by ramon on 12/04/2016.
 */
@Entity
@Table(name = "subtitle_created_by_user", schema = "subtitleworkerdb", catalog = "")
@IdClass(SubtitleCreatedByUserPK.class)
public class SubtitleCreatedByUser {
    private int subtitleIdSubtitle;
    private int userIdUser;

    @Id
    @Column(name = "Subtitle_idSubtitle")
    public int getSubtitleIdSubtitle() {
        return subtitleIdSubtitle;
    }

    public void setSubtitleIdSubtitle(int subtitleIdSubtitle) {
        this.subtitleIdSubtitle = subtitleIdSubtitle;
    }

    @Id
    @Column(name = "User_idUser")
    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubtitleCreatedByUser that = (SubtitleCreatedByUser) o;

        if (subtitleIdSubtitle != that.subtitleIdSubtitle) return false;
        if (userIdUser != that.userIdUser) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subtitleIdSubtitle;
        result = 31 * result + userIdUser;
        return result;
    }
}
