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

import com.entity.ZaizhikechengEntity;

import com.service.ZaizhikechengService;
import com.entity.view.ZaizhikechengView;
import com.service.JiangshiService;
import com.entity.JiangshiEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 在职培训课程
 * 后端接口
 * @author
 * @email
 * @date 2021-04-07
*/
@RestController
@Controller
@RequestMapping("/zaizhikecheng")
public class ZaizhikechengController {
    private static final Logger logger = LoggerFactory.getLogger(ZaizhikechengController.class);

    @Autowired
    private ZaizhikechengService zaizhikechengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private JiangshiService jiangshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "考生".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        if(StringUtil.isNotEmpty(role) && "公务员".equals(role)){
            params.put("gongwuyuanId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = zaizhikechengService.queryPage(params);

        //字典表数据转换
        List<ZaizhikechengView> list =(List<ZaizhikechengView>)page.getList();
        for(ZaizhikechengView c:list){
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
        ZaizhikechengEntity zaizhikecheng = zaizhikechengService.selectById(id);
        if(zaizhikecheng !=null){
            //entity转view
            ZaizhikechengView view = new ZaizhikechengView();
            BeanUtils.copyProperties( zaizhikecheng , view );//把实体数据重构到view中

            //级联表
            JiangshiEntity jiangshi = jiangshiService.selectById(zaizhikecheng.getJiangshiId());
            if(jiangshi != null){
                BeanUtils.copyProperties( jiangshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJiangshiId(jiangshi.getId());
            }
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
    public R save(@RequestBody ZaizhikechengEntity zaizhikecheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zaizhikecheng:{}",this.getClass().getName(),zaizhikecheng.toString());
        Wrapper<ZaizhikechengEntity> queryWrapper = new EntityWrapper<ZaizhikechengEntity>()
            .eq("zaizhikecheng_name", zaizhikecheng.getZaizhikechengName())
            .eq("zaizhikecheng_video", zaizhikecheng.getZaizhikechengVideo())
            .eq("zaizhikecheng_types", zaizhikecheng.getZaizhikechengTypes())
            .eq("zaizhikecheng_money", zaizhikecheng.getZaizhikechengMoney())
            .eq("jiangshi_id", zaizhikecheng.getJiangshiId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZaizhikechengEntity zaizhikechengEntity = zaizhikechengService.selectOne(queryWrapper);
        if(zaizhikechengEntity==null){
            zaizhikecheng.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      zaizhikecheng.set
        //  }
            zaizhikechengService.insert(zaizhikecheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZaizhikechengEntity zaizhikecheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zaizhikecheng:{}",this.getClass().getName(),zaizhikecheng.toString());
        //根据字段查询是否有相同数据
        Wrapper<ZaizhikechengEntity> queryWrapper = new EntityWrapper<ZaizhikechengEntity>()
            .notIn("id",zaizhikecheng.getId())
            .andNew()
            .eq("zaizhikecheng_name", zaizhikecheng.getZaizhikechengName())
            .eq("zaizhikecheng_video", zaizhikecheng.getZaizhikechengVideo())
            .eq("zaizhikecheng_types", zaizhikecheng.getZaizhikechengTypes())
            .eq("zaizhikecheng_money", zaizhikecheng.getZaizhikechengMoney())
            .eq("jiangshi_id", zaizhikecheng.getJiangshiId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZaizhikechengEntity zaizhikechengEntity = zaizhikechengService.selectOne(queryWrapper);
        if("".equals(zaizhikecheng.getZaizhikechengPhoto()) || "null".equals(zaizhikecheng.getZaizhikechengPhoto())){
                zaizhikecheng.setZaizhikechengPhoto(null);
        }
        if(zaizhikechengEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      zaizhikecheng.set
            //  }
            zaizhikechengService.updateById(zaizhikecheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zaizhikechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "考生".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = zaizhikechengService.queryPage(params);

        //字典表数据转换
        List<ZaizhikechengView> list =(List<ZaizhikechengView>)page.getList();
        for(ZaizhikechengView c:list){
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
        ZaizhikechengEntity zaizhikecheng = zaizhikechengService.selectById(id);
            if(zaizhikecheng !=null){
                //entity转view
        ZaizhikechengView view = new ZaizhikechengView();
                BeanUtils.copyProperties( zaizhikecheng , view );//把实体数据重构到view中

                //级联表
                    JiangshiEntity jiangshi = jiangshiService.selectById(zaizhikecheng.getJiangshiId());
                if(jiangshi != null){
                    BeanUtils.copyProperties( jiangshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiangshiId(jiangshi.getId());
                }
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
    public R add(@RequestBody ZaizhikechengEntity zaizhikecheng, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zaizhikecheng:{}",this.getClass().getName(),zaizhikecheng.toString());
        Wrapper<ZaizhikechengEntity> queryWrapper = new EntityWrapper<ZaizhikechengEntity>()
            .eq("zaizhikecheng_name", zaizhikecheng.getZaizhikechengName())
            .eq("zaizhikecheng_video", zaizhikecheng.getZaizhikechengVideo())
            .eq("zaizhikecheng_types", zaizhikecheng.getZaizhikechengTypes())
            .eq("zaizhikecheng_money", zaizhikecheng.getZaizhikechengMoney())
            .eq("jiangshi_id", zaizhikecheng.getJiangshiId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    ZaizhikechengEntity zaizhikechengEntity = zaizhikechengService.selectOne(queryWrapper);
        if(zaizhikechengEntity==null){
            zaizhikecheng.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      zaizhikecheng.set
        //  }
        zaizhikechengService.insert(zaizhikecheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}

