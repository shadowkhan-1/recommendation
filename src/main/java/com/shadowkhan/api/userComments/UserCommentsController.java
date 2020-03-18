package com.shadowkhan.api.userComments;

import com.shadowkhan.api.BaseController;
import com.shadowkhan.core.model.R;
import com.shadowkhan.dao.userComments.model.UserComments;
import com.shadowkhan.dao.userComments.req.UserCommentsReq;
import com.shadowkhan.service.userComments.UserCommentsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * 用户评论
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@RestController
@RequestMapping("/userComments")
public class UserCommentsController extends BaseController {

    @Autowired
    private UserCommentsService userCommentsService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/{id}")
    public R<UserComments> findById(@PathVariable Integer id) {
        return R.data(userCommentsService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/batch/{ids}")
    public R<List<UserComments>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Integer.valueOf(id.trim()));
            }
            return R.data(userCommentsService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/create")
    public R create(UserCommentsReq req) {
        return R.data(userCommentsService.create(req));
    }

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer id) {
        userCommentsService.deleteById(id);
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
            userCommentsService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/update")
    public R updateById(UserCommentsReq req) {
        userCommentsService.updateById(req);
        return R.success();
    }

}