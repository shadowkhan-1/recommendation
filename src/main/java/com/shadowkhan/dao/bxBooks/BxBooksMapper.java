package com.shadowkhan.dao.bxBooks;

import com.shadowkhan.dao.bxBooks.model.BxBooks;
import com.shadowkhan.dao.bxBooks.model.BxBooksEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BxBooksMapper {
    int countByEntity(BxBooksEntity entity);

    int deleteByEntity(BxBooksEntity entity);

    int deleteByPrimaryKey(String id);

    int insert(BxBooks record);

    int insertSelective(BxBooks record);

    List<BxBooks> selectByEntity(BxBooksEntity entity);

    BxBooks selectByPrimaryKey(String id);

    int updateByEntitySelective(@Param("record") BxBooks record, @Param("entity") BxBooksEntity entity);

    int updateByEntity(@Param("record") BxBooks record, @Param("entity") BxBooksEntity entity);

    int updateByPrimaryKeySelective(BxBooks record);

    int updateByPrimaryKey(BxBooks record);

    //搜索所有的书籍
    List<BxBooks> selectAll(HashMap map);

    //模糊搜索
    List<BxBooks> selectByKeys(String keywords);
}
