package com.shadowkhan.api.bxBookRatings;

import com.shadowkhan.api.BaseController;
import com.shadowkhan.core.model.R;
import com.shadowkhan.dao.bxBookRatings.model.BxBookRatings;
import com.shadowkhan.dao.bxBookRatings.req.BxBookRatingsReq;
import com.shadowkhan.service.bxBookRatings.BxBookRatingsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * 评分表
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@RestController
@RequestMapping("/bxBookRatings")
public class BxBookRatingsController extends BaseController {

    @Autowired
    private BxBookRatingsService bxBookRatingsService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/{id}")
    public R<BxBookRatings> findById(@PathVariable Integer id) {
        return R.data(bxBookRatingsService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/batch/{ids}")
    public R<List<BxBookRatings>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Integer.valueOf(id.trim()));
            }
            return R.data(bxBookRatingsService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/create")
    public R create(BxBookRatingsReq req) {
        return R.data(bxBookRatingsService.create(req));
    }

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer id) {
        bxBookRatingsService.deleteById(id);
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
            bxBookRatingsService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/update")
    public R updateById(BxBookRatingsReq req) {
        bxBookRatingsService.updateById(req);
        return R.success();
    }

}