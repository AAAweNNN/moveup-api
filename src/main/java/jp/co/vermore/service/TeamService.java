package jp.co.vermore.service;

import jp.co.vermore.common.Constant;
import jp.co.vermore.common.util.DateUtil;
import jp.co.vermore.common.util.StringUtil;
import jp.co.vermore.entity.Team;
import jp.co.vermore.entity.TeamDetail;
import jp.co.vermore.form.admin.TeamForm;
import jp.co.vermore.form.admin.TeamListForm;
import jp.co.vermore.mapper.TeamDetailMapper;
import jp.co.vermore.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * TeamService
 * Created by wubin.
 * <p>
 * DateTime: 2018/03/03 11:13
 * Copyright: sLab, Corp
 */

@Service

public class TeamService {

    @Autowired
    private TeamMapper teamMapper;

    public Team getTeamByUuid(String uuid) {
        Team entity = teamMapper.getTeamByUuid(uuid);
        return entity;
    }

    public List<Team> getTeamAll() {
        List<Team> teamList = teamMapper.getTeamAll();
        return teamList;
    }

    public List<Team> getTeamAllForTop() {
        String nowMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
//        String now= DateUtil.dateToStringyyyy_MM_dd_HH_mm(new Date(System.currentTimeMillis()));
        List<Team> teamList = teamMapper.getTeamAllForTop(nowMin, nextMin);
        return teamList;
    }

    public List<Team> getTeamCategory(int type, int limit, int offset) {
        List<Team> teamList = teamMapper.getTeamCategory(type, limit, offset);
        return teamList;
    }

    public List<Team> getTeamPre(Date date) {
        String nowMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Team> team = teamMapper.getTeamPre(date, nowMin, nextMin);
        return team;
    }

    public List<Team> getTeamNext(Date date) {
        String nowMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Team> team = teamMapper.getTeamNext(date, nowMin, nextMin);
        return team;
    }

    public List<Team> getTeamAll(int type, int limit, int offset) {
        String nowMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Team> teamList = teamMapper.getTeamJsonAll(type, nowMin, nextMin, limit, offset);
        return teamList;
    }

    public List<Team> getTeamAllByType(int type) {
        String nowMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Team> teamList = teamMapper.getTeamJsonAllByType(type, nowMin, nextMin);
        return teamList;
    }

    public Team getTeamByIdAndType(long id, int type) {
        Team team = teamMapper.getTeamByIdAndType(id, type);
        return team;
    }

    public List<Team> getTeamEventAll(int type1, int type2, int limit, int offset) {
        String today = DateUtil.getYyyyMMdd();
        String tomorrow = DateUtil.getTomorrow();
        List<Team> teamList = teamMapper.getTeamEventAll(type1, type2, tomorrow, today, limit, offset);
        return teamList;
    }

    private List<Team> convertTo(List<Team> demoList) {
        List<Team> resultList = new LinkedList<Team>();
        for (Team entity : demoList) {
            resultList.add(entity);
        }
        return resultList;
    }

    @Autowired
    private TeamMapper addTeamMapper;

