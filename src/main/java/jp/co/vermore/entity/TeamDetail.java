package jp.co.vermore.entity;

import jp.co.vermore.common.mvc.BaseEntity;

import java.util.Date;

public class TeamDetail extends BaseEntity {

    private Long id;


    private Long teamId;


    private Date date;


    private Byte type;


    private String title;


    private String detail;


    private Date publishStart;


    private Date publishEnd;


    private Date createDatetime;


    private Date updateDatetime;

    private Boolean delFlg;

    private String note;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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


    @Override
    public Date getCreateDatetime() {
        return createDatetime;
    }

    @Override
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }


    @Override
    public Date getUpdateDatetime() {
        return updateDatetime;
    }


    @Override
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }


    @Override
    public Boolean getDelFlg() {
        return delFlg;
    }


    @Override
    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }


    @Override
    public String getNote() {
        return note;
    }


    @Override
    public void setNote(String note) {
        this.note = note;
    }
}