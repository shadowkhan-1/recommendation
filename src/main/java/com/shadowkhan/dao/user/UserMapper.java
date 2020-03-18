package com.shadowkhan.dao.user;

import com.shadowkhan.dao.user.model.User;
import com.shadowkhan.dao.user.model.UserEntity;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByEntity(UserEntity entity);

    int deleteByEntity(UserEntity entity);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByEntity(UserEntity entity);

    User selectByPrimaryKey(Integer id);

    int updateByEntitySelective(@Param("record") User record, @Param("entity") UserEntity entity);

    int updateByEntity(@Param("record") User record, @Param("entity") UserEntity entity);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsername(HashMap map);

    List<User> selectAll(HashMap map);

    List<User> selectByKeys(HashMap map);
}
