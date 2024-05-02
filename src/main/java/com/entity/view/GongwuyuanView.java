package com.entity.view;

import com.entity.GongwuyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 在职公务员
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-07
 */
@TableName("gongwuyuan")
public class GongwuyuanView extends GongwuyuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 单位的值
		*/
		private String gongwuyuanValue;



	public GongwuyuanView() {

	}

	public GongwuyuanView(GongwuyuanEntity gongwuyuanEntity) {
		try {
			BeanUtils.copyProperties(this, gongwuyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}
			/**
			* 获取： 单位的值
			*/
			public String getGongwuyuanValue() {
				return gongwuyuanValue;
			}
			/**
			* 设置： 单位的值
			*/
			public void setGongwuyuanValue(String gongwuyuanValue) {
				this.gongwuyuanValue = gongwuyuanValue;
			}












}
