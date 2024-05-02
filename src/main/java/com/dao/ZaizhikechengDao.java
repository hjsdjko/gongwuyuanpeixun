package com.dao;

import com.entity.ZaizhikechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaizhikechengView;

/**
 * 在职培训课程 Dao 接口
 *
 * @author 
 * @since 2021-04-07
 */
public interface ZaizhikechengDao extends BaseMapper<ZaizhikechengEntity> {

   List<ZaizhikechengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
