package com.dao;

import com.entity.GongwuyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GongwuyuanView;

/**
 * 在职公务员 Dao 接口
 *
 * @author 
 * @since 2021-04-07
 */
public interface GongwuyuanDao extends BaseMapper<GongwuyuanEntity> {

   List<GongwuyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
