package jp.co.vermore.jsonparse;

import jp.co.vermore.common.mvc.BaseJsonParse;

/**
 * TeamJsonParse
 * Created by wubin.
 * <p>
 * DateTime: 2018/03/07 13:25
 * Copyright: sLab, Corp
 */

public class TeamJsonParse extends BaseJsonParse {

    private String uuid;

    private String date;

    private String type;

    private String color;

    private String title;

    private String excerpt;

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

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
