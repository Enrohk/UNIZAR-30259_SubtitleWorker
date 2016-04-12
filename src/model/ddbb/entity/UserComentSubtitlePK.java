package model.ddbb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ramon on 12/04/2016.
 */
public class UserComentSubtitlePK implements Serializable {
    private int userIdUser;
    private int subtitleIdSubtitle;

    @Column(name = "User_idUser")
    @Id
    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Column(name = "Subtitle_idSubtitle")
    @Id
    public int getSubtitleIdSubtitle() {
        return subtitleIdSubtitle;
    }

    public void setSubtitleIdSubtitle(int subtitleIdSubtitle) {
        this.subtitleIdSubtitle = subtitleIdSubtitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserComentSubtitlePK that = (UserComentSubtitlePK) o;

        if (userIdUser != that.userIdUser) return false;
        if (subtitleIdSubtitle != that.subtitleIdSubtitle) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userIdUser;
        result = 31 * result + subtitleIdSubtitle;
        return result;
    }
}
