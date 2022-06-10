package jp.co.vermore.controller;

import jp.co.vermore.common.Constant;
import jp.co.vermore.common.JsonObject;
import jp.co.vermore.common.JsonStatus;
import jp.co.vermore.common.mvc.BaseController;
import jp.co.vermore.common.util.DateUtil;
import jp.co.vermore.entity.EntryMail;
import jp.co.vermore.entity.Pic;
import jp.co.vermore.entity.Report;
import jp.co.vermore.entity.ReportDetail;
import jp.co.vermore.jsonparse.ReportDetailJsonParse;
import jp.co.vermore.jsonparse.ReportJsonParse;
import jp.co.vermore.service.EntryService;
import jp.co.vermore.service.PicService;
import jp.co.vermore.service.ReportService;
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
 * ReportController
 * Created by wubin.
 * <p>
 * DateTime: 2018/03/03 11:13
 * Copyright: sLab, Corp
 */
@Controller
public class ReportController extends BaseController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private EntryService entryService;

    @Autowired
    private PicService picService;

    @Autowired
    private WidgetService widgetService;

    @Value(value = "${hosturl}")
    private String hosturl;

    //eg: http://localhost:8081/moveup_war/api/report/list/0/1/0/
    @RequestMapping(value = "/api/report/list/{type}/{limit}/{offset}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getReportList(@PathVariable int type, @PathVariable int limit, @PathVariable int offset) {
        List<Report> list = reportService.getReportAll(type, limit, offset);
        List<Report> countlist = reportService.getReportAllByType(type);
        List<ReportJsonParse> ejpList = new ArrayList<>();
        ejpList = list(ejpList, list);
        Map<String, Object> map = new HashMap<>();
        map.put("reportList", ejpList);
        map.put("count", countlist.size());
        jsonObject.setResultList(map);
        return jsonObject;
    }

    //eg:http://localhost:8081/moveup_war/api/report/list/0/1/1/0/
    @RequestMapping(value = "/api/report/list/{type1}/{type2}/{limit}/{offset}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getReportEventList(@PathVariable int type1, @PathVariable int type2, @PathVariable int limit, @PathVariable int offset) {
        List<Report> list = reportService.getReportEventAll(type1, type2, limit, offset);
        List<ReportJsonParse> ejpList = new ArrayList<>();
        ejpList = list(ejpList, list);
        Map<String, Object> map = new HashMap<>();
        map.put("reportList", ejpList);
        map.put("count", ejpList.size());
        jsonObject.setResultList(map);
        return jsonObject;
    }

    //eg:http://localhost:8081/moveup_war/api/report/detail/VfWfbJc3z2/
    @RequestMapping(value = "/api/report/detail/{uuid}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getReportDetailList(@PathVariable String uuid) {
        Report report = reportService.getReportByUuid(uuid);
        List<ReportDetailJsonParse> ejpList = new ArrayList<>();
        List<ReportDetail> list = reportService.getReportDetailAll(report.getId());
        ReportDetailJsonParse ejp = new ReportDetailJsonParse();
        if (list.size() > 0) {
            
            for (ReportDetail ed : list) {
                ejp.setReportId(ed.getReportId());
                ejp.setTitle(ed.getTitle());
                ejp.setDate(DateUtil.dateToStringyyyy_MM_dd(ed.getDate()));
                ejp.setTypeStr(widgetService.getReportType(ed.getType()));
                ejp.setType(ed.getType());
                ejp.setColor(widgetService.getReportColor(ed.getType()));
                ejp.setDetail(ed.getDetail());

                Pic topPic = new Pic();
                List<Pic> topPicList = picService.getPic(ed.getReportId(), Constant.EVENT_PIC_TYPE.REPORT_TOP);
                List<String> topList = new ArrayList<String>();
                for (Pic pic : topPicList) {
                    topList.add(pic.getPicUrl());
                }
                ejp.setTopPic(topList);

                List<Pic> footPicList = picService.getPic(ed.getReportId(), Constant.EVENT_PIC_TYPE.REPORT_FOOT);
                List<String> footList = new ArrayList<String>();
                for (Pic pic : footPicList) {
                    footList.add(pic.getPicUrl());
                }
                ejp.setFootPic(footList);
                List<Report> listPre = reportService.getReportPre(ed.getDate());
                List<Report> listNext = reportService.getReportNext(ed.getDate());
                List<ReportJsonParse> ejpListPre = new ArrayList<>();
                List<ReportJsonParse> ejpListNext = new ArrayList<>();
                ejpListPre = list(ejpListPre, listPre);
                ejpListNext = list(ejpListNext, listNext);
                if (listPre.size() > 0) {
                    ejpListPre.get(0).setColor(widgetService.getReportDetailColor(listPre.get(0).getType()));
                }
                if (listNext.size() > 0) {
                    ejpListNext.get(0).setColor(widgetService.getReportDetailColor(listNext.get(0).getType()));
                }
                ejp.setReportPre(ejpListPre);
                ejp.setReportNext(ejpListNext);
                ejpList.add(ejp);
            }

            int type = 0;
            if (report.getType() == Constant.REPORT_TYPE.EVENT) {
                type = Constant.REPORT_TYPE.MOVEUP;
            } else if (report.getType() == Constant.REPORT_TYPE.MOVEUP) {
                type = Constant.REPORT_TYPE.EVENT;
            }

            EntryMail entryMail = entryService.getEntryMailByEntryIdAndType(report.getId(), type);
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

    private List<ReportJsonParse> list(List<ReportJsonParse> jpList, List<Report> list) {

        for (Report nd : list) {
            ReportJsonParse njp = new ReportJsonParse();
            njp.setUuid(nd.getUuid());
            njp.setTitle(nd.getTitle());
            njp.setDate(DateUtil.dateToStringyyyy_MM_dd(nd.getDate()));
            njp.setType(widgetService.getReportType(nd.getType()));
            njp.setColor(widgetService.getReportColor(nd.getType()));
            njp.setExcerpt(nd.getExcerpt());
            jpList.add(njp);
        }
        return jpList;
    }

    // Report detail for sns
    //eg:http://localhost:8081/moveup_war/sns/reportDetail/4hIZRgPJFu/
    @RequestMapping(value = "/sns/reportDetail/{uuid}/", method = RequestMethod.GET)
    public Object getReportSNSDetail(@PathVariable String uuid, Model model, HttpServletRequest hsr) {

        Report report = reportService.getReportByUuid(uuid);
        List<ReportDetail> reportDetailList = reportService.getReportDetailAll(report.getId());
        if (reportDetailList.size() > 0) {
            ReportDetail reportDetail = reportDetailList.get(0);

            model.addAttribute("title", reportDetail.getTitle());
            model.addAttribute("url", "https://www.japanmoveupwest.com" + "/reportDetail/" + report.getUuid() + "/");
            model.addAttribute("desc", report.getExcerpt());
            model.addAttribute("image", "");
        }

        String userAgent = hsr.getHeader("User-Agent");
        logger.debug("-------user-agent=" + userAgent);

        String regex = "facebookexternalhit|Facebot|Twitterbot|Pinterest|Google.*snippet";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(userAgent);
        if (m.find()) {
            logger.debug("-------tosns");
            return "sns";
        } else {
            logger.debug("-------tourl");
            return "redirect:" + hosturl + "/reportDetail/" + uuid + "/";
        }
    }

    // Report detail for sns
    //eg: http://localhost:8081/moveup_war/api/sns/reportDetail/app/4hIZRgPJFu/
    @RequestMapping(value = "/api/sns/reportDetail/app/{uuid}/", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject getReportDetailSNSForApp(@PathVariable String uuid) {

        Map<String, Object> urlMap = new HashMap<String, Object>();
        urlMap.put("twitter", "https://twitter.com/share?url=" + hosturl + "/reportDetail/" + uuid + "/");
        urlMap.put("facebook", "https://www.facebook.com/sharer/sharer.php?u=" + hosturl + "/reportDetail/" + uuid + "/");

        jsonObject.setResultList(urlMap);
        jsonObject.setStatus(JsonStatus.SUCCESS);
        return jsonObject;
    }
}