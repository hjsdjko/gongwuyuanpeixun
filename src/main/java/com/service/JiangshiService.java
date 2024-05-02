package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiangshiEntity;
import java.util.Map;

/**
 * 讲师 服务类
 * @author 
 * @since 2021-04-07
 */
public interface JiangshiService extends IService<JiangshiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}