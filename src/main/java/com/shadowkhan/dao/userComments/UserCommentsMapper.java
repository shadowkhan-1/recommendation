package com.shadowkhan.dao.userComments;

import com.shadowkhan.dao.userComments.model.UserComments;
import com.shadowkhan.dao.userComments.model.UserCommentsEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCommentsMapper {
    int countByEntity(UserCommentsEntity entity);

    int deleteByEntity(UserCommentsEntity entity);

    int deleteByPrimaryKey(Integer id);

    int insert(UserComments record);

    int insertSelective(UserComments record);

    List<UserComments> selectByEntity(UserCommentsEntity entity);

    UserComments selectByPrimaryKey(Integer id);

    int updateByEntitySelective(@Param("record") UserComments record, @Param("entity") UserCommentsEntity entity);

    int updateByEntity(@Param("record") UserComments record, @Param("entity") UserCommentsEntity entity);

    int updateByPrimaryKeySelective(UserComments record);

    int updateByPrimaryKey(UserComments record);
}