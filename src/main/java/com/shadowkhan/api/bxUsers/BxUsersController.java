package com.shadowkhan.api.bxUsers;

import com.shadowkhan.api.BaseController;
import com.shadowkhan.core.model.R;
import com.shadowkhan.dao.bxUsers.model.BxUsers;
import com.shadowkhan.dao.bxUsers.req.BxUsersReq;
import com.shadowkhan.service.bxUsers.BxUsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 用户表
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@RestController
@RequestMapping("/bxUsers")
public class BxUsersController extends BaseController {

    @Autowired
    private BxUsersService bxUsersService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/{id}")
    public R<BxUsers> findById(@PathVariable Integer id) {
        return R.data(bxUsersService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/batch/{ids}")
    public R<List<BxUsers>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Integer.valueOf(id.trim()));
            }
            return R.data(bxUsersService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/create")
    public R create(BxUsersReq req) {
        return R.data(bxUsersService.create(req));
    }

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer id) {
        bxUsersService.deleteById(id);
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
            bxUsersService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/update")
    public R updateById(BxUsersReq req) {
        bxUsersService.updateById(req);
        return R.success();
    }
}
