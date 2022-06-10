package jp.co.vermore.form.admin;

import jp.co.vermore.common.mvc.BaseForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public class TeamForm extends BaseForm {

    private Long id;

    private String uuid;

    private String date;

    private Byte type;

    private String title;

    private String excerpt;

    private Integer sortScore;

    private String detail;

    private String publishStart;

    private String publishEnd;

    private Date createDatetime;

    private Date updateDatetime;

    private Boolean delFlg;

    private String note;

    private String picUrl;

    private List<String> picUrl1;

    private List<String> picUrl2;

    private MultipartFile picFile;

    private MultipartFile[] picFile1;

    private MultipartFile[] picFile2;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public List<String> getPicUrl1() {
        return picUrl1;
    }

    public void setPicUrl1(List<String> picUrl1) {
        this.picUrl1 = picUrl1;
    }

    public MultipartFile getPicFile() {
        return picFile;
    }

    public void setPicFile(MultipartFile picFile) {
        this.picFile = picFile;
    }

    public MultipartFile[] getPicFile1() {
        return picFile1;
    }

    public void setPicFile1(MultipartFile[] picFile1) {
        this.picFile1 = picFile1;
    }

    public MultipartFile[] getPicFile2() {
        return picFile2;
    }

    public void setPicFile2(MultipartFile[] picFile2) {
        this.picFile2 = picFile2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public Integer getSortScore() {
        return sortScore;
    }

    public void setSortScore(Integer sortScore) {
        this.sortScore = sortScore;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPublishStart() {
        return publishStart;
    }

    public void setPublishStart(String publishStart) {
        this.publishStart = publishStart;
    }

    public String getPublishEnd() {
        return publishEnd;
    }

    public void setPublishEnd(String publishEnd) {
        this.publishEnd = publishEnd;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<String> getPicUrl2() {
        return picUrl2;
    }

    public void setPicUrl2(List<String> picUrl2) {
        this.picUrl2 = picUrl2;
    }

}
