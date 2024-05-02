package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.*;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.view.ZaizhikechengOrderView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 在职培训课程预定
 * 后端接口
 * @author
 * @email
 * @date 2021-04-07
*/
@RestController
@Controller
@RequestMapping("/zaizhikechengOrder")
public class ZaizhikechengOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ZaizhikechengOrderController.class);

    @Autowired
    private ZaizhikechengOrderService zaizhikechengOrderService;

    @Autowired
    private GongwuyuanService gongwuyuanService;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ZaizhikechengService zaizhikechengService;


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
        PageUtils page = zaizhikechengOrderService.queryPage(params);

        //字典表数据转换
        List<ZaizhikechengOrderView> list =(List<ZaizhikechengOrderView>)page.getList();
        for(ZaizhikechengOrderView c:list){
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
        ZaizhikechengOrderEntity zaizhikechengOrder = zaizhikechengOrderService.selectById(id);
        if(zaizhikechengOrder !=null){
            //entity转view
            ZaizhikechengOrderView view = new ZaizhikechengOrderView();
            BeanUtils.copyProperties( zaizhikechengOrder , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(zaizhikechengOrder.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //级联表
            ZaizhikechengEntity zaizhikecheng = zaizhikechengService.selectById(zaizhikechengOrder.getZaizhikechengId());
            if(zaizhikecheng != null){
                BeanUtils.copyProperties( zaizhikecheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setZaizhikechengId(zaizhikecheng.getId());
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
    public R save(@RequestBody ZaizhikechengOrderEntity zaizhikechengOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zaizhikechengOrder:{}",this.getClass().getName(),zaizhikechengOrder.toString());
        if(!request.getSession().getAttribute("role").equals("公务员")){
            return R.error("只有公务员能预定这个课程哦");
        }
        ZaizhikechengEntity zaizhikecheng = zaizhikechengService.selectById(zaizhikechengOrder.getZaizhikechengId());
        if(zaizhikecheng == null){
            return R.error();
        }
        GongwuyuanEntity user = gongwuyuanService.selectById((Integer) request.getSession().getAttribute("userId"));
        if(user == null){
            return R.error();
        }
        if(user.getNewMoney() < zaizhikecheng.getZaizhikechengMoney()){
            return R.error("余额不足请充值后在预定");
        }
        Wrapper<ZaizhikechengOrderEntity> queryWrapper = new EntityWrapper<ZaizhikechengOrderEntity>()
                .eq("yonghu_id", zaizhikechengOrder.getYonghuId())
                .eq("zaizhikecheng_id",zaizhikechengOrder.getZaizhikechengId())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZaizhikechengOrderEntity zaizhikechengOrderEntity = zaizhikechengOrderService.selectOne(queryWrapper);
        if(zaizhikechengOrderEntity != null){
            return R.error("你已经预定过了");
        }
        zaizhikechengOrder.setInsertTime(new Date());
        zaizhikechengOrder.setCreateTime(new Date());
        boolean insert = zaizhikechengOrderService.insert(zaizhikechengOrder);
        if(insert){
            user.setNewMoney(user.getNewMoney() - zaizhikecheng.getZaizhikechengMoney());
            boolean b = gongwuyuanService.updateById(user);
            if(b){
                return R.ok();
            }
        }
        return R.error();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZaizhikechengOrderEntity zaizhikechengOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zaizhikechengOrder:{}",this.getClass().getName(),zaizhikechengOrder.toString());
        zaizhikechengOrderService.updateById(zaizhikechengOrder);//根据id更新
        return R.ok();
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zaizhikechengOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(!"考生".equals(role)) {
            if (StringUtil.isNotEmpty(role) && "公务员".equals(role)) {
                params.put("gongwuyuanId", request.getSession().getAttribute("userId"));
            }
            // 没有指定排序字段就默认id倒序
            if (StringUtil.isEmpty(String.valueOf(params.get("orderBy")))) {
                params.put("orderBy", "id");
            }
            PageUtils page = zaizhikechengOrderService.queryPage(params);

            //字典表数据转换
            List<ZaizhikechengOrderView> list = (List<ZaizhikechengOrderView>) page.getList();
            for (ZaizhikechengOrderView c : list) {
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(c);
            }
            return R.ok().put("data", page);
        }
        return R.error("没有数据");
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZaizhikechengOrderEntity zaizhikechengOrder = zaizhikechengOrderService.selectById(id);
            if(zaizhikechengOrder !=null){
                //entity转view
        ZaizhikechengOrderView view = new ZaizhikechengOrderView();
                BeanUtils.copyProperties( zaizhikechengOrder , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(zaizhikechengOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    ZaizhikechengEntity zaizhikecheng = zaizhikechengService.selectById(zaizhikechengOrder.getZaizhikechengId());
                if(zaizhikecheng != null){
                    BeanUtils.copyProperties( zaizhikecheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZaizhikechengId(zaizhikecheng.getId());
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
    public R add(@RequestBody ZaizhikechengOrderEntity zaizhikechengOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zaizhikechengOrder:{}",this.getClass().getName(),zaizhikechengOrder.toString());
        if(!request.getSession().getAttribute("role").equals("公务员")){
            return R.error("只有公务员能预定这个课程哦");
        }
        ZaizhikechengEntity zaizhikecheng = zaizhikechengService.selectById(zaizhikechengOrder.getZaizhikechengId());
        if(zaizhikecheng == null){
            return R.error();
        }
        GongwuyuanEntity user = gongwuyuanService.selectById((Integer) request.getSession().getAttribute("userId"));
        if(user == null){
            return R.error();
        }
        if(user.getNewMoney() < zaizhikecheng.getZaizhikechengMoney()){
            return R.error("余额不足请充值后在预定");
        }
        Wrapper<ZaizhikechengOrderEntity> queryWrapper = new EntityWrapper<ZaizhikechengOrderEntity>()
                .eq("yonghu_id", zaizhikechengOrder.getYonghuId())
                .eq("zaizhikecheng_id",zaizhikechengOrder.getZaizhikechengId())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZaizhikechengOrderEntity zaizhikechengOrderEntity = zaizhikechengOrderService.selectOne(queryWrapper);
        if(zaizhikechengOrderEntity != null){
            return R.error("你已经预定过了");
        }
        zaizhikechengOrder.setInsertTime(new Date());
        zaizhikechengOrder.setCreateTime(new Date());
        boolean insert = zaizhikechengOrderService.insert(zaizhikechengOrder);
        if(insert){
            user.setNewMoney(user.getNewMoney() - zaizhikecheng.getZaizhikechengMoney());
            boolean b = gongwuyuanService.updateById(user);
            if(b){
                return R.ok();
            }
        }
        return R.error();
    }


}

