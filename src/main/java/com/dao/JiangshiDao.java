package com.dao;

import com.entity.JiangshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiangshiView;

/**
 * 讲师 Dao 接口
 *
 * @author 
 * @since 2021-04-07
 */
public interface JiangshiDao extends BaseMapper<JiangshiEntity> {

   List<JiangshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
