package jp.co.vermore.mapper;

import jp.co.vermore.entity.TeamDetail;

import java.util.List;

public interface TeamDetailMapper {

    int insertDetailTeam(TeamDetail teamDetail);

    int deleteDetailTeam(TeamDetail teamDetail);

    int updateDetailTeam(TeamDetail teamDetail);

    String getTeamDetail(long id);

    List<TeamDetail> getTeamDetailAll(Long id);

    TeamDetail getStudioTeamDetail(Long id);
}