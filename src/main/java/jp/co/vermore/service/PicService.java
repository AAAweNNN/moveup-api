package jp.co.vermore.service;


import jp.co.vermore.common.Constant;
import jp.co.vermore.entity.Pic;
import jp.co.vermore.form.admin.NewsForm;
import jp.co.vermore.mapper.PicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * RiseService
 * Created by Wangyan.
 * <p>
 * DateTime: 2018/02/28 17:48
 * Copyright: sLab, Corp
 */
@Service
public class PicService {
    @Autowired
    private PicMapper picMapper;

    public List<Pic> getPic(Long itemId, Byte itemType) {
        List<Pic> list = picMapper.selectByPrimaryKey(itemId, itemType);
        return list;
    }

    public Long insertPic(Pic pic) {
        picMapper.insertSelective(pic);
        return pic.getId();
    }

    public List<Pic> getPicUrl(Long id) {
        List<Pic> picUrl = picMapper.getPicUrl(id);
        return picUrl;
    }

    public long insertPicUrl(Pic pic, long id) {
        Pic entity = new Pic();
        entity.setItemId(id);
        entity.setItemType(Constant.EVENT_PIC_TYPE.TEAM);
        entity.setPicUrl(pic.getPicUrl());
        entity.setCreateDatetime(new Date(System.currentTimeMillis()));
        entity.setUpdateDatetime(new Date(System.currentTimeMillis()));
        entity.setDelFlg(Boolean.FALSE);
        entity.setNote(Constant.EMPTY_STRING);
        picMapper.insertPicUrl(entity);
        return entity.getId();

    }

    public long insertShopPicUrl(String picUrl, long id) {
        Pic entity = new Pic();
        entity.setItemId(id);
        entity.setItemType(Constant.EVENT_PIC_TYPE.SHOP);
        entity.setPicUrl(picUrl);
        entity.setCreateDatetime(new Date(System.currentTimeMillis()));
        entity.setUpdateDatetime(new Date(System.currentTimeMillis()));
        entity.setDelFlg(Boolean.FALSE);
        entity.setNote(Constant.EMPTY_STRING);
        picMapper.insertPicUrl(entity);
        return entity.getId();
    }

    public long insertInfoPicUrl(String picUrl, long id) {
        Pic entity = new Pic();
        entity.setItemId(id);
        entity.setItemType(Constant.EVENT_PIC_TYPE.INFO);
        entity.setPicUrl(picUrl);
        entity.setCreateDatetime(new Date(System.currentTimeMillis()));
        entity.setUpdateDatetime(new Date(System.currentTimeMillis()));
        entity.setDelFlg(Boolean.FALSE);
        entity.setNote(Constant.EMPTY_STRING);
        picMapper.insertPicUrl(entity);
        return entity.getId();
    }

    public long insertPlacePicUrl(String picUrl, long id) {
        Pic entity = new Pic();
        entity.setItemId(id);
        entity.setItemType(Constant.EVENT_PIC_TYPE.PLACE);
        entity.setPicUrl(picUrl);
        entity.setCreateDatetime(new Date(System.currentTimeMillis()));
        entity.setUpdateDatetime(new Date(System.currentTimeMillis()));
        entity.setDelFlg(Boolean.FALSE);
        entity.setNote(Constant.EMPTY_STRING);
        picMapper.insertPicUrl(entity);
        return entity.getId();
    }

    public long insertRecruitPicUrl(String picUrl, long id) {
        Pic entity = new Pic();
        entity.setItemId(id);
        entity.setItemType(Constant.EVENT_PIC_TYPE.RECRUIT);
        entity.setPicUrl(picUrl);
        entity.setCreateDatetime(new Date(System.currentTimeMillis()));
        entity.setUpdateDatetime(new Date(System.currentTimeMillis()));
        entity.setDelFlg(Boolean.FALSE);
        entity.setNote(Constant.EMPTY_STRING);
        picMapper.insertPicUrl(entity);
        return entity.getId();
    }

    public long updateShopPicUrl(String picUrl, long shopId, long id) {
        Pic entity = new Pic();
        entity.setId(id);
        entity.setItemId(shopId);
        entity.setItemType(Constant.EVENT_PIC_TYPE.SHOP);
        entity.setPicUrl(picUrl);
        entity.setCreateDatetime(new Date(System.currentTimeMillis()));
        entity.setUpdateDatetime(new Date(System.currentTimeMillis()));
        entity.setDelFlg(Boolean.FALSE);
        entity.setNote(Constant.EMPTY_STRING);
        picMapper.updateShopPicUrl(entity);
        return entity.getId();
    }

