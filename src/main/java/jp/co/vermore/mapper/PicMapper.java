package jp.co.vermore.mapper;

import jp.co.vermore.entity.Pic;

import java.util.List;

public interface PicMapper {

    int insertSelective(Pic record);

    List<Pic> selectByPrimaryKey(Long itemId, Byte itemType);

    int updateByPrimaryKeySelective(Pic record);

    List<Pic> getPicUrl(Long id);

    int deleteTeam2020Url(Pic pic);

    int deleteShopPicUrl(Pic pic);

    int deleteNewsPicUrl(Pic pic);

    int deleteTeamPicUrl(Pic pic);

    //20210317 楊追加
    int deleteReportPicUrl(Pic pic);

    int insertPicUrl(Pic entity);

    int updateShopPicUrl(Pic entity);

    List<Pic> getTeam2020Url(Long id);

    Pic getStudioPicUrl(Long id, Byte type);

    List<Pic> getstudioNewsDetailPicUrl(Long id, Byte type);

    int deleteStudioNewsPicUrl(Pic pic);

    Pic getStudioUrl(int id);

    List<Pic> getStudioUrlList(int id);

    List<Pic> getShopUrlList(long id, int itemType);

    List<Pic> selectPicById(Long id, int type);

}