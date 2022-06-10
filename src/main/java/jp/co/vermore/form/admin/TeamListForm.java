package jp.co.vermore.form.admin;


import java.util.Date;


public class TeamListForm extends DatatablesBaseForm {

    private Date date;

    private String type;

    private String title;

    private String sortScore;

    private String excerpt;

    private Date publishStart;

    private Date publishEnd;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getSortScore() {
        return sortScore;
    }

    public void setSortScore(String sortScore) {
        this.sortScore = sortScore;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public Date getPublishStart() {
        return publishStart;
    }

    public void setPublishStart(Date publishStart) {
        this.publishStart = publishStart;
    }

    public Date getPublishEnd() {
        return publishEnd;
    }

    public void setPublishEnd(Date publishEnd) {
        this.publishEnd = publishEnd;
    }
}
