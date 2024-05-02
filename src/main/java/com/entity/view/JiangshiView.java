package com.entity.view;

import com.entity.JiangshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 讲师
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-07
 */
@TableName("jiangshi")
public class JiangshiView extends JiangshiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 讲师性别的值
		*/
		private String sexValue;



	public JiangshiView() {

	}

	public JiangshiView(JiangshiEntity jiangshiEntity) {
		try {
			BeanUtils.copyProperties(this, jiangshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 讲师性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 讲师性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}












}
