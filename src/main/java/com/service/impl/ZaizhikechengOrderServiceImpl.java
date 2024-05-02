package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.ZaizhikechengOrderDao;
import com.entity.ZaizhikechengOrderEntity;
import com.service.ZaizhikechengOrderService;
import com.entity.view.ZaizhikechengOrderView;

/**
 * 在职培训课程预定 服务实现类
 * @author 
 * @since 2021-04-07
 */
@Service("zaizhikechengOrderService")
@Transactional
public class ZaizhikechengOrderServiceImpl extends ServiceImpl<ZaizhikechengOrderDao, ZaizhikechengOrderEntity> implements ZaizhikechengOrderService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ZaizhikechengOrderView> page =new Query<ZaizhikechengOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
