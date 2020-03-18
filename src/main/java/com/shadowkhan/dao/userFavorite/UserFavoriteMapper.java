package com.shadowkhan.dao.userFavorite;

import com.shadowkhan.dao.userFavorite.model.UserFavorite;
import com.shadowkhan.dao.userFavorite.model.UserFavoriteEntity;

import java.util.HashMap;
import java.util.List;

import com.shadowkhan.dao.userFavorite.req.UserFavoriteReq;
import org.apache.ibatis.annotations.Param;

public interface UserFavoriteMapper {
    int countByEntity(UserFavoriteEntity entity);

    int deleteByEntity(UserFavoriteEntity entity);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFavorite record);

    int insertSelective(UserFavorite record);

    List<UserFavorite> selectByEntitys(UserFavoriteEntity entity);

    UserFavorite selectByPrimaryKey(Integer id);

    int updateByEntitySelective(@Param("record") UserFavorite record, @Param("entity") UserFavoriteEntity entity);

    int updateByEntity(@Param("record") UserFavorite record, @Param("entity") UserFavoriteEntity entity);

    int updateByPrimaryKeySelective(UserFavorite record);

    int updateByPrimaryKey(UserFavorite record);
    //查找所有的收藏
    List<UserFavorite> selectAll(HashMap map);

    UserFavorite selectByEntity(UserFavoriteEntity entity);

    List<UserFavorite> selectByUserId(Integer userId);

}