    public long insertTeam(TeamForm teamForm) {
        Team team = new Team();
        String uuid = "";
        int flagUuid = 0;
        int cntSelect = 0;
        while (flagUuid != 1 && cntSelect < 100) {
            uuid = StringUtil.getUuid();
            if (getTeamByUuid(uuid) == null) {
                flagUuid = 1;
            }
            cntSelect++;
        }

        team.setUuid(uuid);
        String date = teamForm.getDate();
        team.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T", " ")));
        team.setTitle(teamForm.getTitle());
        team.setType(teamForm.getType());
        team.setSortScore(teamForm.getSortScore());
        team.setExcerpt(teamForm.getExcerpt());
        if (teamForm.getPublishStart() == null || "".equals(teamForm.getPublishStart())) {
            team.setPublishStart(DateUtil.getDefaultDate());
        } else {
            team.setPublishStart(DateUtil.stringToDateyyyy_MM_dd_HH_mm(teamForm.getPublishStart().replace("T", " ")));
        }
        if (teamForm.getPublishEnd() == null || "".equals(teamForm.getPublishEnd())) {
            team.setPublishEnd(DateUtil.getDefaultPublishEnd());
        } else {
            team.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd_HH_mm(teamForm.getPublishEnd().replace("T", " ")));
        }
        team.setCreateDatetime(new Date(System.currentTimeMillis()));
        team.setDelFlg(Boolean.FALSE);
        team.setNote(Constant.EMPTY_STRING);
        addTeamMapper.insertTeam(team);
        return team.getId();
    }

    public long insertStudioTeam(TeamForm teamForm) {
        Team team = new Team();
        String uuid = "";
        int flagUuid = 0;
        int cntSelect = 0;
        while (flagUuid != 1 && cntSelect < 100) {
            uuid = StringUtil.getUuid();
            if (getTeamByUuid(uuid) == null) {
                flagUuid = 1;
            }
            cntSelect++;
        }

        team.setUuid(uuid);
        String date = teamForm.getDate();
        team.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        team.setTitle(teamForm.getTitle());
        team.setType(teamForm.getType());
        team.setSortScore(teamForm.getSortScore());
        team.setExcerpt(teamForm.getExcerpt());
        if (teamForm.getPublishStart() == null || "".equals(teamForm.getPublishStart())) {
            team.setPublishStart(DateUtil.getDefaultDate());
        } else {
            team.setPublishStart(DateUtil.stringToDateyyyy_MM_dd(teamForm.getPublishStart()));
        }
        if (teamForm.getPublishEnd() == null || "".equals(teamForm.getPublishEnd())) {
            team.setPublishEnd(DateUtil.getDefaultPublishEnd());
        } else {
            team.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd(teamForm.getPublishEnd()));
        }
        team.setCreateDatetime(new Date(System.currentTimeMillis()));
        team.setDelFlg(Boolean.FALSE);
        team.setNote(Constant.EMPTY_STRING);
        addTeamMapper.insertTeam(team);
        return team.getId();
    }

    @Autowired
    private TeamDetailMapper teamDetailMapper;

    public long insertDetailTeam(TeamForm teamForm, long teamId) {
        TeamDetail teamDetail = new TeamDetail();
        teamDetail.setTeamId(teamId);
        String date = teamForm.getDate();
        teamDetail.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T", " ")));
        teamDetail.setTitle(teamForm.getTitle());
        teamDetail.setType(teamForm.getType());
        teamDetail.setDetail(teamForm.getDetail());
        teamDetail.setCreateDatetime(new Date(System.currentTimeMillis()));
        teamDetail.setDelFlg(Boolean.FALSE);
        teamDetail.setNote(Constant.EMPTY_STRING);
        teamDetailMapper.insertDetailTeam(teamDetail);
        return teamDetail.getId();
    }

    public long insertDetailStudioTeam(TeamForm teamForm, long teamId) {
        TeamDetail teamDetail = new TeamDetail();
        teamDetail.setTeamId(teamId);
        String date = teamForm.getDate();
        teamDetail.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        teamDetail.setTitle(teamForm.getTitle());
        teamDetail.setType(teamForm.getType());
        teamDetail.setDetail(teamForm.getDetail());
        teamDetail.setCreateDatetime(new Date(System.currentTimeMillis()));
        teamDetail.setDelFlg(Boolean.FALSE);
        teamDetail.setNote(Constant.EMPTY_STRING);
        teamDetailMapper.insertDetailTeam(teamDetail);
        return teamDetail.getId();
    }

    public int deleteTeam(TeamForm teamForm) {
        Team team = new Team();
        team.setId(teamForm.getId());
        team.setDelFlg(Boolean.TRUE);
        int count = teamMapper.deleteTeam(team);
        System.out.println(count);
        return count;
    }

    public int deleteDetailTeam(TeamForm teamForm) {
        TeamDetail teamDetail = new TeamDetail();
        teamDetail.setTeamId(teamForm.getId());
        teamDetail.setDelFlg(Boolean.TRUE);
        int count = teamDetailMapper.deleteDetailTeam(teamDetail);
        return count;
    }

    public int updateTeam(TeamForm teamForm) {
        Team team = new Team();
        team.setId(teamForm.getId());
        String date = teamForm.getDate();
        team.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T", " ")));
        team.setTitle(teamForm.getTitle());
        team.setType(teamForm.getType());
        team.setSortScore(teamForm.getSortScore());
        team.setExcerpt(teamForm.getExcerpt());
        if (teamForm.getPublishStart() == null || "".equals(teamForm.getPublishStart())) {
            team.setPublishStart(DateUtil.getDefaultDate());
        } else {
            team.setPublishStart(DateUtil.stringToDateyyyy_MM_dd_HH_mm(teamForm.getPublishStart().replace("T", " ")));
        }
        if (teamForm.getPublishEnd() == null || "".equals(teamForm.getPublishEnd())) {
            team.setPublishEnd(DateUtil.getDefaultPublishEnd());
        } else {
            team.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd_HH_mm(teamForm.getPublishEnd().replace("T", " ")));
        }
        team.setUpdateDatetime(new Date(System.currentTimeMillis()));
        team.setDelFlg(Boolean.FALSE);
        team.setNote(Constant.EMPTY_STRING);
        int count = teamMapper.updateTeam(team);
        return count;
    }

    public int updateStudioTeam(TeamForm teamForm) {
        Team team = new Team();
        team.setId(teamForm.getId());
        String date = teamForm.getDate();
        team.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        team.setTitle(teamForm.getTitle());
        team.setType(teamForm.getType());
        team.setSortScore(teamForm.getSortScore());
        team.setExcerpt(teamForm.getExcerpt());
        if (teamForm.getPublishStart() == null || "".equals(teamForm.getPublishStart())) {
            team.setPublishStart(DateUtil.getDefaultDate());
        } else {
            team.setPublishStart(DateUtil.stringToDateyyyy_MM_dd(teamForm.getPublishStart()));
        }
        if (teamForm.getPublishEnd() == null || "".equals(teamForm.getPublishEnd())) {
            team.setPublishEnd(DateUtil.getDefaultPublishEnd());
        } else {
            team.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd(teamForm.getPublishEnd()));
        }
        team.setUpdateDatetime(new Date(System.currentTimeMillis()));
        team.setDelFlg(Boolean.FALSE);
        team.setNote(Constant.EMPTY_STRING);
        int count = teamMapper.updateTeam(team);
        return count;
    }

    public int updateDetailTeam(TeamForm teamForm) {
        TeamDetail teamDetail = new TeamDetail();
        teamDetail.setTeamId(teamForm.getId());
        String date = teamForm.getDate();
        teamDetail.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T", " ")));
        teamDetail.setTitle(teamForm.getTitle());
        teamDetail.setType(teamForm.getType());
        teamDetail.setDetail(teamForm.getDetail());
        teamDetail.setUpdateDatetime(new Date(System.currentTimeMillis()));
        teamDetail.setDelFlg(Boolean.FALSE);
        teamDetail.setNote(Constant.EMPTY_STRING);
        int count = teamDetailMapper.updateDetailTeam(teamDetail);
        return count;
    }

    public int updateDetailStudioTeam(TeamForm teamForm) {
        TeamDetail teamDetail = new TeamDetail();
        teamDetail.setTeamId(teamForm.getId());
        String date = teamForm.getDate();
        teamDetail.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        teamDetail.setTitle(teamForm.getTitle());
        teamDetail.setType(teamForm.getType());
        teamDetail.setDetail(teamForm.getDetail());
        teamDetail.setUpdateDatetime(new Date(System.currentTimeMillis()));
        teamDetail.setDelFlg(Boolean.FALSE);
        teamDetail.setNote(Constant.EMPTY_STRING);
        int count = teamDetailMapper.updateDetailTeam(teamDetail);
        return count;
    }

    public List<Team> getTeamList(long id) {
        List<Team> teamList = teamMapper.getTeamList(id);
        return teamList;
    }

    public String getTeamDetail(long id) {
        String detail = teamDetailMapper.getTeamDetail(id);
        return detail;
    }

    public List<TeamDetail> getTeamDetailAll(Long id) {
        List<TeamDetail> teamDetail = teamDetailMapper.getTeamDetailAll(id);
        List<TeamDetail> resultList = convertToDetail(teamDetail);
        return resultList;
    }

    private List<TeamDetail> convertToDetail(List<TeamDetail> demoList) {
        List<TeamDetail> resultList = new LinkedList<TeamDetail>();
        for (TeamDetail entity : demoList) {
            resultList.add(entity);
        }
        return resultList;
    }

    public List<Team> getTeamAllByCondition(TeamListForm form) {
        List<Team> team = teamMapper.getTeamAllByCondition(form);
        return team;
    }

    public int getTeamCountByCondition(TeamListForm form) {
        return teamMapper.getTeamCountByCondition(form);
    }

    public int getTeamCount() {
        return teamMapper.getTeamCount();
    }

    public List<Team> getStudioTeamALL(int type) {
        List<Team> team = teamMapper.getStudioTeamALL(type);
        return team;
    }
}