package model.ddbb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ramon on 12/04/2016.
 */
public class SubtitleCreatedByUserPK implements Serializable {
    private int subtitleIdSubtitle;
    private int userIdUser;

    @Column(name = "Subtitle_idSubtitle")
    @Id
    public int getSubtitleIdSubtitle() {
        return subtitleIdSubtitle;
    }

    public void setSubtitleIdSubtitle(int subtitleIdSubtitle) {
        this.subtitleIdSubtitle = subtitleIdSubtitle;
    }

    @Column(name = "User_idUser")
    @Id
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

        SubtitleCreatedByUserPK that = (SubtitleCreatedByUserPK) o;

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
