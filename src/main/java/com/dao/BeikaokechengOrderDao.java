package com.dao;

import com.entity.BeikaokechengOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BeikaokechengOrderView;

/**
 * 备考课程预定 Dao 接口
 *
 * @author 
 * @since 2021-04-07
 */
public interface BeikaokechengOrderDao extends BaseMapper<BeikaokechengOrderEntity> {

   List<BeikaokechengOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
