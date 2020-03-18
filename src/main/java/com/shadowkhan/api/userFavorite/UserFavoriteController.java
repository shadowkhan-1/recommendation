package com.shadowkhan.api.userFavorite;

import com.shadowkhan.api.BaseController;
import com.shadowkhan.core.model.R;
import com.shadowkhan.dao.bxBooks.model.BxBooks;
import com.shadowkhan.dao.userFavorite.model.UserFavorite;
import com.shadowkhan.dao.userFavorite.req.UserFavoriteReq;
import com.shadowkhan.service.bxBooks.BxBooksService;
import com.shadowkhan.service.userFavorite.UserFavoriteService;
import com.shadowkhan.unit.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 用户收藏表
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@RestController
@RequestMapping("/userFavorite")
public class UserFavoriteController extends BaseController {

    @Autowired
    private UserFavoriteService userFavoriteService;
    @Autowired
    private BxBooksService bxBooksService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/{id}")
    public R<UserFavorite> findById(@PathVariable Integer id) {
        return R.data(userFavoriteService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/batch/{ids}")
    public R<List<UserFavorite>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Integer.valueOf(id.trim()));
            }
            return R.data(userFavoriteService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/create")
    public R create(UserFavoriteReq req) {
        return R.data(userFavoriteService.create(req));
    }

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer id) {
        userFavoriteService.deleteById(id);
        return R.success();
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
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
              idList.add(Integer.valueOf(id.trim()));
            }
            userFavoriteService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/update")
    public R updateById(UserFavoriteReq req) {
        userFavoriteService.updateById(req);
        return R.success();
    }

    /**
     * 搜索收藏的书籍
     * @author linwei
     * @date 2020/02/29
     */
    @CrossOrigin
    @GetMapping("/getfavorite")
    public R getFavorite(@RequestParam(name = "currentPage") String currentPage ,@RequestParam(name = "pagesize") String pagesize ,@RequestParam(name = "userId") String userId){
        Map<String,Object> map = new HashMap<>();
        map.put("first",Integer.valueOf(currentPage));
        map.put("second",Integer.valueOf(pagesize));
        map.put("userId",userId);
        map.put("isDeleted","0");
        List<UserFavorite> userFavoriteList = userFavoriteService.findAll((HashMap) map);
        List<Map<String,Object>> bxBooksList = new ArrayList<>();
        if(userFavoriteList == null || userFavoriteList.size() == 0){
            return R.success();
        }
        else {
            List<String> userids = userFavoriteList.stream().map(u -> u.getIsbn()).collect(Collectors.toList());
            List<BxBooks> booksList = bxBooksService.findByIds(userids);
            for(BxBooks bxBooks : booksList){
                Map<String,Object> mapper = MapUtil.beanToMap(bxBooks);
                mapper.put("favoriteState",true);
                bxBooksList.add(mapper);
            }
            return R.data(bxBooksList);
        }
    }
    /**
     * 添加收藏书籍
     * @author linwei
     * @date 2020/03/01
     */
    @CrossOrigin
    @PostMapping("/addfavorite")
    public R addFavorite(@RequestBody UserFavoriteReq req){
        UserFavoriteReq userFavoriteReq = new UserFavoriteReq();
        userFavoriteReq.setUserId(req.getUserId());
        userFavoriteReq.setIsbn(req.getIsbn());
        userFavoriteReq.setCreateTime(System.currentTimeMillis());
        userFavoriteReq.setIsDeleted("0");
        userFavoriteService.create(userFavoriteReq);
        return R.success();
    }

    /**
     * 移除收藏
     * @author linwei
     * @date 2020/03/01
     */
    @CrossOrigin
    @PostMapping("/removefavorite")
    public R removeFavorite(@RequestBody UserFavoriteReq req){
        UserFavoriteReq userFavoriteReq = req;
        userFavoriteReq.setIsDeleted("1");
        userFavoriteReq.setCreateTime(System.currentTimeMillis());
        userFavoriteService.updateById(userFavoriteReq);
        return R.success();
    }

}
