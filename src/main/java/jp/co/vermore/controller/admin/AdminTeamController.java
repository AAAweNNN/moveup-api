package jp.co.vermore.controller.admin;

import jp.co.vermore.common.Constant;
import jp.co.vermore.common.DatatablesJsonObject;
import jp.co.vermore.common.mvc.BaseController;
import jp.co.vermore.common.util.DateUtil;
import jp.co.vermore.entity.EntryMail;
import jp.co.vermore.entity.Pic;
import jp.co.vermore.entity.Team;
import jp.co.vermore.form.admin.TeamForm;
import jp.co.vermore.form.admin.TeamListForm;
import jp.co.vermore.service.AWSService;
import jp.co.vermore.service.EntryService;
import jp.co.vermore.service.PicService;
import jp.co.vermore.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * ReportAdminController
 * Created by wubin.
 * <p>
 * DateTime: 2018/03/03 11:13
 * Copyright: sLab, Corp
 */
@Controller
public class AdminTeamController extends BaseController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private EntryService entryService;

    @Autowired
    private AWSService awsService;

    @Autowired
    private PicService picService;

    @Autowired
    PlatformTransactionManager txManager;

    @RequestMapping(value = "/admin/team/list/", method = RequestMethod.GET)
    public String teamAll(Model model, HttpServletRequest request) {

        int errorCode = 0;
        //TODO
        if (!request.getSession().isNew()) {
            if (request.getSession().getAttribute("error") != null && request.getSession().getAttribute("error") != "") {
                errorCode = (int) request.getSession().getAttribute("error");
                request.getSession().setAttribute("error", 0);
            }
        }
        model.addAttribute("errorCode", errorCode);

        List<Team> team = teamService.getTeamAll();
        TeamForm form = new TeamForm();
        model.addAttribute("teamDeleteForm", form);
        model.addAttribute("team_all", team);
        return "admin/teamList";
    }

    @RequestMapping(value = "/admin/team/list/", method = RequestMethod.POST)
    @ResponseBody
    public DatatablesJsonObject teamList(@RequestBody TeamListForm form) {
        BaseController.logger.debug("----1----");
        // set order statement
        if (form.getOrder().size() > 0
                && form.getColumns().get(form.getOrder().get(0).getColumn()).getName() != null
                && form.getColumns().get(form.getOrder().get(0).getColumn()).getName().length() > 0) {
            form.setOrderStatement(form.getColumns().get(form.getOrder().get(0).getColumn()).getName() + " " + form.getOrder().get(0).getDir());
            BaseController.logger.debug("----2----order statement=" + form.getOrderStatement());
        } else {
            form.setOrderStatement("id");
            BaseController.logger.debug("----2----order statement=" + form.getOrderStatement());
        }
        BaseController.logger.debug("----3----");

        // query data
        List<Team> dataList = teamService.getTeamAllByCondition(form);

        for (Team team : dataList) {
            int type = 0;
            //it's my faults
            if (team.getType() == Constant.TEAM_TYPE.EVENT) {
                type = Constant.TEAM_TYPE.MOVEUP;
            } else if (team.getType() == Constant.TEAM_TYPE.MOVEUP) {
                type = Constant.TEAM_TYPE.EVENT;
            }
            EntryMail entity = entryService.getEntryMailByEntryIdAndType(team.getId(), type);
            if (entity != null) {
                team.setEntryType(1);
            } else {
                team.setEntryType(0);
            }
        }

        int totalCountFiltered = teamService.getTeamCountByCondition(form);
        int totalCount = teamService.getTeamCount();
        BaseController.logger.debug("----4----data count=" + dataList.size());
        BaseController.logger.debug("----5----total filtered=" + totalCountFiltered);
        BaseController.logger.debug("----6----total count=" + totalCount);
        BaseController.logger.debug("----7----page=" + form.getDraw());

        // return json data
        DatatablesJsonObject jsonparse = new DatatablesJsonObject();
        jsonparse.setDraw(form.getDraw());
        jsonparse.setRecordsFiltered(totalCountFiltered);
        jsonparse.setRecordsTotal(totalCount);
        jsonparse.setData(dataList);
        BaseController.logger.debug("----8----");
        return jsonparse;
    }

    @RequestMapping(value = "/admin/team/regist/", method = RequestMethod.GET)
    public String teamInsert(Model model) {
        TeamForm form = new TeamForm();
        model.addAttribute("teamForm", form);
        return "admin/teamRegist";
    }

    @RequestMapping(value = "/admin/team/regist/", method = RequestMethod.POST)
    public String teamInsert(@ModelAttribute TeamForm form, HttpServletRequest request) {
        HttpSession session = request.getSession();
        // トランザクション管理の開始
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus txStatus = txManager.getTransaction(txDefinition);

        try {
            long teamId = teamService.insertTeam(form);
            teamService.insertDetailTeam(form, teamId);
            MultipartFile[] top = form.getPicFile1();
            MultipartFile[] foot = form.getPicFile2();

            if (!form.getPicFile1()[0].isEmpty()) {
                Pic topPic = new Pic();
                if (top.length > 0) {
                    for (int i = 0; i < top.length; i++) {
                        topPic.setPicUrl(awsService.postFile(top[i]));
                        topPic.setItemId(teamId);
                        topPic.setItemType(Constant.EVENT_PIC_TYPE.Team_TOP);
                        picService.insertPic(topPic);
                    }
                }
            }

            if (!form.getPicFile2()[0].isEmpty()) {
                Pic footPic = new Pic();
                if (foot.length > 0) {
                    for (int i = 0; i < foot.length; i++) {
                        footPic.setPicUrl(awsService.postFile(foot[i]));
                        footPic.setItemId(teamId);
                        footPic.setItemType(Constant.EVENT_PIC_TYPE.Team_FOOT);
                        picService.insertPic(footPic);
                    }
                }
            }

            txManager.commit(txStatus);
            session.setAttribute("error", 0);
        } catch (Exception e) {
            txManager.rollback(txStatus);
            session.setAttribute("error", 1);
            BaseController.logger.error("insert team failed!, error=" + e.getMessage());
            BaseController.logger.error("insert team failed!, error=" + e.toString());
            e.printStackTrace();
        }
        return "redirect:/admin/team/list/";
    }

    @RequestMapping(value = "/admin/team/delete/", method = RequestMethod.POST)
    public String teamDetailDelete(@ModelAttribute TeamForm form, HttpServletRequest request) {
        HttpSession session = request.getSession();
        // トランザクション管理の開始
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus txStatus = txManager.getTransaction(txDefinition);

        try {
            teamService.deleteTeam(form);
            teamService.deleteDetailTeam(form);
            picService.deleteTeamPicUrl(form.getId(), Constant.EVENT_PIC_TYPE.Team_TOP);
            picService.deleteTeamPicUrl(form.getId(), Constant.EVENT_PIC_TYPE.Team_FOOT);
            txManager.commit(txStatus);
            session.setAttribute("error", 0);
        } catch (Exception e) {
            txManager.rollback(txStatus);
            session.setAttribute("error", 1);
            BaseController.logger.error("delete team failed!, error=" + e.getMessage());
            BaseController.logger.error("delete team failed!, error=" + e.toString());
            e.printStackTrace();
        }
        return "redirect:/admin/team/list/";
    }

    @RequestMapping(value = "/admin/team/edit/{id}/", method = RequestMethod.GET)
    public String teamUpdate(Model model, @PathVariable long id) {
        TeamForm teamForm = new TeamForm();
        List<Team> list = teamService.getTeamList(id);
        String detail = teamService.getTeamDetail(id);

        List<Pic> topPicList = picService.getPic(id, Constant.EVENT_PIC_TYPE.Team_TOP);
        List<String> topList = new ArrayList<String>();
        for (Pic pic : topPicList) {
            topList.add(pic.getPicUrl());
        }

        List<Pic> footPicList = picService.getPic(id, Constant.EVENT_PIC_TYPE.Team_FOOT);
        List<String> footList = new ArrayList<String>();
        for (Pic pic : footPicList) {
            footList.add(pic.getPicUrl());
        }

        teamForm.setPicUrl1(topList);
        teamForm.setPicUrl2(footList);

        if (list != null && list.size() > 0) {
            teamForm.setId(list.get(0).getId());
            teamForm.setDetail(detail);
            teamForm.setTitle(list.get(0).getTitle());
            teamForm.setType(list.get(0).getType());
            teamForm.setExcerpt(list.get(0).getExcerpt());
            teamForm.setPublishStart(DateUtil.dateToStringyyyy_MM_dd_HH_mm(list.get(0).getPublishStart()));
            teamForm.setPublishEnd(DateUtil.dateToStringyyyy_MM_dd_HH_mm(list.get(0).getPublishEnd()));
            String date = DateUtil.dateToStringyyyy_MM_dd_HH_mm(list.get(0).getDate());

            teamForm.setDate(date);
            teamForm.setSortScore(list.get(0).getSortScore());

            model.addAttribute("teamForm", teamForm);
            return "admin/teamEdit";
        } else {
            return "redirect:/admin/team/list/";
        }
    }

    @RequestMapping(value = "/admin/team/update/", method = RequestMethod.POST)
    public String teamUpdate1(@ModelAttribute TeamForm form, HttpServletRequest request) {
        HttpSession session = request.getSession();
        // トランザクション管理の開始
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus txStatus = txManager.getTransaction(txDefinition);

        try {
            List<String> picUrl1 = form.getPicUrl1();
            teamService.updateTeam(form);
            teamService.updateDetailTeam(form);

            if (form.getPicUrl1().size() == 0 && form.getPicFile1()[0].isEmpty()) {
                picService.deleteTeamPicUrl(form.getId(), Constant.EVENT_PIC_TYPE.Team_TOP);
            }

            if (form.getPicUrl2().size() == 0 && form.getPicFile2()[0].isEmpty()) {
                picService.deleteReportPicUrl(form.getId(), Constant.EVENT_PIC_TYPE.REPORT_FOOT);
            }

            if (!form.getPicFile1()[0].isEmpty()) {
                picService.deleteReportPicUrl(form.getId(), Constant.EVENT_PIC_TYPE.Team_TOP);
                MultipartFile[] top = form.getPicFile1();
                Pic topPic = new Pic();
                if (top.length > 0) {
                    for (int i = 0; i < top.length; i++) {
                        topPic.setPicUrl(awsService.postFile(top[i]));
                        topPic.setItemId(form.getId());
                        topPic.setItemType(Constant.EVENT_PIC_TYPE.Team_TOP);
                        picService.insertPic(topPic);
                    }
                }
            }

            if (!form.getPicFile2()[0].isEmpty()) {
                picService.deleteTeamPicUrl(form.getId(), Constant.EVENT_PIC_TYPE.Team_FOOT);
                MultipartFile[] foot = form.getPicFile2();
                Pic footPic = new Pic();
                if (foot.length > 0) {
                    for (int i = 0; i < foot.length; i++) {
                        footPic.setPicUrl(awsService.postFile(foot[i]));
                        footPic.setItemId(form.getId());
                        footPic.setItemType(Constant.EVENT_PIC_TYPE.Team_FOOT);
                        picService.insertPic(footPic);
                    }
                }
            }

            txManager.commit(txStatus);
            session.setAttribute("error", 0);
        } catch (Exception e) {
            txManager.rollback(txStatus);
            session.setAttribute("error", 1);
            BaseController.logger.error("update team failed!, error=" + e.getMessage());
            BaseController.logger.error("update team failed!, error=" + e.toString());
            e.printStackTrace();
        }
        return "redirect:/admin/team/list/";
    }
}
