package com.shadowkhan.dao.bxUsers;

import com.shadowkhan.dao.bxUsers.model.BxUsers;
import com.shadowkhan.dao.bxUsers.model.BxUsersEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BxUsersMapper {
    int countByEntity(BxUsersEntity entity);

    int deleteByEntity(BxUsersEntity entity);

    int deleteByPrimaryKey(Integer id);

    int insert(BxUsers record);

    int insertSelective(BxUsers record);

    List<BxUsers> selectByEntity(BxUsersEntity entity);

    BxUsers selectByPrimaryKey(Integer id);

    int updateByEntitySelective(@Param("record") BxUsers record, @Param("entity") BxUsersEntity entity);

    int updateByEntity(@Param("record") BxUsers record, @Param("entity") BxUsersEntity entity);

    int updateByPrimaryKeySelective(BxUsers record);

    int updateByPrimaryKey(BxUsers record);
}