package com.shadowkhan.api.recommend;

import com.shadowkhan.api.BaseController;
import com.shadowkhan.core.model.R;
import com.shadowkhan.dao.bxBooks.model.BxBooks;
import com.shadowkhan.dao.recommend.model.Recommend;
import com.shadowkhan.dao.recommend.req.RecommendReq;
import com.shadowkhan.service.bxBooks.BxBooksService;
import com.shadowkhan.service.recommend.RecommendService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * 图书推荐表
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@RestController
@RequestMapping("/recommend")
public class RecommendController extends BaseController {

    @Autowired
    private RecommendService recommendService;

    @Autowired
    private BxBooksService bxBooksService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/{id}")
    public R<Recommend> findById(@PathVariable Integer id) {
        return R.data(recommendService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/batch/{ids}")
    public R<List<Recommend>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Integer.valueOf(id.trim()));
            }
            return R.data(recommendService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/create")
    public R create(RecommendReq req) {
        return R.data(recommendService.create(req));
    }

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer id) {
        recommendService.deleteById(id);
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
            recommendService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/update")
    public R updateById(RecommendReq req) {
        recommendService.updateById(req);
        return R.success();
    }

    /**
     * 获取推荐书籍
     * @author linwei
     * @date 2020/03/17
     */
    @CrossOrigin
    @GetMapping("/getrecommend")
    public R getRecommend(@RequestParam(name = "userId") String userId){
        List<Integer> userIdlist = new ArrayList<>();
        userIdlist.add(Integer.valueOf(userId));
        List<Recommend> recommendList = recommendService.findByIds(userIdlist);
        List<BxBooks> bxBooksList = new ArrayList<>();
        for(Recommend recommend : recommendList){
            BxBooks bxBooks = bxBooksService.findById(recommend.getIsbn());
            if(bxBooks != null){
                bxBooksList.add(bxBooks);
            }
            else continue;
        }
        return R.data(bxBooksList);
    }

}
