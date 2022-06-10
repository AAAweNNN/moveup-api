package jp.co.vermore.service;

import jp.co.vermore.common.Constant;
import jp.co.vermore.common.util.DateUtil;
import jp.co.vermore.common.util.StringUtil;
import jp.co.vermore.entity.Report;
import jp.co.vermore.entity.ReportDetail;
import jp.co.vermore.form.admin.ReportForm;
import jp.co.vermore.form.admin.ReportListForm;
import jp.co.vermore.mapper.ReportDetailMapper;
import jp.co.vermore.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * a
 * ReportService
 * Created by wubin.
 * <p>
 * DateTime: 2018/03/03 11:13
 * Copyright: sLab, Corp
 */

@Service

public class ReportService {

    @Autowired
    private ReportMapper reportMapper;

    public Report getReportByUuid(String uuid) {
        Report entity = reportMapper.getReportByUuid(uuid);
        return entity;
    }

    public List<Report> getReportAll() {
        List<Report> reportList = reportMapper.getReportAll();
        return reportList;
    }

    public List<Report> getReportAllForTop() {
        String nowMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
//        String now= DateUtil.dateToStringyyyy_MM_dd_HH_mm(new Date(System.currentTimeMillis()));
        List<Report> reportList = reportMapper.getReportAllForTop(nowMin, nextMin);
        return reportList;
    }

    public List<Report> getReportCategory(int type, int limit, int offset) {
        List<Report> reportList = reportMapper.getReportCategory(type, limit, offset);
        return reportList;
    }

    public List<Report> getReportPre(Date date) {
        String nowMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Report> report = reportMapper.getReportPre(date, nowMin, nextMin);
        return report;
    }

    public List<Report> getReportNext(Date date) {
        String nowMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Report> report = reportMapper.getReportNext(date, nowMin, nextMin);
        return report;
    }

    public List<Report> getReportAll(int type, int limit, int offset) {
        String nowMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Report> reportList = reportMapper.getReportJsonAll(type, nowMin, nextMin, limit, offset);
        return reportList;
    }

    public List<Report> getReportAllByType(int type) {
        String nowMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(0);
        String nextMin = DateUtil.getTimeByMinuteYyyy_MM_ddHHmm(1);
        List<Report> reportList = reportMapper.getReportJsonAllByType(type, nowMin, nextMin);
        return reportList;
    }

    public Report getReportByIdAndType(long id, int type) {
        Report report = reportMapper.getReportByIdAndType(id, type);
        return report;
    }

    public List<Report> getReportEventAll(int type1, int type2, int limit, int offset) {
        String today = DateUtil.getYyyyMMdd();
        String tomorrow = DateUtil.getTomorrow();
        List<Report> reportList = reportMapper.getReportEventAll(type1, type2, tomorrow, today, limit, offset);
        return reportList;
    }

    private List<Report> convertTo(List<Report> demoList) {
        List<Report> resultList = new LinkedList<Report>();
        for (Report entity : demoList) {
            resultList.add(entity);
        }
        return resultList;
    }

    @Autowired
    private ReportMapper addReportMapper;

