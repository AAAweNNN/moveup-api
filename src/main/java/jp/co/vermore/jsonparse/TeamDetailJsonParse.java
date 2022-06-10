package jp.co.vermore.jsonparse;

import jp.co.vermore.common.mvc.BaseJsonParse;

import java.util.List;

/**
 * TeamDetailJsonParse
 * Created by wubin.
 * <p>
 * DateTime: 2018/03/13 16:52
 * Copyright: sLab, Corp
 */

public class TeamDetailJsonParse extends BaseJsonParse {

    private Long teamId;

    private String entry;

    private String date;

    private String typeStr;

    private int type;

    private String color;

    private String title;

    private String detail;

    private List<String> topPic;

    private List<String> footPic;

    private List<TeamJsonParse> teamPre;

    private List<TeamJsonParse> teamNext;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<TeamJsonParse> getTeamPre() {
        return teamPre;
    }

    public void setTeamPre(List<TeamJsonParse> teamPre) {
        this.teamPre = teamPre;
    }

    public List<TeamJsonParse> getTeamNext() {
        return teamNext;
    }

    public void setTeamNext(List<TeamJsonParse> teamNext) {
        this.teamNext = teamNext;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public List<String> getTopPic() {
        return topPic;
    }

    public void setTopPic(List<String> topPic) {
        this.topPic = topPic;
    }

    public List<String> getFootPic() {
        return footPic;
    }

    public void setFootPic(List<String> footPic) {
        this.footPic = footPic;
    }
}
