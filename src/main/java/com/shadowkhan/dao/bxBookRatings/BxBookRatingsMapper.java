package com.shadowkhan.dao.bxBookRatings;

import com.shadowkhan.dao.bxBookRatings.model.BxBookRatings;
import com.shadowkhan.dao.bxBookRatings.model.BxBookRatingsEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BxBookRatingsMapper {
    int countByEntity(BxBookRatingsEntity entity);

    int deleteByEntity(BxBookRatingsEntity entity);

    int deleteByPrimaryKey(Integer id);

    int insert(BxBookRatings record);

    int insertSelective(BxBookRatings record);

    List<BxBookRatings> selectByEntity(BxBookRatingsEntity entity);

    BxBookRatings selectByPrimaryKey(Integer id);

    int updateByEntitySelective(@Param("record") BxBookRatings record, @Param("entity") BxBookRatingsEntity entity);

    int updateByEntity(@Param("record") BxBookRatings record, @Param("entity") BxBookRatingsEntity entity);

    int updateByPrimaryKeySelective(BxBookRatings record);

    int updateByPrimaryKey(BxBookRatings record);
}