    public long updateInfoPicUrl(String picUrl, long shopId, long id) {
        Pic entity = new Pic();
        entity.setId(id);
        entity.setItemId(shopId);
        entity.setItemType(Constant.EVENT_PIC_TYPE.INFO);
        entity.setPicUrl(picUrl);
        entity.setCreateDatetime(new Date(System.currentTimeMillis()));
        entity.setUpdateDatetime(new Date(System.currentTimeMillis()));
        entity.setDelFlg(Boolean.FALSE);
        entity.setNote(Constant.EMPTY_STRING);
        picMapper.updateShopPicUrl(entity);
        return entity.getId();
    }

    public long updatePlacePicUrl(String picUrl, long shopId, long id) {
        Pic entity = new Pic();
        entity.setId(id);
        entity.setItemId(shopId);
        entity.setItemType(Constant.EVENT_PIC_TYPE.PLACE);
        entity.setPicUrl(picUrl);
        entity.setCreateDatetime(new Date(System.currentTimeMillis()));
        entity.setUpdateDatetime(new Date(System.currentTimeMillis()));
        entity.setDelFlg(Boolean.FALSE);
        entity.setNote(Constant.EMPTY_STRING);
        picMapper.updateShopPicUrl(entity);
        return entity.getId();
    }

    public long updateRecruitPicUrl(String picUrl, long shopId, long id) {
        Pic entity = new Pic();
        entity.setId(id);
        entity.setItemId(shopId);
        entity.setItemType(Constant.EVENT_PIC_TYPE.RECRUIT);
        entity.setPicUrl(picUrl);
        entity.setCreateDatetime(new Date(System.currentTimeMillis()));
        entity.setUpdateDatetime(new Date(System.currentTimeMillis()));
        entity.setDelFlg(Boolean.FALSE);
        entity.setNote(Constant.EMPTY_STRING);
        picMapper.updateShopPicUrl(entity);
        return entity.getId();
    }

    public List<Pic> getTeam2020Url(Long id) {
        List<Pic> pic = picMapper.getTeam2020Url(id);
        return pic;
    }

    public Pic getStudioPicUrl(Long id, Byte type) {
        Pic picUrl = picMapper.getStudioPicUrl(id, type);
        return picUrl;
    }

    public List<Pic> getstudioNewsDetailPicUrl(Long id, Byte type) {
        List<Pic> picUrl = picMapper.getstudioNewsDetailPicUrl(id, type);
        return picUrl;
    }

    public List<Pic> getShopUrlList(Long id, int itemType) {
        List<Pic> list = picMapper.getShopUrlList(id, itemType);
        return list;
    }


    public int deleteStudioNewsPicUrl(NewsForm form) {
        Pic pic = new Pic();
        pic.setItemId(form.getId());
        pic.setDelFlg(Boolean.TRUE);
        int count = picMapper.deleteStudioNewsPicUrl(pic);
        System.out.println(count);
        return count;
    }

    public int deleteShopPicUrl(Long shopId, int type) {
        Pic pic = new Pic();
        pic.setItemId(shopId);
        pic.setItemType((byte) type);
        pic.setDelFlg(Boolean.TRUE);
        int count = picMapper.deleteShopPicUrl(pic);
        return count;
    }

    public int deleteNewsPicUrl(Long newsId, int type) {
        Pic pic = new Pic();
        pic.setItemId(newsId);
        pic.setItemType((byte) type);
        pic.setDelFlg(Boolean.TRUE);
        int count = picMapper.deleteNewsPicUrl(pic);
        return count;
    }

    /**
     * 20210317 楊追加
     *
     * @param newsId
     * @param type
     * @return
     */
    public int deleteReportPicUrl(Long newsId, int type) {
        Pic pic = new Pic();
        pic.setItemId(newsId);
        pic.setItemType((byte) type);
        pic.setDelFlg(Boolean.TRUE);
        int count = picMapper.deleteReportPicUrl(pic);
        return count;
    }

    public int deleteTeamPicUrl(Long newsId, int type) {
        Pic pic = new Pic();
        pic.setItemId(newsId);
        pic.setItemType((byte) type);
        pic.setDelFlg(Boolean.TRUE);
        int count = picMapper.deleteTeamPicUrl(pic);
        return count;
    }


    public Pic getStudioUrl(int id) {
        Pic pic = picMapper.getStudioUrl(id);
        return pic;
    }

    public List<Pic> getStudioUrlList(int id) {
        List<Pic> picList = picMapper.getStudioUrlList(id);
        return picList;
    }

    public List<Pic> selectPicById(Long id, int type) {
        List<Pic> picList = picMapper.selectPicById(id, type);
        return picList;
    }
}
