package jp.co.vermore.controller;

import jp.co.vermore.common.Constant;
import jp.co.vermore.common.JsonObject;
import jp.co.vermore.common.JsonStatus;
import jp.co.vermore.common.mvc.BaseController;
import jp.co.vermore.common.util.DateUtil;
import jp.co.vermore.entity.EntryMail;
import jp.co.vermore.entity.Pic;
import jp.co.vermore.entity.Team;
import jp.co.vermore.entity.TeamDetail;
import jp.co.vermore.jsonparse.TeamDetailJsonParse;
import jp.co.vermore.jsonparse.TeamJsonParse;
import jp.co.vermore.service.EntryService;
import jp.co.vermore.service.PicService;
import jp.co.vermore.service.TeamService;
import jp.co.vermore.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TeamController
 * Created by wubin.
 * <p>
 * DateTime: 2018/03/03 11:13
 * Copyright: sLab, Corp
 */
@Controller
public class TeamController extends BaseController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private EntryService entryService;

    @Autowired
    private PicService picService;

    @Autowired
    private WidgetService widgetService;

    @Value(value = "${hosturl}")
    private String hosturl;

    //eg: http://localhost:8081/moveup_war/api/team/list/0/1/0/
    @RequestMapping(value = "/api/team/list/{type}/{limit}/{offset}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getTeamList(@PathVariable int type, @PathVariable int limit, @PathVariable int offset) {
        List<Team> list = teamService.getTeamAll(type, limit, offset);
        List<Team> countlist = teamService.getTeamAllByType(type);
        List<TeamJsonParse> ejpList = new ArrayList<>();
        ejpList = list(ejpList, list);
        Map<String, Object> map = new HashMap<>();
        map.put("teamList", ejpList);
        map.put("count", countlist.size());
        jsonObject.setResultList(map);
        return jsonObject;
    }

    //eg:http://localhost:8081/moveup_war/api/team/list/0/1/1/0/
    @RequestMapping(value = "/api/team/list/{type1}/{type2}/{limit}/{offset}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getTeamEventList(@PathVariable int type1, @PathVariable int type2, @PathVariable int limit, @PathVariable int offset) {
        List<Team> list = teamService.getTeamEventAll(type1, type2, limit, offset);
        List<TeamJsonParse> ejpList = new ArrayList<>();
        ejpList = list(ejpList, list);
        Map<String, Object> map = new HashMap<>();
        map.put("teamList", ejpList);
        map.put("count", ejpList.size());
        jsonObject.setResultList(map);
        return jsonObject;
    }

    //eg:http://localhost:8081/moveup_war/api/team/detail/4hIZRgPJFu/
    @RequestMapping(value = "/api/team/detail/{uuid}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getTeamDetailList(@PathVariable String uuid) {
        Team team = teamService.getTeamByUuid(uuid);
        List<TeamDetailJsonParse> ejpList = new ArrayList<>();
        List<TeamDetail> list = teamService.getTeamDetailAll(team.getId());
        TeamDetailJsonParse ejp = new TeamDetailJsonParse();
        if (list.size() > 0) {
            for (TeamDetail ed : list) {
                ejp.setTeamId(ed.getTeamId());
                ejp.setTitle(ed.getTitle());
                ejp.setDate(DateUtil.dateToStringyyyy_MM_dd(ed.getDate()));
                ejp.setTypeStr(widgetService.getTeamType(ed.getType()));
                ejp.setType(ed.getType());
                ejp.setColor(widgetService.getTeamColor(ed.getType()));
                ejp.setDetail(ed.getDetail());

                Pic topPic = new Pic();
                List<Pic> topPicList = picService.getPic(ed.getTeamId(), Constant.EVENT_PIC_TYPE.NEWS_TOP);
                List<String> topList = new ArrayList<String>();
                for (Pic pic : topPicList) {
                    topList.add(pic.getPicUrl());
                }
                ejp.setTopPic(topList);

                List<Pic> footPicList = picService.getPic(ed.getTeamId(), Constant.EVENT_PIC_TYPE.NEWS_FOOT);
                List<String> footList = new ArrayList<String>();
                for (Pic pic : footPicList) {
                    footList.add(pic.getPicUrl());
                }
                ejp.setFootPic(footList);
                List<Team> listPre = teamService.getTeamPre(ed.getDate());
                List<Team> listNext = teamService.getTeamNext(ed.getDate());
                List<TeamJsonParse> ejpListPre = new ArrayList<>();
                List<TeamJsonParse> ejpListNext = new ArrayList<>();
                ejpListPre = list(ejpListPre, listPre);
                ejpListNext = list(ejpListNext, listNext);
                if (listPre.size() > 0) {
                    ejpListPre.get(0).setColor(widgetService.getTeamDetailColor(listPre.get(0).getType()));
                }
                if (listNext.size() > 0) {
                    ejpListNext.get(0).setColor(widgetService.getTeamDetailColor(listNext.get(0).getType()));
                }
                ejp.setTeamPre(ejpListPre);
                ejp.setTeamNext(ejpListNext);
                ejpList.add(ejp);
            }

            int type = 0;
            if (team.getType() == Constant.NEWS_TYPE.EVENT) {
                type = Constant.NEWS_TYPE.MOVEUP;
            } else if (team.getType() == Constant.NEWS_TYPE.MOVEUP) {
                type = Constant.NEWS_TYPE.EVENT;
            }

            EntryMail entryMail = entryService.getEntryMailByEntryIdAndType(team.getId(), type);
            if (entryMail != null) {
                Date startTime = entryMail.getPublishStart();
                Date endTime = entryMail.getPublishEnd();
                Date nowTime = new Date(System.currentTimeMillis());
                if (nowTime.getTime() >= startTime.getTime() && nowTime.getTime() <= endTime.getTime()) {
                    ejp.setEntry("1");//応募可能
                } else {
                    ejp.setEntry(null);
                }
            } else {
                ejp.setEntry(null);
            }
            jsonObject.setResultList(ejpList);
        } else {
            jsonObject.setResultList(null);
        }
        return jsonObject;
    }

    private List<TeamJsonParse> list(List<TeamJsonParse> jpList, List<Team> list) {

        for (Team nd : list) {
            TeamJsonParse njp = new TeamJsonParse();
            njp.setUuid(nd.getUuid());
            njp.setTitle(nd.getTitle());
            njp.setDate(DateUtil.dateToStringyyyy_MM_dd(nd.getDate()));
            njp.setType(widgetService.getTeamType(nd.getType()));
            njp.setColor(widgetService.getTeamColor(nd.getType()));
            njp.setExcerpt(nd.getExcerpt());
            jpList.add(njp);
        }
        return jpList;
    }

    // Team detail for sns
    //eg:http://localhost:8081/moveup_war/sns/teamDetail/4hIZRgPJFu/
    @RequestMapping(value = "/sns/teamDetail/{uuid}/", method = RequestMethod.GET)
    public Object getTeamSNSDetail(@PathVariable String uuid, Model model, HttpServletRequest hsr) {

        Team team = teamService.getTeamByUuid(uuid);
        List<TeamDetail> teamDetailList = teamService.getTeamDetailAll(team.getId());
        if (teamDetailList.size() > 0) {
            TeamDetail teamDetail = teamDetailList.get(0);

            model.addAttribute("title", teamDetail.getTitle());
            model.addAttribute("url", "https://www.japanmoveupwest.com" + "/teamDetail/" + team.getUuid() + "/");
            model.addAttribute("desc", team.getExcerpt());
            model.addAttribute("image", "");
        }

        String userAgent = hsr.getHeader("User-Agent");
        BaseController.logger.debug("-------user-agent=" + userAgent);

        String regex = "facebookexternalhit|Facebot|Twitterbot|Pinterest|Google.*snippet";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(userAgent);
        if (m.find()) {
            BaseController.logger.debug("-------tosns");
            return "sns";
        } else {
            BaseController.logger.debug("-------tourl");
            return "redirect:" + hosturl + "/teamDetail/" + uuid + "/";
        }
    }

    // Team detail for sns
    //eg:http://localhost:8081/moveup_war/api/sns/teamDetail/app/4hIZRgPJFu/
    @RequestMapping(value = "/api/sns/teamDetail/app/{uuid}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getTeamDetailSNSForApp(@PathVariable String uuid) {

        Map<String, Object> urlMap = new HashMap<String, Object>();
        urlMap.put("twitter", "https://twitter.com/share?url=" + hosturl + "/teamDetail/" + uuid + "/");
        urlMap.put("facebook", "https://www.facebook.com/sharer/sharer.php?u=" + hosturl + "/teamDetail/" + uuid + "/");

        jsonObject.setResultList(urlMap);
        jsonObject.setStatus(JsonStatus.SUCCESS);
        return jsonObject;
    }
}