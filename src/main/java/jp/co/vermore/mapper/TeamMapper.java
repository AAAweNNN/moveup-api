package jp.co.vermore.mapper;

import jp.co.vermore.entity.Team;
import jp.co.vermore.form.admin.TeamListForm;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TeamMapper {

    int insertTeam(Team report);

    int deleteTeam(Team report);

    int updateTeam(Team report);

    Team getTeamByUuid(String uuid);

    List<Team> getTeamAll();

    List<Team> getTeamAllForTop(String nowMin, String nextMin);

    List<Team> getTeamJsonAll(int type, String nowMin, String nextMin, int limit, int offset);

    List<Team> getTeamJsonAllByType(int type, String nowMin, String nextMin);

    Team getTeamByIdAndType(long id, int type);

    List<Team> getTeamEventAll(int type1, int type2, String tomorrow, String today, int limit, int offset);

    List<Team> getTeamList(long id);

    List<Team> getTeamPre(Date date, String nowMin, String nextMin);

    List<Team> getTeamNext(Date date, String nowMin, String nextMin);

    List<Team> getTeamCategory(int type, int limit, int offset);

    List<Team> getTeamAllByCondition(TeamListForm form);

    int getTeamCountByCondition(TeamListForm form);

    int getTeamCount();

    List<Team> getStudioTeamList(int type, int sortScore, String tomorrow, String today);

    List<Team> getStudioTeamListAll(Byte type, int limit, int offset);

    List<Team> getStudioTeamALL(int type);

    List<Team> getStudioAllByCondition(TeamListForm form);

    int getStudioCountByCondition(TeamListForm form);

    int getStudioCount();

    Team getTeamById(@Param("id") Long id);

}