    //TODO
    public long insertReport(ReportForm reportForm) {
        Report report = new Report();
        String uuid = "";
        int flagUuid = 0;
        int cntSelect = 0;
        while (flagUuid != 1 && cntSelect < 100) {
            uuid = StringUtil.getUuid();
            if (getReportByUuid(uuid) == null) {
                flagUuid = 1;
            }
            cntSelect++;
        }

        report.setUuid(uuid);
        String date = reportForm.getDate();
        report.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T", " ")));
        report.setTitle(reportForm.getTitle());
        report.setType(reportForm.getType());
        report.setSortScore(reportForm.getSortScore());
        report.setExcerpt(reportForm.getExcerpt());
        if (reportForm.getPublishStart() == null || "".equals(reportForm.getPublishStart())) {
            report.setPublishStart(DateUtil.getDefaultDate());
        } else {
            report.setPublishStart(DateUtil.stringToDateyyyy_MM_dd_HH_mm(reportForm.getPublishStart().replace("T", " ")));
        }
        if (reportForm.getPublishEnd() == null || "".equals(reportForm.getPublishEnd())) {
            report.setPublishEnd(DateUtil.getDefaultPublishEnd());
        } else {
            report.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd_HH_mm(reportForm.getPublishEnd().replace("T", " ")));
        }
        report.setCreateDatetime(new Date(System.currentTimeMillis()));
        report.setDelFlg(Boolean.FALSE);
        report.setNote(Constant.EMPTY_STRING);
        addReportMapper.insertReport(report);
        return report.getId();
    }

    public long insertStudioReport(ReportForm reportForm) {
        Report report = new Report();
        String uuid = "";
        int flagUuid = 0;
        int cntSelect = 0;
        while (flagUuid != 1 && cntSelect < 100) {
            uuid = StringUtil.getUuid();
            if (getReportByUuid(uuid) == null) {
                flagUuid = 1;
            }
            cntSelect++;
        }

        report.setUuid(uuid);
        String date = reportForm.getDate();
        report.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        report.setTitle(reportForm.getTitle());
        report.setType(reportForm.getType());
        report.setSortScore(reportForm.getSortScore());
        report.setExcerpt(reportForm.getExcerpt());
        if (reportForm.getPublishStart() == null || "".equals(reportForm.getPublishStart())) {
            report.setPublishStart(DateUtil.getDefaultDate());
        } else {
            report.setPublishStart(DateUtil.stringToDateyyyy_MM_dd(reportForm.getPublishStart()));
        }
        if (reportForm.getPublishEnd() == null || "".equals(reportForm.getPublishEnd())) {
            report.setPublishEnd(DateUtil.getDefaultPublishEnd());
        } else {
            report.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd(reportForm.getPublishEnd()));
        }
        report.setCreateDatetime(new Date(System.currentTimeMillis()));
        report.setDelFlg(Boolean.FALSE);
        report.setNote(Constant.EMPTY_STRING);
        addReportMapper.insertReport(report);
        return report.getId();
    }

    @Autowired
    private ReportDetailMapper reportDetailMapper;

    public long insertDetailReport(ReportForm reportForm, long reportId) {
        ReportDetail reportDetail = new ReportDetail();
        reportDetail.setReportId(reportId);
        String date = reportForm.getDate();
        reportDetail.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T", " ")));
        reportDetail.setTitle(reportForm.getTitle());
        reportDetail.setType(reportForm.getType());
        reportDetail.setDetail(reportForm.getDetail());
        reportDetail.setCreateDatetime(new Date(System.currentTimeMillis()));
        reportDetail.setDelFlg(Boolean.FALSE);
        reportDetail.setNote(Constant.EMPTY_STRING);
        reportDetailMapper.insertDetailReport(reportDetail);
        return reportDetail.getId();
    }

    public long insertDetailStudioReport(ReportForm reportForm, long reportId) {
        ReportDetail reportDetail = new ReportDetail();
        reportDetail.setReportId(reportId);
        String date = reportForm.getDate();
        reportDetail.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        reportDetail.setTitle(reportForm.getTitle());
        reportDetail.setType(reportForm.getType());
        reportDetail.setDetail(reportForm.getDetail());
        reportDetail.setCreateDatetime(new Date(System.currentTimeMillis()));
        reportDetail.setDelFlg(Boolean.FALSE);
        reportDetail.setNote(Constant.EMPTY_STRING);
        reportDetailMapper.insertDetailReport(reportDetail);
        return reportDetail.getId();
    }

    public int deleteReport(ReportForm reportForm) {
        Report report = new Report();
        report.setId(reportForm.getId());
        report.setDelFlg(Boolean.TRUE);
        int count = reportMapper.deleteReport(report);
        System.out.println(count);
        return count;
    }

    public int deleteDetailReport(ReportForm reportForm) {
        ReportDetail reportDetail = new ReportDetail();
        reportDetail.setReportId(reportForm.getId());
        reportDetail.setDelFlg(Boolean.TRUE);
        int count = reportDetailMapper.deleteDetailReport(reportDetail);
        return count;
    }

    public int updateReport(ReportForm reportForm) {
        Report report = new Report();
        report.setId(reportForm.getId());
        String date = reportForm.getDate();
        report.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T", " ")));
        report.setTitle(reportForm.getTitle());
        report.setType(reportForm.getType());
        report.setSortScore(reportForm.getSortScore());
        report.setExcerpt(reportForm.getExcerpt());
        if (reportForm.getPublishStart() == null || "".equals(reportForm.getPublishStart())) {
            report.setPublishStart(DateUtil.getDefaultDate());
        } else {
            report.setPublishStart(DateUtil.stringToDateyyyy_MM_dd_HH_mm(reportForm.getPublishStart().replace("T", " ")));
        }
        if (reportForm.getPublishEnd() == null || "".equals(reportForm.getPublishEnd())) {
            report.setPublishEnd(DateUtil.getDefaultPublishEnd());
        } else {
            report.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd_HH_mm(reportForm.getPublishEnd().replace("T", " ")));
        }
        report.setUpdateDatetime(new Date(System.currentTimeMillis()));
        report.setDelFlg(Boolean.FALSE);
        report.setNote(Constant.EMPTY_STRING);
        int count = reportMapper.updateReport(report);
        return count;
    }

    public int updateStudioReport(ReportForm reportForm) {
        Report report = new Report();
        report.setId(reportForm.getId());
        String date = reportForm.getDate();
        report.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        report.setTitle(reportForm.getTitle());
        report.setType(reportForm.getType());
        report.setSortScore(reportForm.getSortScore());
        report.setExcerpt(reportForm.getExcerpt());
        if (reportForm.getPublishStart() == null || "".equals(reportForm.getPublishStart())) {
            report.setPublishStart(DateUtil.getDefaultDate());
        } else {
            report.setPublishStart(DateUtil.stringToDateyyyy_MM_dd(reportForm.getPublishStart()));
        }
        if (reportForm.getPublishEnd() == null || "".equals(reportForm.getPublishEnd())) {
            report.setPublishEnd(DateUtil.getDefaultPublishEnd());
        } else {
            report.setPublishEnd(DateUtil.stringToDateyyyy_MM_dd(reportForm.getPublishEnd()));
        }
        report.setUpdateDatetime(new Date(System.currentTimeMillis()));
        report.setDelFlg(Boolean.FALSE);
        report.setNote(Constant.EMPTY_STRING);
        int count = reportMapper.updateReport(report);
        return count;
    }

    public int updateDetailReport(ReportForm reportForm) {
        ReportDetail reportDetail = new ReportDetail();
        reportDetail.setReportId(reportForm.getId());
        String date = reportForm.getDate();
        reportDetail.setDate(DateUtil.stringToDateyyyy_MM_dd_HH_mm(date.replace("T", " ")));
        reportDetail.setTitle(reportForm.getTitle());
        reportDetail.setType(reportForm.getType());
        reportDetail.setDetail(reportForm.getDetail());
        reportDetail.setUpdateDatetime(new Date(System.currentTimeMillis()));
        reportDetail.setDelFlg(Boolean.FALSE);
        reportDetail.setNote(Constant.EMPTY_STRING);
        int count = reportDetailMapper.updateDetailReport(reportDetail);
        return count;
    }

    public int updateDetailStudioReport(ReportForm reportForm) {
        ReportDetail reportDetail = new ReportDetail();
        reportDetail.setReportId(reportForm.getId());
        String date = reportForm.getDate();
        reportDetail.setDate(DateUtil.stringToDateyyyy_MM_dd(date));
        reportDetail.setTitle(reportForm.getTitle());
        reportDetail.setType(reportForm.getType());
        reportDetail.setDetail(reportForm.getDetail());
        reportDetail.setUpdateDatetime(new Date(System.currentTimeMillis()));
        reportDetail.setDelFlg(Boolean.FALSE);
        reportDetail.setNote(Constant.EMPTY_STRING);
        int count = reportDetailMapper.updateDetailReport(reportDetail);
        return count;
    }

    public List<Report> getReportList(long id) {
        List<Report> reportList = reportMapper.getReportList(id);
        return reportList;
    }

    public String getReportDetail(long id) {
        String detail = reportDetailMapper.getReportDetail(id);
        return detail;
    }

    public List<ReportDetail> getReportDetailAll(Long id) {
        List<ReportDetail> reportDetail = reportDetailMapper.getReportDetailAll(id);
        List<ReportDetail> resultList = convertToDetail(reportDetail);
        return resultList;
    }

    private List<ReportDetail> convertToDetail(List<ReportDetail> demoList) {
        List<ReportDetail> resultList = new LinkedList<ReportDetail>();
        for (ReportDetail entity : demoList) {
            resultList.add(entity);
        }
        return resultList;
    }

    public List<Report> getReportAllByCondition(ReportListForm form) {
        List<Report> report = reportMapper.getReportAllByCondition(form);
        return report;
    }

    public int getReportCountByCondition(ReportListForm form) {
        return reportMapper.getReportCountByCondition(form);
    }

    public int getReportCount() {
        return reportMapper.getReportCount();
    }

    public List<Report> getStudioReportALL(int type) {
        List<Report> report = reportMapper.getStudioReportALL(type);
        return report;
    }
}