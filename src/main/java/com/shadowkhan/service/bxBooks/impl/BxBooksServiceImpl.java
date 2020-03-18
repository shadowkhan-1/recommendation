package com.shadowkhan.service.bxBooks.impl;

import com.shadowkhan.dao.bxBooks.BxBooksMapper;
import com.shadowkhan.dao.bxBooks.model.BxBooks;
import com.shadowkhan.dao.bxBooks.model.BxBooksEntity;
import com.shadowkhan.dao.bxBooks.req.BxBooksReq;
import com.shadowkhan.service.bxBooks.BxBooksService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

import java.math.BigDecimal;

/**
 * 图书表业务实现
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@Service
public class BxBooksServiceImpl implements BxBooksService {

    @Autowired
    private BxBooksMapper bxBooksMapper;

    @Override
    public BxBooks findById(String id) {
        return bxBooksMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BxBooks> findByIds(List<String> ids) {
        BxBooksEntity bxBooksEntity = new BxBooksEntity();
        bxBooksEntity.createCriteria().andIsbnIn(ids);
        return bxBooksMapper.selectByEntity(bxBooksEntity);
    }

    @Override
    public String create(BxBooksReq req) {
        BxBooks bxBooks = new BxBooks();
        BeanUtils.copyProperties(req, bxBooks);
        bxBooksMapper.insertSelective(bxBooks);
        return bxBooks.getIsbn();
    }

    @Override
    public void deleteById(String id) {
        bxBooksMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        BxBooksEntity bxBooksEntity = new BxBooksEntity();
        bxBooksEntity.createCriteria().andIsbnIn(ids);
        bxBooksMapper.deleteByEntity(bxBooksEntity);
    }

    @Override
    public void updateById(BxBooksReq req) {
        BxBooks bxBooks = new BxBooks();
        BeanUtils.copyProperties(req, bxBooks);
        int result = bxBooksMapper.updateByPrimaryKeySelective(bxBooks);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }

    @Override
    public List<BxBooks> findAll(HashMap map) {
        return bxBooksMapper.selectAll(map);
    }

    @Override
    public List<BxBooks> findByKeyword(String keywords) {
        return bxBooksMapper.selectByKeys(keywords);
    }

    @Override
    public List<BxBooks> findBxBooks(BxBooksReq bxBooksReq) {
        BxBooksEntity bxBooksEntity = new BxBooksEntity();
        bxBooksEntity.createCriteria().andBookAuthorLike(bxBooksReq.getBookAuthor())
                .andBookTitleEqualTo(bxBooksReq.getBookTitle())
                .andisDeletedEqualTo(bxBooksReq.getIsDeleted())
                .andPublisherEqualTo(bxBooksReq.getPublisher());
        return bxBooksMapper.selectByEntity(bxBooksEntity);
    }
}
