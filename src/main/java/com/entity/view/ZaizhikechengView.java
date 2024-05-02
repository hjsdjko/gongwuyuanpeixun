package com.entity.view;

import com.entity.ZaizhikechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 在职培训课程
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-07
 */
@TableName("zaizhikecheng")
public class ZaizhikechengView extends ZaizhikechengEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 课程类型的值
		*/
		private String zaizhikechengValue;



		//级联表 jiangshi
			/**
			* 讲师名称
			*/
			private String jiangshiName;
			/**
			* 讲师性别
			*/
			private Integer sexTypes;
				/**
				* 讲师性别的值
				*/
				private String sexValue;
			/**
			* 讲师头像
			*/
			private String jiangshiPhoto;
			/**
			* 讲师联系方式
			*/
			private String jiangshiPhone;
			/**
			* 讲师薪资
			*/
			private Double jiangshiMoney;
			/**
			* 讲师详情
			*/
			private String jiangshiContent;

	public ZaizhikechengView() {

	}

	public ZaizhikechengView(ZaizhikechengEntity zaizhikechengEntity) {
		try {
			BeanUtils.copyProperties(this, zaizhikechengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 课程类型的值
			*/
			public String getZaizhikechengValue() {
				return zaizhikechengValue;
			}
			/**
			* 设置： 课程类型的值
			*/
			public void setZaizhikechengValue(String zaizhikechengValue) {
				this.zaizhikechengValue = zaizhikechengValue;
			}












				//级联表的get和set jiangshi
					/**
					* 获取： 讲师名称
					*/
					public String getJiangshiName() {
						return jiangshiName;
					}
					/**
					* 设置： 讲师名称
					*/
					public void setJiangshiName(String jiangshiName) {
						this.jiangshiName = jiangshiName;
					}
					/**
					* 获取： 讲师性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 讲师性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
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
					/**
					* 获取： 讲师头像
					*/
					public String getJiangshiPhoto() {
						return jiangshiPhoto;
					}
					/**
					* 设置： 讲师头像
					*/
					public void setJiangshiPhoto(String jiangshiPhoto) {
						this.jiangshiPhoto = jiangshiPhoto;
					}
					/**
					* 获取： 讲师联系方式
					*/
					public String getJiangshiPhone() {
						return jiangshiPhone;
					}
					/**
					* 设置： 讲师联系方式
					*/
					public void setJiangshiPhone(String jiangshiPhone) {
						this.jiangshiPhone = jiangshiPhone;
					}
					/**
					* 获取： 讲师薪资
					*/
					public Double getJiangshiMoney() {
						return jiangshiMoney;
					}
					/**
					* 设置： 讲师薪资
					*/
					public void setJiangshiMoney(Double jiangshiMoney) {
						this.jiangshiMoney = jiangshiMoney;
					}
					/**
					* 获取： 讲师详情
					*/
					public String getJiangshiContent() {
						return jiangshiContent;
					}
					/**
					* 设置： 讲师详情
					*/
					public void setJiangshiContent(String jiangshiContent) {
						this.jiangshiContent = jiangshiContent;
					}










}
