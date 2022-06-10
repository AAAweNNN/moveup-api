package jp.co.vermore.service;

import jp.co.vermore.common.Constant;
import org.springframework.stereotype.Service;

/**
 * WidgetService
 * Created by wubin.
 * <p>
 * DateTime: 2018/04/12 9:08
 * Copyright: sLab, Corp
 */
@Service
public class WidgetService {

    public String getGender(int genderNum) {
        String gender = "";
        if (genderNum == Constant.PERSON_GENDER.UNKNOW) {
            gender = "不明";
        } else if (genderNum == Constant.PERSON_GENDER.MALE) {
            gender = "男性";
        } else if (genderNum == Constant.PERSON_GENDER.FEMALE) {
            gender = "女性";
        }
        return gender;
    }

    public String getCareer(int careerNum) {
        String career = "";
        if (careerNum == Constant.CAREER.JUNIOR_STUDENT) {
            career = "中学生";
        } else if (careerNum == Constant.CAREER.SENIOR_STUDENT) {
            career = "高校生";
        } else if (careerNum == Constant.CAREER.COLLEGE_STUDENT) {
            career = "専門学生";
        } else if (careerNum == Constant.CAREER.UNIVERSITY_STUDENT) {
            career = "大学生";
        } else if (careerNum == Constant.CAREER.CIVIL_SERVANT) {
            career = "公務員";
        } else if (careerNum == Constant.CAREER.SELF_EMPLOYED) {
            career = "自営業";
        } else if (careerNum == Constant.CAREER.EMPLOYEE) {
            career = "会社役員";
        } else if (careerNum == Constant.CAREER.TEMPORARY) {
            career = "会社員";
        } else if (careerNum == Constant.CAREER.DISPATCHED) {
            career = "派遣社員";
        } else if (careerNum == Constant.CAREER.CONTRACT) {
            career = "契約社員";
        } else if (careerNum == Constant.CAREER.HOUSE_WIFE) {
            career = "専業主婦";
        } else if (careerNum == Constant.CAREER.HOUSE_HUSBAND) {
            career = "専業主夫";
        } else if (careerNum == Constant.CAREER.ARBEIT) {
            career = "パート・アルバイト";
        } else if (careerNum == Constant.CAREER.OTHER) {
            career = "その他";
        } else if (careerNum == 0) {
            career = "職業を選択";
        }
        return career;
    }

    public int getGenderNUm(String gender) {
        int genderNum = 0;
        if (gender.equals("不明")) {
            genderNum = Constant.PERSON_GENDER.UNKNOW;
        } else if (gender.equals("男性")) {
            genderNum = Constant.PERSON_GENDER.MALE;
        } else if (gender.equals("女性")) {
            genderNum = Constant.PERSON_GENDER.FEMALE;
        }
        return genderNum;
    }

    public int getCareerNum(String career) {
        int careerNum = 0;
        if (career.equals("中学生")) {
            careerNum = Constant.CAREER.JUNIOR_STUDENT;
        } else if (career.equals("高校生")) {
            careerNum = Constant.CAREER.SENIOR_STUDENT;
        } else if (career.equals("専門学生")) {
            careerNum = Constant.CAREER.COLLEGE_STUDENT;
        } else if (career.equals("大学生")) {
            careerNum = Constant.CAREER.UNIVERSITY_STUDENT;
        } else if (career.equals("公務員")) {
            careerNum = Constant.CAREER.CIVIL_SERVANT;
        } else if (career.equals("自営業")) {
            careerNum = Constant.CAREER.SELF_EMPLOYED;
        } else if (career.equals("会社役員")) {
            careerNum = Constant.CAREER.EMPLOYEE;
        } else if (career.equals("会社員")) {
            careerNum = Constant.CAREER.TEMPORARY;
        } else if (career.equals("派遣社員")) {
            careerNum = Constant.CAREER.DISPATCHED;
        } else if (career.equals("契約社員")) {
            careerNum = Constant.CAREER.CONTRACT;
        } else if (career.equals("専業主婦")) {
            careerNum = Constant.CAREER.HOUSE_WIFE;
        } else if (career.equals("専業主夫")) {
            careerNum = Constant.CAREER.HOUSE_HUSBAND;
        } else if (career.equals("パート・アルバイト")) {
            careerNum = Constant.CAREER.ARBEIT;
        } else if (career.equals("その他")) {
            careerNum = Constant.CAREER.OTHER;
        } else if (career.equals("職業を選択")) {
            careerNum = 0;
        }
        return careerNum;
    }

    public String getNewsType(int newsTypeNum) {
        String category = "";
        if (newsTypeNum == Constant.NEWS_TYPE.UNKNOW) {
            category = "不明";
        } else if (newsTypeNum == Constant.NEWS_TYPE.MOVEUP) {
            category = "MOVEUP";
        } else if (newsTypeNum == Constant.NEWS_TYPE.EVENT) {
            category = "EVENT";
        } else if (newsTypeNum == Constant.NEWS_TYPE.NEWS) {
            category = "NEWS";
        } else if (newsTypeNum == Constant.NEWS_TYPE.ENTRY) {
            category = "EVENT";
        }
        return category;
    }

    public String getTeamType(int teamTypeNum) {
        String category = "";
        if (teamTypeNum == Constant.NEWS_TYPE.UNKNOW) {
            category = "不明";
        } else if (teamTypeNum == Constant.TEAM_TYPE.MOVEUP) {
            category = "MOVEUP";
        } else if (teamTypeNum == Constant.TEAM_TYPE.EVENT) {
            category = "EVENT";
        } else if (teamTypeNum == Constant.TEAM_TYPE.TEAM) {
            category = "NEWS";
        } else if (teamTypeNum == Constant.TEAM_TYPE.ENTRY) {
            category = "EVENT";
        }
        return category;
    }


