package com.shadowkhan.api.bxBooks;

import com.shadowkhan.api.BaseController;
import com.shadowkhan.core.exception.BusinessException;
import com.shadowkhan.core.model.R;
import com.shadowkhan.dao.bxBooks.model.BxBooks;
import com.shadowkhan.dao.bxBooks.req.BxBooksReq;
import com.shadowkhan.dao.userFavorite.model.UserFavorite;
import com.shadowkhan.service.bxBooks.BxBooksService;
import com.shadowkhan.service.userFavorite.UserFavoriteService;
import com.shadowkhan.unit.IdUtils;
import com.shadowkhan.unit.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 图书表
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@RestController
@RequestMapping("/bxBooks")
public class BxBooksController extends BaseController {

    @Autowired
    private BxBooksService bxBooksService;
    @Autowired
    private UserFavoriteService userFavoriteService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/{id}")
    public R<BxBooks> findById(@PathVariable String id) {
        return R.data(bxBooksService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/batch/{ids}")
    public R<List<BxBooks>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<String> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(id.trim());
            }
            return R.data(bxBooksService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/create")
    public R create(BxBooksReq req) {
        return R.data(bxBooksService.create(req));
    }

    /**
     * 根据ID删除
     * @author linwei
     * @date 2020/03/13
     */
    @CrossOrigin
    @GetMapping("/delete/{todo}/{modifyBy}/{isbn}")
    public R deleteById(@PathVariable String isbn,@PathVariable String modifyBy,@PathVariable String todo) {
        if(isbn == null){
            return R.failure(new BusinessException("无效参数!"));
        }
        if(todo.equals("todelete")){
            BxBooksReq bxBooksReq = new BxBooksReq();
            bxBooksReq.setIsbn(isbn);
            bxBooksReq.setIsDeleted("1");
            bxBooksReq.setDeletedTime(System.currentTimeMillis());
            bxBooksReq.setModifyTime(System.currentTimeMillis());
            bxBooksReq.setModifyBy(modifyBy);
            bxBooksService.updateById(bxBooksReq);
            return R.success();
        }
        else if(todo.equals("rollback")){
            BxBooksReq bxBooksReq = new BxBooksReq();
            bxBooksReq.setIsDeleted("0");
            bxBooksReq.setIsbn(isbn);
            bxBooksReq.setModifyTime(System.currentTimeMillis());
            bxBooksReq.setModifyBy(modifyBy);
            bxBooksService.updateById(bxBooksReq);
            return R.success();
        }
        else return R.failure(new BusinessException("无效参数!"));
    }

    /**
     * 根据ID集删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/delete/batch/{ids}")
    public R deleteByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<String> idList = new ArrayList<>();
            for (String id: idArray) {
              idList.add(id.trim());
            }
            bxBooksService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/update")
    public R updateById(BxBooksReq req) {
        bxBooksService.updateById(req);
        return R.success();
    }
    /**
     * 获取书籍
     * @author linwei
     * @date 2020/02/24
     */
    @CrossOrigin
    @GetMapping("/getbooks")
    public R getBook(@RequestParam(name = "rule") String rule, @RequestParam(name = "currentPage") String currentPage ,@RequestParam(name = "pagesize") String pagesize,@RequestParam(name = "userId") String userId ){
        Integer userid = Integer.valueOf(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("first",Integer.valueOf(currentPage));
        map.put("isDeleted","0");
        map.put("second",Integer.valueOf(pagesize));
        List<BxBooks> bxBooksList = bxBooksService.findAll((HashMap) map);
        List<Map<String, Object>> books = new ArrayList<>();
        List<UserFavorite> userFavoriteList = userFavoriteService.findByUserId(userid);
        for (BxBooks bxBooks : bxBooksList) {
            Map<String, Object> mapper = MapUtil.beanToMap(bxBooks);
            for (UserFavorite userFavorite : userFavoriteList) {
                if (bxBooks.getIsbn().equals(userFavorite.getIsbn())) {
                    mapper.put("favoriteState", true);
                    break;
                } else {
                    mapper.put("favoriteState", false);
                }
            }
            books.add(mapper);
        }
        return R.data(books);
    }

    /**
     * 搜索书籍
     * @author linwei
     * @date 2020/02/26
     */
    @CrossOrigin
    @PostMapping("/search")
    public R searchBook(@RequestBody Map<String,String> key){
        if(key==null || key.size()==0){
            BusinessException e = new BusinessException("搜索值不为空!");
            return R.failure(e);
        }
        else {
            List<Map<String, Object>> books = new ArrayList<>();
            List<BxBooks> bxBooksList = bxBooksService.findByKeyword(key.get("keywords"));
            List<UserFavorite> userFavoriteList = userFavoriteService.findByUserId(Integer.valueOf(key.get("userId")));
            for(BxBooks bxBooks : bxBooksList){
                Map<String, Object> mapper = MapUtil.beanToMap(bxBooks);
                for (UserFavorite userFavorite : userFavoriteList){
                    if(userFavorite.getIsbn().equals(bxBooks.getIsbn())){
                        mapper.put("favoriteState", true);
                        break;
                    }
                    else {
                        mapper.put("favoriteState", false);
                    }
                }
                books.add(mapper);
            }
            return R.data(books);
        }
    }
    /**
     * 管理员编辑书籍
     * @author linwei
     * @date 2020/03/11
     */
    @CrossOrigin
    @PostMapping("/editbooks")
    public R editBooks(@RequestBody BxBooksReq req){
        if(req == null){
            return R.failure(new BusinessException("不为空!"));
        }
        else {
            BxBooksReq bxBooksReq = new BxBooksReq();
            BeanUtils.copyProperties(req,bxBooksReq);
            bxBooksReq.setModifyTime(System.currentTimeMillis());
            bxBooksService.updateById(bxBooksReq);
            return R.success();
        }
    }

    /**
     * 管理员添加书籍
     * @author linwei
     * @date 2020/03/15
     */
    @CrossOrigin
    @PostMapping("/addbook")
    public R addBook(@RequestBody BxBooksReq req){
        if(req == null){
            return R.failure(new BusinessException("无效参数!"));
        }
        else {
            BxBooksReq bxBooksReq = new BxBooksReq();
            BeanUtils.copyProperties(req,bxBooksReq);
            bxBooksReq.setIsDeleted("0");
            List<BxBooks> bxBooksList = bxBooksService.findBxBooks(bxBooksReq);
            if(bxBooksList == null || bxBooksList.size() == 0){
                req.setIsbn(IdUtils.getPrimaryKey(8));
                req.setCreateTime(System.currentTimeMillis());
                bxBooksService.create(req);
                return R.success();
            }
            else {
                return R.failure(new BusinessException("图书已存在!"));
            }
        }
    }
}
