package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.GongwuyuanEntity;

import com.service.GongwuyuanService;
import com.entity.view.GongwuyuanView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 在职公务员
 * 后端接口
 * @author
 * @email
 * @date 2021-04-07
*/
@RestController
@Controller
@RequestMapping("/gongwuyuan")
public class GongwuyuanController {
    private static final Logger logger = LoggerFactory.getLogger(GongwuyuanController.class);

    @Autowired
    private GongwuyuanService gongwuyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "公务员".equals(role)){
            params.put("gongwuyuanId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = gongwuyuanService.queryPage(params);

        //字典表数据转换
        List<GongwuyuanView> list =(List<GongwuyuanView>)page.getList();
        for(GongwuyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongwuyuanEntity gongwuyuan = gongwuyuanService.selectById(id);
        if(gongwuyuan !=null){
            //entity转view
            GongwuyuanView view = new GongwuyuanView();
            BeanUtils.copyProperties( gongwuyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GongwuyuanEntity gongwuyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongwuyuan:{}",this.getClass().getName(),gongwuyuan.toString());
        Wrapper<GongwuyuanEntity> queryWrapper = new EntityWrapper<GongwuyuanEntity>()
            .eq("username", gongwuyuan.getUsername())
            .eq("password", gongwuyuan.getPassword())
            .eq("gongwuyuan_name", gongwuyuan.getGongwuyuanName())
            .eq("sex_types", gongwuyuan.getSexTypes())
            .eq("gongwuyuan_id_number", gongwuyuan.getGongwuyuanIdNumber())
            .eq("gongwuyuan_phone", gongwuyuan.getGongwuyuanPhone())
            .eq("gongwuyuan_types", gongwuyuan.getGongwuyuanTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongwuyuanEntity gongwuyuanEntity = gongwuyuanService.selectOne(queryWrapper);
        if(gongwuyuanEntity==null){
            gongwuyuan.setCreateTime(new Date());
            gongwuyuan.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      gongwuyuan.set
        //  }
            gongwuyuanService.insert(gongwuyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongwuyuanEntity gongwuyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongwuyuan:{}",this.getClass().getName(),gongwuyuan.toString());
        //根据字段查询是否有相同数据
        Wrapper<GongwuyuanEntity> queryWrapper = new EntityWrapper<GongwuyuanEntity>()
            .notIn("id",gongwuyuan.getId())
            .andNew()
            .eq("username", gongwuyuan.getUsername())
            .eq("gongwuyuan_name", gongwuyuan.getGongwuyuanName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongwuyuanEntity gongwuyuanEntity = gongwuyuanService.selectOne(queryWrapper);
        if("".equals(gongwuyuan.getGongwuyuanPhoto()) || "null".equals(gongwuyuan.getGongwuyuanPhoto())){
                gongwuyuan.setGongwuyuanPhoto(null);
        }
        if(gongwuyuanEntity==null){
            gongwuyuanService.updateById(gongwuyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        gongwuyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        GongwuyuanEntity gongwuyuan = gongwuyuanService.selectOne(new EntityWrapper<GongwuyuanEntity>().eq("username", username));
        if(gongwuyuan==null || !gongwuyuan.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        String token = tokenService.generateToken(gongwuyuan.getId(),username, "gongwuyuan", "公务员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","公务员");
        r.put("username",gongwuyuan.getGongwuyuanName());
        r.put("tableName","gongwuyuan");
        r.put("userId",gongwuyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody GongwuyuanEntity gongwuyuan){
    //    	ValidatorUtils.validateEntity(user);
        if(gongwuyuanService.selectOne(new EntityWrapper<GongwuyuanEntity>().eq("username", gongwuyuan.getUsername()).orNew().eq("gongwuyuan_phone",gongwuyuan.getGongwuyuanPhone()).orNew().eq("gongwuyuan_id_number",gongwuyuan.getGongwuyuanIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        gongwuyuanService.insert(gongwuyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        GongwuyuanEntity gongwuyuan = new GongwuyuanEntity();
        gongwuyuan.setPassword("123456");
        gongwuyuan.setId(id);
        gongwuyuanService.updateById(gongwuyuan);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrGongwuyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        GongwuyuanEntity gongwuyuan = gongwuyuanService.selectById(id);
        return R.ok().put("data", gongwuyuan);
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = gongwuyuanService.queryPage(params);

        //字典表数据转换
        List<GongwuyuanView> list =(List<GongwuyuanView>)page.getList();
        for(GongwuyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongwuyuanEntity gongwuyuan = gongwuyuanService.selectById(id);
            if(gongwuyuan !=null){
                //entity转view
        GongwuyuanView view = new GongwuyuanView();
                BeanUtils.copyProperties( gongwuyuan , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody GongwuyuanEntity gongwuyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,gongwuyuan:{}",this.getClass().getName(),gongwuyuan.toString());
        Wrapper<GongwuyuanEntity> queryWrapper = new EntityWrapper<GongwuyuanEntity>()
            .eq("username", gongwuyuan.getUsername())
            .eq("password", gongwuyuan.getPassword())
            .eq("gongwuyuan_name", gongwuyuan.getGongwuyuanName())
            .eq("sex_types", gongwuyuan.getSexTypes())
            .eq("gongwuyuan_id_number", gongwuyuan.getGongwuyuanIdNumber())
            .eq("gongwuyuan_phone", gongwuyuan.getGongwuyuanPhone())
            .eq("gongwuyuan_types", gongwuyuan.getGongwuyuanTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    GongwuyuanEntity gongwuyuanEntity = gongwuyuanService.selectOne(queryWrapper);
        if(gongwuyuanEntity==null){
            gongwuyuan.setCreateTime(new Date());
        gongwuyuan.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      gongwuyuan.set
        //  }
        gongwuyuanService.insert(gongwuyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }


}