    /**
     * 楊20210316レポート機能追加
     *
     * @param reportTypeNum
     * @return
     */
    public String getReportType(int reportTypeNum) {
        String category = "";
        if (reportTypeNum == Constant.REPORT_TYPE.UNKNOW) {
            category = "不明";
        } else if (reportTypeNum == Constant.REPORT_TYPE.MOVEUP) {
            category = "MOVEUP";
        } else if (reportTypeNum == Constant.REPORT_TYPE.EVENT) {
            category = "EVENT";
        } else if (reportTypeNum == Constant.REPORT_TYPE.REPORT) {
            category = "REPORT";
        } else if (reportTypeNum == Constant.REPORT_TYPE.ENTRY) {
            category = "EVENT";
        }
        return category;
    }

    public String getEntryType(int entryTypeNum) {
        String type = "";
        if (entryTypeNum == Constant.ENTRY__MAIL_TYPE.UNKNOW) {
            type = "不明";
        } else if (entryTypeNum == Constant.ENTRY__MAIL_TYPE.NEWS_MOVEUP) {
            type = "NEWS-MOVEUP";
        } else if (entryTypeNum == Constant.ENTRY__MAIL_TYPE.NEWS_EVENT) {
            type = "NEWS-EVENT";
        } else if (entryTypeNum == Constant.ENTRY__MAIL_TYPE.EVENT) {
            type = "EVENT";
        }
        return type;
    }

    public String getNewsColor(int newsTypeNum) {
        String color = "";
        if (newsTypeNum == Constant.NEWS_TYPE.MOVEUP) {
            color = "background-color:red";
        } else if (newsTypeNum == Constant.NEWS_TYPE.EVENT || newsTypeNum == Constant.NEWS_TYPE.ENTRY) {
            color = "background-color:#004984";
        } else {
            color = "background-color:#009a4c";
        }
        return color;
    }

    public String getNewsDetailColor(int newsTypeNum) {
        String color = "";
        if (newsTypeNum == Constant.NEWS_TYPE.MOVEUP) {
            color = "color:red";
        } else if (newsTypeNum == Constant.NEWS_TYPE.EVENT || newsTypeNum == Constant.NEWS_TYPE.ENTRY) {
            color = "color:#004984";
        } else {
            color = "color:#009a4c";
        }
        return color;
    }

    public String getTeamColor(int teamTypeNum) {
        String color = "";
        if (teamTypeNum == Constant.TEAM_TYPE.MOVEUP) {
            color = "background-color:red";
        } else if (teamTypeNum == Constant.TEAM_TYPE.EVENT || teamTypeNum == Constant.TEAM_TYPE.ENTRY) {
            color = "background-color:#004984";
        } else {
            color = "background-color:#009a4c";
        }
        return color;
    }

    public String getTeamDetailColor(int teamTypeNum) {
        String color = "";
        if (teamTypeNum == Constant.NEWS_TYPE.MOVEUP) {
            color = "color:red";
        } else if (teamTypeNum == Constant.NEWS_TYPE.EVENT || teamTypeNum == Constant.NEWS_TYPE.ENTRY) {
            color = "color:#004984";
        } else {
            color = "color:#009a4c";
        }
        return color;
    }


    /**
     * 20210317 楊レポート機能追加
     *
     * @param reportTypeNum
     * @return
     */
    public String getReportColor(int reportTypeNum) {
        String color = "";
        if (reportTypeNum == Constant.REPORT_TYPE.MOVEUP) {
            color = "background-color:red";
        } else if (reportTypeNum == Constant.REPORT_TYPE.EVENT || reportTypeNum == Constant.REPORT_TYPE.ENTRY) {
            color = "background-color:#004984";
        } else {
            color = "background-color:#009a4c";
        }
        return color;
    }

    /**
     * 20210317　楊レポート機能追加
     *
     * @param reportTypeNum
     * @return
     */
    public String getReportDetailColor(int reportTypeNum) {
        String color = "";
        if (reportTypeNum == Constant.REPORT_TYPE.MOVEUP) {
            color = "color:red";
        } else if (reportTypeNum == Constant.REPORT_TYPE.EVENT || reportTypeNum == Constant.REPORT_TYPE.ENTRY) {
            color = "color:#004984";
        } else {
            color = "color:#009a4c";
        }
        return color;
    }

    public String getInquireType(int type) {
        String typeStr = "";
        if (type == Constant.INQUIRE_TYPE.USER) {
            typeStr = "ユーザー";
        } else if (type == Constant.INQUIRE_TYPE.ADMIN) {
            typeStr = "協力店";
        }
        return typeStr;
    }

    public String getTopItemType(Byte item) {
        String itemType = "";
        if (item == 1) {
            itemType = "login";
        } else if (item == 2) {
            itemType = "news";
        } else if (item == 3) {
            itemType = "event";
        } else if (item == 4) {
            itemType = "freepaper";
        } else if (item == 5) {
            itemType = "";
        } else if (item == 6) {
            itemType = "shop";
        } else if (item == 7) {
            itemType = "place";
        } else if (item == 8) {
            itemType = "corporate info";
        } else if (item == 9) {
            itemType = "recruit";
        } else if (item == 10) {
            itemType = "goods";
        } else if (item == 11) {
            itemType = "tv";
        } else if (item == 12) {
            itemType = "jmuw";
        } else if (item == 13) {
            itemType = "jmuw web";
        } else if (item == 14) {
            itemType = "その他";
        }
        return itemType;
    }
}
