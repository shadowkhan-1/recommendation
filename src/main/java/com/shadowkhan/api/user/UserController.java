package com.shadowkhan.api.user;

import com.shadowkhan.api.BaseController;
import com.shadowkhan.core.exception.BusinessException;
import com.shadowkhan.core.model.R;
import com.shadowkhan.dao.bxBooks.model.BxBooks;
import com.shadowkhan.dao.user.model.User;
import com.shadowkhan.dao.user.req.UserReq;
import com.shadowkhan.service.user.UserService;
import com.shadowkhan.unit.*;
import com.shadowkhan.unit.sendemail.IMailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;


/**
 * 用户
 * @author 懒猴子CG
 * @date 2020/02/20 13:45
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final java.util.UUID UUID = null;
    @Autowired
    private UserService userService;
    @Autowired
    private IMailService iMailService;

    @Autowired
    private RedisUtil redisUtil;

//    @Autowired  访问redis数据库
//    public StringRedisTemplate stringRedisTemplate;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/{id}")
    public R<User> findById(@PathVariable Integer id) {
        return R.data(userService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @GetMapping("/batch/{ids}")
    public R<List<User>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Integer.valueOf(id.trim()));
            }
            return R.data(userService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/create")
    public R create(UserReq req) {
        return R.data(userService.create(req));
    }

    /**
     * 根据ID删除
     * @author linwei
     * @date 2020/03/06
     */
    @CrossOrigin
    @GetMapping("/delete/{todo}/{modifyBy}/{userId}")
    public R deleteById(@PathVariable Integer userId,@PathVariable String modifyBy,@PathVariable String todo) {
        if(userId == null){
            return R.failure(new BusinessException("无效参数！"));
        }
        if(todo.equals("todelete")){
            UserReq userReq = new UserReq();
            userReq.setUserId(userId);
            userReq.setIsDeleted("1");
            userReq.setDeletedTime(System.currentTimeMillis());
            userReq.setModifyTime(System.currentTimeMillis());
            userReq.setModifyBy(modifyBy);
            userService.updateById(userReq);
            return R.success();
        }
        else if(todo.equals("rollback")){
            UserReq userReq = new UserReq();
            userReq.setUserId(userId);
            userReq.setIsDeleted("0");
            userReq.setModifyTime(System.currentTimeMillis());
            userReq.setModifyBy(modifyBy);
            userService.updateById(userReq);
            return R.success();
        }
        else return R.failure(new BusinessException("无效参数！"));
    }

    /**
     * 根据ID集删除
     * @author linwei
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
            userService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2020/02/20 13:45
     */
    @PostMapping("/update")
    public R updateById(UserReq req) {
        userService.updateById(req);
        return R.success();
    }
    /**
     * 用户登录
     * @author linwei
     */

    //@RequestBody是作用在形参列表上，
    // 用于将前台发送过来固定格式的数据【xml 格式或者 json等】封装为对应的 JavaBean 对象，
    // 封装时使用到的一个对象是系统默认配置的 HttpMessageConverter进行解析，然后封装到形参上。
    //CrossOrigin 可以用来跨域
    @CrossOrigin
    @PostMapping("/login")
    public R login(@RequestBody UserReq req) throws Exception {
        String password = MD5Util.md5Encode(req.getPassword());
        Map<String,Object> map = new HashMap<>();
        map.put("username",req.getUsername());
        map.put("isDeleted","0");
        User user = userService.findByUsername((HashMap) map);
        if(user==null){
            BusinessException e = new BusinessException("用户不存在!");
            return R.failure(e);
        }
        else if(password.equals(user.getPassword())){
            UserReq u = new UserReq();
            u.setUserId(user.getUserId());
            u.setLastestTime(System.currentTimeMillis());
            userService.updateById(u);
            Map<String ,Object> params = new HashMap<>();
            params.put("userid",user.getUserId());
            params.put("username",user.getUsername());
            params.put("name",user.getName());
            params.put("phone",user.getPhone());
            params.put("email",user.getEmail());
            params.put("rule",user.getRule());
            if(user.getLastestTime()==null){
                params.put("lasttestTime",user.getLastestTime());
            }
            else params.put("lastestTime", DateFormat.toDate(user.getLastestTime(),"yyyy-MM-dd HH:mm:ss"));
            return R.data(params);
        }
        else{
            BusinessException e = new BusinessException("用户名或密码错误!");
            return R.failure(e);
        }
    }
    /**
     * 用户注册
     * @author linwei
     * @date 2020-02-18
     */
    @CrossOrigin
    @PostMapping("/register")
    public R register(@RequestBody UserReq req) throws Exception {
        UserReq user = new UserReq();
        Map<String,Object> map = new HashMap<>();
        map.put("username",req.getUsername());
        map.put("isDeleted","0");
        if(userService.findByUsername((HashMap) map) == null){
            Integer user_id = Integer.valueOf(IdUtils.getPrimaryKey());
            long  timeNew =  System.currentTimeMillis(); //时间戳
            user.setUserId(user_id);
            user.setName(req.getName());
            user.setPhone(req.getPhone());
            user.setEmail(req.getEmail());
            user.setUsername(req.getUsername());
            user.setPassword(MD5Util.md5Encode(req.getPassword()));
            user.setCreateTime(timeNew);
            user.setCreateBy(req.getUsername());
            userService.create(user);
            return R.success();
        }
        else {
            BusinessException e = new BusinessException("用户名已存在!");
            return R.failure(e);
        }
    }


    /**
     * 获取验证码
     * @author linwei
     * @date 2020/02/23
     */
    @CrossOrigin
    @PostMapping("/getcode")
    public R getcode(@RequestBody UserReq req){
        Map<String,Object> map = new HashMap<>();
        map.put("username",req.getUsername());
        map.put("isDeleted","0");
        User user = userService.findByUsername((HashMap) map);
        if(user == null){
            BusinessException e = new BusinessException("用户名不存在!");
            return R.failure(e);
        }
        else if(user.getEmail().equals(req.getEmail())){
            String code = GetCode.getNumber();
            iMailService.sendSimpleMail(user.getEmail(),user.getUsername()+"的邮箱验证码","你的验证码为:"+code+"" +
                    "有效时60秒，请妥善保管，勿转发他人，以免信息泄漏!");
            redisUtil.set(user.getUsername(), code);
            return R.success();

        }
        else {
            BusinessException e = new BusinessException("邮箱错误!");
            return R.failure(e);
        }
    }

    /**
     * 更改密码
     * @author linwei
     * @date 2020/02/23
     */
    @CrossOrigin
    @PostMapping("/getpassword")
    public R getpassword(@RequestBody UserReq req) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("username",req.getUsername());
        map.put("isDeleted","0");
        User user = userService.findByUsername((HashMap) map);
        if(user==null){
            BusinessException e = new BusinessException("用户名不存在!");
            return R.failure(e);
        }
        else if(redisUtil.get(user.getUsername())==null){
            BusinessException e = new BusinessException("验证码过时!");
            return R.failure(e);
        }
        else if(req.getName().equals(redisUtil.get(user.getUsername()))){
            UserReq u = new UserReq();
            u.setUsername(req.getUsername());
            u.setUserId(user.getUserId());
            u.setPassword(MD5Util.md5Encode(req.getPassword()));
            userService.updateById(u);
            return R.success();
        }
        else {
            BusinessException e = new BusinessException("验证码错误!");
            return R.failure(e);
        }
    }

    /**
     * 管理员管理用户
     * @author linwei
     * @date 2020/03/02
     */
    @CrossOrigin
    @GetMapping("/getusers")
    public R getUsers(@RequestParam(name = "rule") String rule,@RequestParam(name="currentPage") String currentPage,@RequestParam(name="pagesize") String pagesize){
        if(rule!=null && rule.equals("1") || rule.equals("3")){
            Map<String, Object> map = new HashMap<>();
            map.put("first", Integer.valueOf(currentPage));
            map.put("second", Integer.valueOf(pagesize));
            return R.data(userService.findAll((HashMap) map));
        }
        else {
            BusinessException e = new BusinessException("没有权限!");
            return R.data(e);
        }

    }

    /**
     * 根据关键字搜索用户
     * @author linwei
     * @date 2020/03/04
     */
    @CrossOrigin
    @PostMapping("/search")
    public R search(@RequestBody Map<String,String> map){
        if(map == null && map.size() == 0){
            BusinessException e = new BusinessException("搜索值不为空!");
            return R.failure(e);
        }
        else {
            return R.data(userService.findByKeywords((HashMap) map));
        }
    }

    /**
     * 管理员修改用户信息
     * @author linwei
     * @date 2020/03/05
     */
    @CrossOrigin
    @PostMapping("/editusers")
    public R editUses(@RequestBody UserReq req){
        if(req == null){
            BusinessException e = new BusinessException("不为空");
            return R.failure(e);
        }
        else {
            UserReq userReq = new UserReq();
            BeanUtils.copyProperties(req,userReq);
            userReq.setModifyTime(System.currentTimeMillis());
            userService.updateById(userReq);
            return R.success();
        }
    }

    /**
     * 管理员添加用户
     * @author linwei
     * @date 2020/03/13
     */
    @CrossOrigin
    @PostMapping("/adduser")
    public R addUser(@RequestBody UserReq req) throws Exception {
        if(req == null){
            return R.failure(new BusinessException("无效参数！"));
        }
        else {
            Map<String,Object> map = new HashMap<>();
            map.put("username",req.getUsername());
            map.put("isDeleted","0");
            User user = userService.findByUsername((HashMap) map);
            if(user != null){
                return R.failure(new BusinessException("用户已存在!"));
            }
            else {
                UserReq userReq = new UserReq();
                BeanUtils.copyProperties(req, userReq);
                userReq.setCreateTime(System.currentTimeMillis());
                userReq.setPassword(MD5Util.md5Encode("123456"));
                userReq.setUserId(Integer.valueOf(IdUtils.getPrimaryKey()));
                userService.create(userReq);
                return R.success();
            }
        }
    }

    /**
     * 查询管理员
     * @author linwei
     * @date 2020/03/15
     */
    @CrossOrigin
    @GetMapping("/getsuper")
    public R getSuper(@RequestParam(name = "rule") String rule){
        if(rule!=null && rule.equals("3")){
            Map<String, Object> map = new HashMap<>();
            map.put("rule","1");
            return R.data(userService.findAll((HashMap) map));
        }
        else {
            BusinessException e = new BusinessException("没有权限!");
            return R.data(e);
        }
    }
}
