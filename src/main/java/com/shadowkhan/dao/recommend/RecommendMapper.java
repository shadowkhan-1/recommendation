package com.shadowkhan.dao.recommend;

import com.shadowkhan.dao.recommend.model.Recommend;
import com.shadowkhan.dao.recommend.model.RecommendEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendMapper {
    int countByEntity(RecommendEntity entity);

    int deleteByEntity(RecommendEntity entity);

    int deleteByPrimaryKey(Integer id);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    List<Recommend> selectByEntity(RecommendEntity entity);

    Recommend selectByPrimaryKey(Integer id);

    int updateByEntitySelective(@Param("record") Recommend record, @Param("entity") RecommendEntity entity);

    int updateByEntity(@Param("record") Recommend record, @Param("entity") RecommendEntity entity);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);
}