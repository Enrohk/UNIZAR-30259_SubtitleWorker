package controller.ddbb.dto;

import model.ddbb.entity.UserComentSubtitle;

public class CommentDTO {

    private int authorId;
    private String text;
    private int rate;
    private int idSubtitle;
    private String author;

    public String getAuthor() {
        return author;
    }

    public int getAuthorId() {

        return authorId;
    }

    public void setIdSubtitle(int idSubtitle) {
        this.idSubtitle = idSubtitle;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public UserComentSubtitle getUserCommentSubtitle() {
        UserComentSubtitle ucs = new UserComentSubtitle();
        ucs.setText(text);
        ucs.setPunt(String.valueOf(rate));
        ucs.setSubtitleIdSubtitle(idSubtitle);
        ucs.setUserIdUser(authorId);
        return ucs;
    }
}
