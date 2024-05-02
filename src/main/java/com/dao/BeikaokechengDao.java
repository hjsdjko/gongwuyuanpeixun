package com.dao;

import com.entity.BeikaokechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BeikaokechengView;

/**
 * 备考课程 Dao 接口
 *
 * @author 
 * @since 2021-04-07
 */
public interface BeikaokechengDao extends BaseMapper<BeikaokechengEntity> {

   List<BeikaokechengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
